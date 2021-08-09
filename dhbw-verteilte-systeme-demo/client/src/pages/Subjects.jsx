import React, { Component } from "react";
import axios from "axios";
import Tasks from "./Tasks";

export default class Subjects extends Component {
  constructor(props) {
    super();
    this.state = {
      subjects: [],
    };
  }

  componentDidMount() {
    axios.get(`${process.env.REACT_APP_SERVER}/api/subjects`).then((res) => {
      this.setState({ subjects: res.data });
    });
  }

  render() {
    return (
      <div className="container">
        {this.state.subjects.map((subject, i) => {
          return (
            <div key={i}>
              <br />
              <div className="row">
                <h1 className="title">{subject.subject}</h1>
                <button className="button is-link" onClick={() => {
                  axios.delete(`${process.env.REACT_APP_SERVER}/api/subjects/${subject.id}`).then(() => {window.location.reload();})
                }}>Delete</button>
              </div>
              <br />
                <Tasks name={subject.subject}></Tasks>
            </div>
          );
        })}
      </div>
    );
  }
}
