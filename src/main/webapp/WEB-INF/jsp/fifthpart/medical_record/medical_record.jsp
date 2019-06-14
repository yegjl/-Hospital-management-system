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
          <div class="layui-card-header">折叠面板</div>
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
                      <input class="layui-input" style="float: left;">
                    </div>
                  </div>

                  <div class="layui-col-md12" style="margin-top: 10px;">
                    <div style="float: left;width: 10%;margin-left: 20px;">
                      <p style="margin-top: 7px;">现病史:</p>
                    </div>
                    <div style="float: right;width: 80%;margin-right: 20px;">
                      <textarea name="other" placeholder="" class="layui-textarea" style="float: right;"></textarea>
                    </div>
                  </div>

                  <div class="layui-col-md12" style="margin-top: 10px;">
                    <div style="float: left;width: 10%;margin-left: 20px;">
                      <p style="margin-top: 7px;">既往史:</p>
                    </div>
                    <div style="float: right;width: 80%;margin-right: 20px;">
                      <textarea name="other" placeholder="" class="layui-textarea" style="float: right;"></textarea>
                    </div>
                  </div>

                  <div class="layui-col-md12" style="margin-top: 10px;">
                    <div style="float: left;width: 10%;margin-left: 20px;">
                      <p style="margin-top: 7px;">个人史:</p>
                    </div>
                    <div style="float: right;width: 80%;margin-right: 20px;">
                      <textarea name="other" placeholder="" class="layui-textarea" style="float: right;"></textarea>
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
                      <textarea name="other" placeholder="" class="layui-textarea"
                        style="float: right;height: 70px;;"></textarea>
                    </div>
                  </div>

                  <div class="layui-col-md12" style="margin-top: 10px;">
                    <div style="float: left;width: 15%;margin-left: 20px;">
                      <p style="margin-top: 7px;">辅助检查:</p>
                    </div>
                    <div style="float: right;width: 75%;margin-right: 20px;">
                      <textarea name="other" placeholder="" class="layui-textarea"
                        style="float: right;height: 70px;"></textarea>
                    </div>
                  </div>

                </div>
              </div>

              <div class="layui-colla-item" style="height: 400px;">
                <h2 class="layui-colla-title">评估、诊断</h2>
                <div class="layui-colla-content layui-show">
                  <!-- 中部内容3 -->

                  <div class="layui-col-md12" style="margin-top: 10px;">
                    <p>诊断：</p>
                    <table class="layui-hide" id="test-table-simple3"></table>
                    <p>疾病：</p>
                    <table class="layui-hide" id="test-table-simple4"></table>
                  </div>

                </div>
              </div>

            </div>
          </div>
        </div>
        中
      </div>
      <div class="layui-col-md3">



        <div class="layui-fluid" id="component-tabs2">
          <div class="layui-card">
            <div class="layui-card-body">
              <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
                <ul class="layui-tab-title">
                  <li class="layui-this">病历模板</li>
                  <li>常用诊断</li>
                  <li>历史病历</li>
                </ul>
                <div class="layui-tab-content">
                  <div class="layui-tab-item layui-show">
                    <!-- 选项卡1中内容 -->
                    <!-- 右侧树状图 -->
                    <div class="layui-card layui-form" lay-filter="component-form-element">

                      <div class="layui-card-body layui-row layui-col-space10">
                        <div class="layui-col-md12">
                          <input type="radio" name="sel" value="01" title="全院" checked>
                          <input type="radio" name="sel" value="02" title="科室">
                          <input type="radio" name="sel" value="03" title="个人">
                          <!-- <button class="layui-btn-sm">
                            <i class="layui-icon layui-icon-edit"></i>
                          </button>
                          <button class="layui-btn-sm">
                            <i class="layui-icon layui-icon-delete"></i>
                          </button> -->

                        </div>
                      </div>
                    </div>
                    <div id="test9"></div>

                  </div>
                  <div class="layui-tab-item">
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

                    常用诊断内容
                  </div>
                  <div class="layui-tab-item">
                    历史病历内容
                  </div>

                </div>
              </div>
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
  <!-- 诊断数据表格3 -->
  <script>
    layui.config({
      base: 'department/' //静态资源所在路径
    }).extend({
      index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
      var table = layui.table;

      table.render({
        elem: '#test-table-simple3',
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
            width: 100,
            title: '疾病ID'
          }, {
            field: 'age',
            width: 100,
            title: '病历ID',
            sort: true
          }, {
            field: 'age',
            width: 100,
            title: '主诊标志'
          }, {
            field: 'age',
            width: 100,
            title: '疑似标志'
          }, {
            field: 'age',
            width: 100,
            title: '发病日期'
          }]
        ]
      });
    });
  </script>
  <!-- 疾病数据表格3 -->
  <script>
    layui.config({
      base: 'department/' //静态资源所在路径
    }).extend({
      index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
      var table = layui.table;

      table.render({
        elem: '#test-table-simple4',
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
            width: 180,
            title: '国际IDC编码'
          }, {
            field: 'age',
            width: 100,
            title: '疾病名称',
            sort: true
          }, {
            field: 'age',
            width: 180,
            title: '疾病助记编码'
          }, {
            field: 'age',
            width: 100,
            title: '疾病所属分类'
          }]
        ]
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