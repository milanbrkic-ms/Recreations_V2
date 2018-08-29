package com.recreations.service;

import com.recreations.repository.CityDAO;
import com.recreations.service.impl.CityServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

  @InjectMocks
  private CityServiceImpl service;

  @Mock
  private CityDAO repository;


}
