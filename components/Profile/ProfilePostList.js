import ProfilePost from "./ProfilePost";
import { useSelector } from "react-redux";

const ProfilePostList = () => {
    const {profileData} = useSelector((state) => state.user);
    console.log(profileData);
    return(
        <>
        {profileData.mypagePostDtos.map((v, index) => (
            <div key={index}>
                <ProfilePost image = {v.storedUrl} postId = {v.postId}/>
            </div>
        ))}
        </>
    );
};

export default ProfilePostList;