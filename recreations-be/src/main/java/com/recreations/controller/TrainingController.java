package com.recreations.controller;

import com.recreations.model.Training;
import com.recreations.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
public class TrainingController {

  @Autowired private TrainingService service;

  @GetMapping("/all")
  public @ResponseBody Object getAll() {
    return ResponseEntity.ok().body(service.getAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody Object get(@PathVariable int id)  {
    return ResponseEntity.ok().body(service.get(id));
  }

  @PostMapping("/add")
  public @ResponseBody Object add(@RequestBody Training newTraining) {
    return ResponseEntity.ok().body(service.add(newTraining));
  }
}
