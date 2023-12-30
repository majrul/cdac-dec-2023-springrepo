function Confirmation() {

    const customerId = sessionStorage.getItem('customerId');

    return (
        <div>
            <h1>Registration Done!</h1>
            <h2>Your registered customer id is : {customerId} </h2>
        </div>
    )
}

export default Confirmation