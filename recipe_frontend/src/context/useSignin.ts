import { useNavigate } from "react-router-dom";
import { useAuthContext } from "./useAuthContext";
import axios from "axios";
import { useState } from "react";

export const useSignin = () => {
    const { dispatch } = useAuthContext();
    const navigate = useNavigate();  // Import useNavigate hook
    const [error, setError] = useState(null)



    const signin = async (username, password) => {
        try {
            const response = await axios.post("http://localhost:8087/auth/login", {
                username: username,
                password: password,
            });

            console.log(response);
            
            if (response.data.applicationUser) {
                // console.log(jsonData);

                if (response.status === 200) {
                    localStorage.setItem("user", JSON.stringify(
                        {
                            login:true,
                            username:response.data.applicationUser.username,
                            token:response.data.jwt
                        }
                    ));
                    dispatch({ type: "LOGIN", payload: {
                        login:true,
                        username:response.data.applicationUser.username,
                        token:response.data.jwt
                    } });
                    console.log(response.data.jwt);
                    
                    navigate("/");

                }
                if(response.status===400 || response.status===401){
                    setError("invalid login credentials, please try again")
                }
            } else {
                console.error("Response data is undefined");
            }
        } catch (error) {
            // Handle network errors or other exceptions
            console.error(error.response.data);
    
            setError("invalid login credentials, please try again")
        }
    };

    return { signin, error };
};
