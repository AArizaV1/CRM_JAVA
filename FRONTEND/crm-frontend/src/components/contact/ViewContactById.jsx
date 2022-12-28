import React, { useEffect, useState } from "react";
import {useParams} from 'react-router-dom'
import {Link} from 'react-router-dom'
import StyleContact from "./StyleContact.css"

function ViewContactById(){

        const [contact, setContact] = useState([]);
    
        useEffect(() => {
            fetch(`http://localhost:8085/opportunity/${opportunity.idOpportunity}`)
            .then(res => res.json())
            .then(json => setContact(json))
            
        }, [])
    
        return (
            <div>
                <h1> CONTACTS</h1>
                <div class="contact">
                <table class="paleBlueRows">
                    <thead>
                        <tr>
                            <th>DATE</th>
                            <th>DESCRIPTION</th>
                            <th>ID OPPORTUNITY</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <td colspan="5">
                            <div class="links"><a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a></div>
                            </td>
                        </tr>
                    </tfoot>
                    <tbody>
                        {
                            contact.map(
                            contact1 => 
                            <tr key = {contact1.idContact}>
                                <td>{contact1.contactDate}</td>
                                <td>{contact1.contactDescription}</td>
                                <td>{contact1.opportunity_entity}</td>
                            
                                <td><button class="myButtonUpdate">Update</button></td>
                                <td><button class="myButtonCancel">Delete</button></td>
                            </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    
        )
    
    }
        export default ViewContactById;
        
