import { all , fork, takeLatest, put, call} from "redux-saga/effects";
import axios from "axios";

function mainPageAPI(data) {
    return axios.get(`/feed/${data.accountId}/postList?lastSeenPostId=${data.lastSeenPostId}&pageSize=${data.pageSize}`);
}

function* mainPage(action){
    try{
        //const result = yield call(mainPageAPI, action.data);
        //console.log(result);
        yield put({
            type:'MAIN_PAGE_SUCCESS',
            //data:result,
        });
    } catch (err){
        console.log(err);
        yield put({
            type:'MAIN_PAGE_FAILURE',
            data: err,
        })
    }
}

function* watchMainPage(){
    yield takeLatest('MAIN_PAGE_REQUEST', mainPage);
}

export default function* pageSaga(){
    yield all([
        fork(watchMainPage),
    ])
}