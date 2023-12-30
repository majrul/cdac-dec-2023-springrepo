import { Link } from "react-router-dom";

function Dashboard() {

    const customerId = sessionStorage.getItem('customerId');
    const name = sessionStorage.getItem('name');

    return (
        <div>
            <h1>Welcome back {name}</h1>
            <Link to={`/profile/${customerId}`}>View Profile</Link>
            |
            <Link to={`/editprofile/${customerId}`}>Edit Profile</Link>
        </div>
    )
}

export default Dashboard