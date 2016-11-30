package com.witcream.blog.api.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class BlogContent implements Serializable {
	private static final long serialVersionUID = 1L;
	private int blogId;
	private String blogCategory;
	private String blogTitle;
	private String blogSummary;
	private String blogContent;
	private String mainPicPath;
	private String contentPicsPath;
	private String author;
	private int readCount;
	private int likeCount;
	private int commentCount;
	private String keywords;
	private String blogDetailUrl;
	private String creator;
	private Timestamp createDt;
	private String operator;
	private Timestamp operateDt;
	private String comment;
	private Set<BlogTag> tagsSet = new HashSet<BlogTag>();

	public int getBlogId() {
		return this.blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogCategory() {
		return this.blogCategory;
	}

	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogSummary() {
		return this.blogSummary;
	}

	public void setBlogSummary(String blogSummary) {
		this.blogSummary = blogSummary;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getMainPicPath() {
		return this.mainPicPath;
	}

	public void setMainPicPath(String mainPicPath) {
		this.mainPicPath = mainPicPath;
	}

	public String getContentPicsPath() {
		return this.contentPicsPath;
	}

	public void setContentPicsPath(String contentPicsPath) {
		this.contentPicsPath = contentPicsPath;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getReadCount() {
		return this.readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getLikeCount() {
		return this.likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getBlogDetailUrl() {
		return this.blogDetailUrl;
	}

	public void setBlogDetailUrl(String blogDetailUrl) {
		this.blogDetailUrl = blogDetailUrl;
	}

	public Timestamp getOperateDt() {
		return this.operateDt;
	}

	public void setOperateDt(Timestamp operateDt) {
		this.operateDt = operateDt;
	}

	public Timestamp getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Timestamp createDt) {
		this.createDt = createDt;
	}

	public String getComment() {
		return this.comment;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Set<BlogTag> getTagsSet() {
		return this.tagsSet;
	}

	public void setTagsSet(Set<BlogTag> tagsSet) {
		this.tagsSet = tagsSet;
	}

}
