import { useSelector } from "react-redux";
import React, {useState} from 'react';
import UserInfo from "../UserInfo";
import ReactionWrapper from "../Comment/ReactionWrapper";
import CommentWrapper from "../Comment/CommentWrapper";
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const MainPosts = () => {
    const {content} = useSelector((state) => state.mainpage);
    const [currentSlide, setCurrentSlide] = useState(0);
    const settings = {
        dote:true,
        infinite:true,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }
    console.log(content);
    return (
        <>
            {content.map((v, index) => (
                <div key={index} className="post">
                    <UserInfo postId = {v.postId} postName = {v.accountId} postImage = {v.profileImage} isMain = {true}/>
                    <div className="sliderWrapper">
                    <Slider {...settings} 
                        afterChange={(slide) => setCurrentSlide(slide)}
                    >
                        {v.imageList.map((i, index) => (
                            <div key={index} style={{
                                textAlign: "center"}}>
                            <img src={i.image} className="post-image" alt="" />
                            </div>
                        ))}
                    </Slider>
                    </div>
                    
                    <div className="post-content">
                        <ReactionWrapper checkHeart = {v.likesCheck} id = {v.postId}/>
                        <p className="likes">{v.likeCount}좋아요</p>
                        <p className="description"><span>{v.name}</span> {v.content}</p>
                        <p className="post-time">{v.modifiedDate}</p>
                    </div>
                    <CommentWrapper postId = {v.postId}/>
                </div>
            ))}
        </>
    );
};

export default MainPosts;