import axios from 'axios';
import {useState} from 'react';

export default function Pnr() {

    var pnrNo;
    const [pnrStatus, setPnrStatus] = useState({}); 

    function handleInput(event) {
        pnrNo = event.target.value;
    }

    function checkStatus(event) {
        event.preventDefault();
        //alert(pnrNo);
        //let url = 'http://localhost:8080/spring-mvc/pnr-status?pnrNo='+pnrNo;
        let url = `http://localhost:8080/spring-mvc/pnr-status?pnrNo=${pnrNo}`;
        axios.get(url).then((response) => {
            //console.log(response.data);
            setPnrStatus(response.data);
        })
    }

    return (
        <div>
            <form onSubmit={checkStatus}>
                <h2>Welcome to Breakmytrip.com</h2>
                Enter PNR No : <input type="number" onChange={handleInput} /> <br />
                <button type="submit">Check Status</button>
            </form>
            <div>
                <h2>PNR Status</h2>
                PNR No : {pnrStatus.pnrNo} <br />
                Train No : {pnrStatus.trainNo} <br />
                TravelDate : {pnrStatus.travelDate} <br />
                { /*Write the code to iterate over passengers and display the details*/ }
            </div>
        </div>
      );
}