import Link from "next/link";
import useInput from "../hooks/useInput";
import { useState } from "react";
import {useDispatch, useSelector} from 'react-redux';
import { signupRequestAction } from "../reducers/user";
import { useRouter } from "next/router";
const signup = () => {
    const [id, onChangeId] = useInput('');
    const [nickname , onChangeNickname] = useInput('');
    const [realname, onChangeRealname] = useInput('');
    const [password, onChangePassword] = useInput('');

    const {isSignupSuccess} = useSelector((state) => state.user)
    const router = useRouter();

    const dispatch = useDispatch();
    const onSubmit = () => {
        if(id.length == 0 || nickname.length == 0 || realname.length == 0 || password.length == 0){
                window.alert('전부 입력되지 않았습니다.');
                return;
        }
        console.log("asdf");
        dispatch(signupRequestAction({id,realname,nickname,password}));
    };

    return(
    <>
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
                        placeholder="이메일 주소"/>
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
                        style={{imeMode:'inactive'}}
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
                        <button className="login-button" onClick={onSubmit}>제출</button>
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
    </>
    );
};

export default signup;