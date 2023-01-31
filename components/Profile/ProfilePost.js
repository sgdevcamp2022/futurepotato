const ProfilePost = () => {
    return(
        <>
            <div className="gallery-item" tabindex="0">
                <img src="https://images.unsplash.com/photo-1511765224389-37f0e77cf0eb?w=500&h=500&fit=crop" className="gallery-image" alt="" />
                <div className="gallery-item-info">
                    <ul>
					    <li className="gallery-item-likes"><span>♥</span><i className="fas fa-heart" aria-hidden="true"></i> 56</li>
					    <li className="gallery-item-comments"><span>■</span><i className="fas fa-comment" aria-hidden="true"></i> 2</li>
				    </ul>
                </div>
            </div>
        </>
    );
};

export default ProfilePost;