package com.example.spring.test1;

import com.example.spring.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test1Application {

	public static void main(String[] args) {
		sayHello();
		App.sayHello();
		SpringApplication.run(Test1Application.class, args);
	}

	public static void sayHello(){
		System.out.println("Test1Application sayHello");
	}
}
