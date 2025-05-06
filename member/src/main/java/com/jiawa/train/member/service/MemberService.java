package com.jiawa.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.jiawa.train.member.domain.Member;
import com.jiawa.train.member.domain.MemberExample;
import com.jiawa.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;
    public int count(){
        return (int) memberMapper.countByExample(null);
    }

    public long register(String mobile){
        MemberExample memberExample = new MemberExample();
        //createCriteria()是创建一个while条件
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(list)){
            //return list.get(0).getId();
            throw new RuntimeException("the mobile phone has been created!");
        }

        Member member = new Member();//数据库的表中的一条记录结构
        member.setId(System.currentTimeMillis());//用系统的时间作为id
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
