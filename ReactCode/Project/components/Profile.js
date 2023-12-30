import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function Profile() {

    const params = useParams();

    const [userData,setUserData] = useState({
        id: '',
        name: '',
        profilePic: '',
        address: {
            city: '',
            pincode: ''
        }
    });

    //useEffect(() => { }, [stateVariable]); the side effect will run whenever the state changes
    //useEffect(() => {}, []); //use this technique if in your component you want some code to run only once

    useEffect(() => {
        axios.get(`http://localhost:8080/customer/fetch/${params.id}`).then((response => {
            //console.log(response);
            //console.log(response.data);
            setUserData(response.data);
        }))
    }, [params.id])
   

    return (
        (userData && <div>
            ID : {userData.id} <br />
            Name : {userData.name} <br />
            City : {userData.address.city} <br />
            ProfilePic : <img src={`http://localhost:8080/customer/fetch/profilePic/${userData.id}`} />
        </div>)
    )
}

export default Profile;