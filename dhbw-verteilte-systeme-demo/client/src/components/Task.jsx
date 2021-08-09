import axios from "axios";
import Modal from "./Modal";
import React, { Component } from "react";

export default class Task extends Component {
  constructor(props) {
    super(props);
    this.state = {
      task: this.props.task,
      modalState: false,
    };

    this.toggleModal = this.toggleModal.bind(this);
    this.toggleDone.bind(this);
  }

  toggleModal() {
    this.setState((prev, props) => {
      const newState = !prev.modalState;

      return { modalState: newState };
    });
  }

  toggleDone(finished) {
    axios
      .put(`${process.env.REACT_APP_SERVER}/api/tasks`, {
        id: this.state.task.id,
        name: this.state.task.name,
        timestamp: this.state.task.timestamp,
        description: this.state.task.description,
        expirationDate: this.state.task.expirationDate,
        subject: this.state.task.subject,
        done: finished,
      })
      .then(() => {
        window.location.reload();
      });
  }

  render() {
    return (
      <>
        <div className="column">
          <div className="card" 
            style={ this.state.task.done ? {backgroundColor: "#ccffdd"} : {backgroundColor: "white"} } >
            <div className="card-header">
              <div className="card-header-title">{this.state.task.name}</div>
              {this.state.task.done && (
                <span class="icon">
                  <i class="fas fa-check"></i>
                </span>
              )}
            </div>
            <div className="card-content">
              <p>{this.state.task.description}</p>
              <br />
              <p>
                {new Date(this.state.task.expirationDate)
                  .getUTCDate()
                  .toString()}
                .
                {(
                  new Date(this.state.task.expirationDate).getUTCMonth() + 1
                ).toString()}
                .
                {new Date(this.state.task.expirationDate)
                  .getFullYear()
                  .toString()}
              </p>
              <br />
              <button className="button is-primary" onClick={this.toggleModal}>
                Edit
              </button>
              <button
                className="button is-link"
                onClick={(e) => {
                  axios
                    .delete(
                      `${process.env.REACT_APP_SERVER}/api/tasks/${this.state.task.id}`
                    )
                    .then(() => {
                      window.location.reload();
                    });
                }}
              >
                Delete
              </button>
              {this.state.task.done ? (
                <button
                  className="button is-danger"
                  onClick={(e) => {
                    this.toggleDone(false);
                  }}
                >
                  Undone
                </button>
              ) : (
                <button
                  className="button is-danger"
                  onClick={(e) => {
                    this.toggleDone(true);
                  }}
                >
                  Done
                </button>
              )}
            </div>
          </div>
        </div>

        <Modal
          closeModal={this.toggleModal}
          modalState={this.state.modalState}
          task={this.state.task}
        ></Modal>
      </>
    );
  }
}
