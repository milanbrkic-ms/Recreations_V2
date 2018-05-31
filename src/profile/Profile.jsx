import React from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Avatar from '@material-ui/core/Avatar';
import fetch from 'node-fetch';
import * as config from '../config';
import * as endpoint from '../datasource/endpoint';
import './style/profile.styl';

export default class Profile extends React.Component {
	constructor(props) {
		super(props);
		this.state ={
			cities: []
		}
	}

	componentDidMount() {
		fetch(config.admin + endpoint.city.base + endpoint.city.getAll)
			.then(response => response.json())
			.then(data => this.setState({cities: data}))
	}
	render() {
		return (
			this.state.cities &&
			<div>
				<List className="cities-list">
					{this.state.cities.map(city =>
						<ListItem primaryText={city.name}
											leftAvatar={(<Avatar> {city.name[0]} </Avatar>)}
						/>
					)}
				</List>
			</div>
		);
	}
}
