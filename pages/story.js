import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';

const story = () => {
    const {storyListId, isStoryReady} = useSelector((state)=>state.mainpage); 
    const dispatch = useDispatch();
    const [currentSlide, setCurrentSlide] = useState(0);

    useEffect(() => {
        console.log("aaaaaa");
        dispatch({type: "STORY_REQUEST"});
    }, []);

    console.log(storyListId);
    const settings = {
        dote:true,
        infinite:false,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }
    return(
        <>
        {isStoryReady ? 
        <div className="sliderWrapper">
            <Slider {...settings} afterChange={(slide) => setCurrentSlide(slide)}>
                {storyListId.storyList.map((i, index) => (
                    <div key={index} style={{textAlign: "center"}}>
                        <img src={i.storedStoryImage} className="post-image" alt="" />
                    </div>
                ))}
            </Slider>
        </div>
        : <div>로딩중</div>}
        </>
    );
}

export default story;