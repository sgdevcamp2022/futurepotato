import Link from "next/link";

const ReactionWrapper = (props) => {
    console.log(props.id);
    return(
        <div className="reaction-wrapper">
            {props.checkHeart ? <img src="/like.PNG" className="icon" alt="" />
            : <img src="/like.PNG" className="icon" alt="" />}
            <Link href = {`/detail/${props.id}`} legacyBehavior>
                <img src="/comment.PNG" className="icon" alt="" />
            </Link>
            <img src="/send.PNG" className="icon" alt="" />
            <img src="/save.PNG" className="save icon" alt="" />
        </div>
    );
};

export default ReactionWrapper;