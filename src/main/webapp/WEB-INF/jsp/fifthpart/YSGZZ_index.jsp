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
  <title>医生工作站主页</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport"
    content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="department/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="department/style/admin.css" media="all">

  <!--   <script>
    //检测是否在服务器环境下
  /^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
  </script> -->
  <style>
    #content {
      text-overflow: ellipsis;
      overflow: hidden;
      white-space: nowrap;
      width: 200px;
    }
  </style>
  <script>
    onload = function () {
      content.onmouseover = function () {
        this.title = this.innerHTML;
      }
    }
  </script>

</head>

<body class="layui-layout-body" style="background-color: white">


  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect>
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
            </a>
          </li>

          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;" layadmin-event="refresh" title="刷新">
              <i class="layui-icon layui-icon-refresh-3"></i>
            </a>
          </li>

        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

          <li class="layui-nav-item" lay-unselect>
            <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
              <i class="layui-icon layui-icon-notice"></i>

              <!-- 如果有新消息，则显示小圆点 -->
              <span class="layui-badge-dot"></span>
            </a>
          </li>
          <!-- 便签功能 -->
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="note">
              <i class="layui-icon layui-icon-note"></i>
            </a>
          </li>

          <!-- 全屏 -->
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="fullscreen">
              <i class="layui-icon layui-icon-screen-full"></i>
            </a>
          </li>

          <!-- 用户信息 -->
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;">
              <cite>${sessionScope.user_name}</cite>
            </a>
            <dl class="layui-nav-child">
              <dd><a lay-href="set/user/info.html">基本资料</a></dd>
              <dd><a lay-href="set/user/password.html">修改密码</a></dd>
              <hr>
              <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
            </dl>
          </li>


          <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
            <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
          </li>
        </ul>
      </div>

      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" lay-href="">
            <span>患者列表</span>
          </div>

          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu"
            lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item">
              <a href="javascript:;" lay-tips="科室管理" lay-direction="2">
                <!-- <i class="layui-icon layui-icon-home"></i> -->
                <cite>本人待诊患者</cite>
              </a>
              <dl id="daizhen" class="layui-nav-child">

              </dl>
            </li>

            <li data-name="template" class="layui-nav-item">
              <a href="javascript:;" lay-tips="页面" lay-direction="2">
                <!-- <i class="layui-icon layui-icon-template"></i> -->
                <cite>本人已诊患者</cite>
              </a>
              <dl id="yizhen" class="layui-nav-child">

              </dl>
            </li>


              <li data-name="template" class="layui-nav-item">
              <a href="javascript:;" lay-tips="页面" lay-direction="2">
                <!-- <i class="layui-icon layui-icon-template"></i> -->
                <cite>科室未诊患者</cite>
              </a>
              <dl id="dpartdaizhen" class="layui-nav-child">


              </dl>
            </li>
              <li data-name="template" class="layui-nav-item">
                  <a href="javascript:;" lay-tips="页面" lay-direction="2">
                      <!-- <i class="layui-icon layui-icon-template"></i> -->
                      <cite>科室已诊患者</cite>
                  </a>
                  <dl id="dpartyizhen" class="layui-nav-child">


                  </dl>
              </li>
          </ul>
        </div>
      </div>




      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
        <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-down">
          <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
              <a href="javascript:;"></a>
              <dl class="layui-nav-child layui-anim-fadein">
                <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
              </dl>
            </li>
          </ul>
        </div>

        <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
          <ul class="layui-tab-title" id="LAY_app_tabsheader">
            <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i
                class="layui-icon layui-icon-home"></i></li>
          </ul>
        </div>
      </div>


      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">

          <iframe src="basic/Department_management.html" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
      </div>

      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>

  <script src="department/layui/layui.js"></script>
  <script>
      window.onload=function() {

          var $ = layui.$;
          $.ajax({
              type: "POST",//方法类型
              url: "fifthpart/daizhen",
              data:"doctorid=${sessionScope.doctorid}",//url
              async: false,
              success: function (result) {
                  if (result.status == 0) {
                      var daizhen = result.data;
                      $("#daizhen").empty();
                      for (var i=0;i<daizhen.length;i++) {
                          $("#daizhen").append("<dd data-name='console'><a lay-href='fifthpart/index2?medicalRecordNo=" + daizhen[i].medical_record_no +"'>" + daizhen[i].patient_name + "</a> </dd>");
                      }
                  }
              },
              error: function (result) {
                  alert(result.msg);
              }
          });
        $.ajax({
          type: "POST",//方法类型
          url: "fifthpart/yizhen",
          data:"doctorid=${sessionScope.doctorid}",//url
          async: false,
          success: function (result) {
            if (result.status == 0) {
              var yizhen = result.data;
              $("#yizhen").empty();
              for (var i=0;i<yizhen.length;i++) {
                $("#yizhen").append("<dd data-name='console'><a lay-href='fifthpart/index3?medicalRecordNo=" + yizhen[i].medical_record_no +"'>" + yizhen[i].patient_name + "</a> </dd>");
              }
            }
          },
          error: function (result) {
            alert(result.msg);
          }
        });
        $.ajax({
          type: "POST",//方法类型
          url: "fifthpart/dpartdaizhen",
          data:"departid=${sessionScope.departid}",//url
          async: false,
          success: function (result) {
            if (result.status == 0) {
              var daizhen = result.data;
              $("#dpartdaizhen").empty();
              for (var i=0;i<daizhen.length;i++) {
                $("#dpartdaizhen").append("<dd data-name='console'><a lay-href='fifthpart/index2?medicalRecordNo=" + daizhen[i].medical_record_no +"'>" + daizhen[i].patient_name + "</a> </dd>");
              }
            }
          },
          error: function (result) {
            alert(result.msg);
          }
        });
          $.ajax({
              type: "POST",//方法类型
              url: "fifthpart/dpartyizhen",
              data:"departid=${sessionScope.departid}",//url
              async: false,
              success: function (result) {
                  if (result.status == 0) {
                      var yizhen = result.data;
                      $("#dpartyizhen").empty();
                      for (var i=0;i<yizhen.length;i++) {
                          $("#dpartyizhen").append("<dd data-name='console'><a lay-href='fifthpart/index3?medicalRecordNo=" + yizhen[i].medical_record_no +"'>" + yizhen[i].patient_name + "</a> </dd>");
                      }
                  }
              },
              error: function (result) {
                  alert(result.msg);
              }
          });
      };

    layui.config({
      base: 'department/' //静态资源所在路径
    }).extend({
      index: 'lib/index' //主入口模块
    }).use('index');
  </script>


</body>

</html>