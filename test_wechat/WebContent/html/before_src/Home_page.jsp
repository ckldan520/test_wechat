<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>卓目棉花异纤"云"清除机</title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
    
 	<jsp:useBean id="basic_data" class="org.tiansheng.scs.sdk.Basic_data" ></jsp:useBean>   
    
 </head>

  <body class="nav-md">
      <div class="container body">
      <div class="main_container">
         <!-- 内容均在此下-->
        
        <!-- sidebar menu 左边导航栏-->
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><span>异纤机</span></a>
            </div>
            <div class="clearfix"></div>
            <!-- /menu profile quick info -->
            <br />            
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>导航栏</h3>
                <ul class="nav side-menu">
                  <li><a href="State.html"><i class="fa fa-bar-chart"></i> 设备状态 </a>
                  <li><a ><i class="fa fa-gear"></i> 设备控制 </a>
                  <li><a ><i class="fa fa-image"></i> 异纤图片</a>
                  <li><a href="Info.html"><i class="fa fa-edit"></i> 会员中心 </a>
                  </li>
                  <li><a><i class="fa fa-book"></i> 用户手册 <span class="fa fa-chevron-down"></span></a>
                     <ul class="nav child_menu">
                      <li><a href="Guide.html#first_paragraph">简易操作流程</a></li>
                      <li><a href="Guide.html#second_paragraph">清洁维护流程</a></li>
                    </ul>                 
                  </li>
                  <li><a href="Feedback.html"><i class="fa fa-bug"></i> 反馈 </a>                
                  </li>        
                </ul>
              </div>
            </div>
          </div>
        </div>

        <!-- top navigation  上部导航条-->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a aria-expanded="false" >
                  	欢迎您，<jsp:getProperty property="user_name" name="basic_data"/>
                  </a>
                </li>
                <li class="">
                  <a aria-expanded="false" style="color:red;font-size:16px;" >
                  	<span style="color:red;font-size:16px;">测试版本1.0</span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <!-- top tiles 基础信息-->
          <div class="row">
          <table >
           <tr>
		    <div class="row tile_count"  style="height: 100px;width:100%;">
            <div class="col-md-3   tile_stats_count" style="height: 90px; ">
              <span class="count_top"><i class="fa fa-sun-o"></i> 设备温度</span>
              <div class="count red">
					<jsp:getProperty property="equip_temper" name="basic_data"/>
			  </div>             
            </div>
            <div class="col-md-3   tile_stats_count" style="height: 90px; ">
              <span class="count_top"><i class="fa fa-angle-double-right"></i> 棉花流速</span>
              <div class="count">
					<jsp:getProperty property="cotton_speed" name="basic_data"/>
		      </div>    
            </div>
            </div>
           </tr>
           </table>
           <table>
           <tr>
			<div class="row tile_count"  style="height: 100px;width:100%;">
            <div class="col-md-3   tile_stats_count" style="height: 90px; ">
              <span class="count_top"><i class="fa fa-database"></i> 日统计量</span>
              <div class="count green">
             		 <jsp:getProperty property="cotton_speed" name="basic_data"/>
              </div>        
            </div>
            <div class="col-md-3   tile_stats_count" style="height: 90px; ">
              <span class="count_top"><i class="fa fa-clock-o"></i> 灯管寿命</span>
              <div class="count">9361</div><span>/20000小时</span>      
            </div>  
            </div>
		  </tr>
          </table>
          </div>
            
          <!-- /top tiles -->    
          <!-- main tiles 列表内容-->
          <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel tile fixed_height_640">
               	<div class="x_title">
                   <h2 style="font-size:24px">异纤统计量</h2>
                   <ul class="nav navbar-right panel_toolbox">
                   <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                   </li>
                   </ul>
                   <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <h4 style="font-size:20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间</h4>
                  
                  <div class="widget_summary">
                    <div class="w_center w_25" style="width: 101px; height: 31px;">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">0:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 67%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2014</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>

                  <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">1:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>1821</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                  <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">2:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 59%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>1789</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                  <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">3:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 41%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>1232</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                  <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">4:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 26%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>786</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                  <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">5:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 79%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2377</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
    			 <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">6:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 72%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2188</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                 <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">7:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 76%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2284</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">8:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 84%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2535</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">9:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 81%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2442</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
       			<div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">10:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 82%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2458</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                  <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">11:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 71%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2138</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
				<div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">12:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 76%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2276</span>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  
                <div class="widget_summary">
                    <div class="w_left w_25" style="width: 101px; height: 31px; ">
                      <span style="width:100%;text-align:center;display:block;;font-size:16px">13:00</span>
                    </div>
                    <div class="w_center w_55">
                      <div class="progress">
                        <div class="progress-bar bg-green" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 82%;">
                        </div>
                      </div>
                    </div>
                    <div class="w_right w_20">
                      <span>2468</span>
                    </div>
                    <div class="clearfix"></div>
              	</div>
                  
                </div>
              </div>
            </div>            
          </div>
          <!-- /main tiles 列表内容-->
        </div>
        <!-- /page content -->

        <!-- footer content 尾页-->
        <footer>
          <div class="pull-right">
            	<span  style="width:100%;text-align:left;display:block">@卓目异纤机</span>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>
	<!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="../vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="../vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="../vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="../vendors/Flot/jquery.flot.js"></script>
    <script src="../vendors/Flot/jquery.flot.pie.js"></script>
    <script src="../vendors/Flot/jquery.flot.time.js"></script>
    <script src="../vendors/Flot/jquery.flot.stack.js"></script>
    <script src="../vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="../vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="../vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="../vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="../vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="../vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="../vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="../vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
  </body>
</html>
