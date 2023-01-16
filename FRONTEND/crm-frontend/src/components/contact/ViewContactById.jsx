import React, { useEffect, useState } from "react";
import {useNavigate, useParams} from 'react-router-dom';

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


  function ViewContactById(){

        const [contact, setContact] = useState([]);
        const {idOpportunity} = useParams();
        const navigater = useNavigate(); 
    
        useEffect(() => {
            fetch(`http://localhost:8085/contact/` + idOpportunity)
            .then(res => res.json())
            .then(json => { setContact(json)})
            
        }, [])

        const home = () => {
            navigater('/home/') 
        }

        const createContact = (path) => {
            navigater(path)
        }

        const updateContact = (path) => {
            navigater(path)
        }

        function deleteContact(e) {
            fetch('http://localhost:8085' + e, { method: 'DELETE' }
            ).then(res => {
                window.location.href='http://localhost:3000/contact/'  + idOpportunity});
    
        }

    
        return (
            <div>
                <Card sx={{ minWidth: 475,
                        maxWidth: 1050,
                        margin: "auto" }}>
                <CardContent>
                <h1> CONTACTS</h1>
                <div>
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 700 }} aria-label="customized table">

                    <TableHead>
                            <TableRow>
                                <StyledTableCell>DATE</StyledTableCell>
                                <StyledTableCell align="center">DESCRIPTION</StyledTableCell>
                                <StyledTableCell align="center"></StyledTableCell>
                                <StyledTableCell align="center"></StyledTableCell>
                            </TableRow>
                    </TableHead>
                    
                    <TableBody>
                            {contact.map((contactBody) => (
                                <StyledTableRow key={contactBody.idOpportunity}>
                                    {/* <StyledTableCell component="th" scope="row">
                                        {contactBody.idOpportunity}
                                    </StyledTableCell> */}
                                    <StyledTableCell align="center">{contactBody.contactDate}</StyledTableCell>
                                    <StyledTableCell align="center">{contactBody.contactDescription}</StyledTableCell>

                                    <StyledTableCell align="center" >
                                        <IconButton aria-label="edit" size="small" onClick={()=>updateContact(`/updateContact/${contactBody.idContact}`)}>      
                                            <Fab color="secondary" aria-label="edit"> <EditIcon /> </Fab>
                                        </IconButton>
                                    </StyledTableCell>

                                    <StyledTableCell align="center" >
                                        <IconButton aria-label="delete" size="large" onClick={()=>deleteContact(`/contact/${contactBody.idContact}`)}> 
                                            <Fab color="error" aria-label="delete"> <DeleteIcon/>  </Fab> 
                                        </IconButton>
                                    </StyledTableCell>

                                </StyledTableRow>
                                ))
                            }
                            <StyledTableCell colSpan="4" align="center" >
                                <Button variant="contained" color="info"  size="large" onClick={()=>createContact(`/createContact/${idOpportunity}`)} > CREATE CONTACT</Button>
                            </StyledTableCell>    
                        </TableBody> 
                    </Table>
                </TableContainer>
            </div>
            <Button variant="contained" color="warning"  size="large" onClick={home} >BACK</Button>
            </CardContent> 
            </Card>
        </div>
    
        )
    
    }
        export default ViewContactById;
        
