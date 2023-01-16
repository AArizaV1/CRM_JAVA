import React from "react";
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import './components/general/StyleComponent.css';
import ViewOpportunity from "./components/opportunity/ViewOpportunity";
import ViewCustomer from "./components/customer/ViewCustomer";
import CreateOpportunity from "./components/opportunity/CreateOpportunity";
import UpdateOpportunity from "./components/opportunity/UpdateOpportunity";
import CreateCustomer from "./components/customer/CreateCustomer";
import UpdateCustomer from "./components/customer/UpdateCustomer";
import ViewContactById from "./components/contact/ViewContactById";
import CreateContact from "./components/contact/CreateContact";
import UpdateContact from "./components/contact/UpdateContact";



function App() {

  return (
      <BrowserRouter>
        <Routes>
          <Route path = "" element={<><ViewOpportunity/><ViewCustomer/></>} />
            <Route path = "/home" element={<><ViewOpportunity/><ViewCustomer/></>} />
            <Route path = "/createOpportunity" element={<CreateOpportunity/>} />
            <Route path = "/createCustomer" element={<CreateCustomer/>} />
            <Route path = "/updateOpportunity/:idOpportunity" element={<UpdateOpportunity/>} />
            <Route path = "/updateCustomer/:idCustomer" element={<UpdateCustomer/>}  />
            <Route path = "/contact/:idOpportunity" element={<ViewContactById/>}  />
            <Route path = "/createContact/:idOpportunity" element={<CreateContact/>}  />
            <Route path = "/updateContact/:idContact" element={<UpdateContact/>} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
