import { useCallback } from "react";
import { useDispatch, useSelector } from "react-redux";
import Login from "../components/LoginSignup/login";
import Mainpage from "../components/Mainpage";
const index = () => {
    const {isLoggedIn} = useSelector((state) => state.user);
    console.log(isLoggedIn);
    return(
        <>
            {isLoggedIn ? <Mainpage /> : <Login /> }
        </>
    );
};

export default index;