import React from 'react'
import { withAuth } from '@okta/okta-react';
import OktaAuth from '@okta/okta-auth-js';
import config from '../app.config';
import autobind from 'autobind-decorator';
import TextField from '@material-ui/core/TextField';
import CitiesSelect from './../common/CitiesSelect';
import Button from '@material-ui/core/Button';
import UserService from './../services/UserService';
import {DateFormatInput} from 'material-ui-next-pickers'
import moment from 'moment';

const EMAIL_REGEX = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
const PASS_REGEX = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;

@autobind
export default withAuth(
  class RegistrationForm extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        name: '',
        surname: '',
        email: '',
        password: '',
        sessionToken: '',
        date: new Date
      }
      this.userService = new UserService();
      this.oktaAuth = new OktaAuth({url: config.url});
      this.checkAuthentication();
    }

    async checkAuthentication() {
      const sessionToken = await this.props.auth.getIdToken();
      if (sessionToken) {
        this.setState({ sessionToken });
      }
    }

    componentDidUpdate() {
      this.checkAuthentication();
    }

    isInvalidPassword(pass) {
      if (!pass.match(PASS_REGEX)) {
        return true;
      }
      let temp = this.state.email.split('@')[0];
      if (temp && pass.toLowerCase().includes(temp)) {
        return true;
      }
      return false;
    }

    isInvalidEmail(email) {
      return !email.match(EMAIL_REGEX);
    }

    getUser() {
      return {
        username: this.state.email,
        name: this.state.name,
        surName: this.state.surname,
        password: this.state.password,
        city: this.state.city
      };
    }

    change(type, value) {
      if (type === 'password') {
        if (this.isInvalidPassword(value)) {
          this.setState({invalidPassword: true});
        } else {
          this.setState({invalidPassword: false});
        }
      }
      if (type === 'email') {
        if (this.isInvalidEmail(value)) {
          this.setState({invalidEmail: true});
        } else {
          this.setState({invalidEmail: false});
        }
      }
      this.setState({
        [type]: value
      });
    }

    async singUp(e) {
      e.preventDefault();
      try {
        let user = await fetch('http://localhost:3001/users', {
          method: 'POST',
          headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.state)
        });
        let res = await this.oktaAuth.signIn({
          username: this.state.email,
          password: this.state.password
        });
        this.setState({
          sessionToken: res.sessionToken
        });
        await this.userService.addUser({
          username: res.user.profile.login,
          person: {
            idOsoba: res.user.id,
            ime: res.user.profile.firsName,
            prezime: res.user.profile.lastName,
            datumRodjenja: moment(this.state.date).format('yyyy-mm-dd')
          }
        });
      } catch (e) {
        this.setState({error: e.message});
      }
    }

    render() {
      if (this.state.sessionToken) {
        this.props.auth.redirect({ sessionToken: this.state.sessionToken });
        return null;
      }

      return (
        <div>
          <form className="sing-up-form">
            <TextField 
              required
              onChange={(e) => this.change('name', e.target.value)}
              id="name"
              label="Name"
              margin="normal" />
            <TextField 
              required
              onChange={(e) => this.change('surname', e.target.value)}
              id="surname" 
              label="Surname" 
              margin="normal" />
            <TextField 
              required
              error={this.state.invalidEmail}
              onChange={(e) => this.change('email', e.target.value)}
              id="email" 
              label="Email" 
              margin="normal" />
            <TextField 
              required
              error={this.state.invalidPassword}
              onChange={(e) => this.change('password', e.target.value)}
              id="password" 
              label="Password" 
              type="password" 
              autoComplete="current-password"
              margin="normal"/>
            <TextField
              id="date"
              label="Birthday"
              type="date"
              onChange={(e) => this.change('date', e.target.value)}
              defaultValue="2017-05-24" />
            <Button disabled={this.state.invalidPassword || this.state.invalidEmail} onClick={this.singUp}>
              Sing up
            </Button>            
          </form>
        </div>
      )
    }
  }
);
