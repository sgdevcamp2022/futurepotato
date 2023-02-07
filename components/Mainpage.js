import AppLayout from "./AppLayout";
import StoryForm from "./Story/StoryForm";
import MainPosts from "./Mainpost/MainPosts";
import Recommend from "./MainSide/Recommend";
import { useDispatch, useSelector } from "react-redux";
import { useCallback, useEffect } from "react";
const Mainpage = () => {
    const dispatch = useDispatch();
    const {postList} = useSelector((state) => state.mainpage);
    console.log(postList);
    useEffect(() => {
        dispatch({type: 'MAIN_PAGE_REQUEST'});
    },[])
    return(
        <>
        <AppLayout/>
        <section className="main">
            <div className="wrapper">
                <div className="left-col">
                    <StoryForm />
                    <MainPosts />
                </div>
                <div className="right-col">
                    <Recommend />
                </div>
            </div>
        </section>
        </>
    );
}

export default Mainpage;