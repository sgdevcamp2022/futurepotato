import AppLayout from "../components/AppLayout";
import ProfileHead from "../components/Profile/ProfileHead";
import ProfilePageWrapper from "../components/Profile/ProfilePageWrapper";
import OtherProfileHead from "../components/Profile/OtherProfileHead";
const profile = () => {
    return (
        <>
            <AppLayout />
            <ProfileHead />
            <ProfilePageWrapper />
        </>
    );
};

export default  profile;