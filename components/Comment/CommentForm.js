import { useCallback, useState } from "react";
import {useDispatch, useSelector} from 'react-redux';

const CommentForm = (props) => {
    const {me} = useSelector((state) => state.user);
    console.log(props.checkHeart);
    const [comment, setComment] = useState('');
    const onChangeComment = useCallback((e) => {
        setComment(e.target.value);
    }, []);
    const dispatch = useDispatch();

    const onSubmit = () => {
        dispatch({type: 'ADD_COMMENT_REQUEST', data: {content : comment, dataw:props.postId, datame:me}});
        console.log("1111111");
    };

    const onLike = () => {
        dispatch({type:'LIKE_POST_REQUEST', data:{accountId: me.accountId, postId:props.postId}});
    }

    const onLikeDelete = () => {
        dispatch({type:'LIKE_POST_CANCEL_REQUEST', data:{accountId: me.accountId, postId:props.postId}});
    }

    return (
        <div>
            <div className="post-content" style={{height:50}}>
                <div className="reaction-wrapper">
                    {props.checkHeart.data
                    
                    ? <img src="/likeTure.PNG" onClick={onLikeDelete} className="icon" alt="" />
                    : <img src="/like.PNG" onClick={onLike} className="icon" alt="" />}
                    <img src="/comment.PNG"  className="icon" alt="" />
                    <img src="/send.PNG" className="icon" alt="" />
                    <img src="/save.PNG" className="save icon" alt="" />
                </div>
                <p className="likes">{props.heartCount}좋아요</p>
               
            </div>
            <div className="comment-wrapper">
                <img src="/smile.PNG" className="icon" alt="" />
                <input type="text" className="comment-box" placeholder="Add a comment"  value={comment} onChange={onChangeComment}/>
                <button className="comment-btn" onClick={onSubmit} style={{cursor:'pointer'}}>post</button>
            </div>
            </div>
    );
}

export default CommentForm;