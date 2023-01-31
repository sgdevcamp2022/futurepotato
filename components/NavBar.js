import Link from 'next/link';
import React, {useState} from 'react';
import Modal from 'react-modal';
import {useDispatch} from 'react-redux';
import { logoutRequestAction } from '../reducers/user';
import NewPost from './NewPost';
import NewPostText from './NewPostText'

const NavBar = () => {
    const dispatch = useDispatch();
    const [newPostOpen, setNewPost] = useState(false);
    const logOut = () => {
        dispatch(logoutRequestAction());
    }
    return(
        <nav className="navbar">
            <div className="nav-wrapper">
                <Link href = '/' legacyBehavior>
                    <img src="/logo.PNG" className="brand-img" alt="" />
                </Link>
                <input type="text" className="search-box" placeholder="search" />
                <div className="nav-items">
                    <Link href = '/' legacyBehavior>
                        <img src="/home.PNG" className="icon" alt="" />
                    </Link>
                    <img src="/add.PNG" onClick={() => setNewPost(true)} className="icon" alt="" />
                    <img src="/like.PNG" className="icon" alt="" />
                    <Link href = '/profile' legacyBehavior>
                        <div className="icon user-profile">
                            <div className='profile-pic' style={{width:22, height:22, display:'inline-block', padding: 0
                            ,cursor:'pointer'}}>
                                <img src='/cover 1.png' alt />
                            </div>
                        </div>
                    </Link>

                    <Modal isOpen={newPostOpen} onRequestClose={()=>setNewPost(false)}
                        style={{content:{left:"30%", right:"30%", padding:0, borderRadius:13}}}
                    >
                        <NewPost/>
                    </Modal>

                    <Link href = "/" legacyBehavior>
                        <img src="/logout.PNG" className='icon'  alt="" style={{width:25}} onClick={logOut}/>
                    </Link>
                </div>
            </div>
        </nav>
    );
}

export default NavBar