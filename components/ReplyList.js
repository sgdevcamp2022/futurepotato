const ReplyList = (props) => {
    return(
        <>
        {props.replyList.map((v, index) => (
            <div key={index} className="comment_form" >
                <div className='comment-info'>
                    <div className='profile-content'>
                        <div className = 'pic-wrapper'>
                            <div className="profile-pic" style = {{width:30, height:30}}>
                                <img src = {v.image} alt = ""/>
                            </div>
                        </div>
                        <div className="name-content-data">
                            <div className='name-content'>
                                <span style = {{fontWeight:'bold'}}>{v.replyWriter}&nbsp;&nbsp;&nbsp;</span>
                                <span style = {{maxWidth:"100%", display:"inline-block",wordBreak:"break-all"}}>{v.reply}</span>
                            </div>
                            <div className = 'date-heart-reply' style = {{fontSize:11, color:'gray'}}>
                                <span style={{cursor:'pointer'}}>삭제</span> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ))}
        </>
    );
}

export default ReplyList;