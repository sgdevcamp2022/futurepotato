import { all , fork, takeLatest, put} from "redux-saga/effects";

function mainPageAPI() {
    return axios.get('/');
}

function* mainPage(){
    try{
        //const result = yield call(mainPageAPI);
        yield put({
            type:'LOG_IN_SUCCESS',
            data:result.data,
        });
    } catch (err){
        yield put({
            type:'LOG_IN_FAILURE',
            data: err.response.data,
        })
    }
}

function* watchMainPage(){
    yield takeLatest('MAIN_PAGE_REQUEST', mainPage);
}

export default function* userSaga(){
    yield all([
        fork(watchMainPage),
    ])
}