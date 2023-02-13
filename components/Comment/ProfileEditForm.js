import { useCallback, useRef } from "react";
const ProfileEditForm = () => {
    const imageInput = useRef();

    const onClickImageUpload = useCallback(() => {
        imageInput.current.click();
    }, [imageInput.current]);

    const onChangeImages = useCallback((e) => {
        const imageFormData = new FormData();
        console.log(e.target.files);
        [].forEach.call(e.target.files, (f) => {
            imageFormData.append('image', f);
        });
        console.log(imageFormData.get('image'));
        return dispatch({
            type: "IMAGE_UPLOAD_REQUEST",
            data: imageFormData,
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