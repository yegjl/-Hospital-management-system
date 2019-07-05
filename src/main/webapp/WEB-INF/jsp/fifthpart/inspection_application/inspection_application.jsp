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

      <div class="layui-col-md9" style="overflow: auto;height:600px;">
        <!-- 中部折叠面板 -->
        <div class="layui-card">
          <div class="layui-card-header " style="height: 80px;">
            <p style="font-size: 180%;float: left;width: 15%;margin-top: 5%">${name}申请</p>


        </div>
        <div class="layui-card">
          <div class="layui-card-body">
            <fieldset class="layui-elem-field layui-field-title">
              <legend>${name}申请项目列表</legend>
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
                  <button data-method="result" class="layui-btn  layui-btn-sm" style="margin: 1%">查看${name}结果</button>
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
              <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show">
                  <!-- 选项卡1中内容 -->
                  <!-- 右侧树状图 -->
                        <div class="layui-fluid" id="LAY-component-layer-special-demo2">
                            <div class="layui-btn-container layadmin-layer-demo">
                                <div class="layui-btn-group" style="align-content: center;">
                                    <button data-method="add_muban" class="layui-btn  layui-btn-sm"><i
                                            class="layui-icon">&#xe654;</i></button>
                                    <button class="layui-btn  layui-btn-sm"><i class="layui-icon">&#xe642;</i></button>
                                    <button class="layui-btn  layui-btn-sm"><i
                                            class="layui-icon layui-icon-search"></i></button>
                                    <button  class="layui-btn  layui-btn-sm" lay-demo="getChecked"><i class="layui-icon">&#xe640;</i></button>
                                </div>
                            </div>
                        </div>
                  <div id="test9"></div>

                </div>
                <div class="layui-tab-item">
                  <!-- 选项卡2常用项目内容 -->
                  <div class="layui-inline">


                    <div class="layui-card-header">
                      <div class="layui-btn-group" id="often">
                        <div class="layui-fluid" id="LAY-component-layer-special-demo3">
                          <input data-method="oftenadd" class="layui-btn layui-btn-sm" type="button" value="增加">
                          <input data-method="oftendelete" class="layui-btn layui-btn-sm" type="button" value="删除">
                          <input data-method="oftenuse" class="layui-btn layui-btn-sm" type="button" value="引用">
                        </div>
                      </div>
                    </div>

                    <div class="layui-table-body" style="margin-top:1% ">
                      <table class="layui-hide" id="test-table-checkbox" lay-filter="test-table-toolbar"></table>
                    </div>


                  </div>


                </div>


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

  <script>
    layui.config({
      base: 'department/' //静态资源所在路径
    }).extend({
      index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function () {
      var table = layui.table;

      table.render({
        elem: '#test-table-checkbox',
        url: 'fifthpart/findoften?id=${id}',
        method:'get',
        title: '常用项目表',
        parseData:function (res) {
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
            field: 'itemid',
            title: '编号',
            sort: true
          },{
            field: 'itemname',
            title: '项目名称',
            sort: true
          }]
        ],
        page: true
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
          //todo:连接
        url: 'fifthpart/findpro?doctorid=${doctorid}&medicalid=${medicalid}&id=${id}',
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

          },
            {
              field: 'number',
              title: '项目数量',
              width: 180,

            },
            {
              field: 'goal',
              title: '项目目的',
              width: 180,

            },
            {
              field: 'requirement',
              title: '项目要求 ',
              width: 180,

            },
            {
            field: 'status',
            title: '项目状态',
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
            url: "fifthpart/getsets?id=${id}",
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
              // alert(JSON.stringify(mydata));
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
        // id: 'demoId1',
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
            var myArray = new Array();
            //获取子节点数据
            for(var i=0;i<checkedData.length;i++){
                var children=checkedData[i].children;
                for(var j=0;j<children.length;j++){
                    myArray.push(children[j].id);
                }
            }

            layer.open({
                type: 1,
                title: '删除组套模板',
                area: ['260px', '160px'],
                shade: 0,
                maxmin: true,
                content: '<p style="margin:auto;">您确定要删除选中项吗</p>',
                btn: ['确定', '全部关闭'],
                yes: function () {
                    // 写下编辑的提交方法**********************************************************
                    $.ajax({
                        type: "POST",
                        url: "fifthpart/deleteset",
                        traditional: true,
                        data: {
                            'ids': myArray,
                        },
                        success: function (res) {
                            if (res.status == 0) {
                                layer.msg(res.message);
                            } else {
                                layer.msg(res.message);
                            }
                          setTimeout(function () {
                            layui.table.reload('test-table-cellEdit-middle');
                          }, 100);
                          layer.closeAll();
                        },
                        error: function () {
                            alert("出现错误");
                            return false;
                        }
                    })
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
          id: 'demoId1',
        edit: ['add', 'update', 'del'] //操作节点的图标
          ,
          showCheckbox: true,
        click: function (obj) {
            // layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(obj.data));
            layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(obj.data.id));
            if(obj.data.id==0||obj.data.id==1||obj.data.id==2) {
              layer.msg("请选择二级菜单里面的模板");
              return;
            }
            layer.open({
                type: 1,
                title: '引用组套模板',
                area: ['700px', '600px'],
                content: '<iframe src="fifthpart/useModel?id='+obj.data.id+'" frameborder="0" class="layadmin-iframe"></iframe>',
                btn: ['引用组套', '取消'],
                yes: function (index,layero) {//将组套里面的的项目添加至数据库
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
                        //todo:连接病历号
                        url: "fifthpart/usemubanpros?doctorid=${doctorid}&medicalid=${medicalid}&id=${id}",
                        data:'myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2,
                        success: function (res) {
                            if (res.status == 0) {
                                layer.msg(res.message)
                            } else {
                                layer.msg(res.message)
                            }
                          setTimeout(function () {
                            layui.table.reload('test-table-cellEdit-middle');
                          }, 100);
                          layer.closeAll();
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
                setTimeout(function () {
                  layui.table.reload('test-table-cellEdit-middle');
                }, 100);
                layer.closeAll();
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
                setTimeout(function () {
                  layui.table.reload('test-table-cellEdit-middle');
                }, 100);
                layer.closeAll();
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
        if(tabledata.length==0){
          layer.msg("请选择需要开立的项目");
          return;
        }
        for (var i = 0; i < tabledata.length; i++) {
          if(tabledata[i].status != "未开立") {
            layer.msg("请选择状态为未开立的项目,项目"+tabledata[i].itemname+tabledata[i].status);
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
              url: "fifthpart/openpro?mark=${id}&medicalRecordNo=${medicalRecordNo}",
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

                setTimeout(function () {
                  layui.table.reload('test-table-cellEdit-middle');
                }, 100);
                layer.closeAll();
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

                setTimeout(function () {
                  layui.table.reload('test-table-cellEdit-middle');
                }, 100);
                layer.closeAll();
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
                    //todo:连接病历号
                  url: "fifthpart/add?doctorid=${doctorid}&medicalid=${medicalid}&id=${id}",
                  data: $(form).serialize(),
                  success: function (res) {
                    if (res.status == 0) {
                        layer.msg(res.message)
                    } else {
                      layer.msg(res.message)
                    }
                    setTimeout(function () {
                      layui.table.reload('test-table-cellEdit-middle');
                    }, 100);
                    layer.closeAll();
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
                content: '<iframe src="fifthpart/addModel?id=${id}" frameborder="0" class="layadmin-iframe"></iframe>',
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
                      data:'id=${id}&myArray='+myArray+"&myArray1="+myArray1+"&myArray2="+myArray2+'&'+$(form).serialize(),
                  success: function (res) {
                            if (res.status == 0) {
                                layer.msg(res.message)
                            } else {
                                layer.msg(res.message)
                            }
                    setTimeout(function () {
                      layui.table.reload('test-table-cellEdit-middle');
                    }, 100);
                    layer.closeAll();
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

        //删除对应组套并更新树
        delete_muban: function () {
            var that = this;
            layer.open({
                type: 1,
                title: '删除模板',
                area: ['260px', '160px'],
                shade: 0,
                maxmin: true,
                content: '<p style="margin:auto;">您确定要删除选中项吗</p>',
                btn: ['确定', '全部关闭'],
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
                          setTimeout(function () {
                            layui.table.reload('test-table-cellEdit-middle');
                          }, 100);
                          layer.closeAll();
                        },
                        error: function () {
                            alert("出现错误");
                            return false;
                        }
                    })
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

      result: function () {
        var that = this;
        var tabledata = layui.table.checkStatus('test-table-cellEdit-middle').data;
        if(tabledata.length!=1||tabledata[0].status != "检查结果已录入") {
          layer.msg("请选中一条已录入检查结果的项目");
          return;
        }
//这里需要后台获取的数据
        var examcheckid= tabledata[0].examcheckid;
        var itemname= tabledata[0].itemname;
        // var patient_name= tabledata[0].patient_name;
        layer.open({
          type: 1,
          title: '检查/检验结果查看',
          area: ['550px', '600px'],
          shade: 0,
          maxmin: true,
          offset: 'auto',
          content: '<iframe src="sixpart/getresult1?examcheckid='+examcheckid+'&itemname='+itemname+'" frameborder="0" class="layadmin-iframe"></iframe>',
          btn: ['确定', '取消'],
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

      // 常用项目管理
      oftenadd: function () {
        layer.open({
          type: 1,
          title: '常用项目添加',
          area: ['390px', '360px'],
          shade: 0,
          maxmin: true,
          offset: [],
          content: '<iframe src="fifthpart/addoften?id=${id}" frameborder="0" class="layadmin-iframe"></iframe>',
          btn: ['添加', '关闭'],
          yes: function (index,layero) {
            var iframes = $(layero).find("iframe")[0].contentWindow;
            var fmeditemid = iframes.document.getElementById("fmeditemid");
            $.ajax({
              type: "POST",
              url: "fifthpart/addoftenpro?id=${id}",
              // data: fmeditemid.val(),
              data: {
                'proid': fmeditemid.value,
              },
              success: function (res) {
                if (res.status == 0) {
                  layer.msg(res.message)
                } else {
                  layer.msg(res.message)
                }
                setTimeout(function () {
                  layui.table.reload('test-table-checkbox');
                }, 100);
                layer.closeAll();
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

      oftendelete: function (othis) {
        var type = othis.data('type'),
                text = othis.text();
        var tabledata = layui.table.checkStatus('test-table-checkbox').data;
        if(tabledata.length==0){
          layer.msg("请选择需要删除的项目");
          return;
        }
        var myArray = new Array();
        for (var i = 0; i < tabledata.length; i++) {
          myArray.push(tabledata[i].itemid);
        }
        layer.open({
          type: 1,
          offset: type,
          title: '删除常用药品',
          id: 'layerDemo' + type,
          area: ['190px', '160px'],
          content: '<p style="margin:auto;">您确定要删除选中项吗?</p>',
          btn: ['确定', '取消'],
          btnAlign: 'c',
          shade: 0,
          yes: function () {
            // 写下编辑的提交方法**********************************************************
            $.ajax({
              type: "POST",
              url: "fifthpart/deleteoften",
              traditional: true,
              data: {
                'proids': myArray
              },
              success: function (res) {
                if (res.status == 0) {
                  layer.msg(res.message);
                } else {
                  layer.msg(res.message);
                }
                setTimeout(function () {
                  layui.table.reload('test-table-checkbox');
                }, 100);
                layer.closeAll();
              },
              error: function () {
                alert("出现错误");
                return false;
              }
            })
            layer.closeAll();
          },
          btn2: function () {
            layer.closeAll();
          }
        });
      },

      oftenuse: function (othis) {
        var type = othis.data('type'),
                text = othis.text();
        var tabledata = layui.table.checkStatus('test-table-checkbox').data;
        if(tabledata.length==0){
          layer.msg("请选择需要引用的项目");
          return;
        }
        var myArray = new Array();
        for (var i = 0; i < tabledata.length; i++) {
          myArray.push(tabledata[i].itemid);
        }

        layer.open({
          type: 1,
          title: '常用药引入',
          area: ['390px', '360px'],
          shade: 0,
          maxmin: true,
          offset: [],
          // content: '<p style="margin:auto;">您确定要引用选中项吗</p>请输入引用材料的数量：<input class="layui-input"  id="usenumber" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>',
          content: '<p style="margin:auto;">您确定要引用选中项吗</p>',
          btn: ['引用', '关闭'],
          yes: function () {
            // var iframes = $(layero).find("iframe")[0].contentWindow;
            // var form = iframes.document.getElementById("useoften");
            $.ajax({
              type: "POST",
              url: "fifthpart/useoftenpro?doctorid=${doctorid}&medicalid=${medicalid}&id=${id}",
              traditional: true,
              data: {
                'proids': myArray
              },
              success: function (res) {
                if (res.status == 0) {
                  layer.msg(res.message)
                } else {
                  layer.msg(res.message)
                }
                setTimeout(function(){
                  layui.table.reload('test-table-cellEdit-middle');//修改成功后刷新父界面
                }, 100);
                layer.closeAll();
                $("#prestatus").empty();
                document.getElementById("prestatus").setAttribute("value", "未暂存");
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
    $('#LAY-component-layer-special-demo3 .layui-btn').on('click', function () {
      var othis = $(this),
              method = othis.data('method');
      active[method] ? active[method].call(this, othis) : '';
    });
  });
</script>

</body>

</html>