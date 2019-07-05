<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
  <meta charset="utf-8">
  <title>${name}</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="department/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-header">${name}管理</div>
        <div class="layui-card-body">
          <div class="test-table-reload-btn" style="margin-bottom: 10px;">



            <%--              <!-- 添加弹窗控件 -->--%>

            <div class="layui-fluid" id="LAY-component-layer-special-demo">
              <div class="layui-row">
<%--                <div class="layui-col-xs6 layui-col-sm6 layui-col-md2">--%>
<%--                  <input class="layui-input" name="id" id="test-table-demoReload" autocomplete="off" style="width: 130px;display: inline;margin:10px;">--%>
<%--                  <button class="layui-btn" data-type="reload" style="margin: 10px;">搜索</button>--%>
<%--                </div>--%>




                  <%--                搜索ID：--%>
                  <%--    <input class="layui-input" name="id" id="test-table-demoReload" autocomplete="off" style="width: 200px;display: inline;margin:10px;">--%>
                  <%--    <input id="test-table-demoReload"  style="width: 200px;display: inline;margin:10px;">--%>


                    <%--                  <button class="layui-btn" data-type="reload" style="margin: 10px;">搜索</button>--%>
<%--                    <button data-method="addTop" data-type="auto" class="layui-btn"style="margin: 10px;">添加</button>--%>
<%--                    <button data-method="edit" data-type="auto" class="layui-btn" style="margin: 10px;">编辑</button>--%>
<%--                    <!-- 删除部分还没有填充函数 ************************************************************************-->--%>
<%--                    <button data-method="deltable" datatype="auto" class="layui-btn" style="margin: 10px;">删除</button>--%>
<%--                    <button data-method="upload" data-type="auto" class="layui-btn" style="margin: 10px;"> 导入</button>--%>

                    <div class="layui-inline">
                      <div class="demoTable">
                        搜索ID：
                        <div class="layui-inline">
                          <input class="layui-input" name="id" id="demoReload" autocomplete="off">
                        </div>

                        <button class="layui-btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</button>
                      </div>
                    </div>
                    <%--                搜索ID：--%>
                    <%--    <input class="layui-input" name="id" id="test-table-demoReload" autocomplete="off" style="width: 200px;display: inline;margin:10px;">--%>
                    <%--    <input id="test-table-demoReload"  style="width: 200px;display: inline;margin:10px;">--%>

                    <div class="layui-inline">
                      <div class="layui-btn-container layadmin-layer-demo" style="float: right">
                        <%--                  <button class="layui-btn" data-type="reload" style="margin: 10px;">搜索</button>--%>
                        <%--                    <button data-method="addTop" data-type="auto" class="layui-btn"style="margin: 10px;">添加</button>--%>
                        <button data-method="addTop" data-type="auto" class="layui-btn layui-btn-normal" style="margin: 10px;"><i class="layui-icon">&#xe608;</i>添加</button>
                        <button data-method="edit" data-type="auto" class="layui-btn layui-btn-normal" style="margin: 10px;"><i class="layui-icon">&#xe620;</i>编辑</button>
                        <%--                      <button data-method="edit" data-type="auto" class="layui-btn" style="margin: 10px;">编辑</button>--%>
                        <!-- 删除部分还没有填充函数 ************************************************************************-->
                        <%--                    <button data-method="deltable" datatype="auto" class="layui-btn" style="margin: 10px;">删除</button>--%>
                        <button data-method="deltable" datatype="auto" class="layui-btn layui-btn-normal" style="margin: 10px;"><i class="layui-icon">&#xe640;</i>删除</button>
                        <button data-method="upload" data-type="auto" class="layui-btn layui-btn-warm" style="margin: 10px;"><i class="layui-icon">&#xe601;</i> 导入</button>


                      </div>
                    </div>

              </div>

            </div>





            <table class="layui-hide" id="test-table-reload" lay-filter="user"></table>

          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="department/layui/layui.js"></script>
  <script>
    //对Date的扩展，将 Date 转化为指定格式的String
    //月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    //年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    //例子：
    //(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    //(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    function dateToStr(date) {
       //author: meizz
        var time = new Date(date.time);
        var y = time.getFullYear();
        var M = time.getMonth() + 1;
        M = M < 10 ? ("0" + M) : M;
        var d = time.getDate();
        d = d < 10 ? ("0" + d) : d;
        var h = time.getHours();
        h = h < 10 ? ("0" + h) : h;
        var m = time.getMinutes();
        m = m < 10 ? ("0" + m) : m;
        var s = time.getSeconds();
        s = s < 10 ? ("0" + s) : s;
        var str = y + "-" + M + "-" + d;
        return str;

    }
  </script>
  <script id="createTime" type="text/html">
    {{#
    return dateToStr(d.creationdate);
    }}
  </script>

  <script>
    layui.config({
      base: 'department/' //静态资源所在路径X
    })
            .extend({
              index: 'lib/index' //主入口模块X
            })
            .use(['index', 'table'], function(){
              var table = layui.table;

              //方法级渲染
              table.render({
                elem: '#test-table-reload'
                // 这部分url你们自己填你们部署的接口********************************************************************************************
                // ,url: layui.setter.base + 'data/table/nei.js'
                ,url: 'fmedItem/findall'
                ,method:'get'
                ,parseData:function (res) {
                  //TODO:解析JSON对象
                  return {
                    "code":res.status,
                    "msg":res.message,
                    "count":res.total,
                    "data":res.data
                  }
                }
                ,cols: [[
                  {checkbox: true, fixed: true}
                  ,{field:'id', title: 'ID', width:264, sort: true, fixed: true}
                  ,{field:'itemcode', title: '项目编码', width:264,sort: true}
                  ,{field:'itemname', title: '项目名称', width:264, sort: true}
                  ,{field:'format', title: '规格', width:264, sort: true}
                  ,{field:'price', title: '单价',width:264, sort: true}
                  ,{field:'expclassid', title: '所属费用科目ID', width:264}
                  ,{field:'deptid', title: '执行科室ID', width:264, sort: true}
                  ,{field:'mnemoniccode', title: '拼音助记码', width:264, sort: true}
                  ,{field:'recordtype', title: '项目类型', width:264, sort: true}
                  // ,{field:'creationdate', title: '创建时间', width:264, sort: true, templet: function (d) {
                  //   return dateToStr(d.creationdate);
                  //   }}
                  ,{field:'creationdate', title: '创建时间', width:264, sort: true, templet:"#createTime"}]]
                ,page: true
              });


              // 搜索函数X
              var $ = layui.$, active = {
                reload: function () {
                  var demoReload = $('#demoReload');

                  //执行重载
                  table.reload('test-table-reload', {
                    page: {
                      curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                      deptid: demoReload.val()
                    }
                  },'data');
                }
              };

              $('.test-table-reload-btn .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
              });


            });


  </script>
  <script>

    layui.config({
      base: 'department/' //静态资源所在路径
    }).extend({
      index: 'lib/index' //主入口模块
    }).use(['index'], function(){
      var $ = layui.$
              ,admin = layui.admin
              ,element = layui.element
              ,router = layui.router();
      element.render();

      var active = {
        // 添加函数***************************************************************************************
        addTop: function(othis){

          var that = this;
          var type = othis.data('type')
                  ,text = othis.text();
          layer.open({
            type: 1
            ,title: '非药品收费项目添加'
            ,area: ['490px', '460px']
            ,shade: 0
            ,maxmin: true
            ,offset: '200px'
            // id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input" id="" autocomplete="off" style="width: 200px;display: inline;margin:10px;" align="center"><br>
            // 这个地方不要缩进分行，我查了这个content不能分行orz,id内容你们自己定一个吧****************************************************************
            //TODO:使用form标签对每个input设定name属性值并与bean属性名一致完成参数绑定
            ,content: '<form id="add" style="padding: 20px;" role="form">项目编码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="itemcode" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>项目名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="itemname" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>规格：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="format" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>单价：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="price" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>所属费用科目ID：<input class="layui-input"  name="expclassid" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>执行科室ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="deptid" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>拼音助记码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="mnemoniccode" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>项目类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="recordtype" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br>创建时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input" type="date" name="creationdate" autocomplete="off" style="width: 200px;display: inline;margin:10px;"><br></form>'
            ,btn: ['确定','关闭']
            ,yes: function() {
              $.ajax({
                type: "POST",
                url: "fmedItem/add",
                data: $('#add').serialize(),
                success: function (res) {
                  if (res.status == 0) {
                  } else {
                    layer.msg(res.message)
                  }
                  layer.closeAll();
                  layui.table.reload('test-table-reload');
                },
                error: function () {
                  alert("出现错误");
                  return false;
                }
              }) //ajax结束
            }
            ,btn2: function(){
              // 此处要写递交的函数，但是不要把我closall的函数删掉***********************************************************************

              layer.closeAll();
            }

            ,zIndex: layer.zIndex
            ,success: function(layero){
              layer.setTop(layero);
            }
          });
        }

        // 编辑弹窗
        ,edit: function(othis){
          var tabledata=layui.table.checkStatus('test-table-reload').data;
          var html = '<form id="update" style="padding: 20px;" role="form">id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input" name="id" autocomplete="off" style="width: 200px;display: inline;margin:10px;" align="center" value="'+tabledata[0].id+'"><br>项目编码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="itemcode" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].itemcode+'"><br>项目名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="itemname" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].itemname+'"><br>规格：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="format" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].format+'"><br>单价：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="price" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].price+'"><br>所属费用科目ID：<input class="layui-input"  name="expclassid" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].expclassid+'"><br>执行科室ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="deptid" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].deptid+'"><br>拼音助记码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="mnemoniccode" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].mnemoniccode+'"><br>项目类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input"  name="recordtype" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].recordtype+'"><br>创建时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input" type="date" name="creationdate" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+dateToStr(tabledata[0].creationdate)+'"><br></form>';
          var type = othis.data('type')
                  ,text = othis.text();

          layer.open({
            type: 1
            ,offset: '200px'
            ,title: '非药品收费项目编辑'
            ,id: 'layerDemo'+type
            ,area: ['490px', '460px']
            ,content: html            // '<form id="update" style="padding: 20px;">id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="layui-input" id="" autocomplete="off" style="width: 200px;display: inline;margin:10px;" align="center" value="'+tabledata[0].id+'"><br>科室编码：<input class="layui-input" id="" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].deptcode+'"><br>科室名称：<input class="layui-input" id="" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].deptname+'"><br>科室分类：<input class="layui-input" id="" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].deptcategoryid+'"><br>科室类型：<input class="layui-input" id="" autocomplete="off" style="width: 200px;display: inline;margin:10px;" value="'+tabledata[0].depttype+'"><br></form>'
            ,btn:['确定','取消']
            ,btnAlign: 'c'
            ,shade: 0
            ,yes: function(){
              // 写下编辑的提交方法**********************************************************
              $.ajax({
                type: "POST",
                url: "fmedItem/update",
                data: $('#update').serialize(),
                success: function (res) {
                  if (res.status == 0) {
                  } else {
                    layer.msg(res.message)
                  }
                  layer.closeAll();
                  layui.table.reload('test-table-reload');
                },
                error: function () {
                  alert("出现错误");
                  return false;
                }
              }) //ajax结束
            }
            ,btn2:function(){
              layer.closeAll();
            }
          });
        }
        ,deltable:function(othis){
          var type = othis.data('type')
                  ,text = othis.text();
          var tabledata=layui.table.checkStatus('test-table-reload').data;
          var table ="<div style='text-align: center;'> <table border='1px' style='margin: auto' cellspacing='10px' cellpadding='10px'><th>ID</th><th>项目编码</th><th>项目名称</th><th>规格</th><th>单价</th><th>所属费用科目ID</th><th>执行科室ID</th><th>拼音助记码</th><th>项目类型</th><th>创建时间</th>"
          for(var i=0;i<tabledata.length;i++){
            table+="<tr><td>"+tabledata[i].id+"</td><td>"+tabledata[i].itemcode+"</td><td>"+tabledata[i].itemname+"</td><td>"+tabledata[i].format+"</td><td>"+tabledata[i].price+"</td><td>"+tabledata[i].expclassid+"</td><td>"+tabledata[i].deptid+"</td><td>"+tabledata[i].mnemoniccode+"</td><td>"+tabledata[i].recordtype+"</td><td>"+dateToStr(tabledata[i].creationdate)+"</td></tr>";
          }
          table+="</table> </div>";

          var myArray=[];
          for(var i=0;i<tabledata.length;i++){
            // myArray[i]=tabledata[i].id;
            myArray.push(tabledata[i].id);
          }


          layer.open({
            type:1
            ,offset: '200px'
            ,title: '删除确认'
            ,id: 'layerDemo'+type
            ,area: ['490px', '460px']
            ,content: table
            ,btn:['确定','取消']
            ,btnAlign: 'c'
            ,shade: 0
            ,yes:function(){

              $.ajax({
                type: "POST",
                url: "fmedItem/delete",
                traditional: true,
                data:{'ids': myArray},
                success: function (res) {
                  if (res.status == 0) {
                    layer.msg(res.message);
                  } else {
                    layer.msg(res.message);
                  }
                  layer.closeAll();
                  layui.table.reload('test-table-reload');
                },
                error: function () {
                  alert("出现错误");
                  return false;
                }
              })

            }
            ,btn2:function(){
              layer.closeAll();
            }

          })

        }
        // 导入弹窗
        ,upload: function(othis){
          var type = othis.data('type')
                  ,text = othis.text();

          layer.open({
            type: 2
            ,offset: '200px'
            ,title: '文件导入'
            ,id: 'layerDemo'+type
            ,area: ['490px', '460px']
            ,content: 'fmedItem/uploadUI'
            ,btn:['确定','取消']
            ,btnAlign: 'c'
            ,shade: 0
            ,yes: function(){
              // 写下导入的提交方法**********************************************************
              layer.closeAll();
            }
            ,btn2:function(){
              layer.closeAll();
            }
          });
        }
      };

      $('#LAY-component-layer-special-demo .layadmin-layer-demo .layui-btn').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
      });
    });
  </script>
  <%--  <script>--%>
  <%--      layui.use(['index','table'], function(){--%>
  <%--          var table = layui.table;--%>
  <%--          //监听表格复选框选择--%>
  <%--          table.on('checkbox(demo)', function(obj){--%>
  <%--              console.log(obj)--%>
  <%--          });--%>

  <%--          var $ = layui.$, active = {--%>
  <%--              getCheckData: function(){ //获取选中数据--%>
  <%--                  var checkStatus = table.checkStatus('test-table-reload')--%>
  <%--                      ,data = checkStatus.data;--%>
  <%--                  layer.alert(data);//我这里是把选中的数据进行了弹窗显示，现在的data就是所选中的数据了--%>
  <%--                  // $.ajax({--%>
  <%--                  //     type: "POST",--%>
  <%--                  //     url: "department/delete",--%>
  <%--                  //     data: data[0].id,--%>
  <%--                  //     success: function (res) {--%>
  <%--                  //         if (res.status == 0) {--%>
  <%--                  //         } else {--%>
  <%--                  //             layer.msg(res.message)--%>
  <%--                  //         }--%>
  <%--                  //         layer.closeAll();--%>
  <%--                  //     },--%>
  <%--                  //     error: function () {--%>
  <%--                  //         alert("出现错误");--%>
  <%--                  //         return false;--%>
  <%--                  //     }--%>
  <%--                  // }) //ajax结束--%>
  <%--                  //data.del();--%>
  <%--                  //这个地方你们写一行删除，把我上一行删了就行***********************************--%>
  <%--              }--%>
  <%--              ,getCheckLength: function(){ //获取选中数目--%>
  <%--                  var checkStatus = table.checkStatus('test-table-reload')--%>
  <%--                      ,data = checkStatus.data;--%>
  <%--                  //data.length 是选中的个数 你们直接哪来用就行--%>
  <%--              }--%>
  <%--              ,isAll: function(){ //验证是否全选--%>
  <%--                  var checkStatus = table.checkStatus('idTest');--%>
  <%--                  //checkStatus.isAll 是是否全选值，全选等于bool为1，反之为0--%>
  <%--              }--%>
  <%--          };--%>

  <%--          $('.demoTable .layui-btn').on('click', function(){--%>
  <%--              var type = $(this).data('type');--%>
  <%--              active[type] ? active[type].call(this) : '';--%>
  <%--          });--%>
  <%--      });--%>
  <%--  </script>--%>
  <script>
    layui.config({
      base: 'department/' //静态资源所在路径
    }).extend({
      index: 'lib/index' //主入口模块
    }).use(['index', 'upload'], function(){
      var $ = layui.jquery
              ,upload = layui.upload;


      //拖拽上传
      upload.render({
        elem: '#test-upload-drag'
        ,url: '/upload/'
        ,done: function(res){
          console.log(res)
        }
      });


      //绑定原始文件域
      upload.render({
        elem: '#test-upload-primary'
        ,url: '/upload/'
        ,done: function(res){
          console.log(res)
        }
      });

    });
  </script>
</body>
</html>