import React, { useState } from 'react';
import axios from 'axios';
import { BASE_URL, API_PATHS } from '../apis/Apipaths';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [userName, setUserName] = useState('');
  const [userPassword, setuserPassword] = useState('');
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const handlelogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(`${BASE_URL}${API_PATHS.USER.USER_LOGIN}`, {
        userName,
        userPassword,
      });
      if(response){
        console.log('Login successful:', response.data);
        localStorage.setItem('user',JSON.stringify(response.data)); // Store token in local storage
        navigate('/');
      }
    } catch (error) {
      console.error('Login failed:', error.response?.data || error.message);
      setError('Invalid username or password. Please try again.');
    }
  };

  return (
    <div>
      <h1 className="text-3xl font-bold text-center mt-10">Login</h1>
      <form className="flex flex-col items-center mt-5" onSubmit={handlelogin}>
        <label>USERNAME</label>
        <input
          type="text"
          placeholder="Username"
          className="border p-2 mb-4"
          onChange={(e) => setUserName(e.target.value)}
        />
        <label>PASSWORD</label>
        <input
          type="password"
          placeholder="Password"
          className="border p-2 mb-4"
          onChange={(e) => setuserPassword(e.target.value)}
        />
        <button type="submit" className="bg-blue-500 text-white p-2 rounded">
          Login
        </button>
        {error && <p className="text-red-500 mt-2">{error}</p>}
      </form>
    </div>
  );
};

export default Login;
