import React from 'react';
import PersonService from '../services/PersonService'
import ProfileNavigation from './components/ProfileNavigation';
import ProfileBody from './components/ProfileBody';
import './style/profile.styl';

export default class Profile extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
      tab: 0,
      profile: {}
    };
    this.personService = new PersonService();

    this.setTab = this.setTab.bind(this);
    this.renderBody = this.renderBody.bind(this);
	}

	async componentDidMount() {
    // retrieve profile
  }

  setTab(event, tab) {
    this.setState({tab});
  }
  
  renderBody() {
    switch (this.state.tab) {
      case 0: {
        return (
          <div>
            HOME PAGE
          </div>
        );
      }
      case 1: {
        return (
          <div>EDIT PAGE</div>
        );
      }
    }
  }

	render() {
		return (
      <div className="profile-page">
        <ProfileNavigation onTabChanged={this.setTab} {...this.state} />
        <ProfileBody>
          {this.renderBody()}
        </ProfileBody>
      </div>
		);
	}
}
