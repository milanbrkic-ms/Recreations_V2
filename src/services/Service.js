import fetch from 'node-fetch';
import * as config from '../config';

export default class Service {
  getAll(endpoint) {
    return fetch(config.admin + `/${endpoint}/all`).then(all => all.json());
  }
  
  getById(endpoint, id) {
    return fetch(config.admin + `/${endpoint}/${id}`).then(entity => entity.json());
  }  
}