import React, { useEffect, useState } from 'react';
import { Link, useParams, useNavigate } from 'react-router-dom';
import { deleteAdmin, getAdminById } from '../services/Service';
import AdminNavbar from './AdminNavbar';

function GetAdmin() {
    const [admin, setAdmin] = useState(null);
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getAdminById(id).then(res => setAdmin(res.data));
    },[id])

    const handleDelete = () =>{
        deleteAdmin(id).then(alert("Admin with ID " + id + " has been deleted")).then(navigate("/"))
    }

    return (
        <div>
            <AdminNavbar />
            {admin != null &&
                <div>
          <section class="vh-100">
            <div class="py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-lg-6 mb-4 mb-lg-0">
                  <div class="card">
                    <div class="row g-0">
                      <div class="col-md-4 gradient-custom text-center text-white">
                        <img
                          src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                          alt="Avatar"
                          class="img-fluid my-5"
                        />
                        <h5>{admin.userName}</h5>
                      </div>

                      <div class="col-md-8">
                        <div class="card-body p-4">
                          <h6>Information</h6>
                          <hr class="mt-0 mb-4"></hr>
                          <div class="row pt-1">
                            <div class="col-6 mb-3">
                              <h6>User Name</h6>
                              <p class="text-muted">{admin.userName}</p>
                            </div>
                          </div>
                          <h6>Contact</h6>
                          <hr class="mt-0 mb-4" />
                          <div class="row pt-1">
                            <div class="col-6 mb-3">
                              <h6>Phone Number</h6>
                              <p class="text-muted">{admin.number}</p>
                            </div>
                          </div>
                          <div class="d-flex justify-content-start">
                            <Link
                              to={`/admin/edit/${admin.adminId}`}
                              className="btn btn-dark"
                            >
                              Edit
                            </Link>
                            <button
                              onClick={handleDelete}
                              className="btn btn-danger"
                            >
                              Delete Account
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
            

                
            }
        </div>
    )
}
export default GetAdmin;