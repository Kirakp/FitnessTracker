import React, { useState, useEffect } from "react";
import { Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import UserNavbar from "./UserNavbar";
import { getAllUsers } from "../services/Service";
import AdminNavbar from "./AdminNavbar";

function GetAllUsers() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getAllUsers().then((res) => setUsers(res.data));
  }, []);

  return (
    <>
      <AdminNavbar/>
      <div class="vh-100">
        <div class="container ">
          <div class="table-responsive ">
            <table class="table table-bordered">
              <thead class="table-dark">
                <tr>
                  <th>User ID</th>
                  <th>Username</th>
                  <th>Name</th>
                  <th>Contact</th>
                  <th>Height</th>
                  <th>Weight</th>
                  <th>Date of Birth</th>
                  <th>View User</th>
                </tr>
              </thead>
              <tbody>
                {users.map((u) => (
                  <tr key={u.userId}>
                    <td>{u.userId}</td>
                    <td>{u.userName}</td>
                    <td>{u.name}</td>
                    <td>{u.contact}</td>
                    <td>{u.height}</td>
                    <td>{u.weight}</td>
                    <td>{u.dob}</td>
                    <td>
                      <Link to={`/user/${u.userId}`}> 👤 </Link>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
}

export default GetAllUsers;
