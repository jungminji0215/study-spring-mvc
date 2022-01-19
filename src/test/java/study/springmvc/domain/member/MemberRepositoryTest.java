package study.springmvc.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
    junit5 부터 public 안 써도 됨!
 */
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given - ~가 주어졌을 때
        Member member = new Member("춘식이", 5);

        // when - ~가 실행됐을 때
        Member saveMember = memberRepository.save(member);

        // then - 결과가 이래야 함
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("춘식이", 5);
        Member member2 = new Member("라이언", 6);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        Assertions.assertThat(member1).isEqualTo(members.get(0));

        // 갯수랑 포함되어있는지만 확인해보면 된다.
        Assertions.assertThat(members.size()).isEqualTo(2);
        Assertions.assertThat(members).contains(member1, member2);
    }
}