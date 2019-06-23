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
    <title>编辑诊断</title>
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
            <div style="padding: 20px;">

                <div class="layui-row">
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p>疾病名称：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">

                        <select id="diseaseName" name="diseaseid" lay-verify="required" lay-search>
                            <c:forEach items="${diseases}" var="disease">
                                <option value="${disease.id}">${disease.diseasename}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">病历号：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" name="medicalRecordNo" value="${medicalRecordNo}" readonly="readonly" autocomplete="off">
                    </div>
                    <br>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">主诊/疑似标志：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <div  id="sign">
<%--                            <input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊">--%>
                        </div>
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                        <p style="margin: auto;">发病日期：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input type="date" name="dA" class="layui-input" id="date">
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

        var $=layui.$;
        var date="${date}";
        var flag="${flag}";
        //type date input 默认当天
        document.getElementById('date').valueAsDate = new Date(date);
        if (flag=="0") {
        $("#sign").append('<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" >');
        }else if (flag == "1") {
            $("#sign").append('<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" checked>');
        }
        var select= document.getElementById("diseaseName");
        var opts=select.getElementsByTagName("option");
        for (var i = 0; i <opts.length ; i++) {
            if (opts[i].value=="${diseaseid}") {
                opts[i].selected=true;
                break;
            }
        }
        // $.ajax({
        //     type: "GET",//方法类型
        //     url: "MedicalRecordPage/findDname",//url
        //     async: false,
        //     success: function (result) {
        //         if (result.status == 0) {
        //             var names = result.data;
        //             $("#diseaseName").empty();
        //             for (var id in names) {
        //                 $("#diseaseName").append("<option value=" + names[id].id + ">" + names[id].diseasename + "</option>");
        //             }
        //         }
        //     },
        //     error: function (result) {
        //         alert(result.msg);
        //     }
        // });
    };
    function submit() {
        // alert("zizizi");
        var $=layui.$;
        // var myarray = ["Saab", "Volvo", "BMW"];
        $.ajax({
            type: "POST",//方法类型
            url: "MedicalRecordPage/update",//url
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
        form.on('switch(flag)', function(data){
            if (data.elem.checked) {
                $("#flag").val("1");
            }

        });
    });
</script>

<!-- 时间选择模块 -->
<%--    <script>--%>
<%--        layui.config({--%>
<%--            base: 'department/' //静态资源所在路径--%>
<%--        }).extend({--%>
<%--            index: 'lib/index' //主入口模块--%>
<%--        }).use(['index', 'laydate'], function () {--%>
<%--            // var laydate = layui.laydate;--%>

<%--            //示例代码--%>

<%--            //常规用法--%>
<%--            // laydate.render({--%>
<%--            //     elem: '#test-laydate-normal-cn'--%>
<%--            // });--%>


<%--            //同时绑定多个--%>
<%--            lay('.test-laydate-item').each(function () {--%>
<%--                laydate.render({--%>
<%--                    elem: this,--%>
<%--                    trigger: 'click'--%>
<%--                });--%>
<%--            });--%>

<%--        });--%>
<%--    </script>--%>
</body>
</html>