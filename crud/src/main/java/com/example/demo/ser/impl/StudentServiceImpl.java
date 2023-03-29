package com.example.demo.ser.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.ent.Student;
import com.example.demo.rep.StudentRepository;
import com.example.demo.ser.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student employee) {
		// TODO Auto-generated method stub
		return studentRepository.save(employee);
	}


	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student employee) {
		// TODO Auto-generated method stub
		return studentRepository.save(employee);
	}


	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
	  studentRepository.deleteById(id);
	}
	
	

}
