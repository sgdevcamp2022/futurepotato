import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";

const CommentItem = (props) => {
    const dispatch = useDispatch();
    const [replyView, setReplyView] = useState(false);
    const {me} = useSelector((state) => state.user);
    const comment = props.commentItem;
    const isReply = true;
    const onClickDeleteComment = () => {
        dispatch({type:"DELETE_COMMENT_REQUEST", data:{commentId : comment.commentId, accountId : me.accountId, postId : props.postId}});
    }
    console.log("asdf");
    return(
        <div className="comment_form" >
            <div className='comment-info'>
                <div className='profile-content'>
                    <div className = 'pic-wrapper'>
                        <div className="profile-pic" style = {{width:30, height:30}}>
                            <img src = {comment.Image} alt = ""/>
                        </div>
                    </div>
                    <div className="name-content-data">
                        <div className='name-content'>
                            <span style = {{fontWeight:'bold'}}>{comment.commentWriter}&nbsp;&nbsp;&nbsp;</span>
                            <span style = {{maxWidth:"100%", display:"inline-block",wordBreak:"break-all"}}>{comment.comment}</span>
                        </div>
                        <div className = 'date-heart-reply' style = {{fontSize:11, color:'gray'}}>
                            <span>좋아요 {comment.likeCount}개&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span>답글 달기&nbsp;&nbsp;&nbsp;</span>
                            {comment.commentId == me.accountId && <span onClick={onClickDeleteComment} style={{cursor:'pointer'}}>삭제</span>} 
                        </div>
                    </div>
                </div>
                <div className='heart'>
                    <p>♡</p>
                </div>
            </div>
            {comment.replyList.length != 0 && <div style = {{fontSize:13, paddingLeft:50, color:'gray', cursor:'pointer'}}>--- 답글 보기({comment.replyList.length}개)</div>}
            
        </div>
    );
}

export default CommentItem;