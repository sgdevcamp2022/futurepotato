import Link from "next/link";
import useInput from "../hooks/useInput";
import {useDispatch} from 'react-redux';
import { signupRequestAction } from "../reducers/user";
const signup = () => {
    const [id, onChangeId] = useInput('');
    const [nickname , onChangeNickname] = useInput('');
    const [realname, onChangeRealname] = useInput('');
    const [password, onChangePassword] = useInput('');

    
    const dispatch = useDispatch();
    const onSubmit = () => {
        dispatch(signupRequestAction({id,realname,nickname,password}));
    };

    return(
    <div className="flex-center">    
        <div className="login-container">
            <div className="flex-center logo-wrapper">
                <span className="logo-text">instagram</span>
            </div>
            <div className="input-wrapper">
                <div className="login-wrapper flex-center">
                    <input
                        className="login-input"
                        type="text"
                        value={id}
                        onChange={onChangeId}
                        placeholder="휴대폰 번호 또는 이메일 주소"/>
                </div>
                <div className='login-wrapper flex-center'>
                    <input
                        className="login-input"
                        type='text'
                        placeholder='성명'
                        value={realname}
                        onChange={onChangeRealname}
                    />
                </div>
                <div className='login-wrapper flex-center'>
                    <input
                        className="login-input"
                        type='text'
                        placeholder='사용자 이름'
                        value={nickname}
                        onChange={onChangeNickname}
                    />
                </div>
                <div className="login-wrapper flex-center">
                    <input 
                        className="login-input" 
                        type="password" 
                        placeholder="비밀번호"
                        value={password}
                        onChange = {onChangePassword} 
                    />
                </div>
                <div className="flex-center button-wrapper">
                    <Link href="/" legacyBehavior>
                        <button className="login-button" onClick={onSubmit}>가입</button>
                    </Link>
                </div>

                <div className="flex-center findpass_two">
                    <a>친구들의 새로운 소식과 사진을 보려면 가입하세요</a>
                </div>
            </div>
            <div className="flex-center findpass">
                <Link href="/" legacyBehavior>
                    <a>계정이 있으신가요? 로그인</a>
                </Link>
            </div>
        </div>
    </div>
    );
};

export default signup;