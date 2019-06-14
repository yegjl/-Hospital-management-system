<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>
<html>

<head>
    <title>ajax局部刷新</title>
</head>


<body>

    <header>
        <nav>
            <a href="jq-load.html" class="current">首页</a>
            <a href="jq-load2.html">新闻资讯</a>
            <a href="jq-load3.html">用户中心</a>
        </nav>
    </header>

    <section id="content">
        <div id="container">
            首页的内容
        </div>
    </section>

    <script src="D:\OneDrive\工作\嘤嘤嘤前端\2019-6-5完整\layuiadmin\jQuery\jquery-3.4.1.min.js"></script>
    <script src="jq-load.js"></script>

</body>

</html>