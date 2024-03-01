import "../css/Home.css"
import { Link } from "react-router-dom";

export default function UserRecipes() {
    return (
        <main className="main-container">
            <h2>Your Recipes</h2>
            <div className="grid-container">
                {/*Map from here*/}
                <div className="card-container">
                    <Link className="card-link" to="#" />
                    {/*<img className="card-image" src="/placeholder.svg" alt="recipe_image" />*/}
                    <div className="card-content">
                        <h2 className="card-title">Perfectly Fluffy Pancakes</h2>
                        <p className="card-description">These pancakes are light, fluffy, and absolutely delicious.</p>
                    </div>
                </div>
                {/* Repeat for other cards */}
            </div>
        </main>
    );
}
