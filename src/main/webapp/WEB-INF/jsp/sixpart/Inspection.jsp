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
    <title>检查/检验登记</title>
    <!-- <meta name="renderer" content="webkit"> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">


</head>

<body style="background-color: white">

    <div class="layui-card-body">
        <div class=" layui-card">
            <div class="layui-row">
                <div class="layui-card-header">
                    检查/检验登记
                </div>

                <div class="layui-col-md8">
                    <div class="layui-fluid" id="LAY-component-layer-special-demo">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <label class="layui-form-label">患者查询:</label>
                            </div>
                            <div class="layui-input-inline">
                                <input class="layui-input" type="text" id="demoReload" placeholder="请输入患者姓名或病历号">
                            </div>
                            <div class="layui-input-inline">
<%--                                <input class="layui-btn layui-btn-normal" type="button" value="查询">--%>
                                <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
                            </div>
                        </div>
                        <div class="layui-inline">

                            <div class="layui-btn-container layadmin-layer-demo" style="margin-top: 2.5%">
                                <div class="layui-input-inline">
                                    <a data-method="dengji" class="layui-btn layui-btn-normal" type="button" value=""><i class="layui-icon">&#xe605;</i>登记</a>
                                </div>

                                <div class="layui-input-inline">
                                    <a data-method="bulu" class="layui-btn layui-btn-normal" type="button"
                                       value=""><i class="layui-icon">&#xe654;</i>医技项目补录</a>
                                </div>

                                <div class="layui-input-inline">
                                    <a data-method="jcjy" class="layui-btn layui-btn-normal" type="button"
                                       value=""><i class="layui-icon">&#xe642;</i>检查/检验结果录入</a>
                                </div>

                                <div class="layui-input-inline">
                                    <a data-method="result" class="layui-btn layui-btn-normal" type="button"
                                       value=""><i class="layui-icon">&#xe705;</i>查看检查/检验结果</a>
                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="layui-table-body" style="margin-top:1% ">
                        <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>
                    </div>





                </div>

                <div class="layui-col-md4" id="layui-col-md4">
                    <div class="layui-card" style="margin-left: 5px;">
                        <div class="layui-card-header">
                            常用项目维护
                        </div>
                        <div class="layui-card-header">
                            <div class="layui-btn-group">
                                <input data-method="oftenadd" class="layui-btn layui-btn-sm" type="button" value="增加">
                                <input data-method="oftendelete" class="layui-btn layui-btn-sm" type="button" value="删除">
                                <input data-method="oftenuse" class="layui-btn layui-btn-sm" type="button" value="引用">
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





    <script src="department/layui/layui.js"></script>

    <!-- 左侧表格 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'table'], function () {
            var admin = layui.admin,
                table = layui.table;

            table.render({
                elem: '#test-table-toolbar',
                // url: layui.setter.base + 'json/table/demo.js',
                url: 'sixpart/findpro',
                method:'get',
                toolbar: '#test-table-toolbar-toolbarDemo',
                title: '用户数据表',
                parseData:function (res) {
                    //TODO:解析JSON对象
                    return {
                        "code":res.status,
                        "msg":res.message,
                        "count":res.total,
                        "data":res.data
                    }
                },
                cols: [
                    [{
                        type: 'checkbox',
                        fixed: 'left'
                    }, {
                        field: 'medical_record_no',
                        title: '病历号',
                        width: 150,
                        fixed: 'left',
                        sort: true
                    }, {
                        field: 'patient_name',
                        title: '患者姓名',
                        width: 90,

                    }, {
                        field: 'itemname',
                        title: '项目名称',
                        width: 90,

                    }, {
                        field: 'number',
                        title: '项目数量',
                        width: 90,

                    },
                        {
                            field: 'goal',
                            title: '项目目的',
                            width: 90,

                        },
                        {
                            field: 'requirement',
                            title: '项目要求',
                            width: 90,

                        },
                        {
                            field: 'mark',
                            title: '项目类别',
                            width: 90,

                        },
                        {
                        field: 'status',
                        title: '项目状态',
                            width: 106,

                    }]
                ],
                page: true
            });



            //头工具栏事件
            table.on('toolbar(test-table-toolbar)', function (obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case 'getCheckData':

                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：' + data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选' : '未全选');
                        break;
                };
            });

            //监听行工具事件
            table.on('tool(test-table-toolbar)', function (obj) {
                var data = obj.data;
                if (obj.event === 'del') {

                    layer.confirm('真的删除行么', function (index) {
                        obj.del();
                        layer.close(index);
                    });
                } else if (obj.event === 'edit') {
                    layer.prompt({
                        formType: 2,
                        value: data.email
                    }, function (value, index) {
                        obj.update({
                            email: value
                        });
                        layer.close(index);
                    });
                }
            });

            // 搜索函数X
            var $ = layui.$, active = {
                reload: function () {
                    var demoReload = $('#demoReload');

                    //执行重载
                    table.reload('test-table-toolbar', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            medical_record_no: demoReload.val(),
                            patient_name:demoReload.val()
                        }
                    },'data');
                }
            };

            $('.layui-col-md8 .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

        });
    </script>

    <!-- 右侧表格 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'table'], function () {
            var table = layui.table;

            table.render({
                elem: '#test-table-checkbox',
                url: 'sixpart/findoften',
                method:'get',
                title: '常用项目表',
                parseData:function (res) {
                    //TODO:解析JSON对象
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
                        field: 'drugsname',
                        width: 180,
                        title: '项目名称',
                        sort: true
                    }, {
                        field: 'drugsprice',

                        title: '项目单价'
                    }]
                ],
                page: true
            });

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
                bulu: function () {
                    var that = this;
                    var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                    if(tabledata.length!=1) {
                        layer.msg("请选中某患者的一条数据再进行补录");
                        return;
                    }
                   var medical_record_no= tabledata[0].medical_record_no;
                    var itemname= tabledata[0].itemname;

                    layer.open({
                        type: 1,
                        title: '医技项目补录',
                        area: ['390px', '360px'],
                        shade: 0,
                        maxmin: true,
                        offset: [],
                        content: '<iframe src="sixpart/index3" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['补录', '关闭'],
                        yes: function (index,layero) {
                            var iframes = $(layero).find("iframe")[0].contentWindow;
                            //获取子界面中对应输入框的值
                            var drugid = $(iframes.document).find("#drugid").val();
                            var number = $(iframes.document).find("#number").val();
                            $.ajax({
                                type: "POST",
                                url: "sixpart/addpro?medical_record_no="+medical_record_no+"&itemname="+itemname+"&drugid="+drugid+"&number="+number,
                                success: function (res) {
                                    if (res.status == 0) {
                                        layer.msg(res.message)
                                    } else {
                                        layer.msg(res.message)
                                    }
                                    setTimeout(function(){
                                        window.parent.location.reload();//修改成功后刷新父界面
                                    }, 100);
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

                jcjy: function () {
                    var that = this;
                    var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                    if(tabledata.length!=1) {
                        layer.msg("请先选中要录入结果的项目");
                        return;
                    }
                    var medical_record_no= tabledata[0].medical_record_no;
                    var itemname= tabledata[0].itemname;
                    var patient_name= tabledata[0].patient_name;
                    layer.open({
                        type: 1,
                        title: '检查/检验结果录入',
                        area: ['550px', '600px'],
                        shade: 0,
                        maxmin: true,
                        offset: 'auto',
                        content: '<iframe src="sixpart/index4?medical_record_no='+medical_record_no+'&itemname='+itemname+'&patient_name='+patient_name+'" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['确定', '取消'],
                        yes: function (index,layero) {
                            var iframes = $(layero).find("iframe")[0].contentWindow;
                            //获取子界面中对应输入框的值
                            var suojian = $(iframes.document).find("#suojian").val();
                            var advice = $(iframes.document).find("#advice").val();
                            $.ajax({
                                type: "POST",
                                url: "sixpart/resultadd?medical_record_no="+medical_record_no+"&itemname="+itemname+"&suojian="+suojian+"&advice="+advice,
                                success: function (res) {
                                    if (res.status == 0) {
                                        layer.msg(res.message)
                                    } else {
                                        layer.msg(res.message)
                                    }
                                    setTimeout(function(){
                                        window.parent.location.reload();//修改成功后刷新父界面
                                    }, 100);
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

                dengji: function () {
                    var that = this;
                    var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                    var myArray = new Array();
                    var myArray1 = new Array();
                    if(tabledata.length!=1) {
                        layer.msg("请选中一条要登记的项目");
                        return;
                    }
                    for (var i = 0; i < tabledata.length; i++) {
                        if(tabledata[i].status != "已缴费") {
                            layer.msg("请选择状态为已缴费的项目,项目"+tabledata[i].itemname+tabledata[i].status);
                            return;
                        }
                        myArray.push(tabledata[i].medical_record_no);
                        myArray1.push(tabledata[i].itemname);
                    }
                    layer.open({
                        type: 1,
                        title: '检查/检验项目登记',
                        area: ['190px', '160px'],
                        shade: 0,
                        maxmin: true,
                        offset: 'auto',
                        content: '<p style="margin:auto;">您确定要登记选中项吗</p>',
                        btn: ['确定', '取消'],
                        yes: function () {
                            // 写下编辑的提交方法**********************************************************
                            $.ajax({
                                type: "POST",
                                url: "sixpart/dengjipro",
                                traditional: true,
                                data: {
                                    'myArray': myArray,
                                    'myArray1': myArray1
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

                result: function () {
                    var that = this;
                    var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                    if(tabledata.length!=1||tabledata[0].status != "已录入结果") {
                        layer.msg("请先选中一条要查看结果的项目");
                        return;
                    }

                    var medical_record_no= tabledata[0].medical_record_no;
                    var itemname= tabledata[0].itemname;
                    var patient_name= tabledata[0].patient_name;
                    layer.open({
                        type: 1,
                        title: '检查/检验结果查看',
                        area: ['550px', '600px'],
                        shade: 0,
                        maxmin: true,
                        offset: 'auto',
                        content: '<iframe src="sixpart/getresult?medical_record_no='+medical_record_no+'&itemname='+itemname+'&patient_name='+patient_name+'" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['确定', '取消'],
                        yes: function () {
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

                oftenadd: function () {
                    layer.open({
                        type: 1,
                        title: '医技项目补录',
                        area: ['390px', '360px'],
                        shade: 0,
                        maxmin: true,
                        offset: [],
                        content: '<iframe src="sixpart/index5" frameborder="0" class="layadmin-iframe"></iframe>',
                        btn: ['添加', '关闭'],
                        yes: function (index,layero) {
                            var iframes = $(layero).find("iframe")[0].contentWindow;
                            //获取子界面中对应输入框的值
                            var drugid = $(iframes.document).find("#drugid").val();
                            $.ajax({
                                type: "POST",
                                url: "sixpart/addoften?drugid="+drugid,
                                success: function (res) {
                                    if (res.status == 0) {
                                        layer.msg(res.message)
                                    } else {
                                        layer.msg(res.message)
                                    }
                                    setTimeout(function(){
                                        window.parent.location.reload();//修改成功后刷新父界面
                                    }, 100);
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
                        layer.msg("请选择需要删除的项目");
                        return;
                    }
                    var myArray = new Array();
                    for (var i = 0; i < tabledata.length; i++) {
                        myArray.push(tabledata[i].drugsname);
                    }
                    layer.open({
                        type: 1,
                        offset: type,
                        title: '项目删除',
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
                                url: "sixpart/deleteoften",
                                traditional: true,
                                data: {
                                    'names': myArray
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

                oftenuse: function () {
                    var that = this;
                    var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                    var tabledata1 = layui.table.checkStatus('test-table-checkbox').data;
                    if(tabledata.length!=1) {
                        layer.msg("请选中某患者的一条数据再进行引用");
                        return;
                    }
                    if(tabledata1.length!=1) {
                        layer.msg("请选中一条需要引用的项目");
                        return;
                    }
                    var medical_record_no= tabledata[0].medical_record_no;
                    var itemname= tabledata[0].itemname;

                    var drugname = tabledata1[0].drugsname;

                    layer.open({
                        type: 1,
                        title: '医技项目补录',
                        area: ['390px', '360px'],
                        shade: 0,
                        maxmin: true,
                        offset: [],
                        content: '<p style="margin:auto;">您确定要引用选中项吗</p>请输入引用材料的数量：<input class="layui-input"  id="usenumber" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>',
                        btn: ['引用', '关闭'],
                        yes: function () {
                            var number = $('#usenumber').val();
                            $.ajax({
                                type: "POST",
                                // url: "sixpart/useoften?medical_record_no="+medical_record_no+"&drugname="+drugname+"&number="+number+"&itemname="+itemname,
                                url: "sixpart/useoften",
                                data: {
                                    'medical_record_no': medical_record_no,
                                    'drugname': drugname,
                                    'number': number,
                                    'itemname': itemname
                                },
                                success: function (res) {
                                    if (res.status == 0) {
                                        layer.msg(res.message)
                                    } else {
                                        layer.msg(res.message)
                                    }
                                    setTimeout(function(){
                                        window.parent.location.reload();//修改成功后刷新父界面
                                    }, 100);
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

            $('#layui-col-md4 .layui-btn-group .layui-btn').on('click', function () {
                var othis = $(this),
                    method = othis.data('method');
                active[method] ? active[method].call(this, othis) : '';
            });
        });
    </script>

</body>




</html>