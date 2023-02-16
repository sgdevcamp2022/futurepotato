import { useState } from "react";
import CommentForm from "./Comment/CommentForm";
import CommentList from "./Comment/CommentList";
import UserInfo from "./UserInfo";
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const DetailItem = (prop) => {
    const postItem = prop.postItem;
    console.log(prop);
    console.log(postItem.likeCount)
    console.log(postItem.likesCheck)
    const [currentSlide, setCurrentSlide] = useState(0);
    const settings = {
        dote:true,
        infinite:true,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }

    return(
        <div className = 'detail_window' style={{marginTop:70}}>
            <div className='wrapper-detail'>
                <div className="left-col-detail">
                    <Slider {...settings} 
                        afterChange={(slide) => setCurrentSlide(slide)}
                    >
                        {postItem.imageList.map((i) => (
                            <img src={i.image} className="post-image" alt="" />
                        ))}
                    </Slider>   
                </div>
                <div className="right-col-detail">
                    <UserInfo postId = {postItem.postId} postName = {postItem.accountId} postImage = {postItem.profileImage} isMain = {true}/>
                    <div className="comment-post" style={{}}>
                        <div>
                            <div style={{borderBottom:"1px solid lightgray"}} className="post-story">
                                <p className="description"><span>{postItem.accountId}</span> {postItem.content}</p>
                                <p className="post-time">{postItem.modifiedDt}</p>
                            </div>
                            {postItem.commentList.length != 0 ? <CommentList commentList = { postItem.commentList}/> : <></>}
                        </div>
                        <CommentForm checkHeart = {postItem.likesCheck} postId = {postItem.postId} heartCount = {postItem.likeCount}/>
                    </div>  
                </div>
            </div>
        </div>
    );
}

export default DetailItem