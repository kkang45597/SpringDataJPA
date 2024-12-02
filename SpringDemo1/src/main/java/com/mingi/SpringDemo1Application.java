package com.mingi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemo1Application {

	// SpringApplication.run을 호출하는 main 메서드의 클래스 (여기서는 SpringApplication)는 패키지 최상위에 위치해야 한다.
	public static void main(String[] args) {
		SpringApplication.run(SpringDemo1Application.class, args);
	}

}
