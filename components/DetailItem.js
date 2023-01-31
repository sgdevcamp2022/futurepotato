import { useState } from "react";
import CommentForm from "./Comment/CommentForm";
import CommentList from "./Comment/CommentList";
import UserInfo from "./UserInfo";
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const DetailItem = (prop) => {
    const postItem = prop.postItem;
    const [currentSlide, setCurrentSlide] = useState(0);
    const settings = {
        dote:true,
        infinite:true,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }

    return(
        <div className = 'detail_window'>
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
                        <UserInfo />
                        <div className="comment-post">
                            <div style={{borderBottom:"1px solid lightgray;"}} className="post-story">
                                <p className="description"><span>{postItem.name}</span> {postItem.content}</p>
                                <p className="post-time">{postItem.modifiedDate}</p>
                            </div>
                            {postItem.commentList.length != 0 ? <CommentList commentList = { postItem.commentList}/> : <></>}
                        </div>
                    </div>
                </div>
        </div>
    );
}

export default DetailItem