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
    <title>费用科目管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
    <script src="department/layui/layui.js"></script>
    <script src="js/jquery.min.js"></script>
</head>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径X
    })
        .extend({
            index: 'lib/index' //主入口模块X
        })
        .use(['index', 'table'], function () {
            var table = layui.table;

            //方法级渲染
            table.render({
                elem: '#test-table-reload',
                id: 'test-table-reload',
                url: 'account/list',
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
                cols: [
                    [{
                        checkbox: true,
                        fixed: true
                    }, {
                        field: 'id',
                        title: '编号',
                        width: 250,
                        sort: true,
                        fixed: true
                    }, {
                        field: 'account_code',
                        title: '科目编码',
                        width: 250
                    }, {
                        field: 'account_name',
                        title: '科目名称',
                        width: 250
                    }
                    ]
                ],
                page: true,
                height: 400
            });


            // 搜索函数X
            var $ = layui.$,
                active = {
                    reload: function () {
                        var demoReload = $('#test-table-demoReload');

                        //执行重载
                        table.reload('test-table-reload', {
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
    function selectValue() {
        var keyword = document.getElementById("select_value").value.toUpperCase();
        $.ajax({
            type: "POST",
            url: "account/select",
            traditional: true,
            data:{'key': keyword},
            beforeSend: function () {
                $("#submit").attr({ disabled: "disabled" });
            },
            success: function () {
                layui.table.reload('test-table-reload',{page: {curr: 1}});
            },
            error: function () {
                alert("出现错误");
                return false;
            }
        });
    }

    function refresh() {
        $.ajax({
            type: "get",
            url: "account/refresh",
            success: function () {
                layui.table.reload('test-table-reload',{page: {curr: 1}});
            }
        });
    }
</script>

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

            // 添加函数***************************************************************************************
            addTop: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();

                layer.open({
                    type: 1,
                    title: '科目添加',
                    area: ['490px', '250px'],
                    shade: 0,
                    maxmin: true,
                    offset: type,
                    content: '<iframe src="account/addUI" id="addAccount" name="addAccount" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['确定', '关闭'],
                    yes: function () {
                        var flag = document.getElementById("addAccount").contentWindow.addControll();
                        if(flag == false)
                            return;

                        var code = window.frames["addAccount"].document.getElementById('accountCode').value;
                        var name = window.frames["addAccount"].document.getElementById('accountName').value;

                        $.ajax({
                            type: "post",
                            url: "account/add",
                            data: {
                                "account_code": code,
                                "account_name": name
                            },
                            dataType: "JSON",
                            async: false,
                            beforeSend: function () {
                            },
                            success: function (data) {
                                if(data == 1) {
                                    alert("添加成功");
                                    layui.table.reload('test-table-reload',{page: {curr: 1}});
                                }
                                else if(data == 0)
                                    alert("添加失败");
                                else if(data == 2)
                                    alert("科目编码或科目名称重复");
                                else
                                    alert("error");
                            },
                            error: function () {
                                alert("提交失败");
                            }
                        });
                        layer.closeAll();
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
            }

            // 编辑弹窗
            ,
            edit: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();

                var tabledata = layui.table.checkStatus('test-table-reload').data;
                var myArray = new Array();
                for(var i = 0; i < tabledata.length; i++){
                    myArray.push(tabledata[i].id);
                }
                if(myArray.length > 1) {
                    alert("一次只能修改一条科目！");
                    return;
                }
                else if(myArray.length < 1) {
                    alert("请选择一条科目编辑！");
                    return;
                }

                layer.open({
                    type: 1,
                    offset: type,
                    title: '科目编辑',
                    id: 'layerDemo' + type,
                    area: ['490px', '250px'],
                    content: '<iframe src="account/editUI" id="editAccount" name="editAccount"  frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        var flag = document.getElementById("editAccount").contentWindow.editControll();
                        if(flag == false)
                            return;

                        var code = window.frames["editAccount"].document.getElementById('accountCode').value;
                        var name = window.frames["editAccount"].document.getElementById('accountName').value;

                        $.ajax({
                            type: "post",
                            url: "account/update",
                            data: {
                                "id": tabledata[0].id,
                                "account_code": code,
                                "account_name": name,
                                "code": tabledata[0].account_code,
                                "name": tabledata[0].account_name
                            },
                            dataType: "JSON",
                            async: false,
                            beforeSend: function () {
                            },
                            success: function (data) {
                                if(data == 1) {
                                    alert("修改成功");
                                    layui.table.reload('test-table-reload',{page: {curr: 1}});
                                }
                                else if(data == 0)
                                    alert("修改失败");
                                else if(data == 2)
                                    alert("科目编码或科目名称重复");
                                else
                                    alert("error");
                            },
                            error: function () {
                                alert("提交失败");
                            }
                        });
                        layer.closeAll();
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            }

            // 导入弹窗
            ,
            upload: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();

                layer.open({
                    type: 2,
                    offset: type,
                    title: '文件导入',
                    id: 'layerDemo' + type,
                    area: ['490px', '460px'],
                    content: 'upload.html',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {

                        layer.closeAll();
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            },

            del: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();

                var tabledata = layui.table.checkStatus('test-table-reload').data;

                var myArray = new Array();
                for(var i = 0; i < tabledata.length; i++){
                    myArray.push(tabledata[i].id);
                }
                if(myArray.length < 1) {
                    alert("请选择规则删除");
                    return;
                }

                layer.open({
                    type: 1,
                    offset: type,
                    title: '项目删除',
                    id: 'layerDemo' + type,
                    area: ['250px', '150px'],
                    content: '确定要删除吗?',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        $.ajax({
                            type: "POST",
                            url: "account/delete",
                            traditional: true,
                            data:{'id': myArray},
                            success: function (res) {
                                if (res.status == 0) {
                                    alert("删除成功");
                                } else {
                                    layer.msg(res.message)
                                }
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        });
                        layui.table.reload('test-table-reload',{page: {curr: 1}});
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
    });
</script>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
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

    });
</script>

<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header"><h3>费用科目管理</h3>
                </div>
                <div class="layui-card-body">
                    <div class="layui-card-body">

                        <div class="test-table-reload-btn" style="margin-bottom: 10px;">
                            <!-- 添加弹窗控件 -->
                            <div class="layui-fluid" id="LAY-component-layer-special-demo">
                                <div class="layui-row">
                                    <form method="post">
                                    <div class="layui-col-xs6 layui-col-sm4 layui-col-md3">
                                        <input class="layui-input" name="id" id="select_value" placeholder="请输入搜索内容"
                                               autocomplete="off" style="width: 55%;display: inline;margin:10px;">
<%--                                        <input class="layui-btn" type="button" value="搜索" onclick="selectValue()" style="float: right;margin-top: 5%">--%>
                                        <a class="layui-btn" onclick="selectValue()" style="float: right;margin-top: 3.25%;margin-right: 20px"><i class="layui-icon">&#xe615;</i>搜索</a>

                                    </div>
                                    </form>


                                    <div class="layui-col-xs6 layui-col-sm8 layui-col-md6" style="float: left;">




                                        <div class="layui-btn-container layadmin-layer-demo" style="margin-left: 2%">

                                            <button data-method="addTop" data-type="auto" class="layui-btn layui-btn-normal" style="margin: 10px;"><i class="layui-icon">&#xe608;</i>添加</button>
                                            <button data-method="edit" data-type="auto" class="layui-btn layui-btn-normal" style="margin: 10px;"><i class="layui-icon">&#xe620;</i>编辑</button>
                                            <button data-method="del" datatype="auto" class="layui-btn layui-btn-normal" style="margin: 10px;"><i class="layui-icon">&#xe640;</i>删除</button>
<%--                                            <input  class="layui-btn" type="button" value="刷新" onclick="refresh()" style="margin: 10px;">--%>
                                            <a class="layui-btn layui-bg-cyan" onclick="refresh()" style="margin: 10px;"><i class="layui-icon">&#xe669;</i>刷新</a>

                                        </div>
                                    </div>


                                </div>
                            </div>
                            <!-- 表格 -->
                            <table class="layui-hide" id="test-table-reload" lay-filter="user"></table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
