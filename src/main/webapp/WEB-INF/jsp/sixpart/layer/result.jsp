<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>"/>
<html>

<head>
    <meta charset="utf-8">
    <title>检查/检验结果查看</title>
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
                        <p style="margin: auto;">病历号：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="medical_record_no" autocomplete="off" value="${medical_record_no}">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">患者姓名：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="patient_name" autocomplete="off" value="${patient_name}">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">项目名称：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="itemname" autocomplete="off" value="${itemname}">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">检查/检验所见：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <textarea name="" id="suojian" placeholder="请输入" class="layui-textarea">${suojian}</textarea>
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">诊断建议：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <textarea name="" id="advice" placeholder="请输入" class="layui-textarea">${advice}</textarea>
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">检查/检验结果图片：</p>
                    </div>
                    <br>

                    <div>
                        <c:forEach items="${examcheckResultPics}" var="url">
                            <img src="static/resultpics/${url.directory}"  height="180" width="180">
                        </c:forEach>
                    </div>
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