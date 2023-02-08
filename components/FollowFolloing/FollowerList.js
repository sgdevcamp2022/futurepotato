import { useSelector } from 'react-redux';
import FollowForm from './FolloingForm'
const FollowerList = () => {

    const {followerList} = useSelector((state) => state.user);
    console.log(followerList);    
    return(
        <div className="Follow_ing_list">
            {followerList.map((v, index) => (
                <div key={index}>
                <FollowForm data = {v}/>
                </div>
            ))}
        </div>
    );
}

export default FollowerList;