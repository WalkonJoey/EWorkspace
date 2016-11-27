package com.witcream.core;
/**
 * 请求调用的返回码
 * @author Joey
 * @date 2016年11月26日
 */
public enum RCode {
	
	HttpOK("200","http请求成功的返回码"),
	HttpServerError("500","http请求服务器错误"),
	HttpForbidden("403","http请求被禁止"),
	HttpNotFound("404","未找到对应的资源"),
	HttpCustomError("900","自定义错误码"),
	Other("666","自定义的错误码");
	private String code;
	private String comment;

	private RCode(String code, String comment) {
		this.setCode(code);
		this.setComment(comment);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
