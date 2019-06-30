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
    <title>收费</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/json3.js"></script>

    <style type="text/css">
        .layui-table th {
            font-weight: 600;
            font-size: 100%;
        }

        body .layui-table-tips .layui-layer-content {
            background: 0 0;
            padding: 0;
            box-shadow: 0 1px 6px rgba(0, 0, 0, .12);
        }
    </style>
</head>

<script>
    layui.config({
        base: 'source/' //静态资源所在路径X
    })
        .extend({
            index: 'lib/index' //主入口模块X
        })
        .use(['index', 'table'], function () {
            var table = layui.table;




            // 搜索函数X
            var $ = layui.$,
                active = {
                    reload: function () {
                        var demoReload = $('#test-table-demoReload');

                        //执行重载
                        table.reload('test-table-page', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            },
                            where: {
                                key: {
                                    id: demoReload.val()
                                }
                            }
                        });
                    }
                };

            $('.test-table-reload-btn .layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });


        });
</script>

<script>
    function getPatientInfo(medical_record_no) {
        $.ajax({
            type: "get",
            url: "expense/info/" + medical_record_no,
            success: function (result) {
                if(result[0] == "null") {
                    alert("该病历号不存在！")
                    return;
                }

                var name = result[0];
                var gender = result[1];
                var age = result[2];
                var birthday = result[3];
                var id_card = result[4];
                var settle = result[5];
                var medical = result[6];
                var doctor = result[7];
                var department = result[8];

                var opt1 = document.getElementById("patient_name");
                var opt2 = document.getElementById("patient_gender");
                var opt3 = document.getElementById("patient_age");
                var opt4 = document.getElementById("patient_birthday");
                var opt5 = document.getElementById("patient_id_record");
                var opt6 = document.getElementById("settle_category");
                var opt7 = document.getElementById("medical_category");
                var opt8 = document.getElementById("patient_doctor");
                var opt9 = document.getElementById("patient_department");
                opt1.setAttribute("value", name);
                opt2.setAttribute("value", gender);
                opt3.setAttribute("value", age);
                opt4.setAttribute("value", birthday);
                opt5.setAttribute("value", id_card);
                opt6.setAttribute("value", settle);
                opt7.setAttribute("value", medical);
                opt8.setAttribute("value", doctor);
                opt9.setAttribute("value", department);
            }
        });
    }

    function ValueReset() {
        var opt1 = document.getElementById("patient_name");
        var opt2 = document.getElementById("patient_gender");
        var opt3 = document.getElementById("patient_age");
        var opt4 = document.getElementById("patient_birthday");
        var opt5 = document.getElementById("patient_id_record");
        var opt6 = document.getElementById("settle_category");
        var opt7 = document.getElementById("medical_category");
        var opt8 = document.getElementById("patient_doctor");
        var opt9 = document.getElementById("patient_department");
        opt1.setAttribute("value", "");
        opt2.setAttribute("value", "");
        opt3.setAttribute("value", "");
        opt4.setAttribute("value", "");
        opt5.setAttribute("value", "");
        opt6.setAttribute("value", "");
        opt7.setAttribute("value", "");
        opt8.setAttribute("value", "");
        opt9.setAttribute("value", "");

        $.ajax({
            type: "get",
            url: "expense/refresh",
            success: function () {
                layui.table.reload('test-table-page',{page: {curr: 1}});
            }
        });
    }

    function getTotalExpense() {
        $.ajax({
            type: "get",
            url: "expense/total",
            success: function (result) {
                var total = 0.0;
                for(var i = 0; i < result.length; i++) {
                    total = total + result[i];
                }
                var money = total + "元";
                var opt = document.getElementById("all_expense");
                opt.setAttribute("value", money);
            }
        });
    }

    function getSelect() {
        var medical_record_no = document.getElementById("medical_record_no").value.toUpperCase();
        getPatientInfo(medical_record_no);
        layui.table.reload('test-table-page',{page: {curr: 1}});
    }

    function refresh() {
        $.ajax({
            type: "get",
            url: "expense/refresh",
            success: function () {
                layui.table.reload('test-table-page',{page: {curr: 1}});
            }
        });
    }

    function getInfo(str) {
        var i = 1;
        getJSON(str, "expense_name", i++);
        getJSON(str, "expense_category", i++);
        getJSON(str, "specifications", i++);
        getJSON(str, "unit_price", i++);
        getJSON(str, "number", i++);
        getJSON(str, "unit", i++);
        getJSON(str, "expense", i++);
        getJSON(str, "pay_sign", i);
    }

    function getJSON(str, key, i) {
        var data = JSON.stringify(str, [key]);
        var value = data.toString();
        var name = deleteSign(key, value);
        var opt = document.getElementById("none" + i);
        opt.setAttribute("value", name);
    }

    function getChargeValue() {
        var value1 = document.getElementById("none1").value.toUpperCase();
        var value2 = document.getElementById("none2").value.toUpperCase();
        var value3 = document.getElementById("none3").value.toUpperCase();
        var value4 = document.getElementById("none4").value.toUpperCase();
        var value5 = document.getElementById("none5").value.toUpperCase();
        var value6 = document.getElementById("none6").value.toUpperCase();
        var value7 = document.getElementById("none7").value.toUpperCase();

        var charge = $('#chargeExpense');
        charge.contents().find("#expense_name").val(value1);
        charge.contents().find("#expense_category").val(value2);
        charge.contents().find("#specifications").val(value3);
        charge.contents().find("#unit_price").val(value4);
        charge.contents().find("#number").val(value5);
        charge.contents().find("#unit").val(value6);
        charge.contents().find("#expense").val(value7);
    }
    
    function getRefundValue() {
        var value1 = document.getElementById("none1").value.toUpperCase();
        var value2 = document.getElementById("none2").value.toUpperCase();
        var value3 = document.getElementById("none3").value.toUpperCase();
        var value4 = document.getElementById("none4").value.toUpperCase();
        var value5 = document.getElementById("none5").value.toUpperCase();
        var value6 = document.getElementById("none6").value.toUpperCase();

        var refund = $('#refundExpense');
        refund.contents().find("#expense_name").val(value1);
        refund.contents().find("#expense_category").val(value2);
        refund.contents().find("#specifications").val(value3);
        refund.contents().find("#unit_price").val(value4);
        refund.contents().find("#number").val(value5);
        refund.contents().find("#unit").val(value6);
    }

    function deleteSign(key, word) {
        word = word.replace("[", "");
        word = word.replace("]", "");
        word = word.replace("{", "");
        word = word.replace("}", "");
        word = word.replace(":", "");
        word = word.replace(/\"/g, "");
        word = word.replace(key, "");
        return word;
    }

</script>

<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index'], function () {
        var $ = layui.$,
            admin = layui.admin,
            element = layui.element,
            router = layui.router();

        element.render();

        var active = {

            // 收费函数***************************************************************************************
            pop_charges: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();

                var table = layui.table.checkStatus('test-table-page').data;
                var myArray = new Array();
                for(var i = 0; i < table.length; i++){
                    myArray.push(table[i].id);
                }
                if(myArray.length > 1) {
                    alert("一次只能选择一条收费！");
                    return;
                }
                else if(myArray.length < 1) {
                    alert("请选择一条收费！");
                    return;
                }

                layer.open({
                    type: 1,
                    title: '收费',
                    area: ['490px', '500px'],
                    shade: 0,
                    maxmin: true,
                    offset: type,
                    content: '<iframe src="expense/chargeUI" frameborder="0" id="chargeExpense" name="chargeExpense" class="layadmin-iframe"></iframe>',
                    btn: ['收费', '取消'],
                    yes: function () {
                        var flag = document.getElementById("chargeExpense").contentWindow.chargeControll();
                        if(flag == false)
                            return;

                        var real_expense = window.frames["chargeExpense"].document.getElementById('real_expense').value;
                        var pay_category = window.frames["chargeExpense"].document.getElementById('pay_category').value;
                        var expense_date = window.frames["chargeExpense"].document.getElementById('expense_date').value;
                        var pay_sign = window.frames["chargeExpense"].document.getElementById('pay_sign').value;
                        var expense = window.frames["chargeExpense"].document.getElementById('expense').value;

                        if(real_expense > expense)
                            real_expense = expense;

                        $.ajax({
                            type: "post",
                            url: "expense/charge",
                            data: {
                                "id": table[0].id,
                                "real_expense": real_expense,
                                "pay_category": pay_category,
                                "expense_date": expense_date,
                                "pay_sign": pay_sign
                            },
                            dataType: "JSON",
                            async: false,
                            beforeSend: function () {

                            },
                            success: function (data) {
                                if(data == 1) {
                                }
                                else
                                    alert("交费失败");
                            },
                            error: function () {
                                alert("error");
                            }
                        });
                        //window.location.reload();
                        layui.table.reload('test-table-page',{page: {curr: 1}});
                        layer.closeAll();
                    },
                    btn2: function () {
                        // 此处要写递交的函数，但是不要把我closall的函数删掉***********************************************************************

                        layer.closeAll();
                    }

                    ,
                    zIndex: layer.zIndex,
                    success: function (layero) {
                        layer.setTop(layero);
                    }
                });
            }

            // 退费弹窗
            ,
            pop_refund: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();

                var table = layui.table.checkStatus('test-table-page').data;
                var myArray = new Array();
                for(var i = 0; i < table.length; i++){
                    myArray.push(table[i].id);
                }
                if(myArray.length > 1) {
                    alert("一次只能选择一条退费！");
                    return;
                }
                else if(myArray.length < 1) {
                    alert("请选择一条退费！");
                    return;
                }

                var pay_sign = document.getElementById("none8").value.toUpperCase();
                if(pay_sign == "未付款") {
                    alert("该项目未缴费，无法退费");
                    return;
                }
                else if(pay_sign == "已退费") {
                    alert("该项目已退费");
                    return;
                }

                layer.open({
                    type: 1,
                    offset: type,
                    title: '退费',
                    id: 'layerDemo' + type,
                    area: ['490px', '460px'],
                    content: '<iframe src="expense/refundUI" frameborder="0" id="refundExpense" name="refundExpense" class="layadmin-iframe"></iframe>',
                    btn: ['确定', '取消'],
                    maxmin: true,
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        var flag = document.getElementById("refundExpense").contentWindow.refundControll();
                        if(flag == false)
                            return;

                        var refund_expense = window.frames["refundExpense"].document.getElementById('refund_expense').value;
                        var number = window.frames["refundExpense"].document.getElementById('number').value;
                        var expense_date = window.frames["refundExpense"].document.getElementById('expense_date').value;
                        var refund_number = window.frames["refundExpense"].document.getElementById('refund_number').value;
                        var pay_sign = "";
                        if(number == refund_number) {
                            number = 0;
                            pay_sign = "2";
                        }
                        else if(number > refund_number) {
                            number = number - refund_number;
                            pay_sign = "3";
                        }

                        var value = document.getElementById("none7").value.toUpperCase();
                        var expense = value - refund_expense;
                        var real_expense = value - refund_expense;

                        $.ajax({
                            type: "post",
                            url: "expense/refund",
                            data: {
                                "id": table[0].id,
                                "number": number,
                                "expense": expense,
                                "real_expense": real_expense,
                                "pay_sign": pay_sign,
                                "expense_date": expense_date
                            },
                            dataType: "JSON",
                            async: false,
                            beforeSend: function () {

                            },
                            success: function (data) {
                                if(data == 1) {
                                    alert("退费成功");
                                }
                                else
                                    alert("退费失败");
                            },
                            error: function () {
                                alert("error");
                            }
                        });
                        layui.table.reload('test-table-page',{page: {curr: 1}});
                        layer.closeAll();
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            }
        };

        $('#LAY-component-layer-special-demo .layadmin-layer-demo .layui-btn').on('click', function () {
            var othis = $(this),
                method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    })
        .use(['index'], function () {
            var $ = layui.$,
                admin = layui.admin,
                element = layui.element,
                router = layui.router();

            element.render();

            element.on('tab(component-tabs-brief)', function (obj) {
                layer.msg(obj.index + '：' + this.innerHTML);
            });

            /* 触发事件 */
            var active = {
                tabAdd: function () {
                    /* 新增一个Tab项 */
                    element.tabAdd('demo', {
                        title: '新选项' + (Math.random() * 1000 | 0) /* 用于演示 */ ,
                        content: '内容' + (Math.random() * 1000 | 0),
                        id: new Date().getTime() /* 实际使用一般是规定好的id，这里以时间戳模拟下 */
                    })
                },
                tabDelete: function (othis) {
                    /* 删除指定Tab项 */
                    element.tabDelete('demo', '22');
                    othis.addClass('layui-btn-disabled');
                },
                tabChange: function () {
                    /* 切换到指定Tab项 */
                    element.tabChange('demo', '33');
                }
            };

            $('#component-tabs .site-demo-active').on('click', function () {
                var othis = $(this),
                    type = othis.data('type');
                active[type] ? active[type].call(this, othis) : '';
            });

            /* Hash地址的定位 */
            var layid = router.hash.replace(/^#layid=/, '');
            layid && element.tabChange('component-tabs-hash', layid);

            element.on('tab(component-tabs-hash)', function (elem) {
                location.hash = '/' + layui.router().path.join('/') + '#layid=' + $(this).attr('lay-id');
            });
        }).use(['index', 'upload'], function () {
        var $ = layui.jquery,
            upload = layui.upload;


        //拖拽上传
        upload.render({
            elem: '#test-upload-drag',
            url: '/upload/',
            done: function (res) {
                console.log(res)
            }
        });


        //绑定原始文件域
        upload.render({
            elem: '#test-upload-primary',
            url: '/upload/',
            done: function (res) {
                console.log(res)
            }
        });

    }).use(['index', 'laydate'], function () {
        var laydate = layui.laydate;

        //示例代码

        //开始日期
        var insStart = laydate.render({
            elem: '#test-laydate-start',
            min: 0,
            done: function (value, date) {
                //更新结束日期的最小日期
                insEnd.config.min = lay.extend({}, date, {
                    month: date.month - 1
                });

                //自动弹出结束日期的选择器
                insEnd.config.elem[0].focus();
            }
        });

        //结束日期
        var insEnd = laydate.render({
            elem: '#test-laydate-end',
            min: 0,
            done: function (value, date) {
                //更新开始日期的最大日期
                insStart.config.max = lay.extend({}, date, {
                    month: date.month - 1
                });
            }
        });
    });
</script>

<script>
    layui.config({
        base: 'source/' //静态资源所在路径
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
            // layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

<!-- 选择输入框 -->
<script>
    layui.config({
        base: 'source/' //静态资源所在路径
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
            // layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laydate'], function () {
        var laydate = layui.laydate;


        //常规用法
        laydate.render({
            elem: '#test-laydate-normal-cn'
        });

        //国际版
        laydate.render({
            elem: '#test-laydate-normal-en',
            lang: 'en'
        });

        //年选择器
        laydate.render({
            elem: '#test-laydate-type-year',
            type: 'year'
        });

        //年月选择器
        laydate.render({
            elem: '#test-laydate-type-month',
            type: 'month'
        });

        //日期选择器
        laydate.render({
            elem: '#test-laydate-type-date'
            //,type: 'date' //type 默认为 date，所以可不填
        });

        //时间选择器
        laydate.render({
            elem: '#test-laydate-type-time',
            type: 'time'
        });

        //日期时间选择器
        laydate.render({
            elem: '#test-laydate-type-datetime',
            type: 'datetime'
        });

        //日期范围
        laydate.render({
            elem: '#test-laydate-range-date',
            range: true
        });

        //年范围
        laydate.render({
            elem: '#test-laydate-range-year',
            type: 'year',
            range: true
        });

        //年月范围
        laydate.render({
            elem: '#test-laydate-range-month',
            type: 'month',
            range: true
        });

        //时间范围
        laydate.render({
            elem: '#test-laydate-range-time',
            type: 'time',
            range: true
        });

        //日期时间范围
        laydate.render({
            elem: '#test-laydate-range-datetime',
            type: 'datetime',
            range: true
        });

        //自定义格式
        laydate.render({
            elem: '#test-laydate-format-date1',
            format: 'yyyy年MM月dd日'
        });
        laydate.render({
            elem: '#test-laydate-format-date2',
            format: 'dd/MM/yyyy'
        });
        laydate.render({
            elem: '#test-laydate-format-month',
            type: 'month',
            format: 'yyyyMM'
        });
        laydate.render({
            elem: '#test-laydate-format-time',
            type: 'time',
            format: 'H点m分'
        });
        laydate.render({
            elem: '#test-laydate-format-range1',
            range: '~'
        });
        laydate.render({
            elem: '#test-laydate-format-range2',
            type: 'datetime',
            range: '到',
            format: 'yyyy年M月d日H时m分s秒'
        });

        //同时绑定多个
        lay('.test-laydate-item').each(function () {
            laydate.render({
                elem: this,
                trigger: 'click'
            });
        });

    });
</script>


<!-- 开启头部工具栏 -->
<script>
    layui.config({
        base: 'source/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        table.render({
            elem: '#test-table-page'
            ,id: 'test-table-page'
            ,url: 'expense/list'
            // ,toolbar: '#test-table-toolbar-toolbarDemo'
            ,title: '收费数据表'
            ,method: 'get'
            ,parseData: function (res) {
                return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                }
            }
            ,cols: [
                [{
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                    field: 'expense_name',
                    title: '收费项名',
                    width: 100,
                    sort: true,
                    fixed: true
                }, {
                    field: 'expense_category',
                    title: '收费类别',
                    width: 100
                }, {
                    field: 'specifications',
                    title: '规格',
                    width: 100
                    // sort: true
                }, {
                    field: 'unit_price',
                    title: '单价/元',
                    width: 90
                }, {
                    field: 'number',
                    title: '数量',
                    width: 70
                }, {
                    field: 'unit',
                    title: '单位',
                    width: 100
                }, {
                    field: 'expense',
                    title: '应付金额/元',
                    width: 115
                }, {
                    field: 'real_expense',
                    title: '实付金额/元',
                    width: 115
                }, {
                    field: 'pay_category',
                    title: '付款方式',
                    width: 100
                }, {
                    field: 'pay_sign',
                    title: '付款标志',
                    templet:'#test-table-statusTpl',
                    width: 100
                }, {
                    field: 'day_settle_sign',
                    title: '日结状态',
                    width: 100
                }, {
                    field: 'date',
                    title: '操作日期'
                }]
            ],
            page: true
        });
    });
</script>

<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('test-table-page')
                    ,data = checkStatus.data;
                getInfo(data);
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.layui-row .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <div class="layui-row">
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md9">
                            <lable>收费</lable>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">


                            <!-- <button class="layui-btn" style="float: left;width: 45%;margin-top: 10px;margin-left: 100px;">挂号</button>

                       <button type="reset" class="layui-btn-warm"style="float: right;width: 15%;margin-top: 20px;">清空</button> -->
                        </div>


                    </div>

                </div>

                <!-- 表单 -->
                <div class="layui-card-body">


                    <form class="layui-form" method="post" lay-filter="component-form-element">

                        <div class="test-table-reload-btn" style="margin-bottom: 10px;">

                            <div class="layui-row" style="height: 50px;margin-bottom: 5px;">

                                <input style="display: none" id="none1">
                                <input style="display: none" id="none2">
                                <input style="display: none" id="none3">
                                <input style="display: none" id="none4">
                                <input style="display: none" id="none5">
                                <input style="display: none" id="none6">
                                <input style="display: none" id="none7">
                                <input style="display: none" id="none8">

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">病历号：
                                    </div>
                                    <input type="text" id="medical_record_no" name="title" placeholder="请输入病历号"
                                           autocomplete="off" class="layui-input" style="float: right;width: 70%;">
                                </div>
                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                                    <div class="layui-form-item" style="float: left;">
                                        <div class="layui-input-block">
                                            <button class="layui-btn" id="search" onclick="getSelect();getTotalExpense()">查询</button>
                                            <button type="reset" onclick="ValueReset();getTotalExpense()"
                                                    class="layui-btn layui-btn-primary">重置</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="layui-row" style="height: 50px;margin-bottom: 5px;">

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">姓名：</div>
                                    <input type="text" id="patient_name" name="title" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">

                                </div>

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">性别：</div>

                                    <input type="text" id="patient_gender" name="title" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">

                                </div>



                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left; width: 30%">年龄：</div>

                                    <div class="layui-input-inline" style="float: right;width: 70%;">
                                        <input type="text" id="patient_age" name="title" autocomplete="off"
                                               class="layui-input" style="width: 50%;float: left;" readonly="readonly">
                                        <div class="layui-card layui-form" lay-filter="component-form-element"
                                             style="width: 50%;float: right;">
                                            <select name="week" lay-verify="required" lay-search>

                                                <option value="01">岁</option>
                                                <option value="02">月</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">出生日期：
                                    </div>

                                    <div class="layui-inline" style="float: right;width: 70%;">
                                        <!-- <label class="layui-form-label">日期选择器</label> -->
                                        <div class="layui-input-inline" style="width: 100%">
                                            <input type="text" id="patient_birthday" class="layui-input"
                                                   id="test-laydate-type-date" readonly="readonly">
                                        </div>
                                    </div>

                                </div>

                            </div>

                            <div class="layui-row" style="height: 50px;">

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">身份证号：
                                    </div>

                                    <input type="text" id="patient_id_record" name="title" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">
                                </div>

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">结算类别：
                                    </div>

                                    <input type="text" name="title" id="settle_category" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">

                                </div>

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">医疗类别：
                                    </div>

                                    <input type="text" id="medical_category" name="title" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">

                                </div>

                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">看诊医生：
                                    </div>

                                    <input type="text" id="patient_doctor" name="title" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">

                                </div>

                            </div>

                            <div class="layui-row" style="height: 50px;">



                                <div class="layui-col-xs6 layui-col-sm6 layui-col-md3">
                                    <div style="text-align: right;margin-top: 5px;float: left;width: 30%;">看诊科室：
                                    </div>

                                    <input type="text" id="patient_department" name="title" autocomplete="off"
                                           class="layui-input" style="float: right;width: 70%;" readonly="readonly">

                                </div>

                            </div>


                        </div>

                    </form>
                </div>




                <div class="layui-row">
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md6" style="float: left;">
                        <div class="layui-card-body" style="margin-top: 0px;">
                            <table class="layui-hide" id="test-table-reload" lay-filter="user"></table>
                            <div class="layui-fluid" id="LAY-component-layer-special-demo">
                                <div class="layui-row" style="height: 30px;">
                                    <div class="layui-inline">
                                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md12"
                                             style="float: left;">
                                            <div class="layui-btn-container layadmin-layer-demo">

                                                <button data-method="pop_charges" data-type="getCheckData"
                                                        class="layui-btn layui-btn" lay-event=""
                                                        style="margin-top: 2%;float: left;">收费</button>
                                                <button data-method="pop_refund" data-type="getCheckData"
                                                        class="layui-btn layui-btn" lay-event=""
                                                        style="margin-top: 2%;float: right">退费</button>

                                            </div>
                                        </div>

                                    </div>

                                </div>

                            </div>
                        </div>


                    </div>
                    <div class="layui-col-xs6 layui-col-sm6 layui-col-md6" style="float: right;">
                        <div class="layui-row" style="float: right">
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md5"--%>
<%--                                 style="float: left;margin-top: 5%;">--%>
<%--                                <div style="float: left;width: 40%;">--%>
<%--                                    <p style="margin:10px;float: right;"> 已选金额: </p>--%>
<%--                                </div>--%>
<%--                                <div style="float: right;width:60%;">--%>
<%--                                    <input type="text" id="select_expense" value="0元" class="layui-input" name=""--%>
<%--                                           style="float: left;" readonly="true">--%>
<%--                                </div>--%>
<%--                            </div>--%>
                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10"
                                 style="margin-top: 10%;">
                                <div style="float: left;width: 40%;">
                                    <p style="margin:10px;float: right;"> 合计金额: </p>
                                </div>
                                <div style="float: right;width:60%;">
                                    <input type="text" id="all_expense" value="0元" class="layui-input" name=""
                                           style="float: left;" readonly="true">
                                </div>
                            </div>

                        </div>
                    </div>
                </div>



                <!-- 表格 -->
                <div class="layui-fluid" style="margin-top: 0px">
                    <div class="layui-row layui-col-space15">
                        <div class="layui-col-md12">
                            <div class="layui-card">

                                <div class="layui-card-body">
                                    <table class="layui-hide" id="test-table-page" lay-filter="test-table-page">
                                    </table>

                                    <script type="text/html" id="test-table-statusTpl">
                                        {{#  if(d.pay_sign == '未付款' || d.pay_sign == '已退款'){ }}
                                        <span style="color: #FF0000;">{{ d.pay_sign }}</span>
                                        {{#  } else if(d.pay_sign == '已付款' || d.pay_sign == '部分退款') { }}
                                        <span style="color: #05F936;">{{ d.pay_sign }}</span>

                                        {{#  } }}
                                    </script>



                                    <!-- <script type="text/html" id="test-table-toolbar-barDemo">
                                                  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                                                  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                                </script> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</body>
</html>
