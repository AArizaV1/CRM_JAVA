import React, { useEffect, useState } from "react";
import StyleOpportunity from "./StyleOpportunity.css"
import {Navigate, useNavigate} from 'react-router-dom'
import Axios from 'axios'



function CreateOpportunity(){

    const navigater = useNavigate();
    const home = () => {
        navigater('/home/')
    }

    const [opportunityBody, setOpportunityBody] = useState({
        idOpportunity: null,
        opportunityName:'',
        opportunityPhone:'',
        opportunityEmail:''
    })

  
function submit(e){
    e.preventDefault();
    Axios.post('http://localhost:8085/opportunity', {
        opportunityName: opportunityBody.opportunityName,
        opportunityPhone: opportunityBody.opportunityPhone,
        opportunityEmail: opportunityBody.opportunityEmail
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
        <div class="form">
            <h1>OPPORTUNITY</h1>
            <div class="opportunity">    
                <form onSubmit={(e) => submit(e)}>
                    
                        <input id="idOpportunity" type="hidden"/> 
                        <br/>
                        <input id="opportunityName" type="text" placeholder="Name" value={opportunityBody.opportunityName} onChange={e => handle(e)}/> 
                        <br/>
                        <input id="opportunityPhone" type="tel" placeholder="Phone" value={opportunityBody.opportunityPhone} onChange={e => handle(e)}/> 
                        <br/>
                        <input id="opportunityEmail" type="email" placeholder="Email" value={opportunityBody.opportunityEmail} onChange={e => handle(e)}/> 
                        <br/>    
                        <input type="submit" class="myButtonCreate" value="Create Opportunity" />
                        <br/>    
                        <button class="myButtonCancel" onClick={home}>Cancel</button>
        
                </form> 
            </div>
        </div>

    )

}

export default CreateOpportunity;