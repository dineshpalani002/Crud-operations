package com.example.demo.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ent.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
