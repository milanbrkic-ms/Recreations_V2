import React from 'react'
import Navigation from './common/Navigation';
import Profile from './profile';
import { Route } from 'react-router-dom';
import { ImplicitCallback, SecureRoute } from '@okta/okta-react';
import Login from './login/Login';
import config from './app.config';

export default class App extends React.Component {
  render() {
    return (
      <div>
        <Navigation baseUrl={config.url}/>
        <main>
          <Route path="/" exact render={() => <Login baseUrl={config.url} />} />
          <SecureRoute path="/profile" exact component={Profile} />
          <Route path="/implicit/callback" component={ImplicitCallback} />
        </main>
      </div>
    )
  }
}
