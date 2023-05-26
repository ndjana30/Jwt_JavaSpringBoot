package com.jwt.auth.service;

import com.jwt.auth.models.Course;
import com.jwt.auth.models.Module;
import com.jwt.auth.repository.CourseRepository;
import com.jwt.auth.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ModuleService {
    @Autowired
    ModuleRepository mr;

    public List<Module> getAllModules()
    {
        return mr.findAll();
    }

    public Optional<Module> getModuleById(Integer id)
    {
        return mr.findById(id);
    }

    public Module createModule(Module module)
    {
        if (module.getId()==null)
        {
            List<Module> modules= (List<Module>)mr.findAll();
            module.setId(modules.size()+1);
            mr.save(module);
            return module;
        }
        mr.save(module);
        return module;
    }

}
