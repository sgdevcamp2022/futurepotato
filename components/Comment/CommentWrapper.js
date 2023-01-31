const CommentWrapper = () => {
    return(
        <div className="comment-wrapper">
            <img src="/smile.PNG" className="icon" alt="" />
            <input type="text" className="comment-box" placeholder="Add a comment" />
            <button className="comment-btn">post</button>
        </div>
    );
};

export default CommentWrapper;