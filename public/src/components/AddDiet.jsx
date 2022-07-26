import React, { useState } from 'react'
import { addDiet } from '../services/Service';
import AdminNavbar from "./AdminNavbar";

function AddDiet() {
    const [dietItemId, setDietItemId] = useState(0)
    // const [breakfast, setBreakfast] = useState("");
    // const [brunch , setBrunch] = useState("")
    // const [lunch , setLunch] = useState("")
    // const [snack , setSnack] = useState("")
    // const [dinner , setDinner] = useState("")
    const [dietType , setDietType] = useState("");

    const handleSubmit = () => {
        const payload = {
            dietItemId: {
              dietItemId: dietItemId,
            },
            dietType: dietType
          }
        addDiet(payload).then(res => alert("Diet is added with ID: " +res.data.dietId))
    }
    
    return (
    <div>
        <AdminNavbar/>

            <div>

                <label>Diet Item ID:</label>
                <input type="number" id="dietItemId" name="dietItemId" value={dietItemId} onChange={e => setDietItemId(e.target.value)}></input>
            </div>
            <div>
                <label>Diet Type: </label>
                <input type="text" id="dietType" name="dietType" value={dietType} onChange={e => setDietType(e.target.value)}></input>
            </div>

            <div>
                <button onClick={handleSubmit}>Submit</button>
            </div>

    </div>
  )
}

export default AddDiet