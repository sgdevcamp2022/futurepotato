import { useSelector } from 'react-redux';
import FollowForm from './FolloingForm'
const FollowerList = () => {

    const {followerList} = useSelector((state) => state.user);
    console.log(followerList);    
    return(
        <div className="Follow_ing_list">
            {followerList.map((v) => (
                <FollowForm data = {v}/>
            ))}
        </div>
    );
}

export default FollowerList;