import { all , fork, takeLatest, put, call} from "redux-saga/effects";
import axios from "axios";

function logInAPI(data) {
    return axios.post("/auth/signin", data);
}

function* logIn(action){
    try{
        console.log(action.data);
        const result = yield call(logInAPI, action.data);
        yield put({
            type:'LOG_IN_SUCCESS',
            data:result.data
        });
    } catch (err){
        console.log(err);
        yield put({
            type:'LOG_IN_FAILURE',
            data: err.response,
        })
    }
}

function* watchLogIn(){
    yield takeLatest('LOG_IN_REQUEST', logIn);
}

function signUpAPI(data){
    return axios.post('/signup', {
        email: data.id,
        accountId: data.realname,
        accountPw: data.password,
        accountName: data.nickname
    });
}

function* signUp(action){
    try{
        //const result = yield call(signUpAPI, action.data);
        yield put({
            type: 'SIGN_UP_SUCCESS',
            data:action.data
        })
    }catch(err){
        yield put({
            type:'SIGN_UP_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchSignUp() {
    yield takeLatest('SIGN_UP_REQUEST', signUp);
}

export default function* userSaga(){
    yield all([
        fork(watchLogIn),
        fork(watchSignUp),
    ])
}