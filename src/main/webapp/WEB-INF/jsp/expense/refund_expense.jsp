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
    <title>退费</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>

    <style>
        dl.layui-anim-upbit {
            position: fixed;
            min-width: 10px;
            width: 212px;
            margin: 0px auto;
            left: 0px;
            right: 18px;
        }
    </style>
</head>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
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
    
    function getRefundExpense() {
        var refund_number = document.getElementById("refund_number").value.toUpperCase();
        var unit_price = document.getElementById("unit_price").value.toUpperCase();
        var refund_expense = refund_number * unit_price;
        var opt = document.getElementById("refund_expense");
        opt.setAttribute("value", refund_expense + "");
    }
    
    function refundControll() {
        var refund_number = document.getElementById("refund_number").value.toUpperCase();
        var number = document.getElementById("number").value.toUpperCase();

        if(refund_number == "") {
            alert("退款数量不能为空");
            return false;
        }
        else if(number < refund_number) {
            alert("退款数量不能超过已支付数量");
            return false;
        }
    }

    function getParent() {
        $(window.parent.getRefundValue());
    }

    function getYF() {
        var expense_category = document.getElementById("expense_category").value.toUpperCase();
        var table1 = parent.layui.table;
        var tabledata = table1.checkStatus('test-table-page').data;
        var opt = document.getElementById("refund_number");
        var opt2 = document.getElementById("refund_expense");
        var unit_price = document.getElementById("unit_price").value.toUpperCase();
        if(expense_category.indexOf("药费") != -1) {
            $.ajax({
                type: "post",
                url: "expense/refundDrug",
                data: {
                    "id": tabledata[0].id
                },
                dataType: "JSON",
                async: false,
                success: function (data) {
                    if(data == 0) {
                        alert("该患者未退药，无法退费");
                        parent.layer.closeAll();
                    }
                    else {
                        opt.setAttribute("value", data);
                        opt2.setAttribute("value", (data * unit_price) + "");
                    }
                },
                error: function () {
                    alert("error");
                }
            });
        }
    }
</script>

<body onload="getDate();getParent();getYF()">
<div class="layui-fluid" id="html1">
    <div class="layui-row layui-col-space15">
        <div class="layui-card layui-form" lay-filter="component-form-element">
            <div style="padding: 20px;" style="margin: auto;">

                <div class="layui-row">

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
                        <p style="margin: auto;">单位：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="unit" autocomplete="off" readonly="readonly">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                        <p style="margin: auto;">已支付数量：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="number" autocomplete="off" readonly="readonly">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                        <p style="margin: auto;">退费数量：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input type="number" class="layui-input" id="refund_number" autocomplete="off" onblur="getRefundExpense()" placeholder="请输入退费数量">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                        <p style="margin: auto;">退费金额：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input type="number" class="layui-input" id="refund_expense" autocomplete="off" readonly="true">
                    </div>
                    <br>

                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md1" >
                        <p style="margin: auto;">操作日期：</p>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                        <input class="layui-input" id="expense_date" autocomplete="off" readonly="readonly" >
                    </div>
                    <br>

                </div>

            </div>
        </div>

    </div>

</div>
</body>
</html>
