const commentTest = () => {
    const isReply = true;
    return(
        <div className="comment_form">
            <div className='comment-info'>
                <div className='profile-content'>
                    <div className = 'pic-wrapper'>
                        <div className="profile-pic" style = {{width:30, height:30}}>
                            <img src = '/cover 1.png' alt/>
                        </div>
                    </div>
                    <div className="name-content-data">
                        <div className='name-content'>
                            <span style = {{fontWeight:'bold'}}>이유성&nbsp;&nbsp;&nbsp;</span>
                            <span style = {{maxWidth:"100%", display:"inline-block",wordBreak:"break-all"}}>너무 예뻐요</span>
                        </div>
                        <div className = 'date-heart-reply' style = {{fontSize:11, color:'gray'}}>
                            <span>1일&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span>좋아요 11개&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span>답글 달기</span>
                        </div>
                    </div>
                </div>
                <div className='heart'>
                    <p>♡</p>
                </div>
            </div>
            {isReply ? <div style = {{fontSize:13, paddingLeft:50, color:'gray'}}>--- 답글 보기(2개)</div> : <></>}
        </div>
    );
};

export default commentTest;