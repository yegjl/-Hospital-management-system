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
    <title>个人工作量统计</title>
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
                个人工作量统计
            </div>

            <div class="layui-col-md12" id="suibian">

                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <label class="layui-form-label" style="width: 200px;">请选择工作量统计区间：</label>
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="test-laydate-start" placeholder="开始日期">
                    </div>
                    <div class="layui-input-inline">
                        -
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="test-laydate-end" placeholder="结束日期">
                    </div>
                    <div class="layui-input-inline">
                        <%--                            <input class="layui-btn layui-btn-normal" type="button" value="统计" data-type="reload">--%>
                        <%--                            <button class="layui-btn" data-type="reload" onclick="test()">统计</button>--%>


                                <div class="layui-fluid" id="LAY-component-layer-special-demo" style="margin-top: 5%">
                                    <div class="layui-btn-container layadmin-layer-demo" >
                                        <div class="layui-inline">
                                            <div class="layui-input-inline" style="float: left">
                                                <a class="layui-btn" data-type="suc" onclick="test()"><i class="layui-icon">&#xe62c;</i>统计</a>
                                            </div>
                                            <div class="layui-input-inline">
                                                <button data-method="pan" class="layui-btn" style="margin-left: 3%"><i class="layui-icon">&#xe615;</i>查询</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                    </div>
                </div>




                <div class="layui-table-body" style="margin-top:1% ">
                    <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>

                    <script type="text/html" id="test-table-toolbar-toolbarDemo">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <label>本时间段内本人登记的患者数量为：${amount}</label>

                            </div>


                        </div>
                    </script>
                </div>

            </div>


        </div>

    </div>


</div>

<script src="department/layui/layui.js"></script>
<script src="department/echarts/echarts.js"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script>
    var mycharts = echarts.init(document.getElementById('zhexiantu'));
    option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };
    mycharts.setOption(option);

</script>




<script>
    function test() {
        var startDate = document.getElementById("test-laydate-start").value;
        var endDate = document.getElementById("test-laydate-end").value;
        //执行重载
        layui.table.reload('test-table-toolbar', {

            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: {
                startDate: startDate,
                endDate: endDate
            }
        }, 'data');
        layui.layer.msg("统计成功");
    }
</script>

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
            url: 'selfstatis/getPatient?doctorid=${sessionScope.doctorid}',
            method: 'get',
            toolbar: '#test-table-toolbar-toolbarDemo',
            title: '用户数据表',
            parseData: function (res) {
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
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                    field: 'medicalRecordNo',
                    title: '病历号',
                    width: 200,
                    fixed: 'left',
                    sort: true
                }, {
                    field: 'patientName',
                    title: '患者姓名',
                    width: 100,

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
            }
            ;
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


        var $ = layui.$, active = {
            suc: function () {
                layer.msg('统计成功');
            }
        };

        $('.layui-col-md12. layui-btn').on('click', function () {
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
            url: layui.setter.base + 'json/table/user.js',
            cols: [
                [{
                    type: 'checkbox'
                }, {
                    field: 'id',
                    width: 180,
                    title: '项目名称',
                    sort: true
                }, {
                    field: 'username',

                    title: '项目编码'
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
            pan: function () {
                var that = this;
                var tabledata = layui.table.checkStatus('test-table-toolbar').data;
                var medicalrecordid = tabledata[0].medicalRecordNo;
                layer.open({
                    type: 1,
                    title: '患者详细费用',
                    area: ['400px', '500px'],
                    shade: 0,
                    maxmin: true,
                    offset: [],
                    content: '<iframe src="selfstatis/indexpan?medicalrecordid='+medicalrecordid+'" frameborder="0" class="layadmin-iframe"></iframe>',
                    btn: ['确定', '关闭'],
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
        };

        $('#LAY-component-layer-special-demo .layadmin-layer-demo .layui-btn').on('click', function () {
            var othis = $(this),
                method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });
    });
</script>

<!-- 时间选择 -->

<script>
    layui.config({
        base: 'department/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'laydate'], function () {
        var laydate = layui.laydate;

        //开始
        var insStart = laydate.render({
            elem: '#test-laydate-start',
            type: 'datetime',
            done: function (value, date) {
                //更新结束日期的最小日期
                insEnd.config.min = lay.extend({}, date, {
                    month: date.month - 1
                });

                //自动弹出结束日期的选择器
                insEnd.config.elem[0].focus();
            }
        });

        var insEnd = laydate.render({
            elem: '#test-laydate-end',
            type: 'datetime',
            done: function (value, date) {
                //更新开始日期的最大日期
                insStart.config.max = lay.extend({}, date, {
                    month: date.month - 1
                });
            }
        });


    });
</script>

</div>
</body>




</html>