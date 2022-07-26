import React, { useState } from 'react'
import { addActivity } from '../services/Service';
import AdminNavbar from "./AdminNavbar";

function AddActivity() {
    const [activityName , setActivityName] = useState();
    const [duration , setDuration] = useState(0.0);
    const [calories , setCalories] = useState(0.0);

    const handleSubmit = () => {
        const payload = {
            activityName: activityName,
            duration: duration,
            calories: calories,
        }

        addActivity(payload).then(res => alert("New Activity added with ID " + res.data.activityId))
    }

    // const changeHandler= (event) => {
    //     const {name , value} = event.target;
    //     this.setState({ [name] : value})
    // }
    
    return (
    <div>
        <AdminNavbar/>
        <div>
            <label>Activity Name:</label>
            <input type="text" name="activityName" id="activityName" value={activityName} onChange={e=> setActivityName(e.target.value)}/>
        </div>
        <div>
            <label>Duration:</label>
            <input type="number" name="duration" id="duration" value={duration} onChange={e=> setDuration(e.target.value)}/>
        </div>
        <div>
            <label>Calories:</label>
            <input type="number" name="calories" id="calories" value={calories} onChange={e=> setCalories(e.target.value)}/>
        </div>

        <div>
            <button class='btn btn-primary' onClick={handleSubmit}>Add Activity</button>
        </div>

    </div>
  )
}

export default AddActivity