import React from 'react'
import Service from './Service';

const ENDPOINT = 'user';

export default class UserService extends Service {
  getAllUsers() {
    return super.getAll(ENDPOINT);
  }

  getUser(id) {
    return super.getById(ENDPOINT, id);
  }

  addUser(user) {
    return super.add(ENDPOINT, user);
  }
}