import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import Footer from "./components/Footer";
import GetAllUsers from "./components/GetAllUsers";
import RegisterUser from "./components/RegisterUser";
import RegisterAdmin from "./components/RegisterAdmin";
import GetUser from "./components/GetUser";
import EditUser from "./components/EditUser";
import GetAllAdmin from "./components/GetAllAdmin";
import GetAllActivities from "./components/GetAllActivities";
import AddActivity from "./components/AddActivity";
import EditAdmin from "./components/EditAdmin";
import GetAdmin from "./components/GetAdmin";
import UserDashboard from "./components/UserDashboard";
import UserLogin from "./components/UserLogin";
import GetDiets from "./components/GetAllDiets";
import AddDiet from "./components/AddDiet";
import AdminLogin from "./components/AdminLogin";
import AdminDashboard from "./components/AdminDashboard";
import GetAllDietItems from "./components/GetAllDietItems";
import AddDietItem from "./components/AddDietItem";
import AddUserDiet from "./components/AddUserDiet";
import GetAllUserDiets from "./components/GetAllUserDiets";
import GetAllUserActivities from "./components/GetAllUserActivities";
import AddUserActivity from "./components/AddUserActivity";
import GetUserActivity from "./components/GetUserActivity";
import GetUserDiet from "./components/GetUserDiet";
import EditUserDiet from "./components/EditUserDiet";
import EditUserActivity from "./components/EditUserActivity";
import WeeklyReport from "./components/WeeklyReport";
import Activity from "./components/Activity";
import Diet from "./components/Diet";
import {Navbar} from "react-bootstrap";
import UserNavbar from "./components/UserNavbar";
import GetActivityPlan from "./components/GetActivityPlan";
import GetDietPlan from "./components/GetDietPlan";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />

          <Route path="/user/all" element={<GetAllUsers />} />
          <Route path="/user/register" element={<RegisterUser />} />
          <Route path="/user/login" element={<UserLogin />} />
          <Route path="/user/dashboard" element={<UserDashboard />} />
          <Route path="/user/:id" element={<GetUser />} />
          <Route path="/user/edit/:id" element={<EditUser />} />

          <Route path="/admin/register" element={<RegisterAdmin />} />
          <Route path="/admin/login" element={<AdminLogin />} />
          <Route path="/admin/dashboard" element={<AdminDashboard />} />
          <Route path="/admin/all" element={<GetAllAdmin />} />
          <Route path="/admin/:id" element={<GetAdmin />} />
          <Route path="/admin/edit/:id" element={<EditAdmin />} />

          <Route path="/activities" element={<GetAllActivities />} />
          <Route path="/activityplan" element={<GetActivityPlan />} />
          <Route path="/dietplan" element={<GetDietPlan />} />
          <Route path="/activities/add" element={<AddActivity />} />
          <Route path="/useractivities" element={<GetAllUserActivities />} />
          <Route path="/useractivities/add" element={<AddUserActivity />} />
          <Route path="/useractivities/:id" element={<GetUserActivity />} />
          <Route
            path="/useractivities/edit/:id"
            element={<EditUserActivity />}
          />
          <Route path="/useractivities1/:id" element={<Activity />} />

          <Route path="/diets" element={<GetDiets />} />
          <Route path="/diets/add" element={<AddDiet />} />
          <Route path="/dietitems" element={<GetAllDietItems />} />
          <Route path="/dietitems/add" element={<AddDietItem />} />
          <Route path="/userdiets" element={<GetAllUserDiets />} />
          <Route path="/userdiets/:id" element={<GetUserDiet />} />
          <Route path="/userdiets/add" element={<AddUserDiet />} />
          <Route path="/userdiets/edit/:id" element={<EditUserDiet />} />
          <Route path="/userdiets1/:id" element={<Diet />} />

          <Route path="/userreport/:id" element={<WeeklyReport />} />
        </Routes>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
