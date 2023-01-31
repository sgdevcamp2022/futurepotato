import SideRecommendList from "./SideRecommendList";
import SideSwitch from "./SideSwitch";


const Recommend = () => {
    return(
        <>
            <SideSwitch />
            <p className="suggestion-text">회원님을 위한 추천</p>
            <SideRecommendList />
        </>
    );
};

export default Recommend;