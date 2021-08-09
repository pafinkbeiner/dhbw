import React, { useState, useEffect } from 'react'
import { Redirect } from 'react-router'
import axios from 'axios'

const AddTask = () => {

    const [name, setName] = useState("")
    const [description, setDescription] = useState("")
    const [expirationDate, setExpirationDate] = useState()
    const [subject, setSubject] = useState("")

    // subjects
    const [subjects, setSubjects] = useState([])


    const [redirect, setRedirect] = useState("")

    useEffect(() => {

        axios.get(`${process.env.REACT_APP_SERVER}/api/subjects`).then((res) => {
            setSubjects(res.data);
            // default set subject
            setSubject(res.data[0])
        });

    }, [])

    return (
        <>
            <div className="container">
                <div class="field">
                    <label class="label">Task Name</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Text input" value={name} onChange={(e) => {setName(e.target.value)}}/>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Description</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Text input" value={description} onChange={(e) => {setDescription(e.target.value)}}/>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Subject</label>
                    <div class="select">
                        <select onChange={(e) => setSubject(e.target.value)}>
                            {
                               subjects.length > 0 && subjects.map((s,i) => {
                                   return (
                                        <option key={i}>{s.subject}</option>
                                   )
                               }) 
                            }
                        </select>
                    </div>
                </div>

                <div class="field">
                    <label class="label">Date</label>
                    <div class="control">
                        <input class="input" type="date" placeholder="Text input" value={expirationDate} onChange={(e) => {setExpirationDate(e.target.value)}}/>
                    </div>
                </div>

                <div className="field">
                    <button className="button" onClick={() => {

                        axios.post(`${process.env.REACT_APP_SERVER}/api/tasks`,{
                            name,
                            description,
                            expirationDate,
                            subject,
                            done: false
                        }).then( () => setRedirect(" ")).catch(() => setRedirect("error"))
                    }}>Add</button>
                </div>
            </div>
            {
                redirect !== "" && <Redirect to={`/${redirect}`}/>
            }
        </>
    )
}

export default AddTask
