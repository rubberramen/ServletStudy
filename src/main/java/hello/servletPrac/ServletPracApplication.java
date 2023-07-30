package hello.servletPrac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan  // 서블릿 자동 등록
@SpringBootApplication
public class ServletPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletPracApplication.class, args);
	}

}
