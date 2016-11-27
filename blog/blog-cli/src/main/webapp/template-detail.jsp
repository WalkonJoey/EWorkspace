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
                                <li>关于我</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!--blog-->
        <section class="content portfolio_single">
            <div class="container">
                <div class="row sub_content">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <!--Project Details Page-->
                        <div class="porDetCarousel">
                            <div class="carousel-content">
                                <img class="carousel-item" src="images/portfolio/portfolio_slider1.png" alt="">
                                <img class="carousel-item" src="images/portfolio/portfolio_slider2.png" alt="">
                                <img class="carousel-item" src="images/portfolio/portfolio_slider3.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row sub_content">
                    <div class="col-lg-8 col-md-8 col-sm-8">
                        <div class="project_description">
                            <div class="widget_title">
                                <h4><span>Project Descriptions</span></h4>
                            </div>

                            <p>Lorem ipsum dolor sit amet, consectetur adip, sed do eiusmod tempor incididunt ut aut reiciendise voluptat maiores alias aut et perferendis doloribus asperiores ut labore. Donec earum rerum hic tenetur ans sapiente delectus, ut aut reiciendise voluptat maiores alias consequaturs aut perferendis doloribus asperiores.</p>
                            <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="project_details">
                            <div class="widget_title">
                                <h4><span>Project Details</span></h4>
                            </div>
                            <ul class="details">
                                <li><span>Client :</span>Louis</li>
                                <li><span>Company :</span> Rain Technologies inc.</li>
                                <li><span>Category :</span> Web Design, Photography</li>
                                <li><span>Date :</span> 05 September 2015</li>
                                <li><span>Project URL :</span> <a href="#">www.bestjquery.com</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row sub_content">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>Recent Work</span></h4>
                        </div>
                        <div id="recent-work-slider" class="owl-carousel">
                            <div class="recent-item box">
                                <figure class="touching ">
                                    <img src="images/portfolio/portfolio_1.png" alt=""/>
                                    <div class="option inner">
                                        <div>
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
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
                                            <h5>Touch and Swipe</h5>
                                            <a href="images/portfolio/full/portfolio_8.png" class="fa fa-search mfp-image"></a>
                                            <a href="portfolio_single.html" class="fa fa-link"></a>
                                            <span>Mobile</span>
                                        </div>
                                    </div>
                                </figure>
                            </div>
                        </div>
                    </div>
                </div>
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
    <script type="text/javascript" src="js/jquery.smartmenus.min.js"></script>
    <script type="text/javascript" src="js/jquery.smartmenus.bootstrap.min.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/jflickrfeed.js"></script>
    <script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="js/jquery.isotope.min.js"></script>
    <script type="text/javascript" src="js/swipe.js"></script>
    <script type="text/javascript" src="js/jquery-scrolltofixed-min.js"></script>
    <script type="text/javascript" src="js/jquery-hoverdirection.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function() {
            $.fn.carousel = function(op) {
                var op, ui = {};
                op = $.extend({
                    speed: 500,
                    autoChange: false,
                    interval: 5000
                }, op);
                ui.carousel = this;
                ui.items    = ui.carousel.find('.carousel-item');
                ui.itemsLen = ui.items.length;

                // CREATE CONTROLS
                ui.ctrl 	= $('<div />', {'class': 'carousel-control'});
                ui.prev 	= $('<div />', {'class': 'carousel-prev'});
                ui.next 	= $('<div />', {'class': 'carousel-next'});
                ui.pagList  = $('<ul />', {'class': 'carousel-pagination'});
                ui.pagItem  = $('<li></li>');
                for (var i = 0; i < ui.itemsLen; i++) {
                    ui.pagItem.clone().appendTo(ui.pagList);
                }
                ui.prev.appendTo(ui.ctrl);
                ui.next.appendTo(ui.ctrl);
                ui.pagList.appendTo(ui.ctrl);
                ui.ctrl.appendTo(ui.carousel);
                ui.carousel.find('.carousel-pagination li').eq(0).addClass('active');
                ui.carousel.find('.carousel-item').each(function() {
                    $(this).hide();
                });
                ui.carousel.find('.carousel-item').eq(0).show().addClass('active');


                // CHANGE ITEM
                var changeImage = function(direction, context) {
                    var current = ui.carousel.find('.carousel-item.active');

                    if (direction == 'index') {
                        if(current.index() === context.index())
                            return false;

                        context.addClass('active').siblings().removeClass('active');

                        ui.items.eq(context.index()).addClass('current').fadeIn(op.speed, function() {
                            current.removeClass('active').hide();
                            $(this).addClass('active').removeClass('current');
                        });
                    }

                    if (direction == 'prev') {
                        if (current.index() == 0) {
                            ui.carousel.find('.carousel-item:last').addClass('current').fadeIn(op.speed, function() {
                                current.removeClass('active').hide();
                                $(this).addClass('active').removeClass('current');
                            });
                        }
                        else {
                            current.prev().addClass('current').fadeIn(op.speed, function() {
                                current.removeClass('active').hide();
                                $(this).addClass('active').removeClass('current');
                            });
                        }
                    }

                    if (direction == undefined) {
                        if (current.index() == ui.itemsLen - 1) {
                            ui.carousel.find('.carousel-item:first').addClass('current').fadeIn(300, function() {
                                current.removeClass('active').hide();
                                $(this).addClass('active').removeClass('current');
                            });
                        }
                        else {
                            current.next().addClass('current').fadeIn(300, function() {
                                current.removeClass('active').hide();
                                $(this).addClass('active').removeClass('current');
                            });
                        }
                    }
                    ui.carousel.find('.carousel-pagination li').eq( ui.carousel.find('.carousel-item.current').index() ).addClass('active').siblings().removeClass('active');
                };

                ui.carousel
                        .on('click', 'li', function() {
                            changeImage('index', $(this));
                        })
                        .on('click', '.carousel-prev', function() {
                            changeImage('prev');
                        })
                        .on('click', '.carousel-next', function() {
                            changeImage();
                        });

                // AUTO CHANGE
                if (op.autoChange) {
                    var changeInterval = setInterval(changeImage, op.interval);
                    ui.carousel
                            .on('mouseenter', function() {
                                clearInterval(changeInterval);
                            })
                            .on('mouseleave', function() {
                                changeInterval = setInterval(changeImage, op.interval);
                            });
                }
                return this;
            };

            $('.porDetCarousel').each(function() {
                $(this).carousel({
                    autoChange: true
                });
            });
        });
    </script>
    <script src="js/main.js"></script>

    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>