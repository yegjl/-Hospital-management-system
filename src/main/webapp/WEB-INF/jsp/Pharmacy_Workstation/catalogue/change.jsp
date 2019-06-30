<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>"/>
<html>

<head>
    <meta charset="utf-8">
    <title>调价</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>
<form id="change"  role="form">
    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;" style="margin: auto;">

                    <div class="layui-row">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">药品编码：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugid" name="drugid" autocomplete="off" placeholder="请输入编码">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">药品名：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugname" name="drugname" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">规格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="format" name="format" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">厂家：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="manufacturer" name="manufacturer" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">原价格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="oldprice" name="oldprice" autocomplete="off" placeholder="请输入当前价格" readonly>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">新价格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input type="number" class="layui-input" id="newprice" name="newprice" autocomplete="off" placeholder="请输入新价格">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">调价单号：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="adjustid" name="adjustid" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">执行日期：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="date" name="date" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">调价文号：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="adjustnumber" name="adjustnumber" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">调价原因：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="reason" name="reason" autocomplete="off" placeholder="请输入商品名">
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
        window.onload=function() {
            var logs = null;
            $.ajax({
                type: "GET",//方法类型
                url: "drugstore/changeinfo?id=${id}",//url
                async: false,
                success: function (result) {
                    if (result.status == 0) {
                        logs= result.data;
                        $("#drugid").empty();
                        $("#drugname").empty();
                        $("#format").empty();
                        $("#oldprice").empty();
                        $("#manufacturer").empty();
                        $("#date").empty();
                        document.getElementById("drugid").setAttribute("value",logs.id);
                        document.getElementById("drugname").setAttribute("value",logs.drugsname);
                        document.getElementById("format").setAttribute("value",logs.drugsformat) ;
                        document.getElementById("oldprice").setAttribute("value",logs.drugsprice) ;
                        document.getElementById("manufacturer").setAttribute("value",logs.manufacturer) ;
                        document.getElementById("date").setAttribute("value","${datte}");
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