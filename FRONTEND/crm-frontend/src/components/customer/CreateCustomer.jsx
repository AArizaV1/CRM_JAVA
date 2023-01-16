import React, { useState } from "react";
import Axios from 'axios'
import { useNavigate } from "react-router-dom";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';


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
        <div className="form">
            <Card sx={{ minWidth: 275,
                        maxWidth: 450,
                        margin: "auto" }}>
                <CardContent>    
            <h1>CREATE CUSTOMER</h1>
                <form onSubmit={(e) => submit(e)}>
                    
                        <TextField id="idCustomer" label="idOpportunity" variant="standard" type="hidden"/> 
                        <br/>
                        <TextField id="customerName" type="text" label="Name" variant="standard" value={customerBody.customerName} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="customerPhone" type="tel" label="Phone" variant="standard" value={customerBody.customerPhone} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="customerEmail" type="email" label="Email" variant="standard" value={customerBody.customerEmail} onChange={e => handle(e)}/> 
                        <br/>    
                        <Button type="submit" variant="contained" color="info" > CREATE CUSTOMER </Button>
                        <br/>    
                        <Button type="button" variant="contained"  color="error" onClick={home} > CANCELAR </Button>
                        <br/>
                </form>
                </CardContent> 
            </Card>
               
        </div>

    )

}

export default CreateCustomer;