import CommentItem from "./CommentItem";

const CommentList = (commentList) => {
    const commentLists = commentList.commentList;
    console.log(commentList.commentList);
    return(
        <div className="comment-list">
            {commentLists.length != 0 ? commentLists.map((v) => (
                <CommentItem commentItem = {v}/>
            )) : <div></div>}
        </div>
    );
};

export default CommentList;