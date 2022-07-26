import React, { useState, useEffect } from 'react'
import { getAllActivities } from '../services/Service';
import { Link } from 'react-router-dom'
import activityJpg from '../assets/images/activityJpg.jpg'

function GetAllActivities() {


    const [activities, setActivities] = useState([]);

    useEffect(() => {
        getAllActivities().then(res => setActivities(res.data))
    }, [])

    return (
        <div>
            <div className='row'>
                {
                    activities.map(a =>
                        <div className='col-sm-2'>
                            <div className="card" style={{ width: "200px", height: "320px" }}>
                                <img className="card-img-top" src={activityJpg} alt="" style={{ height: "150px" }} />
                                <div className="card-body">
                                    <h4 className="card-title">{a.activityId}{".  "}{a.activityName}</h4>
                                    <p className="card-text">Duration: {a.duration} hours</p>
                                    <p className="card-text">Calories burnt: {a.calories}</p>
                                </div>
                            </div>
                        </div>
                    )
                }
            </div>

            {/* <div>
            <Link to='/activities/add' class='btn btn-light'>Add a new Activity</Link>
        </div> */}

        </div>
    )
}

export default GetAllActivities