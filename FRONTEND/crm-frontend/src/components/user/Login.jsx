import React, { useState } from "react";
import {useNavigate} from "react-router-dom"


function Login(props){

    const navigator = useNavigate()
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');


    const handleSubmit = (e) => {
        e.preventDefault();
    
        async function getData(){
          const response = await fetch("http://localhost:8085/users/login",
          {
            method:"POST",
            headers:{'Content-type': 'application/json'},
            body:JSON.stringify({
    
              email : email,
              pass : pass
    
            })
          })
          if (response.status === 200) {
            const data = await response.json()
            console.log(data)
    
            props.logged(data.user)
          }
        }
        getData()
    }

    return (
        <div className="auth-form-container">
            <h2>Login</h2>
            <form className="login-form" onSubmit={handleSubmit}>
               
                <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="Email" id="email" name="email" />
              
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="Password" id="password" name="password" />
                
                <button type="submit" to="/opportunity">Log In</button>

            </form>
        </div>
    )
}

export default Login;