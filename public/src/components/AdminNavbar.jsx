import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import AdminLogout from './AdminLogout'

function AdminNavbar() {
    const admin = JSON.parse(localStorage.getItem("loggedInAdmin"))
    const navigate = useNavigate();

    const handleLogout = () => {
        if (admin!==null){
            localStorage.removeItem("loggedInAdmin")
            alert(admin.userName+" has been logged out!")
            navigate("/")
        }
    }
    return (
      <div>
          {admin !== null ?

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
                      <Link to={`/admin/${admin.adminId}`} class="nav-link">
                        Your Profile
                      </Link>
    
                      <Link to='/user/all' class="nav-link">
                        All Users
                      </Link>
                      <Link to='/admin/all' class="nav-link">
                         All Admins
                      </Link>

                      <Link to="/activities" class="nav-link">
                        Activities
                      </Link>

                      <Link to="/dietitems" class="nav-link">
                        Diet Items
                      </Link>

                      <Link to="/diets" class="nav-link">
                        Diets
                      </Link>
                      <button onClick={handleLogout} class="float-right nav-link">Logout</button>           
                    </div>
                  </div>
                </div>
              </nav>
              </div>
              : <h2>Please Login first!</h2>
          }
  
  
      </div>
      
    )
  }


export default AdminNavbar