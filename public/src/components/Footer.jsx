import React from 'react'
import '../styles/Footer.css'


function Footer() {
  
    let currentYear = new Date().getFullYear();
  
    return (
    <div className='footer'>

        <p> &copy; {currentYear} Fitness Tracker</p>
    </div>
  )
}

export default Footer