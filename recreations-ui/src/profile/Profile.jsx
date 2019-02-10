import React from 'react';
import PersonService from '../services/PersonService';
import ProfileNavigation from './components/ProfileNavigation';
import ProfileBody from './components/ProfileBody';
import './style/profile.styl';
import { withAuth } from '@okta/okta-react';
import autobind from 'autobind-decorator';
import ProfileTraining from './components/ProfileTrainings';

@autobind
export default withAuth(
  class Profile extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        tab: 0,
        profile: {}
      };
      this.personService = new PersonService();
    }

    async saveTrainings(trainings) {
      await this.personService.saveTrainings(trainings);
    }

    async componentDidMount() {
      // retrieve profile
      this.props.auth.getUser().then(user => this.setState({ user }));
      console.log(this.state.user);
    }

    setTab(event, tab) {
      this.setState({tab});
    }
    
    renderBody() {
      switch (this.state.tab) {
        case 0: {
          return (
            <ProfileTraining profileId={this.state.user.sub} />
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
      if (!this.state.user) return null;
      return (
        <div className="profile-page">
          <ProfileNavigation saveTrainings={this.saveTrainings} onTabChanged={this.setTab} {...this.state} />
          <ProfileBody>
            {this.renderBody()}
          </ProfileBody>
        </div>
      );
    }
  }
);