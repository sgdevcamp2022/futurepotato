import Link from "next/link";
import { useCallback, useState} from "react";
import {useDispatch} from 'react-redux';
import { loginRequestAction } from "../../reducers/user";

const Login = () => {
    const [accountId, setId] = useState('');
    const onChangeId = useCallback((e) => {
        setId(e.target.value);
    }, []);

    const [accountPw, setPassword] = useState('');
    const onChangePassword = useCallback((e) => {
        setPassword(e.target.value);
    },[]);

    const dispatch = useDispatch();

    const onSubmit = () => {
        dispatch(loginRequestAction({accountId, accountPw}));
    };

    return (
        <div className="flex-login">
            <div className="login-container">
                <div className="flex-center logo-wrapper">
                    <span className="logo-text">instagram</span>
                </div>
                <div className="input-wrapper">
                    <div className="login-wrapper flex-center">
                        <input
                            className="login-input"
                            type="text"
                            value={accountId}
                            onChange = {onChangeId}
                            placeholder="전화번호, 사용자 이름 또는 이메일"/>
                    </div>
                    <div className="login-wrapper flex-center">
                        <input 
                            className="login-input" 
                            type="password" 
                            value={accountPw}
                            onChange={onChangePassword}
                            placeholder="비밀번호" />
                    </div>
                    <div className="flex-center button-wrapper" >
                        <button className="login-button" onClick={onSubmit}>로그인</button>
                    </div>
                </div>
                <div className="flex-center findpass">
                    <a>비밀번호를 잊으셨나요?</a>
                </div>
            </div>
            <div className="signup-container">
                <div>계정이 없으신가요?</div>
                <Link href = "/signup" legacyBehavior>
                    <div className="signup">가입하기</div>
                </Link>
            </div>
        </div>
    );
};

export default Login;