import "../css/Login.css";
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import {useSignin} from "../context/useSignin.ts";
import axios from "axios";

const Login=()=> {
    const { signin, error } = useSignin();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const navigate=useNavigate();

    const onSubmitHandler=async ()=>{
        try {
            await signin(username, password);
          } catch (err) {
            console.error("Error during signin:", err);
            // setErrMsg("An error occurred during signin");
          }
    }

    return (
        <div className="full-container">
            <div className="space-y-2 text-center">
                <h1>Login</h1>
                <p >Enter your credentials to log in</p>
            </div>
            <div className="space-y-2">
                <p>Username</p>
                <input type="text" placeholder={"Enter your username"} required={true} onChange={(e)=>setUsername(e.target.value)} name={"username"}/>
            </div>
            <div className="space-y-2">
                <p>Password</p>
                <input type="text" placeholder={"Enter your password"} required={true} onChange={(e)=>setPassword(e.target.value)} typeof={"password"} name={"password"}/>
            </div>
            <div className="space-y">
                <Link className="link" to="/register">
                    Register here
                </Link>
            </div>
            <p style={{"backgroundColor":"red"}}>{error?error:""}</p>
            <button className={"login-button"}  onClick={()=> onSubmitHandler()}>
                Login
            </button>
        </div>
    )
}

export default Login;