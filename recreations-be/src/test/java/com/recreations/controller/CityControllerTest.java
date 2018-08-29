package com.recreations.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.recreations.model.City;
import com.recreations.service.CityService;
import com.recreations.service.exception.EntityNotFoundException;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

/**
 * Unit tests for city controller
 */
@RunWith(MockitoJUnitRunner.class)
public class CityControllerTest {

  @InjectMocks
  private CityController controller;

  @Mock
  private CityService service;

  @Test
  public void getAllTest() {
    when(service.getAll()).thenReturn(Collections.emptyList());

    ResponseEntity response = (ResponseEntity) controller.getAll();

    assertNotNull(response);
    assertEquals(response.getStatusCode().value(), 200);
    assertEquals(response.getBody(), Collections.EMPTY_LIST);
    verify(service).getAll();
  }

  @Test
  public void getExistingTest() {
    City city = new City(123, "Belgrade");
    when(service.get(1)).thenReturn(city);

    ResponseEntity response = (ResponseEntity<City>) controller.get(1);

    assertNotNull(response);
    assertEquals(response.getBody(), city);
    verify(service).get(1);
  }

  @Test(expected = EntityNotFoundException.class)
  public void getNotExistingTest() {
    when(service.get(1)).thenThrow(EntityNotFoundException.class);

    controller.get(1);
  }
}
