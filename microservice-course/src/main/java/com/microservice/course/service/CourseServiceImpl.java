package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.entitites.Course;
import com.microservice.course.entitites.dto.StudentDTO;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.repository.IcourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private IcourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByIdCourse(Long idCourse) {
        //consultar el curso
        Course course=courseRepository.findById(idCourse).orElse(new Course());

        //obtener los estudiantes
        List<StudentDTO> studentDTOList=studentClient.findAllStudentsByCourse(idCourse);


        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
