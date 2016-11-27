package com.witcream.blog.api.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.witcream.blog.api.bean.Blog;
import com.witcream.core.PageInfo;
import com.witcream.core.QueryResult;

public abstract interface IBlogService
{
	public abstract QueryResult<Blog> getBlogList(PageInfo paramPageInfo, Map<String, Object> paramMap);
  
  public abstract QueryResult<Blog> getBlogList(PageInfo paramPageInfo, Map<String, Object> paramMap, LinkedHashMap<String, String> paramLinkedHashMap);
  
  public abstract Blog getBlogByBlogId(int paramInt);
  
  public abstract QueryResult<Blog> getBlogsByCondition(int paramInt1, int paramInt2, Map<String, Object> paramMap, LinkedHashMap<String, String> paramLinkedHashMap);
  
  
  public abstract QueryResult<Blog> getBlogList(PageInfo paramPageInfo, Map<String, Object> paramMap, LinkedHashMap<String, String> paramLinkedHashMap, List<String> paramList);
  
  public abstract List<Blog> getBlogList(Map<String, Object> paramMap);
  
  public abstract List<Map<String, Object>> getAllCategorysCount();
  
  public abstract List<Map<String, Object>> getAllTagsCount();
}

