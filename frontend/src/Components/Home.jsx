import { useState } from 'react';
import axios from 'axios';
import { 
  Home, User, LogOut, ClipboardCheck, MessageSquare, 
  BarChart2, Wallet, ShoppingCart, Plus
} from 'lucide-react';
import { useNavigate } from 'react-router-dom';
import { API_PATHS, BASE_URL } from '../apis/Apipaths';

export default function FoodOrderingDashboard() {
  const [availableAmount, setAvailableAmount] = useState(0);
  const [showOrderModal, setShowOrderModal] = useState(false);
  const navigate = useNavigate();
  const makeorder = async() => {
    const response = await axios.post(`${BASE_URL}${API_PATHS.ORDER.ADD_ORDER}`);
    console.log("Order CreateD",response.data.orderId);
    localStorage.setItem("orderId",response.data.orderId);
    navigate('/order');
  }
  return (
    <div className="flex flex-col min-h-screen bg-gradient-to-br from-gray-50 to-gray-100">
      {/* Header */}
      <header className="bg-gradient-to-r from-blue-600 to-indigo-700 text-white py-5 px-6 shadow-lg">
        <div className="flex justify-between items-center">
          <h1 className="text-2xl font-bold">FoodHub</h1>
          <div className="flex items-center space-x-2">
            <div className="w-10 h-10 bg-white/20 rounded-full flex items-center justify-center">
              <Bell className="h-5 w-5 text-white" />
            </div>
          </div>
        </div>
      </header>

      {/* Available Amount Banner */}
      <div className="bg-gradient-to-r from-orange-500 to-red-500 text-white py-4 px-6 shadow-md">
        <div className="flex justify-between items-center">
          <span className="text-sm font-medium">Available Balance</span>
          <span className="text-2xl font-bold">${availableAmount.toFixed(2)}</span>
        </div>
      </div>

      {/* Main Content */}
      <div className="flex-grow p-6">
        <h2 className="text-2xl font-semibold mb-6 text-gray-800">Quick Access</h2>
        <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-6">
          {/* Make Order */}
          <MenuCard 
            icon={<ShoppingCart className="w-6 h-6" />}
            title="Make Order"
            bgColor="bg-gradient-to-br from-green-400 to-green-600"
            featured={true}
            onClick={makeorder}
          />
        
          {/* Order Status */}
          <MenuCard 
            icon={<ClipboardCheck className="w-6 h-6" />}
            title="Order Status"
            bgColor="bg-gradient-to-br from-blue-400 to-blue-600"
          />

          {/* Add Cash */}
          <MenuCard 
            icon={<Wallet className="w-6 h-6" />}
            title="Add Cash"
            badge="+"
            bgColor="bg-gradient-to-br from-purple-400 to-purple-600"
          />

          {/* Feedback */}
          <MenuCard 
            icon={<MessageSquare className="w-6 h-6" />}
            title="Feedback"
            bgColor="bg-gradient-to-br from-cyan-400 to-cyan-600"
          />

          {/* Reports */}
          <MenuCard 
            icon={<BarChart2 className="w-6 h-6" />}
            title="Reports"
            bgColor="bg-gradient-to-br from-yellow-400 to-yellow-600"
          />

          {/* My Profile */}
          <MenuCard 
            icon={<User className="w-6 h-6" />}
            title="My Profile"
            bgColor="bg-gradient-to-br from-indigo-400 to-indigo-600"
            onClick={() => navigate('/profile')}
          />
        </div>

        {/* Recent Orders Section */}
        <div className="mt-10">
          <h2 className="text-2xl font-semibold mb-6 text-gray-800">Recent Orders</h2>
          <div className="bg-white rounded-xl shadow-md p-4 divide-y divide-gray-100">
            {[1, 2, 3].map((_, index) => (
              <RecentOrderItem key={index} />
            ))}
          </div>
        </div>
      </div>

      {/* Bottom Navigation */}
      <nav className="bg-white shadow-lg border-t border-gray-100">
        <div className="flex justify-around items-center">
          <NavItem icon={<Home />} label="Home" active />
          <NavItem icon={<ClipboardCheck />} label="Orders" />
          <NavItem icon={<User />} label="Profile" />
          <NavItem icon={<LogOut />} label="Logout" />
        </div>
      </nav>
    </div>
  );
}

// Menu Card Component
function MenuCard({ icon, title, badge, bgColor = "bg-blue-500", featured = false, onClick }) {
  return (
    <div className="relative group cursor-pointer" onClick={onClick}>
      <div className={`${bgColor} rounded-2xl shadow-md p-6 flex flex-col items-center justify-center text-white h-36 transform transition-all duration-300 group-hover:scale-105 group-hover:shadow-xl ${featured ? 'ring-4 ring-green-200' : ''}`}>
        <div className="rounded-full bg-white/20 p-4 mb-4">
          {icon}
        </div>
        <h2 className="font-medium text-base text-center">{title}</h2>
        
        {badge && (
          <div className="absolute -top-2 -right-2 bg-white text-xs font-bold rounded-full w-6 h-6 flex items-center justify-center shadow-md z-10 text-red-500">
            {badge}
          </div>
        )}
        
        {featured && (
          <div className="absolute -bottom-3 right-1/2 transform translate-x-1/2 bg-white rounded-full p-2 shadow-lg">
            <Plus className="w-4 h-4 text-green-500" />
          </div>
        )}
      </div>
    </div>
  );
}

// Navigation Item Component
function NavItem({ icon, label, active = false }) {
  return (
    <div className={`flex flex-col items-center justify-center py-3 px-6 transition-colors duration-200 ${
      active 
        ? 'text-blue-600 border-t-2 border-blue-600 -mt-[2px] pt-[14px]' 
        : 'text-gray-500 hover:text-gray-700'
    }`}>
      {icon}
      <span className="text-xs mt-1 font-medium">{label}</span>
    </div>
  );
}

// Recent Order Item Component
function RecentOrderItem() {
  return (
    <div className="flex items-center justify-between py-3">
      <div className="flex items-center space-x-3">
        <div className="w-12 h-12 bg-gray-100 rounded-lg flex items-center justify-center">
          <ClipboardCheck className="w-6 h-6 text-gray-500" />
        </div>
        <div>
          <h3 className="font-medium text-gray-800">Café Deluxe</h3>
          <p className="text-xs text-gray-500">2 items • May 3, 2025</p>
        </div>
      </div>
      <div className="text-right">
        <p className="font-semibold text-gray-800">$24.50</p>
        <span className="text-xs font-medium px-2 py-1 rounded-full bg-green-100 text-green-700">Delivered</span>
      </div>
    </div>
  );
}

// Bell Icon Component
function Bell(props) {
  return (
    <svg 
      xmlns="http://www.w3.org/2000/svg" 
      viewBox="0 0 24 24" 
      fill="none" 
      stroke="currentColor" 
      strokeWidth="2" 
      strokeLinecap="round" 
      strokeLinejoin="round" 
      {...props}
    >
      <path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9" />
      <path d="M13.73 21a2 2 0 0 1-3.46 0" />
    </svg>
  );
}