import React, { useState } from 'react'
import AddUserActivity from './AddUserActivity'
import AddUserDiet from './AddUserDiet'
import EditUserActivity from './EditUserActivity'
import GetAllUserDiets from './GetAllUserDiets'
import GetUserActivity from './GetUserActivity'
import GetUserDiet from './GetUserDiet'
import UserNavbar from './UserNavbar'
import GetAllDiets from "./GetAllDiets";

function Diet() {



    return (
        <><UserNavbar />
            <br />
            <div className='align-items-center'>


                <div className="row">
                    <div className="col-md-5">
                        <div className="container text-center">

                            <GetAllDiets />

                        </div>
                    </div>
                    <div className="col-md-6">
                        <div className="container align-items-center d-block">
                            <GetUserDiet />
                        </div>
                    </div>
                </div>


            </div></>

    )
}

export default Diet