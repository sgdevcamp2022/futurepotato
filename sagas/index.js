import {all, call, fork, put, takeLatest} from 'redux-saga/effects'
import userSaga from './user'
import pageSaga from './mainpage'
import crudpage from './post'

export default function* rootSaga() {
    yield all([
        fork(userSaga),
        fork(pageSaga),
        fork(crudpage),
    ])
}