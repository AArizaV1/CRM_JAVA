import React from "react";
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import ViewOpportunity from "./components/opportunity/ViewOpportunity";
import ViewCustomer from "./components/customer/ViewCustomer";
import CreateOpportunity from "./components/opportunity/CreateOpportunity";
import CreateCustomer from "./components/customer/CreateCustomer";



function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path = "*" element={<><ViewOpportunity/><ViewCustomer/></>} />
            <Route path = "/home" element={<><ViewOpportunity/><ViewCustomer/></>} />
            <Route path = "/createOpportunity" element={<CreateOpportunity/>} />
            <Route path = "/createCustomer" element={<CreateCustomer/>} />
        </Routes>
      </BrowserRouter>
  );
}

export default App;
