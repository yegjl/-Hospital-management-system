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
    <title>患者详细费用查询</title>
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
                <div class="layui-col-md12">
                    <!-- 中部折叠面板 -->
                    <div class="layui-card" style="overflow: auto;height:600px;">
                        <div class="layui-card-header" style="font-weight: 500">账单明细</div>
                        <div class="layui-table-body">
                            <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>
                            <script type="text/html" id="test-table-toolbar-toolbarDemo">
                                <div class="layui-input-inline">
                                    <input type="text" class="layui-input" style="width:100px">
                                </div>
                                <div class="layui-input-inline">
                                    <input type="button" class="layui-btn layui-btn" lay-event="search" value="搜索">
                                </div>
                            </script>


                        </div>

                    </div>
                </div>
            </form>
        </div>
    </div>


    <script src="department/layui/layui.js?t=1"></script>

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
                url: layui.setter.base + 'json/table/demo.js',
                toolbar: '#test-table-toolbar-toolbarDemo',
                title: '用户数据表',
                cols: [
                    [{
                        field: 'id',
                        title: '名称',
                        width: 80,
                        fixed: 'left',
                        sort: true
                    }, {
                        field: 'username',
                        title: '规格',
                        width: 120,
                        edit: 'text'
                    }, {
                        field: 'email',
                        title: '数量',
                        width: 150,

                    }, {
                        field: 'sex',
                        title: '付款',
                        width: 80,

                    }, {
                        field: 'city',
                        title: '单价',
                        width: 100
                    }, {
                        field: 'sign',
                        title: '金额'
                    }, {
                        field: 'experience',
                        title: '收费状态',
                        width: 80,
                    }]
                ],
                page: true
            });


            //监听行工具事件
            table.on('tool(test-table-toolbar)', function (obj) {
                var data = obj.data;
                if (obj.event === 'search') {


                }
            });

        });
    </script>




</body>

</html>