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
    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" data-name="skins">
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
    <jsp:include page="top-nav.jsp" flush="true" />
    <section class="wrapper">
        <section class="page_head">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="i_sentence">
                            <!--<h2>About Us</h2>-->
                            <p>像“草根”一样，紧贴着地面，低调的存在，冬去春来，枯荣无恙。</p>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.jsp">首页</a>/</li>
                                <li>关于我</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!--blog-->
        <section class="content blog">
            <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-9 col-lg-9">
                    <div class="dividerHeading">
                        <h4><span>Just for me</span></h4>
                    </div>
                    <img class="left_img img-thumbnail" src="images/about_1.png" alt="about img">
                    <p>杨巍，男，一个80后草根站长！有着大多数程序员的天赋--宅，不善言语，但内心狂热。我有一个小梦想：让家人不这么劳累也能过上小康生活！呜呼！
                        我也有每个程序员都有的大梦想：改变世界！
                        这个博客是在我失业的时候写的，没有什么技术含量，仅仅想再给别人有用东西的同时能赚到一点小钱就最好，哈哈……从业已经有三年多,进的小公司，没学习到高大上的技术，做网站确实是因为个人爱好，或许可以满足我缺失的自信。
                        每天都在思考着做些什么，很多点子当时想着很好，有时一下钻进幻想一个小时都出不来，后来又因为各种原因把它否认，然后觉得还是老老实实从基础出发，先做个简单的个人博客再说吧。</p>
                    <p>
                        人生就是一个得与失的过程，我一直相信“塞翁失马，焉知非福”，而我却是一个幸运者，因为我忘记了所有的失去。生活的压力和自己的懒惰迫使我放弃喜欢的前端，改为容易找工作的JAVA开发，后来发现这并不是一件坏事。有些时候我真的相信命运，让我误打误撞到软件工程这个专业，不然我还真不知道我能做什么。骨子里透漏着自卑的程序员，只有不断的学习，不断的创作，才能找回自信！</p>
                    <p></p>
                    <p>
                        我很感谢我的父母，他们都是农民工，除了伟大，我找不出其他词来形容。感谢我的女友，感谢她对我无私的爱。总觉得自己有太多的事情要做，太多的事情想做，但是总是力不从心。
                    </p>

                    <div class="dividerHeading">
                        <h4><span>关于我的博客</span></h4>
                    </div>
                    <img class="left_img img-thumbnail" src="images/about_1.png" alt="about img">
                    <p>域  名：www.witcream.com 创建于2015年09月12日 <a href="/" class="blog_link" target="_blank">注册域名</a></p>
                    <p>服务器：阿里云服务器<a href="/" class="blog_link" target="_blank">购买空间</a></p>
                    <p>备案号：粤ICP备16081729号-1</p>
                    <p>程  序：自己编写后台，JAVA实现</p>
                </div>


                <!--Sidebar Widget-->
                <div class="col-sm-3 col-md-3 col-lg-3">
                    <div class="sidebar">
                        <div class="pdt-50"></div>
                        <div class="widget widget_about_us">
                            <p>网名：<span>Joey</span> | Walk on Joey</p>
                            <p>姓名：杨巍 </p>
                            <p>生日：1989-05-01</p>
                            <p>籍贯：湖北省―广水市</p>
                            <p>现暂居：深圳市―龙岗区</p>
                            <p>职业：JAVA程序猿</p>
                            <p>喜欢的音乐：《故乡》《大海》</p>
                            <p>喜欢玩的游戏：LOL</p>
                            <p>我的其他网站：www.dluan.com</p>
                            <a target="_blank" href="http://wp.qq.com/wpa/qunwpa?idkey=d4d4a26952d46d564ee5bf7782743a70d5a8c405f4f9a33a60b0eec380743c64">
                                <img src="http://pub.idqqimg.com/wpa/images/group.png" alt="杨巍个人博客网站" title="杨巍个人博客网站"></a>
                            <a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&amp;email=HHh9cn95b3F1cHVye1xtbTJ-c3E" ><img src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_22.png" alt="杨巍个人博客网站"></a>
                        </div>

                        <div class="widget widget_weather">
                            <div class="weather"><iframe width="250" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe></div>
                        </div><!-- sidebar -->

                        <div class="widget widget_wechat">
                            <div class="sidebar-heading">
                                微信二维码
                            </div>
                            <img class="img-responsive" src="images/qrcode_for_witcream.jpg" alt="blog-image01"/>
                        </div><!-- blog-sidebar -->
                    </div>
                </div>
            </div>
            <!--/.row-->
                <div class="row">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>免费模板</span></h4>
                        </div>
                        <div id="recent-work-slider" class="owl-carousel">
                            <!-- <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_1.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>个人博客模板</h5>
                                            <a href="images/portfolio/full/portfolio_1.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_2.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>企业网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_2.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_3.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>个人网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_4.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>企业网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_4.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_5.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>企业网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_5.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_6.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>个人网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_6.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>

                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_7.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>个人网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_7.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>

                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_8.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>个人网站模板</h5>
                                            <a href="images/portfolio/full/portfolio_8.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div> -->
                        </div>
                    </div>
                </div>
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

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->

	<script>
		$(function(){
			/*选中关于我*/
			$("ul.navbar-nav").find("li").removeClass("active");
	    	$("#about-pg").addClass("active");
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