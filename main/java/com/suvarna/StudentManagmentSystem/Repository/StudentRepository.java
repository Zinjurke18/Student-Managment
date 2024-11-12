package com.suvarna.StudentManagmentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.suvarna.StudentManagmentSystem.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
