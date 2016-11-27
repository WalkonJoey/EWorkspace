package com.witcream.blog.api.bean;

public class Member implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long memId;
	private Long account;
	private String loginPwd;
	private String payPwd;
	private Long level;
	private String levelName;
	private String nickname;
	private String picture;
	private Long mobile;
	private String mobileBound;
	private String email;
	private String emailBound;
	private String sex;
	private java.util.Date birthday;
	private String wechatBound;
	private String wechat;
	private Long registerChannel;
	private String registerChannelName;
	private String inviterCode;
	private Long inviterMember;
	private String group;
	private Long integral;
	private Long integralConsumer;
	private Long integralBlocked;
	private Long balance;
	private Long balanceBlocked;
	private Long balanceConsumer;
	private Long balancePresent;
	private Long commission;
	private String enabled;
	private Long orderCount;
	private java.util.Date created;
	private String communityCode;

	public Long getCommission() {
		return commission;
	}

	public void setCommission(Long commission) {
		this.commission = commission;
	}

	public Long getMemId(){
		 return this.memId;
	}

	public void setMemId(Long memId){
		this.memId = memId;
	}

	public Long getAccount(){
		 return this.account;
	}

	public void setAccount(Long account){
		this.account = account;
	}

	public String getLoginPwd(){
		 return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd){
		this.loginPwd = loginPwd;
	}

	public String getPayPwd(){
		 return this.payPwd;
	}

	public void setPayPwd(String payPwd){
		this.payPwd = payPwd;
	}

	public Long getLevel(){
		 return this.level;
	}

	public void setLevel(Long level){
		this.level = level;
	}

	public String getLevelName(){
		 return this.levelName;
	}

	public void setLevelName(String levelName){
		this.levelName = levelName;
	}

	public String getNickname(){
		 return this.nickname;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getPicture(){
		 return this.picture;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public Long getMobile(){
		 return this.mobile;
	}

	public void setMobile(Long mobile){
		this.mobile = mobile;
	}

	public String getMobileBound(){
		 return this.mobileBound;
	}

	public void setMobileBound(String mobileBound){
		this.mobileBound = mobileBound;
	}

	public String getEmail(){
		 return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmailBound(){
		 return this.emailBound;
	}

	public void setEmailBound(String emailBound){
		this.emailBound = emailBound;
	}

	public String getSex(){
		 return this.sex;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public java.util.Date getBirthday(){
		 return this.birthday;
	}

	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}

	public String getWechatBound(){
		 return this.wechatBound;
	}

	public void setWechatBound(String wechatBound){
		this.wechatBound = wechatBound;
	}

	public String getWechat(){
		 return this.wechat;
	}

	public void setWechat(String wechat){
		this.wechat = wechat;
	}

	public Long getRegisterChannel(){
		 return this.registerChannel;
	}

	public void setRegisterChannel(Long registerChannel){
		this.registerChannel = registerChannel;
	}

	public String getRegisterChannelName(){
		 return this.registerChannelName;
	}

	public void setRegisterChannelName(String registerChannelName){
		this.registerChannelName = registerChannelName;
	}

	public String getInviterCode(){
		 return this.inviterCode;
	}

	public void setInviterCode(String inviterCode){
		this.inviterCode = inviterCode;
	}

	public Long getInviterMember(){
		 return this.inviterMember;
	}

	public void setInviterMember(Long inviterMember){
		this.inviterMember = inviterMember;
	}

	public String getGroup(){
		 return this.group;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public Long getIntegral(){
		 return this.integral;
	}

	public void setIntegral(Long integral){
		this.integral = integral;
	}

	public Long getIntegralConsumer(){
		 return this.integralConsumer;
	}

	public void setIntegralConsumer(Long integralConsumer){
		this.integralConsumer = integralConsumer;
	}

	public Long getIntegralBlocked(){
		 return this.integralBlocked;
	}

	public void setIntegralBlocked(Long integralBlocked){
		this.integralBlocked = integralBlocked;
	}

	public Long getBalance(){
		 return this.balance;
	}

	public void setBalance(Long balance){
		this.balance = balance;
	}

	public Long getBalanceBlocked(){
		 return this.balanceBlocked;
	}

	public void setBalanceBlocked(Long balanceBlocked){
		this.balanceBlocked = balanceBlocked;
	}

	public Long getBalanceConsumer(){
		 return this.balanceConsumer;
	}

	public void setBalanceConsumer(Long balanceConsumer){
		this.balanceConsumer = balanceConsumer;
	}

	public Long getBalancePresent(){
		 return this.balancePresent;
	}

	public void setBalancePresent(Long balancePresent){
		this.balancePresent = balancePresent;
	}

	public String getEnabled(){
		 return this.enabled;
	}

	public void setEnabled(String enabled){
		this.enabled = enabled;
	}

	public java.util.Date getCreated(){
		 return this.created;
	}

	public void setCreated(java.util.Date created){
		this.created = created;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public String getCommunityCode() {
		return communityCode;
	}

	public void setCommunityCode(String communityCode) {
		this.communityCode = communityCode;
	}

	
}