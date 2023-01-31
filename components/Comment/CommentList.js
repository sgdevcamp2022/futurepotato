import CommentItem from "./CommentItem";

const CommentList = (commentList) => {
    const comment = commentList.commentList;
    
    console.log(commentList);
    return(
        <div className="comment-list">
            {comment.length != 0 ? comment.map((v) => {
                console.log(v);
                <CommentItem commentItem = {v}/>
}) : <div></div>}
        </div>
    );
};

export default CommentList;