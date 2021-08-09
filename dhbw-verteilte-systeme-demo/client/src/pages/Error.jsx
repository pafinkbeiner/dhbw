import React, { useState, useEffect } from 'react'
import { Redirect } from 'react-router'

const Error = () => {

    const [redirect, setRedirect] = useState("")

    useEffect(() => {

        setTimeout(() => {setRedirect(" ")}, 1000)


    }, [])

    return (
        <div>

            <h1 style={{fontSize: "5rem", color: "red"}}>Error while adding element!!</h1>
                        
                        
            {
                redirect !== "" && <Redirect to={`/${redirect}`}/>
            }
        </div>
    )
}

export default Error
