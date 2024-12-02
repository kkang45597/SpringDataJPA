package com.mingi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mingi.annotation.EnableMyFeature;

@SpringBootApplication
@EnableMyFeature  // DeferredImportSelector가 적용됨
public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApplication.class, args);

        // 기본 설정 클래스에서 로드된 빈 출력
        if (context.containsBean("initialBean")) {
            System.out.println(context.getBean("initialBean"));
        } else {
            System.out.println("Initial bean was not loaded.");
        }

        // 지연 로딩된 빈 출력
        if (context.containsBean("deferredBean")) {
            System.out.println(context.getBean("deferredBean"));
        } else {
            System.out.println("Deferred bean was not loaded.");
        }
    }
}