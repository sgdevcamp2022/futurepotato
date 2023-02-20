import { useState,useCallback, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

const CommentItem = (props) => {
    const dispatch = useDispatch();
    const [replyView, setReplyView] = useState(false);
    const [addReply, setAddReply] = useState(false);
    const {me} = useSelector((state) => state.user);
    const {postId} = useSelector((state)=>state.mainpage.currentReqPost);
    const comment = props.commentItem;
    
    const [reply, setReply] = useState('');
    const onChangeReply = useCallback((e) => {
        setReply(e.target.value);
    }, []);

    const onClickDeleteComment = () => {
        dispatch({type:"DELETE_COMMENT_REQUEST", data:{commentId : comment.commentId, accountId : me.accountId, postId :postId}});
    }

    const onClickDeleteReply = (v) => {
        dispatch({type:'DELETE_REPLY_REQUEST', data : {accountId: me.accountId, replyId:v}});
    }

    const onSubmitReply = () => {
        dispatch({type:"ADD_REPLY_REQUEST", data:{ nickname:me.username,profileImage:me.profileimage,commentId:  comment.commentId, accountId : me.accountId, reply: reply}})
    }

    const onClickCommentLike = () => {
        dispatch({type:'LIKE_COMMENT_REQUEST', data:{accountId:me.accountId, commentId:comment.commentId}});
    }

    const onClickCommentLikeCancel = () => {
        dispatch({type:'LIKE_COMMENT_CANCEL_REQUEST', data:{accountId:me.accountId, commentId:comment.commentId}});
    }

    useEffect(() => {
        dispatch({type:'IS_LIKE_COMMENT_REQUEST', data:{accountId:me.accountId, commentId:comment.commentId}});
    }, [])

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
                            <span style={{cursor:'pointer'}} onClick  ={() => setAddReply(!addReply)}>답글 달기&nbsp;&nbsp;&nbsp;</span>
                            {comment.commentWriter == me.accountId && <span onClick={onClickDeleteComment} style={{cursor:'pointer'}}>삭제</span>} 
                        </div>
                    </div>
                </div>
                <div className='heart'>
                    {props.isLikeComment ? <p onClick={onClickCommentLikeCancel}>♥</p> : <p onClick={onClickCommentLike}>♡</p>}
                </div>
            </div>
            {comment.replyList.length != 0 && <div onClick={() => setReplyView(!replyView)} style = {{fontSize:13, paddingLeft:50, color:'gray', cursor:'pointer'}}>--- 답글 보기({comment.replyList.length}개)</div>}
            
            {replyView && 
            comment.replyList.map((v, index) => (
                <div key={index} className="comment_form" >
                    <div className='comment-info'>
                        <div className='profile-content'>
                            <div className = 'pic-wrapper'>
                                <div className="profile-pic" style = {{width:30, height:30}}>
                                    <img src = {v.image} alt = ""/>
                                </div>
                            </div>
                            <div className="name-content-data">
                                <div className='name-content'>
                                    <span style = {{fontWeight:'bold'}}>{v.replyWriter}&nbsp;&nbsp;&nbsp;</span>
                                    <span style = {{maxWidth:"100%", display:"inline-block",wordBreak:"break-all"}}>{v.reply}</span>
                                </div>
                                <div className = 'date-heart-reply' style = {{fontSize:11, color:'gray'}}>
                                    <span style={{cursor:'pointer'}} onClick={onClickDeleteReply(v.replyId)}>삭제</span> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            ))}

            {addReply && <div className="comment-wrapper">
                <img src="/smile.PNG" className="icon" alt="" />
                <input type="text" className="comment-box" placeholder="Add a comment" value = {reply} onChange = {onChangeReply}/>
                <button className="comment-btn" style={{cursor:'pointer'}} onClick = {onSubmitReply}>post</button>
            </div>
            }
        </div>
    );
}

export default CommentItem;