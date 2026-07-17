package com.Tushar.demo.StudentServer.Repository;

import com.Tushar.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}