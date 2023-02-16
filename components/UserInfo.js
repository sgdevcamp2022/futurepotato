import { useState } from "react";
import Modal from "react-modal";
import { useDispatch, useSelector } from "react-redux";
import Link from "next/link";
import NewPostText from "./NewPostText";

const UserInfo = (props) => {
    const [optionOpen, setoptionOpen] = useState(false);
    const {me} = useSelector((state) => state.user);
    const dispatch = useDispatch();

    const onClickMoveProfile = () => {
        dispatch({type:'PROFILE_LOAD_REQUEST'});
    }

    const onClickDelete = () => {
        dispatch({type:'REMOVE_POST_REQUEST', accountId:me.accountId, postId:props.postId})
    }

    const [newPostOpen, setNewPost] = useState(false);

    return(
        <div className="info">
            <Link href = {`/profile/${props.postName}`} legacyBehavior>
                <a>
                <div className="user" onClick={onClickMoveProfile}>
                    <div className="profile-pic"><img src={props.postImage} alt="" /></div>
                    <p className="username">{props.postName}</p>
                </div>
                </a>
            </Link>
            <img src="/option.PNG" className="options" alt="" onClick={() => setoptionOpen(true)}/>
            <Modal ariaHideApp={false} isOpen = {optionOpen} onRequestClose={()=>setoptionOpen(false)} 
                style={{content:{
                    position: "relative",
                    display: "inline-flex",
                    left: "50%",
                    top: "50%",
                    transform: "translate(-50%, -50%)",
                    padding: 0,
                    borderRadius: 13,
                },}}>
                {me.accountId != props.postName ? 
                <div className="flex-center">
                    <div className = 'modal_window_option'>
                        <div className ='modal_title_option_bold'>
                            <div> 신고 </div>
                        </div>
                        <div className ='modal_title_option_bold'>
                            <div> 팔로우 취소 </div>
                        </div>
                        <div className ='modal_title_option_two' onClick={() => setoptionOpen(false)}>
                            <div> 취소 </div>
                        </div>
                    </div>
                </div> : 
                <div className="flex-center">
                    <div className = 'modal_window_option'>
                        <div className ='modal_title_option_user' onClick={() => setNewPost(true)}>
                            <div> 수정 </div>
                        </div>
                        <div className ='modal_title_option_user' onClick={onClickDelete}>
                            <div> 삭제 </div>
                        </div>
                        <div className ='modal_title_option_user_two' onClick={() => setoptionOpen(false)}>
                            <div> 취소 </div>
                        </div>
                        <Modal isOpen={newPostOpen} onRequestClose={()=>setNewPost(false)} style={{content:{left:"20%", right:"20%", padding:0, borderRadius:13}}}>
                            <NewPostText isEdit = {true}/>
                        </Modal>
                    </div>
                </div>
            }
            </Modal>
        </div>
    );
}

export default UserInfo;