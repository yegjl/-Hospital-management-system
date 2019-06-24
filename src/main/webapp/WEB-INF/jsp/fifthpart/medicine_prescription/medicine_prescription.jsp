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
    <title>门诊病历首页</title>
    <!-- <meta name="renderer" content="webkit"> -->
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

        .threed {
            color: transparent;
            background-color: black;
            text-shadow: rgba(255, 255, 255, 0.5) 0 5px 6px, rgba(255, 255, 255, 0.2) 1px 3px 3px;
            -webkit-background-clip: text;
        }
    </style>

</head>



<body class="layui-layout-body" style="background-color: white">
<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">

        <div class="layui-row">
            <!-- <div class="layui-col-md12">
                <div class="layui-card" style="height: 35px;">
                    <div class="layui-card-body" style="height: 35px;">
                        <div class="layui-col-md1">
                            <p>门诊诊断</p>
                            <hr class="layui-bg-black">
                        </div>
                        <div class="layui-col-md1">
                            【{msg}】<a href="">{msg}</a>
                        </div>
                        <div class="layui-col-md1">
                            <button class="layui-btn layui-btn-xs layui-btn-normal"
                                style="float: right;margin-right: 20%;">编辑</button>
                        </div>
                        <div class="layui-col-md4">
                            <div style="float: right;top: -15px;position: relative;">
                                <div class="layui-col-md4">
                                    <label class="layui-form-label">技术工种：</label>
                                    <div class="layui-input-block"
                                        style="width: 60%;bottom: -8px;position: relative;">
                                        <select name="type" lay-verify="required" lay-filter="aihao"
                                            style="bottom: 0px;position: relative;width: 66%;">
                                            <option value=""></option>
                                            <option value="0">普通</option>
                                            <option value="1">专家</option>
                                            <option value="2">急诊</option>
                                        </select>
                                    </div>

                                </div>
                                <div class="layui-col-md4" style="margin-left: 2%;">

                                    <label class="layui-form-label">处方金额：</label>
                                    <div class="layui-input-block">
                                        <p style="font-size: 150%;color: red;align-content: center;margin-top: 2%">
                                            {msg}</p>
                                    </div>
                                </div>

                                <div class="layui-col-md3" style="width: 30%; float: right;">
                                    <div class="layui-btn-group">
                                        <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#xe654;</i>增方</button>
                                        <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#xe640;</i>删方</button>
                                        <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#xe605;</i>保存</button>
                                        <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#xe609;</i>发送</button>
                                        <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#x1006;</i>作废</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <hr class="layui-bg-black">
                    </div>
                </div>
            </div> -->

            <div class="layui-col-md12">

                <div class="layui-card" style="height: 40px;">
                    <div class="layui-card-body" style="height: 30px;">

                        <!-- <div class="layui-fluid" id="LAY-component-layer-special-demo">s -->

                        <div class="layui-col-md4">
                            <p style="float: left;">门诊处方</p>
                        </div>


                        <div class="layui-col-md4">
                            <div class="layui-col-md5">
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

                            </div>
                            <div class="layui-col-md6" style="margin-left: 2%;">

                                <label class="layui-form-label">处方金额：</label>
                                <div class="layui-input-block">
                                    <p style="font-size: 150%;color: red;align-content: center;margin-top: 2%">
                                        {msg}</p>
                                </div>
                            </div>
                            <!-- <div class="layui-btn-container" style="float: right;">
                                <div class="layui-btn-group">
                                    <div class="layui-btn-container layadmin-layer-demo">
                                        <button data-method="add" class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#xe654;</i>增药</button>
                                        <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                            style="float: left;"><i class="layui-icon">&#xe640;</i>删药</button>
                                    </div>

                                </div>
                            </div> -->
                        </div>
                        <div class="layui-col-md4">
                            <div class=" layui-btn-container" style="float: left;margin: auto;">
                                <div class="layui-fluid" id="LAY-component-layer-special-demo">
                                    <div class="layui-btn-container layadmin-layer-demo">
                                        <div class="layui-btn-group">
                                            <button data-type="add" class=" layui-btn layui-btn-xs layui-btn-normal"
                                                    style="float: left;"><i class="layui-icon">&#xe654;</i>增方</button>
                                            <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                                    style="float: left;"><i class="layui-icon">&#xe640;</i>删方</button>
                                            <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                                    style="float: left;"><i class="layui-icon">&#xe605;</i>保存</button>
                                            <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                                    style="float: left;"><i class="layui-icon">&#xe609;</i>发送</button>
                                            <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                                    style="float: left;"><i class="layui-icon">&#x1006;</i>作废</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- </div> -->

                    </div>
                </div>
            </div>
            <hr class="layui-bg-black">
            <!-- 左上部分 -->
            <div class="layui-col-md2" style="height: 50%">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-btn-group">
                            <button class=" layui-btn layui-btn-xs layui-btn-normal" style="float: left;"><i
                                    class="layui-icon">&#xe63c;</i>复制</button>
                            <button class=" layui-btn layui-btn-xs layui-btn-normal"
                                    style="float: left;margin-left: 1%;"><i class="layui-icon">&#xe60a;</i>粘贴</button>
                        </div>
                        <hr class="layui-bg-black">
                        <div>
                            <div class="layui-btn-container">

                                <!-- 左侧菜单 -->
                                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu"
                                    lay-filter="layadmin-system-side-menu">
                                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                                        <dl class="layui-nav-child">
                                            <dd data-name="console">
                                                <a lay-href="prescribe/indexiti">一</a>
                                            </dd>
                                            <dd data-name="console">
                                                <a lay-href="home/homepage1.html">二</a>
                                            </dd>
                                            <dd data-name="console">
                                                <a lay-href="home/homepage2.html">三</a>
                                            </dd>
                                        </dl>
                                    </li>

                                </ul>
                                <button class="layui-btn layui-btn-primary layui-btn-best">123</button>
                                <!-- 给这个按钮一个表格reload事件就能刷新右侧表格 -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 右上部分 -->
            <!-- <div class="layui-col-md10" style="height: 50%">
                <div class="layui-col-md12">
                    <div class="layui-card" style="height: 40px">
                        <div class="layui-card-body" style="height: 40px">
                            <div style="float: left;">
                                <div class="layui-col-md5">
                                    <label class="layui-form-label">技术工种：</label>
                                    <div class="layui-input-block"
                                        style="width: 60%;bottom: -8px;position: relative;">
                                        <select name="type" lay-verify="required" lay-filter="aihao"
                                            style="bottom: 0px;position: relative;width: 66%;">
                                            <option value=""></option>
                                            <option value="0">普通</option>
                                            <option value="1">专家</option>
                                            <option value="2">急诊</option>
                                        </select>
                                    </div>

                                </div>
                                <div class="layui-col-md6" style="margin-left: 2%;">

                                    <label class="layui-form-label">处方金额：</label>
                                    <div class="layui-input-block">
                                        <p style="font-size: 150%;color: red;align-content: center;margin-top: 2%">
                                            {msg}</p>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div> -->

            <div class="layui-col-md12">
                <div class="layui-card" style="height: 150px;">
                    <div class="layui-card-body" style="height: 320px;top: 100px;position: relative;">

                        <div class="layadmin-pagetabs" id="LAY_app_tabs">
                            <!-- 这个盒子里面装的东西不要管也不要动 -->
                            <!-- <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage">
                            </div>
                            <div class="layui-icon layadmin-tabs-control layui-icon-next"
                                layadmin-event="rightPage"></div> -->
                            <!-- <div class="layui-icon layadmin-tabs-control layui-icon-down">
                                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                                    <li class="layui-nav-item" lay-unselect>
                                        <a href="javascript:;"></a>
                                        <dl class="layui-nav-child layui-anim-fadein">
                                            <dd layadmin-event="closeThisTabs"><a href="javascript:;"></a></dd>
                                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;"></a></dd>
                                            <dd layadmin-event="closeAllTabs"><a href="javascript:;"></a>
                                            </dd>
                                        </dl>
                                    </li>
                                </ul>
                            </div> -->
                            <div class="layui-tab" lay-unauto lay-allowClose="true"
                                 lay-filter="layadmin-layout-tabs">
                                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this">
                                        <i class=""></i>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="layui-body" id="LAY_app_body" style="height: 390px;">
                            <div class="layadmin-tabsbody-item layui-show">


                                <!-- <iframe src="null.html" frameborder="0" class="layadmin-iframe"></iframe> -->
                            </div>
                        </div>

                        <!-- <table class="layui-hide" id="test-table-checkbox1"></table> -->
                    </div>
                </div>
            </div>
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
                                               lay-filter="test-table-radio">
                                        </table>
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
</div>

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
                    area: ['450px', '600px'],
                    shade: 0,
                    maxmin: true,

                    content: '<iframe src="add.html" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("add");
                        $.ajax({
                            type: "POST",
                            url: "prescribe/addmedtest",
                            data: $(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {
                                } else {
                                    layer.msg(res.message)
                                }
                                layer.closeAll();
                                layui.table.reload('test-table-reload',{page: {curr: 1}});
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        }) //ajax结束
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

<!-- 主模块加载 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>

</body>

</html>