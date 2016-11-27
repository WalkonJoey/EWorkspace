package com.witcream.core;
/**
 * ������õķ�����
 * @author Joey
 * @date 2016��11��26��
 */
public enum RCode {
	
	HttpOK("200","http����ɹ��ķ�����"),
	HttpServerError("500","http�������������"),
	HttpForbidden("403","http���󱻽�ֹ"),
	HttpNotFound("404","δ�ҵ���Ӧ����Դ"),
	HttpCustomError("900","�Զ��������"),
	Other("666","�Զ���Ĵ�����");
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
