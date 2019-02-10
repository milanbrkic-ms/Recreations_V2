import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import AddIcon from '@material-ui/icons/Add';
import Paper from '@material-ui/core/Paper';
import Tab from '@material-ui/core/Tab';
import Tabs from '@material-ui/core/Tabs';
import '../style/navigation-bar.styl';
import { Button } from '@material-ui/core';
import AddTrainingModal from '../../common/AddTrainingModal';
import autobind from 'autobind-decorator';

@autobind
export default class ProfileNavigation extends React.Component {
  constructor(props) {
    super(props);

    this.state = {};
  }
  
  openDialog() {
    this.setState({openedDialog: true});
  }

  async saveTrainings(trainings) {
    await this.props.saveTrainings(trainings);
    this.handleDialogClose();
  }

  handleDialogClose() {
    this.setState({openedDialog: false});
  }
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
            <Tab label="My Trainings" />
            <Button 
              style={{width: "30px", height:"15px", marginLeft: "-25px", marginTop: "5px"}}
              variant="fab"
              color="primary" 
              aria-label="Add" onClick={this.openDialog}>
                +
            </Button>
            <Tab label="Edit" />
          </Tabs>
        </Paper>
        {this.state.openedDialog && 
        <AddTrainingModal saveTrainings={this.saveTrainings} open={this.state.openedDialog}/>}
      </span>    
    </div>
    );
  }
}