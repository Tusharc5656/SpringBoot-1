package com.Tushar.demo;

import com.Tushar.demo.Dependecyinjection.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)  {
	ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
	/*student student =context.getBean(student.class);
     student.setName("Rahul");
     student.setAge(30);

	 System.out.println(student.getName());
	 System.out.println(student.getAge());*/

	/*	OrderService orderService = context.getBean(OrderService.class);

		orderService.placeOrder();*/
	}

}
