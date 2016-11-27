package com.witcream.core;

import java.io.Serializable;

public class R implements Serializable {
	private static final long serialVersionUID = 1L;
	private Meta meta;
	private Object data;

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Meta getMeta() {
		return this.meta;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

	public R() {
		this(null);
	}

	public R(Object data) {
		this.meta = new Meta(RCode.HttpOK.getCode(), "OK");
		this.data = data;
	}

	public R(Meta meta, Object data) {
		this.meta = meta;
		this.data = data;
	}

	public static R OK() {
		return OK(null);
	}

	public static R OK(Object data) {
		return OK("OK", data);
	}

	public static R OK(String msg, Object data) {
		return OK(RCode.HttpOK.getCode(), msg, data);
	}

	public static R OK(String code, String msg, Object data) {
		return new R(new Meta(code, msg), data);
	}

	public static R FAIL() {
		return FAIL(null);
	}

	public static R FAIL(String msg) {
		return FAIL(RCode.HttpCustomError.getCode(), msg);
	}

	public static R FAIL(String code, String msg) {
		return FAIL(code, msg, null);
	}

	public static R FAIL(String code, String msg, Object data) {
		return new R(new Meta(code, msg), data);
	}

	public static class Meta implements Serializable {
		private static final long serialVersionUID = 1L;
		private String code;
		private String msg;

		public Meta() {
			this("OK");
		}

		public Meta(String msg) {
			this(RCode.HttpOK.getCode(), msg);
		}

		public Meta(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public static Meta ok() {
			return new Meta();
		}

		public static Meta ok(String msg) {
			return new Meta(msg);
		}

		public static Meta err() {
			return new Meta(RCode.HttpCustomError.getCode(), "ERR");
		}

		public static Meta err(String msg) {
			return new Meta(RCode.HttpCustomError.getCode(), msg);
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return this.msg;
		}
	}
}
