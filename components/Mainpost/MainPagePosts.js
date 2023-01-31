
import CommentWrapper from "../Comment/CommentWrapper";
import PostText from "./PostText";
import ReactionWrapper from "../Comment/ReactionWrapper";
import UserInfo from "../UserInfo";

const MainPagePosts = () => {
    return(
        <div className="post">
            <UserInfo />
            <img src="/cover 1.png" className="post-image" alt="" />   
            <div className="post-content">
                <ReactionWrapper />
                <p className="likes">1,012 likes</p>
                <PostText />
            </div>
            <CommentWrapper />
        </div>
    );
}

export default MainPagePosts;