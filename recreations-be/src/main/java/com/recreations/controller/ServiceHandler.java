package com.recreations.controller;

import com.recreations.service.BaseService;
import com.recreations.service.impl.UserServiceImpl;
import com.recreations.service.impl.PersonServiceImpl;
import com.recreations.service.impl.SportServiceImpl;
import com.recreations.service.impl.CityServiceImpl;
import com.recreations.service.impl.TrainingServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class ServiceHandler {

  private static ServiceHandler instance;
  private Map<String, BaseService> services;

  private ServiceHandler() {
    services = new HashMap<>();
    services.put("user", new UserServiceImpl());
    services.put("city", new CityServiceImpl());
    services.put("person", new PersonServiceImpl());
    services.put("sport", new SportServiceImpl());
    services.put("training", new TrainingServiceImpl());
  }

  public static ServiceHandler getInstance() {
    if(instance==null) {
      instance = new ServiceHandler();
    }
    return instance;
  }

  public BaseService getService(String type) {
    return services.get(type.toLowerCase());
  }
}
