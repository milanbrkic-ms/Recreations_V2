import React from 'react';
import PersonService from '../services/PersonService';
import ProfileNavigation from './components/ProfileNavigation';
import ProfileBody from './components/ProfileBody';
import './style/profile.styl';
import { withAuth } from '@okta/okta-react';
import autobind from 'autobind-decorator';

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

    async componentDidMount() {
      // retrieve profile
      this.props.auth.getUser().then(user => this.setState({ user }));
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
      if (!this.state.user) return null;
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
);