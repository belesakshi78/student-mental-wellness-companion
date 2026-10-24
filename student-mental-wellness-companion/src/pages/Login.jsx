import { useState } from "react";
import { useNavigate } from "react-router";
import axios from "axios";

export default function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        const res = await axios.get('http://localhost:8080/apiusers');
        const user = res.data.find(u => u.email === email && u.setPassword);
    if(user){
        localStorage.setItem("user", JSON.stringify(user));
        navigate("/dashboard");
    }else{
        alert("Wrong Email or Password!");
    }
}

return(
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-[#A8E6CF] to-[#DCEDC1]">
        <div className="bg-white/40 backdrop-blur-xl p-10 rounded-3xl shadow-2xl w-96">
        <h1 className="text-4xl font-bold  text-center text-[#2E7D32] m-2">StudyWell</h1>
        <form onSubmit={handleLogin} className="space-y-5 mt-6">
            <input type="email" placeholder="Email" required value={email} onChange={(e) => setEmail(e.target.value)} className="w-full p3 rounded-xl bg-white/70"/>
            <input type="password" placeholder="Password" required value={password} onChange={(e) => setPassword(e.target.value)} className="w-full p-3 rounded-xl bg-white/70"/>
            <button className="w-full bg-[#4CAF50] text-white py-3 rounded-xl font-bold">Login</button>
        </form>
        </div>
    </div>
);
}