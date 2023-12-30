import { Link } from "react-router-dom"
import './Navbar.css'

export default function Navbar() {

    return (
        <div className="topnav">
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
        </div>
    )

}