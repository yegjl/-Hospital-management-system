<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>日结核对</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="source/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="source/style/admin.css" media="all">
    <script src="source/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>

    <style>
        .layui-table-click {
            background-color: rgb(255, 255, 255) !important;
        }
    </style>
</head>

<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laydate'], function () {
        var laydate = layui.laydate;

        //开始
        var insStart = laydate.render({
            elem: '#test-laydate-start',
            type: 'datetime',
            done: function (value, date) {
                //更新结束日期的最小日期
                insEnd.config.min = lay.extend({}, date, {
                    month: date.month - 1
                });

                //自动弹出结束日期的选择器
                insEnd.config.elem[0].focus();
            }
        });

        var insEnd = laydate.render({
            elem: '#test-laydate-end',
            type: 'datetime',
            done: function (value, date) {
                //更新开始日期的最大日期
                insStart.config.max = lay.extend({}, date, {
                    month: date.month - 1
                });
            }
        });
    });
</script>
<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form'], function () {
        var $ = layui.$,
            admin = layui.admin,
            element = layui.element,
            form = layui.form;

        form.render(null, 'component-form-element');
        element.render('breadcrumb', 'breadcrumb');

        form.on('submit(component-form-element)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-toolbar',
            id: 'test-table-toolbar',
            url: 'settle/checklist',
            toolbar: '#test-table-toolbar-toolbarDemo',
            title: '用户数据表',
            method: 'get',
            parseData: function (res) {
                return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                }
            },
            cols: [
                [{
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                    field: 'id',
                    title: '编号',
                    width: 180,
                    fixed: 'left',
                    sort: true
                }, {
                    field: 'username',
                    title: '操作员',
                    width: 180
                }, {
                    field: 'start_date',
                    title: '开始日期',
                    width: 180
                }, {
                    field: 'end_date',
                    title: '截止日期',
                    width: 180
                }, {
                    field: 'expense',
                    title: '费用/元',
                    width: 180
                }, {
                    field: 'check_sign',
                    title: '核对状态',
                    templet:'#test-table-statusTpl',
                    width: 180
                }, {
                    field: 'check_date',
                    title: '核对日期',
                }]
            ],
            page: true
        });

        //头工具栏事件
        table.on('toolbar(test-table-toolbar)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                    var myArray = new Array();
                    for(var i = 0; i < tabledata.length; i++){
                        myArray.push(tabledata[i].id);
                    }
                    if(myArray.length > 1) {
                        alert("一次只能核对一条记录！");
                        return;
                    }
                    else if(myArray.length < 1) {
                        alert("请选择一条记录核对！");
                        return;
                    }

                    layer.open({
                        type: 1,
                        maxmin: true,
                        title: '核对',
                        area: ['400px', '450px'],
                        scrollbar: true,
                        content: '<iframe src="settle/checkUI" id="checkSettle" name="checkSettle" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['确定', '全部关闭'],
                        yes: function () {
                            var flag = document.getElementById("checkSettle").contentWindow.checkControll();
                            if(flag == false)
                                return;

                            var expense = window.frames["checkSettle"].document.getElementById('expense').value;
                            var date = window.frames["checkSettle"].document.getElementById('operationDate').value;
                            var check_sign = "1";
                            if(expense > tabledata[0].expense || expense < tabledata[0].expense) {
                                check_sign = "2";
                                alert("金额核对异常，请检查明细");
                            }

                            $.ajax({
                                type: "post",
                                url: "settle/check",
                                data: {
                                    "id": tabledata[0].id,
                                    "check_sign": check_sign,
                                    "check_date": date
                                },
                                dataType: "JSON",
                                async: false,
                                beforeSend: function () {
                                },
                                success: function (data) {
                                    if(data == 1 && check_sign == "2") {

                                    }
                                    else if(data == 1)
                                        alert("核对成功！");
                                    else
                                        alert("核对失败！");
                                    layer.closeAll();
                                },
                                error: function () {
                                    layer.closeAll();
                                }
                            });
                            layui.table.reload('test-table-toolbar',{page: {curr: 1}});
                        },
                        btn2: function () {
                            layer.closeAll();
                        }
                    });

                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test-table-toolbar)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {

                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.prompt({
                    formType: 2,
                    value: data.email
                }, function (value, index) {
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });

    });
</script>

<script>
    function getSelect() {
        var user_id = document.getElementById("userId").value.toUpperCase();
        var start = document.getElementById("test-laydate-start").value.toUpperCase();
        var end = document.getElementById("test-laydate-end").value.toUpperCase();

        $.ajax({
            type: "post",
            url: "settle/checkfind",
            data: {
                "user_id": user_id,
                "start_date": start,
                "end_date": end
            },
            dataType: "JSON",
            async: false,
            beforeSend: function () {
            },
            success: function () {
            },
            error: function () {
            }
        });
        layui.table.reload('test-table-toolbar',{page: {curr: 1}});
    }
    
    function getUser() {
        $.ajax({
            type: "POST",//方法类型
            url: "settle/getUserList" ,//url
            async: false,
            success: function (result) {
                if (result.status == 0) {
                    userList = result.data;
                    $("#userId").empty();
                    for(var i = 0; i < userList.length; i++){
                        $("#userId").append("<option value='" + userList[i].id + "'>" + userList[i].login_name + "</option>");
                    }
                };
            },
            error : function(result) {
                alert(result.msg);
            }
        });
    }

    function refresh() {
        $.ajax({
            type: "get",
            url: "settle/checkrefresh",
            success: function () {
                layui.table.reload('test-table-toolbar',{page: {curr: 1}});
            }
        });
    }
</script>

<body onload="getUser()">
<div class="layui-row">
    <div class="layui-fluid">
        <div class="layui-col-md12">
            <!-- 日期选择框 -->

            <div class="layui-card" style="height: 50px;">
                <div class="layui-form-item">
                    <form method="post">
                        <div class="layui-row">
                            <div class="layui-col-md3">

                                <div class="layui-card layui-form" lay-filter="component-form-element">
                                    <div style="width: 40%;float: left;margin-top: 2%;">
                                        <div class="layui-card-header" style="float: right;">
                                            选择收费员:
                                        </div>

                                    </div>

                                    <div style="float: right;width: 60%;margin-top: 2.5%;">
                                        <select name="city" id="userId" lay-verify="">
                                            <option value="">请选择收费员</option>
                                            <c:forEach items="${userList}" var="user">
                                                <option value="${user.id}">${user.login_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-col-md2">
                                <div style="width: 100%;float:right;margin-top: 3%;">
                                    <div class="layui-card-header" style="float: right">统计日期：</div>
                                </div>
                            </div>
                            <div class="layui-col-md5">
                                <div style="width: 100%;float:right;margin-top: 1.5%;">

                                    <div class="layui-input-inline">
                                        <input type="text" class="layui-input" id="test-laydate-start" autocomplete="off" placeholder="开始日期">
                                    </div>
                                    <div class="layui-form-mid">
                                        -
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" class="layui-input" id="test-laydate-end" autocomplete="off" placeholder="结束日期">
                                    </div>
                                    <input class="layui-btn" type="button" id="chaxun" value="查询" onclick="getSelect()" style="margin:auto;">
                                    <button class="layui-btn" onclick="refresh()">刷新</button>
                                </div>
                            </div>


                        </div>
                    </form>

                </div>

            </div>

        </div>

        <div class="layui-col-md12">
            <!-- <div class="layui-card-body">
                <div class="layui-card">
                    <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>

                    <script type="text/html" id="test-table-toolbar-toolbarDemo">
                        <div class="layui-btn-container">
                            <button class="layui-btn layui-btn-sm" lay-event="check">核对</button>

                        </div>
                    </script>


                </div>


            </div> -->

            <div class="layui-card">
                <div class="layui-card-body">
                    <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>
                    <script type="text/html" id="test-table-statusTpl">
                        {{#  if(d.check_sign == '未核对' || d.check_sign == '异常'){ }}
                        <span style="color: #FF0000;">{{ d.check_sign }}</span>
                        {{#  } else if(d.check_sign == '已核对') { }}
                        <span style="color: #05F936;">{{ d.check_sign }}</span>

                        {{#  } }}
                    </script>

                    <script type="text/html" id="test-table-toolbar-toolbarDemo">
                        <div class="layui-btn-container">
                            <button class="layui-btn layui-btn-sm" lay-event="getCheckData">核对</button>

                        </div>
                    </script>

                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>
