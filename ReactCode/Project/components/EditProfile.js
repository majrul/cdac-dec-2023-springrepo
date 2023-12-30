import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function EditProfile() {

    const params = useParams();

    const [userData,setUserData] = useState({
        id: '',
        name: '',
        profilePic: '',
        address: {
            id: '',
            city: '',
            pincode: ''
        }
    });

    useEffect(() => {
        axios.get(`http://localhost:8080/customer/fetch/${params.id}`).then((response => {
            setUserData(response.data);
        }))
    }, [params.id])

    function handleInput(event) {
        let name = event.target.name;
        let value = event.target.value;
        //code pending to update the state        
    }

    function update(event) {
        event.preventDefault();
        console.log(userData);
        let url = `http://localhost:8080/customer/update`;
        axios.post(url,userData).then((response) => {
            //setResponseData(response.data);
            if(response.data.status)
                alert("Done!");
            else
                alert("Not done!");
        })
    }

    return (
        (userData && <div>
            <form onSubmit={update}>
                ID : <input type="text" id="id" name="id" value={userData.id} onChange={handleInput} /> <br />
                Name : <input type="text" id="name" name="name" value={userData.name} onChange={handleInput} /> <br />
                City : <input type="text" id="address.city" name="address.city" value={userData.address.city} onChange={handleInput} /> <br />
                <button>Update</button>
            </form>
        </div>)
    )
}

export default EditProfile;