"use strict";
/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
self["webpackHotUpdate_N_E"]("pages/_app",{

/***/ "./reducers/mainpage.js":
/*!******************************!*\
  !*** ./reducers/mainpage.js ***!
  \******************************/
/***/ (function(module, __webpack_exports__, __webpack_require__) {

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"initialMainState\": function() { return /* binding */ initialMainState; },\n/* harmony export */   \"mainPageRequestAction\": function() { return /* binding */ mainPageRequestAction; }\n/* harmony export */ });\n/* harmony import */ var immer__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! immer */ \"./node_modules/immer/dist/immer.esm.mjs\");\n\nconst initialMainState = {\n    clearUpload: false,\n    storyList: [],\n    postList: [],\n    limit: null,\n    prePost: null,\n    nextPost: null,\n    newImage: [],\n    isImage: false,\n    detailPage: null\n};\nconst dummyData = {\n    \"storyList\": [\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 1.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 2.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        }\n    ],\n    \"postList\": [\n        {\n            id: 1,\n            name: \"user1\",\n            \"content\": \"게시글1\",\n            \"createdDate\": \"2023-01-01T12:11:00\",\n            \"modifiedDate\": \"2023-01-01T13:11:00\",\n            likeCount: 12,\n            likesCheck: true,\n            \"commentCount\": 110,\n            \"profileImage\": \"/cover 1.png\",\n            \"commentList\": [\n                {\n                    \"commentWriter\": \"user2\",\n                    \"Image\": \"/cover 3.png\",\n                    \"comment\": \"게시글 댓글1\",\n                    \"likeCount\": 100,\n                    \"commentId\": 1,\n                    \"replyList\": [\n                        {\n                            \"replyWriter\": \"user1\",\n                            \"reply\": \"reply1\",\n                            \"createdDt\": \"\"\n                        },\n                        {\n                            \"replyWriter\": \"user2\",\n                            \"reply\": \"reply2\",\n                            \"image\": \"dsfj.png\",\n                            \"createdDt\": \"\"\n                        }\n                    ]\n                }\n            ],\n            \"imageList\": [\n                {\n                    \"image\": \"./cover 1.png\"\n                },\n                {\n                    \"image\": \"./cover 2.png\"\n                },\n                {\n                    \"image\": \"./cover 3.png\"\n                },\n                {\n                    \"image\": \"./cover 4.png\"\n                }\n            ],\n            \"isMultyImage\": false\n        }\n    ],\n    \"limit\": 10,\n    \"prePost\": 0,\n    \"nextPost\": true\n};\nconst dummyPost = {\n    id: 3,\n    name: \"yusung\",\n    \"content\": \"게시글4\",\n    \"profileImage\": \"/cover 8.png\",\n    \"createdDate\": \"2023-01-01T12:11:00\",\n    \"modifiedDate\": \"2023-01-01T13:11:00\",\n    likeCount: 0,\n    likesCheck: false,\n    \"commentCount\": 0,\n    \"commentList\": [],\n    \"imageList\": [\n        {\n            \"image\": \"./cover 4.png\"\n        },\n        {\n            \"image\": \"./cover 3.png\"\n        },\n        {\n            \"image\": \"./cover 2.png\"\n        }\n    ],\n    \"isMultyImage\": false\n};\nconst mainPageRequestAction = ()=>({\n        type: \"MAIN_PAGE_REQUEST\"\n    });\nconst reducer = function() {\n    let state = arguments.length > 0 && arguments[0] !== void 0 ? arguments[0] : initialMainState, action = arguments.length > 1 ? arguments[1] : void 0;\n    return (0,immer__WEBPACK_IMPORTED_MODULE_0__[\"default\"])(state, (draft)=>{\n        switch(action.type){\n            case \"MAIN_PAGE_REQUEST\":\n                console.log(\"이게뭘까요?\");\n                break;\n            case \"MAIN_PAGE_SUCCESS\":\n                draft.storyList = draft.storyList.concat(dummyData.storyList);\n                draft.postList = draft.postList.concat(dummyData.postList); //dummyData.postList;//draft.postList.concat(dummyData.postList);\n                draft.limit = dummyData.limit;\n                draft.prePost = dummyData.prePost;\n                draft.nextPost = dummyData.nextPost;\n                break;\n            case \"MAIN_PAGE_FAIRLUE\":\n                break;\n            case \"POST_INFO_REQUEST\":\n                draft.detailPage = {};\n                break;\n            case \"POST_INFO_SUCCESS\":\n                draft.postList = action.data;\n                break;\n            case \"POST_INFO_FAILURE\":\n                break;\n            case \"ADD_POST_REQUEST\":\n                break;\n            case \"ADD_POST_SUCCESS\":\n                {\n                    draft.postList.unshift(dummyPost);\n                    draft.clearUpload = true;\n                    draft.newImage = [];\n                    break;\n                }\n            case \"ADD_POST_FAILURE\":\n                draft.clearUpload = true;\n                draft.newImage = [];\n                break;\n            case \"MOD_POST_REQUEST\":\n                break;\n            case \"MOD_POST_SUCCESS\":\n                {\n                    draft.postList.find((v)=>v.name == action.dataId ? v.content = action.data : v.content);\n                    break;\n                }\n            case \"MOD_POST_FAILURE\":\n                break;\n            case \"REMOVE_POST_REQUEST\":\n                console.log(\"포스트를 삭제합니다\");\n                break;\n            case \"REMOVE_POST_SUCCESS\":\n                {\n                    console.log(action.data);\n                    const newPostList = draft.postList.filter((v)=>v.id != action.data);\n                    draft.postList = newPostList;\n                    break;\n                }\n            case \"REMOVE_POST_FAILURE\":\n                break;\n            case \"ADD_COMMENT_REQUEST\":\n                {\n                    console.log(draft);\n                    const post = draft.postList.find((v)=>v.id === action.dataw);\n                    console.log(post);\n                    post.commentList.push({\n                        \"commentWriter\": action.datame.username,\n                        \"Image\": action.datame.profileimage,\n                        \"comment\": action.data,\n                        \"likeCount\": 0,\n                        \"replyList\": [],\n                        commentId: 0\n                    });\n                    break;\n                }\n            case \"ADD_COMMENT_SUCCESS\":\n                break;\n            case \"ADD_COMMENT_FAILURE\":\n                break;\n            case \"DELETE_COMMENT_REQUEST\":\n                break;\n            case \"DELETE_COMMENT_SUCCESS\":\n                {\n                    const post = draft.postList.find((v)=>v.id == action.data.postId);\n                    const index = draft.postList.findIndex((v)=>v.id == action.data.postId);\n                    post.commentList.filter((v)=>v.commentId != action.data.commentId);\n                    draft.postList[index] = post;\n                    break;\n                }\n            case \"DELETE_COMMENT_FAILURE\":\n                break;\n            case \"IMAGE_UPLOAD_REQUEST\":\n                {\n                    draft.newImage.push(action.data);\n                    draft.isImage = true;\n                    break;\n                }\n            case \"ADD_REPLY_REQUEST\":\n                break;\n            case \"ADD_REPLY_SUCCESS\":\n                break;\n            case \"ADD_REPLY_FAILURE\":\n                break;\n            case \"DELETE_REPLY_REQUEST\":\n                break;\n            case \"DELETE_REPLY_SUCCESS\":\n                break;\n            case \"DELETE_REPLY_FAILURE\":\n                break;\n            case \"LOAD_DETAIL_REQUEST\":\n                break;\n            case \"LOAD_DETAIL_SUCCESS\":\n                break;\n            case \"LOAD_DETAIL_FAILURE\":\n                break;\n            default:\n                break;\n        }\n    });\n};\n/* harmony default export */ __webpack_exports__[\"default\"] = (reducer);\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,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WUFFQSxLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFFVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFFVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVjtnQkFDSSxLQUFNO1FBRWQ7SUFDSjtBQUFDO0FBRUQsK0RBQWVVLE9BQU9BLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vcmVkdWNlcnMvbWFpbnBhZ2UuanM/NDhkYiJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgcHJvZHVjZSBmcm9tICdpbW1lcic7XHJcblxyXG5leHBvcnQgY29uc3QgaW5pdGlhbE1haW5TdGF0ZSA9IHtcclxuICAgIGNsZWFyVXBsb2FkIDogZmFsc2UsXHJcbiAgICBzdG9yeUxpc3Q6W10sXHJcbiAgICBwb3N0TGlzdDpbXSxcclxuICAgIGxpbWl0Om51bGwsXHJcbiAgICBwcmVQb3N0Om51bGwsXHJcbiAgICBuZXh0UG9zdDpudWxsLFxyXG4gICAgbmV3SW1hZ2U6W10sXHJcbiAgICBpc0ltYWdlOmZhbHNlLFxyXG4gICAgZGV0YWlsUGFnZTpudWxsLFxyXG5cclxufVxyXG5cclxuY29uc3QgZHVtbXlEYXRhID0ge1xyXG4gICAgXCJzdG9yeUxpc3RcIiA6IFt7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAxLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDIucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifV0sXHJcbiAgICBcInBvc3RMaXN0XCIgOiBbXHJcbiAgICAgICAge2lkOjEsIG5hbWUgOiBcInVzZXIxXCIsIFwiY29udGVudFwiOiBcIuqyjOyLnOq4gDFcIixcImNyZWF0ZWREYXRlXCI6IFwiMjAyMy0wMS0wMVQxMjoxMTowMFwiLFxyXG4gICAgICAgICAgICAgICAgXCJtb2RpZmllZERhdGVcIjogXCIyMDIzLTAxLTAxVDEzOjExOjAwXCIsXHJcbiAgICAgICAgICAgICAgICBsaWtlQ291bnQ6IDEyLFxyXG4gICAgICAgICAgICAgICAgbGlrZXNDaGVjazogdHJ1ZSxcclxuICAgICAgICAgICAgICAgIFwiY29tbWVudENvdW50XCI6IDExMCxcclxuICAgICAgICAgICAgICAgIFwicHJvZmlsZUltYWdlXCIgOiAnL2NvdmVyIDEucG5nJyxcclxuICAgICAgICAgICAgICAgIFwiY29tbWVudExpc3RcIiA6IFt7XHJcbiAgICAgICAgICAgICAgICBcImNvbW1lbnRXcml0ZXJcIjogXCJ1c2VyMlwiLFxyXG4gICAgICAgICAgICAgICAgXCJJbWFnZVwiOiBcIi9jb3ZlciAzLnBuZ1wiLFxyXG4gICAgICAgICAgICAgICAgXCJjb21tZW50XCI6IFwi6rKM7Iuc6riAIOuMk+q4gDFcIixcclxuICAgICAgICAgICAgICAgIFwibGlrZUNvdW50XCI6IDEwMCxcclxuICAgICAgICAgICAgICAgICdjb21tZW50SWQnIDogMSxcclxuICAgICAgICAgICAgICAgIFwicmVwbHlMaXN0XCI6W3tcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIFwicmVwbHlXcml0ZXJcIjogXCJ1c2VyMVwiLCBcInJlcGx5XCI6XCJyZXBseTFcIixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIFwiY3JlYXRlZER0XCI6XCJcIlxyXG4gICAgICAgICAgICAgICAgICAgICAgICB9LFxyXG4gICAgICAgICAgICAgICAgICAgICAgICB7XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBcInJlcGx5V3JpdGVyXCI6IFwidXNlcjJcIiwgXCJyZXBseVwiOlwicmVwbHkyXCIsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBcImltYWdlXCI6XCJkc2ZqLnBuZ1wiLFxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgXCJjcmVhdGVkRHRcIjpcIlwiXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIH0sXHJcbiAgICAgICAgICAgICAgICAgICAgXX1cclxuICAgICAgICAgICAgICAgIF0sXHJcbiAgICAgICAgICAgICAgICBcImltYWdlTGlzdFwiOltcclxuICAgICAgICAgICAgICAgICAgICB7XCJpbWFnZVwiOiBcIi4vY292ZXIgMS5wbmdcIn0sXHJcbiAgICAgICAgICAgICAgICAgICAge1wiaW1hZ2VcIjogXCIuL2NvdmVyIDIucG5nXCJ9LFxyXG4gICAgICAgICAgICAgICAgICAgIHtcImltYWdlXCI6IFwiLi9jb3ZlciAzLnBuZ1wifSxcclxuICAgICAgICAgICAgICAgICAgICB7XCJpbWFnZVwiOiBcIi4vY292ZXIgNC5wbmdcIn0sXHJcbiAgICAgICAgICAgICAgICBdLFxyXG4gICAgICAgICAgICAgICAgXCJpc011bHR5SW1hZ2VcIiA6IGZhbHNlLFxyXG4gICAgICAgICAgICB9XHJcbiAgICBdLFxyXG4gICAgXCJsaW1pdFwiIDogMTAsXHJcbiAgICBcInByZVBvc3RcIiA6IDAsXHJcbiAgICBcIm5leHRQb3N0XCIgOiB0cnVlLFxyXG59XHJcblxyXG5jb25zdCBkdW1teVBvc3QgPSB7XHJcbiAgICBpZDozLCBcclxuICAgIG5hbWUgOiBcInl1c3VuZ1wiLCBcclxuICAgIFwiY29udGVudFwiOiBcIuqyjOyLnOq4gDRcIixcclxuICAgIFwicHJvZmlsZUltYWdlXCIgOiAnL2NvdmVyIDgucG5nJyxcclxuICAgIFwiY3JlYXRlZERhdGVcIjogXCIyMDIzLTAxLTAxVDEyOjExOjAwXCIsXHJcbiAgICBcIm1vZGlmaWVkRGF0ZVwiOiBcIjIwMjMtMDEtMDFUMTM6MTE6MDBcIixcclxuICAgIGxpa2VDb3VudDogMCxcclxuICAgIGxpa2VzQ2hlY2s6IGZhbHNlLFxyXG4gICAgXCJjb21tZW50Q291bnRcIjogMCxcclxuICAgIFwiY29tbWVudExpc3RcIiA6IFtdLFxyXG4gICAgXCJpbWFnZUxpc3RcIiA6IFt7XCJpbWFnZVwiOiBcIi4vY292ZXIgNC5wbmdcIn0sXHJcbiAgICB7XCJpbWFnZVwiOiBcIi4vY292ZXIgMy5wbmdcIn0se1wiaW1hZ2VcIjogXCIuL2NvdmVyIDIucG5nXCJ9XSxcclxuICAgIFwiaXNNdWx0eUltYWdlXCIgOiBmYWxzZSxcclxufVxyXG5cclxuZXhwb3J0IGNvbnN0IG1haW5QYWdlUmVxdWVzdEFjdGlvbiA9ICgpID0+ICh7XHJcbiAgICB0eXBlOiAnTUFJTl9QQUdFX1JFUVVFU1QnLFxyXG4gIH0pO1xyXG5cclxuY29uc3QgcmVkdWNlciA9IChzdGF0ZSA9IGluaXRpYWxNYWluU3RhdGUsIGFjdGlvbikgPT4gcHJvZHVjZShzdGF0ZSwgKGRyYWZ0KSA9PiB7XHJcbiAgICBzd2l0Y2goYWN0aW9uLnR5cGUpe1xyXG4gICAgICAgIGNhc2UgJ01BSU5fUEFHRV9SRVFVRVNUJyA6IFxyXG4gICAgICAgICAgICBjb25zb2xlLmxvZyhcIuydtOqyjOutmOq5jOyalD9cIik7XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ01BSU5fUEFHRV9TVUNDRVNTJyA6XHJcbiAgICAgICAgICAgIGRyYWZ0LnN0b3J5TGlzdCA9IGRyYWZ0LnN0b3J5TGlzdC5jb25jYXQoZHVtbXlEYXRhLnN0b3J5TGlzdCk7XHJcbiAgICAgICAgICAgIGRyYWZ0LnBvc3RMaXN0ID0gZHJhZnQucG9zdExpc3QuY29uY2F0KGR1bW15RGF0YS5wb3N0TGlzdCk7Ly9kdW1teURhdGEucG9zdExpc3Q7Ly9kcmFmdC5wb3N0TGlzdC5jb25jYXQoZHVtbXlEYXRhLnBvc3RMaXN0KTtcclxuICAgICAgICAgICAgZHJhZnQubGltaXQgPSBkdW1teURhdGEubGltaXQ7XHJcbiAgICAgICAgICAgIGRyYWZ0LnByZVBvc3QgPSBkdW1teURhdGEucHJlUG9zdDtcclxuICAgICAgICAgICAgZHJhZnQubmV4dFBvc3QgPSBkdW1teURhdGEubmV4dFBvc3Q7XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ01BSU5fUEFHRV9GQUlSTFVFJyA6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG5cclxuICAgICAgICBjYXNlICdQT1NUX0lORk9fUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGRyYWZ0LmRldGFpbFBhZ2UgPSB7XHJcbiAgICAgICAgICAgICAgICBcclxuICAgICAgICAgICAgfVxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdQT1NUX0lORk9fU1VDQ0VTUyc6XHJcbiAgICAgICAgICAgIGRyYWZ0LnBvc3RMaXN0ID0gYWN0aW9uLmRhdGE7XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ1BPU1RfSU5GT19GQUlMVVJFJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICBcclxuICAgICAgICBjYXNlICdBRERfUE9TVF9SRVFVRVNUJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnQUREX1BPU1RfU1VDQ0VTUyc6e1xyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdC51bnNoaWZ0KGR1bW15UG9zdCk7XHJcbiAgICAgICAgICAgIGRyYWZ0LmNsZWFyVXBsb2FkID0gdHJ1ZTtcclxuICAgICAgICAgICAgZHJhZnQubmV3SW1hZ2UgPSBbXTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgfVxyXG4gICAgICAgIGNhc2UgJ0FERF9QT1NUX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBkcmFmdC5jbGVhclVwbG9hZCA9IHRydWU7XHJcbiAgICAgICAgICAgIGRyYWZ0Lm5ld0ltYWdlID0gW107XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgXHJcbiAgICAgICAgY2FzZSAnTU9EX1BPU1RfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ01PRF9QT1NUX1NVQ0NFU1MnOntcclxuICAgICAgICAgICAgZHJhZnQucG9zdExpc3QuZmluZCgodikgPT4gdi5uYW1lID09IGFjdGlvbi5kYXRhSWQgPyB2LmNvbnRlbnQgPSBhY3Rpb24uZGF0YSA6IHYuY29udGVudCk7XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIH1cclxuICAgICAgICBjYXNlICdNT0RfUE9TVF9GQUlMVVJFJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICBcclxuICAgICAgICBjYXNlICdSRU1PVkVfUE9TVF9SRVFVRVNUJzpcclxuICAgICAgICAgICAgY29uc29sZS5sb2coXCLtj6zsiqTtirjrpbwg7IKt7KCc7ZWp64uI64ukXCIpO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdSRU1PVkVfUE9TVF9TVUNDRVNTJzp7XHJcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGFjdGlvbi5kYXRhKTtcclxuICAgICAgICAgICAgY29uc3QgbmV3UG9zdExpc3QgPSBkcmFmdC5wb3N0TGlzdC5maWx0ZXIoKHYpID0+IHYuaWQgIT0gYWN0aW9uLmRhdGEpO1xyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdCA9IG5ld1Bvc3RMaXN0O1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICB9XHJcbiAgICAgICAgY2FzZSAnUkVNT1ZFX1BPU1RfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG5cclxuICAgICAgICBjYXNlICdBRERfQ09NTUVOVF9SRVFVRVNUJzpcclxuICAgICAgICAgICAge1xyXG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coZHJhZnQpO1xyXG4gICAgICAgICAgICAgICAgY29uc3QgcG9zdCA9IGRyYWZ0LnBvc3RMaXN0LmZpbmQoKHYpID0+IHYuaWQgPT09IGFjdGlvbi5kYXRhdyk7XHJcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhwb3N0KTtcclxuICAgICAgICAgICAgICAgIHBvc3QuY29tbWVudExpc3QucHVzaCh7XCJjb21tZW50V3JpdGVyXCIgOiBhY3Rpb24uZGF0YW1lLnVzZXJuYW1lLCBcIkltYWdlXCIgOiBhY3Rpb24uZGF0YW1lLnByb2ZpbGVpbWFnZSwgXHJcbiAgICAgICAgICAgICAgICBcImNvbW1lbnRcIiA6IGFjdGlvbi5kYXRhLCBcImxpa2VDb3VudFwiOjAsIFwicmVwbHlMaXN0XCIgOiBbXSwgY29tbWVudElkOjB9KTtcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICB9XHJcbiAgICAgICAgY2FzZSAnQUREX0NPTU1FTlRfU1VDQ0VTUyc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0FERF9DT01NRU5UX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBcclxuICAgICAgICBjYXNlICdERUxFVEVfQ09NTUVOVF9SRVFVRVNUJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnREVMRVRFX0NPTU1FTlRfU1VDQ0VTUyc6e1xyXG4gICAgICAgICAgICBjb25zdCBwb3N0ID0gZHJhZnQucG9zdExpc3QuZmluZCgodikgPT4gdi5pZCA9PSBhY3Rpb24uZGF0YS5wb3N0SWQpO1xyXG4gICAgICAgICAgICBjb25zdCBpbmRleCA9IGRyYWZ0LnBvc3RMaXN0LmZpbmRJbmRleCgodikgPT4gdi5pZCA9PSBhY3Rpb24uZGF0YS5wb3N0SWQpO1xyXG4gICAgICAgICAgICBcclxuICAgICAgICAgICAgcG9zdC5jb21tZW50TGlzdC5maWx0ZXIoKHYpID0+IHYuY29tbWVudElkICE9IGFjdGlvbi5kYXRhLmNvbW1lbnRJZCk7XHJcbiAgICAgICAgICAgIGRyYWZ0LnBvc3RMaXN0W2luZGV4XSA9IHBvc3Q7XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIH1cclxuICAgICAgICBjYXNlICdERUxFVEVfQ09NTUVOVF9GQUlMVVJFJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcblxyXG4gICAgICAgIGNhc2UgJ0lNQUdFX1VQTE9BRF9SRVFVRVNUJzp7XHJcbiAgICAgICAgICAgIGRyYWZ0Lm5ld0ltYWdlLnB1c2goYWN0aW9uLmRhdGEpO1xyXG4gICAgICAgICAgICBkcmFmdC5pc0ltYWdlID0gdHJ1ZTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBjYXNlICdBRERfUkVQTFlfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0FERF9SRVBMWV9TVUNDRVNTJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnQUREX1JFUExZX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuXHJcbiAgICAgICAgY2FzZSAnREVMRVRFX1JFUExZX1JFUVVFU1QnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdERUxFVEVfUkVQTFlfU1VDQ0VTUyc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0RFTEVURV9SRVBMWV9GQUlMVVJFJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgXHJcbiAgICAgICAgY2FzZSAnTE9BRF9ERVRBSUxfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0xPQURfREVUQUlMX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdMT0FEX0RFVEFJTF9GQUlMVVJFJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgZGVmYXVsdDpcclxuICAgICAgICAgICAgYnJlYWs7XHJcblxyXG4gICAgfVxyXG59KTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IHJlZHVjZXI7Il0sIm5hbWVzIjpbInByb2R1Y2UiLCJpbml0aWFsTWFpblN0YXRlIiwiY2xlYXJVcGxvYWQiLCJzdG9yeUxpc3QiLCJwb3N0TGlzdCIsImxpbWl0IiwicHJlUG9zdCIsIm5leHRQb3N0IiwibmV3SW1hZ2UiLCJpc0ltYWdlIiwiZGV0YWlsUGFnZSIsImR1bW15RGF0YSIsImlkIiwibmFtZSIsImxpa2VDb3VudCIsImxpa2VzQ2hlY2siLCJkdW1teVBvc3QiLCJtYWluUGFnZVJlcXVlc3RBY3Rpb24iLCJ0eXBlIiwicmVkdWNlciIsInN0YXRlIiwiYWN0aW9uIiwiZHJhZnQiLCJjb25zb2xlIiwibG9nIiwiY29uY2F0IiwiZGF0YSIsInVuc2hpZnQiLCJmaW5kIiwidiIsImRhdGFJZCIsImNvbnRlbnQiLCJuZXdQb3N0TGlzdCIsImZpbHRlciIsInBvc3QiLCJkYXRhdyIsImNvbW1lbnRMaXN0IiwicHVzaCIsImRhdGFtZSIsInVzZXJuYW1lIiwicHJvZmlsZWltYWdlIiwiY29tbWVudElkIiwicG9zdElkIiwiaW5kZXgiLCJmaW5kSW5kZXgiXSwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./reducers/mainpage.js\n"));

/***/ })

});