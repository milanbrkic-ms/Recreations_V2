import React from 'react';
import logo from './logo.svg';
import './App.css';

class App extends React.Component {
  render() {
    return (
    	<div>

				<div className="App">
					<header className="App-header">
						<img src={logo} className="App-logo" alt="logo" />
						<h1 className="App-title">Welcome to React</h1>
					</header>
					<p className="App-intro">
						To get started, edit <code>src/App.js</code> and save to reload.
					</p>
				</div>
			</div>
    );
  }
}

export default App;
