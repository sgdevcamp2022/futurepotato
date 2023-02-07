import DetailPage from "../../components/DetailPage";
import { useRouter } from 'next/router'
import wrapper from "../../store/configureStore";
const detail = () => {
    const router = useRouter();
    const {pid} = router.query;
    return(
        <div className = "flex-center">
            <DetailPage id={pid}/>
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