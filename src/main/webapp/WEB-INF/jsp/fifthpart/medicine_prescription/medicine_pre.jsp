<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
<html>

<head>
    <meta charset="utf-8">
    <title>成药处方</title>
    <!-- <meta name="renderer" content="webkit"> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>




<body>
<div class="layui-fluid">
    <div class="layui-row">

        <div class="layui-col-md8" style="overflow: auto;">
            <!-- 中部折叠面板 -->
            <div class="layui-card">
                <div class="layui-card-header " style="height: 80px;">

                    <div class="layui-card layui-form" lay-filter="component-form-element" style="width: 100%">
                        <!-- <div class="layui-col-md2" style="font-size: 200%;padding: 500;">成药处方</div> -->
                        <div class="layui-col-md2">
                            <p style="font-size: 200%;font-weight: 500;">成药处方</p>
                        </div>

                        <div class="layui-col-md1">
                            <div style="margin-top: 55%;margin-left: 10px;">
                                <p>处方类型</p>
                            </div>
                        </div>
                        <div class="layui-col-md2">
                            <div style="margin-top: 22%;width: 70%" class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                                <input class="layui-input" name="pretype" id="pretype" autocomplete="off" readonly>
                            </div>
                        </div>

<%--                        <div class="layui-col-md3">--%>
<%--                            <div style="margin-top: 20%;width: 70%">--%>
<%--                                <select name="city" lay-verify="required" lay-search>--%>
<%--                                    <option value="">在下是个能搜索的选择框</option>--%>
<%--                                    <option value="01">1</option>--%>
<%--                                    <option value="02">2</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>

                        <div class="layui-col-md1">
                            <div style="margin-top: 55%;">
                                <p>总金额：</p>
                            </div>
                        </div>

                        <div class="layui-col-md1">
                            <div>
                                <p id="totalmoney" style="width: 40%; font-size: 180%;color: red;margin-top: 55%;">
<%--                                    {msg}--%>
                                </p>
                            </div>
                        </div>

                        <%--    asdasd--%>
                        <div class="layui-col-md3">
                            <div >
<%--                                <div class="layui-col-md2">--%>
                                    <div style="margin-top: 20%;width: 70%" class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                                        <input class="layui-input" name="prestatus" id="prestatus" autocomplete="off" readonly>
                                    </div>
<%--                                </div>--%>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-body">
                    <fieldset class="layui-elem-field layui-field-title">
                        <legend>成药处方药品详情</legend>
                    </fieldset>
                    <div class="layui-btn-container">
                        <div class="layui-fluid" id="LAY-component-layer-special-demo">
                            <div class="layui-btn-container layadmin-layer-demo">
                                <button data-method="add" id="addTable" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">新增药品</button>
                                <button data-method="deltable" datatype="auto" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">删除药品</button>
                                <button data-method="uptable" datatype="auto" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">修改药品</button>
                                <button data-method="savetable" datatype="auto" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">暂存处方</button>
                                <button data-method="opentable" datatype="auto" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">删除处方</button>


                                <button data-method="setpretable" datatype="auto" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">开立处方</button>
                                <button data-method="canceltable" datatype="auto" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">作废处方</button>
                                <button data-method="add_muban" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">存为组套</button>
                            </div>

                        </div>


                    </div>
                    <table class="layui-hide" id="test-table-cellEdit-middle" lay-filter="test-table-cellEdit">
                    </table>
                </div>
            </div>

        </div>
        <div class="layui-col-md4">



            <div class="layui-fluid" id="component-tabs2" style="height:300px;overflow: auto;">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                            <ul class="layui-tab-title">
                                <li class="layui-this">组套模板</li>
                                <li>常用项目</li>

                            </ul>
                            <div class="layui-tab-content">
                                <div class="layui-tab-item layui-show">
                                    <!-- 选项卡1中内容 -->
                                    <!-- 右侧树状图 -->
                                    <div class="layui-card layui-form" lay-filter="component-form-element">

                                        <div class="layui-card-body layui-row layui-col-space10">
                                            <div class="layui-col-md12">
                                                <input type="radio" name="sel" value="01" title="全院" checked
                                                       style="size: 50%">
                                                <input type="radio" name="sel" value="02" title="科室">
                                                <input type="radio" name="sel" value="03" title="个人">
                                            </div>
                                            <div class="layui-fluid" id="LAY-component-layer-special-demo2">
                                                <div class="layui-btn-container layadmin-layer-demo">
                                                    <div class="layui-btn-group" style="align-content: center;">
                                                        <button data-method="add_muban"
                                                                class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon">&#xe654;</i></button>
                                                        <button class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon">&#xe642;</i></button>
                                                        <button class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon layui-icon-search"></i></button>
                                                        <button class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon">&#xe640;</i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="test9"></div>

                                </div>
                                <div class="layui-tab-item">
                                    <!-- 选项卡2常用项目内容 -->
                                    <div class="layui-inline">


                                        <span class="layui-badge layui-bg-green" style="margin: 20px;">诊断1</span>
                                        <button type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>

                                        <span class="layui-badge layui-bg-green" style="margin: 20px;">诊断2</span>
                                        <button type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>

                                        <span class="layui-badge layui-bg-green" style="margin: 20px;">诊断3</span>
                                        <button type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i
                                                class="layui-icon layui-icon-delete"></i></button>


                                    </div>


                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-fluid" id="component-tabs3" style="height:300px;overflow: auto;">
                <div class="layui-card">
                    <div class="layui-card-header">组套内容</div>
                    <div class="layui-card-body">
                        <table class="layui-table" lay-even="" lay-skin="row">
                            <colgroup>
                                <col width="150">
                                <col width="150">
                                <col width="200">
                                <col>
                            </colgroup>

                            <tbody>
                            <tr>
                                <td>套组编码</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>套组名称</td>
                                <td>2</td>

                            </tr>
                            <tr>
                                <td>适用类型</td>
                                <td>3</td>

                            </tr>
                            <tr>
                                <td>目的和要求</td>
                                <td>4</td>

                            </tr>
                            <tr>
                                <td>创建医生</td>
                                <td>5</td>
                            </tr>
                            <tr>
                                <td>创建时间</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>包含项目</td>
                                <td>5</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="department/layui/layui.js?t=1"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<script>
    var type = null;
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

        // form.on('select(pretype)', function(data){
        //     // console.log(data.elem); //得到select原始DOM对象
        //     // console.log(data.value); //得到被选中的值
        //     // console.log(data.othis); //得到美化后的DOM对象
        //     type = data.value;
        //     console.log(type);
        //     return type;
        // });
    });
</script>

<!-- 选项卡 -->
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
            },
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


<!-- 数据表格1 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        table.render({
            elem: '#test-table-simple1',
            url: layui.setter.base + 'json/table/user.js',
            cellMinWidth: 80 //全局定义常规单元格的最小宽度
            ,
            cols: [
                [{
                    field: 'id',
                    width: 80,
                    title: 'ID',
                    sort: true
                }, {
                    field: 'name',
                    width: 80,
                    title: '姓名'
                }, {
                    field: 'age',
                    width: 80,
                    title: '年龄',
                    sort: true
                }]
            ]
        });
    });
</script>
<!-- 数据表格2 -->
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
            cellMinWidth: 80 //全局定义常规单元格的最小宽度
            ,
            cols: [
                [{
                    field: 'id',
                    width: 80,
                    title: 'ID',
                    sort: true
                }, {
                    field: 'name',
                    width: 80,
                    title: '姓名'
                }, {
                    field: 'age',
                    width: 80,
                    title: '年龄',
                    sort: true
                }]
            ]
        });
    });
</script>
<!-- 中部复选框表格 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        table.render({
            elem: '#test-table-cellEdit-middle',
            // url: layui.setter.base + 'json/table/demo.js',
            url: 'prescribe/gettestinfo?medicalrecordid=3&doctorid=3',
            method:'get',
            parseData:function (res) {
                //TODO:解析JSON对象
                return {
                    "code": res.status,
                    "msg": res.message,
                    "count": res.total,
                    "data": res.data
                }
            },
            cols: [
                [{
                    type: 'checkbox'
                }, {
                    field: 'drugsname',
                    title: '药品名称*',
                    width: 180,
                    sort: true
                }, {
                    field: 'format',
                    title: '规格*',
                    width: 180
                    // sort: true
                }, {
                    field: 'price',
                    title: '单价*',
                    width: 180
                    // sort: true,
                },
                    {
                        field: 'usage',
                        title: '用法',
                        width: 180
                    },
                    {
                        field: 'dosage',
                        title: '用量 ',
                        width: 180
                    },
                    {
                        field: 'unit',
                        title: '单位*',
                        width: 180
                    },
                    {
                        field: 'times',
                        title: '频次 ',
                        width: 180
                    },
                    {
                        field: 'days',
                        title: '天数 ',
                        width: 180
                    },
                    {
                        field: 'number',
                        title: '次数',
                        width: 180
                    },
                    {
                        field: 'amount',
                        title: '数量',
                        width: 180
                    },
                    {
                        field: 'entrust',
                        title: '用药嘱托',
                        width: 180
                    }
                    // {
                    //     field: 'istemp',
                    //     title: '暂存状态',
                    //     width: 180
                    // },
                ]
            ],
            done: function (res, curr, count) {
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                var money = 0;
                for (var i = 0; i < tabledata.length; i++) {
                    money += tabledata[i].price*tabledata[i].amount;
                }
                $("#totalmoney").empty();
                $("#totalmoney").html(money);
                // $("#prestatus").empty();
                // document.getElementById("prestatus").setAttribute("value", "未暂存");

            },
            page: true
        })

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


<!-- 中部折叠面板模块加载 -->
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

        element.render('collapse');

        //监听折叠
        element.on('collapse(component-panel)', function (data) {
            // layer.msg('展开状态：' + data.show);
        });
    });
</script>

<%--  <script>--%>
<%--    layui.use(['form', 'layedit', 'laydate','element','jquery'], function() {--%>
<%--      var form = layui.form,--%>
<%--              layer = layui.layer,--%>
<%--              element=layui.element,--%>
<%--              table=layui.table,--%>
<%--              $=layui.jquery;--%>
<%--      $(document).on('click','#addTable',function(){--%>
<%--        var dataBak = [];   //定义一个空数组,用来存储之前编辑过的数据已经存放新数据--%>

<%--        var tableBak = table.cache.stock_add_table;--%>
<%--        //获取之前编辑过的全部数据，前提是编辑数据是要更新缓存，stock_add_table 为表格的id--%>

<%--        for (var i = 0; i < tableBak.length; i++) {--%>
<%--          dataBak.push(tableBak[i]);      //将之前的数组备份--%>
<%--        }--%>

<%--        //在尾部新增一行空数据，实现增行效果--%>
<%--        dataBak.push({--%>
<%--          "itemcode": "123"--%>
<%--          ,"itemname": "灌肠"--%>
<%--          ,"status": "未保存"--%>
<%--        });--%>

<%--        table.reload('test-table-cellEdit-middle',{--%>
<%--          data:dataBak   // 将新数据重新载入表格--%>
<%--        })--%>
<%--      });--%>
<%--    });--%>
<%--  </script>--%>
<!-- 树 -->

<script>
    layui.use(['tree', 'util'], function () {
        var tree = layui.tree,
            layer = layui.layer,
            util = layui.util,
            data = [],
            data1 = [{
                title: '一级',
                id: 1,
                children: [{
                    title: '二级',
                    id: 1000,
                    children: [{
                        title: '三级',
                        id: 10001,
                        href: ""
                    }, {
                        title: '三级',
                        id: 10002
                    }]
                }, {
                    title: '二级',
                    id: 1001
                }, {
                    title: '二级',
                    id: 1002
                }]
            }, {
                title: '一级',
                id: 2,
                children: [{
                    title: '二级',
                    id: 2000
                }, {
                    title: '二级',
                    id: 2001
                }]
            }, {
                title: '一级',
                id: 3,
                children: [{
                    title: '二级',
                    id: 3000
                }, {
                    title: '二级',
                    id: 3001
                }]
            }]

            //模拟数据2
            ,
            data2 = [];

        //基本演示
        tree.render({
            elem: '#test12',
            data: data,
            showCheckbox: true //是否显示复选框
            ,
            id: 'demoId1',
            isJump: true //是否允许点击节点时弹出新窗口跳转
            ,
            click: function (obj) {
                var data = obj.data; //获取当前点击的节点数据
                // layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
            }
        });

        //按钮事件
        util.event('lay-demo', {
            getChecked: function (othis) {
                var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据

                layer.alert(JSON.stringify(checkedData), {
                    shade: 0
                });
                console.log(checkedData);
            },
            setChecked: function () {
                tree.setChecked('demoId1', [12, 16]); //勾选指定节点
            },
            reload: function () {
                //重载实例
                tree.reload('demoId1', {

                });

            }
        });

        //常规用法
        tree.render({
            elem: '#test1' //默认是点击节点可进行收缩
            ,
            data: data1
        });

        //无连接线风格
        tree.render({
            elem: '#test13',
            data: data1,
            showLine: false //是否开启连接线
        });

        //仅节点左侧图标控制收缩
        tree.render({
            elem: '#test2',
            data: data1,
            onlyIconControl: true //是否仅允许节点左侧图标控制展开收缩
            ,
            click: function (obj) {
                // layer.msg(JSON.stringify(obj.data));
            }
        });


        //点击节点新窗口跳转
        tree.render({
            elem: '#test5',
            data: data,
            isJump: true //link 为参数匹配
        });

        //开启复选框
        tree.render({
            elem: '#test7',
            data: data2,
            showCheckbox: true
        });

        //开启节点操作图标
        tree.render({
            elem: '#test9',
            data: data1,
            edit: ['add', 'update', 'del'] //操作节点的图标
            ,
            click: function (obj) {
                // layer.msg(JSON.stringify(obj.data));
            }
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
            //删除弹窗
            deltable: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
                var myArray = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    if((tabledata[i].istemp == 2)||(tabledata[i].istemp == 3)){//} && (tabledata[i].status != "未保存")&& (tabledata[i].status != "已作废")) {
                        alert("该处方已开立，不能删除药品！");//+tabledata[i].istemp);
                        return;
                    }
                    myArray.push(tabledata[i].pid);
                }
                // var id = tabledata[0].examcheckid;

                layer.open({
                    type: 1,
                    offset: type,
                    title: '删除药品',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要删除选中项吗</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "prescribe/deleteprescribelog",
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
                        parent.layui.table.reload('test-table-cellEdit-middle', {
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
            //修改药品弹窗
            uptable: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
                if ((tabledata[0].istemp == 2)||(tabledata[0].istemp == 3)){
                    alert("该处方已发送或已作废，无法修改！");
                    return;
                }
                // var myArray = new Array();
                layer.open({
                    type: 1,
                    title: "修改药品",
                    area: ['450px', '350px'],
                    shade: 0,
                    maxmin: true,
                    content: '<iframe src="prescribe/updatemed?prescribeid='+tabledata[0].prescribeid+'&medicalid='+tabledata[0].medicalid+'" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
                    yes: function (index,layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("update");
                        $.ajax({
                            type: "POST",
                            url: "prescribe/updatemedtest?id="+tabledata[0].pid,
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


            //暂存弹窗
            savetable: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                var myArray = new Array();
                var flag = 0;
                for (var i = 0; i < tabledata.length; i++) {
                    if(tabledata[i].istemp == 0) {
                        flag = 1;
                    }
                }
                if (flag == 0){
                    alert("请勿重复暂存！");
                    return;
                }
                for (var i = 0; i < tabledata.length; i++) {
                    myArray.push(tabledata[i].pid);
                }
                // var id = tabledata[0].examcheckid;
                layer.open({
                    type: 1,
                    offset: type,
                    title: '暂存处方',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要暂存处方吗</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "prescribe/upIstemp",
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
                                    layui.table.reload('test-table-cellEdit-middle', {
                                        page: {
                                            curr: 1
                                        }
                                    });
                                    // window.parent.location.reload('test-table-reload',{page: {curr: 1}});

                                }, 100);
                                $("#prestatus").empty();

                                layer.closeAll();
                                document.getElementById("prestatus").setAttribute("value", "已暂存");
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        })
                        layer.closeAll();
                        layui.table.reload('test-table-cellEdit-middle', {
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
            //删除处方弹窗
            opentable: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                var myArray = new Array();

                for (var i = 0; i < tabledata.length; i++) {
                    if((tabledata[i].istemp == 2)||(tabledata[i].istemp == 3)) {
                        alert("该处方已开立，不能删除！");
                        return;
                    }
                    myArray.push(tabledata[i].pid);
                }
                var prescriid = tabledata[0].prescribeid;
                layer.open({
                    type: 1,
                    offset: type,
                    title: '删除处方',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要删除处方吗</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "prescribe/deletepreandcate",
                            traditional: true,
                            data: {
                                'ids': myArray,
                                'prescriid': prescriid
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
                        parent.layui.table.reload('test-table-cellEdit-middle', {
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
            //作废处方弹窗
            canceltable: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                var myArray = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    if ((tabledata[i].istemp == 0) || (tabledata[i].istemp == 1)) {
                        alert("此处方未开立，请先开立");
                        return;
                    }
                    myArray.push(tabledata[i].pid);
                }
                var prescriid = tabledata[0].prescribeid;
                layer.open({
                    type: 1,
                    offset: type,
                    title: '作废项目',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要作废选中项吗</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "prescribe/cancelprescribe",
                            traditional: true,
                            data: {
                                'ids': myArray,
                                'prescriid': prescriid
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
                        parent.layui.table.reload('test-table-cellEdit-middle', {
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
            //开立处方弹窗
            setpretable: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                var myArray = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    if((tabledata[i].istemp == 2)||(tabledata[i].istemp == 3) ) {
                        alert("此处方已开立或已作废！");
                        return;
                    }
                    if (tabledata[i].istemp == 0) {
                        alert("处方中有未暂存的药，请先暂存！");
                        return;
                    }
                    myArray.push(tabledata[i].pid);
                }
                var prescriid = tabledata[0].prescribeid;
                layer.open({
                    type: 1,
                    offset: type,
                    title: '开立处方',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要开立处方吗</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "prescribe/formulation",
                            traditional: true,
                            data: {
                                'ids': myArray,
                                'prescriid': prescriid
                            },
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message);
                                } else {
                                    layer.msg(res.message);
                                }

                                setTimeout(function () {
                                    layui.table.reload('test-table-cellEdit-middle', {
                                        page: {
                                            curr: 1
                                        }
                                    });
                                }, 100);
                                layer.closeAll();
                                $("#prestatus").empty();
                                document.getElementById("prestatus").setAttribute("value", "已开立");
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        })
                        layer.closeAll();
                        layui.table.reload('test-table-cellEdit-middle', {
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
            //添加药品
            //asdasd
            add: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                var myArray = new Array();

                if (tabledata.length != 0) {
                    for (var i = 0; i < tabledata.length; i++) {
                        if((tabledata[0].istemp == 2)||(tabledata[0].istemp == 3)) {
                            alert("此项目已开立或已作废,不能添加新药");
                            return;
                        }
                    }
                }
                layer.open({
                    type: 1,
                    title: "新增药品",
                    area: ['450px', '350px'],
                    shade: 0,
                    maxmin: true,
                    content: '<iframe src="prescribe/addmed?drugid=103" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
                    yes: function (index, layero) {

                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("add");
                        $.ajax({
                            type: "POST",
                            url: "prescribe/addmedtest",
                            data: 'doctorid='+3+'&medicalrecordid='+3+'&'+$(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {} else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                // 就是单楚栋之前弄的一个刷新
                                    // window.parent.location.reload('test-table-reload',{page: {curr: 1}});
                                    layui.table.reload('test-table-cellEdit-middle');
                                }, 100);
                                layer.closeAll();
                                // var money = 0;
                                // for (var i = 0; i < tabledata.length; i++) {
                                //     money += tabledata[i].price*tabledata[i].amount;
                                // }
                                // $("#totalmoney").empty();
                                // $("#totalmoney").html(money);
                                $("#prestatus").empty();
                                document.getElementById("prestatus").setAttribute("value", "未暂存");
                                // document.getElementById("totalmoney").setAttribute("value",money);

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

            add_muban: function () {
                var that = this;
                layer.open({
                    type: 1,
                    title: '添加模板',
                    area: ['700px', '600px'],
                    shade: 0,
                    maxmin: true,
                    //此处的createman的值和1004行中的doctorid都是同一个值,
                    //测试传值为string,后期改成用int的id去查医生姓名和科室名
                    content: '<iframe src="prescribe/addModel?createman=3&createdept=3" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
                    yes: function (index, layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("addmodel");
                        var table = iframes.layui.table;
                        var tabledata = table.cache['test-table-toolbar'];
                        var drugsnames = new Array();
                        var formats = new Array();
                        var prices = new Array();
                        var usages = new Array();
                        var dosages = new Array();
                        var units = new Array();
                        var timess = new Array();
                        var entrusts = new Array();
                        for (var i = 0; i < tabledata.length; i++) {
                            drugsnames.push(encodeURI(tabledata[i].drugsname));
                            // drugsnames.push(tabledata[i].drugsname);
                            formats.push(tabledata[i].format);
                            prices.push(tabledata[i].price);
                            usages.push(tabledata[i].usage);
                            dosages.push(tabledata[i].dosage);
                            units.push(tabledata[i].unit);
                            timess.push(tabledata[i].times);
                            entrusts.push(tabledata[i].entrust);
                        }
                        $.ajax({
                            type: "POST",
                            url: "prescribe/addmuban",
                            // data: $(form).serialize(),
                            // data: {'examcheckSet':$(form).serialize(),
                            //        'setInfo':myArray},
                            // data:$.param({'examcheckSetInfos':myArray})+'&'+$(form).serialize(),
                            data:'drugsnames='+drugsnames+'&formats='+formats+'&prices='+prices+'&usages='+usages+'&dosages='+dosages+'&units='+units+'&timess='+timess+'&entrusts='+entrusts+'&'+$(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message)
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                    layui.table.reload('test-table-cellEdit-middle', {
                                        page: {
                                            curr: 1
                                        }
                                    });

                                    // window.parent.location.reload('test-table-reload',{page: {curr: 1}});

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
            }

        };

        $('#LAY-component-layer-special-demo .layadmin-layer-demo .layui-btn').on('click', function () {
            var othis = $(this),
                method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
        $('#LAY-component-layer-special-demo2 .layadmin-layer-demo .layui-btn').on('click', function () {
            var othis = $(this),
                method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
</script>

</body>

</html>