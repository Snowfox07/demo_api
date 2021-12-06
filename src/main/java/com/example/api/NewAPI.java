package com.example.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NewDTO;
import com.example.service.INewService;

@RestController()
@RequestMapping("/api/new")
public class NewAPI {

    @Autowired
    private INewService newService;

    @PostMapping()
    public NewDTO createNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping(value = "/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping()
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteNew(@PathVariable("id") Long id) {
        newService.delete(id);
    }

    @GetMapping()
    public List<NewDTO> getAll() {
        return newService.findAll();
    }
}
