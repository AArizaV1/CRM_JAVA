import React, { useState } from "react";
import Axios from 'axios'
import { useNavigate, useParams } from "react-router-dom";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';



function CreateContact(){

    const navigater = useNavigate();
    const {idOpportunity} = useParams();

    const back = () => {
        navigater('/contact/' + idOpportunity )
    }

    const [contactBody, setContactBody] = useState({
        idContact: null,
        idOpportunity: '',
        contactDate:'',
        contactDescription:''
    })


function submit(e){
    e.preventDefault();
    Axios.post('http://localhost:8085/contact/' + idOpportunity, {
        idContact: contactBody.idContact,
        idOpportunity: contactBody.idOpportunity,
        contactDate: contactBody.contactDate,
        contactDescription: contactBody.contactDescription
    })
    .then(res => {
        window.location.href='http://localhost:3000/contact/' + idOpportunity})
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
            <h1>CREATE CONTACT</h1>
                    
                <form onSubmit={(e) => submit(e)}>
                    
                        <TextField id="idContact" label="idContact" variant="standard" type="hidden"/>
                        <TextField id="idOpportunity" label="idOpportunity" variant="standard" type="hidden"/>  
                        <br/>
                        <TextField id="contactDate" type="datetime-local" placeholder="Date" variant="standard" value={contactBody.contactDate} onChange={e => handle(e)}/> 
                        <br/>
                        <TextField id="contactDescription" type="text" label="Description" variant="standard" value={contactBody.contactDescription} onChange={e => handle(e)}/> 
                        <br/>  
                        <Button type="submit" variant="contained" color="info"> CREATE CUSTOMER </Button>
                        <br/>    
                        <Button type="button" variant="contained"  color="error" onClick={back}> CANCELAR </Button>
                        <br/>
                </form>
                </CardContent> 
            </Card>
               
        </div>

    )

}

export default CreateContact;