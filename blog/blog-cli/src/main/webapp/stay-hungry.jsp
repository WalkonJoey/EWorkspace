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
                            <p>从明天起，做一个幸福的人;
喂马、劈柴，周游世界;
从明天起，关心粮食和蔬菜;
我有一所房子，面朝大海，春暖花开。</p>
                        </div>
                        <nav id="breadcrumbs">
                            <ul>
                                <li><a href="index.jsp">首页</a>/</li>
                                <li>随笔</li>
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
                <div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
                    <div class="blog_medium" id="blog-list">

                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <ul class="pagination pull-left mrgt-0" id = "pagination">
                            <!-- <li><a href="">&laquo;</a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href="">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li> -->
                        </ul>
                    </div>

                </div>

                <div class="col-sm-3 col-md-3 col-lg-3">
                    <jsp:include page="side-bar.jsp" flush="true" />
                </div>
            </div>
            <!--/.row-->
                <div class="row">
                    <div class="col-md-12">
                        <div class="dividerHeading">
                            <h4><span>免费模板</span></h4>
                        </div>
                        <div id="recent-work-slider" class="owl-carousel">
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

	<script type="text/javascript">
		$(function(){
			/*选中随笔*/
			$("ul.navbar-nav").find("li").removeClass("active");
	    	$("#stay-hungry-pg").addClass("active");
			$.ajax({/* 加载日志页*/
				type : "post",
				url : "blog/getBlogsList.do",
				data : {
					/* productID : "${productID}",skuNo:"${skuNo}" */
				},
				success : function(data) {
		
					if (data.success) {
						var blogList = data.obj.rows;
						var total = data.obj.total;//总数
						var pageTotal = parseInt(total/10)+1;//总页数
						var currentPage = 1;//当前所在页
						$("#pagination").empty();
						var pageContent = "<li data-index=\"prev\"><a href=\"javascript:void(0);\">&laquo;</a></li>"
						for(var a=1;a<=pageTotal;a++){
							if(a==1){
								pageContent += "<li data-index=\""+a+"\" class=\"active\"><a href=\"javascript:void(0);\">"+a+"</a></li>"
							}else{
								pageContent += "<li data-index=\""+a+"\"><a href=\"javascript:void(0);\">"+a+"</a></li>"
							}
						}
						pageContent += "<li data-index=\"next\"><a href=\"javascript:void(0);\">&raquo;</a></li>"
						$("#pagination").html(pageContent);
						$("#pagination").on("click","li",function(){
							var curActive = $("#pagination").children(".active").first();
							var curIndex = $(this).data("index"); //当前点击的按钮
							
							if(curIndex=="prev"){
								if(curActive.prev().data("index")!="prev"){//如果当前active的按钮是第一个按钮
									var currentPage = curActive.prev().data("index");
									curActive.prev().addClass("active").siblings().removeClass("active");
									getBlogData(currentPage);
								}
							}else if(curIndex == "next"){
								if(curActive.next().data("index")!="next"){//如果当前active的按钮是第一个按钮
									var currentPage = curActive.next().data("index");
									curActive.next().addClass("active").siblings().removeClass("active");
									getBlogData(currentPage);
								}
							}else{
								var currentPage = $(this).data("index");
								$(this).addClass("active").siblings().removeClass("active");
								getBlogData(currentPage);
							}
						});
						
						var $blogList = $("#blog-list");
		            	$blogList.empty();//清空节点
		            	var content = "";
						for(var j = 0;j<blogList.length;j++){
							var blog = blogList[j];
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
		function getBlogData(currentPage){
			$.ajax({/* 加载日志页*/
				type : "post",
				url : "blog/getBlogsList.do",
				data : {
					/* productID : "${productID}",skuNo:"${skuNo}" */
					page:currentPage
				},
				success : function(data) {
					if (data.success) {
						var blogList = data.obj.rows;
						var $blogList = $("#blog-list");
		            	$blogList.empty();//清空节点
		            	var content = "";
						for(var j = 0;j<blogList.length;j++){
							var blog = blogList[j];
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
		}
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