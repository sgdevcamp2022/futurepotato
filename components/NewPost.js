import { useCallback, useRef } from "react";
import { useSelector , useDispatch} from "react-redux";
import NewPostText from "./NewPostText";
const NewPost = () => {
    const dispatch = useDispatch();
    const imageInput = useRef();

    const onClickImageUpload = useCallback(() => {
        imageInput.current.click();
    }, [imageInput.current]);

    const {newImage, isImage} = useSelector((state) => state.mainpage);
    console.log(isImage);
    const onChangeImages = useCallback((e) => {
        const imageFormData = new FormData();
        console.log(e.target.files);
        [].forEach.call(e.target.files, (f) => {
            console.log("Asdfasdf", f);
          imageFormData.append('image', f);
          console.log(imageFormData);
        });
        return dispatch({
            type: "IMAGE_UPLOAD_REQUEST",
            data: imageFormData,
        });
      }, [newImage]);

    return(
        <div>
        {isImage ? <NewPostText isEdit = {false}/> : 
        <div className="flex-center">
        <div className = 'modal_window'>
            <div className ='modal_title' style={{borderBottom:"1px solid lightgray", paddingBottom:15,
            paddingTop:15}}>
                <div className = 'modal_title_side'></div>
                <div style={{fontWeight:'bold'}}> 새 게시물 만들기</div>
                <div className ='modal_title_side'></div>
            </div>
            <div className='modal_image_upload'>
                <img src="./newpost.png" style={{width:200, height:150, textAlign:'center',paddingLeft:200, paddingBottom:20}}/>
                <input type="file"  hidden multiple ref={imageInput} onChange={onChangeImages}/>
                <button className="btn profile-edit-btn" onClick={onClickImageUpload}>컴퓨터에서 선택</button>
            </div>
        </div>
        </div>
    }
    </div>
    );
}

export default NewPost;