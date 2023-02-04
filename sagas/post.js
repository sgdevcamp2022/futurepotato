import axios from "axios";
import { all , fork, takeLatest, put, call, putResolve, } from "redux-saga/effects";

function checkPostAPI(postId){
    return axios.get(`/media/${postId}`);
}

function* checkPost(action){
    try{
        const result = yield call(checkPostAPI, action.postList.postId);
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
    console.log(data);
    return axios.post(`/${data.accountId}/media`,{
        "content" : data.data,
        "imageList" : data.dataImage,
    })
}

function* addPost (action) {
    try{
        //yield call(addPostAPI, action.data, action.dataImage, action.accountId);
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
       // const result = yield call(modifyPostAPI, action.name, action.postId, action.content);
        yield put({
            type:'MOD_POST_SUCCESS',
            data:action.data,
            dataId:action.dataId,
            //data:result.data,
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
    return axios.delete(`/${data.accountId}/media/${data.postId}`)
}

function* removePost(action) {
    try{
        //const result = yield call(removePostAPI, action.accountId,action.postId);
        yield put({
            type:'REMOVE_POST_SUCCESS',
            data:1,
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

export default function* crudSaga(){
    yield all([
        fork(watchAddPost),
        fork(watchRemovePost),
        fork(watchModifyPost),
        fork(watchCheckPost),
    ])
}