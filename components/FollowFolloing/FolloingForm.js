const FolloingForm = (prop) => {
    const data = prop.data;
    return(
        <div className="follow-wrapper">
            <div className="profile-pic"><img src={data.profileImage} alt /></div>
            <div className="follow-name">
                <p className="followname">{data.accountId}</p>
                <p className="realname">{data.accountName}</p>
            </div>
            <button className="btn followbtn">취소</button>
        </div>
    );
}

export default FolloingForm;