import { useState } from "react";
import "../css/Navigation.css"
import { Link, } from "react-router-dom";
import { useAuthContext } from "../context/useAuthContext";
import { useLogout } from "../context/useLogout";
export default function Navigation() {
    const {user}=useAuthContext();
    const {logout}=useLogout();

    const logOutUser=()=>{
        logout();
    }
    
    return (
        <header>
            <nav className={"navigation"}>
                    <Link className="nav-link nav-item" to="/">Home</Link>
                    {/* <Link className="nav-link" to="/breakfast">Breakfast</Link>
                    <Link className="nav-link" to="/lunch">Lunch</Link>
                    <Link className="nav-link" to="/dinner">Dinner</Link> */}
                <div className={"user-options"}>
                    {
                    user?.login?
                    <button onClick={logOutUser}>{user?.username}</button>:
                    <Link className="nav-link border" to="/login"><button>Sign In</button></Link>
                        // <Link className="nav-link border" to="/register"><button>Sign Up</button></Link>
                    }
                </div>
            </nav>
        </header>
    );

}

