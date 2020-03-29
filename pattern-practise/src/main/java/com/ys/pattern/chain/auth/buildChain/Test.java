package com.ys.pattern.chain.auth.buildChain;


import com.ys.pattern.chain.auth.Member;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 17:42
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Member member = new Member("yy","dd");
        member.setRoleName("管理员");
        MemberService memberService = new MemberService();
        memberService.login(member);
    }
}
