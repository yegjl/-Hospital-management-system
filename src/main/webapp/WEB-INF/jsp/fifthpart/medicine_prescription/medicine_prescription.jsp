<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>门诊病历首页</title>
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
            border: 1px;
            height: 100%;
        }

        .layui-table-cell {
            overflow: initial;
        }

        .layui-unselect dl {
            max-height: 200px;
        }
    </style>

</head>



<body>
<div class="layui-row">
    <div class="layui-col-md12">
        <div class="layui-card">
            <div class="layui-col-md2">
                <p>门诊诊断</p>
            </div>
            <div class="layui-col-md2">
                【{msg}】<a href="">{msg}</a>
            </div>
            <div class="layui-col-md8">
                <button class="layui-btn-sm" style="float: right;margin-right: 20%;">编辑</button>
            </div>

        </div>
    </div>
    <div class="layui-col-md12">
        <div class="layui-card">
            <div class="layui-col-md4">
                <p style="float: left;">门诊处方</p>
            </div>
            <div class="layui-col-md4">
                <div class=" layui-btn-container" style="float: left;margin: auto;">
                    <div class="layui-btn-group">
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#xe654;</i>增方</button>
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#xe640;</i>删方</button>
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#xe605;</i>保存</button>
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#xe609;</i>发送</button>
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#x1006;</i>作废</button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4">
                <div class="layui-btn-container" style="float: left;">
                    <div class="layui-btn-group">
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#xe654;</i>增药</button>
                        <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                class="layui-icon">&#xe640;</i>删药</button>
                    </div>
                </div>
            </div>
        </div>
        <hr class="layui-bg-black">
    </div>
    <!-- 左上部分 -->
    <div class="layui-col-md2" style="height: 50%">
        <div class="layui-btn-group">
            <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                    class="layui-icon">&#xe63c;</i>复制</button>
            <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;margin-left: 1%;"><i
                    class="layui-icon">&#xe60a;</i>粘贴</button>
        </div>
    </div>
    <!-- 右上部分 -->
    <div class="layui-col-md10" style="height: 50%">
        <div class="layui-col-md12">
            <div style="float: left;">

                <div class="layui-col-md5">
                    <%--                        <form class="layui-form" action="" lay-filter="component-form-element">--%>

                    <label class="layui-form-label">技术工种：</label>
                    <div class="layui-input-block" style="width: 60%;bottom: -8px;position: relative;">
                        <select name="type" lay-verify="required" lay-filter="aihao"
                                style="bottom: 0px;position: relative;width: 66%;">
                            <option value=""></option>
                            <option value="0">普通</option>
                            <option value="1">专家</option>
                            <option value="2">急诊</option>
                        </select>
                    </div>

                    <%--                        </form>--%>
                </div>
                <div class="layui-col-md6" style="margin-left: 2%;">

                    <label class="layui-form-label">处方金额：</label>
                    <div class="layui-input-block">
                        <p style="font-size: 150%;color: red;align-content: center;margin-top: 2%">{msg}</p>
                    </div>

                </div>


                <p> </p>
            </div>

        </div>
        <div class="layui-col-md12">
            <table class="layui-hide" id="test-table-checkbox1"></table>
        </div>
    </div>
    <div class="layui-col-md12" style="float: left;height: 60%;">
        <div class="layui-card">
            <div class="layui-card-body">
                <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                    <ul class="layui-tab-title">
                        <li class="layui-this">处方模板</li>
                        <li>常用药品</li>
                        <li>建议方案</li>
                        <li>商品管理</li>
                        <li>历史处方</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <div class="layui-row">
                                <div class="layui-col-md4">
                                    <div class="layui-col-md12" style="height: 50px;">
                                        <div style="float: left">
                                            <label style="font-size: 150%">处方模板列表</label>
                                        </div>
                                        <div style="float: right">
                                            <div class="layui-form-item">
                                                <div class="layui-input-block">
                                                    <input type="radio" name="role" value="" title="全院" checked>全院
                                                    <input type="radio" name="role" value="" title="科室">科室
                                                    <input type="radio" name="role" value="" title="个人">个人
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="layui-bg-green">
                                    <div class="layui-col-md12">
                                        <table class="layui-hide" id="test-table-radio"
                                               lay-filter="test-table-radio"></table>
                                    </div>
                                </div>
                                <div class="layui-col-md8">
                                    <div class="layui-col-md12" style="height: 50px;">
                                        <div style="float: left;position: relative;left: 20px;">
                                            <label style="font-size: 150%">模板明细</label>
                                        </div>
                                        <div style="float: right">
                                            <div class="layui-form-item">
                                                <div class="layui-input-block">
                                                    <button class="layui-btn layui-btn-xs layui-btn-normal"><i
                                                            class="layui-icon">&#xe605;确认</i></button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="layui-bg-green">
                                    <div class="layui-col-md11" style="margin-left: 20px;">
                                        <table class="layui-hide" id="test-table-checkbox4"></table>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="layui-tab-item">
                            <div class="layui-btn-group">
                                <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                        style="float: left">诊断11231231312331321</button>
                                <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                        class="layui-icon layui-icon-delete"></i></button>
                            </div>

                            <div class="layui-btn-group">
                                <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                        style="float: left">诊断1</button>
                                <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                        class="layui-icon layui-icon-delete"></i></button>
                            </div>

                            <div class="layui-btn-group">
                                <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                        style="float: left">诊断1</button>
                                <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                        class="layui-icon layui-icon-delete"></i></button>
                            </div>

                            <div class="layui-btn-group">
                                <button class=" layui-btn layui-btn-primary layui-btn-xs"
                                        style="float: left">诊断1</button>
                                <button type="button" class="layui-btn layui-btn-danger layui-btn-xs"><i
                                        class="layui-icon layui-icon-delete"></i></button>
                            </div>
                        </div>
                        <div class="layui-tab-item">内容3</div>
                        <div class="layui-tab-item">内容4</div>
                        <div class="layui-tab-item">内容5</div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="js/jquery.min.js"></script>
<script src="department/layui/layui.js?t=1"></script>

<!-- 下拉框模块加载 -->
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
        //口服、皮下注射、肌肉注射、静脉注射、静脉滴注、外用、喷雾吸入、肛门塞入
        var fn1 = function (field) {
            return function (data) {
                // return data[field];
                var value = data[field];
                return [
                    '<select name="use" lay-filter="use_select" lay-search="true" value="' +
                    value + '" id = "use">',
                    '<option value="">请选择或搜索</option>',
                    '<option value="口服" ' + (value === ' 口服' ? 'selected' : '') +
                    '>口服</option>', '<option value="皮下注射" ' +
                    (value === '皮下注射' ? 'selected' : '') + '>皮下注射</option>', '<option value="肌肉注射" ' +
                    (value === '肌肉注射' ? 'selected' : '') +
                    '>肌肉注射</option>', '<option value="静脉注射" ' + (value === '静脉注射' ? 'selected' : '') +
                    '>静脉注射</option>', '<option value="静脉滴注" ' + (value === '静脉滴注' ? 'selected' : '') +
                    '>静脉滴注</option>', '<option value="外用" ' + (value === '外用' ? 'selected' : '') +
                    '>外用</option>', '<option value="喷雾吸入" ' + (value === '喷雾吸入' ? 'selected' : '') +
                    '>喷雾吸入</option>', '<option value="肛门塞入" ' +
                    (value === '外用' ? 'selected' : '') + '>肛门塞入</option>', '</select>'
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
                    '<option value="口服" ' + (value === ' 口服' ? 'selected' : '') +
                    '>口服</option>', '<option value="皮下注射" ' +
                    (value === '皮下注射' ? 'selected' : '') + '>皮下注射</option>', '<option value="肌肉注射" ' +
                    (value === '肌肉注射' ?
                        'selected' : '') + '>肌肉注射</option>', '<option value="静脉注射" ' + (value ===
                    '静脉注射' ? 'selected' : '') +
                    '>静脉注射</option>', '<option value="静脉滴注" ' + (value === '静脉滴注' ? 'selected' : '') +
                    '>静脉滴注</option>', '<option value="外用" ' + (value === '外用' ? 'selected' : '') +
                    '>外用</option>','<option value="喷雾吸入" ' + (value === '喷雾吸入' ? 'selected' : '') +
                    '>喷雾吸入</option>','<option value="肛门塞入" ' + (value === '肛门塞入' ? 'selected' : '') +
                    '>肛门塞入</option>','</select>'
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
                    title: '单位'
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
            table.cache[tableView.attr('lay-id')][trElem.data('index')][tdElem.data('field')] = data
                .value;
        });

    });
</script>
<!-- 左下单选框表格 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-radio',
            url: layui.setter.base + '/json/table/user.js',
            // toolbar: '#test-table-radio-toolbarDemo',
            cols: [
                [{
                    type: 'radio'
                }, {
                    field: 'id',
                    width: 40,
                    title: 'ID',
                    sort: true
                }, {
                    field: 'name',
                    // width: 80,
                    title: '名称'
                }]
            ],
            page: true
        });

        //头工具栏事件
        table.on('toolbar(test-table-radio)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data; //获取选中行数据
                    layer.alert(JSON.stringify(data));
                    break;
            };
        });

    });
</script>
<!-- 右下复选框布局表格 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        table.render({
            elem: '#test-table-checkbox4',
            url: layui.setter.base + 'json/table/user.js',
            cols: [
                [{
                    type: 'checkbox'
                }, {
                    field: 'id',
                    width: 80,
                    title: 'ID',
                    sort: true
                }, {
                    field: 'username',
                    width: 80,
                    title: '药瓶名称'
                }, {
                    field: 'sex',
                    width: 80,
                    title: '规格',
                    sort: true
                }, {
                    field: 'city',
                    width: 80,
                    title: '用法'
                }, {
                    field: 'sign',
                    title: '用量',
                    minWidth: 100
                }, {
                    field: 'experience',
                    width: 80,
                    title: '单位',
                    sort: true
                }, {
                    field: 'score',
                    width: 80,
                    title: '频次',
                    sort: true
                }]
            ],
            page: true
        });

    });
</script>
<!-- 下方选项卡模块加载 -->
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

        element.on('tab(component-tabs-brief)', function (obj) {
            // layer.msg(obj.index + '：' + this.innerHTML);
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
                element.tabChange('demo', '44');
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
            location.hash = '/' + layui.router().path.join('/') + '#layid=' + $(this).attr(
                'lay-id');
        });
    });
</script>
<!-- 表单元素模块加载 -->
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

</body>

</html>