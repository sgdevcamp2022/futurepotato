import ProfilePost from "./ProfilePost";
import { useSelector } from "react-redux";

const ProfilePostList = () => {
    const {profileData} = useSelector((state) => state.user);
    console.log(profileData);
    return(
        <>
        {profileData.imageList.map((v, index) => (
            <div key={index}>
                <ProfilePost image = {v.image} postId = {v.postId}/>
            </div>
        ))}
        </>
    );
};

export default ProfilePostList;