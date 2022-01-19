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

<br>

## JSP로 회원관리 예제 실습
- import도 html 코드 안에서 가능하다.
- <% ~~ %> 이 부분에 자바 코드 입력
- <%= ~~ %> 이 부분에 자바 코드 출력

<br>

JSP를 사용해 보았는데 서블릿이랑 별 차이가 없어 보였다. html을 좀 더 쉽게 사용할 수 있지만, 그 안에서 자바 코드를 다루는 것은 똑같아서 jsp도 사용하는데 불편했다... 


서블릿의 불편함을 해결하기 위해서 jsp가 등장했지만 jsp가 너무 많은 역할을 하게 되어서 비즈니스 로직이 조금만 더 추가되면 jsp 혼자 너무 많은 역할을 하게 되어서 더 복잡해 보일 수 있다.


jsp의 불편함을 해결하기 위해서 MVC 패턴이 등장하였다! 👉 비즈니스 로직은 다른곳에서 처리하고 jsp는 화면을 그리는 역할에 집중한다.

<br>

## MVC 패턴
컨트롤러, 모델, 뷰 3가지로 역할을 나눔

- 컨트롤러 : HTTP 요청을 받고 비즈니스 로직 수행 후, 결과 데이터를 모델에 담고 뷰에 전달
- 모델 : 데이터를 담고, 컨트롤러에서 넘어온 데이터를 뷰에 전달
- 뷰 : 화면 렌더링

<br>

## 개선된 MVC 패턴
프론트 컨트롤러 패턴을 도입하여 기존 MVC 패턴의 수 많은 문제들을 해결할 수 있다.
