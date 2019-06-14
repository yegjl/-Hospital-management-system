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
    <title>门诊病历首页</title>
    <!-- <meta name="renderer" content="webkit"> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">

    <script src="department/jQuery/jquery-3.4.1.min.js"></script>
    <script src="jq-load.js"></script>

</head>

<style>
    .layui-body {
        position: absolute;
        left: 200px;
        right: 0;
        top: 0;
        bottom: 0;
        z-index: 998;
        width: auto;
        overflow: hidden;
        overflow-y: auto;
        box-sizing: border-box
    }
</style>



<body class="layui-layout-body">
    <div id="LAY_app">
        <div class="layui-layout layui-layout-admin">


            <!-- 头部导航栏 -->
            <div class="layui-card">
                <div class="layui-card-body">

                    <ul class="layui-nav" lay-filter="component-nav">
                        <li class="layui-nav-item  layui-this" style="width: 200px;text-align: center;">
                            <p id="1"> 门诊医生工作站</p>
                        </li>
                        <li class="layui-nav-item" style="width: 100px; text-align: center;">
                            <p id="2">门诊首页</p>

                        </li>
                        <li class="layui-nav-item" style="width: 100px; text-align: center;">
                            <p id="3">检查申请</p>
                        </li>



                    </ul>

                </div>
            </div>




            <!-- 主体内容 -->

            <div class="layui-body" id="LAY_app_body" style="left:20px;">
                <div class="layadmin-tabsbody-item layui-show">

                    <div id="box1">
                        <iframe src="fifthpart/index?id=01" frameborder="0" class="layadmin-iframe"></iframe>
                    </div>
                    <div id="box2">
                        <iframe src="fifthpart/index?id=02" frameborder="0"
                                class="layadmin-iframe"></iframe>
                    </div>
                    <div id="box3">
                        <iframe src="fifthpart/index?id=03" frameborder="0"
                                class="layadmin-iframe"></iframe>
                    </div>




                </div>
            </div>



            <!-- 辅助元素，一般用于移动设备下遮罩 -->
            <div class="layadmin-body-shade" layadmin-event="shade"></div>
        </div>
    </div>


    <script src="department/layui/layui.js"></script>


</body>


<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index'], function () {
        var $ = layui.$,
            admin = layui.admin,
            element = layui.element;

        element.render('nav', 'component-nav');
        element.render('nav', 'component-nav-active');

        element.on('nav(component-nav-active)', function (elem) {
            layer.msg(elem.text());
        });
    });
</script>
<script type="text/javascript">
    window.onload = function () {
        var arr = document.getElementsByTagName('p');
        for (var i = 0; i < arr.length; i++) {
            arr[i].onclick = function () {
                if (this.id == '1') {
                    document.getElementById("box1").style.display = 'block';
                    document.getElementById("box2").style.display = 'none';
                    document.getElementById("box3").style.display = 'none';
                } else if (this.id == '2') {
                    document.getElementById("box1").style.display = 'none';
                    document.getElementById("box2").style.display = 'block';
                    document.getElementById("box3").style.display = 'none';
                } else {
                    document.getElementById("box1").style.display = 'none';
                    document.getElementById("box2").style.display = 'none';
                    document.getElementById("box3").style.display = 'block';
                }
                //this是当前激活的按钮，在这里可以写对应的操作
                if (this.className == 'btn1') {
                    this.className = 'btn2';
                    var name = this.id;
                    var btn = document.getElementsByClassName('btn2');
                    for (var j = 0; j < btn.length; j++) {
                        if (btn[j].id != name) {
                            btn[j].className = 'btn1';
                        }
                    }
                }
            }
        }
    }
</script>


</html>