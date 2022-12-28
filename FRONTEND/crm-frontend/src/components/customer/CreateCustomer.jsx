import React, { useEffect, useState } from "react";
import StyleCustomer from "./StyleCustomer.css"
import Axios from 'axios'
import {Navigate, useNavigate } from "react-router-dom";



function CreateCustomer(){

    const navigater = useNavigate();
    const home = () => {
        navigater('/home/')
    }

    const [customerBody, setCustomerBody] = useState({
        idCustomer: null,
        customerName:'',
        customerPhone:'',
        customerEmail:''
    })

  
function submit(e){
    e.preventDefault();
    Axios.post('http://localhost:8085/customer', {
        customerName: customerBody.customerName,
        customerPhone: customerBody.customerPhone,
        customerEmail: customerBody.customerEmail
    })
    .then(res => {
        window.location.href='http://localhost:3000/home'})
    }
        
        


function handle(e) {
    const newCustomerBody = {...customerBody}
    newCustomerBody[e.target.id] = e.target.value
    setCustomerBody(newCustomerBody)
}

    return (
        <div class="form">
            <h1>CUSTOMER</h1>
                <div class="customer">
                    
                <form onSubmit={(e) => submit(e)}>
                    
                        <input id="idCustomer" type="hidden"/> 
                        <br/>
                        <input id="customerName" type="text" placeholder="Name" value={customerBody.customerName} onChange={e => handle(e)}/> 
                        <br/>
                        <input id="customerPhone" type="tel" placeholder="Phone" value={customerBody.customerPhone} onChange={e => handle(e)}/> 
                        <br/>
                        <input id="customerEmail" type="email" placeholder="Email" value={customerBody.customerEmail} onChange={e => handle(e)}/> 
                        <br/>    
                        <input type="submit" class="myButtonCreate" value="Create Customer" />
                        <br/>    
                        <button class="myButtonCancel" onClick={home}>Cancel</button>
                </form>
              
                </div>
               
        </div>

    )

}

export default CreateCustomer;