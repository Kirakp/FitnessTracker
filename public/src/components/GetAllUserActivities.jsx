import React, { useState, useEffect } from 'react'
import {Link} from 'react-router-dom';
import { getAllUserActivities } from '../services/Service';

function GetAllUserActivities() {
    const [userActivities, setUserActivities] = useState([])
    const user= JSON.parse(localStorage.getItem("loggedInUser"))

    useEffect(() =>{
        getAllUserActivities().then(res=> setUserActivities(res.data))
    }, [])

    return (
    <div class='table-responsive'>
        <h1>User Activity:-</h1>
        <table class='table table-bordered'>
            <thead class='table-dark'>
                <tr>
                    <th>User Activity ID:</th>
                    <th>User ID:</th>
                    <th>Frequency:</th>
                    <th>Total Calories:</th>
                    <th>Date of Start:</th>
                    <th>Activity ID:</th>
                </tr>
            </thead>

            <tbody>
                {
                    userActivities.map(ua=>
                        <tr key={ua.userActivity_id}>
                            <td>{ua.userActivity_id}</td>
                            <td>{ua.userId.userId}</td>
                            <td>{ua.frequency}</td>
                            <td>{ua.total_calories}</td>
                            <td>{ua.start_date}</td>
                            <td>{ua.activityId.activityId}</td>
                        </tr>
                        )
                }
            </tbody>
        </table>
    
            
            <div>
            <Link to='/useractivities/add' class='btn btn-light'>Add a new Activity plan for you!</Link>
            </div>
            
            <div>
                <h5>
                    <i> Please Note: You can only add 1 Activity per User (One to One Mapping) </i>
                </h5>
            </div>
    </div>
  )
}

export default GetAllUserActivities