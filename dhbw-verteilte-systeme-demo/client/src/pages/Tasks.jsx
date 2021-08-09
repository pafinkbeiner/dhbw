import axios from "axios";
import React, { Component } from "react";
import Task from "../components/Task";

export default class Tasks extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tasks: [],
    };
  }

  componentDidMount() {
    axios.get(`${process.env.REACT_APP_SERVER}/api/tasks`).then((res) => {
      this.setState({
        tasks: res.data.filter((item) => item.subject === this.props.name),
      });
    });
  }

  render() {
    console.log(this.props.name);
    return (
      <div>
        <div className="columns">
          {this.state.tasks.length > 0 &&
            this.state.tasks.map((task, i) => {
              return <Task task={task} key={i} />;
            })}
        </div>
      </div>
    );
  }
}
