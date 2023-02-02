import { all , fork, takeLatest, put, call} from "redux-saga/effects";

function mainPageAPI() {
    return axios.get('/');
}

function* mainPage(){
    try{
        //const result = yield call(mainPageAPI);
        yield put({
            type:'MAIN_PAGE_SUCCESS',
            //data:result.data,
        });
    } catch (err){
        yield put({
            type:'MAIN_PAGE_FAILURE',
            data: err.response.data,
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