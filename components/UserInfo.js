import { useState } from "react";
import Modal from "react-modal";
import PostDeleteForm from './PostDeleteForm';

const UserInfo = () => {
    const [optionOpen, setoptionOpen] = useState(false);

    return(
        <div className="info">
            <div className="user">
                <div className="profile-pic"><img src="/cover 1.png" alt="" /></div>
                <p className="username">modern_web_channel</p>
            </div>
            <img src="/option.PNG" className="options" alt="" onClick={() => setoptionOpen(true)}/>
            <Modal isOpen = {optionOpen} onRequestClose={()=>setoptionOpen(false)} style={{content:{height:450, width:400, padding:0, left:"35%", right:"35%", top:100}}}>
                <PostDeleteForm />
            </Modal>
        </div>
    );
}

export default UserInfo;