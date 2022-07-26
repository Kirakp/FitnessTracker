import React, { useState } from 'react'
import AddUserActivity from './AddUserActivity'
import EditUserActivity from './EditUserActivity'
import GetActivity from './GetActivityPlan'
import GetAllActivities from './GetAllActivities'
import UserNavbar from './UserNavbar'

function Activity() {



    return (
        <><UserNavbar />
            <br />
            <div className='align-items-center'>
                <div className="col-md">
                    <div className="container text-center">
                        <h2>Activity List</h2>
                        <GetAllActivities />
                    </div>
                </div>
                <br />
                <div className="col-md">
                    <div className="container align-items-center d-block">
                        <h2>Add your activity</h2>
                        <AddUserActivity />
                    </div>
                </div>
            </div></>

    )
}

export default Activity