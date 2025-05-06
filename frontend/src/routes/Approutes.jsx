import React from 'react'
import { Route,Routes } from 'react-router-dom';
import Home from '../Components/Home.jsx'
import Order from '../Components/Order.jsx'
import Login from '../Components/Login.jsx'
import Profile from '../Components/Profile.jsx';
const Approutes = () => {
  return (
    <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/order" element={<Order/>} />
        <Route path="/login" element={<Login/>} />
        <Route path="/profile" element={<Profile/>} />
    </Routes>
  )
}

export default Approutes
