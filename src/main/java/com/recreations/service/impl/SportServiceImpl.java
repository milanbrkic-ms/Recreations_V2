package com.recreations.service.impl;

import com.recreations.model.Sport;
import com.recreations.repository.SportDAO;
import com.recreations.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements SportService {
    @Autowired
    private SportDAO repository;

    @Override
    public List<Sport> getAll() {
        return repository.findAll();
    }

    @Override
    public Sport get(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void add(Sport newObject) {
        repository.save(newObject);
    }

    @Override
    public Integer remove(Sport obj) {
        repository.delete(obj);
        return obj.getSportID();
    }

    @Override
    public void update(Sport obj) {

    }
}
