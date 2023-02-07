import { useRouter } from 'next/router'
import Profile from '../../components/profile';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
const profile = () => {
    const router = useRouter();
    const {profileid} = router.query;
    const dispatch = useDispatch();
    
    useEffect(() => { 
        dispatch({type:'PROFILE_LOAD_REQUEST', data: profileid});
    },[])

    return(
        <Profile id={profileid}/>
    );
}

export default profile;