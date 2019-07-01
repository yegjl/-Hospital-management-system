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
    <title>收费员日结</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/json3.js"></script>

<%--    <style>--%>
<%--        .layui-table-click {--%>
<%--            background-color: rgb(255, 255, 255) !important;--%>
<%--        }--%>
<%--    </style>--%>
</head>

<script>
    function getLastDate() {
        $.ajax({
            type: "POST",//方法类型
            url: "settle/lastdate" ,//url
            async: false,
            success: function (result) {
                var opt = document.getElementById("start_date");
                opt.setAttribute("value", result);
            },
            error: function(result) {
            }
        });
    }

    function selectList() {
        var start = document.getElementById("test-laydate-start2").value.toUpperCase();
        var end = document.getElementById("test-laydate-end2").value.toUpperCase();
        dateControll(start, end);

        $.ajax({
            type: "post",
            url: "settle/select",
            data: {
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
        //window.location.reload();
        layui.table.reload('test-table-toolbar',{page: {curr: 1}});
    }

    function toSettle() {
        var start = document.getElementById("start_date").value.toUpperCase();
        var end = document.getElementById("test-laydate-end").value.toUpperCase();
        var flag = dateControll(start, end);
        if(flag == false)
            return;

        $.ajax({
            type: "post",
            url: "settle/settle",
            data: {
                "start_date": start,
                "end_date": end
            },
            dataType: "JSON",
            async: false,
            beforeSend: function () {
            },
            success: function (res) {
                if(res == 0.0)
                    alert("从" + start + "至" + end + "没有可结算金额");
                else {
                    var str = "结算成功，从" + start + "至" + end + "的收费金额合计为：" + res + "元";
                    alert(str);
                }
                layui.table.reload('test-table-radio',{page: {curr: 1}});
            },
            error: function () {
                alert("error");
            }
        });
    }

    function dateControll(date1, date2) {
        if(date1 == "") {
            alert("开始日期不能为空");
            return false;
        }
        if(date2 == "") {
            alert("截止日期不能为空");
            return false;
        }
        var oDate1 = new Date(date1);
        var oDate2 = new Date(date2);
        if(oDate1.getTime() > oDate2.getTime()) {
            alert("输入错误：截止日期不能早于开始日期");
            return false;
        }
        else
            return true;
    }

    function refresh() {
        $.ajax({
            type: "get",
            url: "settle/refresh",
            success: function () {
                layui.table.reload('test-table-toolbar',{page: {curr: 1}});
            }
        });
    }
</script>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-toolbar',
            id: 'test-table-toolbar',
            url: 'settle/list',
            toolbar: '#test-table-toolbar-toolbarDemo',
            title: '日结单数据表',
            method: 'get',
            parseData: function (res) {
            return {
                "code":res.status,
                "msg":res.message,
                "count":res.total,
                "data":res.data
            }
        },
            cols: [[
                // {type: 'radio', fixed: 'left'},
                {
                    field: 'id',
                    title: '编号',
                    width: 90,
                    sort: true
                }, {
                    field: 'username',
                    title: '操作员',
                    width: 120

                }, {
                    field: 'start_date',
                    title: '开始日期',
                    width: 230
                }, {
                    field: 'end_date',
                    title: '截止日期',
                    width: 230
                }, {
                    field: 'expense',
                    title: '结算金额/元',
                    width: 130
                }, {
                    fixed: 'right',
                    title: '操作',
                    toolbar: '#test-table-toolbar-barDemo',
                }]
            ],
            page: true
        });


        //头工具栏事件
        table.on('toolbar(test-table-toolbar)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;
            };
        });

        //监听行工具事件，详细弹窗模块
        table.on('tool(test-table-toolbar)', function (obj) {
            var data = obj.data;
            var opt1 = document.getElementById("sdate");
            opt1.setAttribute("value", data.start_date);
            var opt2 = document.getElementById("edate");
            opt2.setAttribute("value", data.end_date);

            if (obj.event === 'detail') {
                layer.open({
                    type: 2,
                    title: '详细',
                    area: ['1000px', '600px'],
                    scrollbar: true,
                    content: 'settle/detailUI',
                    btn: ['关闭'],
                    yes: function () {
                        layer.closeAll();
                    },
                    success: function(layero, index) {
                        // var body = layer.getChildFrame('body', index);
                        // body.find('#sdate').val(data.start_date);
                        // body.find('#edate').val(data.end_date);
                    }
                });
            }
        });

    });
</script>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-radio',
            url: 'settle/user',
            method: 'get',
            parseData: function (res) {
                return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                }
            },
            page: {
                layout: ['prev', 'page', 'next', 'count'],
                groups: 1 //只显示 1 个连续页码
                ,
                first: false //不显示首页
                ,
                last: false //不显示尾页

            },
            cols: [
                [{
                    field: 'username',
                    width: "40%",
                    title: '收费员',
                    sort: true
                }, {
                    field: 'end_date',
                    title: '最后结算日期'
                }]
            ],
        });

        //头工具栏事件
        table.on('toolbar(test-table-radio)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data; //获取选中行数据
                    layer.alert(JSON.stringify(data));
                    break;
            };
        });

    });
</script>
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
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

        var insStart = laydate.render({
            elem: '#test-laydate-start2',
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
            elem: '#test-laydate-end2',
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

<body onload="getLastDate()">
<div class="layui-row">
    <div class="layui-fluid">
        <form method="post">
            <input type="hidden" name="sdate" id="sdate">
            <input type="hidden" name="edate" id="edate">
            <div class="layui-col-md12">
                <!-- 日期选择框 -->
                <div class="layui-card" style="height: 50px;">
                    <div class="layui-form-item">
                        <div class="layui-row">
                            <div class="layui-col-md1">
                                <div style="width: 100%;float:right;margin-top: 1.5%;">
                                    <div class="layui-card-header">请选择结算时间区间</div>
                                </div>
                            </div>
                            <div class="layui-col-md5">
                                <div style="width: 100%;float:right;margin-top: 1.5%;">

                                    <div class="layui-input-inline">
                                        <input type="text" class="layui-input" id="start_date"
                                               placeholder="开始日期" disabled>
                                    </div>
                                    <div class="layui-form-mid">
                                        -
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" class="layui-input" id="test-laydate-end" autocomplete="off" placeholder="结束日期">
                                    </div>
<%--                                    <input class="layui-btn" type="button" value="结算" id="settle" onclick="toSettle()">--%>
                                    <a class="layui-btn layui-btn-normal" id="settle" onclick="toSettle()"><i class="layui-icon">&#xe605;</i>结算</a>
                                </div>
                            </div>
                            <div class="layui-col-md6">
                                <div style="width: 100%;float:left;margin-top: 1.5%;">
                                    <div class="layui-input-inline" style="float: left;">
                                        <input type="text" class="layui-input" id="test-laydate-start2" autocomplete="off"
                                               placeholder="开始日期">
                                    </div>
                                    <div class="layui-form-mid">
                                        -
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" class="layui-input" id="test-laydate-end2" autocomplete="off"
                                               placeholder="结束日期">
                                    </div>
<%--                                    <button class="layui-btn" style="margin:auto;" onclick="select()">查询</button>--%>
<%--                                    <input class="layui-btn" type="button" value="查询" id="chaxun" onclick="selectList()">--%>
                                    <a class="layui-btn" id="chaxun" onclick="selectList()"><i class="layui-icon">&#xe615;</i>查询</a>
                                    <button class="layui-btn layui-bg-cyan" style="margin:auto;" onclick="refresh()"><i class="layui-icon">&#xe669;</i>刷新</button>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>

            </div>
        </form>


        <div class="layui-col-md9">

            <div style="width: 100%">
                <div class="layui-card">

                    <div class="layui-card-body">
                        <hr class="layui-bg-green">

                        <p style="font-weight: 800">日结明细</p>
                    </div>
                    <hr class="layui-bg-green">
                    <div class="layui-col-md12">
                        <div class="layui-card">

                            <div class="layui-card-body">
                                <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar">
                                </table>

                                <script type="text/html" id="test-table-toolbar-barDemo">
                                    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="detail">详细</a>
                                    <input type="hidden" name="info" id="info">
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-md3">
            <div style="width: 100%">
                <div class="layui-card">

                    <div class="layui-card-body">
                        <hr class="layui-bg-green">
                        <p style="font-weight: 800">日结信息列表</p>

                    </div>
                    <hr class="layui-bg-green">
                    <div class="layui-col-md12">
                        <div class="layui-card">
                            <div class="layui-card-body">
                                <table class="layui-hide" id="test-table-radio" lay-filter="test-table-radio">
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
