import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { editUserDiet, getUserDietById } from "../services/Service";
import UserNavbar from "./UserNavbar";


function EditUserDiet() {
    const [userDietId, setUsrDietId] = useState(0)
    const [userId, setUserId] = useState(0)
    const [dietId, setDietId] = useState(0)
    const [days, setDays] = useState(0)

    const { id } = useParams();
    const navigate = useNavigate();


    useEffect(() => {
        getUserDietById(id).then((res) => {
            setUsrDietId(res.data.userDietId);
            setUserId(res.data.userId.userId);
            setDietId(res.data.dietId.dietId);
            setDays(res.data.no_of_days);
        })
    }, [id])

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
        editUserDiet(id, payload).then(alert("Diet details have been modified")).then(res => navigate(-1)).catch(error => console.error("Something went wrong"))
    }

    return (
<><UserNavbar/>
        <div className='container-fluid align-items-center'>
            <form class="row g-3">
                <div class="col-md-6">
                    <div class="form-outline ">
                        <input type="number" class="form-control" id="validationDefault01" value={userDietId} disabled />
                        <label for="validationDefault01" class="form-label">User Diet ID</label>
                    </div>
                </div>
                <div className="w-100"></div>

                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="number" class="form-control" id="validationDefault02" value={userId} disabled />
                        <label for="validationDefault02" class="form-label">User ID</label>
                    </div>
                </div>
                <div className="w-100"></div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="number" class="form-control" id="validationDefault03" value={dietId} disabled />
                        <label for="validationDefault03" class="form-label">Diet ID</label>
                    </div>
                </div>
                <div className="w-100"></div>
                <div class="col-md-6">
                    <div class="form-outline">
                        <input type="number" class="form-control" id="validationDefault05" value={days} onChange={e => setDays(e.target.value)} required />
                        <label for="validationDefault05" class="form-label">How many days would you like to follow this diet for?</label>
                    </div>
                </div>
                <div className="w-100"></div>

                <div class="col-12">
                    <button class="btn btn-primary" type="submit" onClick={handleSubmit}>Edit User Diet Details</button>
                </div>
            </form>



        </div>
</>

    )
}

export default EditUserDiet