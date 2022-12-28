import React, { useEffect, useState } from "react";
import StyleOpportunity from "./StyleOpportunity.css"
import {Navigate, useNavigate} from 'react-router-dom'
import Axios from 'axios'



function ViewOpportunity(){

    const [opport, setOpport] = useState([]);
    const navigater = useNavigate();

    useEffect(() => {
        fetch('http://localhost:8085/opportunity')
        .then(res => res.json())
        .then(json => setOpport(json))
        
    }, [])

    const createOpp = () => {
        navigater('/createOpportunity')
    }

    function seeContact(e){
        navigater(e);
    }
    
    function deleteOpportunity(e){
         Axios.delete(e)
        .then(() => this.setState({ status: 'Delete successful' })); 
    }

    return (
<div>
    <h1>OPPORTUNITY</h1>
        <div class="opportunity">
            <table class="paleBlueRows">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>¿Customer?</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tfoot>
                        <tr>
                            <td colspan="7">
                            <div class="links"><a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a></div>
                            </td>
                        </tr>
                    </tfoot>
                <tbody>
                {
                    opport.map(
                    opportunity => 
                    <tr key = {opportunity.idOpportunity}>
                        <td>{opportunity.opportunityName}</td>
                        <td>{opportunity.opportunityPhone}</td>
                        <td>{opportunity.opportunityEmail}</td>
                        <td>{opportunity.customer_entity}</td>

                        <td><button class="myButtonUpdate">Update</button></td>
                        <td><button class="myButtonCancel" onClick={()=>deleteOpportunity(`/opportunity/${opportunity.idOpportunity}`)}>Delete</button></td>
                        <td><button class="myButtonContacts" onClick={()=>seeContact(`/opportunity/${opportunity.idOpportunity}`)}>See contacts</button></td>
                    </tr>
                    )
                }
                </tbody>
            </table>
            <button class="myButtonCreate" onClick={createOpp} >Create Opportunity</button>
        </div>
        </div>

    )

}

export default ViewOpportunity;