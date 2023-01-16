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
import Fab from '@mui/material/Fab';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';
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

    const updateOpp = (path) => {
        navigater(path)
    }

    const seeContacts = (path) => {
        navigater(path)
    }



    function seeContact(e){
        navigater(e);
    }


  
    function deleteOpportunity(e) {
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
    <h1>OPPORTUNITY</h1>
        <div className="opportunity">
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 700 }} aria-label="customized table">
            

            <TableHead>
                <TableRow>
                    <StyledTableCell>ID</StyledTableCell>
                    <StyledTableCell align="center">Name</StyledTableCell>
                    <StyledTableCell align="center">Phone</StyledTableCell>
                    <StyledTableCell align="center">Email</StyledTableCell>
                    <StyledTableCell align="center">¿Customer?</StyledTableCell>
                    <StyledTableCell align="right"></StyledTableCell>
                    <StyledTableCell align="right"></StyledTableCell>
                    <StyledTableCell align="right"></StyledTableCell>
                </TableRow>
            </TableHead>

            <TableBody>
                {opport.map((opportunity) => (
                    <StyledTableRow key={opportunity.idOpportunity}>
                        <StyledTableCell component="th" scope="row">
                            {opportunity.idOpportunity}
                        </StyledTableCell>
                        <StyledTableCell align="center">{opportunity.opportunityName}</StyledTableCell>
                        <StyledTableCell align="center">{opportunity.opportunityPhone}</StyledTableCell>
                        <StyledTableCell align="center">{opportunity.opportunityEmail}</StyledTableCell>
                        <StyledTableCell align="center">{opportunity.idCustomer}</StyledTableCell>
                        <StyledTableCell align="center" >
                            <Button variant="contained" color="success" size="large" onClick={()=>seeContacts(`/contact/${opportunity.idOpportunity}`)}> SEE CONTACTS </Button>
                        </StyledTableCell>

                        <StyledTableCell align="center" >
                            <IconButton aria-label="delete" size="small" onClick={()=>updateOpp(`/updateOpportunity/${opportunity.idOpportunity}`)}>      
                                <Fab color="secondary" aria-label="edit"> <EditIcon /> </Fab>
                            </IconButton>
                        </StyledTableCell>

                        <StyledTableCell align="center" >
                            <IconButton aria-label="delete" size="large" onClick={()=>deleteOpportunity(`/opportunity/${opportunity.idOpportunity}`)}> 
                                <Fab color="error" aria-label="delete"> <DeleteIcon/>  </Fab> 
                            </IconButton>
                        </StyledTableCell>

                    </StyledTableRow>
                ))
                }
                <StyledTableCell colSpan="8" align="center" >
                    <Button variant="contained" color="info" size="large" onClick={createOpp} >Create Opportunity</Button>
                </StyledTableCell>       
            </TableBody>
      </Table>
    </TableContainer>
        </div>
        </CardContent> 
            </Card>
            <br/>
        </div>

    )
}

export default ViewOpportunity;