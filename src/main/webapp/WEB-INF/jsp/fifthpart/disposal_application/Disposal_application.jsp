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
    <title>门诊病历首页</title>
    <!-- <meta name="renderer" content="webkit"> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">

    <style>
        .layui-body {
            overflow-y: scroll;
        }
    </style>
</head>


<body>
<div class="layui-fluid">

    <div class="layui-row">
        <div class="layui-col-md8">
            <!-- 左大半部分 -->
            <div class="layui-card">
                <div class="layui-row">
                    <div class="layui-col-md12" style="height: 40%;">
                        <div class="layui-card" style="margin-top: 1%;">
                            <p style="float: left;">申请单列表</p>
                            <div class="layui-btn-container" style="float: right">
                                <button class="layui-btn layui-btn-xs layui-btn-normal">新增申请</button>
                                <button class="layui-btn layui-btn-xs layui-btn-normal">删除申请</button>
                                <button class="layui-btn layui-btn-xs layui-btn-normal">暂存</button>
                                <button class="layui-btn layui-btn-xs layui-btn-normal">开立</button>
                                <button class="layui-btn layui-btn-xs layui-btn-normal">作废</button>
                                <button class="layui-btn layui-btn-xs layui-btn-normal">存为模板</button>
                            </div>
                            <div class="layui-col-md12">
                                <!-- 申请单号表格 -->
                                <table class="layui-hide" id="test-table-radio1" lay-filter="test-table-radio">
                                </table>
                            </div>
                        </div>
                    </div>
                    <hr class="layui-bg-green">

                    <div class="layui-col-md5" style="height: 60%;">
                        <div class="layui-card">
                            <p style="float: left;">项目列表列表</p>
                            <!-- 项目列表表格 -->
                            <div class="layui-col-md12">
                                <table class="layui-hide" id="test-table-radio2" lay-filter="test-table-radio">
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md7" style="height: 40%;">
                        <div class="layui-col-md11" style="margin-left: 1%;">
                            <table class="layui-hide" id="test-table-radio3" lay-filter="test-table-radio">
                            </table>
                        </div>
                    </div>
                    <div class="layui-col-md5" style="height: 20%;">
                        <p>执行科室：</p>
                        <p></p><br>
                        <p>样本/部位：</p>
                        <p></p><br>
                        <p>项目价格：</p>
                        <p></p><br>
                    </div>

                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <!-- 右小部分 -->

            <div class="layui-card" style="margin-left: 2%">
                <div class="layui-card-body" style="height:100%;">
                    <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                        <ul class="layui-tab-title">
                            <li class="layui-this">常用部分</li>
                            <li>处置模板</li>
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <div class="layui-inline">


                                    <div class="layui-btn-group">
                                        <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                                style="float: left;margin-top: 1%;">诊断
                                        </button>
                                        <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>
                                    </div>

                                    <div class="layui-btn-group">
                                        <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                                style="float: left;margin-top: 1%;">诊断
                                        </button>
                                        <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>
                                    </div>
                                    <div class="layui-btn-group">
                                        <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                                style="float: left;margin-top: 1%;">诊断
                                        </button>
                                        <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>
                                    </div>
                                    <div class="layui-btn-group">
                                        <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                                style="float: left;margin-top: 1%;">诊断
                                        </button>
                                        <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>
                                    </div>
                                    <div class="layui-btn-group">
                                        <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                                style="float: left;margin-top: 1%;">诊断
                                        </button>
                                        <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-tab-item">

                                处置模板
                                <!-- 处置模板 -->
                            </div>


                        </div>
                    </div>
                </div>
            </div>


        </div>

    </div>
</div>

<script src="../../../layuiadmin/layui/layui.js?t=1"></script>


<!-- 申请单号数据表格 -->
<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-radio1',
            url: layui.setter.base + '/json/table/user.js',
            cols: [
                [{
                    type: 'radio'
                }, {
                    field: 'id',
                    width: 180,
                    title: '申请单号',
                    sort: true
                }, {
                    field: '',
                    width: 180,
                    title: '申请时间'
                }, {
                    field: '',
                    width: 100,
                    title: '状态',
                    sort: true
                }, {
                    field: '',
                    width: 100,
                    title: '城市申请人'
                }, {
                    field: '',
                    title: '收费状态',
                    width: 100
                }, {
                    field: '',
                    width: 100,
                    title: '执行状态',
                    sort: true
                }]
            ],
            page: true
        });

    });
</script>

<!-- 项目列表表格 -->
<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-radio2',
            url: layui.setter.base + '/json/table/user.js',
            cols: [
                [{
                    type: 'radio'
                }, {
                    field: 'id',
                    // width: 180,
                    title: '项目名称',
                    sort: true
                }]
            ],
            page: true
        });


    });
</script>

<!-- 项目数据表格 -->
<script>
    layui.config({
        base: '../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-radio3',
            url: layui.setter.base + '/json/table/user.js',
            cols: [
                [{
                    type: 'radio'
                }, {
                    field: 'id',
                    width: 80,
                    title: '类别',
                    sort: true
                }, {
                    field: 'id',
                    width: 100,
                    title: '通用名'
                }, {
                    field: 'id',
                    width: 80,
                    title: '价格'
                }, {
                    field: 'id',
                    width: 80,
                    title: '库存剩余'
                }, {
                    field: 'id',
                    width: 80,
                    title: '执行科室'
                }]
            ],
            page: true
        });


    });
</script>

</body>

</html>