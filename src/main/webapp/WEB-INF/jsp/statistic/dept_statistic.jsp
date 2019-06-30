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
    <title>门诊科室工作量统计</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
</head>

<!-- 切换页 -->
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

        element.on('tab(component-tabs-brief)', function (obj) {
            layer.msg(this.innerHTML);
        });
        form.on('submit(component-form-element)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        var this_table = table.render(GetTableOption('#table-test', "/api/test", function (res, cur, count) {
            if (this_table.config.cols[0].length == 0) {
                this_table.config.cols = res.cols;
                this_table.reload();
            }
        }));

        function GetTableOption(tablId, url, callback) {
            var title = getTitle();
            layer.msg('统计数据获取中...', {
                icon: 16,
                shade: 0.01,
                time: 0
            });
            var options = {
                elem: "#demo",
                id: "demo",
                url: 'statistic/deptList',
                toolbar: '#test-table-toolbar-toolbarDemo',
                method: 'get',
                parseData: function (res) {
                    return {
                        "code":res.status,
                        "msg":res.message,
                        "count":res.total,
                        "data":res.data
                    }
                },
                cols: [ title ],
                //page: true,
                //limit: 10,
                height: 'full-270',
                //height: 'full-230',
                text: {
                    none: '未找到相关数据'
                },
                done: function () {
                    layer.close(layer.msg());
                    layer.msg('获取成功');
                }
            };
            return options;
        }

        //监听单元格编辑
        table.on('edit(test-table-cellEdit)', function (obj) {
            var value = obj.value //得到修改后的值
                ,
                data = obj.data //得到所在行所有键值
                ,
                field = obj.field; //得到字段
            layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value, {
                offset: '15px'
            });
        });

    });
</script>

<!-- 表格2 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        var this_table = table.render(GetTableOption('#table-test', "/api/test", function (res, cur, count) {
            if (this_table.config.cols[0].length == 0) {
                this_table.config.cols = res.cols;
                this_table.reload();
            }
        }));

        function GetTableOption(tablId, url, callback) {
            var title = getTitle();
            layer.msg('统计数据获取中...', {
                icon: 16,
                shade: 0.01,
                time: 0
            });
            var options = {
                elem: "#demo2",
                id: "demo2",
                url: 'statistic/ZdeptList',
                toolbar: '#test-table-toolbar-toolbarDemo',
                method: 'get',
                parseData: function (res) {
                    return {
                        "code": res.status,
                        "msg": res.message,
                        "count": res.total,
                        "data": res.data
                    }
                },
                cols: [title],
                //page: true,
                //limit: 10,
                height: 'full-270',
                text: {
                    none: '未找到相关数据'
                },
                done: function () {
                    layer.close(layer.msg());
                    layer.msg('获取成功');
                }
            };
            return options;
        }

        //监听单元格编辑
        table.on('edit(test-table-cellEdit)', function (obj) {
            var value = obj.value //得到修改后的值
                ,
                data = obj.data //得到所在行所有键值
                ,
                field = obj.field; //得到字段
            layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value, {
                offset: '15px'
            });
        });

    });
</script>

<!-- 时间模块 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laydate'], function () {
        var laydate = layui.laydate;

        //开始
        var insStart = laydate.render({
            elem: '#test-laydate-start',
            type: 'date',
            done: function (value, date) {
                //更新结束日期的最小日期
                insEnd.config.min = lay.extend({}, date, {
                    month: date.month - 1
                });

                //自动弹出结束日期的选择器
                insEnd.config.elem[0].focus();
            }
        });

        var insEnd = laydate.render({
            elem: '#test-laydate-end',
            type: 'date',
            done: function (value, date) {
                //更新开始日期的最大日期
                insStart.config.max = lay.extend({}, date, {
                    month: date.month - 1
                });
            }
        });

        //开始
        var insStart = laydate.render({
            elem: '#test-laydate-start2',
            type: 'date',
            done: function (value, date) {
                //更新结束日期的最小日期
                insEnd.config.min = lay.extend({}, date, {
                    month: date.month - 1
                });

                //自动弹出结束日期的选择器
                insEnd.config.elem[0].focus();
            }
        });

        var insEnd = laydate.render({
            elem: '#test-laydate-end2',
            type: 'date',
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
    var info;
    function getList() {
        $.ajax({
            type: "post",
            url: "statistic/listTitle",
            async: false,
            success: function (result) {
                info = result.data;
            }
        });
        return info;
    }

    function getTitle() {
        var info = getList();
        var mycols = new Array();
        mycols[0] = {field: 'name', title: '科室名称', width: 150};
        mycols[1] = {field: 'num', title: '看诊人次', width: 100};
        for(var i = 2; i < info.length + 2; i++) {
            if(i == info.length + 1)
                mycols[i] = {field: info[i - 2].account_code, title: info[i - 2].account_name};
            else
                mycols[i] = {field: info[i - 2].account_code, title: info[i - 2].account_name, width: 100};
        }
        return mycols;
    }

    function getSelect() {
        var start = document.getElementById("test-laydate-start").value.toUpperCase();
        var end = document.getElementById("test-laydate-end").value.toUpperCase();

        if(start == "") {
            alert("开始日期不能为空");
            return;
        }
        else if(end == "") {
            alert("截止日期不能为空");
            return;
        }

        $.ajax({
            type: "post",
            url: "statistic/search",
            data: {
                "start": start,
                "end": end
            },
            dataType: "JSON",
            async: false,
            beforeSend: function () {
            },
            success: function () {
            },
            error: function () {
            }
        });
        //window.location.reload();
        layui.table.reload('demo',{page: {curr: 1}});
        layer.msg('统计数据获取中...', {
            icon: 16,
            shade: 0.01,
            time: 0
        });
    }

    function getSelectList() {
        var start = document.getElementById("test-laydate-start2").value.toUpperCase();
        var end = document.getElementById("test-laydate-end2").value.toUpperCase();

        if(start == "") {
            alert("开始日期不能为空");
            return;
        }
        else if(end == "") {
            alert("截止日期不能为空");
            return;
        }

        $.ajax({
            type: "post",
            url: "statistic/searchList",
            data: {
                "start": start,
                "end": end
            },
            dataType: "JSON",
            async: false,
            beforeSend: function () {
            },
            success: function () {
            },
            error: function () {
            }
        });
        //window.location.reload();
        layui.table.reload('demo2',{page: {curr: 1}});
        layer.msg('统计数据获取中...', {
            icon: 16,
            shade: 0.01,
            time: 0
        });
    }

    function refresh() {
        $.ajax({
            type: "get",
            url: "statistic/refresh",
            success: function () {
                layui.table.reload('demo',{page: {curr: 1}});
            }
        });
    }

    function refresh2() {
        $.ajax({
            type: "get",
            url: "statistic/refresh2",
            success: function () {
                layui.table.reload('demo2',{page: {curr: 1}});
            }
        });
    }

    window.onbeforeunload = function() {
        refresh();
    };
</script>

<body style="background-color: white">
<div class="layui-card">
    <div class="layui-card-header"><h3>门诊科室工作量统计</h3></div>
    <div class="layui-card-body">
        <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
            <ul class="layui-tab-title">
                <li class="layui-this">开单科室统计</li>
                <li>执行科室统计</li>

            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <div class="layui-row">
                        <div class="layui-fluid">
                            <div class="layui-col-md12">
                                <!-- 日期选择框 -->
                                <div class="layui-form-item">
                                    <div class="layui-row">

                                        <div class="layui-col-md1" style="float: left">
                                            <div style="width: 100%;float:right;margin-top: 4%;">
                                                <div class="layui-card-header" style="float: left">统计日期：</div>
                                            </div>
                                        </div>
                                        <div class="layui-col-md5">
                                            <div style="width: 120%;float:right;margin-top: 1.5%;">
                                                <form method="post">
                                                    <div class="layui-input-inline">
                                                        <input type="text" class="layui-input"
                                                               id="test-laydate-start" autocomplete="off"
                                                               placeholder="开始日期">
                                                    </div>
                                                    <div class="layui-form-mid">
                                                        -
                                                    </div>
                                                    <div class="layui-input-inline">
                                                        <input type="text" class="layui-input" id="test-laydate-end"
                                                               autocomplete="off" placeholder="结束日期">
                                                    </div>
                                                </form>
<%--                                                <input class="layui-btn" type="button" value="查询" style="margin:auto;" id="search" onclick="getSelect()">--%>
                                                <a class="layui-btn" style="margin:auto;" id="search" onclick="getSelect()"><i class="layui-icon">&#xe615;</i>查询</a>
                                                <button class="layui-btn layui-bg-cyan" style="margin:auto;" id="refresh" onclick="refresh()"><i class="layui-icon">&#xe669;</i>刷新</button>
                                            </div>
                                        </div>


                                    </div>

                                </div>


                            </div>

                            <div class="layui-col-md12">


                                <div class="layui-card">
                                    <div class="layui-card-header"
                                         style="margin-left: 35%;font-size: 200%;margin-top: 2%">
                                        门诊科室工作量统计（开单科室）
                                    </div>
                                    <div class="layui-table-body">
                                        <table class="layui-hide" id="demo"></table>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item">

                    <!-- 内容2 -->

                    <div class="layui-row">
                        <div class="layui-fluid">
                            <div class="layui-col-md12">
                                <!-- 日期选择框 -->
                                <div class="layui-form-item">
                                    <div class="layui-row">

                                        <div class="layui-col-md1" style="float: left">
                                            <div style="width: 100%;float:right;margin-top: 4%;">
                                                <div class="layui-card-header" style="float: left">统计日期：</div>
                                            </div>
                                        </div>
                                        <div class="layui-col-md5">
                                            <div style="width: 120%;float:right;margin-top: 1.5%;">
                                                <form method="post">
                                                    <div class="layui-input-inline">
                                                        <input type="text" class="layui-input"
                                                               id="test-laydate-start2" autocomplete="off"
                                                               placeholder="开始日期">
                                                    </div>
                                                    <div class="layui-form-mid">
                                                        -
                                                    </div>
                                                    <div class="layui-input-inline">
                                                        <input type="text" class="layui-input"
                                                               id="test-laydate-end2" autocomplete="off"
                                                               placeholder="结束日期">
                                                    </div>
                                                </form>
<%--                                                <input class="layui-btn" type="button" value="查询" style="margin:auto;" id="chaxun2" onclick="getSelectList()">--%>
                                                <a class="layui-btn" style="margin:auto;" id="chaxun2" onclick="getSelectList()"><i class="layui-icon">&#xe615;</i>查询</a>
                                                <button class="layui-btn layui-bg-cyan" style="margin:auto;" id="refresh2" onclick="refresh2()"><i class="layui-icon">&#xe669;</i>刷新</button>
                                            </div>
                                        </div>


                                    </div>

                                </div>


                            </div>

                            <div class="layui-col-md12">


                                <div class="layui-card">
                                    <div class="layui-card-header"
                                         style="margin-left: 35%;font-size: 200%;margin-top: 2%">
                                        门诊科室工作量统计（执行科室）
                                    </div>
                                    <div class="layui-table-body">
                                        <table class="layui-hide" id="demo2"></table>

                                    </div>
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
</html>
