import axios from "axios";
import { all , fork, takeLatest, put, call, putResolve, take, } from "redux-saga/effects";

function checkPostAPI(data){
    return axios.get(`/feed/media/${data.postId}`);
}

function* checkPost(action){
    try{
        const result = yield call(checkPostAPI, action.data);
        yield put({
            type:'POST_INFO_SUCCESS',
            data: result,
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
    console.log(data.content);
    return axios.post(`/feed/${data.accountId}/media`, data.content,
        {headers:{"Content-Type": "multipart/form-data"}}
    )
}

function* addPost (action) {
    try{
        yield call(addPostAPI, action.data);
        yield put({
            type:'ADD_POST_SUCCESS',
            data:action.data
        })
    } catch (err){
        console.log(err);
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
    const content = data.content;
    return axios.patch(`/feed/${data.accountId}/media/${data.postId}?content=${content}`);
}

function* modifyPost(action){
    try{
       const result = yield call(modifyPostAPI, action.data);
        yield put({
            type:'MOD_POST_SUCCESS',
            data:action.data,
            dataId:action.dataId,
            //data:result.data,
        });

    } catch(err){
        console.log(err);
        yield put({
            type:'MOD_POST_FAILURE',
        })
    }
}

function* watchModifyPost(){
    yield takeLatest('MOD_POST_REQUEST', modifyPost);
}

function removePostAPI(data) {
    console.log(data);
    return axios.delete(`/feed/${data.accountId}/media/${data.postId}`);
}

function* removePost(action) {
    try{
        const result = yield call(removePostAPI, action.data);
        yield put({
            type:'REMOVE_POST_SUCCESS',
            //data:3,
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

function addReplyAPI(data){
    return axios.post(`/feed/${data.accountId}/${data.commentId}/reply`, {reply : data.reply});
}

function* addReply(action){
    try{
        const result = yield call(addReplyAPI, action.data);
        yield put({
            type:'ADD_REPLY_SUCCESS',
            data:action.data,
        })
    }catch(err){
        yield put({
            type:'ADD_REPLY_FAILURE',
            data: err.response.data,
        })
    }
}

function* watchAddReply(){
    yield takeLatest('ADD_REPLY_REQUEST', addReply);
}


function addCommentAPI(data){
    const message = data.content;
    return axios.post(`/feed/${data.datame.accountId}/${data.dataw}/comment`,{'comment': message});
}

function* addComment(action){
    try{
        //console.log(action);
        const result = yield call(addCommentAPI, action.data);
        yield put({
            type:'ADD_COMMENT_SUCCESS',
            data:result
        })
    }catch(err){
        console.log(err);
        yield put({
            type:"ADD_COMMENT_FAILURE",
            data:err.response.data
        })
    }
}

function* watchAddComment(){
    yield takeLatest('ADD_COMMENT_REQUEST', addComment);
}

function deleteCommentAPI(data){
    console.log("Asdfasdf");
    return axios.delete(`/feed/${data.accountId}/comment/${data.commentId}`);
}

function* deleteComment(action){
    try{
        const result = yield call(deleteCommentAPI, action.data);
        yield put({
            type:'DELETE_COMMENT_SUCCESS',
            data:action.data
            //data:result
        })
    }catch(err){
        yield put({
            type:"DELETE_COMMENT_FAILURE",
            data: err.response.data,
        })
    }
}

function* watchRemoveComment(){
    yield takeLatest('DELETE_COMMENT_REQUEST', deleteComment);
}

function deleteReplyAPI(data){
    return axios.delete(`/feed/${data.accountId}/reply/${data.replyId}`);
}

function* deleteReply(action){
    try{
        const result = yield call(deleteReplyAPI, action.data);
        yield put({
            type:'DELETE_REPLY_SUCCESS',
            //data:result
        })
    }catch(err){
        yield put({
            type:"DELETE_REPLY_FAILURE",
            data: err.response.data,
        })
    }
}

function* watchRemoveReply(){
    yield takeLatest('DELETE_REPLY_REQUEST', deleteReply);
}

function alarmRequestAPI(data){
    return axios.get(`/alarm/${data}`);
}

function* alarmRequest(action){
    try{
        //const result = yield call(alarmRequestAPI, action.data);
        yield put({
            type:'ALARM_REQUEST_SUCCESS',
            //data: result
        })
    }catch(err){
        yield put({
            type:'ALARM_REQUEST_FAILURE',
            data: err.response.data,
        })
    }
}

function* watchAlarmRequest(){
    yield takeLatest('ALARM_REQUEST', alarmRequest);
}

function storyRequestAPI(data){
    return axios.get(`/feed/story/${data.accountId}`);
}

function* storyRequest(action){
    try{
        //const result = yield call(storyRequestAPI, action.data);
        yield put({
            type:'STORY_REQUEST_SUCCESS',
            data:action.data
        })
    }catch(err){
        yield put({type: 'STORY_REQUEST_FAILURE', data: err});
    }
}

function* watchStoryRequest(){
    yield takeLatest('STORY_REQUEST', storyRequest);
}

function postLikeRequestAPI(data){
    return axios.post(`/feed/${data.accountId}/likePost/${data.postId}`)
}

function* postLikeRequest(action){
    try{
        const result = yield call(postLikeRequestAPI, action.data);
        yield put ({
            type:'LIKE_POST_SUCCESS',
        })
    }catch(err){
        yield put({type: 'LIKE_POST_FAILURE', data: err});
    }
}

function* watchPostLikeRequest(){
    yield takeLatest('LIKE_POST_REQUEST', postLikeRequest);
}

function postLikeCancelRequestAPI(data){
    return axios.delete(`/feed/${data.accountId}/likePost/${data.postId}`)
}

function* postLikeCancelRequest(action){
    try{
        const result = yield call(postLikeCancelRequestAPI, action.data);
        yield put ({
            type:'LIKE_POST_CANCEL_SUCCESS',
        })
    }catch(err){
        yield put({type: 'LIKE_POST_CANCEL_FAILURE', data: err});
    }
}

function* watchPostLikeCancelRequest(){
    yield takeLatest('LIKE_POST_CANCEL_REQUEST', postLikeCancelRequest);
}

function commentLikeRequestAPI(data){
    return axios.post(`/feed/${data.accountId}/likeComment/${data.commentId}`)
}

function* commentLikeRequest(action){
    try{
        const result = yield call(commentLikeRequestAPI, action.data);
        yield put ({
            type:'LIKE_COMMENT_SUCCESS',
        })
    }catch(err){
        yield put({type: 'LIKE_COMMENT_FAILURE', data: err});
    }
}

function* watchCommentLikeRequest(){
    yield takeLatest('LIKE_COMMENT_REQUEST', commentLikeRequest);
}

function commentLikeCancelRequestAPI(data){
    return axios.delete(`/feed/${data.accountId}/likeComment/${data.commentId}`)
}

function* commentLikeCancelRequest(action){
    try{
        //const result = yield call(commentLikeCancelRequestAPI, action.data);
        yield put ({
            type:'LIKE_COMMENT_CANCEL_SUCCESS',
        })
    }catch(err){
        yield put({type: 'LIKE_COMMENT_CANCEL_FAILURE', data: err});
    }
}

function* watchCommentLikeCancelRequest(){
    yield takeLatest('LIKE_COMMENT_CANCEL_REQUEST', commentLikeCancelRequest);
}

function isLikeRequestAPI(data){
    return axios.get(`/feed/${data.accountId}/isLikePost/${data.postId}`);
}

function* isLikeRequset(action){
    try{
        const result = yield call(isLikeRequestAPI, action.data);
        yield put({
            type: 'IS_LIKE_SUCCESS',
            data: result
        })
    }catch(err){
        yield put ({type: 'IS_LIKE_FAILURE'});
    }
}

function* watchIsLikeRequest(){
    yield takeLatest('IS_LIKE_REQUEST', isLikeRequset);
}

export default function* crudSaga(){
    yield all([
        fork(watchAddPost),
        fork(watchRemovePost),
        fork(watchModifyPost),
        fork(watchCheckPost),
        fork(watchAddReply),
        fork(watchAddComment),
        fork(watchRemoveComment),
        fork(watchRemoveReply),
        fork(watchAlarmRequest),
        fork(watchStoryRequest),
        fork(watchPostLikeRequest),
        fork(watchPostLikeCancelRequest),
        fork(watchCommentLikeRequest),
        fork(watchCommentLikeCancelRequest),
        fork(watchIsLikeRequest),
    ])
}