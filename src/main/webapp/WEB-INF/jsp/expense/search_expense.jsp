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
    <title>患者费用查询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/json3.js"></script>
</head>

<script>
    function getList() {
        var medical_record_no = document.getElementById("medical_record_no").value.toUpperCase();
        var start = document.getElementById("test-laydate-start").value.toUpperCase();
        var end = document.getElementById("test-laydate-end").value.toUpperCase();

        if(medical_record_no == "") {
            alert("病历号不能为空");
            return;
        }
        else if(start == "") {
            alert("开始日期不能为空");
            return;
        }
        else if(end == "") {
            alert("结束日期不能为空");
            return;
        }

        $.ajax({
            type: "post",
            url: "expense/search",
            data: {
                "medical_record_no": medical_record_no,
                "start": start,
                "end": end
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
        layui.table.reload('test-table-page',{page: {curr: 1}});
    }

    function refresh() {
        $.ajax({
            type: "get",
            url: "expense/searchRefresh",
            success: function () {
                layui.table.reload('test-table-page',{page: {curr: 1}});
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
            elem: '#test-table-page',
            id: 'test-table-page',
            url: 'expense/searchlist',
            toolbar: '#test-table-toolbar-toolbarDemo',
            title: '收费数据表',
            method: 'get',
            parseData: function (res) {
            return {
                "code":res.status,
                "msg":res.message,
                "count":res.total,
                "data":res.data
            }
        }
            ,initSort: {
                field: 'date'
                ,type: 'desc'
            }

            ,cols: [
            [{
                field: 'expense_name',
                title: '收费项名',
                width: 170,
                sort: true,
                fixed: true
            }, {
                field: 'expense_category',
                title: '收费类别',
                width: 100
            }, {
                field: 'specifications',
                title: '规格',
                width: 100
                // sort: true
            }, {
                field: 'unit_price',
                title: '单价',
                width: 100
            }, {
                field: 'number',
                title: '数量',
                width: 100
            }, {
                field: 'unit',
                title: '单位',
                width: 70
            }, {
                field: 'expense',
                title: '应付金额',
                width: 100
            }, {
                field: 'real_expense',
                title: '实付金额',
                width: 100
            }, {
                field: 'pay_category',
                title: '付款方式',
                width: 100
            }, {
                field: 'pay_sign',
                title: '付款标志',
                templet:'#test-table-statusTpl',
                width: 100
            }, {
                field: 'day_settle_sign',
                title: '日结状态',
                width: 90
            }, {
                field: 'date',
                title: '操作日期',
                sort: true
            }]
        ],
            height: 430,
            page: true
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

        //示例代码

        //开始
        var insStart = laydate.render({
            elem: '#test-laydate-start',
            showBottom: false,
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
            showBottom: false,
            done: function (value, date) {
                //更新开始日期的最大日期
                insStart.config.max = lay.extend({}, date, {
                    month: date.month - 1
                });
            }
        });


    });
</script>

<body>
<div class="layui-fluid">
    <!-- 日期选择框 -->
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <form>
                        <div class="layui-card-header">请选择查询时间区间</div>
                        <div class="layui-card-body" pad15>
                            <div class="layui-form" wid100>
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <div class="layui-input-inline">
                                            <input type="text" id="medical_record_no" class="layui-input" placeholder="请输入病历号" value="${medicalRecordNo}">
                                        </div>
                                        <label class="layui-form-label">日期范围</label>
                                        <div class="layui-input-inline">
                                            <input type="text" class="layui-input" id="test-laydate-start" autocomplete="off" placeholder="开始日期">
                                        </div>
                                        <div class="layui-form-mid">
                                            -
                                        </div>
                                        <div class="layui-input-inline">
                                            <input type="text" class="layui-input" id="test-laydate-end" autocomplete="off" placeholder="结束日期">
                                        </div>

<%--                                        <input class="layui-btn" type="button" value="查询" id="chaxun" onclick="getList()">--%>
                                        <a class="layui-btn" id="chaxun" onclick="getList()"><i class="layui-icon">&#xe615;</i>查询</a>
                                        <button class="layui-btn layui-btn-primary" type="reset" style="margin:auto;" id="clear" onclick="refresh()">重置</button>
<%--                                        <button class="layui-btn" id="refresh" onclick="refresh()">刷新</button>--%>

                                    </div>

                                </div>
                                <!-- 表格 -->
                                <table class="layui-hide" id="test-table-page" lay-filter="user"></table>

                                <script type="text/html" id="test-table-statusTpl">
                                    {{#  if(d.pay_sign === '未付款' || d.pay_sign === '已退费'){ }}
                                    <span style="color: #FF0000;">{{ d.pay_sign }}</span>
                                    {{#  } else if(d.pay_sign === '已付款' || d.pay_sign === '部分退款') { }}
                                    <span style="color: #05F936;">{{ d.pay_sign }}</span>

                                    {{#  } }}
                                </script>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>


</div>
</body>
</html>
