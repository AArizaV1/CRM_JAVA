import React, { useEffect, useState } from "react";
import {useParams, Navigate, useNavigate} from 'react-router-dom'
import {Link} from 'react-router-dom'
import StyleCustomer from "./StyleCustomer.css"
import Axios from 'axios'

function ViewCustomer(){

        const [customer, setCustomer] = useState([]);

        const navigater = useNavigate();

        const createCustomer = () => {
            navigater('/createCustomer/')
        }

        
        function deleteCustomer(e){
            Axios.delete(e)
           .then(() => this.setState({ status: 'Delete successful' })); 
       }
   
   
        useEffect(() => {
            fetch('http://localhost:8085/customer')
            .then(res => res.json())
            .then(json => setCustomer(json))
            
        }, [])
    
        return (
            <div>
                <h1> CUSTOMERS</h1>
                <div class="customer">
                <table class="paleBlueRows">
                    <thead>
                        <tr>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
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
                            customer.map(
                            customer1 => 
                            <tr key = {customer1.idCustomer}>
                                <td>{customer1.customerName}</td>
                                <td>{customer1.customerPhone}</td>
                                <td>{customer1.customerEmail}</td>
                            
                                <td><button class="myButtonUpdate">Update</button></td>
                                <td><button class="myButtonCancel" onClick={deleteCustomer(`http://localhost:3000/customer/${customer1.idCustomer}`)}>Delete</button></td>
                            </tr>
                            )
                        }
                    </tbody>
                </table>
                <button class="myButtonCreate" onClick={createCustomer} >Create Customer</button>
            </div>
        </div>
    
        )
    
    }
        export default ViewCustomer;
        
