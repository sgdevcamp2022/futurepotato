import Modal from 'react-modal';
import { useState } from 'react';
import FolloingModal from '../FollowFolloing/FolloingModal';
import FollowModal from '../FollowFolloing/FollowModal';
const ProfileHead = () => {
    const [followOpen, setFollowOpen] = useState(false);
    const [follingOpen, setFollingOpen] = useState(false);


    return (
        <header>
            <div className="container">
                <div className="profile">
                    <div className="profile-image">
                        <img src="https://images.unsplash.com/photo-1513721032312-6a18a42c8763?w=152&h=152&fit=crop&crop=faces" alt="" />
			        </div>
                    <div className="profile-user-settings">
                        <h1 className="profile-user-name">iyusung2</h1>
                        <button className="btn profile-edit-btn">프로필 편집</button>
                        <button className="btn profile-settings-btn" aria-label="profile settings"><img src="/setting.png" width="17px"/></button>
					</div>

			        <div className="profile-stats">
                        <ul className='profile-stats-ul'>
					        <li>게시글 <span className="profile-stat-count">164</span></li>
					        <li>팔로워 <span className="profile-stat-count" onClick={() => setFollingOpen(true)}>188</span></li>
					        <li>팔로잉 <span className="profile-stat-count" onClick={() => setFollowOpen(true)}>206</span></li>
				        </ul>
                    </div>
                    <Modal isOpen = {followOpen} onRequestClose={() => setFollowOpen(false)} style = {{content:{top:110, bottom:130, height:450, width:400, left:"35%", right:"35%", }}}>
                        <FolloingModal />
                    </Modal>
                    <Modal isOpen = {follingOpen} onRequestClose = {() => setFollingOpen(false)}  style = {{content:{top:110, bottom:130, height:450, width:400, left:"35%", right:"35%", }}}>
                        <FollowModal />
                    </Modal>

			        <div className="profile-bio">
                        <p><span className="profile-real-name">이유성</span> 컴퓨터공학과 재학중 📷✈️🏕️</p>
                    </div>
                </div>
                <div className="container-bottom">
                    <div className = "store-tag">
                        <img src="./post.png" style={{width:15, height:15, marginRight:10, marginTop: 10}} />저장됨
                    </div>
                    <div className = "store-tag">
                        <img src="./tag.png" style={{width:15, height:15, marginRight:10, marginTop: 10}}/>태그됨
                    </div>
                </div>
            </div>
		</header>
    );
};

export default ProfileHead;