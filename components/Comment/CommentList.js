import { useSelector } from "react-redux";
import CommentItem from "./CommentItem";

const CommentList = () => {
    const {commentList} = useSelector((state)=>state.mainpage.currentReqPost);
    console.log(commentList);
    return(
        <div className="comment-list">
            {commentList.length != 0 ? commentList.map((v, index) => (
                <CommentItem key={index} commentItem = {v}/>
            )) : <div></div>}
        </div>
    );
};

export default CommentList;