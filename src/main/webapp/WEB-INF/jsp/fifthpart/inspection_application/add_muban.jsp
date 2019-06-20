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
    <title>检查组套</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>
<%--    <div class="layui-fluid" id="html1">--%>
<%--        <div class="layui-row layui-col-space15">--%>
<%--            <div class="layui-card layui-form" lay-filter="component-form-element">--%>
<%--                <div style="padding: 20px;">--%>

<%--                    <div class="layui-row">--%>
<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 150%">组合编码：</p>--%>
<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <input class="layui-input" name="setcode" autocomplete="off">--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <div style="margin-left: 5px">--%>
<%--                                    <p style="margin: auto;font-size: 150%;">组合名称：</p>--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <input class="layui-input" name="setname" autocomplete="off">--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 150%">业务分类：</p>--%>
<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <select name="week" lay-verify="required" disabled="disabled">--%>
<%--                                    <option value="">请选择项目</option>--%>
<%--                                    <option value="01">项目一</option>--%>
<%--                                    <option value="02">项目二</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <div style="margin-left: 5px">--%>
<%--                                    <p style="margin: auto;font-size: 150%;">单据分类：</p>--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <select name="week" lay-verify="required" lay-search>--%>
<%--                                    <option value="">请选择项目</option>--%>
<%--                                    <option value="01">项目一</option>--%>
<%--                                    <option value="02">项目二</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 150%">服务分类：</p>--%>
<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <select name="week" lay-verify="required" disabled="disabled">--%>
<%--                                    <option value="">请选择项目</option>--%>
<%--                                    <option value="01">项目一</option>--%>
<%--                                    <option value="02">项目二</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <div style="margin-left: 5px">--%>
<%--                                    <p style="margin: auto;font-size: 150%;">适用范围：</p>--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <select name="limits" lay-verify="required" lay-search>--%>
<%--                                    <option value="">请选择项目</option>--%>
<%--                                    <option value="0">全院</option>--%>
<%--                                    <option value="1">科室</option>--%>
<%--                                    <option value="2">个人</option>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">--%>
<%--                            <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 150%;">临床印象：</p>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10">--%>
<%--                                <div class="layui-input-block" style="margin-left: 10%">--%>
<%--                                    <textarea name="impression" placeholder="" class="layui-textarea"--%>
<%--                                        style="min-height: 50px"></textarea>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">--%>
<%--                            <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 150%;">临床诊断：</p>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10">--%>
<%--                                <div class="layui-input-block" style="margin-left: 10%">--%>
<%--                                    <textarea name="diagnosis" placeholder="" class="layui-textarea"--%>
<%--                                        style="min-height: 50px"></textarea>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">--%>
<%--                            <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 110%;">目的和要求：</p>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10">--%>
<%--                                <div class="layui-input-block" style="margin-left: 10%">--%>
<%--                                    <textarea name="requirement" placeholder="" class="layui-textarea"--%>
<%--                                        style="min-height: 50px"></textarea>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <!-- 分割线 -->--%>
<%--                        <hr class="layui-bg-green">--%>

<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <p style="margin: auto;font-size: 150%">创建医生：</p>--%>
<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <input class="layui-input" id="" autocomplete="off" readonly>--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                                <div style="margin-left: 5px">--%>
<%--                                    <p style="margin: auto;font-size: 150%;">创建科室：</p>--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">--%>
<%--                                <input class="layui-input" id="" autocomplete="off" readonly>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="layui-col-xs1 layui-col-sm1 layui-col-md1">--%>
<%--                            <div class="layui-fluid" id="LAY-component-layer-special-demo">--%>
<%--                                <div class="layui-btn-container layadmin-layer-demo">--%>
<%--                            <div class="layui-card-body">--%>
<%--                                <div class="layui-btn-group">--%>


<%--                                    <button data-method="add" class=" layui-btn layui-btn-xs layui-btn-normal"><i--%>
<%--                                            class="layui-icon">&#xe654;</i>增加</button>--%>
<%--                                    <button class=" layui-btn layui-btn-xs layui-btn-normal"><i--%>
<%--                                            class="layui-icon">&#xe640;</i>删除</button>--%>
<%--                                    <button class=" layui-btn layui-btn-xs layui-btn-normal"><i--%>
<%--                                            class="layui-icon">&#xe642;</i>修改</button>--%>
<%--                                    <button class=" layui-btn layui-btn-xs layui-btn-normal"><i--%>
<%--                                            class="layui-icon">&#xe615;</i>查询</button>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <div class="layui-col-xs11 layui-col-sm11 layui-col-md11">--%>
<%--                            <div class="layui-input-block" style="margin-left: 18%">--%>
<%--                                <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar">--%>
<%--                                </table>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                    </div>--%>

<%--                </div>--%>

<%--            </div>--%>


<%--        </div>--%>

<%--    </div>--%>
    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;">

                    <div class="layui-row">
                        <form id="add"  role="form">
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <p style="margin: auto;font-size: 150%">组合编码：</p>
                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <input class="layui-input" name="setcode" autocomplete="off">
                            </div>
                        </div>


                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <div style="margin-left: 5px">
                                    <p style="margin: auto;font-size: 150%;">组合名称：</p>
                                </div>

                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <input class="layui-input" name="setname" autocomplete="off">
                            </div>
                        </div>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <p style="margin: auto;font-size: 150%">业务分类：</p>
                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <select name="week" lay-verify="required" disabled="disabled">
                                    <option value="">请选择项目</option>
                                    <option value="01">项目一</option>
                                    <option value="02">项目二</option>
                                </select>
                            </div>
                        </div>


                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <div style="margin-left: 5px">
                                    <p style="margin: auto;font-size: 150%;">单据分类：</p>
                                </div>

                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <select name="week" lay-verify="required" lay-search>
                                    <option value="">请选择项目</option>
                                    <option value="01">项目一</option>
                                    <option value="02">项目二</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <p style="margin: auto;font-size: 150%">服务分类：</p>
                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <select name="week" lay-verify="required" disabled="disabled">
                                    <option value="">请选择项目</option>
                                    <option value="01">项目一</option>
                                    <option value="02">项目二</option>
                                </select>
                            </div>
                        </div>


                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <div style="margin-left: 5px">
                                    <p style="margin: auto;font-size: 150%;">适用范围：</p>
                                </div>

                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <select name="limits" lay-verify="required" lay-search>
                                    <option value="">请选择项目</option>--%>
                                    <option value="0">全院</option>
                                    <option value="1">科室</option>
                                    <option value="2">个人</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                                <p style="margin: auto;font-size: 150%;">临床印象：</p>

                            </div>
                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10">
                                <div class="layui-input-block" style="margin-left: 10%">
                                    <textarea name="impression" placeholder="" class="layui-textarea"
                                              style="min-height: 50px"></textarea>
                                </div>
                            </div>
                        </div>

                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                                <p style="margin: auto;font-size: 150%;">临床诊断：</p>

                            </div>
                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10">
                                <div class="layui-input-block" style="margin-left: 10%">
                                    <textarea name="diagnosis" placeholder="" class="layui-textarea"
                                              style="min-height: 50px"></textarea>
                                </div>
                            </div>
                        </div>

                        <div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
                            <div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
                                <p style="margin: auto;font-size: 110%;">目的和要求：</p>

                            </div>
                            <div class="layui-col-xs10 layui-col-sm10 layui-col-md10">
                                <div class="layui-input-block" style="margin-left: 10%">
                                    <textarea name="requirement" placeholder="" class="layui-textarea"
                                              style="min-height: 50px"></textarea>
                                </div>
                            </div>
                        </div>

                        <!-- 分割线 -->
                        <hr class="layui-bg-green">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <p style="margin: auto;font-size: 150%">创建医生：</p>
                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <input class="layui-input" id="" autocomplete="off" readonly>
                            </div>
                        </div>


                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">
                                <div style="margin-left: 5px">
                                    <p style="margin: auto;font-size: 150%;">创建科室：</p>
                                </div>

                            </div>
                            <div class="layui-col-xs6 layui-col-sm6 layui-col-md10">
                                <input class="layui-input" id="" autocomplete="off" readonly>
                            </div>
                        </div>
                        </form>
                        <div class="layui-col-xs1 layui-col-sm1 layui-col-md1">
                            <div class="layui-card-body">
                                <div class="layui-fluid" id="LAY-component-layer-special-demo">
                                    <div class="layui-btn-container layadmin-layer-demo">
                                        <div class="layui-btn-group">

                                            <button data-method="add"
                                                    class=" layui-btn layui-btn-xs layui-btn-normal"><i
                                                    class="layui-icon" type="button">&#xe654;</i>增加</button>
                                            <button data-method="deltable" class=" layui-btn layui-btn-xs layui-btn-normal"><i
                                                    class="layui-icon">&#xe640;</i>删除</button>
                                            <button class=" layui-btn layui-btn-xs layui-btn-normal"><i
                                                    class="layui-icon">&#xe642;</i>修改</button>
                                            <button class=" layui-btn layui-btn-xs layui-btn-normal"><i
                                                    class="layui-icon">&#xe615;</i>查询</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="layui-col-xs11 layui-col-sm11 layui-col-md11">
                            <div class="layui-input-block" style="margin-left: 18%">
                                <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar">
                                </table>
                            </div>
                        </div>

                    </div>



                </div>





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

    <!-- 数据表格 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'table'], function () {
            var admin = layui.admin,
                table = layui.table;
            var table1 = parent.layui.table;
            var tabledata = table1.checkStatus('test-table-cellEdit-middle').data;
            var myData = [];
            for (var i = 0; i < tabledata.length; i++) {
                var data1={itemcode:tabledata[i].itemcode,itemname:tabledata[i].itemname,requirement:tabledata[i].requirement,number:i};
                myData.push(data1);
            }
            JSON.stringify(myData);
            table.render({
                elem: '#test-table-toolbar',
                // url: layui.setter.base + 'json/table/demo.js',
                // toolbar: '#test-table-toolbar-toolbarDemo',
                title: '项目数据表',
                width: 475,
                cols: [
                    [{
                        type: 'checkbox',
                        fixed: 'left'
                    }, {
                            field: 'itemcode',
                            title: '项目编码',
                            width: 200,
                            edit: 'text',
                            sort: true
                        }, {
                        field: 'itemname',
                        title: '项目名称',
                        width: 200,
                        edit: 'text',
                        sort: true
                    }, {
                        field: 'requirement',
                        title: '医生嘱托',
                        width: 200,
                        edit: 'text'
                    }]
                ],
                data:myData,
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

        });
    </script>


<%--<!-- 弹窗模块 -->--%>
<%--<script>--%>
<%--    layui.config({--%>
<%--        base: 'department/' //静态资源所在路径--%>
<%--    }).extend({--%>
<%--        index: 'lib/index' //主入口模块--%>
<%--    }).use(['index'], function () {--%>
<%--        var $ = layui.$,--%>
<%--            admin = layui.admin,--%>
<%--            element = layui.element,--%>
<%--            router = layui.router();--%>

<%--        element.render();--%>

<%--        var active = {--%>
<%--            //添加检查检验项目--%>
<%--            add: function () {--%>
<%--                var that = this;--%>

<%--                layer.open({--%>
<%--                    type: 1,--%>
<%--                    title: '添加项目',--%>
<%--                    area: ['450px', '350px'],--%>
<%--                    shade: 0,--%>
<%--                    maxmin: true,--%>
<%--                    content: '<iframe src="fifthpart/addUI?id=${id}" frameborder="0" class = "layadmin-iframe"></iframe>',--%>
<%--                    btn: ['确定', '全部关闭'],--%>
<%--                    yes: function (index,layero) {--%>
<%--                        var iframes = $(layero).find("iframe")[0].contentWindow;--%>
<%--                        var form = iframes.document.getElementById("add");--%>
<%--                        $.ajax({--%>
<%--                            type: "POST",--%>
<%--                            url: "fifthpart/add?doctorid=5&medicalid=5",--%>
<%--                            data: $(form).serialize(),--%>
<%--                            success: function (res) {--%>
<%--                                if (res.status == 0) {--%>
<%--                                    layer.msg(res.message)--%>
<%--                                } else {--%>
<%--                                    layer.msg(res.message)--%>
<%--                                }--%>
<%--                                setTimeout(function(){--%>
<%--                                    window.parent.location.reload();//修改成功后刷新父界面--%>
<%--                                }, 100);--%>
<%--                            },--%>
<%--                            error: function () {--%>
<%--                                alert("出现错误");--%>
<%--                                return false;--%>
<%--                            }--%>
<%--                        }) //ajax结束--%>
<%--                    },--%>
<%--                    btn2: function () {--%>
<%--                        layer.closeAll();--%>
<%--                    }--%>

<%--                    ,--%>
<%--                    zIndex: layer.zIndex,--%>
<%--                    success: function (layero) {--%>
<%--                        layer.setTop(layero);--%>
<%--                    }--%>
<%--                });--%>
<%--            },--%>
<%--            };--%>
<%--        $('#LAY-component-layer-special-demo .layadmin-layer-demo .layui-btn').on('click', function () {--%>
<%--            var othis = $(this),--%>
<%--                method = othis.data('method');--%>
<%--            active[method] ? active[method].call(this, othis) : '';--%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>
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
//删除特定选中项目
            deltable: function () {
                layer.closeAll();
                layer.msg('确定要删除项目吗', {
                    // time: 20 * 1000,
                    btn: ['确定', '取消'],
                    yes: function () {
                        var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                        var oldData =layui.table.cache["test-table-toolbar"];
                        for (var i = 0; i < tabledata.length; i++) {
                            for(var j = 0; j < oldData.length; j++) {
                                if(oldData[j].itemcode == tabledata[i].itemcode) {
                                    oldData.splice(j, 1);
                                }
                            }
                        }
                        layui.table.reload('test-table-toolbar',{
                            data : oldData
                        });
                        layer.closeAll();
                    },
                    btn2: function () {
                        layer.closeAll();
                    }

                });

            },


            add: function () {
                var that = this;
                layer.open({
                    type: 1,
                    title: '添加检查项目',
                    area: ['450px', '350px'],
                    shade: 0,
                    maxmin: true,

                    content: '<iframe src="fifthpart/addUI?id=03" frameborder="0" class = "layadmin-iframe"></iframe>',
                    btn: ['确定', '全部关闭'],
                     yes: function (index,layero) {
                        var iframes = $(layero).find("iframe")[0].contentWindow;
                        var proid = iframes.document.getElementById("fmeditemid").value;
                         var requirement = iframes.document.getElementById("requirement").value;
                         $.ajax({
                             type: "POST",
                             url: 'fifthpart/findprobyid?proid='+proid,
                             success: function (res) {
                                 var itemcode = res.itemcode;
                                 var itemname = res.itemname;
                                 var oldData =layui.table.cache["test-table-toolbar"];
                                 var data1={"itemcode":itemcode,"itemname":itemname,"requirement":requirement};
                                 oldData.push(data1);
                                 layui.table.reload('test-table-toolbar',{
                                     data : oldData
                                 });
                             },
                             error: function () {
                                 alert("出现错误");
                                 return false;
                             }
                         }) //ajax结束
                        // var oldData =layui.table.cache["test-table-toolbar"];
                        // var data1={"itemcode":itemcode,"itemname":,"requirement":requirement};
                        // oldData.push(data1);
                        //  layui.table.reload('test-table-toolbar',{
                        //     data : oldData
                        // });
                        layer.closeAll();
                        // $.ajax({
                        //     type: "POST",
                        //     url: "fifthpart/add?doctorid=5&medicalid=5",
                        //     data: $(form).serialize(),
                        //     success: function (res) {
                        //         if (res.status == 0) {
                        //             layer.msg(res.message)
                        //         } else {
                        //             layer.msg(res.message)
                        //         }
                        //
                        //     },
                        //     error: function () {
                        //         alert("出现错误");
                        //         return false;
                        //     }
                        // }) //ajax结束
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
                    area: ['700px', '700px'],
                    shade: 0,
                    maxmin: true,

                    content: '<iframe src="add_muban.html" frameborder="0" class="layadmin-iframe"></iframe>',
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
            }

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