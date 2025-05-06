import React, { useState, useEffect } from 'react';
import { PlusCircle, Edit, Save, XCircle } from 'lucide-react';
import axios from 'axios';
import { API_PATHS, BASE_URL } from '../apis/Apipaths.js';

const Profile = () => {
  const [activeTab, setActiveTab] = useState('profile');
  const [foodItems, setFoodItems] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const [editingFood, setEditingFood] = useState(null);
  
  // Form states - updated to match Java model variable names
  const [newFood, setNewFood] = useState({
    food_name: '',
    price: '',
    category: 'VEG', // Default to veg
    isAvailable: true, // Changed from 'availability' to 'isAvailable'
    description: ''
  });

  useEffect(() => {
    // Fetch food items if on food management tabs
    if (activeTab === 'editFood' || activeTab === 'addFood') {
      fetchFoodItems();
    }
  }, [activeTab]);

  const fetchFoodItems = async () => {
    setIsLoading(true);
    try {
      const response = await axios.get(`${BASE_URL}/food/allfood`);
      setFoodItems(response.data);
      setError(null);
    } catch (err) {
      console.error('Error fetching food items:', err);
      setError('Failed to load food items. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };

  const handleAddFood = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    
    try {
      // Convert price from string to integer to match the Java model
      const foodToAdd = {
        ...newFood,
        price: parseInt(newFood.price)
      };
      
      const response = await axios.post(`${BASE_URL}${API_PATHS.FOOD.ADD_FOOD}`, foodToAdd);
      setFoodItems([...foodItems, response.data]);
      setNewFood({
        food_name: '',
        price: '',
        category: 'VEG',
        isAvailable: true,
        description: ''
      });
      alert('Food item added successfully!');
    } catch (err) {
      console.error('Error adding food item:', err);
      setError('Failed to add food item. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };

  const startEditing = (food) => {
    setEditingFood({
      ...food,
      price: parseInt(food.price) // Ensure price is an integer
    });
  };

  const cancelEditing = () => {
    setEditingFood(null);
  };

  const handleEditChange = (e) => {
    const { name, value, type, checked } = e.target;
    setEditingFood({
      ...editingFood,
      [name]: type === 'checkbox' ? checked : value
    });
  };

  const saveEdit = async () => {
    setIsLoading(true);
    try {
      // Convert price from string to integer before sending to API
      const foodToUpdate = {
        ...editingFood,
        price: parseInt(editingFood.price)
      };
      
      await axios.put(`${BASE_URL}${API_PATHS.FOOD.UPDATE_FOOD}`, foodToUpdate);
      
      // Update the local state
      setFoodItems(foodItems.map(item => 
        item.foodid === editingFood.foodid ? foodToUpdate : item
      ));
      
      setEditingFood(null);
      alert('Food item updated successfully!');
    } catch (err) {
      console.error('Error updating food item:', err);
      setError('Failed to update food item. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };

  const handleInputChange = (e) => {
    const { name, value, type, checked } = e.target;
    setNewFood({
      ...newFood,
      [name]: type === 'checkbox' ? checked : value
    });
  };

  // Get user from localStorage
  const user = JSON.parse(localStorage.getItem('user') || '{}');
  const isAdmin = user && (user.userName === 'admin' && user.userPassword === 'admin123');
  const isLoggedIn = user && user.userName && user.userPassword;

  // If not logged in or not admin
  if (!isLoggedIn) {
    return (
      <div className="flex flex-col items-center justify-center h-screen bg-gray-100">
        <h1 className="text-3xl font-bold mb-4">Please log in to view your profile</h1>
      </div>
    );
  }

  if (!isAdmin) {
    return (
      <div className="flex flex-col items-center justify-center h-screen bg-gray-100">
        <h1 className="text-3xl font-bold mb-4 text-red-600">You are not authorized to view this page</h1>
      </div>
    );
  }

  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold mb-6 text-center">Admin Dashboard</h1>
      
      {/* Tab navigation */}
      <div className="flex border-b mb-6">
        <button 
          className={`px-4 py-2 font-medium ${activeTab === 'profile' ? 'border-b-2 border-blue-500 text-blue-600' : 'text-gray-600'}`}
          onClick={() => setActiveTab('profile')}
        >
          Profile
        </button>
        <button 
          className={`px-4 py-2 font-medium ${activeTab === 'addFood' ? 'border-b-2 border-blue-500 text-blue-600' : 'text-gray-600'}`}
          onClick={() => setActiveTab('addFood')}
        >
          Add Food
        </button>
        <button 
          className={`px-4 py-2 font-medium ${activeTab === 'editFood' ? 'border-b-2 border-blue-500 text-blue-600' : 'text-gray-600'}`}
          onClick={() => setActiveTab('editFood')}
        >
          Edit Food
        </button>
      </div>

      {/* Profile Tab */}
      {activeTab === 'profile' && (
        <div className="flex flex-col items-center">
          <div className="bg-white shadow-md rounded-lg p-6 w-full max-w-md">
            <h2 className="text-xl font-semibold mb-4">Admin Information</h2>
            <p className="text-gray-700 mb-2">Username: {user.userName}</p>
            <p className="text-gray-700 mb-2">Phone: {user.userPhone || 'Not provided'}</p>
            <p className="text-gray-700 mb-2">Role: Administrator</p>
          </div>
        </div>
      )}

      {/* Add Food Tab */}
      {activeTab === 'addFood' && (
        <div className="bg-white shadow-md rounded-lg p-6">
          <h2 className="text-xl font-semibold mb-4 flex items-center">
            <PlusCircle className="mr-2" size={20} />
            Add New Food Item
          </h2>

          {error && (
            <div className="bg-red-100 p-3 rounded-md text-red-700 mb-4">
              {error}
            </div>
          )}

          <form onSubmit={handleAddFood}>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-4">
              <div>
                <label className="block text-gray-700 text-sm font-medium mb-1">
                  Food Name*
                </label>
                <input
                  type="text"
                  name="food_name"
                  value={newFood.food_name}
                  onChange={handleInputChange}
                  className="w-full p-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                  required
                />
              </div>
              
              <div>
                <label className="block text-gray-700 text-sm font-medium mb-1">
                  Price (₹)*
                </label>
                <input
                  type="number"
                  name="price"
                  value={newFood.price}
                  onChange={handleInputChange}
                  className="w-full p-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                  min="0"
                  step="1" // Changed to step="1" since price is integer in the Java model
                  required
                />
              </div>
              
              <div>
                <label className="block text-gray-700 text-sm font-medium mb-1">
                  Category*
                </label>
                <select
                  name="category"
                  value={newFood.category}
                  onChange={handleInputChange}
                  className="w-full p-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                  required
                >
                  <option value="VEG">VEG</option>
                  <option value="NON_VEG">NON_VEG</option>
                </select>
              </div>
              
              <div className="flex items-center">
                <label className="flex items-center cursor-pointer mt-6">
                  <input
                    type="checkbox"
                    name="isAvailable" // Changed from 'availability' to 'isAvailable'
                    checked={newFood.isAvailable}
                    onChange={handleInputChange}
                    className="form-checkbox h-5 w-5 text-blue-600"
                  />
                  <span className="ml-2 text-gray-700">Available for Order</span>
                </label>
              </div>
            </div>
            
            <div className="mb-4">
              <label className="block text-gray-700 text-sm font-medium mb-1">
                Description
              </label>
              <textarea
                name="description"
                value={newFood.description}
                onChange={handleInputChange}
                className="w-full p-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"
                rows="3"
              ></textarea>
            </div>
            
            <button
              type="submit"
              className="bg-green-600 hover:bg-green-700 text-white py-2 px-4 rounded-md transition-colors flex items-center"
              disabled={isLoading}
            >
              {isLoading ? (
                <>
                  <span className="animate-spin mr-2">⟳</span> Adding...
                </>
              ) : (
                <>
                  <PlusCircle size={16} className="mr-2" /> Add Food Item
                </>
              )}
            </button>
          </form>
        </div>
      )}

      {/* Edit Food Tab */}
      {activeTab === 'editFood' && (
        <div className="bg-white shadow-md rounded-lg p-6">
          <h2 className="text-xl font-semibold mb-4 flex items-center">
            <Edit className="mr-2" size={20} />
            Edit Food Items
          </h2>

          {error && (
            <div className="bg-red-100 p-3 rounded-md text-red-700 mb-4">
              {error}
            </div>
          )}

          {isLoading && !editingFood ? (
            <div className="text-center py-8">
              <span className="animate-spin inline-block mr-2">⟳</span> Loading food items...
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="min-w-full bg-white">
                <thead>
                  <tr className="bg-gray-100 text-gray-700 text-sm uppercase font-semibold">
                    <th className="py-3 px-4 text-left">ID</th>
                    <th className="py-3 px-4 text-left">Name</th>
                    <th className="py-3 px-4 text-left">Category</th>
                    <th className="py-3 px-4 text-left">Price</th>
                    <th className="py-3 px-4 text-left">Availability</th>
                    <th className="py-3 px-4 text-left">Actions</th>
                  </tr>
                </thead>
                <tbody className="text-gray-600">
                  {foodItems.map(food => (
                    <tr key={food.foodid} className="border-b hover:bg-gray-50">
                      {editingFood && editingFood.foodid === food.foodid ? (
                        <>
                          <td className="py-3 px-4">{food.foodid}</td>
                          <td className="py-3 px-4">{food.food_name}</td>
                          <td className="py-3 px-4">{food.category}</td>
                          <td className="py-3 px-4">
                            <input
                              type="number"
                              name="price"
                              value={editingFood.price}
                              onChange={handleEditChange}
                              className="w-24 p-1 border rounded"
                              min="0"
                              step="1" // Changed to step="1" for integer values
                            />
                          </td>
                          <td className="py-3 px-4">
                            <input
                              type="checkbox"
                              name="isAvailable" // Changed from 'availability' to 'isAvailable'
                              checked={editingFood.isAvailable}
                              onChange={handleEditChange}
                              className="form-checkbox h-5 w-5 text-blue-600"
                            />
                          </td>
                          <td className="py-3 px-4">
                            <div className="flex space-x-2">
                              <button 
                                onClick={saveEdit}
                                className="text-green-600 hover:text-green-800"
                                disabled={isLoading}
                              >
                                <Save size={18} />
                              </button>
                              <button 
                                onClick={cancelEditing}
                                className="text-red-600 hover:text-red-800"
                              >
                                <XCircle size={18} />
                              </button>
                            </div>
                          </td>
                        </>
                      ) : (
                        <>
                          <td className="py-3 px-4">{food.foodid}</td>
                          <td className="py-3 px-4">{food.food_name}</td>
                          <td className="py-3 px-4">
                            <span className={`px-2 py-1 rounded-full text-xs ${food.category === 'VEG' ? 'bg-green-100 text-green-800' : 'bg-red-100 text-red-800'}`}>
                              {food.category}
                            </span>
                          </td>
                          <td className="py-3 px-4">₹{food.price}</td>
                          <td className="py-3 px-4">
                            <span className={`px-2 py-1 rounded-full text-xs ${food.isAvailable ? 'bg-green-100 text-green-800' : 'bg-gray-100 text-gray-800'}`}>
                              {food.isAvailable ? 'Available' : 'Unavailable'}
                            </span>
                          </td>
                          <td className="py-3 px-4">
                            <button 
                              onClick={() => startEditing(food)}
                              className="text-blue-600 hover:text-blue-800"
                            >
                              <Edit size={18} />
                            </button>
                          </td>
                        </>
                      )}
                    </tr>
                  ))}
                  
                  {foodItems.length === 0 && !isLoading && (
                    <tr>
                      <td colSpan="6" className="py-8 text-center text-gray-500">
                        No food items found. Add some from the "Add Food" tab.
                      </td>
                    </tr>
                  )}
                </tbody>
              </table>
            </div>
          )}
        </div>
      )}
    </div>
  );
};

export default Profile;