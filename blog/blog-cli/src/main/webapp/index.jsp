<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="meta.jsp" />
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" class="no-js" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>WITCREAM</title>
    <meta name="description" content="">
    <link rel="shortcut icon" type="image/png" href="images/48.png"/>
    <!-- CSS FILES -->
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" data-name="skins"> -->
    <link rel="stylesheet" href="css/layout/wide.css" data-name="layout">

    <link rel="stylesheet" href="css/style-fraction.css"/>
    <link rel="stylesheet" href="css/animate.css"/>

    <link rel="stylesheet" type="text/css" href="css/switcher.css" media="screen" />

    <link rel="stylesheet" type="text/css" href="vendor/rs-plugin/css/settings.css" media="screen"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="home">
    <div class="loader"></div>
    <jsp:include page="top-nav.jsp" flush="true" />
    <section class="wrapper">
        <!--slider-->
        <div class="tp-banner-container">
            <div class="tp-banner">
                <ul>  <!-- SLIDE  -->
                <li data-transition="fade" data-slotamount="25" data-masterspeed="2500"
                    data-thumb="images/slider/slider_img_01.jpg" data-saveperformance="off">
                    <!-- MAIN IMAGE -->
                    <img src="images/slider/slider_img_01.jpg" alt="fullslide2" data-bgposition="center center" data-kenburns="on"
                         data-duration="12000" data-ease="Power0.easeInOut" data-bgfit="115" data-bgfitend="100"
                         data-bgpositionend="center center">

                    <div class="tp-caption very_large_text lfb ltt skewfromrightshort fadeout tp-resizeme head-tag"
                         data-x="637"
                         data-y="100"
                         data-speed="1000"
                         data-start="3500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; font-size:63px;white-space: nowrap;color:#f9844c;"><h1>生活</h1>
                    </div>
                    <div class="tp-caption very_large_text lfb ltt skewfromrightshort fadeout tp-resizeme head-tag"
                         data-x="790"
                         data-y="100"
                         data-speed="1000"
                         data-start="4080"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; font-size:63px;white-space: nowrap;color:#fff;"><h1>总是在无意间</h1>
                    </div>

                    <!-- LAYERS -->
                    <div class="tp-caption very_large_text lfb ltt skewfromrightshort fadeout tp-resizeme"
                         data-x="637"
                         data-y="182"
                         data-speed="1000"
                         data-start="4500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; font-size:63px;white-space: nowrap;color:#fff;"><h1>给我们</h1>
                    </div>
                    <div class="tp-caption very_large_text lfb ltt skewfromrightshort fadeout tp-resizeme"
                         data-x="924"
                         data-y="182"
                         data-speed="1500"
                         data-start="5500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; font-size:63px;white-space: nowrap;color:#f9844c;"><h1>希望</h1>
                    </div>


                    <div class="tp-caption lft randomrotate customout"
                         data-x="left"
                         data-y="center" data-voffset="110"
                         data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                         data-speed="800"
                         data-start="1500"
                         data-easing="Back.easeOut"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         data-captionhidden="on"
                         style="z-index: 9"><img src="images/slider/mobile.png" alt="" data-ww="550" data-hh="490">
                    </div>

                    <div class="tp-caption lfl randomrotate tp-resizeme"
                         data-x="60"
                         data-y="bottom" data-voffset="-70"
                         data-speed="800"
                         data-start="2000"
                         data-easing="Back.easeOut"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         data-captionhidden="on"
                         style="z-index: 9"><img src="images/slider/html.png" alt="" data-ww="125" data-hh="160">
                    </div>

                    <div class="tp-caption randomrotate tp-resizeme"
                         data-x="210"
                         data-y="bottom" data-voffset="-70"
                         data-speed="800"
                         data-start="2500"
                         data-easing="Back.easeOut"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         data-captionhidden="on"
                         style="z-index: 9"><img src="images/slider/css.png" alt="" data-ww="125" data-hh="160">
                    </div>
                    <div class="tp-caption sfr randomrotate tp-resizeme"
                         data-x="360"
                         data-y="bottom" data-voffset="-70"
                         data-speed="800"
                         data-start="3000"
                         data-easing="Back.easeOut"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         data-captionhidden="on"
                         style="z-index: 9"><img src="images/slider/js.png" alt="" data-ww="125" data-hh="160">
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption lfl tp-resizeme"
                         data-x="637"
                         data-y="240"
                         data-speed="800"
                         data-start="6000"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         style="z-index: 2; white-space: nowrap;">
                        <h2 class="white_shadow_text">看一本书</h2>
                    </div>

                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption  lfl tp-resizeme"
                         data-x="637"
                         data-y="300"
                         data-speed="800"
                         data-start="6200"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <h2 class="white_shadow_text">去一次户外</h2>
                    </div>
                    <!-- LAYER NR. 4 -->
                    <div class="tp-caption  lfl tp-resizeme"
                         data-x="637"
                         data-y="360"
                         data-speed="800"
                         data-start="6400"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <h2 class="white_shadow_text">和家人逛一次商场</h2>
                    </div>

                    <!-- LAYER NR. 5 -->
                    <div class="tp-caption lfr tp-resizeme start-button"
                         data-x="1037"
                         data-y="360"
                         data-speed="800"
                         data-start="7000"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <button type="button" class="btn btn-danger" style="background-color:transparent;">详情</button>
                    </div>
                </li>

                <li class="items" data-transition="slideleft" data-slotamount="1" data-masterspeed="1500"
                    data-thumb="images/slider/slider_img_02.jpg" data-delay="13000" data-saveperformance="on">
                    <!-- MAIN IMAGE -->
                    <img src="images/slider/slider_img_02.jpg" alt="kenburns1" data-bgposition="left center" data-kenburns="on"
                         data-duration="14000" data-ease="Linear.easeNone" data-bgfit="100" data-bgfitend="130"
                         data-bgpositionend="right center">
                    <!-- LAYERS -->


                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption very_large_text lfb ltt tp-resizeme head-tag"
                         data-x="left" data-hoffset="20"
                         data-y="center" data-voffset="-100"
                         data-speed="600"
                         data-start="500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="chars"
                         data-elementdelay="0.08"
                         style="z-index: 2; white-space: nowrap;">
                        <h1><span>WITCREAM</span>是我的思想</h1>
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class=" tp-caption  lfl tp-resizeme"
                         data-x="left" data-hoffset="30"
                         data-y="180"
                         data-speed="800"
                         data-start="1500"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         style="z-index: 2; white-space: nowrap;">
                        <h2 class="white_shadow_text">带给你一份充实</h2>
                    </div>

                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption  lfl tp-resizeme"
                         data-x="left" data-hoffset="30"
                         data-y="240"
                         data-speed="800"
                         data-start="2000"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <h2 class="white_shadow_text">带给你一丝快乐</h2>
                    </div>

                    <!-- LAYER NR. 4 -->
                    <div class="tp-caption  lfl tp-resizeme"
                         data-x="left" data-hoffset="30"
                         data-y="300"
                         data-speed="800"
                         data-start="2500"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <h2 class="white_shadow_text">带给你一个新的起点</h2>
                    </div>

                    <!-- LAYER NR. 5 -->
                    <div class="tp-caption lfr tp-resizeme"
                         data-x="left" data-hoffset="30"
                         data-y="380"
                         data-speed="1000"
                         data-start="3500"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <button type="button" class="btn btn-danger" style="background-color:transparent;">详情</button>
                    </div>
                </li>
                <li class="items" data-transition="slidevertical" data-slotamount="1" data-masterspeed="1500"
                    data-thumb="images/slider/slider_img_03.jpg" data-delay="13000" data-saveperformance="off">
                    <!-- MAIN IMAGE -->
                    <img src="images/slider/slider_img_03.jpg" alt="kenburns1" data-bgposition="left center" data-kenburns="on"
                         data-duration="14000" data-ease="Linear.easeNone" data-bgfit="100" data-bgfitend="130"
                         data-bgpositionend="right center">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption very_large_text lfb ltt tp-resizeme head-tag"
                         data-x="center" data-hoffset="0"
                         data-y="center" data-voffset="-160"
                         data-speed="1200"
                         data-start="1700"
                         data-easing="Power3.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.05"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 2; white-space: nowrap;">
                        <h1><span>我相信大家一起努力</span> 会创造更多的美好 </h1>
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption  lfl tp-resizeme small-text"
                         data-x="center" data-hoffset="0"
                         data-y="center" data-voffset="-60"
                         data-speed="1500"
                         data-start="2000"
                         data-easing="Power1.easeInOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 3; white-space: nowrap;">
                        <p>世界上最宽阔的是海洋,比海洋更宽阔的是天空,比天空更宽阔的是人的胸怀.</p>
                    </div>

                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption  lfl tp-resizeme small-text"
                         data-x="center" data-hoffset="0"
                         data-y="center" data-voffset="-30"
                         data-speed="1500"
                         data-start="2000"
                         data-easing="Power1.easeInOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 3; white-space: nowrap;">
                        <p>一个人如果不到最高峰,他就没有片刻的安宁,他也就不会感到生命的恬静和光荣.</p>
                    </div>

                    <!-- LAYER NR. 4 -->
                    <div class="tp-caption lfr tp-resizeme start-button"
                         data-x="center" data-hoffset="0"
                         data-y="center" data-voffset="33"
                         data-speed="1000"
                         data-start="3000"
                         data-easing="Power4.easeInOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="1000"
                         data-endeasing="Power1.easeOut"
                         style="z-index: 3; white-space: nowrap;">
                        <button type="button" class="btn btn-danger" style="background-color:transparent;">详情</button>
                    </div>
                    <div class="tp-caption tp-resizeme lfb randomrotate down-arrow"
                         data-x="center" data-hoffset="0"
                         data-y="center" data-voffset="180"
                         data-speed="1200"
                         data-start="5500"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                         style="z-index: 3; max-width: 50px; max-height: 50px; white-space: nowrap;">
                        <i class="scroll-bottom"><img src="images/slider_button.png" alt="arrow-down.png"
                                                      class="img-responsive"></i>
                    </div>
                </li>
                </ul>
            </div>
        </div>
        <!--slider end-->
        <!--blog-->
        <section class="content blog">
            <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="dividerHeading">
                        <h4><span>免费模板</span></h4>
                    </div>
                    <div id="recent-work-slider" class="owl-carousel">
                    </div>
                </div>
            </div>

            <div class="row pdt-30">
                <div class="col-sm-9 col-md-9 col-lg-9">

                    <div class="blog_large" id="blog-list">
                        <article class="post">
                            <figure class="post_img">
                                <a href="#">
                                    <img src="images/blog/blog_1.png" alt="blog post">
                                </a>
                            </figure>
                            <div class="post_date">
                                <span class="day">28</span>
                                <span class="month">9月</span>
                            </div>
                            <div class="post_content">
                                <div class="post_meta">
                                    <h2>
                                        <a href="#">程序员请放下你的技术情节，与你的同伴一起进步</a>
                                    </h2>

                                    <div class="metaInfo">
                                        <span><i class="fa fa-calendar"></i> <a href="#">2015年9月8日</a> </span>
                                        <span><i class="fa fa-user"></i> By <a href="#">Joey</a> </span>
                                        <span><i class="fa fa-tag"></i> <a href="#">日记</a>, <a href="#">分享</a> </span>
                                        <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
                                    </div>
                                </div>
                                <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
                                <a class="btn btn-small btn-default" href="#">更多</a>
                            </div>
                        </article>

                        <article class="post">
                            <figure class="post_img">

                                <!-- Post Image Slider -->
                                <div id="slider" class="swipe">
                                    <ul class="swipe-wrap">
                                        <li><img src="images/blog/blog_2.png" alt="blog post"></li>
                                        <li><img src="images/blog/blog_1.png" alt="blog post"></li>
                                        <li><img src="images/blog/blog_3.png" alt="blog post"></li>
                                    </ul>
                                    <div class="swipe-navi">
                                        <div class="swipe-left" onclick="mySwipe.prev()"><i class="fa fa-chevron-left"></i></div>
                                        <div class="swipe-right" onclick="mySwipe.next()"><i class="fa fa-chevron-right"></i></div>
                                    </div>
                                </div>
                            </figure>

                            <div class="post_date">
                                <span class="day">27</span>
                                <span class="month">Nov</span>
                            </div>

                            <div class="post_content">
                                <div class="post_meta">
                                    <h2>
                                        <a href="#">程序员请放下你的技术情节，与你的同伴一起进步</a>
                                    </h2>

                                    <div class="metaInfo">
                                        <span><i class="fa fa-calendar"></i> <a href="#">2015年9月8日</a> </span>
                                        <span><i class="fa fa-user"></i> By <a href="#">Joey</a> </span>
                                        <span><i class="fa fa-tag"></i> <a href="#">日记</a>, <a href="#">分享</a> </span>
                                        <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
                                    </div>
                                </div>
                                <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
                                <a class="btn btn-small btn-default" href="#">更多</a>
                            </div>
                        </article>

                        <article class="post">
                            <figure class="post_video">
                                <div class="video">
                                    <!--<iframe src="http://player.vimeo.com/video/3365942?title=0&amp;byline=0&amp;portrait=0"></iframe>-->
                                    <embed src="http://player.youku.com/player.php/sid/XNzQ3Mjg3MTU2/v.swf" allowFullScreen="true" quality="high" width="480" height="400" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
                                </div>
                            </figure>

                            <div class="post_date">
                                <span class="day">25</span>
                                <span class="month">Nov</span>
                            </div>

                            <div class="post_content">
                                <div class="post_meta">
                                    <h2>
                                        <a href="#">程序员请放下你的技术情节，与你的同伴一起进步</a>
                                    </h2>

                                    <div class="metaInfo">
                                        <span><i class="fa fa-calendar"></i> <a href="#">2015年9月8日</a> </span>
                                        <span><i class="fa fa-user"></i> By <a href="#">Joey</a> </span>
                                        <span><i class="fa fa-tag"></i> <a href="#">日记</a>, <a href="#">分享</a> </span>
                                        <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
                                    </div>
                                </div>
                                <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
                                <a class="btn btn-small btn-default" href="#">更多</a>
                            </div>
                        </article>

                        <article class="post">
                            <div class="post_date">
                                <span class="day">24</span>
                                <span class="month">Nov</span>
                            </div>
                            <div class="post_content">
                                <div class="post_meta">
                                    <h2>
                                        <a href="#">程序员请放下你的技术情节，与你的同伴一起进步</a>
                                    </h2>

                                    <div class="metaInfo">
                                        <span><i class="fa fa-calendar"></i> <a href="#">2015年9月8日</a> </span>
                                        <span><i class="fa fa-user"></i> By <a href="#">Joey</a> </span>
                                        <span><i class="fa fa-tag"></i> <a href="#">日记</a>, <a href="#">分享</a> </span>
                                        <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
                                    </div>
                                </div>
                                <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
                                <a class="btn btn-small btn-default" href="#">更多</a>
                            </div>
                        </article>

                        <article class="post">
                            <figure class="post_img">
                                <a href="#">
                                    <img src="images/blog/blog_2.png" alt="blog post">
                                </a>
                            </figure>
                            <div class="post_date">
                                <span class="day">20</span>
                                <span class="month">Nov</span>
                            </div>
                            <div class="post_content">
                                <div class="post_meta">
                                    <h2>
                                        <a href="#">程序员请放下你的技术情节，与你的同伴一起进步</a>
                                    </h2>

                                    <div class="metaInfo">
                                        <span><i class="fa fa-calendar"></i> <a href="#">2015年9月8日</a> </span>
                                        <span><i class="fa fa-user"></i> By <a href="#">Joey</a> </span>
                                        <span><i class="fa fa-tag"></i> <a href="#">日记</a>, <a href="#">分享</a> </span>
                                        <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
                                    </div>
                                </div>
                                <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
                                <a class="btn btn-small btn-default" href="#">更多</a>
                            </div>
                        </article>
                    </div>
                </div>

                <!--Sidebar Widget-->
                <div class="col-sm-3 col-md-3 col-lg-3">
                	<jsp:include page="side-bar.jsp" flush="true" />
                </div>
            </div>
            <!--/.row-->
            </div>
        <!--/.container-->
        </section>

    </section>

    <jsp:include page="footer.jsp" flush="true" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- REVOLUTION Slider  -->
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/retina-1.1.0.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script> <!-- jQuery cookie -->
    <script type="text/javascript" src="js/styleswitch.js"></script> <!-- Style Colors Switcher -->
    <!-- REVOLUTION Slider  -->
    <script type="text/javascript" src="vendor/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="vendor/rs-plugin/js/jquery.themepunch.revolution.js"></script>
    <script type="text/javascript">
        //////// -- loader -- /////////
        /* setTimeout(function(){ $('.loader').fadeOut(); }, 2000); */
        //Rs-PLUGIN
        jQuery(document).ready(function() {
            jQuery('.tp-banner').show().revolution(
                    {
                        dottedOverlay:"none",
                        delay:10000,
                        startwidth:1170,
                        startheight:470,
                        hideThumbs:200,

                        thumbWidth:100,
                        thumbHeight:50,
                        thumbAmount:5,

                        navigationType:"none",
                        navigationArrows:"solo",
                        navigationStyle:"preview4",

                        touchenabled:"on",
                        onHoverStop:"off",

                        swipe_velocity: 0.7,
                        swipe_min_touches: 1,
                        swipe_max_touches: 1,
                        drag_block_vertical: false,

                        parallax:"mouse",
                        parallaxBgFreeze:"on",
                        parallaxLevels:[7,4,3,2,5,4,3,2,1,0],

                        keyboardNavigation:"off",

                        navigationHAlign:"center",
                        navigationVAlign:"bottom",
                        navigationHOffset:0,
                        navigationVOffset:20,

                        soloArrowLeftHalign:"left",
                        soloArrowLeftValign:"center",
                        soloArrowLeftHOffset:20,
                        soloArrowLeftVOffset:0,

                        soloArrowRightHalign:"right",
                        soloArrowRightValign:"center",
                        soloArrowRightHOffset:20,
                        soloArrowRightVOffset:0,

                        shadow:0,
                        fullWidth:"on",
                        fullScreen:"off",

                        spinner:"spinner4",

                        stopLoop:"off",
                        stopAfterLoops:-1,
                        stopAtSlide:-1,

                        shuffle:"off",

                        autoHeight:"off",
                        forceFullWidth:"off",



                        hideThumbsOnMobile:"off",
                        hideNavDelayOnMobile:1500,
                        hideBulletsOnMobile:"off",
                        hideArrowsOnMobile:"off",
                        hideThumbsUnderResolution:0,

                        hideSliderAtLimit:0,
                        hideCaptionAtLimit:0,
                        hideAllCaptionAtLilmit:0,
                        startWithSlide:0,
                        videoJsPath:"rs-plugin/videojs/",
                        fullScreenOffsetContainer: ""
                    });
        });
    </script>
    <script type="text/javascript" src="js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/jflickrfeed.js"></script>
    <script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="js/jquery.easypiechart.min.js"></script>
    <script type="text/javascript" src="js/swipe.js"></script>
    <script type="text/javascript" src="js/jquery-hoverdirection.min.js"></script>
    <script type="text/javascript" src="js/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="js/jquery-scrolltofixed-min.js"></script>

    <script src="js/main.js"></script>
    
    <script type="text/javascript">/* 首先加载页面元素 */
    $(function() {
    	/*选中关首页*/
		$("ul.navbar-nav").find("li").removeClass("active");
    	$("#index-pg").addClass("active");
		$.ajax({/* 加载日志页*/
			type : "post",
			url : "blog/getBlogsList.do",
			data : {
				/* productID : "${productID}",skuNo:"${skuNo}" */
			},
			success : function(data) {

				if (data.success) {
					var blogList = data.obj.rows;
					
					var $blogList = $("#blog-list");
                	$blogList.empty();//清空节点
                	var content = "";
					for(var j = 0;j<blogList.length;j++){
						var blog = blogList[j];
						/* var tags  = blog.tags.split(",");
						var tagContent = "<span><i class=\"fa fa-tag\"></i>";
						for(var i = 0;i<tags.length;i++){
							if(i==0){
								tagContent += "<a href=\"#\">"+tags[i]+"</a>"
							}else{
								tagContent += ",<a href=\"#\">"+tags[i]+"</a>"
							}
						}
						tagContent +="</span>"; */
						var tags  = blog.tagsSet;
						var tagContent = "<span><i class=\"fa fa-tag\"></i>";
						for(var i = 0;i<tags.length;i++){
							if(i==0){
								tagContent += "<a href=\"#\">"+tags[i].tagName+"</a>"
							}else{
								tagContent += ",<a href=\"#\">"+tags[i].tagName+"</a>"
							}
						}
						tagContent +="</span>";
						
						var articleContent = "<article class=\"post\"><figure class=\"post_img\"><a href=\""+blog.blogDetailUrl+"\"><img src=\""+blog.mainPicPath+"\" alt=\"blog post\"></a></figure>"
						+"<div class=\"post_content\"><div class=\"post_meta\"><h2><a href=\""+blog.blogDetailUrl+"\">"+blog.blogTitle+"</a></h2>"
						+"<div class=\"metaInfo\"><span><i class=\"fa fa-calendar\"></i> <a href=\"#\">"+blog.createDt+"</a></span>"
                        +"<span><i class=\"fa fa-user\"></i> By <a href=\"#\">"+blog.author+"</a></span>"
                        +tagContent
                        +"<span><i class=\"fa fa-comments\"></i> <a href=\"#\">"+blog.commentCount+" Comments</a></span>"
                    	+"</div> </div><p>"+blog.blogSummary+"</p><a class=\"btn btn-small btn-default\" href=\""+blog.blogDetailUrl+"\">更多</a></div></article>";
						content+=articleContent;
					}
					$blogList.html(content);
				}
			},
			dataType : "json"
		});
		$.ajax({/* 加载最受欢迎日志和最新日志*/
			type : "post",
			url : "blog/getBlogsList.do",
			data : {
				/* productID : "${productID}",skuNo:"${skuNo}" */
				rows:"3",
				sort:"likeCount",
				order:"desc"
			},
			success : function(data) {
				if (data.success) {
					var iList = data.obj.rows;
					var $popularList = $("#Popular");
                	$popularList.empty();//清空节点
                	var content = "<ul class=\"recent_tab_list\">";
					for(var j = 0;j<iList.length;j++){
						var item = iList[j];
						var articleContent = "<li><span><a href=\""+item.blogDetailUrl+"\"><img src=\""+item.mainPicPath+"\" alt=\"\"/></a></span>"
						+"<a href=\""+item.blogDetailUrl+"\">"+item.blogTitle+"</a><i>"+item.createDt+"</i></li>";
						content+=articleContent;
					}
					content+="</ul>";
					$popularList.html(content);
				}
			},
			dataType : "json"
		});
        $.ajax({/* 加载最受欢迎日志和最新日志*/
            type : "post",
            url : "blog/getBlogsList.do",
            data : {
            /* productID : "${productID}",skuNo:"${skuNo}" */
              rows:"3",
              sort:"createDt",
              order:"desc"
            },
   			success : function(data) {
   				if (data.success) {
   					var iList = data.obj.rows;
   					var $popularList = $("#Recent");
                   	$popularList.empty();//清空节点
                   	var content = "<ul class=\"recent_tab_list\">";
   					for(var j = 0;j<iList.length;j++){
   						var item = iList[j];
   						var articleContent = "<li><span><a href=\""+item.blogDetailUrl+"\"><img src=\""+item.mainPicPath+"\" alt=\"\"/></a></span>"
   						+"<a href=\""+item.blogDetailUrl+"\">"+item.blogTitle+"</a><i>"+item.createDt+"</i></li>";
   						content+=articleContent;
   					}
   					content+="</ul>";
   					$popularList.html(content);
   				}
   			},
   			dataType : "json"
   		});
        $.ajax({/* 加载分类*/
            type : "post",
            url : "blog/getAllCategorysCount.do",
            data : {},
   			success : function(data) {
   				if (data.success) {
   					var iList = data.obj;
   					var $iList = $("#category-count");
                   	$iList.empty();//清空节点
                   	var content = "";
   					for(var j = 0;j<iList.length;j++){
   						var item = iList[j];
   						var articleContent = "<li><a href=\"blog/blogSearchPage.do?isSearch=yes&blogCategory="+item.category+"\"> "+item.category+" ("+item.count+")</a></li>";
   						content+=articleContent;
   					}
   					$iList.html(content);
   				}
   			},
   			dataType : "json"
   		});
        $.ajax({/* 加载标签*/
            type : "post",
            url : "blog/getAllTagsCount.do",
            data : {},
   			success : function(data) {
   				if (data.success) {
   					var iList = data.obj;
   					var $iList = $("#tag-count");
                   	$iList.empty();//清空节点
                   	var content = "";
   					for(var j = 0;j<iList.length;j++){
   						var item = iList[j];
   						if(item.count>5){
   							var articleContent = "<li><a href=\"blog/blogSearchPage.do?isSearch=yes&tag="+item.tag+"\"><b> "+item.tag+"</b></a></li>";
   	   						content+=articleContent;
   						}else{
	   						var articleContent = "<li><a href=\"blog/blogSearchPage.do?isSearch=yes&tag="+item.tag+"\"> "+item.tag+"</a></li>";
	   						content+=articleContent;
   						}
   					}
   					$iList.html(content);
   				}
   			},
   			dataType : "json"
   		});
		$.ajax({/* 加载模板页*/
			type : "post",
			url : "template/getTemplatesByCondition.do",
			data : {
				/* productID : "${productID}",skuNo:"${skuNo}" */
			},
			success : function(data) {
				if (data.success) {
					$('.loader').fadeOut();//添加这一句是将加载图片抹不掉
					var templateList = data.obj.rows;
					var $templateList = $("#recent-work-slider");
                	$templateList.empty();//清空节点
                	var content = "";
					for(var j = 0;j<templateList.length;j++){
						var template = templateList[j];
						var articleContent = "<div class=\"recent-item box\"><figure class=\"touching\"><img src=\""+template.mainPicPath+"\" alt=\"\"/>"
				        +"<div class=\"option inner\"><div class=\"i_inner\"><h5>"+template.templateTitle+"</h5>"
				        +"<a href=\""+template.mainPicPath+"\" class=\"fa fa-search mfp-image\"></a>"
				        +"<a href=\""+template.templateDetailUrl+"\" class=\"fa fa-download\"></a>"
				        +"<span>"+template.templateSummary+"</span></div></div></figure></div>";
						content+=articleContent;
					}
					$templateList.html(content);
					 if(jQuery.isFunction(jQuery.fn.owlCarousel)){
					 // Recent Work Slider
			            $("#recent-work-slider").owlCarousel({
			                navigation : true,
			                pagination : false,
			                items : 5,
			                itemsDesktop:[1199,4],
			                itemsTablet : [768, 3],
			                itemsDesktopSmall : [992, 3],
			                itemsMobile : [480,1],
			                navigationText : ["",""]
			            });
					 }
					 if(jQuery.isFunction(jQuery.fn.hoverDirection)){
				            $('.box').hoverDirection();

				            // Example of calling removeClass method after a CSS animation
				            $('.box .inner').on('animationend', function (event) {
				                var $box = $(this).parent();
				                $box.filter('[class*="-leave-"]').hoverDirection('removeClass');
				            });
				        }
				}
			},
			dataType : "json"
		});
    });
    </script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->

    <!-- WARNING: Wow.js doesn't work in IE 9 or less -->
    <!--[if gte IE 9 | !IE ]><!-->
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script>
        // WOW Animation
        new WOW().init();
    </script>
    <![endif]-->

</body>
</html>