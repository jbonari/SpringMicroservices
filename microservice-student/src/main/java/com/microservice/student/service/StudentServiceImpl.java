package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.respository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentRespository studentRespository;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRespository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRespository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRespository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRespository.findAllStudents(idCourse);
    }
}
