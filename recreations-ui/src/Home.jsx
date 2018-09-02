import React from 'react';
import ReactDOM from 'react-dom';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Button from '@material-ui/core/Button';
import Profile from './profile';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import './index.styl';

export default class Home extends React.Component {
	render() {
		return (
      <React.Fragment>
        <CssBaseline />
        <Router>
          <div>
            <div className="navigation">
              <AppBar className="navigation" position="static">
                <Toolbar variant="dense">
                    <Link to="/"><Button variant="raised" color="primary" > Home </Button> </Link>
                    <Link to="/profile"><Button variant="raised" color="primary" > Profile </Button> </Link>
                    <Typography variant="title" color="inherit" className="title">
                     Title
                    </Typography>
                    <Button className="login" variant="raised" color="primary" >
                      Login
                    </Button>
                </Toolbar>
              </AppBar>
            </div>


          </div>
        </Router>
      </React.Fragment>
		);
	}
}
