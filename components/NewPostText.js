import React, {useCallback, useState} from 'react';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import UserInfo from './UserInfo';
import { useSelector } from 'react-redux';
import {useDispatch} from 'react-redux';

const NewPostText = (props) => {
    const dispatch = useDispatch();

    const {me} = useSelector((state) => state.user);
    const {newImage} = useSelector((state) => state.mainpage);
    
    const [postText, setPostText] = useState('');
    const onChangePostText = useCallback((e) => {
        setPostText(e.target.value);
    }, []);

    const [currentSlide, setCurrentSlide] = useState(0);
    const settings = {
        dote:true,
        infinite:true,
        speed:500,
        slidesToShow: 1,
        slidesToScroll: 1,
    }



    const onSubmit = () =>{
        props.isEdit ? dispatch({type:'MOD_POST_REQUEST', data:postText, dataId:me.accountId})
        : dispatch({type:'ADD_POST_REQUEST', dataId:me.accountId, data:postText, dataImage:newImage});
    }
    return(
        <div className="flex-center">
            <div className="modal_window" >
                <div className="modal_title"  style={{borderBottom:"1px solid lightgray", paddingBottom:15,
                paddingTop:15}}>
                    <div className = 'modal_title_side'></div>
                    <div style={{fontWeight:'bold'}}> {props.isEdit ? "게시물 수정하기" : "세 게시물 만들기"}</div>
                    <div className ='modal_title_side'></div>
                </div>
                <div className='wrapper-detail' style={{girdTemplateColumns:"50% 50%"}}>
            <div className="left-col-detail"> 
                <Slider {...settings}  afterChange={(slide) => setCurrentSlide(slide)}>
                    {newImage.map((p) => (
                        <img src={p.image} className="post-image" alt="" style={{objectFit:"contain", height:200, width:400}}/>
                    ))}
                </Slider>
            </div>
            <div className="right-col-detail" style={{padding:0, display:'flex', flexDirection:'column'}}>
                <div>
                    <UserInfo postImage = {me.profileimage} postId = {me.accountId} postName = {me.username} isMain = {false}/>
                    <textarea placeholder={props.isEdit ? '' : '내용 작성...'} style={{height:100, width:350}}
                    value={postText} onChange={onChangePostText}/>
                </div>
                <button className="btn profile-edit-btn" onClick={onSubmit}>{props.isEdit ? "수정하기" : "공유하기"}</button>
            </div>
            </div>

            </div>
        </div>
    )
}

export default NewPostText;