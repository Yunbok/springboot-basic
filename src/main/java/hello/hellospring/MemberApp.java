package hello.hellospring;

import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberServiceImpl;
import hello.hellospring.domain.Grade;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberApp {



    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}