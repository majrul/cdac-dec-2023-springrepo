import { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";

function Login3() {
    
    const history = useHistory();

    const [errorMessage, setErrorMessage] = useState();

    const [loginData, setLoginData] = useState({
        email: '',
        password: ''
    })

    function handleInput(event) {
        setLoginData(prevData => {
            return {
                ...prevData,
                [event.target.name] : event.target.value
            }
        })        
    }

    function login(event) {
        event.preventDefault();
        axios.post('http://localhost:8080/customer/login', loginData).then((response => {
            console.log(response);
            console.log(response.data);
            if(response.data.status) {
                sessionStorage.setItem('customerId', response.data.customerId);
                sessionStorage.setItem('name', response.data.name);
                history.push('/dashboard')
            }
            else {
                setErrorMessage(response.data.messageIfAny);
            }
        }))
    }

    return (
        <div>
            {errorMessage && <h1>{errorMessage}</h1>}
            <form onSubmit={login}>
                <div className="form-group">
                    <label>Email Address</label>
                    <input type="email" name="email" className="form-control" onChange={handleInput} />
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input type="password" name="password" className="form-control" onChange={handleInput} />
                </div>
                <button className="btn btn-primary">Login</button>
            </form>
        </div>
    )
}

export default Login3