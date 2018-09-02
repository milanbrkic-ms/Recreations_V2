import React from 'react';
import OktaAuth from '@okta/okta-auth-js';
import { withAuth } from '@okta/okta-react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import autobind from 'autobind-decorator';
import Snackbar from '@material-ui/core/Snackbar';
import SnackbarContent from '@material-ui/core/SnackbarContent';

@autobind
export default withAuth(
  class LoginForm extends React.Component {
    constructor(props) {
      super(props);
      this.state ={
        sessionToken: null,
        error: null,
        username: '',
        password: ''
      }

      this.oktaAuth = new OktaAuth({url: props.baseUrl});
    }

    login(e) {
      e.preventDefault();
      this.oktaAuth.signIn({
          username: this.state.username,
          password: this.state.password
        }).then(res =>
          this.setState({
            sessionToken: res.sessionToken
          })
        ).catch(err => {
          this.setState({ error: err.message });
          console.log(err.statusCode + ' error', err);
        });
    }

    change(type, value) {
      this.setState({
        [type]: value
      });
    }

    handleClose() {
      this.setState({error: null});
    }

    render() {
      if (this.state.sessionToken) {
        this.props.auth.redirect({ sessionToken: this.state.sessionToken });
        return null;
      }

      const error = this.state.error ? (
        <Snackbar
          autoHideDuration={3000}
          anchorOrigin={{ vertical: 'top', horizontal: 'center' }}
          open={!!this.state.error}
          onClose={this.handleClose}>
          <SnackbarContent style={{backgroundColor: 'red'}} message={<span id="message-id">{this.state.error}</span>} />
        </Snackbar>
      ) : null;

      return (
        <React.Fragment>
          {error}
          <TextField 
            onChange={(e) => this.change('username', e.target.value)}
            className="input" 
            id="username-input" 
            label="Username" 
            margin="dense"/>
          <TextField 
            onChange={(e) => this.change('password', e.target.value)} 
            className="input" 
            id="password-input" 
            label="Password" 
            type="password" 
            autoComplete="current-password" />
          <Button onClick={this.login} className="login" variant="raised" color="primary" >
            Login
          </Button>
        </React.Fragment>
      )
    }
  }
)