import FollowerList from './FollowerList'
const FollowModal = () => {
    return(
        <div className="flex-center">
        <div className="modal_window_option">
            <div className="follwing-title">팔로워</div>
            <FollowerList />
        </div>
        </div>
    );
}

export default FollowModal;