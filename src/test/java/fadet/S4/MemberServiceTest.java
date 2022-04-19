package fadet.S4;

import fadet.S4.service.MemberService;
import fadet.S4.domain.Member;
import fadet.S4.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("A");
        member.setRID("a@a");

        //when
        Long saveId = memberService.join(member);

        //then
        assertThat(member).isEqualTo(memberRepository.findOne(saveId));
    }

    @Test
    void 중복테스트() {
        //given

        //when

        //then
    }
}