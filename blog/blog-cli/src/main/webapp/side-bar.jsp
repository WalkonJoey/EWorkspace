<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
                    <div class="widget widget_search">
                        <div class="site-search-area">
                            <form method="get" id="site-searchform" action="#">
                                <div>
                                    <input class="input-text" name="s" id="s" placeholder="Enter Search keywords..."
                                           type="text"/>
                                    <input id="searchsubmit" value="Search" type="submit"/>
                                </div>
                            </form>
                        </div>
                        <!-- end site search -->
                    </div>

                    <div class="widget widget_weather">
                        <div class="weather"><iframe width="250" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe></div>
                    </div><!-- sidebar -->
                    <div class="widget widget_categories">
                        <div class="widget_title">
                            <h4><span>分类</span></h4>
                        </div>
                        <ul class="arrows_list list_style" id="category-count">
                            <!-- <li><a href="#"> 所思所想 (10)</a></li>
                            <li><a href="#"> 碎言碎语 (25)</a></li>
                            <li><a href="#"> 模板介绍 (29)</a></li>
                            <li><a href="#"> 笔记分享 (19)</a></li>
                            <li><a href="#"> 转载(38)</a></li> -->
                        </ul>
                    </div>

                    <div class="widget widget_about">
                        <div class="widget_title">
                            <h4><span>公告</span></h4>
                        </div>
                        <p>欢迎各位网友浏览本博客，如果发现问题和意见，请添加QQ：826307574，感谢大家对本博客的支持.</p>
                    </div>

                    <div class="widget widget_tab">
                        <div class="velocity-tab sidebar-tab">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#Popular" data-toggle="tab">最受欢迎</a></li>
                                <li class=""><a href="#Recent" data-toggle="tab">最新</a></li>
                            </ul>

                            <div class="tab-content clearfix">
                                <div class="tab-pane fade active in" id="Popular">
                                    <ul class="recent_tab_list">
                                        <!-- <li>
                                            <span><a href="#"><img src="images/content/recent_1.png" alt=""/></a></span>
                                            <a href="#">IP突破2000啦</a>
                                            <i>October 09, 2015</i>
                                        </li>
                                        <li>
                                            <span><a href="#"><img src="images/content/recent_2.png" alt=""/></a></span>
                                            <a href="#">关于Elastic网站模板的介绍</a>
                                            <i>October 08, 2015</i>
                                        </li>
                                        <li class="last-tab">
                                            <span><a href="#"><img src="images/content/recent_3.png" alt=""/></a></span>
                                            <a href="#">本网站服务器更换了</a>
                                            <i>October 07, 2015</i>
                                        </li> -->
                                    </ul>
                                </div>
                                <div class="tab-pane fade" id="Recent">
                                    <ul class="recent_tab_list">
                                        <!-- <li>
                                            <span><a href="#"><img src="images/content/recent_1.png" alt=""/></a></span>
                                            <a href="#">IP突破2000啦</a>
                                            <i>October 09, 2015</i>
                                        </li>
                                        <li>
                                            <span><a href="#"><img src="images/content/recent_2.png" alt=""/></a></span>
                                            <a href="#">关于Elastic网站模板的介绍</a>
                                            <i>October 08, 2015</i>
                                        </li>
                                        <li class="last-tab">
                                            <span><a href="#"><img src="images/content/recent_3.png" alt=""/></a></span>
                                            <a href="#">本网站服务器更换了</a>
                                            <i>October 07, 2015</i>
                                        </li> -->
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="widget widget_tags">
                        <div class="widget_title">
                            <h4><span>标签</span></h4>
                        </div>

                        <ul class="tags" id="tag-count">
                            <!-- <li><a href="#"><b>励志</b></a></li>
                            <li><a href="#">生活</a></li>
                            <li><a href="#">私人博客</a></li>
                            <li><a href="#"><b>个人模板</b></a></li>
                            <li><a href="#">空间</a></li>
                            <li><a href="#"><b>网站建设</b></a></li>
                            <li><a href="#">网站模板</a></li>
                            <li><a href="#"><b>分享</b></a></li>
                            <li><a href="#">转载</a></li>
                            <li><a href="#">witcream</a></li>
                            <li><a href="#">dluan.com</a></li> -->
                        </ul>
                    </div>

                    <!-- <div class="widget widget_archives">
                        <div class="widget_title">
                            <h4><span>时间归类</span></h4>
                        </div>
                        <ul class="archives_list list_style">
                            <li><a href="#">2015年9月</a></li>
                            <li><a href="#">2015年8月</a></li>
                            <li><a href="#">2015年7月</a></li>
                            <li><a href="#">2015年6月</a></li>
                            <li><a href="#">2015年5月</a></li>
                            <li><a href="#">2015年4月</a></li>
                            <li><a href="#">2015年3月</a></li>
                        </ul>
                    </div> -->

                    <div class="widget widget_wechat">
                        <div class="sidebar-heading">
                            微信二维码
                        </div>
                        <img class="img-responsive" src="images/qrcode_for_witcream.jpg" alt="blog-image01"/>
                    </div><!-- blog-sidebar -->
                </div>