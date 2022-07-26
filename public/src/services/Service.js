import { baseUrl } from "../util/AppConstants";
import axios from "axios";


//^USER
export function getAllUsers() {
    return axios.get(baseUrl + "/fitness/users");
}

export function registerUser(user){
    return axios.post(baseUrl+ "/fitness/register", user);
}

export function editUser(userId, user){
    return axios.put(baseUrl+ "/fitness/update_user/" +userId, user)
}


//^ADMIN
export function getAllAdmins(){
    return axios.get(baseUrl + "/admin/getadmin");
}

export function registerAdmin(admin){
    return axios.post(baseUrl + "/admin/register/", admin);
}

export function getUserById(userId){
    return axios.get(baseUrl+ "/admin/getuser/" + userId)
}

export function getAdminById(adminId){
    return axios.get(baseUrl+ "/admin/getadmin/" + adminId)
}

export function editAdmin(adminId, admin){
    return axios.put(baseUrl + "/admin/update_admin/" +adminId , admin);
}

export function deleteAdmin(adminId){
    return axios.delete(baseUrl+ "/admin/delete_admin/?id="+ adminId)
}

export function deleteUser(userId){
    return axios.delete(baseUrl+ "/admin/delete_user/?id=" + userId)
}

//^ACTIVITY
export function getAllActivities(){
    return axios.get(baseUrl + "/activity/");
}
    
export function addActivity(activity){
    return axios.post(baseUrl+ "/activity/addactivity", activity);
}

//^USER ACTIVITY
export function getAllUserActivities(){
    return axios.get(baseUrl+ "/useractivity")
}

export function addUserActivity(userActivity){
    return axios.post(baseUrl+ "/useractivity/addUserActivity" ,userActivity)
}

export function getUserActivityById(userId){
    return axios.get(baseUrl + "/useractivity/" + userId)
}

export function editUserActivity(userActivityId, userActivity){
    return axios.put(baseUrl + "/useractivity/update/" +userActivityId, userActivity)
}

export function deleteUserActivity(userActivityId){
    return axios.delete(baseUrl + "/useractivity/delete/" +userActivityId)
}

//^DIET ITEM
export function getAllDietItems(){
    return axios.get(baseUrl+ "/diet_item/get_diet");
}

export function addDietItem(dietItem){
    return axios.post(baseUrl+ "/diet_item/add_diet", dietItem)
}

//^DIET
export function getAllDiets(){
    return axios.get(baseUrl+ "/diet/getdiet");
}

export function addDiet(diet){
    return axios.post(baseUrl+ "/diet/adddiet", diet)
}


//^USER DIET
export function getAllUserDiets(){
    return axios.get(baseUrl+ "/userdiet/viewDiet");
}

export function addUserDiet(userDiet){
    return axios.post(baseUrl+ "/userdiet/addUserDiet", userDiet);
}

export function getUserDietById(userId){
    return axios.get(baseUrl + "/userdiet/viewDiet/" +userId)
}

export function editUserDiet(userDietId, userDiet){
    return axios.put(baseUrl + "/userdiet/update/" +userDietId, userDiet)
}

export function deleteUserDiet(userDietId){
    return axios.delete(baseUrl + "/userdiet/delete/" + userDietId)
}




