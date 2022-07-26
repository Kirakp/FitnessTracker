import React, { useState } from 'react'
import { registerAdmin } from '../services/Service'

function RegisterAdmin() {

    const [password , setPassword] = useState("");
    const [number , setNumber] = useState(0);
    const [userName , setUserName] = useState("");

    const handleSubmit = () => {
        const payload = {
            password: password,
            number: number,
            userName: userName,
        }
        registerAdmin(payload).then(res => alert("New Admin registered with ID" + res.data.adminId))
    }
  
    return (
    <div>
        <div>
            <h2>Admin Registration</h2>
        </div>
        <div>
            <label>User Name:</label>
            <input type="text" name="userName" id="userName" value={userName} onChange={e=> setUserName(e.target.value)}/>
        </div>
        <div>
            <label>Contact Number:</label>
            <input type="number" name="number" id="number" value={number} onChange={e=> setNumber(e.target.value)}/>
        </div>
        <div>
            <label>Password:</label>
            <input type="password" name="password" id="password" value={password} onChange={e=> setPassword(e.target.value)}/>
        </div>
        

        <div>
            <button class='btn btn-primary' onClick={handleSubmit}>Register</button>
        </div>

    </div>
  )
}

export default RegisterAdmin