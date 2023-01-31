import { useSelector } from "react-redux";
import DetailItem from "./DetailItem";

const DetailPage = (props) => {
    const {postList} = useSelector((state) => state.mainpage);
    console.log(props);
    const item = postList.filter((v) => v.id == props.id ? v : null);

    return(
        <DetailItem postItem = {item[0]}/>
    );
};

export default DetailPage;