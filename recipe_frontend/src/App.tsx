import { useState } from "react";
import "./App.css";

function App() {
  return (
    <div className="home page">
      <div className="home-header">
        <h2>Your Recipes:</h2>
      </div>
      <ol className="recipe-list-container">
        <li>Dal Bhat</li>
        <li>Chicken Biryani</li>
        <li>Pizza</li>
        <a>see More</a>
      </ol>

      <a className="add-recipe link">
        <h2>Add Recipe +icon</h2>
      </a>
    </div>
    // <RouterProvider router={
    //       createBrowserRouter(
    //         [
    //             {path:"/",element:<Home/>},
    //             {path:"/register",element:<Register/>},
    //             {path:"/login",element:<Login/>},
    //             {path:"/dashboard",element:<Dashboard/>},
    //             {path:"/stating",element:<Stating/>},
    //             {path:"/users/create",element:<UserCreate/>},
    //             {path:"/users/table",element:<UsersTable/>}
    //         ]
    //     )
    // }/>
  );
}

export default App;
