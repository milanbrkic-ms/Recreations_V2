package com.recreations.controller;

import com.recreations.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService service;

    @GetMapping("/")
    public @ResponseBody Object getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public @ResponseBody Object get(@PathVariable int id)  {
        return ResponseEntity.ok().body(service.get(id));
    }
}
