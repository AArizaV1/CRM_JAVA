import React, { useState } from "react";
import Axios from 'axios'
import { useNavigate, useParams } from "react-router-dom";
import { useEffect } from "react";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';



function UpdateContact(){

    const {idContact} = useParams();

    const navigater = useNavigate();
    
    const [contactBody, setContactBody] = useState({
        idContact: Number(idContact),
        contactDate: '',
        contactDescription: '',
        idOpportunity: ''
        })

    useEffect(() => {
        fetch(`http://localhost:8085/contact/id/` + idContact)
            .then(res => res.json())
            .then(json => {
                setContactBody(json)
                console.log(json);
            })
    }, [])


  
    function submit(e){
        e.preventDefault();
        Axios.put('http://localhost:8085/contact/' + contactBody.idContact, {
            idContact: contactBody.idContact,
            contactDate: contactBody.contactDate,
            contactDescription: contactBody.contactDescription,
            idOpportunity: contactBody.idOpportunity
        })
        .then(res => {
            window.location.href='http://localhost:3000/contact/' + contactBody.idOpportunity})

        
    }
        
    const back = () => {
        navigater('/home/') 
    }
    
    function handle(e) {
        const newContactBody = {...contactBody}
        newContactBody[e.target.id] = e.target.value
        setContactBody(newContactBody)
    }


    return (
        <div className="form">
            <Card sx={{ minWidth: 275,
                        maxWidth: 450,
                        margin: "auto" }}>
                <CardContent>
            <h1>UPDATE CONTACT</h1>
                <form onSubmit={(e) => submit(e)}>
                        <TextField id="idContact" label="idContact" variant="standard" type="hidden"/>  
                        <br/>
                        <input id="contactDate" type="datetime-local" value={contactBody.contactDate} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="contactDescription" type="text" label="Description" variant="standard" value={contactBody.contactDescription} onChange={e => handle(e)}/> 
                        <br/>    
                        <TextField id="idOpportunity" type="number" label="ID Opportunity" variant="standard" value={contactBody.idOpportunity} onChange={e => handle(e)}/> 
                        <br/>
                        <Button type="submit" variant="contained" color="info"> UPDATE CONATCT </Button>
                        <br/>    
                        <Button type="button" variant="contained"  color="error" onClick={back}  > CANCELAR </Button>
                        <br/>
                </form>
                </CardContent> 
            </Card>
               
        </div>

    )

}

export default UpdateContact;