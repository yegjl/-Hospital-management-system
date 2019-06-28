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
    <div class="layui-card">
        <div class="layui-card-body">
            <table class="layui-hide" id="test-table"></table>
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
                table = layui.table,
                myArray = new Array();

            table.render({
                elem: '#test-table',
                // url: layui.setter.base + '/json/table/user.js',
                url: 'drugstore/showtable?drugid=${id}'
                ,method:'get'
                ,parseData:function (res) {
                    return {
                        "code":res.status,
                        "msg":res.message,
                        "count":res.total,
                        "data":res.data
                    }
                }

                ,cols: [
                    [{
                        field: 'id',
                        width: 100,
                        title: 'id',
                        sort: true
                    }, {
                        field: 'drugname',
                        width: 120,
                        title: '药品名'
                    }, {
                        field: 'format',
                        width: 120,
                        title: '规格'
                    },{
                        field: 'manufacturer',
                        width: 120,
                        title: '产地',
                        sort: true
                    }, {
                        field: 'oldprice',
                        width: 100,
                        title: '原价'
                    }, {
                        field: 'newprice',
                        title: '新价',
                        width: 100,
                    }, {
                        field: 'adjustid',
                        width: 100,
                        title: '调价单号',
                    }, {
                        field: 'date',
                        width: 120,
                        title: '调价日期',
                    }, {
                        field: 'adjustnumber',
                        width: 120,
                        title: '调价文号'
                    }, {
                        field: 'reason',
                        width: 120,
                        title: '调价原因'
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

</body>

</html>