import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Paper from '@material-ui/core/Paper';
import Tab from '@material-ui/core/Tab';
import Tabs from '@material-ui/core/Tabs';
import Typography from '@material-ui/core/Typography';
import '../style/navigation-bar.styl';

export default class ProfileNavigation extends React.Component {

  render() {
    return (
    <div className="profile-navigation-bar">
      <span className="wrapper">
        <Avatar
          classes={{
            root: 'picture'
          }}>
          {this.props.profile.name || 'M'}
        </Avatar>
        <span> {this.props.profile.name} </span>
        <Paper className="tabs-nav">
          <Tabs value={this.props.tab}
            onChange={this.props.onTabChanged}
            indicatorColor="primary">
            <Tab label="Home" />
            <Tab label="Edit" />
          </Tabs>
        </Paper>
      </span>    
    </div>
    );
  }
}