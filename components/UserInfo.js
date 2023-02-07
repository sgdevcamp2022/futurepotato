import { useState } from "react";
import Modal from "react-modal";
import { useSelector } from "react-redux";
import PostDeleteForm from './PostDeleteForm';
import PostEditForm from "./PostEditForm";
import Link from "next/link";
const UserInfo = (props) => {
    const [optionOpen, setoptionOpen] = useState(false);
    const {me} = useSelector((state) => state.user);


    return(
        <div className="info">
            <Link href = {`/profile/${props.postName}`} legacyBehavior>
                <div className="user">
                    <div className="profile-pic"><img src={props.postImage} alt="" /></div>
                    <p className="username">{props.postName}</p>
                </div>
            </Link>
            <img src="/option.PNG" className="options" alt="" onClick={() => setoptionOpen(true)}/>
            <Modal ariaHideApp={false} isOpen = {optionOpen} onRequestClose={()=>setoptionOpen(false)} style={{content:{height:450, width:400, padding:0, left:"35%", right:"35%", top:100}}}>
                {me.accountId != props.postName ? <PostDeleteForm /> : <PostEditForm postId = {props.postId}/>}
            </Modal>
        </div>
    );
}

export default UserInfo;