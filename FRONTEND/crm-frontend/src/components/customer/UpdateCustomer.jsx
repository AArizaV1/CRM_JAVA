import React, { useState } from "react";
import Axios from 'axios'
import { useNavigate, useParams } from "react-router-dom";
import { useEffect } from "react";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';



function UpdateCustomer(){

    const {idCustomer} = useParams();

    const navigater = useNavigate();
    
    const [customerBody, setCustomerBody] = useState({
        idCustomer: Number(idCustomer),
        customerName: '',
        customerPhone:'',
        customerEmail:''
    })

    const home = () => {
        navigater('/home/') 
    }

    useEffect(() => {
        fetch(`http://localhost:8085/customer/${idCustomer}`)
            .then(res => res.json())
            .then(json => {
                setCustomerBody(json)
            })
    }, [])


  
    function submit(e){
        e.preventDefault();
        Axios.put('http://localhost:8085/customer/' + customerBody.idCustomer, {
            idCustomer: customerBody.idCustomer,
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
            <h1>UPDATE CUSTOMER</h1>
                <form onSubmit={(e) => submit(e)}>
                        <TextField id="idCustomer" label="idCustomer" variant="standard" type="hidden"/> 
                        <br/>
                        <TextField id="customerName" type="text" label="Name" variant="standard" value={customerBody.customerName} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="customerPhone" type="tel" label="Phone" variant="standard" value={customerBody.customerPhone} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="customerEmail" type="email" label="Email" variant="standard" value={customerBody.customerEmail} onChange={e => handle(e)}/> 
                        <br/>    
                        <Button type="submit" variant="contained" color="info" > UPDATE CUSTOMER </Button> 
                        <br/>    
                        <Button type="button" variant="contained" color="error" onClick={home} > CANCELAR </Button>
                        <br/>
                </form>
                </CardContent> 
            </Card>
               
        </div>

    )

}

export default UpdateCustomer;