import FollowList from "./FollowList";
const FolloingModal = () => {
    return(
        <div className="flex-center">
        <div className="modal_window_option">
            <div className="follwing-title">팔로잉</div>
            <FollowList />
        </div>
        </div>
    );
}

export default FolloingModal;