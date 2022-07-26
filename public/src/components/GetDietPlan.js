import React, { useState, useEffect } from 'react'
import {Link} from 'react-router-dom';
import { getAllDiets } from '../services/Service';
import AdminNavbar from "./AdminNavbar";
import UserNavbar from "./UserNavbar";


function GetDietPlan() {

    const [diets , setDiets] = useState([]);

    useEffect(() => {
        getAllDiets().then(res=> setDiets(res.data))
    }, [])

    return (
        <>
            <UserNavbar/>
            <div class='table-responsive'>
                <table class='table table-bordered'>
                    <thead class='table-dark'>
                    <tr>
                        <th>Diet ID:</th>
                        <th>Breakfast:</th>
                        <th>Brunch:</th>
                        <th>Lunch:</th>
                        <th>Snack:</th>
                        <th>Dinner:</th>
                        <th>Diet Type:</th>
                    </tr>
                    </thead>

                    <tbody>
                    {
                        diets.map(d=>
                            <tr key={d.dietId}>
                                <td>{d.dietId}</td>
                                <td>{d.dietItemId.breakfast}</td>
                                <td>{d.dietItemId.brunch}</td>
                                <td>{d.dietItemId.lunch}</td>
                                <td>{d.dietItemId.snack}</td>
                                <td>{d.dietItemId.dinner}</td>
                                <td>{d.dietType}</td>
                            </tr>
                        )
                    }
                    </tbody>
                </table>
                <div>
                    <Link to='/diets/add' class='btn btn-light'>Add a new Diet plan</Link>
                </div>
            </div>
        </>
    )
}

export default GetDietPlan