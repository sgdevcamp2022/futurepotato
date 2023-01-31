import { tokenInsertHeader } from "../hooks/tokenInsertHeader";
import produce from 'immer'

export const initialState = {
    isLoggedIn:false,
    me:null,
    signUpData:{},
    loginData:{},
}

export const loginRequestAction = (data) => ({
    type: 'LOG_IN_REQUEST',
    data,
  });

export const signupRequestAction = (data) => ({
    type: 'SIGN_UP_REQUEST',
    data,
});

export const logoutRequestAction = () => ({
    type:'LOG_OUT',
})

//이전 상태를 액션을 통해 다음 상태로 만들어내는 함수(불면성은 지키고)
const reducer = (state = initialState, action) => produce(state, (draft) => {
        switch(action.type){
            case 'LOG_IN_REQUEST' :
                draft.isLoggedIn = false;
                break;
            case 'LOG_IN_SUCCESS' :
                localStorage.setItem('token', action.data.token);
                tokenInsertHeader(action.data.token);
                draft.isLoggedIn = true;
                draft.me = action.data;
                break;
            case 'LOG_IN_FAILURE' :
                draft.isLoggedIn = true;
                break;
    
            case 'SIGN_UP_REQUEST' :
                break;
            case 'SIGN_UP_SUCCESS' :
                break;
            case 'SIGN_UP_FAILURE' :
                break;
    
            case 'LOG_OUT' :
                localStorage.clear();
                draft.isLoggedIn = false;
                break;
            default:
                break;
    
        }
});

export default reducer;