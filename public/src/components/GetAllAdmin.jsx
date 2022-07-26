import React, { useState, useEffect } from 'react'
import { getAllAdmins } from '../services/Service';
import { Link } from 'react-router-dom'
import AdminNavbar from "./AdminNavbar";

function GetAllAdmin() {
  
    const [admins , setAdmins] = useState([]);

    useEffect(() => {
      getAllAdmins().then(res=> setAdmins(res.data))
    }, [])
    
  
    return (
        <><AdminNavbar/>
    <div class='table-responsive'>
        <table class='table table-bordered'>
            <thead class='table-dark'>
                <tr>
                    <th>Admin ID: </th>
                    <th>Admin Name: </th>
                    <th>Contact Number: </th>
                    <th>Contact Number: </th>
                </tr>
            </thead>

            <tbody>
                {
                    admins.map(a=>
                        <tr key={a.adminId}>
                            <td>{a.adminId}</td>
                            <td>{a.userName}</td>
                            <td>{a.number}</td>
                            <td><Link to={`/admin/${a.adminId}`}> 🛡️ </Link></td>
                        </tr>
                        )
                }
            </tbody>

        </table>
    </div>
        </>
  )
}

export default GetAllAdmin