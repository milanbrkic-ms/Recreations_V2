import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Tab from '@material-ui/core/Tab';
import Tabs from '@material-ui/core/Tabs';
import Paper from '@material-ui/core/Paper';
import '../style/profile-body.styl';

export default class ProfileBody extends React.Component {

  render() {
    // TODO: make some kind of layout
    return (
    <div className="profile-body">
      {React.Children.map(this.props.children, (child) => React.cloneElement(child))}
    </div>)
  }
}