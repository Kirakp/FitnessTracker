import React from 'react'
import { useNavigate } from 'react-router-dom'


function AdminLogout() {

    const navigate = useNavigate();
    const admin = JSON.parse(localStorage.getItem("loggedInAdmin"))

    const handleLogout = () => {
        if (admin!==null){
            localStorage.removeItem("loggedInAdmin")
            alert("Admin has been logged out!")
            navigate("/")
        }
    }
  return (
    <div>
        <button onClick={handleLogout} class="btn btn-warning">Logout</button>
    </div>
  )
}

export default AdminLogout