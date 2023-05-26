package com.jwt.auth.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name="module")
public class Module {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Integer Id;

    private String name;

    @ManyToOne
    @JoinColumn(name="courseid", updatable=false, insertable=false)
    private Course course;

    private Integer courseid;
    public Module(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonBackReference
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
