// import {React,useState,useEffect} from 'react'
// import axios from 'axios'
// import {API_PATHS,BASE_URL} from '../apis/Apipaths.js'
// const Order = () => {
//     const [food,setfood]=useState([])
//     const [isLoading, setIsLoading] = useState(true);
//     const [error, setError] = useState(null);

//     useEffect(()=>{
//         const fetchData = async () => {
//             setIsLoading(true);
//             try {
//               const response = await axios.get(`${BASE_URL}/food/allfood`);
//               setfood(response.data);
//               setError(null);
//             } catch (error) {
//               console.error('Error fetching food:', error);
//               setError('Failed to load food data. Please try again later.');
//             } finally {
//               setIsLoading(false);
//             }
//           };
      
//           fetchData();
//         }, []);
//   return (
//     <div>
//         <h1 className='text-3xl font-bold'>Order</h1>
//         <p className='text-lg'>This is the order page</p>
//         <div className='flex flex-col items-center justify-center'>
//             <button className='bg-blue-500 text-white px-4 py-2 rounded'>Place Order</button>
//             {isLoading ? (
//           <div className="flex justify-center items-center h-64">
//             <div className="animate-spin rounded-full h-12 w-12 border-t-2 border-b-2 border-blue-500"></div>
//           </div>
//         ) : error ? (
//           <div className="bg-red-100 border-l-4 border-red-500 text-red-700 p-4 rounded shadow">
//             <p>{error}</p>
//           </div>
//         ) : (
//           <div className="bg-white rounded-lg shadow-lg overflow-hidden">
//             <div className="overflow-x-auto">
//               <table className="w-full table-auto">
//                 <thead>
//                   <tr className="bg-gray-100 text-gray-700 uppercase text-sm leading-normal">
//                     <th className="py-3 px-6 text-left">Food ID</th>
//                     <th className="py-3 px-6 text-left">Food Name</th>
//                     <th className="py-3 px-6 text-right">Price</th>
//                   </tr>
//                 </thead>
//                 <tbody className="text-gray-600 text-sm">
//                   {food.length === 0 ? (
//                     <tr>
//                       <td colSpan="3" className="py-4 px-6 text-center">No food items available</td>
//                     </tr>
//                   ) : (
//                     food.map((item) => (
//                       <tr key={item.foodid} className="border-b border-gray-200 hover:bg-gray-50">
//                         <td className="py-3 px-6 text-left">{item.foodid}</td>
//                         <td className="py-3 px-6 text-left font-medium">{item.food_name}</td>
//                         <td className="py-3 px-6 text-right">${parseFloat(item.price).toFixed(2)}</td>
//                       </tr>
//                     ))
//                   )}
//                 </tbody>
//               </table>
//             </div>
//           </div>
//         )}
//         </div>
//     </div>
//   )
// }

// export default Order

import { React, useState, useEffect } from 'react';
import { ShoppingCart, Search, Loader2, CheckCircle } from 'lucide-react';
import axios from 'axios';
import { BASE_URL } from '../apis/Apipaths.js';

const Order = () => {
  const [food, setFood] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [cart, setCart] = useState([]);
  const [orderPlaced, setOrderPlaced] = useState(false);
  const [showOrderSummary, setShowOrderSummary] = useState(false);
  const orderId = localStorage.getItem("orderId");
  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);
      try {
        const response = await axios.get(`${BASE_URL}/food/allfood`);
        setFood(response.data);
        setError(null);
      } catch (error) {
        console.error('Error fetching food:', error);
        setError('Failed to load food data. Please try again later.');
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();
  }, []);

  const addToCart = (item) => {
    const existingItem = cart.find(cartItem => cartItem.foodid === item.foodid);
    
    if (existingItem) {
      setCart(cart.map(cartItem => 
        cartItem.foodid === item.foodid 
          ? { ...cartItem, quantity: cartItem.quantity + 1 } 
          : cartItem
      ));
    } else {
      setCart([...cart, { ...item, quantity: 1 }]);
    }
  };
  console.log(cart);
  const handlePlaceOrder = () => {
    setOrderPlaced(true);
    setShowOrderSummary(true);
  };

  const handlePayNow = () => {
    const paymentDetails = {
      orderId: orderId,
    }
    const response = axios.post(`${BASE_URL}/order/pay`, paymentDetails);
    alert("Payment processing would happen here");
    // Reset cart after successful payment
    setCart([]);
    setOrderPlaced(false);
    setShowOrderSummary(false);
  };

  const filteredFood = food.filter(item => 
    item.food_name.toLowerCase().includes(searchTerm.toLowerCase()) ||
    item.category.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const getTotalPrice = () => {
    return cart.reduce((total, item) => total + (item.price * item.quantity), 0).toFixed(2);
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <div className="flex flex-col md:flex-row justify-between items-center mb-8">
        <h1 className="text-3xl font-bold text-gray-800">Our Menu</h1>
        
        <div className="relative mt-4 md:mt-0">
          <input
            type="text"
            placeholder="Search menu..."
            className="pl-10 pr-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <Search className="absolute left-3 top-2.5 text-gray-400" size={18} />
        </div>
      </div>

      {/* Order Summary Modal */}
      {showOrderSummary && (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
          <div className="bg-white p-6 rounded-lg shadow-lg max-w-md w-full max-h-96 overflow-y-auto">
            <div className="flex justify-between items-center mb-4">
              <h2 className="text-xl font-bold text-gray-800 flex items-center">
                <CheckCircle className="mr-2 text-green-500" size={24} />
                Order Summary
              </h2>
              <button 
                onClick={() => setShowOrderSummary(false)}
                className="text-gray-500 hover:text-gray-700"
              >
                ×
              </button>
            </div>
            
            <div className="divide-y">
              {cart.map((item) => (
                <div key={`summary-${item.foodid}`} className="py-3 flex justify-between">
                  <div>
                    <p className="font-medium">{item.food_name}</p>
                    <p className="text-sm text-gray-500">${parseFloat(item.price).toFixed(2)} × {item.quantity}</p>
                  </div>
                  <p className="font-semibold">${(item.price * item.quantity).toFixed(2)}</p>
                </div>
              ))}
            </div>
            
            <div className="mt-4 pt-4 border-t flex justify-between">
              <p className="font-bold">Total:</p>
              <p className="font-bold">${getTotalPrice()}</p>
            </div>
            
            <button 
              className="mt-6 w-full bg-blue-600 hover:bg-blue-700 text-white py-3 px-4 rounded-md font-medium transition-colors"
              onClick={handlePayNow}
            >
              Pay Now
            </button>
          </div>
        </div>
      )}

      {isLoading ? (
        <div className="flex justify-center items-center h-64">
          <Loader2 className="animate-spin mr-2" size={24} />
          <p>Loading menu items...</p>
        </div>
      ) : error ? (
        <div className="bg-red-100 p-4 rounded-md text-red-700 text-center">
          {error}
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {filteredFood.length === 0 ? (
            <div className="col-span-full text-center p-8 bg-gray-100 rounded-lg">
              <p className="text-gray-500">No food items available matching your search.</p>
            </div>
          ) : (
            filteredFood.map((item) => (
              <div key={item.foodid} className="bg-white rounded-lg shadow-md overflow-hidden hover:shadow-lg transition-shadow">
                <div className="h-48 bg-gray-200 relative">
                  <img 
                    src={`/api/placeholder/400/320`} 
                    alt={item.food_name}
                    className="w-full h-full object-cover"
                  />
                  <div className="absolute top-2 right-2 bg-white py-1 px-2 rounded-full text-sm font-semibold text-gray-700">
                    ${parseFloat(item.price).toFixed(2)}
                  </div>
                </div>
                <div className="p-4">
                  <div className="flex justify-between items-start">
                    <div>
                      <h3 className="font-bold text-lg text-gray-800">{item.food_name}</h3>
                      <span className="text-xs text-gray-500 uppercase">{item.category}</span>
                    </div>
                    <div className="text-xs bg-gray-100 px-2 py-1 rounded">
                      ID: {item.foodid}
                    </div>
                  </div>
                  <p className="text-gray-600 text-sm mt-2">{item.description}</p>
                  <button 
                    className="mt-4 w-full bg-green-600 hover:bg-green-700 text-white py-2 px-4 rounded-md flex items-center justify-center transition-colors"
                    onClick={() => addToCart(item)}
                  >
                    <ShoppingCart size={16} className="mr-2" />
                    Add to Order
                  </button>
                </div>
              </div>
            ))
          )}
        </div>
      )}

      {/* Static Order Section */}
      {cart.length > 0 && (
        <div className="mt-12 bg-white p-6 rounded-lg shadow-md">
          {/* <h2 className="text-2xl font-bold mb-4 text-gray-800 flex items-center">
            <ShoppingCart className="mr-2" size={24} />
            Your Order
          </h2> */}
          {/* <div className="divide-y">
            {cart.map((item) => (
              <div key={`cart-${item.foodid}`} className="py-3 flex justify-between">
                <div>
                  <p className="font-medium">{item.food_name}</p>
                  <p className="text-sm text-gray-500">${parseFloat(item.price).toFixed(2)} × {item.quantity}</p>
                </div>
                <p className="font-semibold">${(item.price * item.quantity).toFixed(2)}</p>
              </div>
            ))}
          </div> */}
          <div className="mt-4 pt-4 border-t flex justify-between">
            <p className="font-bold">Total:</p>
            <p className="font-bold">${getTotalPrice()}</p>
          </div>
          <button 
            className="mt-6 w-full bg-blue-600 hover:bg-blue-700 text-white py-3 px-4 rounded-md font-medium transition-colors"
            onClick={handlePlaceOrder}
          >
            Place Order
          </button>
        </div>
      )}
    </div>
  );
};

export default Order;