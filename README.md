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
<br>

## 서블릿으로 회원관리 예제 실습

- MemberFormServlet
- MemberListServlet
- MemberSaveServlet

<br>

서블릿으로 실습 결과 html 화면 만드는 것이 정말 불편했다... 자바 코드 안에 html 태그를 써서 화면을 그리는데 언제 다 하지?라는 생각밖에 안 들었다.
이러한 불편함을 해결해 주기 위해 나타난 것이 탬플릿 엔진이라고 한다. 👉 html 문서에 동적으로 변경되어야 하는 부분만 자바 코드를 넣을 수 있도록 해준다.
