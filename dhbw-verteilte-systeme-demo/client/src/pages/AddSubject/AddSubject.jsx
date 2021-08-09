import axios from 'axios'
import React, { useState } from 'react'
import { Redirect } from 'react-router'

const AddSubject = () => {

    const [subject, setSubject] = useState("")
    const [redirect, setRedirect] = useState("")

    return (
        <>
            <div className="container">
                <div class="field">
                    <label class="label">Subject Name</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Text input" value={subject} onChange={(e) => {setSubject(e.target.value)}}/>
                    </div>
                </div>
                <div className="field">
                    <button className="button" onClick={() => {
                        axios.post(`${process.env.REACT_APP_SERVER}/api/subjects`,{
                            subject
                        }).then( () => setRedirect(" "))
                        
                    }}>Add</button>
                </div>
            </div>
            {
                redirect !== "" && <Redirect to={`/${redirect}`}/>
            }
        </>
    )
}

export default AddSubject
