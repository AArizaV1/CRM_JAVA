import React, { useState } from "react";
import {useNavigate} from 'react-router-dom'
import Axios from 'axios'
import '../general/StyleComponent.css'
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';



function CreateOpportunity(){

    const navigater = useNavigate();
    const home = () => {
        navigater('/home/')
    }

    const [opportunityBody, setOpportunityBody] = useState({
        idOpportunity: null,
        opportunityName:'',
        opportunityPhone:'',
        opportunityEmail:'',
        idCustomer:''
    })

  
function submit(e){
    e.preventDefault();
    Axios.post('http://localhost:8085/opportunity', {
        opportunityName: opportunityBody.opportunityName,
        opportunityPhone: opportunityBody.opportunityPhone,
        opportunityEmail: opportunityBody.opportunityEmail,
        idCustomer: opportunityBody.idCustomer
    })
    .then(res => {
        window.location.href='http://localhost:3000/home'})
}
        
        

function handle(e) {
    const newOpportunityBody = {...opportunityBody}
    newOpportunityBody[e.target.id] = e.target.value
    setOpportunityBody(newOpportunityBody)
}

    return (
        <div className="form">
            <Card sx={{ minWidth: 275,
                        maxWidth: 450,
                        margin: "auto" }}>
                <CardContent>
            <h1>CREATE OPPORTUNITY</h1>

                    <form onSubmit={(e) => submit(e)}>
                        
                            <TextField id="idOpportunity" label="idOpportunity" variant="standard" type="hidden" />
                            <br/>
                            <TextField id="opportunityName" label="Name" variant="standard" type="text" value={opportunityBody.opportunityName} onChange={e => handle(e)}/> 
                            <br/>
                            <TextField id="opportunityPhone" label="Phone" variant="standard" type="tel" value={opportunityBody.opportunityPhone} onChange={e => handle(e)}/> 
                            <br/>
                            <TextField id="opportunityEmail" label="Email" variant="standard" type="email" value={opportunityBody.opportunityEmail} onChange={e => handle(e)}/> 
                            <br/>    
                            <TextField id="idCustomer" type="number" label="ID Customer" variant="standard" value={opportunityBody.idCustomer} onChange={e => handle(e)}/> 
                            <br/>   
                            <Button variant="contained" color="info" type="submit"> CREATE OPPORTUNITY </Button>
                            <br/>    
                            <Button variant="contained"  color="error" type="button" onClick={home}> CANCELAR </Button>
                            <br/>
            
                    </form> 
                
                </CardContent> 
            </Card>
        </div>
    )

}

export default CreateOpportunity;