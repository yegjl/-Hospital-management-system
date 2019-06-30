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
    <title>增药</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>
<form id="add"  role="form">
    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;">

                    <div class="layui-row">



                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p>药品名称：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <select name="drugid" id="drugid" lay-verify="required" id="drugselect" lay-filter="yaopin" lay-search>
                                <option value="">请选择补录项目</option>
                                <c:forEach items="${drugs}" var="drug">
                                    <option value="${drug.id}">${drug.drugsname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">规格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugsformat" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">单价：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugsprice" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">数量：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input type="number" name="number" id="number" class="layui-input" id="" autocomplete="off">
                        </div>
                        <br>





                    </div>



                </div>





            </div>


        </div>

    </div>
</form>



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

            form.on('select(yaopin)', function(drugid){
                $.ajax({
                    type: "get",
                    url: "sixpart/getdrug?id="+drugid.value,
                    success: function (drugs1) {
                        var result = drugs1;
                        var opt = document.getElementById("drugsformat");
                        opt.setAttribute("value", result.drugsformat);
                        var opt1 = document.getElementById("drugsprice");
                        opt1.setAttribute("value", result.drugsprice);
                    }
                });
            });

            });
    </script>

</body>

</html>