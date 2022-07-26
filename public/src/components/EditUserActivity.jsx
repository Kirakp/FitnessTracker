import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { editUserActivity, getUserActivityById } from "../services/Service";
import UserNavbar from "./UserNavbar";

function EditUserActivity() {
  const [userActivity_id , setUserActivityId] = useState(0);
  const [userId , setUserId] = useState(0);
  const [activityId , setActivityId] = useState(0);
  const [activityName , setActivityName] = useState("");
  const [duration , setDuration] = useState(0.0);
  const [calories , setCalories] = useState(0.0);
  const [frequency , setFrequency] = useState(0);
  const [total_calories , SetTotalCalories] = useState(0);
  const [start_date , SetStartDate] = useState("");
  
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() =>{
    getUserActivityById(id).then((res)=> {
        setUserActivityId(res.data.userActivity_id);
        setUserId(res.data.userId.userId);
        setActivityId(res.data.activityId.activityId);
        setActivityName(res.data.activityId.activityName);
        setDuration(res.data.activityId.duration);
        setCalories(res.data.activityId.calories);
        setFrequency(res.data.frequency);
        SetTotalCalories(res.data.total_calories);
        SetStartDate(res.data.start_date);
    })
  }, [id])

  const handleSubmit = () => {
    const payload ={
      userId: {
        userId: userId
      },
      activityId: {
        activityId: activityId
      },
      frequency: frequency,
      total_calories: total_calories,
      start_date: start_date
    }
    editUserActivity(id, payload).then(alert("Activity details have been modified")).then(res=> navigate(-1)).catch(error=>console.error("Something went wrong"))
  }
  
  return (
    <div>
        <UserNavbar/>
      <div>
          <label>User Activity ID:</label>
          <input type="number" id="userActivity_id" name="userActivity_id" value={userActivity_id} disabled/>
      </div>
      <div>
          <label>User ID:</label>
          <input type="number" id="userId" name="userId" value={userId} disabled/>
      </div>
      <div>
          <label>Activity ID:</label>
          <input type="number" id="activityId" name="activityId" value={activityId} disabled/>
      </div>
      <div>
          <label>Activity Name:</label>
          <input type="number" id="activityName" name="activityName" value={activityName} disabled/>
      </div>
      <div>
          <label>Duration:</label>
          <input type="number" id="duration" name="duration" value={duration} disabled/>
      </div>
      <div>
          <label>Calories:</label>
          <input type="number" id="calories" name="calories" value={calories} disabled/>
      </div>
      <div>
            <label>Frequency:</label>
            <input type="number" id="frequency" name="frequency" value={frequency} onChange={e => setFrequency(e.target.value)}></input>
        </div>
        <div>
            <label>Total Calories to lose:</label>
            <input type="number" id="total_calories" name="total_calories" value={total_calories} onChange={e => SetTotalCalories(e.target.value)}></input>
        </div>
        <div>
            <label>Starting date:</label>
            <input type="date" id="start_date" name="start_date" value={start_date} onChange={e => SetStartDate(e.target.value)}></input>
        </div>

        <div>
        <button class='btn btn-primary' onClick={handleSubmit}>Edit User Activity Details</button>
        </div>
    </div>
  )
}

export default EditUserActivity