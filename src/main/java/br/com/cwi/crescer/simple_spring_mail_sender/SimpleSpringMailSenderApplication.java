package br.com.cwi.crescer.simple_spring_mail_sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SimpleSpringMailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringMailSenderApplication.class, args);
    }

}
