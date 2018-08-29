import PropTypes from 'prop-types'
import React, { Component } from 'react'
import { Button } from '@material-ui/core';

export default class EditProfile extends Component {
  render() {
    return (
      <div className="edit-profile">
        <Button autoCorrect />
      </div>
    )
  }
}
