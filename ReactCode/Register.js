import axios from 'axios';
import {useState} from 'react';

export default function Register() {

    const [userData, setUserData] = useState({});
    const [responseData, setResponseData] = useState({});

    function handleInput(event) {
        let name = event.target.name;
        let value = event.target.value;
        setUserData(userData => {
            userData[name] = value;
            return userData;
        })        
    }

    function register(event) {
        event.preventDefault();
        console.log(userData);
        let url = `http://localhost:8080/register`;
        axios.post(url,userData).then((response) => {
            //console.log(response.data);
            setResponseData(response.data);
            if(response.data.status)
                alert("Done!");
            else
                alert("Not done!");
        })
    }

    return (
        <div>
            <h1>{responseData.customerId}</h1>
            <form onSubmit={register}>
                Name : <input type="text" name="name" onChange={handleInput} /> <br />
                Email : <input type="email" name="email" onChange={handleInput} /> <br />
                Password : <input type="password" name="password" onChange={handleInput} /> <br />
                Date of Birth : <input type="date" name="dateOfBirth" onChange={handleInput} /> <br />
                <button type="submit">Register</button>
            </form>
        </div>
      );
}