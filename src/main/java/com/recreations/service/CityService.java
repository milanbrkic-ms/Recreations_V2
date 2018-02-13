package com.recreations.service;

import com.recreations.model.City;

import java.util.List;

public interface CityService {
    List<City> getAll();

    City get(int cityId);

    void add(City newCity);

    int remove(City city);

    void update(City city);
}
