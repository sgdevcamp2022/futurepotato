import { useRouter } from 'next/router'
import Profile from '../../components/profile';

const profile = () => {
    const router = useRouter();
    const {profileid} = router.query;
    return(
        <Profile id={profileid}/>
    );
}

export default profile;