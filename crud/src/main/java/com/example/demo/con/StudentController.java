package com.example.demo.con;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.ent.Student;
import com.example.demo.ser.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/employees")
	public String listStudents(Model model) {
		model.addAttribute("employees",studentService.getAllStudents());
		
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createStudentFrom(Model model) {
		
		Student employee = new Student();
		model.addAttribute("employee",employee);
		
		return "create_employee";
	}
	
	@PostMapping("/employees")
	public String saveStudent(@ModelAttribute("employee") Student employee) {
		studentService.saveStudent(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editStudentFrom(@PathVariable Long id,Model model) {
		
		model.addAttribute("employee",studentService.getStudentById(id));
		
		return "edit_employees";
	}
	
	@PostMapping("/employees/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("employee") Student employee,Model model) {
		Student existingStudent = studentService.getStudentById(id);
		
		existingStudent.setId(id);
		
		existingStudent.setPid(employee.getPid());
		existingStudent.setFirstName(employee.getFirstName());
		existingStudent.setSal(employee.getSal());
		
		studentService.updateStudent(existingStudent);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/employees";
	}

}
