package com.example1;

import com.example.TestApp1;

public class TestApp2 {
    public static void main(String[] args) {
		sayHello();
        TestApp1.sayHello();
	}

	public static void sayHello() {
		System.out.println("MyTest2 says hello!");
	}
}
