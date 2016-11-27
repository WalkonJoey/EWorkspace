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

    <link rel="stylesheet" type="text/css" href="css/switcher.css" media="screen" />
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
                                <li><a href="index.html">首页</a>/</li>
                                <li>模板分享 /</li>
                                <li>企业网站模板</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!--blog-->
        <section class="content portfolio_single">
            <div class="container">
            <section class="section3">
                <div class="dividerHeading text-center">
                    <h4><span>RECENT PORTFOLIO ITEMS</span></h4>
                </div>

                <nav class="clearfix">
                    <ul id="filter">
                        <li data-filter="*" class="selected"><a href="#">All Works</a></li>
                        <li data-filter=".mockups"><a href="#">Mockups</a></li>
                        <li data-filter=".graphic-design"><a href="#">Graphics</a></li>
                        <li data-filter=".web-design"><a href="#">Web Projects</a></li>
                        <li data-filter=".flayers"><a href="#">Flayers</a></li>
                    </ul>
                </nav>

                <div class="portfolio-centered">
                    <div class="recentitems portfolio">

                        <div class="portfolio-item mockups">
                            <div class="box">
                                <img src="images/portfolio/portfolio_1.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>A Graphic Design Item</h5>
                                        <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item web-design graphic-design">
                            <div class="box">
                                <img src="images/portfolio/portfolio_2.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>New Flayer Design Item</h5>
                                        <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item graphic-design">
                            <div class="box">
                                <img src="images/portfolio/portfolio_3.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Gray and Pink</h5>
                                        <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item mockups">
                            <div class="box">
                                <img src="images/portfolio/portfolio_4.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Amazing Keyboard Desin</h5>
                                        <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item flayers">
                            <div class="box">
                                <img src="images/portfolio/portfolio_5.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Our Favorite Colors</h5>
                                        <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item flayers">
                            <div class="box">
                                <img src="images/portfolio/portfolio_6.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Not War Make Design</h5>
                                        <a href="images/portfolio/full/portfolio_3.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item graphic-design mockups">
                            <div class="box">
                                <img src="images/portfolio/portfolio_7.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>A GREAT MOCK-UPS</h5>
                                        <a href="images/portfolio/full/portfolio_5.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item web-design mockups">
                            <div class="box">
                                <img src="images/portfolio/portfolio_8.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Missis Of 2014</h5>
                                        <a href="images/portfolio/full/portfolio_4.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item web-design mockups">
                            <div class="box">
                                <img src="images/portfolio/portfolio_9.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Light Carpet</h5>
                                        <a href="images/portfolio/full/portfolio_1.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                        <div class="portfolio-item web-design mockups">
                            <div class="box">
                                <img src="images/portfolio/portfolio_10.png" alt="">
                                <div class="option inner">
                                    <div>
                                        <h5>Business Card Mock-Up</h5>
                                        <a href="images/portfolio/full/portfolio_8.png" class="fa fa-search mfp-image"></a>
                                        <a href="portfolio_single.html" class="fa fa-link"></a>
                                    </div>
                                </div>
                            </div><!-- box -->
                        </div>

                    </div><!-- portfolio -->
                </div><!-- portfolio container -->
            </section>


            <section class="feature_bottom">
                <div class="container">
                    <div class="row sub_content">
                        <div class="col-lg-8 col-md-8 col-sm-8 wow fadeInLeft">
                            <div class="dividerHeading">
                                <h4><span>Why Choose Us?</span></h4>
                            </div>
                            <div class="row">
                                <div class="col-lg-6  rec_blog">
                                    <div class="blogPic">
                                        <div class="news-thumb">
                                            <div class="swipe" id="slider" style="visibility: visible;">
                                                <ul class="swipe-wrap" style="width: 904px;">
                                                    <li><img alt="" src="images/blog/blog_1.png"></li>
                                                    <li><img alt="" src="images/blog/blog_2.png"></li>
                                                    <li><img alt="" src="images/blog/blog_3.png"></li>
                                                    <li><img alt="" src="images/blog/blog_4.png"></li>
                                                </ul>
                                                <div class="swipe-navi">
                                                    <div onclick="mySwipe.prev()" class="swipe-left"><i class="fa fa-chevron-left"></i></div>
                                                    <div onclick="mySwipe.next()" class="swipe-right"><i class="fa fa-chevron-right"></i></div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="blogDetail">
                                        <div class="blogTitle">
                                            <a href="#">
                                                <h2>This title in post blogs</h2>
                                            </a>
                                        <span>
                                            <i class="fa fa-calendar"></i>
                                            30 June, 20:43 PM
                                        </span>
                                        </div>
                                        <div class="blogContent">
                                            <p>Etu eros omnes theophratus mei, cumit usulan dicit omnium eripuit. Qui tever iluma facete gubergren. </p>
                                        </div>
                                        <div class="blogMeta">
                                            <a href="#">
                                                <i class="fa fa-user"></i>
                                                Here Author Name
                                            </a>
                                            <a href="#">
                                                <i class="fa fa-comment"></i>
                                                1980
                                            </a>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-6  rec_blog">
                                    <div class="blogPic">
                                        <img alt="" src="images/blog/blog_6.png">
                                        <div class="blog-hover">
                                            <a href="#">
                                            <span class="icon">
                                                <i class="fa fa-link"></i>
                                            </span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="blogDetail">
                                        <div class="blogTitle">
                                            <a href="#">
                                                <h2>This title in post blogs</h2>
                                            </a>
                                        <span>
                                            <i class="fa fa-calendar"></i>
                                            30 June, 20:43 PM
                                        </span>
                                        </div>
                                        <div class="blogContent">
                                            <p>Etu eros omnes theophratus mei, cumit usulan dicit omnium eripuit. Qui tever iluma facete gubergren. </p>
                                        </div>
                                        <div class="blogMeta">
                                            <a href="#">
                                                <i class="fa fa-user"></i>
                                                Here Author Name
                                            </a>
                                            <a href="#">
                                                <i class="fa fa-comment"></i>
                                                1980
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- TESTIMONIALS -->
                        <div class="col-lg-4 col-md-4 col-sm-4 wow fadeInRight">
                            <div class="dividerHeading">
                                <h4><span>What Client's Say</span></h4>
                            </div>
                            <div id="testimonial-carousel" class="testimonial carousel slide">
                                <div class="carousel-inner">
                                    <div class="active item">
                                        <div class="testimonial-item">
                                            <div class="icon"><i class="fa fa-quote-right"></i></div>
                                            <blockquote>
                                                <p>Donec convallis, metus nec tempus aliquet, nunc metus adipiscing leo, a lobortis nisi dui ut odio. Nullam ultrices, eros accumsan vulputate faucibus, turpis tortor dictum phasellus ac libero. </p>
                                            </blockquote>
                                            <div class="icon-tr"></div>
                                            <div class="testimonial-review">
                                                <img src="images/testimonials/1.png" alt="testimoni">
                                                <h1>Jonathan Dower,<small>Company Inc.</small></h1>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <div class="testimonial-item">
                                            <div class="icon"><i class="fa fa-quote-right"></i></div>
                                            <blockquote>
                                                <p>Metus aliquet tincidunt metus, sit amet mattis lectus sodales ac. Suspendisse rhoncus dictum eros, ut egestas eros luctus eget. Nam nibh sem, mattis et feugiat ut, porttitor nec risus.</p>
                                            </blockquote>
                                            <div class="icon-tr"></div>
                                            <div class="testimonial-review">
                                                <img src="images/testimonials/2.png" alt="testimoni">
                                                <h1>Jonathan Dower<small>Leopard</small></h1>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <div class="testimonial-item">
                                            <div class="icon"><i class="fa fa-quote-right"></i></div>
                                            <blockquote>
                                                <p>Donec convallis, metus nec tempus aliquet, nunc metus adipiscing leo, a lobortis nisi dui ut odio. Nullam ultrices, eros accumsan vulputate faucibus, turpis tortor dictum. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commo, magnase quis lacinia ornare, quam ante aliqua nisi, eu iaculis. </p>
                                            </blockquote>
                                            <div class="icon-tr"></div>
                                            <div class="testimonial-review">
                                                <img src="images/testimonials/3.png" alt="testimoni">
                                                <h1>Jonathan Dower<small>Leopard</small></h1>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="testimonial-buttons"><a href="#testimonial-carousel" data-slide="prev"><i class="fa fa-chevron-left"></i></a>&#32;
                                    <a href="#testimonial-carousel" data-slide="next"><i class="fa fa-chevron-right"></i></a></div>
                            </div>
                        </div><!-- TESTIMONIALS END -->
                    </div>
                </div>
            </section>
            </div>
        </section>

    </section>

    <jsp:include page="footer.jsp" flush="true" />
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/retina-1.1.0.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script> <!-- jQuery cookie -->
    <script type="text/javascript" src="js/styleswitch.js"></script> <!-- Style Colors Switcher -->
    <script src="js/jquery.fractionslider.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/jflickrfeed.js"></script>
    <script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="js/swipe.js"></script>
    <script type="text/javascript" src="js/jquery-hoverdirection.min.js"></script>
    <script type="text/javascript" src="js/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="js/jquery-scrolltofixed-min.js"></script>

    <script src="js/main.js"></script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->

    <!-- Portfolio -->
    <script>

        (function($) {
            "use strict";
            var $container = $('.portfolio'),
                    $items = $container.find('.portfolio-item'),
                    portfolioLayout = 'fitRows';

            if( $container.hasClass('portfolio-centered') ) {
                portfolioLayout = 'masonry';
            }

            $container.isotope({
                filter: '*',
                animationEngine: 'best-available',
                layoutMode: portfolioLayout,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                },
                masonry: {
                }
            }, refreshWaypoints());

            function refreshWaypoints() {
                setTimeout(function() {
                }, 1000);
            }

            $('ul#filter li').on('click', function() {
                var selector = $(this).attr('data-filter');
                $container.isotope({ filter: selector }, refreshWaypoints());
                $('ul#filter li').removeClass('selected');
                $(this).addClass('selected');
                return false;
            });

            function getColumnNumber() {
                var winWidth = $(window).width(),
                        columnNumber = 1;

                if (winWidth > 1200) {
                    columnNumber = 5;
                } else if (winWidth > 950) {
                    columnNumber = 4;
                } else if (winWidth > 600) {
                    columnNumber = 3;
                } else if (winWidth > 400) {
                    columnNumber = 2;
                } else if (winWidth > 250) {
                    columnNumber = 1;
                }
                return columnNumber;
            }

            function setColumns() {
                var winWidth = $(window).width(),
                        columnNumber = getColumnNumber(),
                        itemWidth = Math.floor(winWidth / columnNumber);

                $container.find('.portfolio-item').each(function() {
                    $(this).css( {
                        width : itemWidth + 'px'
                    });
                });
            }

            function setPortfolio() {
                setColumns();
                $container.isotope('reLayout');
            }

            $container.imagesLoaded(function () {

                setPortfolio();
            });

            $(window).on('resize', function () {
                setPortfolio();
            });
        })(jQuery);
    </script>

    <!-- WARNING: Wow.js doesn't work in IE 9 or less -->
    <!--[if gte IE 9 | !IE ]><!-->
    <script type="text/javascript" src="js/wow.min.js"></script>
    <script>
		/*选中留言板*/
		$("ul.navbar-nav").find("li").removeClass("active");
		$("#enterprise-template-pg").addClass("active");
	</script>
    <script>
        // WOW Animation
        new WOW().init();
    </script>
    <![endif]-->
</body>
</html>