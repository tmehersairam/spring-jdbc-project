package com.fis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fis.entity.Student;
import com.fis.service.StudentService;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		StudentService studentService = context.getBean(StudentService.class);

//		studentService.insert(new Student("meher", 234234324));
		studentService.update(new Student("alien", 234234234), 3);
//		studentService.delete(2);

		System.out.println(studentService.getAll());
	}

}
