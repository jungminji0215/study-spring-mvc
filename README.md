## 테스트 코드 작성 연습

서블릿만 사용하여 만든 회원관리 예제에 대해서 테스트 코드를 직접 작성해 보았다.

```java
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
```
