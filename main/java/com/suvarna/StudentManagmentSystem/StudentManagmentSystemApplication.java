package com.suvarna.StudentManagmentSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.suvarna.StudentManagmentSystem.Model.Student;
import com.suvarna.StudentManagmentSystem.Repository.StudentRepository;

@SpringBootApplication
public class StudentManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentSystemApplication.class, args);
	}
	
	@Autowired
	StudentRepository studentRepository;
	public void run(String...args)throws Exception{
		Student s1 = new Student();
		studentRepository.save(s1);
	}

}
