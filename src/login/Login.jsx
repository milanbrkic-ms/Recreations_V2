import React, { Component } from 'react'
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import AppBar from '@material-ui/core/AppBar';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { TextField, Input, Paper } from '@material-ui/core';
import { MuiThemeProvider, createMuiTheme } from '@material-ui/core/styles';
import './style/index.styl';
import loginImage from '../../images/login.jpg';

const theme = createMuiTheme({
  palette: {
    type: 'dark'
  }
});
export default class Login extends Component {
  constructor() {
    super();
    this.state = {
      username: '',
      password: ''
    };
    this.login = this.login.bind(this);
    this.change = this.change.bind(this);
  }

  change(type, value) {
    this.setState({
      [type]: value
    });
  }

  login() {
    let {username, password} = this.state;
    console.log(`Username: ${username} and password: ${password}`);
  }

  render() {
    return (
      <MuiThemeProvider theme={theme}>
        <CssBaseline />
        <AppBar className="navigation" position="static">
          <Toolbar variant="dense">
              <Typography variant="title" color="inherit" className="title">
                Welcome to Recreations
              </Typography>
              <TextField onChange={(e) => this.change('username', e.target.value)} className="input" id="username-input" label="Username" margin="dense"/>
              <TextField onChange={(e) => this.change('password', e.target.value)} className="input" id="password-input" label="Password" type="password" 
                autoComplete="current-password" />
              <Button onClick={this.login} className="login" variant="raised" color="primary" >
                Login
              </Button>
          </Toolbar>
        </AppBar>
          <Paper className="login-body">
            <div className="left">
              <img src={loginImage} alt="Login image"/>
              <span className="helper" />
            </div>
            <div className="divider"/>
          </Paper>
      </MuiThemeProvider>
    );
  }
}
