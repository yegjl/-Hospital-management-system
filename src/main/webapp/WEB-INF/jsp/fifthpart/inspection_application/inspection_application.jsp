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
  <title>检查申请</title>
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
      <div class="layui-col-md3">
        <!-- 左侧内容 -->
        <div class="layui-fluid" id="component-tabs">
          <div class="layui-card">
            <div class="layui-card-body">
              <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                <ul class="layui-tab-title">
                  <li class="layui-this">本人</li>
                  <li>科室</li>
                </ul>
                <div class="layui-tab-content">
                  <div class="layui-tab-item layui-show">
                    <!-- 选项卡1中内容 -->
                    <!-- 左侧数据表格1 -->
                    <p>特诊患者共有${msg}位患者新信息</p>
                    <table class="layui-hide" id="test-table-simple1"></table>

                  </div>
                  <div class="layui-tab-item">科室内容</div>

                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="layui-fluid">
          <div class="layui-card-body" style="background-color: white">
            <p>已诊患者共有${msg}位患者新信息</p>
            <table class="layui-hide" id="test-table-simple2"></table>
          </div>
        </div>

        左
      </div>
      <div class="layui-col-md6" style="overflow: auto;height:600px;">
        <!-- 中部折叠面板 -->
        <div class="layui-card">
          <div class="layui-card-header " style="height: 80px;">
            <p style="font-size: 180%;float: left;width: 15%;margin-top: 5%">检查申请</p>


          </div>
          <div class="layui-card">
            <div class="layui-card-body">
              <fieldset class="layui-elem-field layui-field-title">
                <legend>检查申请项目列表</legend>
              </fieldset>
              <div class="layui-btn-container">
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">新增项目</button>
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">暂存项目</button>
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">开立项目</button>
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">删除项目</button>
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">作废项目</button>
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">查看检查结果</button>
                <button class="layui-btn  layui-btn-sm" style="margin: 1%">存为组套</button>

              </div>
              <table class="layui-hide" id="test-table-cellEdit-middle" lay-filter="test-table-cellEdit"></table>
            </div>
          </div>
        </div>
        中
      </div>
      <div class="layui-col-md3">



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
                          <input type="radio" name="sel" value="01" title="全院" checked style="size: 50%">
                          <input type="radio" name="sel" value="02" title="科室">
                          <input type="radio" name="sel" value="03" title="个人">
                        </div>
                        <div class="layui-btn-group" style="align-content: center;">
                          <button class="layui-btn  layui-btn-sm"><i class="layui-icon">&#xe654;</i></button>
                          <button class="layui-btn  layui-btn-sm"><i class="layui-icon">&#xe642;</i></button>
                          <button class="layui-btn  layui-btn-sm"><i class="layui-icon layui-icon-search"></i></button>
                          <button class="layui-btn  layui-btn-sm"><i class="layui-icon">&#xe640;</i></button>

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



        右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右右
      </div>

    </div>
  </div>

  <script src="department/layui/layui.js?t=1"></script>

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
        location.hash = '/' + layui.router().path.join('/') + '#layid=' + $(this).attr('lay-id');
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
        url: 'fifthpart/findpro?doctorid=5&medicalid=5',
        method:'get',
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
            field: 'itemcode',
            title: '项目编码',
            width: 180,
            sort: true
          }, {
            field: 'itemname',
            title: '项目名称',
            width: 180,
            // sort: true,
            edit: 'text.jsp'
          }, {
            field: 'status',
            title: '项目状态',
            edit: 'text.jsp',
            minWidth: 180
          }]
        ]
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





</body>

</html>