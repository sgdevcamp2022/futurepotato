import DetailPage from "../../components/DetailPage";
import { useRouter } from 'next/router'
import { useEffect } from "react";
import wrapper from "../../store/configureStore";
import { useDispatch, useSelector } from "react-redux";
const detail = () => {
    const router = useRouter();
    const dispatch = useDispatch();
    const {me} = useSelector((state)=>state.user);
    const {pid} = router.query;
    useEffect(() => {
        console.log("ASDFASDasdf");
        dispatch({type:'POST_INFO_REQUEST', data: {postId:pid}});
        dispatch({type:'IS_LIKE_REQUEST', data: {accountId: me.accountId, postId:pid}});
    }, [])
    return(
        <div className = "flex-center">
            <DetailPage data = {pid}/>
        </div>
    );
}

// export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
//     const cookie = context.req? context.req.headers.cookie:'';
//     console.log(context);
//     axios.defaults.headers.Cookie = '';
//     if(context.req && cookie) {
//         axios.defaults.headers.Cookie = cookie;
//     }

//     context.store.dispatch({
//         type: 'POST_INFO_REQUEST',
//         data: context.params.pid
//     })
// })
export default detail;