import React, { useState, useEffect } from "react";
import {useNavigate, useParams} from 'react-router-dom'
import Axios from 'axios'
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';


function UpdateOpportunity() {

    const {idOpportunity} = useParams();

    const navigater = useNavigate(); 

    const [opportunityBody, setOpportunityBody] = useState({
        idOpportunity: Number(idOpportunity),
        opportunityName: '',
        opportunityPhone:'',
        opportunityEmail:'',
        idCustomer: ''
        
})


    const home = () => {
        navigater('/home/')
    }

    useEffect(() => {
        fetch('http://localhost:8085/opportunity/' + idOpportunity)
            .then(res => res.json())
            .then(json => {
                setOpportunityBody(json)
                console.log(json);
            })
    }, [])

    function submit(e){
        e.preventDefault();
        Axios.put('http://localhost:8085/opportunity/' + opportunityBody.idOpportunity, {
            idOpportunity: opportunityBody.idOpportunity,
            opportunityName: opportunityBody.opportunityName,
            opportunityPhone: opportunityBody.opportunityPhone,
            opportunityEmail: opportunityBody.opportunityEmail,
            idCustomer: opportunityBody.idCustomer
        })
        .then(console.log(opportunityBody))
        .then(res => {
            window.location.href='http://localhost:3000/home'})
    }


    function handle(e) {
        const newOpportunityBody = {...opportunityBody, [e.target.id]: e.target.value}
        console.log(newOpportunityBody);
        setOpportunityBody(newOpportunityBody)
    }


    function handleIdCustomer(e) {
        const newCustomer = Number(e.target.value)
        const newOpportunityBody = {...opportunityBody, idCustomer: newCustomer}
        setOpportunityBody(newOpportunityBody)
    }

    
    return (
        <div className="form">
            <Card sx={{ minWidth: 275,
                        maxWidth: 450,
                        margin: "auto" }}>
                <CardContent> 
            <h1>UPDATE OPPORTUNITY</h1>
                <form onSubmit={(e) => submit(e)}>   
                        <TextField id="opportunityName" type="text" plabel="Name" variant="standard" value={opportunityBody.opportunityName} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="opportunityPhone" type="tel" label="Phone" variant="standard" value={opportunityBody.opportunityPhone} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="opportunityEmail" type="email" label="Email" variant="standard" value={opportunityBody.opportunityEmail} onChange={e => handle(e)}/> 
                        <br/>    
                        <TextField id="idCustomer" type="text" label="ID Customer" variant="standard" value={opportunityBody.idCustomer} onChange={e => handleIdCustomer(e)}/> 
                        <br/>    
                        <Button type="submit" variant="contained" color="info"> UPDATE OPPORTUNITY </Button>
                        <br/>    
                        <Button type="button" variant="contained" color="error" onClick={home} > CANCELAR </Button>
                        <br/>
                </form> 
                </CardContent> 
            </Card>
        </div>

    )

}

export default UpdateOpportunity;