import autobind from 'autobind-decorator';
import React from 'react'
import { Paper } from '@material-ui/core';
import loginImage from '../../images/login.jpg';
import { withAuth } from '@okta/okta-react';
import RegistrationForm from './RegistrationForm';
import {Redirect} from 'react-router-dom';
import './style/index.styl';

@autobind
export default withAuth(
  class Login extends React.Component {
    constructor(props) {
      super(props);
      this.state = { authenticated: null };
      this.checkAuthentication();
    }

    async checkAuthentication() {
      const authenticated = await this.props.auth.isAuthenticated();
      if (authenticated !== this.state.authenticated) {
        this.setState({ authenticated });
      }
    }

    componentDidUpdate() {
      this.checkAuthentication();
    }

    renderLogInBody() {
      return (
        <React.Fragment>
          <Paper className="login-body">
            <div className="left">
              <img src={loginImage} alt="Login image"/>
              <span className="helper" />
            </div>
            <div className="divider"/>
            <RegistrationForm />
          </Paper>
        </React.Fragment>
      )
    }

    render() {
      if (this.state.authenticated === null) return null;
      return (
        this.state.authenticated ? 
        <Redirect to={{pathname: '/profile'}} /> : 
        this.renderLogInBody()
      );
    }
  }
);
