import React from 'react'
import {Link, NavLink} from "react-router-dom"

const Navbar = () => {
    return (
        <nav className="navbar" role="navigation" aria-label="main navigation">
            <div className="navbar-brand">
                <Link className="navbar-item" href="https://bulma.io" to="/">
                    <b><p>Studienplan</p></b>
                </Link>
            </div>

            <div id="navbarBasicExample" className="navbar-menu">
                <div className="navbar-start">

                <NavLink className="navbar-item" to="/addTask">
                    Add Task
                </NavLink>

                <NavLink className="navbar-item" to="/addSubject">
                    Add Subject
                </NavLink>

                </div>
            </div>
        </nav>
    )
}

export default Navbar
