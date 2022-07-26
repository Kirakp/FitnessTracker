import React, { useState } from 'react'
import { addUserDiet } from '../services/Service'
import UserNavbar from "./UserNavbar";

function AddUserDiet() {
  
    const [userId , setUserId] = useState(0)
    const [dietId, setDietId] = useState(0)
    const [days, setDays] = useState(0)

    const handleSubmit = () => {
        const payload = {
            userId: {
              userId: userId
            },
            dietId: {
              dietId: dietId
          },
            no_of_days: days
        }
        addUserDiet(payload).then(res=> alert("New User Diet created with ID: "+ res.data.userDietId))
    }


    return (
    <div>
        <UserNavbar/>
        <div>
            <label>Enter your User ID:</label>
            <input type="number" id="userId" name="userId" value={userId} onChange={e => setUserId(e.target.value)}></input>
        </div>
        <div>
            <label>Enter the Diet ID you would like to select:</label>
            <input type="number" id="dietId" name="dietId" value={dietId} onChange={e => setDietId(e.target.value)}></input>
        </div>
        <div>
            <label>How many days would you like to follow this diet for?</label>
            <input type="number" id="days" name="days" value={days} onChange={e => setDays(e.target.value)}></input>
        </div>

        <div>
                <button onClick={handleSubmit}>Start Diet</button>
        </div>

    </div>
  )
}

export default AddUserDiet
