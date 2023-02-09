import { useRouter } from 'next/router'
import Profile from '../../components/profile';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
const profile = () => {
    const router = useRouter();
    const {profileid} = router.query;
    const dispatch = useDispatch();
    console.log("로딩이 됬나요?");
    

    return(
        <Profile id={profileid}/>
    );
}

export default profile;