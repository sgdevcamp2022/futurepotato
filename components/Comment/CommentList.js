import { useSelector } from "react-redux";
import CommentItem from "./CommentItem";

const CommentList = () => {
    const {commentList} = useSelector((state)=>state.mainpage.currentReqPost);
    const {isCommentLike} = useSelector((state) => state.mainpage);
    
    console.log(commentList);
    return(
        <div className="comment-list">
            {commentList.length != 0 ? commentList.map((v, index) => (
                <CommentItem key={index} isLikeComment = {isCommentLike[index]} commentItem = {v}/>
            )) : <div></div>}
        </div>
    );
};

export default CommentList;