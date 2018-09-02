import "babel-polyfill";
import { Security } from '@okta/okta-react';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import config from './app.config';
import App from './App';
import { MuiThemeProvider, createMuiTheme } from "@material-ui/core";
import { CssBaseline } from '@material-ui/core/CssBaseline';

// dev-552467.oktapreview.com - clientID 0oag4641w3ohIYqm00h7

function onAuthRequired({ history }) {
  history.push('/');
}
const theme = createMuiTheme({
  palette: {
    type: 'dark'
  }
});

ReactDOM.render(
  <Router>
    <Security 
      issuer={config.issuer}
      client_id={config.client_id}
      redirect_uri={config.redirect_uri}
      onAuthRequired={onAuthRequired}>
      <App />
    </Security>
  </Router>
  , document.getElementById('root')
);
