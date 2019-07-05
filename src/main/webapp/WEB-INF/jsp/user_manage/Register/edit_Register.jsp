<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <meta charset="utf-8">
    <title>编辑挂号收费员</title>
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
        <form id="form" class="layui-card layui-form" lay-filter="component-form-element">
            <div style="padding: 20px;" style="margin: auto;">

                <div class="layui-row">

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">用户名：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input"name="login_name" autocomplete="off" value="${login_name}">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">真实姓名：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" name="real_name" autocomplete="off" value="${real_name}">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">所在科室：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                    <select id="departments" name="deptid"  lay-search>
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.id}">${dept.deptname}</option>
                        </c:forEach>
                    </select>
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">用户类别：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                    <select id="usercategorys" name="category"  lay-search>
                        <option value="01">挂号收费员</option>
                        <option value="02">门诊医生</option>
                        <option value="03">医技医生</option>
                        <option value="04">药房操作员</option>
                        <option value="05">财务管理员</option>
                        <option value="06">医院管理员</option>
                    </select>
                    </div>
                    <br>


                </div>


            </div>


        </form>


    </div>

</div>


<script src="department/layui/layui.js"></script>


<script>
    window.onload = function () {
        var select1= document.getElementById("departments");
        var opts1=select1.getElementsByTagName("option");
        for (var i = 0; i <opts1.length ; i++) {
            if (opts1[i].innerText=="${deptid}") {
                opts1[i].selected=true;
                break;
            }
        }

        var select= document.getElementById("usercategorys");
        var opts=select.getElementsByTagName("option");
        for (var j = 0; j <opts.length ; j++) {
            if (opts[j].innerText=="${category}") {
                opts[j].selected=true;
                break;
            }
        }
    };
    function submit() {
        // alert("zizizi");
        var $=layui.$;
        // var myarray = ["Saab", "Volvo", "BMW"];
        $.ajax({
            type: "POST",//方法类型
            url: "user/update",//url
            async: false,
            // data: $("#form").serialize()+"&myarray="+myarray,
            data: $("#form").serialize()+"&id=${id}",
            success: function (result) {

            },
            error: function (result) {
                alert(result.msg);
            }
        });
    }
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form'], function () {
        var $ = layui.$
            , admin = layui.admin
            , element = layui.element
            , form = layui.form;

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