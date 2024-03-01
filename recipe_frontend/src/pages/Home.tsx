
// import {Link}from "react-router-dom";
import UserRecipes from "../components/UserRecipes.tsx";
import Navigation from "../components/Navigation.tsx";
import RecipeForm from "../components/CreateRecipeForm.tsx";


export default function Component() {
    return (
        <>
            <div className={"padding"}></div>
            <UserRecipes/>
            <hr/>
            <RecipeForm/>
        </>
    );
}

