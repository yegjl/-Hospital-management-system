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
<%--    //todo:改为el name--%>
<%--   prescribetype:如果是西医(deptcategoryid!=20)，就传成药，如果是deptcategoryid==20就是中医，传草药 --%>
    <title>${prescribetype}处方</title>
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
<%--                        //todo:改为el name--%>
                            <p style="font-size: 200%;font-weight: 500;">${prescribetype}处方</p>
                        </div>

                        <div class="layui-col-md1">
                            <div style="margin-top: 55%;margin-left: 5px;">
                                <p>处方类型</p>
                            </div>
                        </div>
                        <div class="layui-col-md2">
                            <div style="margin-top: 22%;width: 70%" class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                                <input class="layui-input" value="${prestatus}" name="pretype" id="pretype" autocomplete="off" readonly>
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
<%--                    //todo:改为el name--%>
                        <legend>${prescribetype}处方药品详情</legend>
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
                                <button data-method="send_expense" class="layui-btn  layui-btn-sm"
                                        style="margin: 1%">发送</button>
<%--                                发送按钮将存储的--%>
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
                                                                class="layui-icon" lay-demo="getChecked">&#xe640;</i></button>
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
                                        <div class="layui-card-header">
                                            <div class="layui-btn-group" id="often">
                                                <div class="layui-fluid" id="LAY-component-layer-special-demo3">
                                                <input data-method="oftenadd" class="layui-btn layui-btn-sm" type="button" value="增加">
                                                <input data-method="oftendelete" class="layui-btn layui-btn-sm" type="button" value="删除">
                                                <input data-method="oftenuse" class="layui-btn layui-btn-sm" type="button" value="引用">
                                            </div>
                                            </div>
                                        </div>

                                        <div class="layui-table-body" style="margin-top:1% ">
                                            <table class="layui-hide" id="test-table-checkbox" lay-filter="test-table-toolbar"></table>
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


    });
</script>

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;

        table.render({
            elem: '#test-table-checkbox',
            url: 'prescribe/findoften?doctorid=${sessionScope.doctorid}',
            method:'get',
            title: '常用项目表',
            parseData:function (res) {
                return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                }
            },
            cols: [
                [{
                    type: 'checkbox'
                }, {
                    field: 'medicalname',
                    title: '药品名称',
                    sort: true
                }]
            ],
            page: true
        });

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

            //todo:连接
            url: 'prescribe/gettestinfo?medicalrecordid=${medicalRecordNo}&&doctorid=${sessionScope.doctorid}',
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


<!-- 树 -->
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" language="JavaScript">
    window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
</script>
<script>
    layui.use(['tree', 'util'], function () {
        var tree = layui.tree,
            layer = layui.layer,
            util = layui.util,
            data = [];
        $.ajax({
            type: "get",
            async : false,//设置为同步操作就可以给全局变量赋值成功
            url: "fifthpart/getprescribemodel",
            success: function (models) {
                var mydata = [];
                var children1=[];
                var children2=[];
                var children3=[];
                var data1 =[];
                var data2 =[];
                var data3 =[];
                for(var i=0;i<models.length;i++){
                    // alert(examcheckSets[i].setname);
                    //测试成功！！！

                    if(models[i].usage==0) {
                        data1 = {
                            title:models[i].prescribemodelname,
                            id:models[i].id
                        };
                        children1.push(data1);
                    }

                    if(models[i].usage==1) {
                        data2 = {
                            title:models[i].prescribemodelname,
                            id:models[i].id
                        };
                        children2.push(data2);
                    }

                    if(models[i].usage==2) {
                        data3 = {
                            title:models[i].prescribemodelname,
                            id:models[i].id
                        };
                        children3.push(data3);
                    }
                    // alert(JSON.stringify(children3));
                }

                var data4 ={
                    title: '全院处方模板',
                    id: 0,
                    children:children1
                };

                var data5 ={
                    title: '科室处方模板',
                    id: 1,
                    children:children2
                };

                var data6 ={
                    title: '个人处方模板',
                    id: 2,
                    children:children3
                };

                mydata.push(data4);
                mydata.push(data5);
                mydata.push(data6);
                //将json对象转换成字符串
                // alert(JSON.stringify(mydata));
                data=mydata;
            }
        });
        //基本演示
        // tree.render({
        //     elem: '#test12',
        //     data: data,
        //     showCheckbox: true //是否显示复选框
        //     ,
        //     id: 'demoId1',
        //     isJump: true //是否允许点击节点时弹出新窗口跳转
        //     ,
        //     click: function (obj) {
        //         var data = obj.data; //获取当前点击的节点数据
        //         // layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
        //     }
        // });

        //按钮事件
        util.event('lay-demo', {
            getChecked: function (othis) {
                var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
                var myArray = new Array();
                //获取子节点数据
                for(var i=0;i<checkedData.length;i++){
                    var children=checkedData[i].children;
                    for(var j=0;j<children.length;j++){
                        myArray.push(children[j].id);
                    }
                }

                layer.open({
                    type: 1,
                    title: '删除组套模板',
                    area: ['260px', '160px'],
                    shade: 0,
                    maxmin: true,
                    content: '<p style="margin:auto;">您确定要删除选中项吗</p>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "fifthpart/deletepremodels",
                            traditional: true,
                            data: {
                                'ids': myArray,
                            },
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message);
                                } else {
                                    layer.msg(res.message);
                                }
                                setTimeout(function(){
                                    window.parent.location.reload();//修改成功后刷新父界面
                                }, 100);
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        })
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



        //开启节点操作图标
        tree.render({
            elem: '#test9',
            data: data,
            id: 'demoId1',
            edit: ['add', 'update', 'del'] //操作节点的图标
            ,
            showCheckbox: true,
            click: function (obj) {
                // layer.msg(JSON.stringify(obj.data));
                layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(obj.data.id));
                if(obj.data.id==0||obj.data.id==1||obj.data.id==2) {
                    layer.msg("请选择二级菜单里面的模板");
                    return;
                }
                layer.open({
                    type: 1,
                    title: '引用处方模板',
                    area: ['700px', '600px'],
                    content: '<iframe src="fifthpart/usePreModel?id='+obj.data.id+'" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['引用组套', '取消'],
                    yes: function (index,layero) {//将组套里面的的项目添加至数据库
                        <%--var iframes = $(layero).find("iframe")[0].contentWindow;--%>
                        <%--var form = iframes.document.getElementById("add");--%>
                        <%--var table = iframes.layui.table;--%>
                        <%--var tabledata = table.checkStatus('test-table-toolbar').data;--%>
                        <%--var myArray = new Array();--%>
                        <%--var myArray1 = new Array();--%>
                        <%--var myArray2 = new Array();--%>
                        <%--for (var i = 0; i < tabledata.length; i++) {--%>
                        <%--    myArray.push(tabledata[i].itemcode);--%>
                        <%--    myArray1.push(tabledata[i].requirement);--%>
                        <%--    myArray2.push(tabledata[i].goal);--%>
                        <%--}--%>
                        <%--$.ajax({--%>
                        <%--    type: "POST",--%>
                        <%--    //todo:连接病历号--%>
                        <%--    url: "fifthpart/usemubanpros?doctorid=${doctorid}&medicalid=${medicalid}&id=${id}",--%>
                        <%--    data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2,--%>
                        <%--    success: function (res) {--%>
                        <%--        if (res.status == 0) {--%>
                        <%--            layer.msg(res.message)--%>
                        <%--        } else {--%>
                        <%--            layer.msg(res.message)--%>
                        <%--        }--%>
                        <%--        setTimeout(function(){--%>
                        <%--            window.parent.location.reload();//修改成功后刷新父界面--%>
                        <%--        }, 100);--%>
                        <%--    },--%>
                        <%--    error: function () {--%>
                        <%--        alert("出现错误");--%>
                        <%--        return false;--%>
                        <%--    }--%>
                        <%--}) //ajax结束--%>
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
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
                                    layui.table.reload('test-table-cellEdit-middle');
                                }, 100);
                                layer.closeAll();
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
                                    layui.table.reload('test-table-cellEdit-middle');
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
                                    layui.table.reload('test-table-cellEdit-middle');
                                }, 100);
                                layer.closeAll();
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
                                    layui.table.reload('test-table-cellEdit-middle');
                                }, 100);
                                layer.closeAll();
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
                var fee = document.getElementById("totalmoney").innerText;//获得界面中的总价钱
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
                        });
                        //TODO：金额已经存入到处方索引表里，缺少发送到expense
                        $.ajax({
                            type: "POST",
                            url: "prescribe/settotalmoney",
                            traditional: true,
                            data: {
                                'id': prescriid,
                                'fee': fee
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
                        });

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
                            alert("此处方已开立或已作废,不能添加新药");
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
                    //todo:统一
                    //drugtypeid应该为101/102/103三个值中的一个
                    <%--content: '<iframe src="prescribe/addmed?drugid=${drugid}" frameborder="0" class = "layadmin-iframe"></iframe>',--%>
                    content: '<iframe src="prescribe/addmed?deptcategoryid=${sessionScope.deptcategoryid}" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
                    yes: function (index, layero) {

                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("add");
                        $.ajax({
                            type: "POST",
                            url: "prescribe/addmedtest",
                            //todo:连接
                            data: 'doctorid=${sessionScope.doctorid}&medicalrecordid=${medicalRecordNo}&prestatus=${prestatus}&medicaltype=${prescribetype}&'+$(form).serialize(),
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
                    //todo:连接(doctorid,depetid)
                    //此处的createman的值和1004行中的doctorid都是同一个值,
                    //测试传值为string,后期改成用int的id去查医生姓名和科室名
                    content: '<iframe src="prescribe/addModel?createman=${sessionScope.doctorid}&createdept=${sessionScope.deptcategoryid}" frameborder="0" class="layadmin-iframe"></iframe>',
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
            },

            //todo:将处方信息发送给expense
            send_expense: function () {
                var tabledata = layui.table.cache['test-table-cellEdit-middle'];
                if (tabledata[0].istemp != 2) {
                    alert("处方未开立或已废除，不能发送！");
                    return;
                }
                var medicalrecordids = new Array();
                var medicalids = new Array();
                var prescribeids = new Array();
                var amounts = new Array();
                var prices = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    medicalrecordids.push(tabledata[i].medicalrecordid);
                    medicalids.push(tabledata[i].medicalid);
                    prescribeids.push(tabledata[i].prescribeid);
                    amounts.push(tabledata[i].amount);
                    prices.push(tabledata[i].price);
                }
                layer.closeAll();
                layer.msg('是否发送至收费处？', {
                    // time: 20 * 1000,
                    btn: ['确定', '取消'],
                    yes: function () {

                        $.ajax({
                            // String[] medicalrecordids, Integer[] medicalids, Integer[] presribeids, Integer[] amounts, Integer[] prices
                            type: "POST",
                            url: "prescribe/sendtoexpense?medicalrecordids=" + medicalrecordids + "&medicalids="+medicalids+"&presribeids="+prescribeids+"&amounts="+amounts+"&prices="+prices,
                            success: function (res) {
                                if (res.status == 0) {
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                    layui.table.reload('test-table-cellEdit-middle');
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

            // 常用项目管理
            oftenadd: function () {
                layer.open({
                    type: 1,
                    title: '常用药品添加',
                    area: ['390px', '360px'],
                    shade: 0,
                    maxmin: true,
                    offset: [],
                    content: '<iframe src="prescribe/indexaddoften?doctorid=${sessionScope.doctorid}" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['添加', '关闭'],
                    yes: function (index,layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("often");
                        $.ajax({
                            type: "POST",
                            url: "prescribe/addoftendrug",
                            data: $(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message)
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function () {
                                   layui.table.reload('test-table-checkbox');
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

            oftendelete: function (othis) {
                var type = othis.data('type'),
                    text = othis.text();
                var tabledata = layui.table.checkStatus('test-table-checkbox').data;
                if(tabledata.length==0){
                    layer.msg("请选择需要删除的药品");
                    return;
                }
                var myArray = new Array();
                for (var i = 0; i < tabledata.length; i++) {
                    myArray.push(tabledata[i].medicalid);
                }
                layer.open({
                    type: 1,
                    offset: type,
                    title: '删除常用药品',
                    id: 'layerDemo' + type,
                    area: ['190px', '160px'],
                    content: '<p style="margin:auto;">您确定要删除选中项吗?</p>',
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    shade: 0,
                    yes: function () {
                        // 写下编辑的提交方法**********************************************************
                        $.ajax({
                            type: "POST",
                            url: "prescribe/deleteoften",
                            traditional: true,
                            data: {
                                'medicalids': myArray
                            },
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message);
                                } else {
                                    layer.msg(res.message);
                                }
                                setTimeout(function () {
                                    layui.table.reload('test-table-checkbox');
                                }, 100);
                                layer.closeAll();
                            },
                            error: function () {
                                alert("出现错误");
                                return false;
                            }
                        })
                        layer.closeAll();
                    },
                    btn2: function () {
                        layer.closeAll();
                    }
                });
            },

            oftenuse: function (othis) {
                var that = this;
                var type = othis.data('type'),
                    text = othis.text();
                var middletable = layui.table.cache['test-table-cellEdit-middle'];
                var myArray = new Array();

                if (middletable.length != 0) {
                    for (var i = 0; i < middletable.length; i++) {
                        if((middletable[0].istemp == 2)||(middletable[0].istemp == 3)) {
                            alert("此处方已开立或已作废,不能添加新药");
                            return;
                        }
                    }
                }
                // var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                var tabledata = layui.table.checkStatus('test-table-checkbox').data;
                if(tabledata.length==0) {
                    layer.msg("请选中一条需要引用的项目");
                    return;
                }
                // var itemname= tabledata[0].itemname;

                layer.open({
                    type: 1,
                    title: '常用药引入',
                    area: ['390px', '360px'],
                    shade: 0,
                    maxmin: true,
                    offset: [],
                    // content: '<p style="margin:auto;">您确定要引用选中项吗</p>请输入引用材料的数量：<input class="layui-input"  id="usenumber" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>',
                    content: '<iframe src="prescribe/indexuseoften?medicalid='+tabledata[0].medicalid+'&medicalname='+tabledata[0].medicalname+'&doctorid=${doctorid}" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['引用', '关闭'],
                    yes: function (index, layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var form = iframes.document.getElementById("useoften");
                        $.ajax({
                            type: "POST",
                            url: "prescribe/addmedtest",
                            data: 'doctorid=${doctorid}&medicalrecordid=${medicalRecordNo}&'+$(form).serialize(),
                            success: function (res) {
                                if (res.status == 0) {
                                    layer.msg(res.message)
                                } else {
                                    layer.msg(res.message)
                                }
                                setTimeout(function(){
                                    layui.table.reload('test-table-cellEdit-middle');//修改成功后刷新父界面
                                }, 100);
                                layer.closeAll();
                                $("#prestatus").empty();
                                document.getElementById("prestatus").setAttribute("value", "未暂存");
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
        $('#LAY-component-layer-special-demo3 .layui-btn').on('click', function () {
            var othis = $(this),
                method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
</script>

</body>

</html>