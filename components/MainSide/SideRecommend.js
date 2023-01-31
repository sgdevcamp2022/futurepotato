const SideRecommend = () => {
    return(
        <div className="profile-card">
            <div className="profile-pic">
                <img src="/cover 9.png" alt="" />
            </div>
        <div>
            <p className="username">modern_web_channel</p>
            <p className="sub-text">유저가 팔로우합니다.</p>
        </div>
        <div className="action-btn-wrapper">
            <button className="action-btn">팔로우</button>
        </div>
    </div>
    );
}

export default SideRecommend;