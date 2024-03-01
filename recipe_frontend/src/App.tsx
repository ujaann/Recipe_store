import "./App.css";
import {Route, Routes, useLocation} from "react-router-dom";
import Home from "./pages/Home.tsx";
import Register from "./pages/Register.tsx";
import Login from "./pages/Login.tsx";
import {useAuthContext} from "./context/useAuthContext.ts";
import Navigation from "./components/Navigation.tsx";


function App() {
  const { user } = useAuthContext();


    return (
    <>
    <Routes>
                <Route path={"/"} element={<Home/>}/>
                <Route path={"/register"} element={<Register/>}/>
                <Route path={"/login"} element={<Login/>}/>
    </Routes>

    </>
  );
}

export default App;
