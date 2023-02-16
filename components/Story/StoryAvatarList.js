import {useSelector} from 'react-redux';
import StoryAvatar from "./StoryAvatar";
import Link from 'next/link';

const StoryAvatarList = () => {
    const {storyList} = useSelector((state) => state.mainpage);
    console.log(storyList);
    return(
        <>
            {storyList.map((v, index) => (
                <Link href = '/story' key={index} legacyBehavior>
                <div key={index} className="status-card">
                    <div className="profile-pic-story">
                        <img src={v.profileImage} alt="" />
                    </div>
                    <p className="username">{v.name}</p>
                </div>
                </Link>
            ))}
        </>
    );
}

export default StoryAvatarList;