import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import AppLayout from "./AppLayout";
import ProfileHead from "./Profile/ProfileHead";
import ProfilePageWrapper from "./Profile/ProfilePageWrapper";
const Profile = (prop) => {
    const dispatch = useDispatch();
    const {me, isProfileLoading} = useSelector((state)=>state.user);
    //const isMe = prop.id == me.accountId ? true : dispatch({type:'GET_FOLLOING_REQUEST', data:{senderId: me.accountId, recipientId:prop.id}});
    const isMe = prop.id == me.accountId ? true : false;
    useEffect(() => {
        console.log(prop.id);
        dispatch({type:'PROFILE_LOAD_REQUEST', data: prop.id});
        if(!isMe){
            dispatch({type:'GET_IS_FOLLOING_REQUEST', data: {senderId: me.accountId, recipientId:prop.id}});
        }
    }, [prop.id])
    return (
        <>
        {isProfileLoading ? <>
            <AppLayout />
            <ProfileHead isMe = {isMe} profileId = {prop.id}/>
            <ProfilePageWrapper />
        </> : <div>로딩중</div>}
        </>
        
    );
};

export default  Profile;