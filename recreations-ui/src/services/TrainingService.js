import React from 'react'
import Service from './Service';

const ENDPOINT = 'training';

export default class TrainingService extends Service {
  getAllTrainigs() {
    return super.getAll(ENDPOINT);
  }

  getCity(id) {
    return super.getById(ENDPOINT, id);
  }
}