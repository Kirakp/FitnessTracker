import { baseUrl } from "../util/AppConstants";
import axios from "axios";

export function userSignIn(userName, password) {
    
    const config = { headers: {'Content-Type': 'text/plain'} };
    
    // const payload = {
    //     password : password
    // }
    return axios.put(baseUrl + "/fitness/login/?userValue="+userName, password, config)
}

export function adminSignIn(userName, password){
    const config = { headers: {'Content-Type': 'text/plain'} };

    return axios.put(baseUrl+"/admin/login/?userValue="+userName, password, config)
}

