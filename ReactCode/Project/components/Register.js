import { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";

function Register() {
    
    const history = useHistory();

    const [errorMessage, setErrorMessage] = useState();

    const [userData, setUserData] = useState(new FormData());

    function handleUserInput(event) {
        let name = event.target.name;
        let value = event.target.value;
        if(event.target.type == 'file')
        value = event.target.files[0];
        setUserData(formData => {
            formData.set(name, value);
            return formData;
        })        
    }

    function register(event) {
        event.preventDefault();
        axios.post('http://localhost:8080/customer/registerv3', userData).then((response => {
            console.log(response);
            console.log(response.data);
            if(response.data.status) {
                sessionStorage.setItem('customerId', response.data.customerId);
                history.push('/confirmation')
            }
            else {
                setErrorMessage(response.data.messageIfAny);
            }
        }))
    }

    return (
        <div>
            {errorMessage && <h1>{errorMessage}</h1>}
            <form onSubmit={register}>
                <div className="form-group">
                    <label>Name</label>
                    <input type="text" name="name" className="form-control" onChange={handleUserInput} />
                </div>
                <div className="form-group">
                    <label>Profile Pic</label>
                    <input type="file" name="profilePic" className="form-control" onChange={handleUserInput} />
                </div>
                <div className="form-group">
                    <label>Email Address</label>
                    <input type="email" name="email" className="form-control" onChange={handleUserInput} />
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input type="password" name="password" className="form-control" onChange={handleUserInput} />
                </div>
                <div className="form-group">
                    <label>Pincode</label>
                    <input type="number" name="address.pincode" className="form-control" onChange={handleUserInput} />
                </div>
                <div className="form-group">
                    <label>City</label>
                    <input type="text" name="address.city" className="form-control" onChange={handleUserInput} />
                </div>
                <div className="form-group">
                    <label>State</label>
                    <input type="text" name="address.state" className="form-control" onChange={handleUserInput} />
                </div>
                <button className="btn btn-primary">Signup</button>
            </form>
        </div>
    )
}

export default Register