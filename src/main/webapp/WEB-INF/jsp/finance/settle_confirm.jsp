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
    <title>日结核对明细</title>
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
    function getParent() {
        var table1 = parent.layui.table;
        var tabledata = table1.checkStatus('test-table-toolbar').data;

        var user = tabledata[0].username;
        var start = tabledata[0].start_date;
        var end = tabledata[0].end_date;

        var opt1 = document.getElementById("username");
        var opt2 = document.getElementById("test-laydate-type-datetime1");
        var opt3 = document.getElementById("test-laydate-type-datetime2");

        opt1.setAttribute("value", user);
        opt2.setAttribute("value", start);
        opt3.setAttribute("value", end);
    }

    function getTime() {
        var date = new Date();
        var seperator1 = "-";//设置成自己想要的日期格式 年/月/日
        var seperator2 = ":";//设置成自己想要的时间格式 时:分:秒
        var month = date.getMonth() + 1;//月
        var strDate = date.getDate();//日
        if (month >= 1 && month <= 9)
        {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9)
        {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();

        var opt = document.getElementById("operationDate");
        opt.setAttribute("value", currentdate);
    }

    function checkControll() {
        var expense = document.getElementById("expense").value.toUpperCase();
        if(expense == "") {
            alert("核对金额不能为空");
            return false;
        }
    }
</script>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laydate'], function () {
        var laydate = layui.laydate;


        //日期时间选择器
        laydate.render({
            elem: '#test-laydate-type-datetime1',
            type: 'datetime'
        });

        laydate.render({
            elem: '#test-laydate-type-datetime2',
            type: 'datetime'
        });
    });
</script>

<body onload="getParent();getTime()">
<div class="layui-fluid" id="html1">
    <div class="layui-row layui-col-space15">
        <div class="layui-card layui-form" lay-filter="component-form-element">
            <div style="padding: 20px;" style="margin: auto;">

                <div class="layui-row">

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">操作员：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="username" autocomplete="off" readonly>
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">开始日期：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="test-laydate-type-datetime1" autocomplete="off"
                               readonly="readonly">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">结束日期：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="test-laydate-type-datetime2" autocomplete="off"
                               readonly="readonly">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">核对金额：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input type="number" class="layui-input" id="expense" autocomplete="off">
                    </div>
                    <br>


                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">操作日期：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="operationDate" readonly="true" autocomplete="off">
                    </div>
                    <br>

                </div>
            </div>
        </div>

    </div>

</div>
</body>
</html>
