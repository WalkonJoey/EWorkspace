package com.witcream.blog.api.service;

import com.alibaba.fastjson.JSONObject;
import com.witcream.core.R;

/**
 * @author Joey
 * @date 2016年11月26日
 */
public interface MemberService {

	/**
	 * 查询用户信息
	 * @param body
	 * @return
	 */
	R queryMember(JSONObject body);
	
	/**
	 * 修改用户信息
	 * @param body
	 * @return
	 */
	R updateMember(JSONObject body);

	/**
	 * 删除用户身份证
	 * @param content
	 * @return
	 */
	R deleteMemberIdCard(JSONObject body);

}
