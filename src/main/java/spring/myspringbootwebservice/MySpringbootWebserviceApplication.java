package spring.myspringbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MySpringbootWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringbootWebserviceApplication.class, args);
	}

}