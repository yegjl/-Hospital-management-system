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
    <title>添加常用药</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>
<form id="often"  role="form">
    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;">

                    <div class="layui-row">
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p>药品名称：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">

                            <select id="fmeditemid" name="fmeditemid" lay-verify="required" lay-filter="yaoid" lay-search>
                                <option value="">请选择药品</option>
                                <c:forEach items="${fmeditems}" var="fmeditem">
                                    <option value="${fmeditem.id}">${fmeditem.itemname}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="medicalname" id="medicalname" autocomplete="off" type="hidden" readonly>
                        </div>
                        <br>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="doctorid" id="doctorid" type="hidden" autocomplete="off" readonly>
                        </div>

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

        form.on('select(yaoid)', function(data){
            // console.log(data.elem); //得到select原始DOM对象
            // console.log(data.value); //得到被选中的值
            // console.log(data.othis); //得到美化后的DOM对象
            var drug = null;
            $.ajax({
                type: "POST",//方法类型
                url: "prescribe/getinfo?id="+data.value,//url
                async: false,
                success: function (result) {
                    if (result.status == 0) {
                        drug= result.data;
                        $("#medicalname").empty();
                        $("#doctorid").empty();
                        document.getElementById("medicalname").setAttribute("value",drug.drugsname);
                        document.getElementById("doctorid").setAttribute("value",${doctorid});
                    }
                },
                error: function (result) {
                    alert(result.msg);
                }
            });
        });

    });
</script>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" language="JavaScript">
    window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
</script>



</body>

</html>