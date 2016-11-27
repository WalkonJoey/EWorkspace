package com.witcream.blog.serv.member.mapper;

import java.util.List;
import java.util.Map;

import com.witcream.blog.api.bean.Member;


/**
 * 
 * @author Joey
 * @date 2016年11月26日
 */
public interface MemberMapper {

	/**
	 * 根据条件查询用户信息
	 * @param query 多条件
	 * @return Member
	 */
	Member queryMember(Map<String, Object> query);
	
	/**
	 * 根据条件查询用户列表信息
	 * @param query 多条件
	 * @return Member
	 */
	List<Member> queryMemberList(Map<String, Object> query);
	
	/**
	 * 根据条件查询用户信息
	 * @param query 多条件
	 * @return Member
	 */
	Member queryMemberUpdate(Map<String, Object> query);

	/**
	 * 修改用户信息
	 * @param query 多字段
	 * @return change row count
	 */
	Integer updateMember(Map<String, Object> query);

	/**
	 * 创建用户
	 * @param query
	 * @return
	 */
	Integer createMember(Map<String, Object> query);

	/**
	 * 创建用户身份证
	 * @param query
	 * @return
	 */
	Integer createMemberIdCard(Map<String, Object> query);

	/**
	 * 删除用户身份证
	 * @param query
	 * @return
	 */
	Integer deleteMemberIdCard(Map<String, Object> body);

	

}
