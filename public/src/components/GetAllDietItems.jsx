import React, { useState, useEffect } from 'react'
import { getAllDietItems } from '../services/Service'
import { Link } from 'react-router-dom'
import AdminNavbar from "./AdminNavbar";

function GetAllDietItems() {
  const [dietItems, setDietItems] = useState([])

  useEffect(() =>{
    getAllDietItems().then(res=> setDietItems(res.data))
  }, [])
  
  return (
      <> <AdminNavbar/>
    <div class='table-responsive'>
        <table class='table table-bordered'>
            <thead class='table-dark'>
                <tr>
                    <th> Diet Item ID: </th>
                    <th> Breakfast: </th>
                    <th> Brunch: </th>
                    <th> Lunch: </th>
                    <th> Snack: </th>
                    <th> Dinner: </th>
                </tr>
            </thead>

            <tbody>
                {
                    dietItems.map(di=>
                        <tr key={di.dietItemId}>
                            <td>{di.dietItemId}</td>
                            <td>{di.breakfast}</td>
                            <td>{di.brunch}</td>
                            <td>{di.lunch}</td>
                            <td>{di.snack}</td>
                            <td>{di.dinner}</td>
                            
                        </tr>
                        )
                }
            </tbody>

        </table>

        <div>
            <Link to='/dietitems/add' class='btn btn-light'>Add a new Diet item</Link>
        </div>
    </div>
      </>
  )
}

export default GetAllDietItems