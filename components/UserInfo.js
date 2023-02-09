import { useState } from "react";
import Modal from "react-modal";
import { useDispatch, useSelector } from "react-redux";
import PostDeleteForm from './PostDeleteForm';
import PostEditForm from "./PostEditForm";
import Link from "next/link";
const UserInfo = (props) => {
    const [optionOpen, setoptionOpen] = useState(false);
    const {me} = useSelector((state) => state.user);
    const dispatch = useDispatch();
    const onClickMoveProfile = () => {
        dispatch({type:'PROFILE_LOAD_REQUEST'});
    }
    console.log(props.postName);
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
                    },
                }}
            >
                {me.accountId != props.postName ? <PostDeleteForm /> : <PostEditForm postId = {props.postId}/>}
            </Modal>
        </div>
    );
}

export default UserInfo;