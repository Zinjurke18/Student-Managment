package com.suvarna.StudentManagmentSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvarna.StudentManagmentSystem.Model.Student;
import com.suvarna.StudentManagmentSystem.Repository.StudentRepository;

@Service
public class StudentService {
	// we use autowired annotation to make the object of factory
	@Autowired
	StudentRepository studentRepository;

	//list All student ----> Read all student
	
	public List<Student> listAllStudents(){
		
		return studentRepository.findAll();
	}
	
	//Save Student ----> write a student in db
	public Student saveStudent (Student student) {
		return studentRepository.save(student);
	}
	
	//getStudentById(id) ----> student
	
	public Student getStudentById (Long id) {
		return studentRepository.findById(id).get();
	}
	
	//updateStudent(Student student)----> update
	
	//deleteStudentById(id) ----> delete student of that particular id
	public void deleteStudentById (Long id) {
		studentRepository.deleteById(id);
	}
	
	
	
}
