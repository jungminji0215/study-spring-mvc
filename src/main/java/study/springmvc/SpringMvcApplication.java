package study.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/*
	@ServletComponentScan을 붙이면 스프링이 자동으로
	현재 패키지를 포함해서 하위 패키지들에서 서블릿을 찾아서
	자동으로 서블릿을 등록해서 실행할 수 있도록 해준다.
 */
@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
