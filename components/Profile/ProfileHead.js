import Modal from 'react-modal';
import { useState } from 'react';
import FolloingModal from '../FollowFolloing/FolloingModal';
import FollowModal from '../FollowFolloing/FollowModal';
import { useDispatch, useSelector } from 'react-redux';
import ProfileEditForm from '../Comment/ProfileEditForm';
import ProfileNameEditForm from '../ProfileNameEditForm';

const ProfileHead = (prop) => {
    const isMe = prop.isMe;

    const [profileEdit, setProfileEdit] = useState(false);
    const [profileImage, setProfileImage] = useState(false);
    const [followOpen, setFollowOpen] = useState(false);
    const [follingOpen, setFollingOpen] = useState(false);
    const {profileData, isFollowing} = useSelector((state) => state.user);
    const {me} = useSelector((state) => state.user);
    const dispatch = useDispatch();

    const onClickfollowerOpen = () => {
        setFollowOpen(true);
        dispatch({type:'GET_FOLLOWER_REQUEST', data:prop.profileId.accoutId});
    }

    const onClickfolloingOpen = () => {
        setFollingOpen(true);
        dispatch({type:'GET_FOLLOING_REQUEST', data:prop.profileId.accoutId});
    }

    const onClickProfileOrFollow = () => {
        console.log("isCheck");
        if(isMe){
            setProfileEdit(true);
        }else if(isFollowing){
            console.log("asdfisFollowing")
            dispatch({type:'FOLLOW_CANCEL_REQUEST', data:{senderId:me.accountId, recipientId:prop.profileId}});
        }else{
            console.log("asdfisNotFollowing")
            dispatch({type:'FOLLOW_FOLLOW_REQUEST', data:{senderId:me.accountId, recipientId:prop.profileId}});
            console.log("asdfisNotFollowing")
        }
    }
    const onClickProfileIamgeChange = () => {
        setProfileImage(true);
    }


    return (
        <header>
            <div className="container">
                <div className="profile">
                    <div className="profile-image" >
                            <img src={profileData.profileImage} alt="" onClick={onClickProfileIamgeChange}/>
                    </div>
                    <div className="profile-user-settings">
                        <h1 className="profile-user-name">{profileData.accountName}</h1>
                        <button className="btn profile-edit-btn" onClick={onClickProfileOrFollow}>{isMe ? "프로필 편집" : isFollowing ? "팔로우" : "팔로우 하기"}</button>
                        <button className="btn profile-settings-btn" aria-label="profile settings"><img src="/setting.png" width="17px"/></button>
					</div>

			        <div className="profile-stats">
                        <ul className='profile-stats-ul'>
					        <li>게시글 <span className="profile-stat-count">{profileData.postCount}</span></li>
					        <li>팔로워 <span className="profile-stat-count" onClick={onClickfollowerOpen}>{profileData.followerCount}</span></li>
					        <li>팔로잉 <span className="profile-stat-count" onClick={onClickfolloingOpen}>{profileData.followingCount}</span></li>
				        </ul>
                    </div>
                    <Modal isOpen = {follingOpen} onRequestClose={() => setFollingOpen(false)} style={{content:{
                            position: "relative",
                            display: "inline-flex",
                            left: "50%",
                            top: "50%",
                            transform: "translate(-50%, -50%)",
                            padding: 0,
                            borderRadius: 13,
                            },
                        }}>
                        <FolloingModal />
                    </Modal>
                    <Modal isOpen = {followOpen} onRequestClose = {() => setFollowOpen(false)}  style={{content:{
                            position: "relative",
                            display: "inline-flex",
                            left: "50%",
                            top: "50%",
                            transform: "translate(-50%, -50%)",
                            padding: 0,
                            borderRadius: 13,
                            },
                        }}>
                        <FollowModal />
                    </Modal>
                    
                    <Modal isOpen={profileImage} onRequestClose={()=>setProfileImage(false)}
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
                        <ProfileEditForm />
                    </Modal>

                    <Modal isOpen={profileEdit} onRequestClose={()=>setProfileEdit(false)}
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
                        <ProfileNameEditForm />
                    </Modal>

			        <div className="profile-bio">
                        <p><span className="profile-real-name">{profileData.accountName}</span> 컴퓨터공학과 재학중 📷✈️🏕️</p>
                    </div>
                </div>
                <div className="container-bottom">
                    <div className = "store-tag">
                        <img src="../../post.png" style={{width:15, height:15, marginRight:10, marginTop: 10}} />저장됨
                    </div>
                    <div className = "store-tag">
                        <img src="../../tag.png" style={{width:15, height:15, marginRight:10, marginTop: 10}}/>태그됨
                    </div>
                </div>
            </div>
		</header>
    );
};

export default ProfileHead;