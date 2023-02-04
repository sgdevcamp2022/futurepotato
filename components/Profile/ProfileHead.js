import Modal from 'react-modal';
import { useState } from 'react';
import FolloingModal from '../FollowFolloing/FolloingModal';
import FollowModal from '../FollowFolloing/FollowModal';
import { useDispatch, useSelector } from 'react-redux';
const ProfileHead = () => {
    const [followOpen, setFollowOpen] = useState(false);
    const [follingOpen, setFollingOpen] = useState(false);
    const {profileData} = useSelector((state) => state.user);
    const dispatch = useDispatch();

    const onClickfollowerOpen = () => {
        setFollowOpen(true);
        dispatch({type:'GET_FOLLOWER_REQUEST'});
    }

    const onClickfolloingOpen = () => {
        setFollingOpen(true);
        dispatch({type:'GET_FOLLOING_REQUEST'});
    }

    return (
        <header>
            <div className="container">
                <div className="profile">
                    <div className="profile-image" >
                            <img src={profileData.profileImage} alt="" />
                    </div>
                    <div className="profile-user-settings">
                        <h1 className="profile-user-name">{profileData.name}</h1>
                        <button className="btn profile-edit-btn">프로필 편집</button>
                        <button className="btn profile-settings-btn" aria-label="profile settings"><img src="/setting.png" width="17px"/></button>
					</div>

			        <div className="profile-stats">
                        <ul className='profile-stats-ul'>
					        <li>게시글 <span className="profile-stat-count">{profileData.postCount}</span></li>
					        <li>팔로워 <span className="profile-stat-count" onClick={onClickfollowerOpen}>{profileData.followerCount}</span></li>
					        <li>팔로잉 <span className="profile-stat-count" onClick={onClickfolloingOpen}>{profileData.followingCount}</span></li>
				        </ul>
                    </div>
                    <Modal isOpen = {followOpen} onRequestClose={() => setFollowOpen(false)} style = {{content:{top:110, bottom:130, height:450, width:400, left:"35%", right:"35%", }}}>
                        <FolloingModal />
                    </Modal>
                    <Modal isOpen = {follingOpen} onRequestClose = {() => setFollingOpen(false)}  style = {{content:{top:110, bottom:130, height:450, width:400, left:"35%", right:"35%", }}}>
                        <FollowModal />
                    </Modal>

			        <div className="profile-bio">
                        <p><span className="profile-real-name">{profileData.name}</span> 컴퓨터공학과 재학중 📷✈️🏕️</p>
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