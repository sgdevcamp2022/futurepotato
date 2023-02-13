import { all , fork, takeLatest, put, call} from "redux-saga/effects";
import axios from "axios";

function logInAPI(data) {
    return axios.post('/auth/signin', data);
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
    return axios.post('/auth/signup', {
        email: data.id,
        accountId: data.realname,
        accountPw: data.password,
        accountName: data.nickname
    });
}

function* signUp(action){
    try{
        const result = yield call(signUpAPI, action.data);
        yield put({
            type: 'SIGN_UP_SUCCESS',
            data:result.data
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

function profileLoadAPI (data) {
    return axios.get(`/feed/mypage/${data}`);
}

function* profileLoad(action){
    try{
         //const result = yield call(profileLoadAPI, action.data);
        console.log(action);
         yield put({
            type: 'PROFILE_LOAD_SUCCESS',
            data:action.data,
        })
    }catch(err){
        yield put({
            type:'PROFILE_LOAD_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchProfileLoad() {
    yield takeLatest('PROFILE_LOAD_REQUEST', profileLoad);
}

function folloingLoadAPI(data){
    return axios.get(`/${data}/following`);
}

function* folloingLoad(action){
    try{
        //const result = yield call(folloingLoadAPI, action.accountId);
        yield put({
            type:'GET_FOLLOING_SUCCESS',
            //data:result.data
        })
    } catch(err){
        yield put({
            type:'GET_FOLLOING_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchFolloingLoad() {
    yield takeLatest('GET_FOLLOING_REQUEST', folloingLoad);
}


function followerLoadAPI(data){
    return axios.get(`/${data}/followers`);
}

function* followerLoad(action){
    try{
        //const result = yield call(followerLoadAPI, action.accountId);
        yield put({
            type:'GET_FOLLOWER_SUCCESS',
            //data:result.data
        })
    } catch(err){
        yield put({
            type:'GET_FOLLOWER_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchFollowerLoad() {
    yield takeLatest('GET_FOLLOWER_REQUEST', followerLoad);
}

function followRequestAPI(data){
    return axios.post('/follow', {
        senderId:data.senderId,
        recipientId:data.recipientId,
    })
}

function* followRequest(action){
    try{
        //const result = yield call(followRequestAPI, action.data);
         yield put({
            type:'FOLLOW_SUCCESS',
            //data:result.data
        })
    }catch(err){
        yield put({
            type:'FOLLOW_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchFollow(){
    yield takeLatest('FOLLOW_REQUEST', followRequest);
}

function followCancelAPI(data) {
    return axios.delete('/follow', {
        senderId:data.senderId,
        recipientId:data.recipientId,
    })
}

function* followCancel(action){
    try{
        //const result = yield call(followCancelAPI, action.data);
        yield put({
            type:'FOLLOW_CANCEL_SUCCESS',
            //data:result.data
        })
    }catch(err){
        yield put({
            type:'FOLLOW_CANCEL_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchFollowCancel(){
    yield takeLatest('FOLLOW_CANCEL_REQUEST', followCancel);
}


function isFollowAPI(data){
    return axios.get('/isFollowing', {
        senderId:data.senderId,
        recipientId:data.recipientId
    })
}

function* isFollow(action){
    try{
        //const result = yield call(isFollowAPI, action.data);
        yield put({
            type:'GET_IS_FOLLOING_SUCCESS',
            //data:result.result,
        })
    }catch(err){
        yield put({
            type:'GET_IS_FOLLOING_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchIsFolloing(){
    yield takeLatest('GET_IS_FOLLOING_REQUEST', isFollow);
}

function editProfileImageAPI(data){
    return axios.post(`feed/profileImage/${data.accountId}`,{image:data.image});
}

function* editProfileImage(action){
    try{
        //const result = yield call(editProfileImageAPI, action.data);
        yield put({
            type:'PROFILE_IMAGE_SUCCESS',
            //data:result.result,
        })
    }catch(err){
        yield put({
            type:'PROFILE_IMAGE_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchProfileImage() {
    yield takeLatest('PROFILE_IMAGE_REQUEST', editProfileImage);
}

export default function* userSaga(){
    yield all([
        fork(watchLogIn),
        fork(watchSignUp),
        fork(watchProfileLoad),
        fork(watchFolloingLoad),
        fork(watchFollowerLoad),
        fork(watchFollow),
        fork(watchFollowCancel),
        fork(watchIsFolloing),
        fork(watchProfileImage),
    ])
}