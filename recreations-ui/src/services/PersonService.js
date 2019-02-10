import React from 'react'
import Service from './Service';

const ENDPOINT = 'person';

export default class PersonService extends Service {
  getAllPersons() {
    return super.getAll(ENDPOINT);
  }

  getPerson(id) {
    return super.getById(ENDPOINT, id);
  }

  getTrainings(id) {
    return super.getTrainings("member", id);
  }
}