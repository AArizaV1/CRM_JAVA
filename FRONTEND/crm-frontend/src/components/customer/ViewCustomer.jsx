import * as React from 'react'; 
import { useEffect, useState } from "react";
import {useNavigate} from 'react-router-dom';


import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';
import Fab from '@mui/material/Fab';
import EditIcon from '@mui/icons-material/Edit';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
      fontSize: 14,
    },
  }));

  const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    '&:last-child td, &:last-child th': {
      border: 0,
    },
  }));

  function createData(Id, Name, Phone, Email, Customer) {
    return { Id, Name, Phone, Email, Customer };
  }

function ViewCustomer() {

        const [customerView, setCustomerView] = useState([]);

        const navigater = useNavigate();

        useEffect(() => {
            fetch('http://localhost:8085/customer')
            .then(res => res.json())
            .then(json => {
                setCustomerView(json)
            })
        }, [])

        const createCustomer = () => {
            navigater('/createCustomer/')
        }

        const updateCustomer = (path) => {
            navigater(path)
        }

        
        // DELETE request using fetch with async/await
        function deleteCustomer(e) {
            fetch('http://localhost:8085' + e, { method: 'DELETE' }
            ).then(res => {
                window.location.href='http://localhost:3000/home'});

        }
    
        return (
            <div>
                <Card sx={{ minWidth: 475,
                        maxWidth: 1050,
                        margin: "auto" }}>
                <CardContent>   
                <h1> CUSTOMERS</h1>
                <div>
                    <TableContainer component={Paper}>
                        <Table sx={{ minWidth: 700 }} aria-label="customized table">
                        <TableHead>
                            <TableRow>
                                <StyledTableCell>ID</StyledTableCell>
                                <StyledTableCell align="center">Name</StyledTableCell>
                                <StyledTableCell align="center">Phone</StyledTableCell>
                                <StyledTableCell align="center">Email</StyledTableCell>
                                <StyledTableCell align="right"></StyledTableCell>
                                <StyledTableCell align="right"></StyledTableCell>

                            </TableRow>
                        </TableHead>

                        <TableBody>
                            {customerView.map((customer) => (
                                <StyledTableRow key={customer.idCustomer}>
                                    <StyledTableCell component="th" scope="row">
                                        {customer.idCustomer}
                                    </StyledTableCell>
                                    <StyledTableCell align="center">{customer.customerName}</StyledTableCell>
                                    <StyledTableCell align="center">{customer.customerPhone}</StyledTableCell>
                                    <StyledTableCell align="center">{customer.customerEmail}</StyledTableCell>

                                    <StyledTableCell align="center" >
                                        <IconButton aria-label="edit" size="small" onClick={()=>updateCustomer(`/updateCustomer/${customer.idCustomer}`)}>      
                                            <Fab color="secondary" aria-label="edit"> <EditIcon /> </Fab>
                                        </IconButton>
                                    </StyledTableCell>

                                    <StyledTableCell align="center" >
                                        <IconButton aria-label="delete" size="large" onClick={()=>deleteCustomer(`/customer/${customer.idCustomer}`)}> 
                                            <Fab color="error" aria-label="delete"> <DeleteIcon/>  </Fab> 
                                        </IconButton>
                                    </StyledTableCell>

                                </StyledTableRow>
                                ))
                            }
                            <StyledTableCell colSpan="8" align="center" >
                                <Button variant="contained" color="info"  size="large" onClick={createCustomer} >Create Customer</Button>
                            </StyledTableCell>    
                        </TableBody>                   
                        </Table>
                    </TableContainer>
                </div>
                </CardContent> 
            </Card>
            </div>
    
        )
    
    }
        export default ViewCustomer;
        
