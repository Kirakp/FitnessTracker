import React, { useEffect, useState } from 'react';
import { Link, useParams, useNavigate } from 'react-router-dom';
import { deleteUserActivity, getUserActivityById } from '../services/Service';
import UserNavbar from "./UserNavbar";


function GetUserActivity() {
  const [userActivity, setUserActivity] = useState(null);
  const { id } = useParams();
  const navigate = useNavigate();


  useEffect(() => {
    getUserActivityById(id).then(res => setUserActivity(res.data))
  }, [id])

  const handleDelete = () => {
    deleteUserActivity(id).then(alert("User Activity with ID " + id + " has been deleted")).then(navigate("/"))
  }

  return (
    <div>
      <UserNavbar/>
      {
        userActivity != null &&

        <div className="container ">
          <div className="row align-items-center ">
            <div className="col-md-8 ">User Activity ID:</div>
            <div className="col-md-4">{userActivity.userActivity_id}</div>
            <div className="w-100"></div>
            <div className="col-md-8">User ID:</div>
            <div className="col-md-4"> {userActivity.userId.userId}</div>
            <div className="w-100"></div>
            <div className="col-md-8">Activity ID:</div>
            <div className="col-md-4"> {userActivity.activityId.activityId}</div>
            <div className="w-100"></div>
            <div className="col-md-8">Activity Name: </div>
            <div className="col-md-4"> {userActivity.activityId.activityName}</div>
            <div className="w-100"></div>
            <div className="col-md-8">Duration</div>
            <div className="col-md-4"> {userActivity.activityId.duration}</div>
            <div className="w-100"></div>
            <div className="col-md-8">Calories</div>
            <div className="col-md-4"> {userActivity.activityId.calories}</div>
            <div className="w-100"></div>

            <div className="col-md-8">Frequency</div>
            <div className="col-md-4"> {userActivity.frequency}</div>
            <div className="w-100"></div>

            <div className="col-md-8">Total number of Calories</div>
            <div className="col-md-4"> {userActivity.total_calories}</div>
            <div className="w-100"></div>

            <div className="col-md-8">Start Date</div>
            <div className="col-md-4"> {userActivity.start_date}</div>
            <div className="w-100"></div>

            <br />
            <div className="col">
              <Link to={`/useractivities/edit/${userActivity.userId.userId}`} className="btn btn-dark">Edit</Link> &nbsp;
              <button onClick={handleDelete} className="btn btn-danger">Delete User Activity</button>

            </div>
          </div>



        </div>



      }
    </div>
  )
}

export default GetUserActivity