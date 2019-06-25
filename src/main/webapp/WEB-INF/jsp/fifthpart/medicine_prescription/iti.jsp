<%@ page language="java" pageEncoding="UTF-8" %>
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
    <title>增药</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">

    <style>
        .layui-body {
            overflow-y: scroll;

        }
    </style>
    <style>
        .layui-select-title,
        .layui-form-select {
            top: -5px;
            height: 100%;
        }

        .layui-input.layui-unselect {
            /* border: 1; */
            height: 100%;
        }

        .layui-table-cell {
            overflow: initial;
        }

        .layui-unselect dl {
            max-height: 200px;
        }
    </style>
    <style>
        .layui-btn-best {
            height: 50px;
            width: 100%;
            line-height: 44px;
            padding: 0 25px;
            font-size: 16px
        }
    </style>
</head>

<body style="background-color: white">

<div class="layui-fluid" id="html1">

    <div class="layui-row">
        <div class="layui-col-md12">
            <div class="layui-fluid" id="LAY-component-layer-special-demo">

                <div class="layui-btn-container" style="float: right;">

                    <div class="layui-btn-group">
                        <div class="layui-btn-container layadmin-layer-demo">

                            <button data-method="add" class=" layui-btn layui-btn-xs layui-btn-normal"
                                    style="float: left;"><i class="layui-icon">&#xe654;</i>增药</button>

                            <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                    class="layui-icon">&#xe640;</i>删药</button>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <div class="layui-col-md12">
            <table class="layui-hide" id="test-table-checkbox1"></table>
        </div>

    </div>


</div>




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
    });
</script>

<!-- 门诊处方表格 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        // var table = layui.table;
        var $ = layui.jquery,
            layer = layui.layer //弹层
            ,
            form = layui.form //弹层
            ,
            table = layui.table //表格
            ,
            laydate = layui.laydate //日期控件
            ,
            tablePlug = layui.tablePlug //表格插件
            ,
            testTablePlug = layui.testTablePlug // 测试js模块
            ,
            renderFormSelectsIn = layui.renderFormSelectsIn // 针对form在特定场合下的渲染的封装
            ,
            formSelects = layui.formSelects; //多选下拉插件
        var fn1 = function (field) {
            return function (data) {
                // return data[field];
                var value = data[field];
                return [
                    '<select name="use" lay-filter="use_select" lay-search="true" value="' +
                    value + '" id = "use">',
                    '<option value="">请选择或搜索</option>',
                    '<option value="北京" ' + (value === ' 北京' ? 'selected' : '') +
                    '>北京</option>', '<option value="天津" ' +
                    (value === '天津' ? 'selected' : '') + '>天津</option>',
                    '<option value="上海" ' +
                    (value === '上海' ? 'selected' : '') +
                    '>上海</option>', '<option value="广州" ' + (value === '广州' ? 'selected' :
                        '') +
                    '>广州</option>', '<option value="深圳" ' + (value === '深圳' ? 'selected' :
                        '') +
                    '>深圳</option>', '<option value="佛山" ' +
                    (value === '佛山' ? 'selected' : '') + '>佛山</option>', '</select>'
                ].join('');
            };
        };
        var fn2 = function (field) {
            return function (data) {
                // return data[field];
                var value = data[field];
                return [
                    '<select name="use" lay-filter="use_select" lay-search="true" value="' +
                    value + '" id="use2">',
                    '<option value="">请选择或搜索</option>',
                    '<option value="北京" ' + (value === ' 北京' ? 'selected' : '') +
                    '>北京</option>', '<option value="天津" ' +
                    (value === '天津' ? 'selected' : '') + '>天津</option>',
                    '<option value="上海" ' +
                    (value === '上海' ?
                        'selected' : '') + '>上海</option>', '<option value="广州" ' + (value ===
                    '广州' ? 'selected' : '') +
                    '>广州</option>', '<option value="深圳" ' + (value === '深圳' ? 'selected' :
                        '') +
                    '>深圳</option>', '<option value="佛山" ' + (value === '佛山' ? 'selected' :
                        '') +
                    '>佛山</option>', '</select>'
                ].join('');
            };
        };
        table.render({
            elem: '#test-table-checkbox1',
            // url: layui.setter.base + 'json/table/user.js',
            height: 315,
            cols: [
                [{
                    type: 'checkbox'
                }, {
                    field: 'id',
                    width: 135,
                    title: '药品名称*',
                    sort: true,
                    edit: 'text'
                }, {
                    field: 'username',
                    width: 70,
                    title: '规格'
                }, {
                    field: 'sex',
                    width: 70,
                    title: '单价',
                    sort: true
                }, {
                    field: 'use',
                    width: 170,
                    title: '用法',
                    search: true,
                    edit: false,
                    type: 'normal',
                    templet: fn1('use')
                }, {
                    field: 'sign',
                    title: '用量*',
                    width: 70,
                    edit: 'text'
                }, {
                    field: 'experience',
                    width: 70,
                    title: '单位',
                    sort: true
                }, {
                    field: 'f',
                    width: 170,

                    title: '频次',
                    search: true,
                    edit: false,
                    type: 'normal',
                    templet: fn2('f')
                }, {
                    field: 'classify',
                    width: 70,
                    title: '天数*',
                    edit: 'text'
                }, {
                    field: 'wealth',
                    width: 70,
                    title: '次数',
                    sort: true
                }, {
                    field: 'wealth',
                    width: 80,
                    title: '数量*',
                    edit: 'text'
                }, {
                    field: 'wealth',
                    width: 70,
                    title: '皮试'
                }, {
                    field: 'wealth',
                    width: 100,
                    title: '皮试结果'
                }, {
                    field: 'wealth',
                    width: 70,
                    title: '自购'
                }, {
                    field: 'wealth',
                    title: '用药嘱托'
                }]
            ],
            data: [{
                "id": "10001",
                "username": "MDL",
                "sex": "男"

            }],
            page: true

        });
        form.on('select(use_select)', function (data) {
            var selectElem = $(data.elem);
            var tdElem = selectElem.closest('td');
            var trElem = tdElem.closest('tr');
            var tableView = trElem.closest('.layui-table-view');
            table.cache[tableView.attr('lay-id')][trElem.data('index')][tdElem.data('field')] =
                data
                    .value;
        });

    });
</script>
<!-- 弹窗模块 -->
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


            add: function () {
                var that = this;
                layer.open({
                    type: 1,
                    title: '添加药品',
                    area: ['450px', '350px'],
                    shade: 0,
                    maxmin: true,

                    content: '<iframe src="add.html" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
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