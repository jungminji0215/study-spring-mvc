package study.springmvc.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void clearStore() {
    }
}