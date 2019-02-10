import React from 'react';
import DialogTitle from '@material-ui/core/DialogTitle';
import Dialog from '@material-ui/core/Dialog';
import { TextField, Table, TableBody, TableRow, TableCell, Checkbox, Button } from '@material-ui/core';
import TrainingService from '../services/TrainingService';
import autobind from 'autobind-decorator';
import SaveIcon from '@material-ui/icons/Save';

@autobind
export default class AddTrainingModal extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      selected: []
    }
    this.service = new TrainingService();
  }

  async componentDidMount() {
    this.trainings = await this.service.getAllTrainigs();
    this.forceUpdate();
  }
  
  save(e) {
    let selectedTrening = this.state.selected;
    this.props.saveTrainings(selectedTrening);
  }

  add(training) {
    let arr = this.state.selected;
    arr.push(training);
    this.setState({trainings: arr});
  }

  isSelected(id) {
    this.state.selected.indexOf(id) !== -1;
  }

  handleClick(event, id) {
    const { selected } = this.state;
    const selectedIndex = selected.indexOf(id);
    let newSelected = [];

    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selected, id);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selected.slice(1));
    } else if (selectedIndex === selected.length - 1) {
      newSelected = newSelected.concat(selected.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(
        selected.slice(0, selectedIndex),
        selected.slice(selectedIndex + 1),
      );
    }

    this.setState({ selected: newSelected });
  };

  render() {
    if (!this.trainings) {
      return null;
    }

    return (
      <Dialog onClose={this.props.handleDialogClose} aria-labelledby="simple-dialog-title" open={true}>
        <DialogTitle id="simple-dialog-title">Add training</DialogTitle>
        <Table>
          <TableBody>
            {this.trainings.map(t => {
              return (
                <TableRow 
                  hover
                  onClick={event => this.handleClick(event, t.treningId)}
                  role="checkbox" key={t.treningId}>
                  <TableCell padding="checkbox">
                    <Checkbox checked={this.isSelected(t.treningId)}/>
                  </TableCell>
                  <TableCell>{t.nazivTreninga}</TableCell>
                  <TableCell>{t.datum}</TableCell>
                  <TableCell>{t.vremeOd}</TableCell>
                  <TableCell>{t.vremeDo}</TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
        <Button variant="fab" aria-label="Save">
          <SaveIcon style={{position: "absolute", bottom: "10", right: "10"}}/>
      </Button>
      </Dialog>
    );
  }
}