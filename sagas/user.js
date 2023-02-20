import { all , fork, takeLatest, put, call, takeEvery,take} from "redux-saga/effects";
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
        console.log(err);
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
        const result = yield call(profileLoadAPI, action.data);
        console.log(action);
         yield put({
            type: 'PROFILE_LOAD_SUCCESS',
            data:result.data,
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
    return axios.get(`/graph/${data}/following`);
}

function* folloingLoad(action){
    try{
        const result = yield call(folloingLoadAPI, action.data);
        yield put({
            type:'GET_FOLLOING_SUCCESS',
            data:result
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
    console.log("asdf");
    return axios.get(`/graph/${data}/follower`);
}

function* followerLoad(action){
    try{
        const result = yield call(followerLoadAPI, action.data);
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
    console.log('요청이 들어가나여');
    return axios.post(`/graph/${data.senderId}/follow/${data.recipientId}`);
}

function* followRequest(action){
    try{
        const result = yield call(followRequestAPI, action.data);
         yield put({
            type:'FOLLOW_FOLLOW_SUCCESS',
        })
    }catch(err){
        yield put({
            type:'FOLLOW_FOLLOW_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchFollow(){
    yield takeLatest('FOLLOW_FOLLOW_REQUEST', followRequest);
}

function followCancelAPI(data) {
    
    return axios.delete(`/graph/${data.senderId}/follow/${data.recipientId}`);
}

function* followCancel(action){
    try{
        const result = yield call(followCancelAPI, action.data);
        yield put({
            type:'FOLLOW_CANCEL_SUCCESS',
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
    return axios.get(`/graph/${data.senderId}/isFollowing/${data.recipientId}`);
}

function* isFollow(action){
    try{
        const result = yield call(isFollowAPI, action.data);
        console.log(result);
        yield put({
            type:'GET_IS_FOLLOING_SUCCESS',
            data:result.data,
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
    return axios.post(`feed/profileImage/${data.accountId}`,data.image,  {headers:{"Content-Type": "multipart/form-data"}});
}

function* editProfileImage(action){
    try{
        const result = yield call(editProfileImageAPI, action.data);
        yield put({
            type:'PROFILE_IMAGE_SUCCESS',
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

function profileEditAPI(data){
    console.log(data.accountId);
    return axios.patch(`/feed/mypage/${data.accountId}`, {accountId: data.accountID, accountName:data.accountName});
}

function* profileEdit(action){
    try{
        const result = yield call(profileEditAPI, action.data);
        yield put({
            type:'PROFILE_EDIT_SUCCESS',
            data:action.data
        })
    }catch(err){
        yield put({
            type:'PROFILE_EDIT_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchProfileEdit(){
    yield takeLatest('PROFILE_EDIT_REQUEST', profileEdit);
}

function searchAPI(data){
    return axios.get(`/feed/users?keyword=${data}`);
}

function* search(action){
    try{
        const result = yield call(searchAPI, action.data);
        console.log(result);
        yield put({type:'SEARCH_REQUEST_SUCCESS', data:result.data});
    }
    catch(err){
        yield put({type: 'SEARCH_REQUEST_FAILURE'});
    }
}
function* watchSearch(){
    yield takeLatest('SEARCH_REQUEST', search);
}


function myProfileAPI(data){
    return axios.get(`/feed/mypage/${data}`);
}

function* myProfile(action){
    try{
        const result = yield call(myProfileAPI,action.data);
        yield put({type:'MY_PROFILE_SUCCESS', data:result.data})
    }catch(err){
        yield put({type:'MY_PROFILE_FAILURE'});
    }
}

function* watchMyProfile(){
    yield takeLatest('MY_PROFILE_REQUEST', myProfile);
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
        fork(watchProfileEdit),
        fork(watchSearch),
        fork(watchMyProfile),
    ])
}