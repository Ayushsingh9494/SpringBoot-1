package com.ayush.demo;

import com.ayush.demo.DependencyInjection.OrderService;
import com.ayush.demo.Server.HelloServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DemoApplication.class, args);
//		Student student = context.getBean(Student.class);
//		student.setAge(28);
//		student.setName("Rahul");
//		System.out.println(student.getName());
//		System.out.println(student.getAge());
//		OrderService order1 = context.getBean(OrderService.class);
//		order1.placeOrder();
	}
}
