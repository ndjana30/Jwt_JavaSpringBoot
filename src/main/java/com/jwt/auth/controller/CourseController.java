package com.jwt.auth.controller;

import com.jwt.auth.models.Course;
import com.jwt.auth.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/courses")
@RestController
public class CourseController
{
    @Autowired
    CourseService cs;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses()
    {
        List<Course> courses = cs.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable Integer id)
    {
        if(cs.getCourseById(id)==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(cs.getCourseById(id), HttpStatus.FOUND);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course)
    {
        return new ResponseEntity<>(cs.createCourse(course),HttpStatus.CREATED);
    }
}
