import { useDispatch, useSelector } from "react-redux";

const PostEditForm = (props) => {

    const dispatch = useDispatch();
    const {me} = useSelector((state) => state.user);

    const onClickDelete = () => {
        dispatch({type:'REMOVE_POST_REQUEST', accountId:me.accountId, postId:props.postId})
    }

    return(
        <div className="flex-center">
            <div className = 'modal_window_option'>
                <div className ='modal_title_option_user'>
                    <div> 수정 </div>
                </div>
                <div className ='modal_title_option_user' onClick={onClickDelete}>
                    <div> 삭제 </div>
                </div>
                <div className ='modal_title_option_user_two'>
                    <div> 취소 </div>
                </div>
            </div>
        </div>
    );
}

export default PostEditForm;