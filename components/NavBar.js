import Link from 'next/link';
import React, {useState} from 'react';
import { useEffect } from 'react';
import Modal from 'react-modal';
import {useDispatch, useSelector} from 'react-redux';
import { logoutRequestAction } from '../reducers/user';
import AlarmForm from './AlarmForm';
import NewPost from './NewPost';

const NavBar = () => {
    const dispatch = useDispatch();
    const {clearUpload} = useSelector((state) => state.mainpage);
    const [newPostOpen, setNewPost] = useState(false);
    const [alarmOpen, setAlarmopen] = useState(false);

    const{me} = useSelector((state) => state.user);
    const logOut = () => {
        dispatch(logoutRequestAction());
    }
    
    useEffect(() => {
        if(clearUpload) setNewPost(false);
    }, [clearUpload])
    
    const onClickProfile = () => {
        dispatch({type:'PROFILE_LOAD_REQUEST', data: me.accountId});
    }

    const onClickAlarmPage = () => {
        dispatch({type:'ALARM_REQUEST',data:me.accountId
        })
        setAlarmopen(true);
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
                        <a>
                            <img src="/home.PNG" className="icon" alt="" />
                        </a>
                    </Link>
                    <img src="/add.PNG" onClick={() => setNewPost(true)} className="icon" alt="" />
                    <img src="/like.PNG" className="icon" alt="" onClick={onClickAlarmPage} />
                    <Link href = {`/profile/${me.accountId}`} legacyBehavior> 
                        <a>
                        <div className="icon user-profile">
                            <div className='profile-pic' style={{width:22, height:22, display:'inline-block', padding: 0
                            ,cursor:'pointer'}} onClick = {onClickProfile}>
                                <img src={me.profileimage} alt=""/>
                            </div>
                        </div>
                        </a>
                    </Link>

                    <Modal isOpen={newPostOpen} onRequestClose={()=>setNewPost(false)}
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
                        ariaHideApp={false}
                    >
                        <NewPost/>
                    </Modal>

                    <Modal isOpen={alarmOpen} onRequestClose={()=>setAlarmopen(false)}
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
                        ariaHideApp={false}
                    >
                        <AlarmForm/>
                    </Modal>

                    <Link href = "/" legacyBehavior>
                        <a>
                        <img src="/logout.PNG" className='icon'  alt="" style={{width:25}} onClick={logOut}/>
                        </a>
                    </Link>
                </div>
            </div>
        </nav>
    );
}

export default NavBar