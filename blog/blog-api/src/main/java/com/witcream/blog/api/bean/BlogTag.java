package com.witcream.blog.api.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class BlogTag implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tagId;
	private String tagName;
	private int blogId;
	private String creator;
	private Timestamp createDt;

	public int getTagId() {
		return this.tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Timestamp getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Timestamp createDt) {
		this.createDt = createDt;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

}
