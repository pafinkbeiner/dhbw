import React, { useState, useEffect } from "react";
import axios from "axios";
import { Redirect } from "react-router";

const Modal = ({ children, closeModal, modalState, task }) => {
  const [name, setName] = useState(task.name);
  const [description, setDescription] = useState(task.description);
  const [expirationDate, setExpirationDate] = useState(task.expirationDate);
  const [subject, setSubject] = useState(task.subject);
  const [id] = useState(task.id);
  const [timestamp] = useState(task.timestamp);

  // subjects
  const [subjects, setSubjects] = useState([]);

  const [redirect, setRedirect] = useState(false);

  useEffect(() => {
    axios.get(`${process.env.REACT_APP_SERVER}/api/subjects`).then((res) => {
      setSubjects(res.data);
      // default set subject
      setSubject(res.data[0]);
    });
  }, []);

  if (!modalState) {
    return null;
  }

  return (
    <div className="modal is-active">
      <div className="modal-background" onClick={closeModal} />
      <div className="modal-card">
        <header className="modal-card-head">
          <p className="modal-card-title">Edit Task</p>
        </header>
        <section className="modal-card-body">
          <div className="field">
            <label className="label">Task Id</label>
            <div class="control">
              <input
                class="input"
                type="text"
                placeholder={id}
                disabled
              ></input>
            </div>
          </div>

          <div className="field">
            <label className="label">Task Name</label>
            <div className="control">
              <input
                className="input"
                type="text"
                placeholder="Text input"
                value={name}
                onChange={(e) => {
                  setName(e.target.value);
                }}
              />
            </div>
          </div>

          <div className="field">
            <label className="label">Description</label>
            <div className="control">
              <input
                className="input"
                type="text"
                placeholder="Text input"
                value={description}
                onChange={(e) => {
                  setDescription(e.target.value);
                }}
              />
            </div>
          </div>

          <div className="field">
            <label className="label">Subject</label>
            <div className="select">
              <select onChange={(e) => setSubject(e.target.value)}>
                {subjects.length > 0 &&
                  subjects.map((s, i) => {
                    return <option key={i}>{s.subject}</option>;
                  })}
              </select>
            </div>
          </div>

          <div className="field">
            <label className="label">Date</label>
            <div className="control">
              <input
                className="input"
                type="date"
                value={expirationDate}
                onChange={(e) => {
                  setExpirationDate(e.target.value);
                }}
              />
            </div>
          </div>

          <div className="field">
            <button
              className="button"
              onClick={() => {
                axios
                  .put(`${process.env.REACT_APP_SERVER}/api/tasks`, {
                    id,
                    name,
                    timestamp,
                    description,
                    expirationDate,
                    subject: subject.subject,
                    done: false,
                  })
                  .then(() => {
                    window.location.reload();
                    closeModal();
                  })
                  .catch(() => setRedirect("error"));
              }}
            >
              Save
            </button>
          </div>
        </section>
        <footer className="modal-card-foot">
          <button className="button" onClick={closeModal}>
            Cancel
          </button>
        </footer>
      </div>
      {redirect !== "" && <Redirect to={`/${redirect}`} />}
    </div>
  );
};

export default Modal;
