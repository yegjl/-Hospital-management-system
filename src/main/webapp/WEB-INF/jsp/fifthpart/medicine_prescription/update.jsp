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
    <title>改药</title>
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
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;">

                    <div class="layui-row">
<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">--%>
<%--                            <p>处方号：</p>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">--%>
<%--                            <input class="layui-input" name="prescribeid" id="prescribeid" autocomplete="off">--%>
<%--                        </div>--%>
<%--                        <br>--%>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p>药品名称：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="drugsname" id="drugsname" autocomplete="off" readonly>
<%--                            <select id="medicalid" name="medicalid" lay-verify="required" lay-filter="yaopin" lay-search>--%>
<%--                                <option value="">请选择药品</option>--%>
<%--                                <c:forEach items="${projects}" var="project">--%>
<%--                                    <option value="${project.id}">${project.drugsname}</option>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
                        </div>
                        <br>
    <form id="update"  role="form">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="medicalid" id="medicalid" autocomplete="off" type="hidden" readonly>
                        </div>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">规格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="format" id="format" autocomplete="off" readonly>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">单价：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="price" id="price" autocomplete="off" readonly>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p>用法：</p>
                        </div>
                        <%--                        口服、皮下注射、肌肉注射、静脉注射、静脉滴注、外用、喷雾吸入、肛门塞入--%>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <select name="usage" lay-verify="required" lay-search>
                                <option value="">请输入或搜素搜用法</option>
                                <option value="口服">口服</option>
                                <option value="皮下注射">皮下注射</option>
                                <option value="肌肉注射">肌肉注射</option>
                                <option value="静脉注射">静脉注射</option>
                                <option value="静脉滴注">静脉滴注</option>
                                <option value="外用">外用</option>
                                <option value="喷雾吸入">喷雾吸入</option>
                                <option value="肛门塞入">肛门塞入</option>
                            </select>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">用量：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="dosage" id="dosage" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">单位：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="unit" id="unit" autocomplete="off" readonly>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p>频次：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <select name="times" lay-verify="required" lay-search>
                                <option value="">请输入或搜素搜频次</option>
                                <option value="一天一次">一天一次</option>
                                <option value="一天两次">一天两次</option>
                                <option value="一天三次">一天三次</option>
                            </select>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">天数：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="days" id="days" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">次数：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="number" id="number" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">数量：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input type="number" class="layui-input" id="amount" name="amount" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">用药嘱托：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="entrust" id="entrust" autocomplete="off">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" name="istemp" id="istemp" autocomplete="off" type="hidden" readonly>
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

<%--    <script>--%>
<%--        window.onload=function() {--%>
<%--            var medicalid = null;--%>
<%--            // var pre = parent.document.getElementById('presid').innerHTML;--%>
<%--            // $("#prescribeid").empty();--%>
<%--            // document.getElementById("prescribeid").setAttribute("value",pre);--%>
<%--            $.ajax({--%>
<%--                type: "POST",//方法类型--%>
<%--                url: "prescribe/indexadd?drugid=${drugid}",//url--%>
<%--                async: false,--%>
<%--                success: function (result) {--%>
<%--                    if (result.status == 0) {--%>
<%--                        medicalid = result.data;--%>
<%--                        $("#medicalid").empty();--%>
<%--                        $("#medicalid").append("<option value=''>输入药品名称</option>");--%>
<%--                        for (var i = 0 ; i < medicalid.length;i++) {--%>
<%--                            $("#medicalid").append("<option value="+medicalid[i].id+">"+medicalid[i].drugsname+"</option>");--%>
<%--                        }--%>
<%--                    }--%>
<%--                },--%>
<%--                error: function (result) {--%>
<%--                    alert(result.msg);--%>
<%--                }--%>
<%--            });--%>

<%--            $(function () {--%>
<%--                $("#first").click();--%>
<%--            })--%>
<%--        }--%>
<%--        layui.config({--%>
<%--            base: 'department/' //静态资源所在路径--%>
<%--        }).extend({--%>
<%--            index: 'lib/index' //主入口模块--%>
<%--        }).use('index');--%>
<%--    </script>--%>

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


        // form.on('select(yaopin)', function(data){
        //     console.log(data.elem); //得到select原始DOM对象
        //     console.log(data.value); //得到被选中的值
        //     console.log(data.othis); //得到美化后的DOM对象
        //     var drug = null;
        //     $.ajax({
        //         type: "POST",//方法类型
        //         url: "prescribe/getinfo?id="+data.value,//url
        //         async: false,
        //         success: function (result) {
        //             if (result.status == 0) {
        //                 drug= result.data;
        //                 $("#format").empty();
        //                 $("#price").empty();
        //                 $("#unit").empty();
        //                 document.getElementById("format").setAttribute("value",drug.drugsformat);
        //                 document.getElementById("price").setAttribute("value",drug.drugsprice) ;
        //                 document.getElementById("unit").setAttribute("value",drug.drugsunit) ;
        //                 document.getElementById("istemp").setAttribute("value",0) ;
        //             }
        //         },
        //         error: function (result) {
        //             alert(result.msg);
        //         }
        //     });
        // });
    });
</script>

<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" language="JavaScript">
    window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
</script>
<%--<script>--%>
<%--    function searchpro(pro_name) { //获取用户名对应的密保问题--%>
<%--        $.ajax({--%>
<%--            type: "get",--%>
<%--            url: "fifthpart/getQue?name="+pro_name+"&id=1",--%>
<%--            success: function (fmeditem) {--%>
<%--                var result = fmeditem;--%>
<%--                var opt = document.getElementById("result");--%>
<%--                if(result=="")--%>
<%--                    opt.setAttribute("value","暂无查询结果");--%>
<%--                else--%>
<%--                    opt.setAttribute("value", result.itemname);--%>

<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>

<script>
    window.onload=function() {
        // var table = parent.layui.table;
        // var tablevalue = table.checkStatus('test-table-cellEdit-middle').data;
        // $("#medicalid").empty();
        // document.getElementById("medicalid").setAttribute("value",tablevalue[0].medicalid) ;
        var logs = null;//tablevalue[0].medicalid;
        $.ajax({
            type: "POST",//方法类型
            url: "prescribe/updateinfo?prescribeid=${prescribeid}&medicalid=${medicalid}",//url
            async: false,
            success: function (result) {
                    if (result.status == 0) {
                        logs= result.data;
                        $("#medicalid").empty();
                        $("#format").empty();
                        $("#price").empty();
                        $("#unit").empty();
                        $("#dosage").empty();
                        $("#days").empty();
                        $("#number").empty();
                        $("#amount").empty();
                        $("#entrust").empty();
                        $("#istemp").empty();

                        document.getElementById("drugsname").setAttribute("value",logs.drugsname);
                        document.getElementById("medicalid").setAttribute("value",logs.medicalid);
                        document.getElementById("format").setAttribute("value",logs.format);
                        document.getElementById("price").setAttribute("value",logs.price) ;
                        document.getElementById("unit").setAttribute("value",logs.unit) ;
                        document.getElementById("dosage").setAttribute("value",logs.dosage) ;
                        document.getElementById("days").setAttribute("value",logs.days) ;
                        document.getElementById("number").setAttribute("value",logs.number) ;
                        document.getElementById("amount").setAttribute("value",logs.amount) ;
                        document.getElementById("entrust").setAttribute("value",logs.entrust) ;
                        document.getElementById("istemp").setAttribute("value",logs.istemp) ;
                    }
            },
            error: function (result) {
                alert(result.msg);
            }
        });
        // var table = parent.layui.table;
        // var tablevalue = table.checkStatus('test-table-cellEdit-middle').data;
        // $("#").empty();
        // document.getElementById("medicalid").setAttribute("value",tablevalue[0].medicalid) ;
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