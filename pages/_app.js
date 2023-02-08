import "./app.css";
import wrapper from "../store/configureStore";
import axios from "axios";

axios.defaults.baseURL = "http://localhost:8000";
const App = ({Component}) => {
    return (
        <Component />
    )
}

export default wrapper.withRedux(App);