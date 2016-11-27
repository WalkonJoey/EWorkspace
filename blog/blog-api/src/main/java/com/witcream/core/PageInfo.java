package com.witcream.core;

import java.io.Serializable;

public class PageInfo implements Serializable {
	private static final long serialVersionUID = -3591536968171663992L;
	private int currentPage = 1;
	private int rowsOnePage = 10;
	private int startIndex = 0;
	private String sort = null;
	private String order = "asc";

	public int getPage() {
		return this.currentPage;
	}

	public void setPage(int currentPage) {
		this.currentPage = currentPage;
		this.startIndex = ((currentPage - 1) * this.rowsOnePage);
	}

	public int getRows() {
		return this.rowsOnePage;
	}

	public void setRows(int rowsOnePage) {
		this.rowsOnePage = rowsOnePage;
		this.startIndex = ((this.currentPage - 1) * rowsOnePage);
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getStartIndex() {
		return this.startIndex;
	}
}
