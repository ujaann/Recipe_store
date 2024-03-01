import { useEffect, useState } from "react";
import "../css/Home.css"
import { Link } from "react-router-dom";
import axios from "axios";

export default function UserRecipes() {

    const[recipes,setRecipes]=useState([]);

    useEffect(() => {
        const fetchRecipes = async () => {
          const res = await axios.get(
            `http://localhost:8087/recipe/`
          );
    
          setRecipes(res.data);
        };
        fetchRecipes();
      }, []);


    return (
        <main className="main-container">
            <h2>Your Recipes</h2>
            <div className="grid-container">
                {/*Map from here*/}

                {
                recipes.map((x)=>
                    {
                    return (<div className="card-container">
                            <Link className="card-link" to="#" />
                    
                            <div className="card-content">
                            <h2 className="card-title">{x?.title}</h2>
                            <p className="card-description">{x?.cookingTime}</p>
                            </div>
                            </div>
                            );
                })
                }                {/* Repeat for other cards */}
            </div>
        </main>
    );
}
