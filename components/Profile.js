import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import AppLayout from "./AppLayout";
import ProfileHead from "./Profile/ProfileHead";
import ProfilePageWrapper from "./Profile/ProfilePageWrapper";
const Profile = (prop) => {
    const dispatch = useDispatch();
    const {me} = useSelector((state)=>state.user);
    //const isMe = prop.id == me.accountId ? true : dispatch({type:'GET_FOLLOING_REQUEST', data:{senderId: me.accountId, recipientId:prop.id}});
    const isMe = prop.id == me.accountId ? true : false;
    useEffect(() => {
        dispatch({type:'PROFILE_LOAD_REQUEST', data: prop.id});
    }, [])
    return (
        <>
            <AppLayout />
            <ProfileHead isMe = {isMe}/>
            <ProfilePageWrapper />
        </>
    );
};

export default  Profile;