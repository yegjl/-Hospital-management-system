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

    <script src="department/jQuery/jquery-3.4.1.min.js"></script>
    <script src="jq-load.js"></script>

</head>

<body style="background-color: white">

    <div class="layui-card" style="height: 800px;">
<%--        <div class="layui-card-header" style="font-size: 100%;padding: 500px">--%>
<%--            <div class="layui-inline">--%>
<%--                <label class="layui-form-label" style="font-weight: 600"> 就诊状态: </label>--%>
<%--                <label class="layui-form-label" style="font-weight: 600"> 就诊号: </label>--%>
<%--                <label class="layui-form-label" style="font-weight: 600"> 姓名: </label>--%>
<%--                <label class="layui-form-label" style="font-weight: 600"> 性别: </label>--%>
<%--                <label class="layui-form-label" style="font-weight: 600"> 年龄: </label>--%>
<%--                <label class="layui-form-label" style="font-weight: 600"> 过敏史: </label>--%>
<%--            </div>--%>
<%--            <div class="layui-btn-container" style="float: right">--%>
<%--                <button class="layui-btn layui-btn-lg layui-btn-normal">诊毕</button>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="layui-card-body" style="height: 500px;">
            <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                <ul class="layui-tab-title">
                    <li class="layui-this">门诊病历首页</li>
                    <li>检查申请</li>
                    <li>检验申请</li>
                    <li>处置申请</li>
                    <li>${prescribetype}处方</li>
<%--                    <li>草药处方</li>--%>
                    <li>患者费用明细查询</li>
                    <li>个人工作量统计</li>
                </ul>
                <div class="layui-tab-content" style="height: 100%;">
                    <div class="layui-tab-item layui-show" style="height: 100%">

                        <iframe src="MedicalRecordPage/index?medicalRecordNo=${medicalRecordNo}" style="height: 700px;width: 100%"
                            frameborder="0"></iframe>
                    </div>
<%--                    //检查申请--%>
                    <div class="layui-tab-item">
                        <iframe src="fifthpart/index?id=02&medicalRecordNo=${medicalRecordNo}"
                            style="height: 700px;width: 100%" frameborder="0"></iframe>
                    </div>
<%--                    //检验申请--%>
                    <div class="layui-tab-item">
                        <iframe src="fifthpart/index?id=03&medicalRecordNo=${medicalRecordNo}"
                                style="height: 700px;width: 100%" frameborder="0"></iframe>
                    </div>
<%--                    //处置申请--%>
                    <div class="layui-tab-item">
                        <iframe src="fifthpart/index?id=04&medicalRecordNo=${medicalRecordNo}"
                                style="height: 700px;width: 100%" frameborder="0"></iframe>
                    </div>
                    <div class="layui-tab-item"><iframe src="fifthpart/index?id=05&medicalRecordNo=${medicalRecordNo}&word=未开立"style="height: 700px;width: 100%" frameborder="0"></iframe></div>
<%--                    <div class="layui-tab-item"><iframe src="fifthpart/index?id=06"--%>
<%--                            style="height: 700px;width: 100%" frameborder="0"></iframe></div>--%>
<%--                    <div class="layui-tab-item"><iframe src="login/index12?medicalRecordNo=${medicalRecordNo}" style="height: 700px;width: 100%" frameborder="0"></iframe></div>--%>
                    <div class="layui-tab-item"><iframe src="MedicalRecordPage/indexcost" style="height: 700px;width: 100%" frameborder="0"></iframe></div>
                    <div class="layui-tab-item"><iframe src="selfstatis/indexselfstatis?doctorid=${sessionScope.doctorid}" style="height: 700px;width: 100%" frameborder="0"></iframe></div>
                </div>
            </div>
        </div>
    </div>


    <script src="department/layui/layui.js"></script>

    <!-- 选项卡模块加载 -->
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
                layer.msg(this.innerHTML);
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

</body>




</html>