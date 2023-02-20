import { useSelector,useDispatch } from "react-redux";
import NavBar from "./NavBar";
import { useState,useEffect } from "react";
import CommentForm from "./Comment/CommentForm";
import CommentList from "./Comment/CommentList";
import UserInfo from "./UserInfo";
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const DetailPage = (data) => {
    const {currentReqPost, isLoadingPost, isLikePost} = useSelector((state) => state.mainpage);
    const [currentSlide, setCurrentSlide] = useState(0);
    const [isLoading, setIsLoading] = useState(true);
    const dispatch = useDispatch();
    
    useEffect(() => {
        dispatch({type:'POST_INFO_REQUEST', data: {postId:data.data}});
        setIsLoading(false);
    }, []);
    console.log(currentReqPost);
    const settings = {
        dote:true,
        infinite:true,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }
    return(
        <>
        {!isLoadingPost ? <div>로딩중</div> :
        <div>
        <NavBar />
        <div className = 'detail_window' style={{marginTop:70}}>
            <div className='wrapper-detail'>
                <div className="left-col-detail">
                    <Slider {...settings} 
                        afterChange={(slide) => setCurrentSlide(slide)}
                    >
                        {currentReqPost.imageList.map((i, index) => (
                            <img key={index} src={i} className="post-image" alt="" />
                        ))}
                    </Slider>   
                </div>
                <div className="right-col-detail">
                    <UserInfo postId = {currentReqPost.postId} postName = {currentReqPost.accountId} postImage = {currentReqPost.profileImage} isMain = {true}/>
                    <div className="comment-post" style={{}}>
                        <div style={{maxHeight: "80%"}}>
                            <div style={{borderBottom:"1px solid lightgray"}} className="post-story">
                                <p className="description"><span>{currentReqPost.accountId}</span> {currentReqPost.content}</p>
                                <p className="post-time">{currentReqPost.createdDt}</p>
                            </div>
                            {currentReqPost.commentList.length != 0 ? <CommentList /> : <></>}
                        </div>
                        <CommentForm checkHeart = {isLikePost} postId = {currentReqPost.postId} heartCount = {currentReqPost.likeCount}/>
                    </div>  
                </div>
            </div>
        </div>
        </div>}
        </>
    );
};

export default DetailPage;