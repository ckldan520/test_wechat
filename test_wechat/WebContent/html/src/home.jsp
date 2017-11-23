<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="../css/amazeui.min.css">
    <link rel="stylesheet" href="../css/wap.css?2">
    <title>首页</title>
    
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
<body>
<div data-am-widget="gotop" class="am-gotop am-gotop-fixed">
    <a href="#top" title="">
        <img class="am-gotop-icon-custom" src="../image/goTop.png" />
    </a>
</div>

<div class="pet_mian" id="top">
	<!-- top image  上部图-->
	 <div data-am-widget="slider" class="am-slider am-slider-a1" data-am-slider='{"directionNav":false}' >
	  <ul class="am-slides">
	      <li>
	            <img src="../image/fl01.jpg">
	            <div class="pet_slider_font">
	                <span style="color:black;">追求第一，永远让客户满意！</span>
	            </div>
	            <div class="pet_slider_shadow"></div>
	      </li>
	      <li>
	            <img src="../image/fl02.jpg">
	            <div class="pet_slider_font">
	                <span style="color:black;">技术引领革新，性能超越想象。</span>
	            </div>
	            <div class="pet_slider_shadow"></div>
	      </li>
	  </ul>
	</div>
<!-- top navigation  上部导航条-->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a aria-expanded="false" >
                  	欢迎您，<jsp:getProperty property="user_name" name="basic_data"/>！
                  </a>
                </li>
                <li class="">
                  <a aria-expanded="false" style="color:red;font-size:16px;" >
                  	<span style="color:red;font-size:16px;">设备正常</span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        
           
   <!-- top tiles 基础信息-->
      <div class="row">
		    <div class="row tile_count"  style="height: 100px;width:100%;">
            <div class="col-md-3   tile_stats_count" style="height: 90px;width: 25%; left: 4%;">
              <span class="count_top"><i class="fa fa-sun-o"></i> 设备温度</span>
              <div class="count red">
              		<jsp:getProperty property="equip_temper" name="basic_data"/>
              </div>             
            </div>
            <div class="col-md-3   tile_stats_count" style="height: 90px; width:25%; ">
              <span class="count_top"><i class="fa fa-angle-double-right"></i> 棉花流速</span>
              <div class="count">
              		<jsp:getProperty property="cotton_speed" name="basic_data"/>
              </div>    
            </div>
            <div class="col-md-3   tile_stats_count" style="height: 90px; width:25%;">
              <span class="count_top"><i class="fa fa-database"></i> 日统计量</span>
              <div class="count green">
              		<jsp:getProperty property="day_count" name="basic_data"/>
              </div>        
            </div>
            <div class="col-md-3   tile_stats_count" style="height: 90px; width:25%;">
              <span class="count_top"><i class="fa fa-clock-o"></i> 灯管寿命</span>
              <div class="count">
              			<jsp:getProperty property="cotton_speed" name="basic_data"/>
              </div><span>/20000小时</span>      
            </div>  
            </div>
        </div>

 <!-- key tiles 按键栏-->
<div class="pet_circle_nav">
    <ul class="pet_circle_nav_list">
        <li><a href="" class="iconfont pet_nav_xinxianshi "><i class="fa fa-bar-chart"></i></a><span>数据统计</span></li>
        <li><a href="" class="iconfont pet_nav_zhangzhishi "><i class="fa fa-image"></i></a><span>异纤图片</span></li>
        <li><a href="" class="iconfont pet_nav_kantuya "><i class="fa fa-book"></i></a><span>用户手册</span></li>
        <li><a href="" class="iconfont pet_nav_mengzhuanti "><i class="fa fa-edit"></i> </a><span>会员中心</span></li>
        <li><a href="" class="iconfont pet_nav_meirong "><i class="fa fa-gear"></i></a><span>设备控制</span></li>
        <li><a href="" class="iconfont pet_nav_yiyuan "><i class="fa fa-bars"></i></a><span>新闻专栏</span></li>
        <li><a href="" class="iconfont pet_nav_dianpu "><i class="fa fa-bug"></i></a><span>信息反馈</span></li>
        <li><a href="javascript:;" class="iconfont pet_nav_gengduo "><i class="fa fa-ellipsis-h"></i></a><span>更多</span></li>
    </ul>
    <div class="pet_more_list"><div class="pet_more_list_block">
    <div class="iconfont pet_more_close">×</div>
    <div class="pet_more_list_block">
        <div class="pet_more_list_block_name">
            <div class="pet_more_list_block_name_title">阅读 Read</div>
            <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
                <div class="pet_more_list_block_line_font">新鲜事</div>
            </a>
                        <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
                <div class="pet_more_list_block_line_font">趣闻</div>
            </a>
                        <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
                <div class="pet_more_list_block_line_font">阅读</div>
            </a>
                        <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
                <div class="pet_more_list_block_line_font">专题</div>
            </a>
                                    <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
                <div class="pet_more_list_block_line_font">订阅</div>
            </a>
                                    <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_wd pet_more_list_block_line_ico">&#xe602;</i>
                <div class="pet_more_list_block_line_font">专栏</div>
            </a>
 <div class="pet_more_list_block_name_title pet_more_list_block_line_height">服务 Service</div>
              <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_xinxianshi pet_more_list_block_line_ico">&#xe61e;</i>
                <div class="pet_more_list_block_line_font">新鲜事</div>
            </a>
                        <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_zhangzhishi pet_more_list_block_line_ico">&#xe607;</i>
                <div class="pet_more_list_block_line_font">趣闻</div>
            </a>
                        <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_kantuya pet_more_list_block_line_ico">&#xe62c;</i>
                <div class="pet_more_list_block_line_font">阅读</div>
            </a>
                        <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_mengzhuanti pet_more_list_block_line_ico">&#xe622;</i>
                <div class="pet_more_list_block_line_font">专题</div>
            </a>
                                    <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_bk pet_more_list_block_line_ico">&#xe629;</i>
                <div class="pet_more_list_block_line_font">订阅</div>
            </a>
                                    <a class="pet_more_list_block_line">
                <i class="iconfont pet_nav_wd pet_more_list_block_line_ico">&#xe602;</i>
                <div class="pet_more_list_block_line_font">专栏</div>
            </a>
        </div>
    </div>

    </div></div>
</div>

<div class="pet_article_dowload pet_dowload_more_top_off">
      <div class="pet_article_dowload_title" style="color:black; font-size:16px;">关于卓目</div>
      <div class="pet_article_dowload_content pet_dowload_more_top_bg"><div class="pet_article_dowload_triangle pet_dowload_more_top_san"></div>
      <div class="pet_article_dowload_ico"><img src="../image/zoomer.jpg"></div>
      <div class="pet_article_dowload_content_font" >
     	<p style="color:black;font-size:14px;">
			电话：027-87526592
		<br>传真：027-68778696转808
		<br>手机：13971628989
		<br>邮箱：tctzf138@sina.com
		<br>地址：湖北省武汉市武昌区武汉大学文理学部计算机大楼G区2楼
		</p>
		 </div>
      </div>
      <div class="pet_article_footer_info">Copyright(c)2017 @卓目"云"异纤清除机 </div>
</div>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/amazeui.min.js"></script>
<script>
$(function(){

    // 动态计算新闻列表文字样式
    auto_resize();
    $(window).resize(function() {
        auto_resize();
    });
    $('.am-list-thumb img').load(function(){
        auto_resize();
    });

    $('.am-list > li:last-child').css('border','none');
    function auto_resize(){
        $('.pet_list_one_nr').height($('.pet_list_one_img').height());

    }
        $('.pet_nav_gengduo').on('click',function(){
            $('.pet_more_list').addClass('pet_more_list_show');
       });
        $('.pet_more_close').on('click',function(){
            $('.pet_more_list').removeClass('pet_more_list_show');
        });
});

</script>
</body>
</html>