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
    <title>药品目录管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">



</head>

<body>
<div class="layui-card-body">
    <div class="layui-card">

        <div class="layui-header">
            <p class="layui-form-pane" style="font-size: 150%">药品目录管理</p>
            <hr class="layui-bg-black">
        </div>
        <div class="layui-card layui-form" lay-filter="component-form-element">
            <div class="layui-input-inline" style="margin-left: 10px;">
                <input type="text" class="layui-input">

            </div>
            <div class="layui-input-inline">
                <button class="layui-btn"><i class="layui-icon layui-icon-search"></i>查询</button>
            </div>
            <div class="layui-input-inline">
                <div class="layui-fluid" id="LAY-component-layer-special-demo" style="margin-top: 2%">
                    <div class="layui-btn-container layadmin-layer-demo">
                        <div class="layui-input-inline">
                            <button data-method="add" class="layui-btn"><i
                                    class="layui-icon layui-icon-add-1"></i>增加</button>
                        </div>
                        <div class="layui-input-inline">
                            <button data-method="del" class="layui-btn"><i
                                    class="layui-icon layui-icon-delete"></i>删除</button>
                        </div>
                        <div class="layui-input-inline">
                            <button data-method="edit" class="layui-btn"><i
                                    class="layui-icon layui-icon-edit"></i>修改</button>
                        </div>
                        <div class="layui-input-inline">
                            <button data-method="change" class="layui-btn"><i
                                    class="layui-icon layui-icon-list"></i>调价</button>
                        </div>
                        <div class="layui-input-inline">
                            <button data-method="table" class="layui-btn"><i
                                    class="layui-icon layui-icon-table"></i>调价记录</button>
                        </div>
                    </div>

                </div>
            </div>


        </div>
        <div class="layui-table-body">
            <table class="layui-hide" id="test-table-radio" lay-filter="test-table-radio"></table>

        </div>


    </div>
</div>


    <script src="department/layui/layui.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>




<!-- 单选表格 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var admin = layui.admin,
            table = layui.table;

        table.render({
            elem: '#test-table-radio'
            ,url: 'drugstore/getAllDrug'
            ,method:'get'
            ,parseData:function (res) {
            //TODO:解析JSON对象
            return {
                "code":res.status,
                "msg":res.message,
                "count":res.total,
                "data":res.data
            }
        }
            // url: layui.setter.base + '/json/table/user.js',
            // toolbar: '#test-table-radio-toolbarDemo',
            ,cols: [
                [{
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                    field: 'id',
                    width: 100,
                    title: '编码',
                    sort: true
                }, {
                    field: 'drugsname',
                    width: 120,
                    title: '药品名',
                    sort: true
                }, {
                    field: 'drugstatus',
                    width: 100,
                    title: '状态'
                }, {
                    field: 'drugsformat',
                    title: '规格',
                    width: 100,
                }, {
                    field: 'constantname',
                    width: 100,
                    title: '剂型',
                }, {
                    field: 'drugamount',
                    width: 180,
                    title: '包装数量',
                }, {
                    field: 'drugsunit',
                    width: 180,
                    title: '包装单位'
                }, {
                    field: 'drugsprice',
                    width: 100,
                    title: '售价'
                }, {
                    field: 'manufacturer',
                    width: 180,
                    title: '生产厂商'
                }, {
                    field: 'typename',
                    width: 180,
                    title: '药品类别'
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
                    title: '添加',
                    area: ['390px', '500px'],
                    shade: 0,
                    maxmin: true,

                        content: '<iframe src="drugstore/indexadd?constanttypeid=11" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['确定', '取消'],
                        yes: function (index, layero) {
                            var iframes = $(layero).find("iframe")[0].contentWindow;
                            var form = iframes.document.getElementById("add");
                            $.ajax({
                                type: "POST",
                                url: "drugstore/addmedicine",
                                data: $(form).serialize(),
                                success: function (res) {
                                    if (res.status == 0) {} else {
                                        layer.msg(res.message)
                                    }
                                    setTimeout(function () {
                                        // 就是单楚栋之前弄的一个刷新
                                        // window.parent.location.reload('test-table-reload',{page: {curr: 1}});
                                        layui.table.reload('test-table-radio');
                                    }, 100);
                                    layer.closeAll();
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
            del: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.checkStatus('test-table-radio').data;
                var myArray = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    myArray.push(tabledata[i].id);
                }
                // var id = tabledata[0].examcheckid;

                layer.open({
                    type: 1,
                    offset: type,
                    title: '删除药品',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要删除选中药品吗</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "drugstore/delmedicine",
                            traditional: true,
                            data: {
                                'ids': myArray
                            },
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message);
                                } else {
                                    layer.msg(res.message);
                                }
                                setTimeout(function () {
                                    window.parent.location
                                        .reload(); //修改成功后刷新父界面
                                }, 100);
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        })
                        layer.closeAll();
                        parent.layui.table.reload('test-table-radio', {
                            page: {
                                curr: 1
                            }
                        });
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            },

            //修改药品
            edit: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.checkStatus('test-table-radio').data;
                // var myArray = new Array();
                layer.open({
                    type: 1,
                    title: "修改药品",
                    area: ['450px', '350px'],
                    shade: 0,
                    maxmin: true,
                    content: '<iframe src="drugstore/indexedit?constanttypeid=11&id='+tabledata[0].id+'" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '关闭'],
                    yes: function (index,layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("edit");
                        $.ajax({
                            type: "POST",
                            url: "drugstore/editmedicine?id="+tabledata[0].id,
                            data: $(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                    window.parent.location.reload();
                                }, 100);
                                layer.closeAll();
                                // window.parent.layui.table.reload('test-table-reload',{page: {curr: 1}});
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

            // 调价
            change: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.checkStatus('test-table-radio').data;
                layer.open({
                    type: 1,
                    title: '调价',
                    area: ['390px', '300px'],
                    shade: 0,
                    maxmin: true,

                    content: '<iframe src="drugstore/indexchange?id='+tabledata[0].id+'" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['确定', '取消'],
                    yes: function (index,layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("edit");
                        $.ajax({
                            type: "POST",
                            url: "drugstore/editmedicine?id="+tabledata[0].id,
                            data: $(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                    window.parent.location.reload();
                                }, 100);
                                layer.closeAll();
                                // window.parent.layui.table.reload('test-table-reload',{page: {curr: 1}});
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
            table: function () {
                var that = this;
                layer.open({
                    type: 1,
                    title: '调价记录',
                    area: ['900px', '400px'],
                    shade: 0,
                    maxmin: true,

                        content: '<iframe src="table.jsp" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['确定', '取消'],
                        yes: function () {

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