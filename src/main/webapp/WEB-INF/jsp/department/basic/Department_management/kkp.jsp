<%--
  Created by IntelliJ IDEA.
  User: Luo Shijie
  Date: 2019/6/11
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <meta name="renderer" content="webkit">
    <title>${icdfirstname}管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>${icdfirstname}管理</legend>
</fieldset>

<div class="layui-tab layui-tab-card" style="width:100%;">
    <ul id="icdsecondnames" class="layui-tab-title"></ul>
    <div class="layui-tab-content" style="height:100%;">
        <div class="layui-tab-item">

        </div>
        <div class="layui-tab-item">

        </div>
        <div class="layui-tab-item">3</div>
        <div class="layui-tab-item">4</div>
        <div class="layui-tab-item">5</div>
        <div class="layui-tab-item">6</div>
        <div class="layui-tab-item">7</div>
        <div class="layui-tab-item">8</div>
        <div class="layui-tab-item">9</div>
    </div>
</div>


<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="department/layui/layui.js"></script>

<script>
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
</script>

<script>
    window.onload = function () {
       // $= layui.$;
        var icdsecondnames = null;
        $.ajax({
            type: "GET",//方法类型
            <%--url: "icd/secondname?icdid=${icdid}",//url--%>
            url: "icd/secondname?icdid=${icdid}",//url
            async: false,
            success: function (result) {
                if (result.status == 0) {
                    icdsecondnames = result.data;
                    $("#icdsecondnames").empty();
                    for (var i = 0; i < icdsecondnames.length; i++) {

                        // $("#icdsecondnames").append("<li><a lay-href='icd/info?secondid=" + icdsecondnames[i].id + "'>" + icdsecondnames[i].icdsecondname + "</a></li>");
                        $("#icdsecondnames").append("<li> "+ icdsecondnames[i].icdsecondname + "</li>");

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

<script>
    layui.config({
        base: 'department/' //静态资源所在路径X
    })
        .extend({
            index: 'lib/index' //主入口模块X
        })
        .use(['index', 'table'], function () {
            var table = layui.table;

            //方法级渲染
         var tablerender=   table.render({
                elem: '#test-table-reload'
                // 这部分url你们自己填你们部署的接口********************************************************************************************
                // ,url: layui.setter.base + 'data/table/nei.js'
             <%--, url: 'icd/info01?secondid=${secondid}'--%>
             , url: 'icd/info01?secondid=${secondid}'
                , method: 'get'
                , parseData: function (res) {
                    //TODO:解析JSON对象
                    return {
                        "code": res.status,
                        "msg": res.message,
                        "count": res.total,
                        "data": res.data
                    }
                }
                , cols: [[
                    {checkbox: true, fixed: true}
                    , {field: 'id', title: 'id', width: 180, sort: true, fixed: true}
                    , {field: 'diseaseicd', title: '疾病编码', width: 180}
                    , {field: 'diseasename', title: '疾病名称', width: 180}
                    , {field: 'diseasecode', title: '拼音码', width: 180}
                    , {field: 'dicaname', title: '分类名称', width: 180}
                ]]

            });


            // 搜索函数X
            var $ = layui.$, active = {
                reload: function () {
                    var demoReload = $('#demoReload');

                    //执行重载
                    table.reload('test-table-reload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            deptid: demoReload.val()
                        }
                    }, 'data');
                }
            };

            $('.test-table-reload-btn .layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });


        });


</script>
</body>
</html>
