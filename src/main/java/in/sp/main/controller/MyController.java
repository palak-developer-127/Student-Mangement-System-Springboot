package in.sp.main.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.Student;
import in.sp.main.service.StudentService;

import org.springframework.ui.Model;

@Controller
public class MyController {
	
	@Autowired
	private StudentService studentService;
		
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		model.addAttribute("student", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
	    Student student = new Student();
	    model.addAttribute("student", student);
	    return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
	    studentService.saveStudent(student);
	    return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int  id ,Model model) {
		model.addAttribute("student",studentService.getById(id));
		return "update_student";	
	}
	
	@PostMapping("students/edit/{id}")
	public String updateStudent(@PathVariable int id , @ModelAttribute("student")Student student) {
		Student existLingStudent = studentService.getById(id);
		existLingStudent.setFirstName(student.getFirstName());
		existLingStudent.setLastName(student.getLastName());
		existLingStudent.setEmail(student.getEmail());
		
		studentService.saveStudent(existLingStudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteById(@PathVariable int id)
	{
		studentService.deleteById(id);
		return "redirect:/students";
		
	}
}
