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
  <title>${name}申请</title>
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
              <div class="layui-fluid" id="LAY-component-layer-special-demo">
                <div class="layui-btn-container layadmin-layer-demo">
                    <button data-method="add" id="addTable" class="layui-btn  layui-btn-sm"
                            style="margin: 1%">新增项目</button>
                  <button data-method="savetable" datatype="auto" class="layui-btn  layui-btn-sm" style="margin: 1%">暂存项目</button>
                  <button data-method="opentable" datatype="auto" class="layui-btn  layui-btn-sm" style="margin: 1%">开立项目</button>
                  <button data-method="deltable" datatype="auto" class="layui-btn  layui-btn-sm"
                          style="margin: 1%">删除项目</button>

                  <button data-method="canceltable" datatype="auto" class="layui-btn  layui-btn-sm" style="margin: 1%">作废项目</button>
                  <button class="layui-btn  layui-btn-sm" style="margin: 1%">查看检查结果</button>
                  <button data-method="add_muban" class="layui-btn  layui-btn-sm" style="margin: 1%">存为组套</button>
                </div>

              </div>


            </div>
            <table class="layui-hide" id="test-table-cellEdit-middle" lay-filter="test-table-cellEdit"></table>
          </div>
        </div>
      </div>
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
                    </div>
                  </div>
                        <div class="layui-fluid" id="LAY-component-layer-special-demo2">
                            <div class="layui-btn-container layadmin-layer-demo">
                                <div class="layui-btn-group" style="align-content: center;">
                                    <button data-method="add_muban" class="layui-btn  layui-btn-sm"><i
                                            class="layui-icon">&#xe654;</i></button>
                                    <button class="layui-btn  layui-btn-sm"><i class="layui-icon">&#xe642;</i></button>
                                    <button class="layui-btn  layui-btn-sm"><i
                                            class="layui-icon layui-icon-search"></i></button>
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
        },
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
          },{
            field: 'examcheckid',
            title: '检查编号',
            width: 180,
            sort: true
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
          },
            {
              field: 'goal',
              title: '项目目的',
              width: 180,
              // sort: true,
              edit: 'text.jsp'
            },
            {
              field: 'requirement',
              title: '项目要求 ',
              width: 180,
              // sort: true,
              edit: 'text.jsp'
            },
            {
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
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" language="JavaScript">
    window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
</script>
  <script>
    layui.use(['tree', 'util'], function () {
        var data = [];
        $.ajax({
            type: "get",
            async : false,//设置为同步操作就可以给全局变量赋值成功
            url: "fifthpart/getsets",
            success: function (examcheckSets) {
              var mydata = [];
              var children1=[];
              var children2=[];
              var children3=[];
              var data1 =[];
              var data2 =[];
              var data3 =[];
                for(var i=0;i<examcheckSets.length;i++){
                    // alert(examcheckSets[i].setname);
                    //测试成功！！！

                    if(examcheckSets[i].limits==0) {
                         data1 = {
                            title:examcheckSets[i].setname,
                            id:examcheckSets[i].id
                        };
                        children1.push(data1);
                    }

                    if(examcheckSets[i].limits==1) {
                         data2 = {
                            title:examcheckSets[i].setname,
                            id:examcheckSets[i].id
                        };
                        children2.push(data2);
                    }

                    if(examcheckSets[i].limits==2) {
                         data3 = {
                            title:examcheckSets[i].setname,
                            id:examcheckSets[i].id
                        };
                        children3.push(data3);
                    }
                  // alert(JSON.stringify(children3));
                }

                var data4 ={
                    title: '全院组套模板',
                    id: 0,
                    children:children1
                };

                var data5 ={
                    title: '科室组套模板',
                    id: 1,
                    children:children2
                };

                var data6 ={
                    title: '个人组套模板',
                    id: 2,
                    children:children3
                };

              mydata.push(data4);
              mydata.push(data5);
              mydata.push(data6);
              //将json对象转换成字符串
              alert(JSON.stringify(mydata));
              data=mydata;
            }
        });
      var tree = layui.tree,
        layer = layui.layer,
        util = layui.util,
        // data = [],
        data1 = [{
          title: '全院组套模板',
          id: 1,
          children: [{
            title: '二级',
            id: 1000
          }, {
            title: '二级',
            id: 1001,
              href: ""
          }, {
            title: '二级',
            id: 1002,
              href: ""
          }]
        }, {
          title: '科室组套模板',
          id: 2,
          children: [{
            title: '二级',
            id: 2000,
              href: ""
          }, {
            title: '二级',
            id: 2001,
              href: ""
          }]
        }, {
          title: '个人组套模板',
          id: 3,
          children: [{
            title: '二级',
            id: 3000,
              href: ""
          }, {
            title: '二级',
            id: 3001,
              href: ""
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

      //开启节点操作图标
      tree.render({
        elem: '#test9',
        data: data,
          // data: data1,
        edit: ['add', 'update', 'del'] //操作节点的图标
          ,
          showCheckbox: true,
        click: function (obj) {
            // layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(obj.data));
            layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(obj.data.id));
            layer.open({
                type: 1,
                title: '引用组套模板',
                area: ['700px', '600px'],
                content: '<iframe src="fifthpart/addModel" frameborder="0" class="layadmin-iframe"></iframe>',
                btn: ['引用组套', '取消'],
                yes: function (index,layero) {
                    layer.closeAll();
                },
                btn2: function () {
                    layer.closeAll();
                }
            });
        }
      });

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
//删除弹窗
      deltable: function (othis) {
        var type = othis.data('type'),
                text = othis.text();
        var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
        var myArray = new Array();
        for (var i = 0; i < tabledata.length; i++) {
          if((tabledata[i].status != "未开立") && (tabledata[i].status != "未保存")&& (tabledata[i].status != "已作废")) {
            alert("请选择状态为未保存或未开立或已作废的项目");
            return;
          }
          myArray.push(tabledata[i].itemcode);
        }
        var id = tabledata[0].examcheckid;
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
              url: "fifthpart/deletepro",
              traditional: true,
              data: {
                'ids': myArray,
                'id': id
              },
              success: function (res) {
                if (res.status == 0) {
                  layer.msg(res.message);
                } else {
                  layer.msg(res.message);
                }
                // layer.closeAll();
                // parent.layui.table.reload('test-table-cellEdit-middle', {
                //   page: {
                //     curr: 1
                //   }
                // });
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
//暂存弹窗
      savetable: function (othis) {
        var type = othis.data('type'),
                text = othis.text();
        var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
        var myArray = new Array();
        for (var i = 0; i < tabledata.length; i++) {
          if(tabledata[i].status != "未保存") {
            alert("请选择状态为未保存的项目,项目"+tabledata[i].itemname+tabledata[i].status);
            return;
          }
          myArray.push(tabledata[i].itemcode);
        }
        var id = tabledata[0].examcheckid;
        layer.open({
          type: 1,
          offset: type,
          title: '项目删除',
          id: 'layerDemo' + type,
          area: ['190px', '160px'],
          content: '<p style="margin:auto;">您确定要保存选中项吗</p>',
          btn: ['确定', '取消'],
          btnAlign: 'c',
          shade: 0,
          yes: function () {
            // 写下编辑的提交方法**********************************************************
            $.ajax({
              type: "POST",
              url: "fifthpart/savepro",
              traditional: true,
              data: {
                'ids': myArray,
                'id': id
              },
              success: function (res) {
                if (res.status == 0) {
                  layer.msg(res.message);
                } else {
                  layer.msg(res.message);
                }
                // layer.closeAll();
                // parent.layui.table.reload('test-table-cellEdit-middle', {
                //   page: {
                //     curr: 1
                //   }
                // });
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
//开立项目弹窗
      opentable: function (othis) {
        var type = othis.data('type'),
                text = othis.text();
        var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
        var myArray = new Array();
        for (var i = 0; i < tabledata.length; i++) {
          if(tabledata[i].status != "未开立") {
            alert("请选择状态为未开立的项目,项目"+tabledata[i].itemname+tabledata[i].status);
            return;
          }
          myArray.push(tabledata[i].itemcode);
        }
        var id = tabledata[0].examcheckid;
        layer.open({
          type: 1,
          offset: type,
          title: '项目开立',
          id: 'layerDemo' + type,
          area: ['190px', '160px'],
          content: '<p style="margin:auto;">您确定要开立选中项吗</p>',
          btn: ['确定', '取消'],
          btnAlign: 'c',
          shade: 0,
          yes: function () {
            // 写下编辑的提交方法**********************************************************
            $.ajax({
              type: "POST",
              url: "fifthpart/openpro",
              traditional: true,
              data: {
                'ids': myArray,
                'id': id
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
//作废项目弹窗
      canceltable: function (othis) {
        var type = othis.data('type'),
                text = othis.text();
        var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
        var myArray = new Array();
        for (var i = 0; i < tabledata.length; i++) {
          if(tabledata[i].status != "已开立") {
            alert("请选择状态为已开立的项目,项目"+tabledata[i].itemname+tabledata[i].status);
            return;
          }
          myArray.push(tabledata[i].itemcode);
        }
        var id = tabledata[0].examcheckid;
        layer.open({
          type: 1,
          offset: type,
          title: '作废项目',
          id: 'layerDemo' + type,
          area: ['190px', '160px'],
          content: '<p style="margin:auto;">您确定要作废选中项吗</p>',
          btn: ['确定', '取消'],
          btnAlign: 'c',
          shade: 0,
          yes: function () {
            // 写下编辑的提交方法**********************************************************
            $.ajax({
              type: "POST",
              url: "fifthpart/cancelpro",
              traditional: true,
              data: {
                'ids': myArray,
                'id': id
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
//添加检查检验项目
        add: function () {
            var that = this;

            layer.open({
                type: 1,
                title: '添加项目',
                area: ['450px', '350px'],
                shade: 0,
                maxmin: true,
                content: '<iframe src="fifthpart/addUI?id=${id}" frameborder="0" class = "layadmin-iframe"></iframe>',
                btn: ['确定', '全部关闭'],
              yes: function (index,layero) {
                var iframes = $(layero).find("iframe")[0].contentWindow;
                var form = iframes.document.getElementById("add");
                $.ajax({
                  type: "POST",
                  url: "fifthpart/add?doctorid=5&medicalid=5",
                  data: $(form).serialize(),
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

        add_muban: function () {
            var that = this;
            layer.open({
                type: 1,
                title: '添加模板',
                area: ['700px', '600px'],
                shade: 0,
                maxmin: true,
                content: '<iframe src="fifthpart/addModel" frameborder="0" class="layadmin-iframe"></iframe>',
                btn: ['确定', '全部关闭'],
                yes: function (index,layero) {
                    var iframes = $(layero).find("iframe")[0].contentWindow;
                    var form = iframes.document.getElementById("add");
                    var table = iframes.layui.table;
                    var tabledata = table.checkStatus('test-table-toolbar').data;
                    var myArray = new Array();
                    var myArray1 = new Array();
                    var myArray2 = new Array();
                    for (var i = 0; i < tabledata.length; i++) {
                        myArray.push(tabledata[i].itemcode);
                        myArray1.push(tabledata[i].requirement);
                        myArray2.push(tabledata[i].goal);
                    }
                    $.ajax({
                        type: "POST",
                        url: "fifthpart/addmuban",
                        // data: $(form).serialize(),
                      // data: {'examcheckSet':$(form).serialize(),
                      //        'setInfo':myArray},
                      // data:$.param({'examcheckSetInfos':myArray})+'&'+$(form).serialize(),
                      data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2+'&'+$(form).serialize(),
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

</body>

</html>