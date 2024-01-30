package com.microservice.course.client;

import com.microservice.course.entitites.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//nombre del micro que haremos la consulta (application.yaml->name:)
@FeignClient(name = "msvc-student",url = "localhost:8080/api/student")
public interface StudentClient {

    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long idCourse);
}
