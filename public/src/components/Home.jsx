import React from 'react'

import AdminLogin from './AdminLogin';
import UserLogin from './UserLogin';


function Home() {
  return (
    <section class="vh-100">
        <div class="container-fluid h-custom">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
              <img
                src="https://img.freepik.com/free-vector/sport-fitness-tracker-abstract-concept-vector-illustration-activity-band-health-monitor-wrist-worn-device-application-running-cycling-every-day-training-abstract-metaphor_335657-1454.jpg?w=2000"
                class="img-fluid"
                alt="Sample"
              />
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
              <form>
                {/* <!-- Pills navs --> */}
                <ul
                  class="nav nav-pills nav-justified mb-3"
                  id="ex1"
                  role="tablist"
                >
                  <li class="nav-item" role="presentation">
                    <a
                      class="nav-link active"
                      id="tab-login"
                      data-mdb-toggle="pill"
                      href="#pills-login-user"
                      role="tab"
                      aria-controls="pills-login-user"
                      aria-selected="true"
                    >
                      User{" "}
                    </a>
                  </li>
                  <li class="nav-item" role="presentation">
                    <a
                      class="nav-link"
                      id="tab-register"
                      data-mdb-toggle="pill"
                      href="#pills-register"
                      role="tab"
                      aria-controls="pills-register"
                      aria-selected="false"
                    >
                      Admin
                    </a>
                  </li>
                </ul>
                {/* <!-- Pills navs --> */}
                {/* <!-- Pills content --> */}
                <div class="tab-content">
                  <div
                    class="tab-pane fade show active"
                    id="pills-login-user"
                    role="tabpanel"
                    aria-labelledby="tab-login"
                  >
                    <UserLogin />
                  </div>
                  <div
                    class="tab-pane fade"
                    id="pills-register"
                    role="tabpanel"
                    aria-labelledby="tab-register"
                  >
                    <AdminLogin />
                  </div>
                </div>
                {/* <!-- Pills content --> */}
              </form>
            </div>
          </div>
        </div>
      </section>
  )
}

export default Home


