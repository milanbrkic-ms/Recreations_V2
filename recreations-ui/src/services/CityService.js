import React from 'react'
import Service from './Service';

const ENDPOINT = 'city';

export default class CityService extends Service {
  getAllCities() {
    return super.getAll(ENDPOINT);
  }

  getCity(id) {
    return super.getById(ENDPOINT, id);
  }
}