import React, { useEffect, useState } from "react";
import UserLogout from "./UserLogout";
import { Link, useParams, useNavigate } from "react-router-dom";
import UserNavbar from "./UserNavbar";
import WeeklyReport from "./WeeklyReport";

function UserDashboard() {


  return (
    <div>
      <UserNavbar />
      <WeeklyReport />
    </div>
  );
}

export default UserDashboard;
