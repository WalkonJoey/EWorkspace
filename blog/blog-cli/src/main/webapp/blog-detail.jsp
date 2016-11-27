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
            <div class="row">
            <div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
                <div class="blog_single">
                    <article class="post">
                        <figure class="post_img">
                            <a href="#">
                                <img src="images/blog/blog_1.png" alt="blog post">
                            </a>
                        </figure>
                        <div class="post_date">
                            <span class="day">28</span>
                            <span class="month">Nov</span>
                        </div>
                        <div class="post_content">
                            <div class="post_meta">
                                <h2>
                                    <a href="#">perferendis doloribus asperiores ut labore</a>
                                </h2>
                                <div class="metaInfo">
                                    <span><i class="fa fa-calendar"></i> <a href="#">Nov 28, 2015</a> </span>
                                    <span><i class="fa fa-user"></i> By <a href="#">Louis</a> </span>
                                    <span><i class="fa fa-tag"></i> <a href="#">Emin</a>, <a href="#">News</a> </span>
                                    <span><i class="fa fa-comments"></i> <a href="#">12 Comments</a></span>
                                </div>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adip, sed do eiusmod tempor incididunt  ut aut reiciendise voluptat maiores alias consequaturs aut perferendis doloribus asperiores ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>

                            <blockquote class="default">
                                Nulla nunc dui, tristique in semper vel, congue sed ligula. Nam dolor ligula, faucibus id sodales in, auctor fringilla libero. Pellentesque pellentesque eget tempor tellus. Fusce lacinia tempor malesuada. Ut lacus sapien, placerat a ornare nec, elementum sit amet felis. Maecenas pretium lorem hendrerit eros sagittis fermentum.
                            </blockquote>

                            <p>Morbi augue velit, tempus mattis dignissim nec, porta sed risus. Donec eget magna eu lorem tristique pellentesque eget eu dui. Fusce lacinia tempor malesuada. Ut lacus sapien, placerat a ornare nec, elementum sit amet felis. Maecenas pretium hendrerit fermentum. Fusce lacinia tempor malesuada. Ut lacus sapien, placerat a ornare nec, elementum sit amet felis. Maecenas pretium lorem hendrerit eros sagittis fermentum.</p>

                            <p>Donec in ut odio libero, at vulputate urna. Nulla tristique mi a massa convallis cursus. Nulla eu mi magna. Etiam suscipit commodo gravida. Cras suscipit, quam vitae adipiscing faucibus, risus nibh laoreet odio, a porttitor metus eros ut enim. Morbi augue velit, tempus mattis dignissim nec, porta sed risus. Donec eget magna eu lorem tristique pellentesque eget eu duiport titor metus eros ut enim. </p>
                        </div>
                        <ul class="shares">
                            <li class="shareslabel"><h3>Share This Story</h3></li>
                            <li><a class="twitter" href="#" data-placement="bottom" data-toggle="tooltip" title="Twitter"></a></li>
                            <li><a class="facebook" href="#" data-placement="bottom" data-toggle="tooltip" title="Facebook"></a></li>
                            <li><a class="gplus" href="#" data-placement="bottom" data-toggle="tooltip" title="Google Plus"></a></li>
                            <li><a class="pinterest" href="#" data-placement="bottom" data-toggle="tooltip" title="Pinterest"></a></li>
                            <li><a class="yahoo" href="#" data-placement="bottom" data-toggle="tooltip" title="Yahoo"></a></li>
                            <li><a class="linkedin" href="#" data-placement="bottom" data-toggle="tooltip" title="LinkedIn"></a></li>
                        </ul>
                    </article>
                    <div class="about_author">
                        <div class="author_desc">
                            <img src="images/blog/author.png" alt="about author">
                            <ul class="author_social">
                                <li><a class="fb" href="#." data-placement="top" data-toggle="tooltip" title="Facbook"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="twtr" href="#." data-placement="top" data-toggle="tooltip" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                                <li><a class="skype" href="#." data-placement="top" data-toggle="tooltip" title="Skype"><i class="fa fa-skype"></i></a></li>
                            </ul>
                        </div>
                        <div class="author_bio">
                            <h3 class="author_name"><a href="#">Tom Jobs</a></h3>
                            <h5>CEO at <a href="#">jQuery Rain</a></h5>
                            <p class="author_det">
                                Lorem ipsum dolor sit amet, consectetur adip, sed do eiusmod tempor incididunt  ut aut reiciendise voluptat maiores alias consequaturs aut perferendis doloribus omnis saperet docendi nec, eos ea alii molestiae aliquand.
                            </p>
                        </div>
                    </div>
                </div>

                <!--News Comments-->
                <div class="news_comments">
                    <div class="dividerHeading">
                        <h4><span>Comments (6)</span></h4>
                    </div>
                    <div id="comment">
                        <ul id="comment-list">
                            <li class="comment">
                                <div class="avatar"><img alt="" src="images/blog/avatar_1.png" class="avatar"></div>
                                <div class="comment-container">
                                    <h4 class="comment-author"><a href="#">John Smith</a></span></h4>
                                    <div class="comment-meta"><a href="#" class="comment-date link-style1">February 22, 2015</a><a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a></div>
                                    <div class="comment-body">
                                        <p>Ne omnis saperet docendi nec, eos ea alii molestiae aliquand. Latine fuisset mele, mandamus atrioque eu mea, wi forensib argumentum vim an. Te viderer conceptam sed, mea et delenit fabellas probat.</p>
                                    </div>
                                </div>
                            </li>
                            <li class="comment">
                                <div class="avatar"><img alt="" src="images/blog/avatar_2.png" class="avatar"></div>
                                <div class="comment-container">
                                    <h4 class="comment-author"><a href="#">Eva Smith</a></span></h4>
                                    <div class="comment-meta"><a href="#" class="comment-date link-style1">February 13, 2015</a><a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a></div>
                                    <div class="comment-body">
                                        <p>Vidit nulla errem ea mea. Dolore apeirian insolens mea ut, indoctum consequuntur hasi. No aeque dictas dissenti as tusu, sumo quodsi fuisset mea in. Ea nobis populo interesset cum, ne sit quis elit officiis, min im tempor iracundia sit anet. Facer falli aliquam nec te. In eirmod utamur offendit vis, posidonium instructior sed te.</p>
                                    </div>
                                </div>
                                <ul class="children">
                                    <li class="comment">
                                        <div class="avatar"><img alt="" src="images/blog/avatar_3.png" class="avatar"></div>
                                        <div class="comment-container">
                                            <h4 class="comment-author"><a href="#">Thomas Smith</a></span></h4>
                                            <div class="comment-meta"><a href="#" class="comment-date link-style1">February 14, 2015</a><a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a></div>
                                            <div class="comment-body">
                                                <p>Labores pertinax theophrastus vim an. Error ditas in sea, per no omnis iisque nonumes. Est an dicam option, ad quis iriure saperet nec, ignota causae inciderint ex vix. Iisque qualisque imp duo eu, pro reque consequ untur. No vero laudem legere pri, error denique vis ne, duo iusto bonorum.</p>
                                            </div>
                                        </div>
                                        <ul class="children">
                                            <li class="comment">
                                                <div class="avatar"><img alt="" src="images/blog/avatar_2.png" class="avatar"></div>
                                                <div class="comment-container">
                                                    <h4 class="comment-author"><a href="#">Eva Smith</a></span></h4>
                                                    <div class="comment-meta"><a href="#" class="comment-date link-style1">February 14, 2015</a><a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a></div>
                                                    <div class="comment-body">
                                                        <p>Dico animal vis cu, sed no aliquam appellantur, et exerci eleifend eos. Vixese eros tiloi novum adtam, mazim inimicus maiestatis ad vim. Ex his unum fuisset reformidans, has iriure ornatus atomorum ut, ad tation feugiat impedit per.</p>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="comment">
                                <div class="avatar"><img alt="" src="images/blog/avatar_1.png" class="avatar"></div>
                                <div class="comment-container">
                                    <h4 class="comment-author"><a href="#">John Smith</a></span></h4>
                                    <div class="comment-meta"><a href="#" class="comment-date link-style1">February 07, 2015</a><a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a></div>
                                    <div class="comment-body">
                                        <p>Eu mea harum soleat albucius. At duo nihil saperet inimicus. Ne quo dicit offendit eloquenam. Ut intellegam inn theophras tus mea. Vide ceteros mediocritatem est in, utamur gubergren contentiones.</p>
                                    </div>
                                </div>
                            </li>
                            <li class="comment">
                                <div class="avatar"><img alt="" src="images/blog/avatar_3.png" class="avatar"></div>
                                <div class="comment-container">
                                    <h4 class="comment-author"><a href="#">Thomas Smith</a></span></h4>
                                    <div class="comment-meta"><a href="#" class="comment-date link-style1">February 02, 2015</a><a class="comment-reply-link link-style3" href="#respond">Reply &raquo;</a></div>
                                    <div class="comment-body">
                                        <p>Quodsi eirmod salutandi usu ei, ei mazim facete mel. Deleniti interesset at sed, sea ei malis expetenda. Ei efficiat integebat mel, vis alii insoles te. Vis ex bonorum contentiones. An cum possit reformidans. Est at eripuit theophrastus. Scripta imper diet ad nec, everti contentiones id eam, an eum causae officiis.</p>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!-- /#comments -->
                    <div class="dividerHeading">
                        <h4><span>Leave a comment</span></h4>
                    </div>

                    <div class="comment_form">
                        <div class="row">
                            <div class="col-sm-4">
                                <input class="col-lg-4 col-md-4 form-control" name="name" type="text" id="name" size="30"  onfocus="if(this.value == 'Name') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'Name'; }" value="Name" placeholder="Name" >
                            </div>
                            <div class="col-sm-4">
                                <input class="col-lg-4 col-md-4 form-control" name="email" type="text" id="email" size="30" onfocus="if(this.value == 'E-mail') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'E-mail'; }" value="E-mail" placeholder="E-mail">
                            </div>
                            <div class="col-sm-4">
                                <input class="col-lg-4 col-md-4 form-control" name="url" type="text" id="url" size="30" onfocus="if(this.value == 'Url') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'Url'; }" value="Url" placeholder="Url">
                            </div>
                        </div>
                    </div>
                    <div class="comment-box row">
                        <div class="col-sm-12">
                            <p>
                                <textarea name="comments" class="form-control" rows="6" cols="40" id="comments" onfocus="if(this.value == 'Message') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'Message'; }" placeholder="Message">Message</textarea>
                            </p>
                        </div>
                    </div>

                    <a class="btn btn-lg btn-default" href="#">Post Comment</a>
                </div>
            </div>

            <!--Sidebar Widget-->
            <div class="col-sm-3 col-md-3 col-lg-3">
            	<jsp:include page="side-bar.jsp" flush="true" />
            </div>
            </div><!--/.row-->
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