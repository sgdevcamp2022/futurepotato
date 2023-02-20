import { useCallback, useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
const ProfileEditForm = () => {
    const imageInput = useRef();
    const dispatch = useDispatch();
    const {me} = useSelector((state) => state.user);
    const onClickImageUpload = useCallback(() => {
        imageInput.current.click();
    }, [imageInput.current]);

    const onChangeImages = useCallback((e) => {
        const imageFormData = new FormData();
        console.log(e.target.files);
        [].forEach.call(e.target.files, (f) => {
            imageFormData.append('multipartFile', f);
        });
        return dispatch({
            type: "PROFILE_IMAGE_REQUEST",
            data: {image: imageFormData, accountId: me.accountId},
        });
    }, []);

    return(
        <div className="flex-center">
            <div className="modal_window_option">
                <div className="follwing-title">프로필 이미지 편집</div>
                    <div className="Follow_ing_list">
                        <div className='modal_image_upload'>
                
                            <input type="file"  hidden multiple ref={imageInput} onChange={onChangeImages}/>
                            <button className="btn profile-edit-btn" onClick={onClickImageUpload}>컴퓨터에서 선택</button>
                        </div>
                    </div>    
                </div>
            </div>
    );
}

export default ProfileEditForm;