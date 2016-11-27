package com.witcream.core;

import java.util.List;

public class QueryResult<T> {
	private List<T> resultlist;
	private long totalrecord;

	public List<T> getResultlist() {
		return this.resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public long getTotalrecord() {
		return this.totalrecord;
	}

	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
}
