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
    <title>日结明细</title>
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
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;
        getParent();

        table.render({
            elem: '#test-table-simple1',
            id: 'test-table-simple1',
            title: '收费清单',
            url: 'settle/findexpense',
            cellMinWidth: 80,
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
                    field: 'id',
                    width: 80,
                    title: '编号',
                    sort: true
                }, {
                    field: 'medical_record_no',
                    width: 80,
                    title: '病历号',
                    width: 150
                }, {
                    field: 'name',
                    width: 80,
                    title: '姓名',
                    // sort: true
                }, {
                    field: 'expense_name',
                    width: 120,
                    title: '收费项名'
                }, {
                    field: 'expense_category',
                    title: '收费类别',
                    // sort: true
                }, {
                    field: 'pay_category',
                    title: '付款方式',
                    width: 100
                }, {
                    field: 'expense',
                    title: '金额/元',
                    // sort: true
                }, {
                    field: 'pay_sign',
                    title: '状态',
                    templet:'#test-table-statusTpl',
                    width: 100
                }, {
                    field: 'date',
                    title: '操作日期'
                }]
            ]
            ,page: true
            ,done: function () {
                //getParent();
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
        var table = layui.table;
        getParent();

        table.render({
            elem: '#test-table-simple2',
            id: 'test-table-simple2',
            title: '退费清单',
            url: 'settle/findrefund',
            cellMinWidth: 80,
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
                    field: 'id',
                    width: 80,
                    title: '编号',
                    sort: true
                }, {
                    field: 'medical_record_no',
                    width: 80,
                    title: '病历号',
                    width: 150,
                }, {
                    field: 'name',
                    width: 80,
                    title: '姓名',
                    // sort: true
                }, {
                    field: 'expense_name',
                    width: 120,
                    title: '收费项名'
                }, {
                    field: 'expense_category',
                    title: '收费类别',
                    width: 100
                }, {
                    field: 'pay_category',
                    title: '付款方式',
                    width: 150
                }, {
                    field: 'refund_expense',
                    title: '金额/元',
                    // sort: true
                }, {
                    field: 'date',
                    title: '操作日期'
                }]
            ]
            ,page: true
            ,done: function () {
                //getParent();
            }
        });
    });
</script>


<script>
    function getParent() {
        var start = $('#sdate', parent.document).val();
        var end = $('#edate', parent.document).val();
        while(start == null || end == null) {
            start = $('#sdate', parent.document).val();
            end = $('#edate', parent.document).val();
        }

        $.ajax({
            type: "post",
            url: "settle/find",
            data: {
                "start_date": start,
                "end_date": end
            },
            dataType: "JSON",
            async: false,
            beforeSend: function () {
            },
            success: function () {
                layui.table.reload('test-table-simple1',{page: {curr: 1}});
                layui.table.reload('test-table-simple2',{page: {curr: 1}});
            },
            error: function () {
            }
        });
    }
</script>

<body>
<div class="layui-fluid">
    <form>
        <input type="hidden" name="sdate" id="sdate">
        <input type="hidden" name="edate" id="edate">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <!-- <div class="layui-card-header">详细</div> -->
                    <div class="layui-card-body">
                        <div class="layui-card-header"><h3>收费清单</h3></div>
                        <table class="layui-hide" id="test-table-simple1"></table>
<%--                        <button onclick="getParent()">111</button>--%>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-card-header"><h3>退费清单</h3></div>
                        <table class="layui-hide" id="test-table-simple2"></table>
                        <%--                        <button onclick="getParent()">111</button>--%>
                    </div>
                    <script type="text/html" id="test-table-statusTpl">
                        {{#  if(d.pay_sign == '未付款' || d.pay_sign == '已退款'){ }}
                        <span style="color: #FF0000;">{{ d.pay_sign }}</span>
                        {{#  } else if(d.pay_sign == '已付款' || d.pay_sign == '部分退款') { }}
                        <span style="color: #05F936;">{{ d.pay_sign }}</span>

                        {{#  } }}
                    </script>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
