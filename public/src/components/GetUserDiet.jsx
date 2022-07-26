import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { deleteUserDiet, getUserDietById } from '../services/Service';
import EditUserDiet from './EditUserDiet';
import UserNavbar from "./UserNavbar";

function GetUserDiet() {
    const [userDiet, setUserDiet] = useState(null);
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getUserDietById(id).then(res => setUserDiet(res.data))
    }, [id])

    console.log(id)

    const handleDelete = () => {
        deleteUserDiet(id).then(alert("User Diet with ID " + id + " has been deleted")).then(navigate("/"))
    }

    return (
        <div>
            {
                (userDiet !== null) &&
                <div className="container ">
                    <div className="row align-items-center ">
                        <div className="col-md-8 ">User Diet ID</div>
                        <div className="col-md-4">{userDiet.userDietId}</div>
                        <div className="w-100"></div>
                        <div className="col-md-8">User ID:</div>
                        <div className="col-md-4"> {userDiet.userId.userId}</div>
                        <div className="w-100"></div>
                        <div className="col-md-8">Diet ID:</div>
                        <div className="col-md-4"> {userDiet.dietId.dietId}</div>
                        <div className="w-100"></div>
                        <div className="col-md-8">Your Breakfast </div>
                        <div className="col-md-4"> {userDiet.dietId.dietItemId.breakfast}</div>
                        <div className="w-100"></div>
                        <div className="col-md-8">Your Brunch</div>
                        <div className="col-md-4"> {userDiet.dietId.dietItemId.brunch}</div>
                        <div className="w-100"></div>
                        <div className="col-md-8">Your Lunch</div>
                        <div className="col-md-4"> {userDiet.dietId.dietItemId.lunch}</div>
                        <div className="w-100"></div>

                        <div className="col-md-8">Your Snack</div>
                        <div className="col-md-4"> {userDiet.dietId.dietItemId.snack}</div>
                        <div className="w-100"></div>

                        <div className="col-md-8">Your Dinner</div>
                        <div className="col-md-4"> {userDiet.dietId.dietItemId.dinner}</div>
                        <div className="w-100"></div>

                        <div className="col-md-8">Diet Type</div>
                        <div className="col-md-4"> {userDiet.dietId.dietType}</div>
                        <div className="w-100"></div>
                        <div className="col-md-8">Number of Days</div>
                        <div className="col-md-4"> {userDiet.no_of_days}</div>
                        <div className="w-100"></div>

                        <br />
                        <div className="col">
                            <button type="button" class="btn btn-primary" data-mdb-toggle="modal" data-mdb-target="#exampleModal">
                                Edit
                            </button>

                            <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <EditUserDiet />

                                    </div>
                                </div>
                                &nbsp;

                            </div> &nbsp;
                            <button onClick={handleDelete} className="btn btn-danger">Delete User Diet</button>

                        </div>

                    </div>

                </div>

            }
        </div>
    )
}

export default GetUserDiet