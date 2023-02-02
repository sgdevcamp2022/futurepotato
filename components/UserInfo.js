import { useState } from "react";
import Modal from "react-modal";
import { useSelector } from "react-redux";
import PostDeleteForm from './PostDeleteForm';
import PostEditForm from "./PostEditForm";

const UserInfo = (postId) => {
    const [optionOpen, setoptionOpen] = useState(false);
    const {me} = useSelector((state) => state.user);
    console.log(postId);
    console.log(me.accountId);
    return(
        <div className="info">
            <div className="user">
                <div className="profile-pic"><img src="/cover 1.png" alt="" /></div>
                <p className="username">modern_web_channel</p>
            </div>
            <img src="/option.PNG" className="options" alt="" onClick={() => setoptionOpen(true)}/>
            <Modal ariaHideApp={false} isOpen = {optionOpen} onRequestClose={()=>setoptionOpen(false)} style={{content:{height:450, width:400, padding:0, left:"35%", right:"35%", top:100}}}>
                {me.accountId != postId.postId ? <PostDeleteForm /> : <PostEditForm />}
            </Modal>
        </div>
    );
}

export default UserInfo;