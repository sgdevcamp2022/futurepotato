import { useSelector } from "react-redux";
import FolloingForm from "./FollowForm";

const FollowList = () => {
    const {folloingList} = useSelector((state) => state.user);
    console.log(folloingList);
    return(
        <div className="Follow_ing_list">
            {folloingList.map((v) => (
                <FolloingForm data = {v}/>
            ))}
        </div>
    );
}

export default FollowList;