package com.recreations.service;

import java.util.List;

public interface BaseService<T, K> {

  List<T> getAll();

  T get(K id) ;

  T add(T newObject);

  K remove(T obj);

  void update(T obj);
}
