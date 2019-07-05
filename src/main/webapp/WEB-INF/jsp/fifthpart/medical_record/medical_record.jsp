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
    <title>门诊病历首页</title>
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
        <form id="medicalRecord" class="layui-form">
<%--            todo:栅栏--%>
            <div id="zuo" class="layui-col-md9">
                <!-- 中部折叠面板 -->
                <div class="layui-card" style="overflow: auto;height:600px;">
                    <div class="layui-card-header">门（急）诊面板信息</div>
                    <div class="layui-card-body">
                        <div class="layui-collapse" lay-filter="component-panel">
                            <div class="layui-colla-item">
                                <h2 class="layui-colla-title">病史内容</h2>
                                <div class="layui-colla-content layui-show" style="height: 400px;">
                                    <!-- 中部内容1 -->
                                    <div class="layui-col-md12">
                                        <div style="float: left;width: 10%;margin-left: 20px;">
                                            <p style="margin-top: 7px;">主诉:</p>
                                        </div>
                                        <div style="float: right;width: 80%;margin-right: 20px;">
                                            <input class="layui-input" autocomplete="off" name="chiefComplaint" style="float: left;" >
                                        </div>
                                    </div>

                                    <div class="layui-col-md12" style="margin-top: 10px;">
                                        <div style="float: left;width: 10%;margin-left: 20px;">
                                            <p style="margin-top: 7px;">现病史:</p>
                                        </div>
                                        <div style="float: right;width: 80%;margin-right: 20px;">
                                            <textarea name="hpi" placeholder="" class="layui-textarea"
                                                      style="float: right;"></textarea>
                                        </div>
                                    </div>

                                    <div class="layui-col-md12" style="margin-top: 10px;">
                                        <div style="float: left;width: 10%;margin-left: 20px;">
                                            <p style="margin-top: 7px;">既往史:</p>
                                        </div>
                                        <div style="float: right;width: 80%;margin-right: 20px;">
                                            <textarea name="ph" placeholder="" class="layui-textarea"
                                                      style="float: right;"></textarea>
                                        </div>
                                    </div>

                                    <div class="layui-col-md12" style="margin-top: 10px;">
                                        <div style="float: left;width: 10%;margin-left: 20px;">
                                            <p style="margin-top: 7px;">个人史:</p>
                                        </div>
                                        <div style="float: right;width: 80%;margin-right: 20px;">
                                            <textarea name="historyOfAllergy" placeholder="" class="layui-textarea"
                                                      style="float: right;"></textarea>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="layui-colla-item">
                                <h2 class="layui-colla-title">检查及结果</h2>
                                <div class="layui-colla-content layui-show" style="height: 250px;">
                                    <!-- 中部内容2 -->

                                    <div class="layui-col-md12" style="margin-top: 10px;">
                                        <div style="float: left;width: 15%;margin-left: 20px;">
                                            <p style="margin-top: 7px;">体格检查:</p>
                                        </div>
                                        <div style="float: right;width: 75%;margin-right: 20px;">
                        <textarea name="healthCheckup" placeholder="" class="layui-textarea"
                                  style="float: right;height: 70px;;"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-colla-item" style="height: 400px;">
                                <h2 class="layui-colla-title">评估、诊断</h2>
                                <div class="layui-colla-content layui-show">
                                    <!-- 中部内容3 -->

                                    <div class="layui-col-md12" style="margin-top: 10px;">
                                        <div style="width: 30%;float: left">
                                            <p>诊断：</p>
                                        </div>
                                        <div style="width: 70%;float: right">
                                            <div class="layui-fluid" id="LAY-component-layer-special-demo">
                                                <div class="layui-btn-container layadmin-layer-demo">
                                                    <div class="layui-btn-group" style="float: right">
                                                        <button type="button" data-method="add" data-type="auto"
                                                            class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon">&#xe654;</i></button>
                                                        <button type="button" data-method="update" data-type="auto" class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon">&#xe642;</i></button>
                                                        <button type="button" data-method="delete" data-type="auto" class="layui-btn  layui-btn-sm"><i
                                                                class="layui-icon">&#xe640;</i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="layui-col-md12">
                                            <table class="layui-hide" id="test-table-simple3"></table>
                                        </div>


                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- 中 -->
                <div class="layui-card" style="bottom: 30px;position: relative;padding-left: 20%" >

                    <button  type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="subm"
                            style="margin:0 auto;right: -300px;position: relative;" >确诊
                    </button>
                    <button id="zhenbi" type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="quezhen"
                            style="margin:0 auto;right: -300px;position: relative;" >诊毕
                    </button>
                    <button type="reset" class="layui-btn layui-btn-danger"
                            style="margin:0 auto;left: 300px;position: relative;">清屏
                    </button>


                </div>
            </div>
        </form>
<%--        todo:栅栏--%>
        <div class="layui-col-md3" id="you">
            <div class="layui-fluid" id="component-tabs2">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                            <ul class="layui-tab-title">
                                <li class="layui-this">病历模板</li>
                                <li>常用诊断</li>
                            </ul>
                            <div class="layui-tab-content">
                                <div class="layui-tab-item layui-show">
                                    <!-- 选项卡1中内容 -->
                                    <!-- 右侧树状图 -->
                                    <div class="layui-fluid" id="LAY-component-layer-special-demo2">
                                        <div class="layui-btn-container layadmin-layer-demo">
                                            <div class="layui-btn-group" style="align-content: center;">
                                                <button id="addmu" type="button" data-method="addmu" data-type="auto" class="layui-btn  layui-btn-sm" >
                                                    <i class="layui-icon">&#xe654;</i></button>
                                                <button id="deletemu" type="button" lay-demo="getChecked" class="layui-btn  layui-btn-sm" ><i class="layui-icon">&#xe640;</i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="test9"></div>

                                </div>
                                <div class="layui-tab-item">
                                    <div class="layui-inline">
                                        <c:forEach items="${CommonDiagnosises}" varStatus="flag" var="CommonDiagnosis">
                                            <div class="layui-btn-group">
                                                <button type="button" class=" layui-btn layui-btn-primary layui-btn-xs"
                                                        style="float: left;margin-top: 1%;" value="${CommonDiagnosises.indexOf(CommonDiagnosis)}" lay-submit lay-filter="dia">${CommonDiagnosis.diseasename}
                                                </button>
                                                <button type="button" class="layui-btn layui-btn-danger layui-btn-xs" value="${CommonDiagnosises.indexOf(CommonDiagnosis)}" lay-submit lay-filter="deletedia"><i
                                                        class="layui-icon layui-icon-delete"></i></button>
                                            </div>
                                        </c:forEach>



                                    </div>

                                </div>
<%--                                <div class="layui-tab-item">--%>
<%--                                    历史病历内容--%>
<%--                                </div>--%>

                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>

    </div>
</div>


<script src="department/layui/layui.js?t=1"></script>

<!-- 选项卡 -->
<script>
    window.onload = function () {
        var $ = layui.$;
        var isSeen="${isSeen}";
        if (isSeen == "") {
            var buttons2 = document.getElementById("LAY-component-layer-special-demo2");
            buttons2.parentNode.removeChild(buttons2);
            return;
        }
        var inputs = $("input");
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].readOnly=true;
        }
        var textareas = $("textarea");
        for (var i = 0; i < textareas.length; i++) {
            textareas[i].readOnly=true;
        }
        var buttons = $("button");
        for (var i = 0; i < buttons.length; i++) {
            if (buttons[i].id == "addmu" || buttons[i].id == "deletemu") {
                continue;
            }
            buttons[i].disabled = true;
        }
        $.ajax({
            type: "GET",
            url: "MedicalRecordPage/getHistory?&medicalRecordNo=${medicalRecordNo}",
            async : false,
            // data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2,
            success: function (res) {
                var rdata=res.data;
                if (res.status == 0) {
                    document.getElementsByName("chiefComplaint")[0].value=rdata.chiefComplaint;
                    // document.getElementsByName("chiefComplaint")[0].disabled=true;
                    document.getElementsByName("hpi")[0].value=rdata.hpi;
                    // document.getElementsByName("hpi")[0].readOnly=true;
                    document.getElementsByName("ph")[0].value=rdata.ph;
                    // document.getElementsByName("ph")[0].disabled=true;
                    document.getElementsByName("historyOfAllergy")[0].value=rdata.historyOfAllergy;
                    document.getElementsByName("healthCheckup")[0].value=rdata.healthCheckup;
                    $.ajax({
                        type: "POST",
                        url: "MedicalRecordPage/findDiaYi?medicalRecordNo=${medicalRecordNo}",
                        async : false,
                        // data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2,
                        success: function (res) {
                            var rdata=res.data;
                            if (res.status == 0) {
                                layui.table.render({
                                    elem: '#test-table-simple3',
                                    cellMinWidth: 200 //全局定义常规单元格的最小宽度
                                    ,cols: [[
                                        {
                                            checkbox: true,
                                            fixed: true
                                        }, {
                                            field: 'id',
                                            width: 80,
                                            title: 'ID',
                                            sort: true
                                        }, {
                                            field: 'diseasename',
                                            width: 313,
                                            title: '疾病名称'
                                        }, {
                                            field: 'medicalRecordNo',
                                            width: 300,
                                            title: '病历号',
                                            sort: true
                                        }, {
                                            field: 'flag',
                                            width: 120,
                                            title: '主诊/疑似标志',
                                            templet: function (d) {
                                                var state = "";
                                                if (d.flag == "0") {
                                                    state = '<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" disabled>';
                                                }
                                                else if (d.flag == "1") {
                                                    state = '<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" checked disabled>';

                                                }

                                                return state;
                                            }
                                            ,unresize: true
                                        }, {
                                            field: 'dA',
                                            width: 300,
                                            title: '发病日期',
                                            templet: function (d) {
                                                return dateToStr(d.dA);
                                            }
                                        }]],
                                    data:rdata

                                });
                            } else {
                                layer.msg(res.message)
                            }
                        },
                        error: function () {
                            alert("出现错误");
                            return false;
                        }
                    }) //ajax结束
                    layer.msg(res.message)
                } else {
                    layer.msg(res.message)
                }
            },
            error: function () {
                alert("出现错误");
                return false;
            }
        }); //ajax结束


    };
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
        var form = layui.form;
        form.render();
        form.on('submit(subm)', function(data){
            $.ajax({
                type: "POST",
                url: "MedicalRecordPage/submit",
                data: $('#medicalRecord').serialize()+"&medicalRecordNo=${medicalRecordNo}",
                success: function (res) {
                    // if (res.status == 0) {
                    // } else {
                    //     layer.msg(res.message)
                    // }
                    var inputs = $("input");
                    for (var i = 0; i < inputs.length; i++) {
                        inputs[i].readOnly=true;
                    }
                    var textareas = $("textarea");
                    for (var i = 0; i < textareas.length; i++) {
                        textareas[i].readOnly=true;
                    }
                    var buttons = $("button");
                    for (var i = 0; i < buttons.length; i++) {
                        if (buttons[i].id == "zhenbi") {
                            continue;
                        }
                        buttons[i].disabled=true;
                    }
                    var you=document.getElementById("you");
                    var zuo=document.getElementById("zuo");
                    zuo.className="layui-col-md12";
                    you.parentNode.removeChild(you);
                    alert("提交成功");
                    // layer.closeAll();
                    // layui.table.reload('test-table-reload',{page: {curr: 1}});
                },
                error: function () {
                    alert("出现错误");
                    return false;
                }
            })
        });

        form.on('submit(dia)', function(data){
            $.ajax({
                type: "POST",//方法类型
                url: "MedicalRecordPage/addcommon",//url
                async: false,
                // data: $("#form").serialize()+"&myarray="+myarray,
                data: "index="+data.elem.value,
                success: function (result) {
                    layui.table.reload('test-table-simple3');
                },
                error: function (result) {
                    alert(result.msg);
                }
            })
        });
        form.on('submit(deletedia)', function(data){
            var res = confirm("确定删除这一常用诊断吗?");
            if (!res) {
                return;
            }
            $.ajax({
                type: "POST",//方法类型
                url: "MedicalRecordPage/deletecommon",//url
                async: false,
                // data: $("#form").serialize()+"&myarray="+myarray,
                data: "index="+data.elem.value,
                success: function (result) {
                    layui.table.reload('test-table-simple3');
                },
                error: function (result) {
                    alert(result.msg);
                }
            });
        });
        form.on('submit(quezhen)', function(data){
            $.ajax({
                type: "POST",//方法类型
                url: "MedicalRecordPage/quezhen",
                data:"medicalRecordNo=${medicalRecordNo}",//url
                async: false,
                // data: $("#form").serialize()+"&myarray="+myarray,
                success: function (result) {
                    parent.parent.location.reload();
                    // if (res.status == 0) {
                    // } else {
                    //     layer.msg(res.message)
                    // }

                    // layui.table.reload('test-table-simple3');
                },
                error: function (result) {
                    alert(result.msg);
                }
            })
        });
        <%--form.on('submit(addmu)', function(data){--%>
        <%--    var id;--%>
        <%--    var res = confirm("确定添加病历模板?");--%>
        <%--    if (!res) {--%>
        <%--        return;--%>
        <%--    }--%>
        <%--    $.ajax({--%>
        <%--        type: "POST",--%>
        <%--        url: "MedicalRecordPage/submit",--%>
        <%--        data: $('#medicalRecord').serialize()+"&medicalRecordNo=${medicalRecordNo}",--%>
        <%--        success: function (res) {--%>
        <%--             id=res.data;--%>
        <%--            // layer.closeAll();--%>
        <%--            // layui.table.reload('test-table-reload',{page: {curr: 1}});--%>
        <%--        },--%>
        <%--        error: function () {--%>
        <%--            alert("出现错误");--%>
        <%--            return false;--%>
        <%--        }--%>
        <%--    })--%>

        //     $.ajax({
        //         type: "POST",//方法类型
        //         url: "MedicalRecordPage/addmu",//url
        //         async: false,
        //         // data: $("#form").serialize()+"&myarray="+myarray,
        //         data: "index="+data.elem.value,
        //         success: function (result) {
        //             layui.table.reload('test-table-simple3');
        //         },
        //         error: function (result) {
        //             alert(result.msg);
        //         }
        //     });
        // });
        // form.on('submit(updatemu)', function(data){
        //     var res = confirm("确定修改病历模板?");
        //     if (!res) {
        //         return;
        //     }
        //     $.ajax({
        //         type: "POST",//方法类型
        //         url: "MedicalRecordPage/updatemu",//url
        //         async: false,
        //         // data: $("#form").serialize()+"&myarray="+myarray,
        //         data: "index="+data.elem.value,
        //         success: function (result) {
        //             layui.table.reload('test-table-simple3');
        //         },
        //         error: function (result) {
        //             alert(result.msg);
        //         }
        //     });
        // });
        // form.on('submit(deletemu)', function(data){
        //     var res = confirm("确定删除病历模板?");
        //     if (!res) {
        //         return;
        //     }
        //     $.ajax({
        //         type: "POST",//方法类型
        //         url: "MedicalRecordPage/deletemu",//url
        //         async: false,
        //         // data: $("#form").serialize()+"&myarray="+myarray,
        //         data: "index="+data.elem.value,
        //         success: function (result) {
        //             layui.table.reload('test-table-simple3');
        //         },
        //         error: function (result) {
        //             alert(result.msg);
        //         }
        //     });
        // });
        /* 触发事件 */
        var active = {
            tabAdd: function () {
                /* 新增一个Tab项 */
                element.tabAdd('demo', {
                    title: '新选项' + (Math.random() * 1000 | 0) /* 用于演示 */,
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
            location.hash = '/' + layui.router().path.join('/') + '#layid=' + $(this).attr('lay-id');
        });
    });
</script>


<!-- 数据表格1 -->
<%--<script>--%>
<%--    layui.config({--%>
<%--        base: 'department/' //静态资源所在路径--%>
<%--    }).extend({--%>
<%--        index: 'lib/index' //主入口模块--%>
<%--    }).use(['index', 'table'], function () {--%>
<%--        var table = layui.table;--%>

<%--        table.render({--%>
<%--            elem: '#test-table-simple1',--%>
<%--            url: layui.setter.base + 'json/table/user.js',--%>
<%--            cellMinWidth: 80 //全局定义常规单元格的最小宽度--%>
<%--            ,--%>
<%--            cols: [--%>
<%--                [{--%>
<%--                    field: 'id',--%>
<%--                    width: 80,--%>
<%--                    title: 'ID',--%>
<%--                    sort: true--%>
<%--                }, {--%>
<%--                    field: 'name',--%>
<%--                    width: 80,--%>
<%--                    title: '姓名'--%>
<%--                }, {--%>
<%--                    field: 'age',--%>
<%--                    width: 80,--%>
<%--                    title: '年龄',--%>
<%--                    sort: true--%>
<%--                }]--%>
<%--            ]--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<!-- 数据表格2 -->
<%--<script>--%>
<%--    layui.config({--%>
<%--        base: 'department/' //静态资源所在路径--%>
<%--    }).extend({--%>
<%--        index: 'lib/index' //主入口模块--%>
<%--    }).use(['index', 'table'], function () {--%>
<%--        var table = layui.table;--%>

<%--        table.render({--%>
<%--            elem: '#test-table-simple2',--%>
<%--            url: layui.setter.base + 'json/table/user.js',--%>
<%--            cellMinWidth: 80 //全局定义常规单元格的最小宽度--%>
<%--            ,--%>
<%--            cols: [--%>
<%--                [{--%>
<%--                    field: 'id',--%>
<%--                    width: 80,--%>
<%--                    title: 'ID',--%>
<%--                    sort: true--%>
<%--                }, {--%>
<%--                    field: 'name',--%>
<%--                    width: 80,--%>
<%--                    title: '姓名'--%>
<%--                }, {--%>
<%--                    field: 'age',--%>
<%--                    width: 80,--%>
<%--                    title: '年龄',--%>
<%--                    sort: true--%>
<%--                }]--%>
<%--            ]--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<!-- 诊断数据表格3 -->
<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
        var table = layui.table;
//todo:渲染表格
        table.render({
            elem: '#test-table-simple3',
            url: "MedicalRecordPage/findDiaAll?medicalRecordNo=${medicalRecordNo}",
            cellMinWidth: 200 //全局定义常规单元格的最小宽度
            ,parseData:function (res) {
                //TODO:解析JSON对象
                return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                }
            }
            ,cols: [[
                {
                    checkbox: true,
                    fixed: true
                }, {
                    field: 'id',
                    width: 80,
                    title: 'ID',
                    sort: true
                }, {
                    field: 'diseasename',
                    width: 313,
                    title: '疾病名称'
                }, {
                    field: 'medicalRecordNo',
                    width: 300,
                    title: '病历号',
                    sort: true
                }, {
                    field: 'flag',
                    width: 120,
                     title: '主诊/疑似标志',
                    templet: function (d) {
                        var state = "";
                        if (d.flag == "0") {
                            state = '<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" disabled>';
                        }
                        else if (d.flag == "1") {
                            state = '<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" checked disabled>';

                        }

                        return state;
                    }
                    ,unresize: true
                }, {
                    field: 'dA',
                    width: 300,
                    title: '发病日期',
                    templet: function (d) {
                          return dateToStr(d.dA);
                          }
                }]]
            ,
            // done : function(res, curr, count){
            //     console.log(layui.table);
            //     var tabledata=  layui.table.cache["test-table-simple3"];
            //     console.log(tabledata);
            // }
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

<script>
    layui.use(['tree', 'util'], function () {
        var $=layui.$;
        var data = [];
        $.ajax({
            type: "get",
            async : false,//设置为同步操作就可以给全局变量赋值成功
            url: "MedicalRecordPage/getsets",
            success: function (res) {
                // var mydata = [];
                var children1=[];
                var children2=[];
                var children3=[];
                var data1 =[];
                var data2 =[];
                var data3 =[];
                for(var i=0;i<res.length;i++){
                    // alert(examcheckSets[i].setname);
                    //测试成功！！！

                    if(res[i].type==0) {
                        data1 = {
                            title:res[i].name,
                            id:res[i].id
                        };
                        children1.push(data1);
                    }

                    if(res[i].type==1) {
                        data2 = {
                            title:res[i].name,
                            id:res[i].id
                        };
                        children2.push(data2);
                    }

                    if(res[i].type==2) {
                        data3 = {
                            title:res[i].name,
                            id:res[i].id
                        };
                        children3.push(data3);
                    }
                    // alert(JSON.stringify(children3));
                }

                var data4 ={
                    title: '全院组套模板',
                    id: -3,
                    children:children1
                };

                var data5 ={
                    title: '科室组套模板',
                    id: -2,
                    children:children2
                };

                var data6 ={
                    title: '个人组套模板',
                    id: -1,
                    children:children3
                };

                data.push(data4);
                data.push(data5);
                data.push(data6);
                //将json对象转换成字符串
                // alert(JSON.stringify(mydata));

            }
        });
        var tree = layui.tree,
            layer = layui.layer,
            util = layui.util;


        //基本演示
        tree.render({
            elem: '#test9',
            data: data,
            showCheckbox: true, //是否显示复选框
            onlyIconControl: true,
            id: 'demoId1',
            isJump: true,//是否允许点击节点时弹出新窗口跳转
            click: function (obj) {
                var isSeen="${isSeen}";
                if (isSeen!="") {
                    alert("该病人已经看诊完毕!");
                    return;
                }
                var data = obj.data;
                // data.title
                if(data.id==-1||data.id==-2||data.id==-3) {
                    layer.msg("请选择二级菜单里面的模板");
                    return;
                }
                // document.getElementsByName("chiefComplaint")[0].value="123";
                $.ajax({
                    type: "GET",
                    url: "MedicalRecordPage/getTemplate?&id="+data.id,
                    async : false,
                    // data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2,
                    success: function (res) {
                        var rdata=res.data;
                        if (res.status == 0) {
                            document.getElementsByName("chiefComplaint")[0].value=rdata.chiefComplaint;
                            document.getElementsByName("hpi")[0].value=rdata.hpi;
                            document.getElementsByName("ph")[0].value=rdata.ph;
                            document.getElementsByName("historyOfAllergy")[0].value=rdata.historyOfAllergy;
                            document.getElementsByName("healthCheckup")[0].value=rdata.healthCheckup;
                            $.ajax({
                                type: "POST",
                                url: "MedicalRecordPage/findDiaAllAndSub?medicalRecordNoNew=${medicalRecordNo}&medicalRecordNoOld="+rdata.medicalRecordNo,
                                async : false,
                                // data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2,
                                success: function (res) {
                                    layui.table.reload("test-table-simple3");
                                    // var rdata=res.data;
                                    // if (res.status == 0) {
                                    //    layui.table.render({
                                    //         elem: '#test-table-simple3',
                                    //         cellMinWidth: 200 //全局定义常规单元格的最小宽度
                                    //         ,cols: [[
                                    //             {
                                    //                 checkbox: true,
                                    //                 fixed: true
                                    //             }, {
                                    //                 field: 'id',
                                    //                 width: 80,
                                    //                 title: 'ID',
                                    //                 sort: true
                                    //             }, {
                                    //                 field: 'diseasename',
                                    //                 width: 313,
                                    //                 title: '疾病名称'
                                    //             }, {
                                    //                 field: 'medicalRecordNo',
                                    //                 width: 300,
                                    //                 title: '病历号',
                                    //                 sort: true
                                    //             }, {
                                    //                 field: 'flag',
                                    //                 width: 120,
                                    //                 title: '主诊/疑似标志',
                                    //                 templet: function (d) {
                                    //                     var state = "";
                                    //                     if (d.flag == "0") {
                                    //                         state = '<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" disabled>';
                                    //                     }
                                    //                     else if (d.flag == "1") {
                                    //                         state = '<input id="flag" type="checkbox" name="flag" lay-filter="flag" lay-skin="switch" lay-text="疑似|主诊" checked disabled>';
                                    //
                                    //                     }
                                    //
                                    //                     return state;
                                    //                 }
                                    //                 ,unresize: true
                                    //             }, {
                                    //                 field: 'dA',
                                    //                 width: 300,
                                    //                 title: '发病日期',
                                    //                 templet: function (d) {
                                    //                     return dateToStr(d.dA);
                                    //                 }
                                    //             }]],
                                    //         data:rdata
                                    //
                                    //     });
                                //     } else {
                                //         layer.msg(res.message)
                                //     }
                                },
                                error: function () {
                                    alert("出现错误");
                                    return false;
                                }
                            }) //ajax结束
                            layer.msg(res.message)
                        } else {
                            layer.msg(res.message)
                        }
                    },
                    error: function () {
                        alert("出现错误");
                        return false;
                    }
                }) //ajax结束
                // document.getElementById("chiefComplaint").value="123";//获取当前点击的节点数据
                // document.getElementById("chiefComplaint").value
                layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
            }
            // ,operate: function(obj){
            //     var type = obj.type; //得到操作类型：add、edit、del
            //     var data = obj.data; //得到当前节点的数据
            //     var elem = obj.elem; //得到当前节点元素
            //
            //     //Ajax 操作
            //     var id = data.id;
            //     alert(id);//得到节点索引
            //     if(type === 'add'){ //增加节点
            //         //返回 key 值
            //         return 123;
            //     } else if(type === 'update'){ //修改节点
            //         console.log(elem.find('.layui-tree-txt').html()); //得到修改后的内容
            //     } else if(type === 'del'){ //删除节点
            //
            //     };
            // }
        });

        //按钮事件
        util.event('lay-demo', {
            getChecked: function (othis) {
                var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
                var ids = [];
                //获取子节点数据
                for(var i=0;i<checkedData.length;i++) {
                    var children = checkedData[i].children;
                    for (var j = 0; j < children.length; j++) {
                        ids.push(children[j].id);
                    }
                }
                $.ajax({
                    type: "POST",//方法类型
                    url: "MedicalRecordPage/deletemu",//url
                    async: false,
                    // data: $("#form").serialize()+"&myarray="+myarray,
                    data: "ids="+ids,
                    success: function (result) {

                    },
                    error: function (result) {

                        alert(result.msg);
                    }
                });
                layer.closeAll();
                layui.table.reload('test-table-simple3');
            },
            setChecked: function () {
                tree.setChecked('demoId1', [12, 16]); //勾选指定节点
            },
            reload: function () {
                //重载实例
                tree.reload('demoId1', {});

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
        // tree.render({
        //     elem: '#test9',
        //     data: data1,
        //     edit: ['add', 'update', 'del'] //操作节点的图标
        //     ,
        //     click: function (obj) {
        //         // layer.msg(JSON.stringify(obj.data));
        //     }
        // });
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

            addmu: function (othis) {
                var that = this;
                layer.open({
                    type: 1,
                    title: '添加病历模板',
                    area: ['450px', '250px'],
                    shade: 0,
                    maxmin: true,//<div class="layui-fluid" id="html1"><div class="layui-row layui-col-space15">                                                                                                                                                                            //'+tabledata[0].id+'
                    // content: '<form id="tianjia"><input type="text" name="name"/> </form>',
                    content: '<form id="tianjia" style="padding: 20px;">模板名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" autocomplete="off" style="width: 200px;height:20%;display: inline;margin:10px;" /><br>类别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select  name="type" style="width: 200px;display: inline;margin:10px;" ><option value="0">全院</option><option value="1">科室</option><option value="2">个人</option></select></form>',
                    // content: '<h1>111222</h1>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                                $.ajax({
                                    type: "POST",
                                    url: "MedicalRecordPage/addmu",
                                    data: $('#tianjia').serialize()+"&medicalRecordNo=${medicalRecordNo}",
                                    async:false,
                                    success: function (res) {
                                        // layer.closeAll();
                                        // layui.table.reload('test-table-reload',{page: {curr: 1}});
                                    },
                                    error: function () {
                                        alert("cuowu");
                                        return false;
                                    }
                                });
                                layer.closeAll();
                                parent.window.location.reload();
                                // layui.table.reload('test-table-reload',{page: {curr: 1}});

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
            add: function (othis) {
                var that = this;
                layer.open({
                    type: 1,
                    title: '添加诊断',
                    area: ['450px', '450px'],
                    shade: 0,
                    maxmin: true,
                    //todo:加参数 window.onload赋值
                    content: '<iframe name="myframe" src="MedicalRecordPage/indexadd?medicalRecordNo=${medicalRecordNo}" frameborder="0" class = "layadmin-iframe"></iframe>',
                    // content: '<h1>111222</h1>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                        myframe.window.submit();
                        layer.closeAll();
                        layui.table.reload('test-table-simple3');
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

            update: function (othis) {
                var tabledata=layui.table.checkStatus('test-table-simple3').data;
                var that = this;
                layer.open({
                    type: 1,
                    title: '编辑诊断',
                    area: ['450px', '450px'],
                    shade: 0,
                    maxmin: true,
                    //todo:传值给uptate
                    content: '<iframe name="myframe" src="MedicalRecordPage/indexupdate?date='+dateToStr(tabledata[0].dA)+'&medicalRecordNo=${medicalRecordNo}&flag='+tabledata[0].flag+'&diseaseid='+tabledata[0].diseaseid+'&id='+tabledata[0].id+'" frameborder="0" class = "layadmin-iframe"></iframe>',
                    // content: '<h1>111222</h1>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                        myframe.window.submit();
                        layer.closeAll();
                        layui.table.reload('test-table-simple3');

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
            } ,
            delete: function (othis) {
                var tabledata=layui.table.checkStatus('test-table-simple3').data;
                if (tabledata.length == 0) {
                    alert("请选定要删除的诊断！");
                    return;
                }
                var ids = [];
                for (var i = 0; i < tabledata.length; i++) {
                    ids.push(tabledata[i].id);
                }
                var that = this;
                layer.open({
                    type: 1,
                    title: '删除诊断',
                    area: ['450px', '150px'],
                    shade: 0,
                    maxmin: true,
                    content: '<h2 align="center">确定删除这些诊断吗?</h2>',
                    // content: '<h1>111222</h1>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                        $.ajax({
                            type: "POST",//方法类型
                            url: "MedicalRecordPage/delete",//url
                            async: false,
                            // data: $("#form").serialize()+"&myarray="+myarray,
                            data: "ids="+ids,
                            success: function (result) {

                            },
                            error: function (result) {

                                alert(result.msg);
                            }
                        });
                        layer.closeAll();
                        layui.table.reload('test-table-simple3');
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
            deletecomdia: function (othis) {
                var tabledata=layui.table.checkStatus('test-table-simple3').data;
                if (tabledata.length == 0) {
                    alert("请选定要删除的诊断！");
                    return;
                }
                var ids = [];
                for (var i = 0; i < tabledata.length; i++) {
                    ids.push(tabledata[i].id);
                }
                var that = this;
                layer.open({
                    type: 1,
                    title: '删除诊断',
                    area: ['450px', '150px'],
                    shade: 0,
                    maxmin: true,
                    content: '<h2 align="center">确定删除这些诊断吗?</h2>',
                    // content: '<h1>111222</h1>',
                    btn: ['确定', '全部关闭'],
                    yes: function () {
                        $.ajax({
                            type: "POST",//方法类型
                            url: "MedicalRecordPage/delete",//url
                            async: false,
                            // data: $("#form").serialize()+"&myarray="+myarray,
                            data: "ids="+ids,
                            success: function (result) {

                            },
                            error: function (result) {

                                alert(result.msg);
                            }
                        });
                        layer.closeAll();
                        layui.table.reload('test-table-simple3');
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
<script>
    //对Date的扩展，将 Date 转化为指定格式的String
    //月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    //年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    //例子：
    //(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    //(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    function dateToStr(date) {
        //author: meizz
        var time = new Date(date.time);
        var y = time.getFullYear();
        var M = time.getMonth() + 1;
        M = M < 10 ? ("0" + M) : M;
        var d = time.getDate();
        d = d < 10 ? ("0" + d) : d;
        var h = time.getHours();
        h = h < 10 ? ("0" + h) : h;
        var m = time.getMinutes();
        m = m < 10 ? ("0" + m) : m;
        var s = time.getSeconds();
        s = s < 10 ? ("0" + s) : s;
        var str = y + "-" + M + "-" + d;
        return str;

    }
</script>
<script id="createTime" type="text/html">
    {{#
    return dateToStr(d.dA);
    }}
</script>
</body>

</html>