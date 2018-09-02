import autobind from 'autobind-decorator';
import React from 'react';
import { Link } from 'react-router-dom';
import { withAuth } from '@okta/okta-react';
import LoginForm from '../login/LoginForm';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';

@autobind
export default withAuth(
    class Navigation extends React.Component {
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
  
      render() {
        if (this.state.authenticated === null) return null;

        const authNav = this.state.authenticated ? (
          <React.Fragment>
            <Link to="/home"><Button variant="raised" color="primary" > Home </Button> </Link>
            <Link to="/profile"><Button variant="raised" color="primary" > Profile </Button> </Link>
            <Typography variant="title" color="inherit" className="title">
              Recreations
            </Typography>
            <Button onClick={() => this.props.auth.logout()} className="login" variant="raised" color="primary" >
              Logout
            </Button>
          </React.Fragment>
        ) : (
          <React.Fragment>
            <Typography variant="title" color="inherit" className="title">
              Welcome to Recreations
            </Typography>
            <LoginForm baseUrl={this.props.baseUrl} />
          </React.Fragment>
        );
        return (
          <AppBar className="navigation" position="static">
            <Toolbar>
              {authNav}
            </Toolbar>
          </AppBar>
        )
      }
  }
);
