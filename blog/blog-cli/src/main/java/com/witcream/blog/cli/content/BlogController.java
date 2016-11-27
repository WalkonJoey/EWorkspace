package com.witcream.blog.cli.content;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.witcream.blog.api.bean.Blog;
import com.witcream.blog.api.service.IBlogService;
import com.witcream.core.PageInfo;
import com.witcream.core.R;

@Controller
@RequestMapping({ "/blog" })
public class BlogController {
	@Resource(name = "blogService")
	protected IBlogService blogService;
	private static final Logger logger = Logger.getLogger(BlogController.class);

	@RequestMapping(params = { "blogManagePage" })
	public String forward() {
		return "/index";
	}

	@RequestMapping({ "blogDetailPg" })
	public String blogDetailPgViaAddAttrPg(HttpServletRequest request, int blogId, String skuNo) {
		Blog blogVo = null;
		if ((skuNo != null) && (!"".equals(skuNo))) {
			request.setAttribute("skuNo", skuNo);
			blogVo = this.blogService.getBlogByBlogId(blogId);
			request.setAttribute("blogInfo", blogVo);
		} else if (blogId > 0) {
			request.setAttribute("blogId", Integer.valueOf(blogId));
			blogVo = this.blogService.getBlogByBlogId(blogId);
			request.setAttribute("blogInfo", blogVo);
		} else {
			logger.debug("无效的ID");
		}
		return "/blogMgr/blogDetail";
	}

	@RequestMapping({ "updateProductPicPg" })
	public String updateProductPicPgViaListPg(HttpServletRequest request, int blogId) {
		request.setAttribute("blogId", Integer.valueOf(blogId));
		return "/blogMgr/updateProductPic";
	}

	@RequestMapping(value = { "/getBlogsList" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = {
					"application/json;charset=UTF-8" })
	@ResponseBody
	public R findBlogsViaListPg(HttpServletRequest request, HttpServletResponse response, PageInfo pgInfo,
			HttpSession session, Blog blogVo, String isSearch, String tag) {
		return R.OK();
	}

	@RequestMapping(value = { "/blogSearchPage" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = {
					"application/json;charset=UTF-8" })
	@ResponseBody
	public ModelAndView blogSearch(HttpServletRequest request, HttpServletResponse response, PageInfo pgInfo,
			HttpSession session, Blog blogVo, String isSearch, String tag) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/blog-search");
		/*try {
			QueryResult<BlogVo> qr = this.blogService.getBlogList(pgInfo, whereSqlMap, order);
			if (qr != null) {
				mv.addObject("total", Long.valueOf(qr.getTotalrecord()));
				mv.addObject("rows", qr.getResultlist());
			}
		} catch (BlogException e) {
			e.printStackTrace();
		}*/
		return mv;
	}

	@RequestMapping(value = { "/getAllCategorysCount" }, method = {RequestMethod.POST }, produces = {
					"application/json;charset=UTF-8" })
	@ResponseBody
	public R getAllCategorysCount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return R.OK();
	}

	@RequestMapping(value = { "/getAllTagsCount" }, method = {RequestMethod.POST }, produces = {
					"application/json;charset=UTF-8" })
	@ResponseBody
	public R getAllTagsCount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return R.OK();
	}

}
