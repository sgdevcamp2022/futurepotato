import { useRouter } from 'next/router'
import Profile from '../../components/profile';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
const profile = () => {
    const router = useRouter();
    const {profileid} = router.query;
    console.log(profileid);
    return(
        <Profile id={profileid}/>
    );
}

export default profile;