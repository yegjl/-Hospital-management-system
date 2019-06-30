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
    <title>检查/检验结果录入</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>

<body>

    <div class="layui-fluid" id="html1">
        <div class="layui-row layui-col-space15">
            <div class="layui-card layui-form" lay-filter="component-form-element">
                <div style="padding: 20px;">

                    <div class="layui-row">

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">病历号：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="medical_record_no" autocomplete="off" value="${medical_record_no}">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">患者姓名：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="patient_name" autocomplete="off" value="${patient_name}">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">项目名称：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <input class="layui-input" id="itemname" autocomplete="off" value="${itemname}">
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">检查/检验所见：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <textarea name="" id="suojian" placeholder="请输入" class="layui-textarea"></textarea>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">诊断建议：</p>
                        </div>
                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">
                            <textarea name="" id="advice" placeholder="请输入" class="layui-textarea"></textarea>
                        </div>
                        <br>

                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md1">
                            <p style="margin: auto;">上传检查/检验结果图片：</p>
                        </div>
<%--                        <div class="layui-col-xs6 layui-col-sm6 layui-col-md11">--%>
<%--                            <div class="layui-card">--%>
<%--                                <div class="layui-card-body">--%>
<%--                                    <div class="layui-upload-drag" id="test-upload-drag">--%>
<%--                                        <i class="layui-icon"></i>--%>
<%--                                        <p>点击上传，或将文件拖拽到此处</p>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="layui-upload">
                            <button type="button" class="layui-btn" id="test2">多图片上传</button>
                            <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                                预览图：
                                <div class="layui-upload-list" id="demo2"></div>
                            </blockquote>
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

    <!-- 文件上传 -->
    <script>
        layui.config({
            base: 'department/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'upload'], function () {
            var $ = layui.jquery,
                upload = layui.upload;
            //选完文件后不自动上传
            upload.render({
                elem: '#test-upload-change',
                url: '/upload/',
                auto: false
                    //,multiple: true
                    ,
                bindAction: '#test-upload-change-action',
                done: function (res) {
                    console.log(res)
                }
            });

            //拖拽上传
            upload.render({
                elem: '#test-upload-drag',
                url: '/upload/',
                done: function (res) {
                    console.log(res)
                }
            });

            //多文件列表示例
            var demoListView = $('#test-upload-demoList'),
                uploadListIns = upload.render({
                    elem: '#test-upload-testList',
                    url: '/upload/',
                    accept: 'file',
                    multiple: true,
                    auto: false,
                    bindAction: '#test-upload-testListAction',
                    choose: function (obj) {
                        var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                        //读取本地文件
                        obj.preview(function (index, file, result) {
                            var tr = $(['<tr id="upload-' + index + '">', '<td>' + file.name +
                                '</td>', '<td>' + (file.size / 1014).toFixed(1) +
                                'kb</td>', '<td>等待上传</td>', '<td>',
                                '<button class="layui-btn layui-btn-mini test-upload-demo-reload layui-hide">重传</button>',
                                '<button class="layui-btn layui-btn-mini layui-btn-danger test-upload-demo-delete">删除</button>',
                                '</td>', '</tr>'
                            ].join(''));

                            //单个重传
                            tr.find('.test-upload-demo-reload').on('click', function () {
                                obj.upload(index, file);
                            });

                            //删除
                            tr.find('.test-upload-demo-delete').on('click', function () {
                                delete files[index]; //删除对应的文件
                                tr.remove();
                                uploadListIns.config.elem.next()[0].value =
                                    ''; //清空 input file 值，以免删除后出现同名文件不可选
                            });

                            demoListView.append(tr);
                        });
                    },
                    done: function (res, index, upload) {
                        if (res.code == 0) { //上传成功
                            var tr = demoListView.find('tr#upload-' + index),
                                tds = tr.children();
                            tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                            tds.eq(3).html(''); //清空操作
                            return delete this.files[index]; //删除文件队列已经上传成功的文件
                        }
                        this.error(index, upload);
                    },
                    error: function (index, upload) {
                        var tr = demoListView.find('tr#upload-' + index),
                            tds = tr.children();
                        tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                        tds.eq(3).find('.test-upload-demo-reload').removeClass('layui-hide'); //显示重传
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

            //多图片上传
            upload.render({
                elem: '#test2'
                ,url: 'sixpart/uploadFile'
                ,accept: 'file'
                ,multiple: true
                ,before: function(obj){
                    //预读本地文件示例，不支持ie8
                    obj.preview(function(index, file, result){
                        $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img" height="200" width="220">')
                    });
                }
                ,done: function(res){
                    // var picurl=JSON.stringify(res.data);
                    var picurl=res.data;
                    $.ajax({
                        type: "POST",
                        data:'picurl='+picurl+"&medical_record_no=${medical_record_no}&itemname=${itemname}",
                        url: "sixpart/resultpic",
                        async:false,
                        success: function (res1) {
                            if (res.status == 0) {
                                layer.msg(res1.message);
                            } else {
                                layer.msg(res1.message);
                            }
                        }
                    });
                    // layer.msg(JSON.stringify(res.data));
                }
            });

        });
    </script>
</body>

</html>