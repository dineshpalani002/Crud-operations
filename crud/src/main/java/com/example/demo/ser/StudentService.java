package com.example.demo.ser;

import java.util.List;

import com.example.demo.ent.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student employee); 
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student employee);
	
	void deleteStudentById(Long id);

}
