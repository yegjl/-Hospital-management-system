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
    <title>编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>

<form id="edit"  role="form">
    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;" style="margin: auto;">

                    <div class="layui-row">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">药品编码：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugscode" name="drugscode" autocomplete="off" placeholder="请输入编码">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">药品名：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugsname" name="drugsname" autocomplete="off" placeholder="请输入商品名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">拼音码：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="mnemoniccode" name="mnemoniccode" autocomplete="off" placeholder="请输入拼音码">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">状态：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugstatus" name="drugstatus" autocomplete="off" placeholder="请输入状态">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">规格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugsformat" name="drugsformat" autocomplete="off" placeholder="请输入规格">
                        </div>
                        <br>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">剂型：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <select name="constantname" lay-verify="required" lay-search>
                                <option value="">请选择剂型</option>
                                <c:forEach items="${projects}" var="project">
                                    <option value="${project.id}">${project.constantname}</option>
                                </c:forEach>


                            </select>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">包装数量：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugamount" name="drugamount" autocomplete="off" placeholder="请输入包装数量">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">单位：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="drugsunit" name="drugsunit" autocomplete="off" placeholder="单位">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">售价：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input type="number" class="layui-input" id="drugsprice" name="drugsprice" autocomplete="off" placeholder="请输入售价">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">厂商：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="manufacturer" name="manufacturer" autocomplete="off" placeholder="请输入厂商名">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">药品类别：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <select name="typename" lay-verify="required">
                                <option value="">请选择剂型</option>
                                <option value="101">西药</option>
                                <option value="102">中成药</option>
                                <option value="103">中草药</option>
                            </select>
                        </div>
                    </div>
                    <br>




                </div>



            </div>





        </div>


    </div>
</form>





    <script src="department/layui/layui.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>


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
                url: "drugstore/updateinfo?id=${id}",//url
                async: false,
                success: function (result) {
                    if (result.status == 0) {
                        logs= result.data;
                        $("#drugscode").empty();
                        $("#drugsname").empty();
                        $("#mnemoniccode").empty();
                        $("#drugstatus").empty();
                        $("#drugsformat").empty();
                        $("#drugamount").empty();
                        $("#drugsunit").empty();
                        $("#drugsprice").empty();
                        $("#manufacturer").empty();

                        document.getElementById("drugscode").setAttribute("value",logs.drugscode);
                        document.getElementById("drugsname").setAttribute("value",logs.drugsname);
                        document.getElementById("mnemoniccode").setAttribute("value",logs.mnemoniccode);
                        document.getElementById("drugstatus").setAttribute("value",logs.drugstatus) ;
                        document.getElementById("drugsformat").setAttribute("value",logs.drugsformat) ;
                        document.getElementById("drugamount").setAttribute("value",logs.drugamount) ;
                        document.getElementById("drugsunit").setAttribute("value",logs.drugsunit) ;
                        document.getElementById("drugsprice").setAttribute("value",logs.drugsprice) ;
                        document.getElementById("manufacturer").setAttribute("value",logs.manufacturer) ;
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