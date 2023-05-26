package com.jwt.auth.service;

import com.jwt.auth.models.Course;
import com.jwt.auth.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository cr;

    public List<Course> getAllCourses()
    {
        return cr.findAll();
    }

    public Optional<Course> getCourseById(Integer id)
    {
        return cr.findById(id);
    }
}
