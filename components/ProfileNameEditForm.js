
import { useDispatch, useSelector } from "react-redux";
import { useState, useCallback } from "react";
const ProfileNameEditForm = () => {
    const {me} = useSelector((state) => state.user);
    const dispatch = useDispatch();

    const [accountId, setAccountId] = useState('');
    const onChangeId = useCallback((e) => {
        setAccountId(e.target.value);
    }, []);

    const [accountName, setAccountName] = useState('');
    const onChangeName = useCallback((e) => {
        setAccountName(e.target.value);
    },[]);

    const onClickProfileEdit = () => {
        dispatch({type : 'PROFILE_EDIT_REQUEST', data:{accountId, accountName, originalId: me.accountId}})
    }
    
    return(
        <div className="flex-center">
            <div className="modal_window_option">
                <div className="follwing-title">프로필 편집</div>
                <div className="Follow_ing_list">
                    <div className ='modal_title_option_user'>
                        <div> 프로필 이름 :</div>
                        <input placeholder={me.username} value={accountName}
                            onChange = {onChangeName}/>
                    </div>
                    <div className ='modal_title_option_user'>
                        <div> 프로필 아이디 : </div>
                        <input placeholder={me.accountId} value={accountId}
                            onChange = {onChangeId}/>
                    </div>
                    <button className="btn profile-edit-btn" onClick={onClickProfileEdit}>프로필 편집</button>
                </div>    
            </div>
        </div>
    );
}

export default ProfileNameEditForm;