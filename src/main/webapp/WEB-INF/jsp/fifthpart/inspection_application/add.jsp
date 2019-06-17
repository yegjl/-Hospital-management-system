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
    <title>排班管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>

    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;">

                    <div class="layui-row">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p>检查项目：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">

                            <select name="week" lay-verify="required" lay-search>
                                <option value="">请选择项目</option>
                                <c:forEach items="${projects}" var="project">
                                <option value="${project.id}">${project.itemname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">快速检索：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="" autocomplete="off">
                        </div>
                        <br>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">检查目的：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">项目要求：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="" autocomplete="off">
                        </div>
                        <br>
                    </div>



                </div>





            </div>


        </div>

    </div>




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
</body>

</html>