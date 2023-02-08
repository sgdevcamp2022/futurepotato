import {useSelector} from 'react-redux';
import StoryAvatar from "./StoryAvatar";

const StoryAvatarList = () => {
    const {storyList} = useSelector((state) => state.mainpage);
    console.log(storyList);
    return(
        <>
            {storyList.map((v, index) => (
                <div key={index} className="status-card">
                    <div className="profile-pic-story">
                        <img src={v.profileImage} alt="" />
                    </div>
                    <p className="username">{v.name}</p>
                </div>
            ))}
        </>
    );
}

export default StoryAvatarList;