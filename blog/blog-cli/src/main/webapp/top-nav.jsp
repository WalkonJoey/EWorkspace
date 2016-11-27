<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="header">
        <div id="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 top-info hidden-xs">
                        <span><i class="fa fa-phone"></i>QQ群: 179135494</span>
                        <span><i class="fa fa-envelope"></i>Email: 826307574@qq.com</span>
                    </div>
                    <div class="col-sm-4 top-info">
                        <div class="social-share" data-sites="weibo,qq,tencent,douban,qzone,linkedin"></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="logo-bar">
            <div class="container">
                <div class="row">
                    <!-- Logo / Mobile Menu -->
                    <div  class="col-lg-3 col-sm-3 ">
                        <div id="logo">
                            <h1><a href="index.jsp"><img alt="logo" src="images/logo.png"/></a></h1>
                        </div>
                    </div>
                    <!-- Navigation
    ================================================== -->
                    <div class="col-lg-9 col-sm-9">
                        <div class="navbar navbar-default navbar-static-top" role="navigation">
                            <!--  <div class="container">-->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">切换导航</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li class="active" id="index-pg"><a href="index.jsp">首页</a></li>
                                    <li  id="about-pg"> <a href="about.jsp">关于我</a></li>
                                    <li  id="stay-foolish-pg"> <a href="stay-foolish.jsp">随笔</a></li>
                                    <li id="stay-hungry-pg"> <a href="stay-hungry.jsp" >学无止境</a></li>
                                    <li class="dropdown"> <a class="drop dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" href="#">模板分享</a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li id="self-template-pg"><a href="self-template.jsp">个人网站模板</a></li>
                                            <li id="enterprise-template-pg"><a href="enterprise-template.jsp" >企业网站模板</a></li>
                                        </ul>
                                    </li>
                                    <li  id="message-broad-pg"><a href="message-broad.jsp">留言板</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>