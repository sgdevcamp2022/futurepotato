import axios from "axios";
import { all , fork, takeLatest, put, call, putResolve, } from "redux-saga/effects";

function checkPostAPI(postId){
    return axios.get(`/media/${postId}`);
}

function* checkPost(action){
    try{
        //const result = yield call(checkPostAPI, action.postList.postId);
        yield put({
            type:'POST_INFO_SUCCESS',
            data: result.data,
        })
    } catch (err) {
        yield put({
            type:"POST_INFO_FAILURE",
            data: err.response.data,
        })
    }
}

function* watchCheckPost(){
    yield takeLatest('POST_INFO_REQUEST', checkPost);
}

function addPostAPI(data){
    return axios.post(`/${data.name}/media`,{
        "content" : data.content,
        "imageList" : [{"image" : data.image}],
    })
}

function* addPost (action) {
    try{
        //yield call(addPostAPI, action.data);
        yield put({
            type:'ADD_POST_SUCCESS',
        })
    } catch (err){
        yield put({
            type:'ADD_POST_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchAddPost(){
    yield takeLatest('ADD_POST_REQUEST', addPost);
}

function modifyPostAPI (data) {
    return axios.patch(`/${data.name}/media/${data.postId}`, {
        "content" : data.content,
    })
}

function* modifyPost(action){
    try{
        //const result = yield call(modifyPostAPI, action.data);
        yield put({
            type:'MOD_POST_SUCCESS',
            data:result.data,
        });

    } catch(err){
        yield put({
            type:'MOD_POST_FAILURE',
            data:err.response.data,
        })
    }
}

function* watchModifyPost(){
    yield takeLatest('MOD_POST_REQUEST', modifyPost);
}

function removePostAPI(data) {
    return axios.delete(`/${data.name}/media/${data.postId}`)
}

function* removePost(action) {
    try{
        //const result = yield call(removePostAPI, action.data);
        yield put({
            type:'REMOVE_POST_SUCCESS',
            data:result.data,
        })
    } catch (err){
        yield put ({
            type: 'REMOVE_POST_FAILURE',
            data: err.response.data,
        })
    }
}

function* watchRemovePost(){
    yield takeLatest('REMOVE_POST_REQUEST', removePost);
}

export default function* userSaga(){
    yield all([
        fork(watchAddPost),
        fork(watchRemovePost),
        fork(watchModifyPost),
        fork(watchCheckPost),
    ])
}