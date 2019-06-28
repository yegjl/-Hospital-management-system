<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<base href="<%=basePath%>"/>
<html>

<head>
    <meta charset="utf-8">
    <title>退药</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>

<form id="tuiyao" role="form">
    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;" style="margin: auto;">

                    <div class="layui-row">
                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            药品id：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" name="id" id="id" class="layui-input" readonly>
                        </div>
                        <br>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            药品名称：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" name="medicinename" id="medicinename" class="layui-input" readonly>
                        </div>
                        <br>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            现数量：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" name="amount" id="amount" class="layui-input" readonly>
                        </div>
                        <br>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            退掉数量：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" id="renum" name="renum" class="layui-input">
                        </div>
                        <br>


                    </div>


                </div>


            </div>

        </div>
    </div>
</form>


<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="department/layui/layui.js"></script>


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
    window.onload = function () {
        var logs = null;
        $.ajax({
            type: "GET",//方法类型
            url: "drugstore/findreturninfo?id=${id}",//url
            async: false,
            success: function (result) {
                if (result.status == 0) {
                    logs = result.data;
                    $("#id").empty();
                    $("#medicinename").empty();
                    $("#amount").empty();

                    document.getElementById("id").setAttribute("value", logs.id);
                    document.getElementById("medicinename").setAttribute("value", logs.medicinename);
                    document.getElementById("amount").setAttribute("value", logs.amount);
                }
            },
            error: function (result) {
                alert(result.msg);
            }
        });
        $(function () {
            $("#first").click();
        })
    }
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');

</script>
</body>

</html>