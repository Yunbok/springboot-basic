package hello.hellospring.service;

import hello.hellospring.AppConfig;
import hello.hellospring.domain.Grade;
import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join() {

        //given
        Member member = new Member(2L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(2L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
