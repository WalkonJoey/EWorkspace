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

    <link rel="stylesheet" type="text/css" href="vendor/social-share/css/share.min.css" />
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
                            <p>如果你从来为她停留，那么你注定是她人生的匆匆过客</p>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.html">首页</a>/</li>
                                <li>留言板<input type="hidden" name="blogId" value='0' /></li>
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
                <!--News Comments-->
                <div class="news_comments">
                    <div class="dividerHeading">
                        <h4><span>评论 (6)</span></h4>
                    </div>
                    <div id="comment">
                        <ul id="comment-list">
                        </ul>
                    </div>
                    <!-- /#comments -->
                    <div class="dividerHeading">
                        <h4><span>说点什么吧</span></h4>
                    </div>
					<div id="form1">
	                    <div class="comment_form">
	                        <div class="row">
	                            <div class="col-sm-4">
	                                <input class="col-lg-4 col-md-4 form-control" name="creator" type="text" id="name" size="30"  onfocus="if(this.value == 'Name') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'Name'; }" value="Name" placeholder="Name" >
	                            </div>
	                            <div class="col-sm-4">
	                                <input class="col-lg-4 col-md-4 form-control" name="email" type="text" id="email" size="30" onfocus="if(this.value == 'E-mail') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'E-mail'; }" value="E-mail" placeholder="E-mail">
	                            </div>
	                            <!-- <div class="col-sm-4">
	                                <input class="col-lg-4 col-md-4 form-control" name="url" type="text" id="url" size="30" onfocus="if(this.value == 'Url') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'Url'; }" value="Url" placeholder="Url">
	                            </div> -->
	                        </div>
	                    </div>
	                    <div class="comment-box row">
	                        <div class="col-sm-12">
	                            <p>
	                                <textarea name="messageContent" class="form-control" rows="6" cols="40" id="comments" onfocus="if(this.value == 'Message') { this.value = ''; }" onblur="if(this.value == '') { this.value = 'Message'; }" placeholder="Message">Message</textarea>
	                            </p>
	                        </div>
	                    </div>
	
	                    <a class="btn btn-lg btn-default" href="javascript:void(0);" onclick = "submitForm()">Post Comment</a>
	                </div>
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
    <script type="text/javascript" src="vendor/social-share/js/social-share.min.js"></script>


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

	<script type="text/javascript">
	
		
		$(function(){
			/*选中留言板*/
			$("ul.navbar-nav").find("li").removeClass("active");
	    	$("#message-broad-pg").addClass("active");
			
			$.ajax({/* 加载标签*/
	            type : "post",
	            url : "message/getMessagesList.do",
	            data : {
	            	blogId:0
	            },
	   			success : function(data) {
	   				if (data.success) {
	   					var iList = data.obj.rows;
	   					console.log(iList);
	   					var $iList = $("#comment-list");
	                   	$iList.empty();//清空节点
	                   	var content = "";
	   					for(var j = 0;j<iList.length;j++){
	   						var item = iList[j];
   							var articleContent = "<li class=\"comment\"><div class=\"avatar\"><img alt=\"\" src=\""+item.headPortraitPath+"\" class=\"avatar\"></div>"
   	   						+"<div class=\"comment-container\"><h4 class=\"comment-author\"><a href=\"javascript:void(0);\">"+item.creator+"</a></span></h4>"
   							+"<div class=\"comment-meta\"><a href=\"javascript:void(0);\" class=\"comment-date link-style1\">"+item.createDt+"</a><a class=\"comment-reply-link link-style3\" href=\"javascript:void(0);\">回复 &raquo;</a></div>"
   							+"<div class=\"comment-body\"><p>"+item.messageContent+"</p></div></div>";
   							console.log(item.childMessage);
   							if(item.childMessage&&item.childMessage.length>0){
   								articleContent = addChild(articleContent,item.childMessage);
   							}
   							articleContent+="</li>";
   							content+=articleContent;
	   					}
	   					$iList.html(content);
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
		
		function addChild(articleContent,iList){
			console.log(articleContent);
			articleContent+="<ul class=\"children\">";
			for(var j = 0;j<iList.length;j++){
				var item = iList[j];
				articleContent += "<li class=\"comment\"><div class=\"avatar\"><img alt=\"\" src=\""+item.headPortraitPath+"\" class=\"avatar\"></div>"
						+"<div class=\"comment-container\"><h4 class=\"comment-author\"><a href=\"javascript:void(0);\">"+item.creator+"</a></span></h4>"
					+"<div class=\"comment-meta\"><a href=\"javascript:void(0);\" class=\"comment-date link-style1\">"+item.createDt+"</a><a class=\"comment-reply-link link-style3\" href=\"javascript:void(0);\">回复 &raquo;</a></div>"
					+"<div class=\"comment-body\"><p>"+item.messageContent+"</p></div></div>";
					if(item.childMessage&&item.childMessage.length>0){
						articleContent = addChild(articleContent,item.childMessage);
					}
			}
			articleContent +="</ul>";
			return articleContent;
		}
		
		function submitForm(parentMessageId){
			var blogId = $("input[name='blogId']").val();
			console.log(blogId);
			console.log($("#form1").find("input[name='creator']").val());
			console.log($("#form1").find("input[name='creator']")[0].value);
			console.log(blogId);
			console.log(blogId);
			$.ajax({/* 加载标签*/
	            type : "post",
	            url : "message/addMessage.do",
	            data : {
	            	blogId:blogId,
	            	parentMessageId:parentMessageId,
	            	creator:$("#form1").find("input[name='creator']").val(),
		            email:$("#form1").find("input[name='email']").val(),
		            messageContent:$("#form1").find("textarea[name='messageContent']").val()
	            },
	   			success : function(data) {
	   				if (data.success) {
	   					var iList = data.obj.rows;
	   					console.log(iList);
	   					var $iList = $("#comment-list");
	                   	$iList.empty();//清空节点
	                   	var content = "";
	   					for(var j = 0;j<iList.length;j++){
	   						var item = iList[j];
   							var articleContent = "<li class=\"comment\"><div class=\"avatar\"><img alt=\"\" src=\""+item.headPortraitPath+"\" class=\"avatar\"></div>"
   	   						+"<div class=\"comment-container\"><h4 class=\"comment-author\"><a href=\"javascript:void(0);\">"+item.creator+"</a></span></h4>"
   							+"<div class=\"comment-meta\"><a href=\"javascript:void(0);\" class=\"comment-date link-style1\">"+item.createDt+"</a><a class=\"comment-reply-link link-style3\" href=\"javascript:void(0);\">回复 &raquo;</a></div>"
   							+"<div class=\"comment-body\"><p>"+item.messageContent+"</p></div></div>";
   							console.log(item.childMessage);
   							if(item.childMessage&&item.childMessage.length>0){
   								articleContent = addChild(articleContent,item.childMessage);
   							}
   							articleContent+="</li>";
   							content+=articleContent;
	   					}
	   					$iList.html(content);
	   				}
	   			},
	   			dataType : "json"
	   		});
		}
	</script>
    <!-- Start Style Switcher -->
    <div class="switcher"></div>
    <!-- End Style Switcher -->
</body>
</html>