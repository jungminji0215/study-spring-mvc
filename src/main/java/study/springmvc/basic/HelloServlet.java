package study.springmvc.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿은 HttpServlet을 상속받는다
// /hello로 오면 이 클래스가 실행된다.
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 이 서블릿이 호출되면 service 메서드가 호출됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            org.apache.catalina.connector.RequestFacade -> 이거는 톰캣쪽 라이브러리
            HttpServletRequest와 HttpServletResponse은 인터페이스다.
            인터페이스를 톰캣같은 WAS가 서블릿 표준 스펙을 구현한 것이다.
            그 구현체들이  org.apache.catalina.connector.RequestFacade 이것들.
         */
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // org.apache.catalina.connector.RequestFacade@6a758e58
        System.out.println("response = " + response); // org.apache.catalina.connector.ResponseFacade@3b66b7a2

        /*
             http://localhost:8080/hello?username=minji
             ?username=minji -> 쿼리 파라미터
             서블릿이 쿼리파라미터를 읽기 쉽게 지원해 줌
         */
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 헤더 정보에 들어감
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // write - http 메시지 바디에 데이터 들어감
        response.getWriter().write("hello " + username);
    }
}
