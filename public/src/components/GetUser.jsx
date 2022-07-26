import React, { useEffect, useState } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";
import { deleteUser, getUserById } from "../services/Service";
import UserNavbar from "./UserNavbar";

function GetUser() {
  const [user, SetUser] = useState(null);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    getUserById(id).then((res) => SetUser(res.data));
  }, [id]);

  const handleDelete = () => {
    deleteUser(id)
      .then(alert("User with ID " + id + " has been deleted"))
      .then(navigate("/"));
  };

  return (
    <div>
      <UserNavbar />
      <br />
      <br />
      <br />
      {user != null && (
        <section class="mh-100 overflow-hidden">
          <div class="py-2 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
              <div class="col col-lg-6 mb-4 mb-lg-0">
                <div class="card">
                  <div class="row g-0">
                    <div class="col-md-4 gradient-custom text-center text-white">
                      <img
                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                        alt="Avatar"
                        class="img-fluid my-4"
                      />
                      <h5 className="text-black">{user.userName}</h5>
                    </div>

                    <div class="col-md-8">
                      <div class="card-body p-4">
                        <h6>Information</h6>
                        <hr class="mt-0 mb-4"></hr>
                        <div class="row pt-1">
                          <div class="col-6 mb-3">
                            <h6>Phone</h6>
                            <p class="text-muted">{user.contact}</p>
                          </div>
                          <div class="col-6 mb-3">
                            <h6>Date of Birth</h6>
                            <p class="text-muted">{user.dob}</p>
                          </div>
                        </div>
                        <h6>Measurements</h6>
                        <hr class="mt-0 mb-4" />
                        <div class="row pt-1">
                          <div class="col-6 mb-3">
                            <h6>Height</h6>
                            <p class="text-muted">{user.height}</p>
                          </div>
                          <div class="col-6 mb-3">
                            <h6>Weight</h6>
                            <p class="text-muted">{user.weight}</p>
                          </div>
                        </div>
                        <div class="d-flex justify-content-center">
                          <Link
                            to={`/user/edit/${user.userId}`}
                            className="btn btn-dark"
                          >
                            Edit
                          </Link> &nbsp;
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
      )}
    </div>
  );
}

export default GetUser;
