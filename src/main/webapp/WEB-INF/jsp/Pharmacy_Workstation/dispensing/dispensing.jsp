<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>"/>
<html>

<head>
    <meta charset="utf-8">
    <title>发药</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">


</head>

<body>

<div class="layui-row">
    <div class="layui-col-md9">
        <!-- 左侧区域 -->
        <div class="layui-card-body">
            <div class="layui-card">
                <div class="layui-card-header">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <p class="layui-form-pane" style="width: 300px">发药明细信息</p>
                        </div>

                    </div>
                </div>
                <div style="vertical-align: middle;margin-top: 2%">
                    <p style="margin-right: 40%;margin-left: 40%;font-size: 150%;font-weight: 500">门诊发药单</p>
                </div>
                <hr class="layui-bg-black">
                <div class="layui-row">
                    <div class="layui-card layui-form" lay-filter="component-form-element">
                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            病历号：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" id="medical_record_no" class="layui-input" placeholder="请输入病历号" readonly>
                        </div>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            患者姓名：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" id="patient_name" class="layui-input" placeholder="请输入患者姓名" readonly>
                        </div>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                            患者性别：
                        </div>
                        <div class="layui-col-md2">
                            <input type="text" id="gender" class="layui-input" placeholder="性别" readonly>
<%--                            <input type="checkbox" name="marriage" lay-skin="switch" lay-text="男|女">--%>
                            <!-- <select name="city" lay-verify="">
                                    <option value="">请选择性别</option>
                                    <option value="01">男</option>
                                    <option value="02">女</option>
                                </select> -->

                        </div>
                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%;">
                            患者年龄：
                        </div>
                        <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                            <input type="text"  id="age" placeholder="年龄" autocomplete="off" class="layui-input"
                                   style="width: 50%;float: left;" readonly>
                            <div class="layui-card layui-form" lay-filter="component-form-element"
                                 style="width: 50%;float: right;">
                                <select name="week" lay-verify="required">
                                    <option value="01">岁</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                            结算类别：
<%--                            挂号表里的settle_accounts_category--%>
                        </div>
                        <div class="layui-col-md2" style="margin-top: 1%">
<%--                            <select name="city" lay-verify="">--%>
<%--                                <option value="">请选择结算类别</option>--%>
<%--                                <option value="01">自费</option>--%>
<%--                                <option value="02">2</option>--%>
<%--                            </select>--%>
                            <input type="text" id="settle_accounts_category" class="layui-input" placeholder="结算类别" readonly>
                        </div>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                            就诊科室：
                        </div>
                        <div class="layui-col-md2" style="margin-top: 1%">
<%--                            <select name="city" lay-verify="" lay-search>--%>
<%--                                <option value="">请选择结算类别</option>--%>
<%--                                <option value="01">自费</option>--%>
<%--                                <option value="02">2</option>--%>
<%--                            </select>--%>
                            <input type="text" id="department_id" class="layui-input" placeholder="就诊科室" readonly>
                        </div>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                            收费日期：
<%--                            对应挂号表里面的日期--%>
                        </div>
                        <div class="layui-col-md2" style="margin-top: 1%">
                            <input type="text" id="date" class="layui-input" placeholder="收费时间" readonly>
                        </div>

<%--                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">--%>
<%--                            处方号：--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-md2" style="margin-top: 1%">--%>
<%--                            <input type="text" class="layui-input" placeholder="处方号">--%>
<%--                        </div>--%>

                        <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                            开单医生：
                        </div>
                        <div class="layui-col-md2" style="margin-top: 1%">
                            <input type="text" id="doctor_id" class="layui-input" placeholder="医生id" readonly>
                        </div>
                    </div>

                </div>
                <hr class="layui-bg-black">
                <div class="layui-card-header" style="height: 50px;">
                    发药明细信息
                    <div class="layui-btn-group" style="margin-left: 70%;">
                        <div class="layui-fluid" id="LAY-component-layer-special-demo">
                            <div class="layui-btn-container layadmin-layer-demo">
                                <button data-method="confirmTrans" class="layui-btn layui-btn-sm">发药</button>
                                <button class="layui-btn layui-btn-sm">打印</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="layui-table-body">
                    <table class="layui-hide" id="test-table-simple"></table>
                    <script type="text/html" id="test-table-statusTpl">
                        {{#  if(d.dispensestatus == 0){ }}
                        <span style="color: #000000;">{{ "未发药"}}</span>
                        {{#  } else if(d.dispensestatus == 1) { }}
                        <span style="color: #05F936;">{{ "已发药" }}</span>
                        {{#  } else if(d.dispensestatus == 2) { }}
                        <span style="color: #FF0000;">{{ "已退药" }}</span>
                        {{#  } }}
                    </script>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-col-md3">
        <!-- 右侧区域 -->
        <div class="layui-card-body">
            <div class="layui-card">
                <div class="test-table-reload-btn">
                <div class="layui-card-header">
                    检索信息
                    <button data-type="reload" class="layui-btn layui-btn-sm"
                            style="float: right;margin-top: 2%">
                        检索
                    </button>

                </div>
                <hr class="layui-bg-black">
                <div class="layui-card layui-form" lay-filter="component-form-element">
                    <div class="layui-inline" style="margin-top: 1%">
                        <div class="layui-input-inline" style="margin-left: 10px;margin-top: 1.5%">
                            发药药房：
                        </div>
                        <div class="layui-input-inline" style="float: right;width: 64%">
                            <select name="" lay-verify="" lay-search>
                                <option value="">药房</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline" style="margin-top: 1%">
                        <div class="layui-input-inline" style="margin-left: 10px;margin-top: 1.5%">
                            病历号：
                        </div>
                        <div class="layui-input-inline" style="float: right">
                            <input type="text" id="preid" class="layui-input" placeholder="病历号" >
                        </div>
                    </div>

                    <div class="layui-inline" style="margin-top: 1%">
                        <div class="layui-input-inline" style="margin-left: 10px;margin-top: 1.5%">
                            收费日期：
                        </div>
                        <div class="layui-input-inline" style="float: right;">
                            <input type="text" class="layui-input" id="test-laydate-type-date"
                                   placeholder="yyyy-MM-dd" style="width: 100%">
                        </div>
                    </div>
                    <form id="dispensestatus">
                        <div class="layui-inline">
                            <div class="layui-card layui-form" lay-filter="component-form-element"
                                 style="margin-left: 20px">
                                <input type="radio" name="status" value="0" title="未发" checked>
                                <input type="radio" name="status" value="1" title="已发">
                                <input type="radio" name="status" value="2" title="已退">
                            </div>
                        </div>
                    </form>
                </div>
                </div>
                <br>
                <div class="layui-table-body">
                    <div class="test-table-reload-btn2">
<%--                    <div class="layui-table-header">--%>
                        <div class="layui-card-header">

                        发药列表：
                            <button data-type="reload" class="layui-btn layui-btn-sm"
                                    style="float: right;margin-top: 2%">
                                确定
                            </button>
                    </div>
                    <table class="layui-hide" id="test-table-simple2"></table>

                </div>
                </div>





            </div>
        </div>
    </div>
</div>

<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="department/layui/layui.js"></script>

    <!-- form -->
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
        });
    </script>
    <!-- 时间 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'laydate'], function () {
            var laydate = layui.laydate;


        //日期时间选择器
        laydate.render({
            elem: '#test-laydate-type-datetime',
            type: 'datetime'
        });
        //日期选择器
        laydate.render({
            elem: '#test-laydate-type-date',

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

    <!-- 左侧数据表格 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'table'], function () {
            var table = layui.table;

        table.render({
            elem: '#test-table-simple'
            // url: layui.setter.base + 'json/table/user.js',
            ,url:'drugstore/getDispenselog'
            ,toolbar: '#test-table-toolbar-toolbarDemo'
            ,title:"门诊发药单"
            ,method:'get'
                ,parseData:function (res) {
                return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                }
            },
            cols: [
                [
                    {
                    field: 'medicinename',
                    width: 180,
                    title: '药品名称',
                    sort: true
                }, {
                    field: 'format',
                    width: 115,
                    title: '规格'
                }, {
                    field: 'amount',
                    width: 110,
                    title: '数量'
                }, {
                    field: 'unit',
                    width: 120,
                    title: '单位'
                }, {
                    field: 'price',
                    title: '单价',
                    width: 110

                }, {
                    field: 'manufacturer',
                    width: 200,
                    title: '厂家'
                },{
                    field: 'dispensestatus',
                    width: 130,
                    templet:'#test-table-statusTpl',
                    title: '发药状态'
                }]
            ],page: true
        });

            // 搜索函数X
            var $ = layui.$, active = {
                reload: function () {
                    var tabledata=layui.table.checkStatus('test-table-simple2').data;
                    var medicalrecordno = tabledata[0].medicalrecordid;//用病历号查相应的值
                    //执行重载
                    table.reload('test-table-simple', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            medicalrecordno: medicalrecordno
                        }
                    },'data');

                    //做中间上面部分表格的重载
                    var logs = null;
                    $.ajax({
                        type: "GET",//方法类型
                        url: "drugstore/getRegistInfo?medicalrecordno="+medicalrecordno,//url
                        async: false,
                        success: function (result) {
                            // if (result.status == 0) {
                            //     logs= result.data;
                                var num = result[0];
                                var name = result[1];
                                var gender = result[2];
                                var age = result[3];
                                var settle = result[4];
                                var department = result[5];
                                var time = result[6];
                                var doctor = result[7];
                                $("#medical_record_no").empty();
                                $("#patient_name").empty();
                                $("#gender").empty();
                                $("#age").empty();
                                $("#settle_accounts_category").empty();
                                $("#department_id").empty();
                                $("#date").empty();
                                $("#doctor_id").empty();
                                // document.getElementById("medical_record_no").setAttribute("value",logs.medical_record_no);
                                // document.getElementById("patient_name").setAttribute("value",logs.patient_name);
                                // document.getElementById("gender").setAttribute("value",logs.gender) ;
                                // document.getElementById("age").setAttribute("value",logs.age) ;
                                // document.getElementById("settle_accounts_category").setAttribute("value",logs.settle_accounts_category) ;
                                // document.getElementById("department_id").setAttribute("value",logs.department_id);
                                //
                                document.getElementById("medical_record_no").setAttribute("value",num);
                                document.getElementById("patient_name").setAttribute("value",name);
                                document.getElementById("gender").setAttribute("value",gender) ;
                                document.getElementById("age").setAttribute("value",age) ;
                                document.getElementById("settle_accounts_category").setAttribute("value",settle) ;
                                document.getElementById("department_id").setAttribute("value",department);
                                // var month=0;
                                // var day=0;
                                // var date=new Date(logs.registration_date);
                                // if((date.getMonth()+1)>=10)
                                // {
                                //     month=date.getMonth()+1;
                                // }else
                                // {
                                //     month="0"+(date.getMonth()+1);
                                // }
                                // if(date.getDate()>=10)
                                // {
                                //     day=date.getDate();
                                // }else {
                                //     day="0"+date.getDate();
                                // }
                                // var setDate=date.getFullYear()+"-"+month+"-"+day;
                                // document.getElementById("date").setAttribute("value",setDate);
                                // document.getElementById("doctor_id").setAttribute("value",logs.doctor_id) ;

                                document.getElementById("date").setAttribute("value",time);
                                document.getElementById("doctor_id").setAttribute("value",doctor) ;
                        },
                        error: function (result) {
                            alert(result.msg);
                        }
                    });

                }
            };

            $('.test-table-reload-btn2 .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
    });
</script>
<!-- 右侧数据表格 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径X
    })
        .extend({
            index: 'lib/index' //主入口模块X
        })
        .use(['index', 'table'], function(){
            var table = layui.table;

            //方法级渲染
            table.render({
                elem: '#test-table-simple2'
                // 这部分url你们自己填你们部署的接口********************************************************************************************
                // ,url: layui.setter.base + 'data/table/nei.js'
                ,url: 'drugstore/getDispensing'
                ,method:'get'
                ,parseData:function (res) {
                    return {
                        "code":res.status,
                        "msg":res.message,
                        "count":res.total,
                        "data":res.data
                    }
                }
                ,cols: [
                    [
                        {checkbox: true, fixed: true},{
                        field: 'medicalrecordid',
                        width: 127,
                        title: '病历号',
                        sort: true
                    }, {
                        field: 'patientname',
                        width: 120,
                        title: '姓名'
                    }]
                ],page:true
            });


            // 搜索函数X
            var $ = layui.$, active = {
                reload: function () {
                    var preid = $('#preid');
                    var today = $('#test-laydate-type-date');
                    var radionum = document.getElementById("dispensestatus").status;
                    for (var i = 0; i < radionum.length; i++) {
                        if (radionum[i].checked) {
                            status = radionum[i].value;
                        }
                    }
                    //执行重载
                    table.reload('test-table-simple2', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            preid: preid.val(),
                            today: today.val(),
                            statu: status
                        }
                    },'data');
                }
            };

            $('.test-table-reload-btn .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

    });
</script>

    <!-- 弹出层 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index'], function () {
            var $ = layui.$,
                admin = layui.admin,
                element = layui.element,
                router = layui.router();

        element.render();

        var active = {
            tuiyao: function () {
                var that = this;
                layer.open({
                    type: 1,
                    title: '退药',
                    area: ['300px', '200px'],
                    shade: 0,
                    maxmin: true,

                    content: '',
                    btn: ['继续弹出', '全部关闭'],
                    yes: function () {
                        $(that).click();
                    },
                    btn2: function () {
                        layer.closeAll();
                    }

                    ,
                    zIndex: layer.zIndex,
                    success: function (layero) {
                        layer.setTop(layero);
                    }
                });
            },
            confirmTrans: function () {
                var tabledata = layui.table.cache['test-table-simple'];
                if (tabledata[0].dispensestatus != 0) {
                    alert("药品已发或者已退！");
                    return;
                }
                var medicineids = new Array();
                var amounts = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    medicineids.push(tabledata[i].medicineid);
                    amounts.push(tabledata[i].amount);
                }
                layer.closeAll();
                layer.msg('是否发放药品？', {
                    // time: 20 * 1000,
                    btn: ['确定', '取消'],
                    yes: function () {

                        var recordid = tabledata[0].medicalrecordno;
                        //TODO:加上修改药品库存的ajax
                        $.ajax({
                            type: "POST",
                            url: "drugstore/changestatus?medicalrecordno=" + recordid + "&status=1",//将状态改为已发的1
                            success: function (res) {
                                if (res.status == 0) {
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                    layui.table.reload('test-table-simple');
                                }, 100);
                                layer.closeAll();
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        }); //ajax结束
                        //将库存数量减少
                        $.ajax({
                            type: "POST",
                            url: "drugstore/dispensenall?medicineids="+medicineids+"&amounts="+amounts,
                            success: function (res) {
                                if (res.status == 0) {
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                    layui.table.reload('test-table-simple');
                                }, 100);
                                layer.closeAll();
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        }); //ajax结束
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            },


        };

        $('#LAY-component-layer-special-demo .layadmin-layer-demo .layui-btn').on('click', function () {
            var othis = $(this),
                method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
</script>
</body>

</html>