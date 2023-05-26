package com.jwt.auth.controller;

import com.jwt.auth.models.Course;
import com.jwt.auth.models.Module;
import com.jwt.auth.service.CourseService;
import com.jwt.auth.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/modules")
@RestController
public class ModuleController {

    @Autowired
    ModuleService ms;

    @GetMapping("/all")
    public ResponseEntity<List<Module>> getAllModules()
    {
        List<Module> modules = ms.getAllModules();
        return new ResponseEntity<>(modules, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Module>> getModuleById(@PathVariable Integer id)
    {
        if(ms.getModuleById(id)==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(ms.getModuleById(id), HttpStatus.FOUND);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<Module> createModule(@RequestBody Module module)
    {
        return new ResponseEntity<>(ms.createModule(module),HttpStatus.CREATED);
    }
}
