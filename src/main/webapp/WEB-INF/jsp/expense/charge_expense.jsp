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
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>收费</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="source/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="source/style/admin.css" media="all">
    <script src="source/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
</head>

<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form'], function(){
        var $ = layui.$
            ,admin = layui.admin
            ,element = layui.element
            ,form = layui.form;

        form.render(null, 'component-form-element');
        element.render('breadcrumb', 'breadcrumb');

        form.on('submit(component-form-element)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

<script>
    function getDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        var opt = document.getElementById("expense_date");
        opt.setAttribute("value", currentdate);
    }

    function chargeControll() {
        var real_expense = document.getElementById("real_expense").value.toUpperCase();
        var pay_category = document.getElementById("pay_category").value.toUpperCase();
        var expense = document.getElementById("expense").value.toUpperCase();

        if(real_expense == "") {
            alert("实付金额不能为空");
            return false;
        }
        else if(pay_category == "") {
            alert("付款方式不能为空");
            return false;
        }
        else if(real_expense < expense) {
            alert("交费额度不足");
            return false;
        }
        else if(real_expense > expense) {
            var m = real_expense - expense;
            alert("找零" + m + "元");
            var opt = document.getElementById("real_expense");
            opt.setAttribute("value", m + "");
            return true;
        }
    }

    function getParent() {
        $(window.parent.getChargeValue());
    }
</script>

<body onload="getDate();getParent()">
<div class="layui-fluid" id="html1">
    <div class="layui-row layui-col-space15">
        <div class="layui-card layui-form" lay-filter="component-form-element">
            <div style="padding: 20px;" style="margin: auto;">

                <form>

                    <div class="layui-row">

                        <input id="pay_sign" value="1" style="display: none">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">收费项目名：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="expense_name" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">收费类别：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="expense_category" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">规格：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="specifications" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">单价：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="unit_price" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">数量：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="number" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">单位：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="unit" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">应付金额：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="expense" autocomplete="off" readonly="readonly">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">实付金额：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input type="number" class="layui-input" id="real_expense" autocomplete="off" >
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1"><p>支付方式：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">

                            <select name="week" id="pay_category" lay-verify="required" lay-search>
                                <option value="">请选择收费方式</option>
                                <option value="01">现金</option>
                                <option value="02">银行储蓄卡</option>
                                <option value="03">银行信用卡</option>
                                <option value="04">支付宝</option>
                                <option value="05">微信支付</option>
                                <option value="06">医保卡</option>
                            </select>
                        </div>
                        <br>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                            <p style="margin: auto;">收费日期：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="expense_date" autocomplete="off" readonly="readonly" >
                        </div>
                        <br>

                    </div>
                </form>

            </div>


        </div>


    </div>

</div>
</body>
</html>
