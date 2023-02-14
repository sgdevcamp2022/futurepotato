import AppLayout from "./AppLayout";
import StoryForm from "./Story/StoryForm";
import MainPosts from "./Mainpost/MainPosts";
import Recommend from "./MainSide/Recommend";
import { useDispatch, useSelector } from "react-redux";
import { useCallback, useEffect, useState } from "react";
const Mainpage = () => {
    const dispatch = useDispatch();
    const {postList} = useSelector((state) => state.mainpage);
    console.log(postList);
    const [fetching, setFetching] = useState(false);
    useEffect(() => {
        dispatch({type: 'MAIN_PAGE_REQUEST'});
    },[]);

    const handleScroll = () => {
        const scrollHeight = document.documentElement.scrollHeight;
        const scrollTop = document.documentElement.scrollTop;
        const clientHeight = document.documentElement.clientHeight;
        if(scrollTop + clientHeight >= scrollHeight && fetching === false){
            setFetching(true);
            dispatch({type:'MAIN_PAGE_REQUEST', data:{lastSeenPostId:2, pageSize: 2}});
            setFetching(false);
        }
        
    };

    useEffect(() => {
        window.addEventListener("scroll", handleScroll);
        return () => {
            window.removeEventListener("scroll", handleScroll);
        }
    })

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