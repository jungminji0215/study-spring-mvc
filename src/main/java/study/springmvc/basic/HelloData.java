package study.springmvc.basic;

import lombok.Getter;
import lombok.Setter;

/*
    JSON 형식의 데이터를 객체로 바꿔서 쓴다.
    JSON 형식으로 파싱할 수 있게 객체를 만든 것이다.
 */
@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}