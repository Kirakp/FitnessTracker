import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import { getUserActivityById } from "../services/Service";
import '../styles/WeeklyReportInput.css'
import UserNavbar from "./UserNavbar";

function WeeklyReport() {
  const [activity, setActivty] = useState("");
  const [duration, setDuration] = useState(0);
  const [days, setDays] = useState(0);
  const [total_calories, SetTotalCalories] = useState(0)

  const [flag , setFlag] = useState(false)
  const [report, setReport ] = useState(0)

  const { id } = useParams();

  useEffect(() => {
    getUserActivityById(id).then((res)=> {
    SetTotalCalories(res.data.total_calories);  
    })
  }, [id])
  

  const handleSubmit = (event) =>{
    setReport(total_calories * (duration/60) * days);
    setFlag(true)
    event.preventDefault(); 
  }

  return (
    <>
      <UserNavbar/>
      <div className="weeklyreport container">
        <form id="report1" action="">
          <h3>
            <b> Report Form </b>
          </h3>
          <fieldset>
            <input
              placeholder="Activity Name"
              id="activity"
              name="activity"
              type="text"
              value={activity}
              tabindex="1"
              required
              autofocus
              onChange={(e) => setActivty(e.target.value)}
            />
          </fieldset>
          <fieldset>
            <input
              placeholder="Duration(mins)"
              id="duration"
              name="duration"
              type="number"
              value={duration}
              tabindex="2"
              min="0"
              required
              onChange={(e) => setDuration(e.target.value)}
            />
          </fieldset>
          <fieldset>
            <input
              placeholder="No. Of Days"
              id="days"
              name="days"
              type="number"
              value={days}
              tabindex="3"
              min="0"
              required
              onChange={(e) => setDays(e.target.value)}
            />
          </fieldset>

          <fieldset>
            <input
              id="total_calories"
              name="total_calories"
              type="number"
              value={total_calories}
              tabindex="4"
              disabled
              onChange={(e) => SetTotalCalories(e.target.value)}
            />
          </fieldset>


          <h4>
            <b>
              <u>Note: </u>
            </b>
          </h4>
          <h4>
            <b>1. Duration should be in multiples of 30 mins</b>
          </h4>
          <h4>
            <b>2. Number of Days should be between 0-7</b>
          </h4>
          <fieldset>
            <button
              className="btn btn-light"
              name="submit"
              type="submit"
              id="report1-submit"
              data-submit="...Sending "
              onClick={handleSubmit}
            >
              Submit
            </button>
          </fieldset>
        </form>

        {flag && (<div style={{ color: "darkcyan", paddingBottom: 10}}>
          Report Calculations : {report}
          </div>)
        }
      </div>
      <div>
        
        {/* <Link
          className="nav-link active"
          aria-current="page"
          to="/home/weeklyreport/report"
        >
          {" "}
          REPORT{" "}
        </Link> */}
      </div>
    </>
  );
}

export default WeeklyReport;
