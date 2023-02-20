import { useDispatch, useSelector } from "react-redux";
import React, {useState} from 'react';
import Modal from 'react-modal';
import NewPostText from "./NewPostText";

const PostEditForm = (props) => {

    const dispatch = useDispatch();
    const {me} = useSelector((state) => state.user);
    const {postId} = useSelector((state) =>state.mainpage.currentReqPost);
    console.log(postId);
    
    const onClickDelete = () => {
        console.log("asdfasdf");
        dispatch({type:'REMOVE_POST_REQUEST', accountId:me.accountId, postId:postId})
    }

    const [newPostOpen, setNewPost] = useState(false);

    return(
        <div className="flex-center">
            <div className = 'modal_window_option'>
                <div className ='modal_title_option_user' onClick={() => setNewPost(true)}>
                    <div> 수정 </div>
                </div>
                <div className ='modal_title_option_user' onClick={onClickDelete}>
                    <div> 삭제 </div>
                </div>
                <div className ='modal_title_option_user_two'>
                    <div> 취소 </div>
                </div>
                <Modal isOpen={newPostOpen} onRequestClose={()=>setNewPost(false)} style={{content:{left:"20%", right:"20%", padding:0, borderRadius:13}}}>
                        <NewPostText isEdit = {true}/>
                </Modal>
            </div>
        </div>
    );
}

export default PostEditForm;