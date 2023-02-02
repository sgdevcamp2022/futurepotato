import Link from 'next/link';
import { useSelector } from 'react-redux';
const SideSwitch = () => {
    const {me} = useSelector((state) => state.user);
    return(
        <div className="profile-card">
            <div className="profile-pic">
                <img src={me.profileimage} alt="" />
            </div>
            <div>
                <p className="username">{me.accountId}</p>
                <p className="sub-text">{me.username}</p>
            </div>
            <div className="action-btn-wrapper">
                <Link href = '/profile' legacyBehavior>
                    <button className="action-btn">전환</button>
                </Link>
            </div>
        </div>
    );
}

export default SideSwitch;