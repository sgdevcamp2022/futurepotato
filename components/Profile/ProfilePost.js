import { useDispatch } from "react-redux";
import Link from 'next/link';

const ProfilePost = (props) => {
    const dispatch = useDispatch();
    const onClickImage = () => {
        dispatch({type:'POST_INFO_REQUEST', data: props.postId})
    }
    return(
        <>
        <Link href = {`/detail/${props.postId}`} legacyBehavior>
            <div className="gallery-item" tabIndex="0">
                    <img src={props.image} className="gallery-image" onClick={onClickImage} alt="" />
                        <div className="gallery-item-info">
                        <ul>
					        <li className="gallery-item-likes"><span>♥</span><i className="fas fa-heart" aria-hidden="true"></i> 56</li>
					        <li className="gallery-item-comments"><span>■</span><i className="fas fa-comment" aria-hidden="true"></i> 2</li>
				        </ul>
                    </div>
            </div>
        </Link>
        </>
    );
};

export default ProfilePost;