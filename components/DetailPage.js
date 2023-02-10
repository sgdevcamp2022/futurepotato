import { useSelector } from "react-redux";
import NavBar from "./NavBar";
import { useState } from "react";
import CommentForm from "./Comment/CommentForm";
import CommentList from "./Comment/CommentList";
import UserInfo from "./UserInfo";
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const DetailPage = (props) => {
    const {postList} = useSelector((state) => state.mainpage);
    const item = postList.filter((v) => v.id == props.id ? v : null);
    console.log(item);
    const [currentSlide, setCurrentSlide] = useState(0);
    const settings = {
        dote:true,
        infinite:true,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }
    return(
        <>
        <NavBar />
        <div className = 'detail_window' style={{marginTop:70}}>
            <div className='wrapper-detail'>
                <div className="left-col-detail">
                    <Slider {...settings} 
                        afterChange={(slide) => setCurrentSlide(slide)}
                    >
                        {item[0].imageList.map((i) => (
                            <img src={i.image} className="post-image" alt="" />
                        ))}
                    </Slider>   
                </div>
                <div className="right-col-detail">
                    <UserInfo postId = {item[0].id} postName = {item[0].name} postImage = {item[0].profileImage} isMain = {true}/>
                    <div className="comment-post" style={{}}>
                        <div style={{maxHeight: "80%"}}>
                            <div style={{borderBottom:"1px solid lightgray"}} className="post-story">
                                <p className="description"><span>{item[0].name}</span> {item[0].content}</p>
                                <p className="post-time">{item[0].modifiedDate}</p>
                            </div>
                            {item[0].commentList.length != 0 ? <CommentList commentList = { item[0].commentList} postId  = {item[0].id}/> : <></>}
                        </div>
                        <CommentForm checkHeart = {item[0].likesCheck} postId = {item[0].id} heartCount = {item[0].likeCount}/>
                    </div>  
                </div>
            </div>
        </div>
        </>
    );
};

export default DetailPage;