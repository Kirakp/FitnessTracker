import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { editAdmin, getAdminById } from "../services/Service";

function EditAdmin() {
  const [adminId, setAdminId] = useState(0);
  const [password, setPassword] = useState("");
  const [number, setNumber] = useState(0);
  const [userName, setUserName] = useState("");

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    getAdminById(id).then((res) => {
      setAdminId(res.data.adminId);
      setPassword(res.data.password);
      setNumber(res.data.number);
      setUserName(res.data.userName);
    });
  }, [id]);

  const handleSubmit = () => {
    const payload = {
      adminId: adminId,
      password: password,
      number: number,
      userName: userName,
    };
    editAdmin(id,payload)
      .then((res) => navigate(-1)).then(alert("Details have been modified"))
      .catch((error) => console.log("Something went wrong"));
  };

  return (
    <div>
      <div>
        <label>Admin ID:</label>
        <input
          type="number"
          id="adminId"
          name="adminId"
          value={adminId}
          disabled
        />
      </div>
      <div>
        <label>User Name:</label>
        <input
          type="text"
          id="userName"
          name="userName"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />
      </div>
      <div>
        <label>Contact Number:</label>
        <input
          type="number"
          id="number"
          name="number"
          value={number}
          onChange={(e) => setNumber(e.target.value)}
        />
      </div>
      <div>
        <label>Password:</label>
        <input
          type="password"
          id="password"
          name="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>

      <div>
        <button class="btn btn-primary" onClick={handleSubmit}>
          Edit Admin
        </button>
      </div>
    </div>
  );
}

export default EditAdmin;
