import { useDispatch, useSelector } from "react-redux";

const FolloingForm = (prop) => {
    const data = prop.data;
    const {me} = useSelector((state) => state.user);
    const dispatch = useDispatch();
    const onClickCancel = () => {
        dispatch({type:'FOLLOW_CANCEL_REQUEST' , data:{senderId: me.accountId, recipientId: data.accountId}});
    }
    return(
        <div className="follow-wrapper">
            <div className="profile-pic"><img src={data.profileImage} alt /></div>
            <div className="follow-name">
                <p className="followname">{data.accountId}</p>
                <p className="realname">{data.accountName}</p>
            </div>
            <button className="btn followbtn" onClick={onClickCancel}>취소</button>
        </div>
    );
}

export default FolloingForm;