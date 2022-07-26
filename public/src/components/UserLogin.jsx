import React, { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom';
import { userSignIn } from '../services/AuthenticationService';

function UserLogin() {
    
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const navigate= useNavigate();

    const [authFailed, setAuthFailed] = useState('')
    const [formErrors, setFormErrors] = useState([])

    const handleSubmit = (event) => {
        //Validation of login
        let errors= {}

        if (!userName){
            errors["userNameError"] = "Please enter a username"
        }
        if (!password){
            errors["passwordError"] = "Please enter a password"
        }

        setFormErrors(errors)

        const noErrors = Object.keys(errors).length === 0
        if (noErrors){
            userSignIn(userName, password).then(res=> {
                localStorage.setItem("loggedInUser", JSON.stringify(res.data));
                navigate("/user/dashboard");
            }).catch(error => setAuthFailed(error.response.data))
        }
        event.preventDefault();   
    }
  
    return (
        <>
        {/*  <!-- Pills content --> */}
        <div class="tab-content">
          <div
            class="tab-pane fade show active"
            id="pills-login"
            role="tabpanel"
            aria-labelledby="tab-login"
          >
            <div style={{ color: "red", paddingBottom: 10 }}>{authFailed}</div>
  
            <form>
              <div class="text-center mb-3">
                <p>Sign in with:</p>
                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-facebook-f"></i>
                </button>
  
                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-google"></i>
                </button>
  
                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-twitter"></i>
                </button>
  
                <button type="button" class="btn btn-link btn-floating mx-1">
                  <i class="fab fa-github"></i>
                </button>
              </div>
  
              <p class="text-center">or:</p>
  
              {/* <!-- Email input --> */}
              <div class="form-outline mb-4">
                <input
                  id="loginName"
                  class="form-control"
                  value={userName}
                  onChange={(e) => setUserName(e.target.value)}
                />
                {formErrors.userNameError && (
                  <div style={{ color: "red", paddingBottom: 10 }}>
                    {formErrors.userNameError}{" "}
                  </div>
                )}
  
                <label class="form-label" for="loginName">
                  username
                </label>
              </div>
  
              {/* <!-- Password input --> */}
              <div class="form-outline mb-4">
                <input
                  type="password"
                  id="loginPassword"
                  class="form-control"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
                {formErrors.passwordError ? (
                  <div style={{ color: "red", paddingBottom: 10 }}>
                    {formErrors.passwordError}{" "}
                  </div>
                ) : (
                  <></>
                )}
                <label class="form-label" for="loginPassword">
                  Password
                </label>
              </div>
  
              {/* <!-- 2 column grid layout --> */}
  
              {/* <!-- Submit button --> */}
              <button
                type="submit"
                class="btn btn-outline-primary btn-block mb-4 "
                onClick={handleSubmit}
              >
                Sign in
              </button>
  
              <hr></hr>
              {/* <!-- Register buttons --> */}
              <div class="text-center">
                <p></p>
                Not a member? <br></br>
                <Link
                  className="btn btn-outline-primary mb-2"
                  aria-current="page"
                  to="/user/register"
                >
                  Register{" "}
                </Link>
              </div>
            </form>
          </div>
        </div>
        {/*  <!-- Pills content --> */}
      </>
  )
}

export default UserLogin