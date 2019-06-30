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
    <title>退药</title>
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
                                <p class="layui-form-pane" style="width: 300px">退药明细信息</p>
                            </div>

                        </div>
                    </div>
                    <div style="vertical-align: middle;margin-top: 2%">
                        <p style="margin-right: 40%;margin-left: 40%;font-size: 150%;font-weight: 500">门诊退药单</p>
                    </div>
                    <hr class="layui-bg-black">
                    <div class="layui-row">
                        <form class="layui-form" action="" lay-filter="component-form-element">
                            <div class="layui-card layui-form" lay-filter="component-form-element">
                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                                    病历号：
                                </div>
                                <div class="layui-col-md2">
                                    <input type="text" class="layui-input" placeholder="请输入病历号">
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                                    患者姓名：
                                </div>
                                <div class="layui-col-md2">
                                    <input type="text" class="layui-input" placeholder="请输入患者姓名">
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 1%">
                                    患者性别：
                                </div>
                                <div class="layui-col-md2">
                                    <input type="checkbox" name="marriage" lay-skin="switch" lay-text="男|女">
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
                                    <input type="text" name="title" placeholder="年龄" autocomplete="off"
                                        class="layui-input" style="width: 50%;float: left;">
                                    <div class="layui-card layui-form" lay-filter="component-form-element"
                                        style="width: 50%;float: right;">
                                        <select name="week" lay-verify="required">
                                            <option value="01">岁</option>
                                            <option value="02">月</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    结算类别：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <select name="city" lay-verify="">
                                        <option value="">请选择结算类别</option>
                                        <option value="01">自费</option>
                                        <option value="02">2</option>
                                    </select>
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    就诊科室：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <select name="city" lay-verify="" lay-search>
                                        <option value="">请选择结算类别</option>
                                        <option value="01">自费</option>
                                        <option value="02">2</option>
                                    </select>
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    处方状态：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <select name="city" lay-verify="" lay-search>
                                        <option value="">请选择处方状态</option>
                                        <option value="01">1</option>
                                        <option value="02">2</option>
                                    </select>
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    收费日期：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <input type="text" class="layui-input" id="test-laydate-type-datetime"
                                        placeholder="yyyy-MM-dd">
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    农合卡号：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <input type="text" class="layui-input" placeholder="请输入农合卡号">
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    处方号：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <input type="text" class="layui-input" placeholder="请输入农合卡号">
                                </div>

                                <div class="layui-col-md1" style="font-size: 90%;margin-top: 2%">
                                    开单医生：
                                </div>
                                <div class="layui-col-md2" style="margin-top: 1%">
                                    <input type="text" class="layui-input" placeholder="请输入农合卡号">
                                </div>
                            </div>



                            <button type="reset" class="layui-btn layui-btn layui-btn-danger"
                                style="float: right;margin-top: 1%">清屏</button>
                        </form>
                    </div>
                    <hr class="layui-bg-black">
                    <div class="layui-card-header" style="height: 50px;">
                        退药明细信息
                        <div class="layui-btn-group" style="margin-left: 70%;">
                            <div class="layui-fluid" id="LAY-component-layer-special-demo">
                                <div class="layui-btn-container layadmin-layer-demo">
                                    <button data-method="tuiyao" class="layui-btn layui-btn-sm">退药</button>
                                    <button data-method="confirmTrans" class="layui-btn layui-btn-sm">全退</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-table-body">
                        <table class="layui-hide" id="test-table-simple"></table>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-md3">
            <!-- 右侧区域 -->
            <div class="layui-card-body">
                <div class="layui-card">
                    <div class="layui-card-header">
                        检索信息.
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
                                    <option value="">请选择XXX</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline" style="margin-top: 1%">
                            <div class="layui-input-inline" style="margin-left: 10px;margin-top: 1.5%">
                                病历/发票号：
                            </div>
                            <div class="layui-input-inline" style="float: right">
                                <input type="text" class="layui-input" placeholder="病历/发票号">
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
                        <div class="layui-inline">
                            <div class="layui-card layui-form" lay-filter="component-form-element"
                                style="margin-left: 20px">
                                <input type="radio" name="sex" value="nan" title="已退">
                                <input type="radio" name="sex" value="nv" title="未发" checked>
                                <input type="radio" name="sex" value="" title="已发">
                            </div>
                        </div>

                    </div>
                    <div class="layui-table-body">
                        <div class="layui-table-header">
                            写药列表
                        </div>
                        <table class="layui-hide" id="test-table-simple2"></table>

                    </div>


                </div>
            </div>
        </div>
    </div>

    <script src="department/layui/layui.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

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
                elem: '#test-table-simple',
                url: layui.setter.base + 'json/table/user.js',
                cellMinWidth: 80,
                cols: [
                    [{
                        type: 'checkbox',
                        fixed: 'left'
                    }, {
                        field: '',
                        width: 180,
                        title: '药品名称',
                        sort: true
                    }, {
                        field: '',
                        width: 80,
                        title: '规格'
                    }, {
                        field: '',
                        width: 80,
                        title: '数量',
                        sort: true
                    }, {
                        field: '',
                        width: 80,
                        title: '单位'
                    }, {
                        field: '',
                        title: '单价',
                        width: 80,

                    }, {
                        field: '',
                        title: '总金额',
                    }, {
                        field: '',
                        title: '厂家',
                    }]
                ]
            });
        });
    </script>
    <!-- 右侧数据表格 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'table'], function () {
            var table = layui.table;

            table.render({
                elem: '#test-table-simple2',
                url: layui.setter.base + 'json/table/user.js',
                cellMinWidth: 80,
                cols: [
                    [{
                        field: '',
                        width: 180,
                        title: '病历号',
                        sort: true
                    }, {
                        field: '',
                        width: 80,
                        title: '姓名'
                    }, {
                        field: '',
                        title: '发票号',
                    }]
                ]
            });
            var $ = layui.$,
                active = {
                    reload: function () {
                        var demoReload = $('#demoReload');

                        //执行重载
                        table.reload('testReload', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            },
                            where: {
                                key: {
                                    id: demoReload.val()
                                }
                            }
                        }, 'data');
                    }
                };

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

                        content: '<div class="layui-inline"><div class="layui-input-inline" style="width: 40%"> <label class="layui-form-label">药品名称: </label></div><div class="layui-input-inline" style="width: 50%"><input class="layui-input" placeholder="请输入药品名称" readonly></div></div><br><div class="layui-inline"><div class="layui-input-inline" style="width: 40%"><label class="layui-form-label">数量: </label></div><div class="layui-input-inline" style="width: 50%"><input class="layui-input" type="number" placeholder="请输入数量"></div></div>',
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
                    layer.closeAll();
                    layer.msg('是否删除所有选项', {
                        // time: 20 * 1000,
                        btn: ['确定', '取消'],
                        yes: function () {

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