import React, { useState, useEffect } from 'react'
import {Link} from 'react-router-dom';
import { getAllUserDiets } from '../services/Service'
import AdminNavbar from "./AdminNavbar";


function GetAllUserDiets() {
  const [userDiets, setUserDiets] = useState([])

  useEffect(()=>{
    getAllUserDiets().then(res=> setUserDiets(res.data))
  }, [])
  
    return (
<>
    <AdminNavbar/>
        <div class='table-responsive'>
        <h1>User Diet:-</h1>
        <table class='table table-bordered'>
            <thead class='table-dark'>
                <tr>
                    <th>User Diet ID:</th>
                    <th>User ID:</th>
                    <th>Weight:</th>
                    <th>Diet Type:</th>
                    <th>Number of Days completed:</th>
                </tr>
            </thead>

            <tbody>
                {
                    userDiets.map(ud=>
                        <tr key={ud.userDietId}>
                            <td>{ud.userDietId}</td>
                            <td>{ud.userId.userId}</td>
                            <td>{ud.userId.weight}</td>
                            <td>{ud.dietId.dietType}</td>
                            <td>{ud.no_of_days}</td>
                        </tr>
                        )
                }
            </tbody>
        </table>
    
        <div>
            <Link to='/userdiets/add' class='btn btn-light'>Add a new Diet plan for you!</Link>
        </div>

        <h5>
             <i> Please Note: You can only add 1 Diet per User (One to One Mapping) </i>
        </h5>
    
        </div>
</>
  )
}

export default GetAllUserDiets

