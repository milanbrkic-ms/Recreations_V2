import React from 'react';
import PersonService from '../../services/PersonService';
import { Paper, Table, TableBody, TableCell, TableRow, TableHead } from '@material-ui/core';
import '../style/profile-training';

export default class ProfileTraining extends React.Component {
    constructor(props) {
        super(props);
      this.personService = new PersonService();
    }
    async componentDidMount() {
        this.trainings = await this.personService.getTrainings(this.props.profileId);
        this.forceUpdate();
    }

    renderTraining(training, index) {
        return (
            <Paper style={{margin: "20px 0"}}>
                <div className="training">
                    <div className="header">
                        {training.vremeOd}
                        <span className="divider" />
                        {training.vremeDo}
                    </div>
                    <div className="datum">{training.datum}</div>
                    <div className="temp">
                        <div className="sport">{training.sport.naziv}</div>
                        <div>{`Availability ${training.clanovi.length}/${training.sport.maxBrClanova}`}</div>
                    </div>
                    <div className="content">
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell>Name</TableCell>
                                    <TableCell numeric>Sex</TableCell>
                                    <TableCell numeric>Height (cm)</TableCell>
                                    <TableCell numeric>Weight (kg)</TableCell>
                                    <TableCell numeric>Rating</TableCell>
                                    <TableCell numeric>Stamina</TableCell>
                                    <TableCell numeric>City</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {training.clanovi.map(c => {
                                    return (
                                        <TableRow key={c.idOsoba}>
                                            <TableCell>{c.name}</TableCell>
                                            <TableCell>{c.pol}</TableCell>
                                            <TableCell>{c.height}</TableCell>
                                            <TableCell>{c.weight}</TableCell>
                                            <TableCell>{c.rating}</TableCell>
                                            <TableCell>{c.stamina}</TableCell>
                                            <TableCell>{c.city.name}</TableCell>
                                        </TableRow>
                                    );
                                })}
                            </TableBody>
                        </Table>
                    </div>
                </div>
            </Paper>
        );
    }

    render() {
        if (!this.trainings) {
            return null;
        }
        
        return (
            <div className="trainings-body">
                {this.trainings.map(this.renderTraining)}
            </div>
        );
    }
}