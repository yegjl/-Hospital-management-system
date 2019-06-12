<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">

    <!--   <script>
        //检测是否在服务器环境下
      /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
      </script> -->


</head>
<body class="layui-layout-body">

<!-- 二级侧边栏 -->
<div class="layui-side layui-side-menu">
    <div class="layui-side-scroll">
        <ul id="icdsecondnames" class="layui-nav layui-nav-tree site-demo-table-nav"></ul>
    </div>
</div>

<!-- 主体部分 -->

<div class="layui-body" id="LAY_app_body">
    <div class="layadmin-tabsbody-item layui-show">
        <iframe href="../basic/Department_management.jsp" frameborder="0" class="layadmin-iframe"></iframe>
<%--        <iframe src="disease.jsp" frameborder="0" class="layadmin-iframe"></iframe>--%>
    </div>
</div>


<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="department/layui/layui.js"></script>
<script>
    layui.config({
        base: '../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>

<script>
    window.onload = function () {
        // $= layui.$;
        var icdsecondnames = null;
        $.ajax({
            type: "GET",//方法类型
            url: "icd/secondname?icdid=${icdid}",//url
            async: false,
            success: function (result) {
                if (result.status == 0) {
                    icdsecondnames = result.data;
                    $("#icdsecondnames").empty();
                    for (var i = 0; i < icdsecondnames.length; i++) {
                        // $("#icdsecondnames").append("<li><a lay-href='icd/info?secondid=" + icdsecondnames[i].id + "'>" + icdsecondnames[i].icdsecondname + "</a></li>");
                        $("#icdsecondnames").append("<li class='layui-nav-item'><a href='icd/index01?secondid="+icdsecondnames[i].id+"&secondname="+icdsecondnames[i].icdsecondname+"'> "+ icdsecondnames[i].icdsecondname + "</a></li>");
                    }
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


