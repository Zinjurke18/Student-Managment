package com.suvarna.StudentManagmentSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.suvarna.StudentManagmentSystem.Model.Student;
import com.suvarna.StudentManagmentSystem.Service.StudentService;

@RestController
public class StudentController {
	//controller --> service --> repository --> db
	//view<--controller<--service<--repository<--db
	//localhost:8080/ --> it show the list
	
	@Autowired
	StudentService studentService;
	@GetMapping("/")
	public ModelAndView listStudents(Model model) {
		
		model.addAttribute("studentsList", studentService.listAllStudents());
		return new ModelAndView("students");
	}
	
	@GetMapping("/students/new")
	public ModelAndView createStudentForm(Model model) {
		Student s = new Student();
		model.addAttribute("studentObject",s);
		return new ModelAndView("create_student");

	}
	
	@PostMapping("/students")
	public ModelAndView saveStudent(@ModelAttribute("studentObject") Student student) {
		studentService.saveStudent(student);
		//redirect map bydefault the getmapping 
		RedirectView rd = new RedirectView();
		rd.setUrl("/");
		return new ModelAndView(rd);
	}
	
	//url--> student/edit/{id}-->edit_student form return --> get
	@GetMapping("/students/edit/{id}")
	//it fecthing data through the pathvariable
    public ModelAndView editStudentForm(@PathVariable Long id ,Model model) {
		model.addAttribute("studentObject",studentService.getStudentById(id));
		return new ModelAndView("edit_student");

    }
	
	//url --> 	/student/{id} --> Post
	@PostMapping("/students/{id}")
	public ModelAndView studentUpdate(@PathVariable Long id, @ModelAttribute("studentObject") Student student) {
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentService.saveStudent(existingStudent);
		RedirectView rd = new RedirectView();
		rd.setUrl("/");
		return new ModelAndView(rd);
	}
	
	@GetMapping("/students/delete/{id}")
	public ModelAndView deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		RedirectView rd = new RedirectView();
		rd.setUrl("/");
		return new ModelAndView(rd);
		
	}
	
	
	
	
	
	
    }
