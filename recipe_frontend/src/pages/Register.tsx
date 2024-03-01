/**
 * v0 by Vercel.
 * @see https://v0.dev/t/LzdsVHAiBr8
 * Documentation: https://v0.dev/docs#integrating-generated-code-into-your-nextjs-app
 */
import "../css/Login.css";
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import axios from "axios";

const Register=()=> {
    const navigate=useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const registerUser = async (e) => {
        console.log("hrlo");
        
        e.preventDefault();
        try {
          const response = await axios.post("http://localhost:8087/auth/register", {
            username: username,
            password: password,
          });
      
          console.log(response);
          if (response.status === 201) {
      
            setTimeout(() => {
              console.log("Sign Up Successful. Redirecting to /login...");
              navigate("/login");
            }, 2500);
          }
          if (response.status===401) {
            setError("User already exists");
          }
          // Reset state values
          setUsername(" ");
          setPassword(" ");
        } catch (error) {
          const errorMessage = error?.response?.data?.message;
          if (!errorMessage) {
            console.log(error.message);
          }
        }
      };

    return (
        <div className="full-container">
            <div className="space-y-2 text-center">
                <h1 className="text-3xl font-bold">Sign Up</h1>
                <p className="text-center">Enter your information to create an account</p>
            </div>
            <div className="space-y-2">
                <p>Username</p>
                <input type="text" placeholder={"Enter your username"} required={true} onChange={(e)=>setUsername(e.target.value)} name={"username"}/>
            </div>
            <div className="space-y-2">
                <p>Password</p>
                <input type="text" placeholder={"Enter your password"} required={true} typeof={"password"}onChange={(e)=>setPassword(e.target.value)} name={"password"}/>
            </div>
            <div className="space-y-2">
                <Link className="link" to="/login">
                    Already have an account
                </Link>
            </div>
            <p style={{"backgroundColor":"red"}}>{error?error:""}</p>
            <button className={"register-button"} type="submit" onClick={e=>registerUser(e)}>
                Register
            </button>
        </div>
    )
}

export default Register;