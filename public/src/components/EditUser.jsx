import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { editUser, getUserById } from "../services/Service";


function EditUser() {
    const [userId, setUserId] = useState(0);
    const [userName , setUserName] = useState("");
    const [name , setName] = useState("");
    const [password , setPassword] = useState("");
    const [contact , setContact] = useState("");
    const [height , setHeight] = useState(0);
    const [weight , setWeight] = useState(0);
    const [dob , setDob] = useState("");
  
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getUserById(id).then((res)=> {
            setUserId(res.data.userId);
            setUserName(res.data.userName);
            setName(res.data.name);
            setPassword(res.data.password);
            setContact(res.data.contact);
            setHeight(res.data.height);
            setWeight(res.data.weight);
            setDob(res.data.dob);
        });
    }, [id]);

    const handleSubmit = () => {
        const payload = {
            userId: userId,
            userName: userName,
            name: name,
            password: password,
            contact : contact,
            height : height,
            weight : weight,
            dob : dob
        };

        editUser(id,payload).then(alert("Details have been modified")).then(res => navigate('/')).catch(error=>console.log("Something went wrong"))
    }
  
    return (
    <div>
        <div>
            <label>User ID:</label>
            <input type="number" name="userId" id="userId" value={userId} disabled/>
        </div>
        <div>
            <label>User Name:</label>
            <input type="text" name="userName" id="userName" value={userName} onChange={e=> setUserName(e.target.value)}/>
        </div>
        <div>
            <label>Name:</label>
            <input type="text" name="name" id="name" value={name} onChange={e=> setName(e.target.value)}/>
        </div>
        <div>
            <label>Password:</label>
            <input type="password" name="password" id="password" value={password} onChange={e=> setPassword(e.target.value)}/>
        </div>
        <div>
            <label>Contact:</label>
            <input type="text" name="contact" id="contact" value={contact} onChange={e=> setContact(e.target.value)}/>
        </div>
        <div>
            <label>Height:</label>
            <input type="number" name="height" id="height" value={height} onChange={e=> setHeight(e.target.value)}/>
        </div>
        <div>
            <label>Weight:</label>
            <input type="number" name="weight" id="weight" value={weight} onChange={e=> setWeight(e.target.value)}/>
        </div>
        <div>
            <label>Date of Birth:</label>
            <input type="date" name="dob" id="dob" value={dob} onChange={e=> setDob(e.target.value)}/>
        </div>

        <div>
            <button class='btn btn-primary' onClick={handleSubmit}>Edit User</button>
        </div>

    </div>
  )
}

export default EditUser