import React, { useState } from 'react'
import { addUserActivity } from '../services/Service'

function AddUserActivity() {
    const [userId, setUserId] = useState(0)
    const [activityId, setActivityId] = useState(0)
    const [frequency, setFrequency] = useState(0)
    const [total_calories, SetTotalCalories] = useState(0)
    const [start_date, SetStartDate] = useState("")

    const handleSubmit = () => {
        const payload = {
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
        addUserActivity(payload).then(res => alert("New user activity added with id: " + res.data.userActivity_id))
    }

    return (
        <div className='container-fluid align-items-center'>
            <form class="row g-3 needs-validation" novalidate>
                <div class="col-md-6 position-relative">
                    <div class="form-outline ">
                        <input type="number" class="form-control" id="validationTooltip02" onChange={e => setUserId(e.target.value)} required />
                        <label for="validationTooltip02" class="form-label">Enter your User ID:</label>
                        <div class="invalid-tooltip">Enter User Id</div>
                    </div>
                </div>
                <div className="w-100"></div>

                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="number" class="form-control" id="validationDefault02" onChange={e => setActivityId(e.target.value)} required />
                        <label for="validationDefault02" class="form-label">Which Activity ID would you like to follow?</label>
                    </div>
                </div>
                <div className="w-100"></div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="number" class="form-control" id="validationDefault03" onChange={e => setFrequency(e.target.value)} required />
                        <label for="validationDefault03" class="form-label">Frequency</label>
                    </div>
                </div>
                <div className="w-100"></div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="number" class="form-control" id="validationDefault05" onChange={e => SetTotalCalories(e.target.value)} required />
                        <label for="validationDefault05" class="form-label">Total Calories to lose:</label>
                    </div>
                </div>
                <div className="w-100"></div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="date" class="form-control" id="validationDefault05" onChange={e => SetStartDate(e.target.value)} required />
                        <label for="validationDefault05" class="form-label">Starting date</label>
                    </div>
                </div>
                <div className="w-100"></div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit" onClick={handleSubmit}>Submit form</button>
                </div>
            </form>



        </div>
    )
}

export default AddUserActivity