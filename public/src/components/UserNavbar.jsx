import React from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom';

function UserNavbar() {
  const user = JSON.parse(localStorage.getItem("loggedInUser"));

  const navigate = useNavigate();

  const handleLogout = () => {
    if (user !== null) {
      localStorage.removeItem("loggedInUser");
      alert(user.userName + " has been logged out!");
      navigate("/");
    }
  };
  return (
    <div>
      {user !== null ? (
        <div>
          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

              <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <i class="fas fa-bars"></i>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                  <Link to={`/user/${user.userId}`} class="nav-link">
                    Your Profile
                  </Link>
                  <Link to="/activityplan" class="nav-link">
                    Activity Plans
                  </Link>
                  <Link to="/dietplan" class="nav-link">
                    Diet Plans
                  </Link>
                  <Link to={`/userdiets/${user.userId}`} class="nav-link">
                    Your Diet
                  </Link>
                  <Link to={`/useractivities/${user.userId}`} class="nav-link">
                    Your Activity
                  </Link>
                  <Link to={`/userreport/${user.userId}`} class="nav-link">
                    Your Report
                  </Link>
                  <Link to={`/useractivities1/${user.userId}`} class="nav-link">
                    Activity
                  </Link>
                  <Link to={`/userdiets1/${user.userId}`} class="nav-link">
                    Diet
                  </Link>
                  <button onClick={handleLogout} class="float-right nav-link">Logout</button>
                </div>
              </div>
            </div>
          </nav>
        </div>
      ) : (
        <h2>Please Login first!</h2>
      )}
    </div>
  );
}

export default UserNavbar