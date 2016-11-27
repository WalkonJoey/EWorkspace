package com.witcream.blog.serv.member.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.witcream.blog.api.bean.Member;
import com.witcream.blog.api.service.MemberService;
import com.witcream.blog.serv.member.mapper.MemberMapper;
import com.witcream.core.R;
import com.witcream.ext.meta.Display;
import com.witcream.ext.meta.Validator;
import com.witcream.util.Loggers;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	static final Logger logger = Loggers.getLogger();
	
	@Autowired
	private MemberMapper memberMapper;
	
	/**
	 * 查询用户信息
	 * @param body
	 * @return
	 */
	@Override
	@Display("查询用户信息")
	@Validator("{\"type\":\"object\",\"properties\":{\"mem_id\":{\"type\":\"string\",\"pattern\":\"^\\\\d{1,20}$\"},\"account\":{\"type\":\"string\",\"pattern\":\"^(13|14|15|18|17)\\\\d{9}$\"}}}")
	public R queryMember(JSONObject body) {
		Member member = memberMapper.queryMember(body);
		if(Objects.isNull(member)) return R.FAIL("未查询到用户信息");
		JSONObject data = new JSONObject();
		data.put("mem_id", member.getMemId());
		data.put("account", member.getAccount());
		data.put("nickname", member.getNickname());
		data.put("level", member.getLevel());
		data.put("level_name", member.getLevelName());
		data.put("picture", member.getPicture());
		data.put("mobile", member.getMobile());
		data.put("mobile_bound", member.getMobileBound());
		data.put("sex", member.getSex());
		data.put("birthday", member.getBirthday());
		data.put("wechat_bound", member.getWechatBound());
		data.put("wechat", "Y".equals(member.getWechatBound()) ? member.getWechat() : "");
		String inviterMemberNickname = "";
		if(Objects.nonNull(member.getInviterMember())) {
			JSONObject query = new JSONObject();
			query.put("mem_id", member.getInviterMember());
			Member inviterMember = memberMapper.queryMember(query);
			if(Objects.nonNull(inviterMember)) {
				inviterMemberNickname = inviterMember.getNickname();
			}
		}
		data.put("inviter_member", inviterMemberNickname);
		data.put("inviter_code", member.getInviterCode());
		data.put("integral", member.getIntegral());
		data.put("integral_blocked", member.getIntegralBlocked());
		data.put("balance", member.getBalance());
		data.put("balance_blocked", member.getBalanceBlocked());
		data.put("community_code", member.getCommunityCode());
		return R.OK(data);
	}
	
	/**
	 * 修改用户信息
	 * @param body
	 * @return
	 */
	@Override
	@Display("修改用户信息")
	@Validator("{\"type\":\"object\",\"properties\":{\"mem_id\":{\"type\":\"string\",\"pattern\":\"^\\\\d{1,20}$\"},\"nickname\":{\"type\":\"string\",\"pattern\":\"^[^\\\\s]{1,12}$\"},\"picture\":{\"type\":\"string\"},\"sex\":{\"type\":\"string\",\"pattern\":\"^(S|M|W)$\"},\"birthday\":{\"type\":\"string\",\"pattern\":\"^\\\\d{4}-\\\\d{2}-\\\\d{2}$\"}},\"required\":[\"mem_id\"]}")
	@Transactional
	public R updateMember(JSONObject body) { //,\"pattern\":\"^(((https|http):\\\\/\\\\/)[^\\\\s]+)?$\"
		Member member = memberMapper.queryMember(body);
		if(Objects.isNull(member)) return R.FAIL("未查询到用户信息");
		memberMapper.updateMember(body);
		return R.OK();
	}
	/**
	 * 删除用户身份证
	 * @param content
	 * @return
	 */
	@Override
	@Display("删除用户身份证")
	@Validator("{\"type\":\"object\",\"properties\":{\"mem_id\":{\"type\":\"string\",\"pattern\":\"^[^\\\\s]{1,20}$\"},\"id\":{\"type\":\"string\",\"pattern\":\"^\\\\d{1,20}$\"}},\"required\":[\"mem_id\",\"id\"]}}")
	@Transactional
	public R deleteMemberIdCard(JSONObject body) {
		Integer count = memberMapper.deleteMemberIdCard(body);
		if(count != 0) return R.OK();
		return R.FAIL("不存在的用户身份证记录");
	}
	
}
