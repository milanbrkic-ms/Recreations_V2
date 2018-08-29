package com.recreations.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/{type}")
public class Controller {
    private ServiceHandler handler = ServiceHandler.getInstance();

    @GetMapping("/getAll")
    public @ResponseBody Object getAll(@PathVariable @NotNull String type) {

        return ResponseEntity.ok().body(handler.getService(type).getAll());
    }

  @GetMapping("/get/{id}")
  public @ResponseBody Object getAll(@PathVariable @NotNull String type, @PathVariable @NotNull Object id) {

    return ResponseEntity.ok().body(handler.getService(type).get(id));
  }
}
