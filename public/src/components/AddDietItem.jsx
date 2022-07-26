import React, { useState } from 'react'
import { addDietItem } from '../services/Service'
import AdminNavbar from "./AdminNavbar";

function AddDietItem() {
  const [breakfast, setBreakfast] = useState("");
  const [brunch, setBrunch] = useState("");
  const [lunch, setLunch] = useState("");
  const [snack, setSnack] = useState("");
  const [dinner, setDinner] = useState("");
  
  const handleSubmit = () =>{
    const payload = {
        breakfast : breakfast,
        brunch : brunch,
        lunch: lunch,
        snack: snack,
        dinner: dinner,
    }

    addDietItem(payload).then(res => alert("New Diet Item added with ID " + res.data.dietItemId))

  }

    return (
        
    <div>
        <AdminNavbar/>
        <div>
            <label>Breakfast:</label>
            <input type="text" name="breakfast" id="breakfast" value={breakfast} onChange={e=> setBreakfast(e.target.value)}/>
        </div>
        <div>
            <label>Brunch:</label>
            <input type="text" name="brunch" id="brunch" value={brunch} onChange={e=> setBrunch(e.target.value)}/>
        </div>
        <div>
            <label>Lunch:</label>
            <input type="text" name="lunch" id="lunch" value={lunch} onChange={e=> setLunch(e.target.value)}/>
        </div>
        <div>
            <label>Snack:</label>
            <input type="text" name="snack" id="snack" value={snack} onChange={e=> setSnack(e.target.value)}/>
        </div>
        <div>
            <label>Dinner:</label>
            <input type="text" name="dinner" id="dinner" value={dinner} onChange={e=> setDinner(e.target.value)}/>
        </div>

        <div>
            <button class='btn btn-primary' onClick={handleSubmit}>Add Diet Item</button>
        </div>
    </div>
   
    )
}

export default AddDietItem