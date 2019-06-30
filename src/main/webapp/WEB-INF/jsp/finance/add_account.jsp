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
    <title>费用科目增加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
</head>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form'], function(){
        var $ = layui.$
            ,admin = layui.admin
            ,element = layui.element
            ,form = layui.form;

        form.render(null, 'component-form-element');
        element.render('breadcrumb', 'breadcrumb');

        form.on('submit(component-form-element)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

<script>
    function addControll() {
        var code = document.getElementById("accountCode").value.toUpperCase();
        var name = document.getElementById("accountName").value.toUpperCase();

        if(code == ""){
            alert("科目编码不能为空");
            return false;
        }
        else if(name == "") {
            alert("科目名称不能为空");
            return false;
        }
    }
</script>

<body>
<div class="layui-fluid" id="html1">
    <div class="layui-row layui-col-space15">
        <div class="layui-card layui-form" lay-filter="component-form-element">
            <div style="padding: 20px;">
                <form method="post">

                    <div class="layui-row">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">科目编码：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="accountCode" autocomplete="off">
                        </div>
                        <br>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">科目名称：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="accountName" autocomplete="off">
                        </div>
                        <br>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
