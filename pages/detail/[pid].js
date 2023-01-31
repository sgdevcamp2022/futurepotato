import DetailPage from "../../components/DetailPage";
import { useRouter } from 'next/router'

const detail = () => {
    const router = useRouter();
    const {pid} = router.query;
    console.log(pid);
    return(
        <div className = "flex-center">
            <DetailPage id={pid}/>
        </div>
    );
}

export default detail;