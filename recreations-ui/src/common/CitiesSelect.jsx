import autobind from 'autobind-decorator';
import CityService from '../services/CityService';
import FormControl from '@material-ui/core/FormControl';
import FormHelperText from '@material-ui/core/FormHelperText';
import MenuItem from '@material-ui/core/MenuItem';
import React, { Component } from 'react'
import Select from '@material-ui/core/Select';

export default class CitiesSelect extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: props.id || 0
    };
    this.cityService = new CityService();
  }

  async componentDidMount() {
    let cities = await this.cityService.getAllCities();
    this.setState({cities});
  }
  
  @autobind
  handleChange(event) {
    this.setState({ id: event.target.value });
    this.props.onSelectCity(event.target.value);
  }

  render() {
    return (
      <FormControl>
        <Select
          value={this.state.id}
          onChange={this.handleChange}
          name="City"
          displayEmpty>
          {
            this.state.cities &&
            this.state.cities.map(city => 
              <MenuItem key={city.ptt} value={city.ptt}>
                {city.name}
              </MenuItem>
            )
          }
        </Select>
        <FormHelperText>Choose city</FormHelperText>
      </FormControl>
    );
  }
}
