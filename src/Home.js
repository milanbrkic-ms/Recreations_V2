import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import darkBaseTheme from 'material-ui/styles/baseThemes/darkBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import AppBar from 'material-ui/AppBar';
import FlatButton from 'material-ui/FlatButton';
import Profile from './profile';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

export default class Home extends React.Component {
	render() {
		return (
			<MuiThemeProvider>
				<Router>
					<div>
						<div className="navigation">
							<AppBar
								iconElementLeft={
									<div>
										<Link to="/"><FlatButton label="Home" /></Link>
										<Link to="/profile"><FlatButton label="Profile" /></Link>
									</div>
								}
								iconElementRight={<FlatButton label="Login"/>}
							/>
						</div>

						<Switch>
							<Route exact path="/" component={App}/>
							<Route exact path="/profile" component={Profile}/>
						</Switch>
					</div>
				</Router>
			</MuiThemeProvider>
		);
	}
}
const wrapper = document.getElementById("create-article-form");
wrapper ? ReactDOM.render(<Home />, wrapper) : false;
