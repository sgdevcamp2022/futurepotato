const CommentForm = (checkHeart, heartCount) => {
    return (
        <>
            <div className="post-content">
                <div className="reaction-wrapper">
                    {checkHeart ? <img src="/like.PNG" className="icon" alt="" />
                    : <img src="/like.PNG" className="icon" alt="" />}
                    <img src="/comment.PNG" className="icon" alt="" />
                    <img src="/send.PNG" className="icon" alt="" />
                    <img src="/save.PNG" className="save icon" alt="" />
                </div>
                <p className="likes">{heartCount}좋아요</p>
               
            </div>
            <div className="comment-wrapper">
                <img src="/smile.PNG" className="icon" alt="" />
                <input type="text" className="comment-box" placeholder="Add a comment" />
                <button className="comment-btn">post</button>
            </div>
            </>
    );
}

export default CommentForm;