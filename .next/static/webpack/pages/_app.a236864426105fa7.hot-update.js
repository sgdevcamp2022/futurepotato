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

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"initialMainState\": function() { return /* binding */ initialMainState; },\n/* harmony export */   \"mainPageRequestAction\": function() { return /* binding */ mainPageRequestAction; }\n/* harmony export */ });\n/* harmony import */ var immer__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! immer */ \"./node_modules/immer/dist/immer.esm.mjs\");\n\nconst initialMainState = {\n    clearUpload: false,\n    storyList: [],\n    postList: [],\n    limit: null,\n    prePost: null,\n    nextPost: null,\n    newImage: [],\n    isImage: false,\n    detailPage: null,\n    alarmData: null\n};\nconst dummyData = {\n    \"storyList\": [\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 1.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 2.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        }\n    ],\n    \"postList\": [\n        {\n            id: 1,\n            name: \"user1\",\n            \"content\": \"게시글1\",\n            \"createdDate\": \"2023-01-01T12:11:00\",\n            \"modifiedDate\": \"2023-01-01T13:11:00\",\n            likeCount: 12,\n            likesCheck: true,\n            \"commentCount\": 110,\n            \"profileImage\": \"/cover 1.png\",\n            \"commentList\": [\n                {\n                    \"commentWriter\": \"user2\",\n                    \"Image\": \"/cover 3.png\",\n                    \"comment\": \"게시글 댓글1\",\n                    \"likeCount\": 100,\n                    \"commentId\": 1,\n                    \"replyList\": [\n                        {\n                            \"replyWriter\": \"user1\",\n                            \"reply\": \"reply1\",\n                            \"createdDt\": \"\"\n                        },\n                        {\n                            \"replyWriter\": \"user2\",\n                            \"reply\": \"reply2\",\n                            \"image\": \"dsfj.png\",\n                            \"createdDt\": \"\"\n                        }\n                    ]\n                }\n            ],\n            \"imageList\": [\n                {\n                    \"image\": \"./cover 1.png\"\n                },\n                {\n                    \"image\": \"./cover 2.png\"\n                },\n                {\n                    \"image\": \"./cover 3.png\"\n                },\n                {\n                    \"image\": \"./cover 4.png\"\n                }\n            ],\n            \"isMultyImage\": false\n        }\n    ],\n    \"limit\": 10,\n    \"prePost\": 0,\n    \"nextPost\": true\n};\nconst dummyPost = {\n    id: 3,\n    name: \"yusung\",\n    \"content\": \"게시글4\",\n    \"profileImage\": \"/cover 8.png\",\n    \"createdDate\": \"2023-01-01T12:11:00\",\n    \"modifiedDate\": \"2023-01-01T13:11:00\",\n    likeCount: 0,\n    likesCheck: false,\n    \"commentCount\": 0,\n    \"commentList\": [],\n    \"imageList\": [\n        {\n            \"image\": \"./cover 4.png\"\n        },\n        {\n            \"image\": \"./cover 3.png\"\n        },\n        {\n            \"image\": \"./cover 2.png\"\n        }\n    ],\n    \"isMultyImage\": false\n};\nconst mainPageRequestAction = ()=>({\n        type: \"MAIN_PAGE_REQUEST\"\n    });\nconst reducer = function() {\n    let state = arguments.length > 0 && arguments[0] !== void 0 ? arguments[0] : initialMainState, action = arguments.length > 1 ? arguments[1] : void 0;\n    return (0,immer__WEBPACK_IMPORTED_MODULE_0__[\"default\"])(state, (draft)=>{\n        switch(action.type){\n            case \"MAIN_PAGE_REQUEST\":\n                console.log(\"이게뭘까요?\");\n                break;\n            case \"MAIN_PAGE_SUCCESS\":\n                draft.storyList = draft.storyList.concat(dummyData.storyList);\n                draft.postList = draft.postList.concat(dummyData.postList); //dummyData.postList;//draft.postList.concat(dummyData.postList);\n                draft.limit = dummyData.limit;\n                draft.prePost = dummyData.prePost;\n                draft.nextPost = dummyData.nextPost;\n                break;\n            case \"MAIN_PAGE_FAIRLUE\":\n                break;\n            case \"POST_INFO_REQUEST\":\n                draft.detailPage = {};\n                break;\n            case \"POST_INFO_SUCCESS\":\n                draft.postList = action.data;\n                break;\n            case \"POST_INFO_FAILURE\":\n                break;\n            case \"ADD_POST_REQUEST\":\n                break;\n            case \"ADD_POST_SUCCESS\":\n                {\n                    draft.postList.unshift(dummyPost);\n                    draft.clearUpload = true;\n                    draft.newImage = [];\n                    break;\n                }\n            case \"ADD_POST_FAILURE\":\n                draft.clearUpload = true;\n                draft.newImage = [];\n                break;\n            case \"MOD_POST_REQUEST\":\n                break;\n            case \"MOD_POST_SUCCESS\":\n                {\n                    draft.postList.find((v)=>v.name == action.dataId ? v.content = action.data : v.content);\n                    break;\n                }\n            case \"MOD_POST_FAILURE\":\n                break;\n            case \"REMOVE_POST_REQUEST\":\n                console.log(\"포스트를 삭제합니다\");\n                break;\n            case \"REMOVE_POST_SUCCESS\":\n                {\n                    console.log(action.data);\n                    const newPostList = draft.postList.filter((v)=>v.id != action.data);\n                    draft.postList = newPostList;\n                    break;\n                }\n            case \"REMOVE_POST_FAILURE\":\n                break;\n            case \"ADD_COMMENT_REQUEST\":\n                {\n                    console.log(draft);\n                    const post = draft.postList.find((v)=>v.id === action.dataw);\n                    console.log(post);\n                    post.commentList.push({\n                        \"commentWriter\": action.datame.username,\n                        \"Image\": action.datame.profileimage,\n                        \"comment\": action.data,\n                        \"likeCount\": 0,\n                        \"replyList\": [],\n                        commentId: 0\n                    });\n                    break;\n                }\n            case \"ADD_COMMENT_SUCCESS\":\n                break;\n            case \"ADD_COMMENT_FAILURE\":\n                break;\n            case \"DELETE_COMMENT_REQUEST\":\n                break;\n            case \"DELETE_COMMENT_SUCCESS\":\n                {\n                    const post = draft.postList.find((v)=>v.id == action.data.postId);\n                    const index = draft.postList.findIndex((v)=>v.id == action.data.postId);\n                    post.commentList.filter((v)=>v.commentId != action.data.commentId);\n                    draft.postList[index] = post;\n                    break;\n                }\n            case \"DELETE_COMMENT_FAILURE\":\n                break;\n            case \"IMAGE_UPLOAD_REQUEST\":\n                {\n                    draft.newImage.push(action.data);\n                    draft.isImage = true;\n                    break;\n                }\n            case \"ADD_REPLY_REQUEST\":\n                break;\n            case \"ADD_REPLY_SUCCESS\":\n                break;\n            case \"ADD_REPLY_FAILURE\":\n                break;\n            case \"DELETE_REPLY_REQUEST\":\n                break;\n            case \"DELETE_REPLY_SUCCESS\":\n                break;\n            case \"DELETE_REPLY_FAILURE\":\n                break;\n            case \"LOAD_DETAIL_REQUEST\":\n                break;\n            case \"LOAD_DETAIL_SUCCESS\":\n                break;\n            case \"LOAD_DETAIL_FAILURE\":\n                break;\n            case \"ALARM_REQUEST\":\n                break;\n            case \"ALARM_REQUEST_SUCCESS\":\n                break;\n            case \"ALARM_REQUEST_FAILURE\":\n                break;\n            default:\n                break;\n        }\n    });\n};\n/* harmony default export */ __webpack_exports__[\"default\"] = (reducer);\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,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b0JBQ3BCLEtBQU07Z0JBQ1Y7WUFFQSxLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFFVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFFVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFFVixLQUFLO2dCQUNELEtBQU07WUFDVixLQUFLO2dCQUVELEtBQU07WUFDVixLQUFLO2dCQUNELEtBQU07WUFDVjtnQkFDSSxLQUFNO1FBRWQ7SUFDSjtBQUFDO0FBRUQsK0RBQWVXLE9BQU9BLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vcmVkdWNlcnMvbWFpbnBhZ2UuanM/NDhkYiJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgcHJvZHVjZSBmcm9tICdpbW1lcic7XHJcblxyXG5leHBvcnQgY29uc3QgaW5pdGlhbE1haW5TdGF0ZSA9IHtcclxuICAgIGNsZWFyVXBsb2FkIDogZmFsc2UsXHJcbiAgICBzdG9yeUxpc3Q6W10sXHJcbiAgICBwb3N0TGlzdDpbXSxcclxuICAgIGxpbWl0Om51bGwsXHJcbiAgICBwcmVQb3N0Om51bGwsXHJcbiAgICBuZXh0UG9zdDpudWxsLFxyXG4gICAgbmV3SW1hZ2U6W10sXHJcbiAgICBpc0ltYWdlOmZhbHNlLFxyXG4gICAgZGV0YWlsUGFnZTpudWxsLFxyXG4gICAgYWxhcm1EYXRhOm51bGwsXHJcbn1cclxuXHJcbmNvbnN0IGR1bW15RGF0YSA9IHtcclxuICAgIFwic3RvcnlMaXN0XCIgOiBbe1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMS5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAyLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn1dLFxyXG4gICAgXCJwb3N0TGlzdFwiIDogW1xyXG4gICAgICAgIHtpZDoxLCBuYW1lIDogXCJ1c2VyMVwiLCBcImNvbnRlbnRcIjogXCLqsozsi5zquIAxXCIsXCJjcmVhdGVkRGF0ZVwiOiBcIjIwMjMtMDEtMDFUMTI6MTE6MDBcIixcclxuICAgICAgICAgICAgICAgIFwibW9kaWZpZWREYXRlXCI6IFwiMjAyMy0wMS0wMVQxMzoxMTowMFwiLFxyXG4gICAgICAgICAgICAgICAgbGlrZUNvdW50OiAxMixcclxuICAgICAgICAgICAgICAgIGxpa2VzQ2hlY2s6IHRydWUsXHJcbiAgICAgICAgICAgICAgICBcImNvbW1lbnRDb3VudFwiOiAxMTAsXHJcbiAgICAgICAgICAgICAgICBcInByb2ZpbGVJbWFnZVwiIDogJy9jb3ZlciAxLnBuZycsXHJcbiAgICAgICAgICAgICAgICBcImNvbW1lbnRMaXN0XCIgOiBbe1xyXG4gICAgICAgICAgICAgICAgXCJjb21tZW50V3JpdGVyXCI6IFwidXNlcjJcIixcclxuICAgICAgICAgICAgICAgIFwiSW1hZ2VcIjogXCIvY292ZXIgMy5wbmdcIixcclxuICAgICAgICAgICAgICAgIFwiY29tbWVudFwiOiBcIuqyjOyLnOq4gCDrjJPquIAxXCIsXHJcbiAgICAgICAgICAgICAgICBcImxpa2VDb3VudFwiOiAxMDAsXHJcbiAgICAgICAgICAgICAgICAnY29tbWVudElkJyA6IDEsXHJcbiAgICAgICAgICAgICAgICBcInJlcGx5TGlzdFwiOlt7XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBcInJlcGx5V3JpdGVyXCI6IFwidXNlcjFcIiwgXCJyZXBseVwiOlwicmVwbHkxXCIsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBcImNyZWF0ZWREdFwiOlwiXCJcclxuICAgICAgICAgICAgICAgICAgICAgICAgfSxcclxuICAgICAgICAgICAgICAgICAgICAgICAge1xyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgXCJyZXBseVdyaXRlclwiOiBcInVzZXIyXCIsIFwicmVwbHlcIjpcInJlcGx5MlwiLFxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgXCJpbWFnZVwiOlwiZHNmai5wbmdcIixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIFwiY3JlYXRlZER0XCI6XCJcIlxyXG4gICAgICAgICAgICAgICAgICAgICAgICB9LFxyXG4gICAgICAgICAgICAgICAgICAgIF19XHJcbiAgICAgICAgICAgICAgICBdLFxyXG4gICAgICAgICAgICAgICAgXCJpbWFnZUxpc3RcIjpbXHJcbiAgICAgICAgICAgICAgICAgICAge1wiaW1hZ2VcIjogXCIuL2NvdmVyIDEucG5nXCJ9LFxyXG4gICAgICAgICAgICAgICAgICAgIHtcImltYWdlXCI6IFwiLi9jb3ZlciAyLnBuZ1wifSxcclxuICAgICAgICAgICAgICAgICAgICB7XCJpbWFnZVwiOiBcIi4vY292ZXIgMy5wbmdcIn0sXHJcbiAgICAgICAgICAgICAgICAgICAge1wiaW1hZ2VcIjogXCIuL2NvdmVyIDQucG5nXCJ9LFxyXG4gICAgICAgICAgICAgICAgXSxcclxuICAgICAgICAgICAgICAgIFwiaXNNdWx0eUltYWdlXCIgOiBmYWxzZSxcclxuICAgICAgICAgICAgfVxyXG4gICAgXSxcclxuICAgIFwibGltaXRcIiA6IDEwLFxyXG4gICAgXCJwcmVQb3N0XCIgOiAwLFxyXG4gICAgXCJuZXh0UG9zdFwiIDogdHJ1ZSxcclxufVxyXG5cclxuY29uc3QgZHVtbXlQb3N0ID0ge1xyXG4gICAgaWQ6MywgXHJcbiAgICBuYW1lIDogXCJ5dXN1bmdcIiwgXHJcbiAgICBcImNvbnRlbnRcIjogXCLqsozsi5zquIA0XCIsXHJcbiAgICBcInByb2ZpbGVJbWFnZVwiIDogJy9jb3ZlciA4LnBuZycsXHJcbiAgICBcImNyZWF0ZWREYXRlXCI6IFwiMjAyMy0wMS0wMVQxMjoxMTowMFwiLFxyXG4gICAgXCJtb2RpZmllZERhdGVcIjogXCIyMDIzLTAxLTAxVDEzOjExOjAwXCIsXHJcbiAgICBsaWtlQ291bnQ6IDAsXHJcbiAgICBsaWtlc0NoZWNrOiBmYWxzZSxcclxuICAgIFwiY29tbWVudENvdW50XCI6IDAsXHJcbiAgICBcImNvbW1lbnRMaXN0XCIgOiBbXSxcclxuICAgIFwiaW1hZ2VMaXN0XCIgOiBbe1wiaW1hZ2VcIjogXCIuL2NvdmVyIDQucG5nXCJ9LFxyXG4gICAge1wiaW1hZ2VcIjogXCIuL2NvdmVyIDMucG5nXCJ9LHtcImltYWdlXCI6IFwiLi9jb3ZlciAyLnBuZ1wifV0sXHJcbiAgICBcImlzTXVsdHlJbWFnZVwiIDogZmFsc2UsXHJcbn1cclxuXHJcbmV4cG9ydCBjb25zdCBtYWluUGFnZVJlcXVlc3RBY3Rpb24gPSAoKSA9PiAoe1xyXG4gICAgdHlwZTogJ01BSU5fUEFHRV9SRVFVRVNUJyxcclxuICB9KTtcclxuXHJcbmNvbnN0IHJlZHVjZXIgPSAoc3RhdGUgPSBpbml0aWFsTWFpblN0YXRlLCBhY3Rpb24pID0+IHByb2R1Y2Uoc3RhdGUsIChkcmFmdCkgPT4ge1xyXG4gICAgc3dpdGNoKGFjdGlvbi50eXBlKXtcclxuICAgICAgICBjYXNlICdNQUlOX1BBR0VfUkVRVUVTVCcgOiBcclxuICAgICAgICAgICAgY29uc29sZS5sb2coXCLsnbTqsozrrZjquYzsmpQ/XCIpO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdNQUlOX1BBR0VfU1VDQ0VTUycgOlxyXG4gICAgICAgICAgICBkcmFmdC5zdG9yeUxpc3QgPSBkcmFmdC5zdG9yeUxpc3QuY29uY2F0KGR1bW15RGF0YS5zdG9yeUxpc3QpO1xyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdCA9IGRyYWZ0LnBvc3RMaXN0LmNvbmNhdChkdW1teURhdGEucG9zdExpc3QpOy8vZHVtbXlEYXRhLnBvc3RMaXN0Oy8vZHJhZnQucG9zdExpc3QuY29uY2F0KGR1bW15RGF0YS5wb3N0TGlzdCk7XHJcbiAgICAgICAgICAgIGRyYWZ0LmxpbWl0ID0gZHVtbXlEYXRhLmxpbWl0O1xyXG4gICAgICAgICAgICBkcmFmdC5wcmVQb3N0ID0gZHVtbXlEYXRhLnByZVBvc3Q7XHJcbiAgICAgICAgICAgIGRyYWZ0Lm5leHRQb3N0ID0gZHVtbXlEYXRhLm5leHRQb3N0O1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdNQUlOX1BBR0VfRkFJUkxVRScgOlxyXG4gICAgICAgICAgICBicmVhaztcclxuXHJcbiAgICAgICAgY2FzZSAnUE9TVF9JTkZPX1JFUVVFU1QnOlxyXG4gICAgICAgICAgICBkcmFmdC5kZXRhaWxQYWdlID0ge1xyXG4gICAgICAgICAgICAgICAgXHJcbiAgICAgICAgICAgIH1cclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnUE9TVF9JTkZPX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdCA9IGFjdGlvbi5kYXRhO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdQT1NUX0lORk9fRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgXHJcbiAgICAgICAgY2FzZSAnQUREX1BPU1RfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0FERF9QT1NUX1NVQ0NFU1MnOntcclxuICAgICAgICAgICAgZHJhZnQucG9zdExpc3QudW5zaGlmdChkdW1teVBvc3QpO1xyXG4gICAgICAgICAgICBkcmFmdC5jbGVhclVwbG9hZCA9IHRydWU7XHJcbiAgICAgICAgICAgIGRyYWZ0Lm5ld0ltYWdlID0gW107XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIH1cclxuICAgICAgICBjYXNlICdBRERfUE9TVF9GQUlMVVJFJzpcclxuICAgICAgICAgICAgZHJhZnQuY2xlYXJVcGxvYWQgPSB0cnVlO1xyXG4gICAgICAgICAgICBkcmFmdC5uZXdJbWFnZSA9IFtdO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgIFxyXG4gICAgICAgIGNhc2UgJ01PRF9QT1NUX1JFUVVFU1QnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdNT0RfUE9TVF9TVUNDRVNTJzp7XHJcbiAgICAgICAgICAgIGRyYWZ0LnBvc3RMaXN0LmZpbmQoKHYpID0+IHYubmFtZSA9PSBhY3Rpb24uZGF0YUlkID8gdi5jb250ZW50ID0gYWN0aW9uLmRhdGEgOiB2LmNvbnRlbnQpO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICB9XHJcbiAgICAgICAgY2FzZSAnTU9EX1BPU1RfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgXHJcbiAgICAgICAgY2FzZSAnUkVNT1ZFX1BPU1RfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwi7Y+s7Iqk7Yq466W8IOyCreygnO2VqeuLiOuLpFwiKTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnUkVNT1ZFX1BPU1RfU1VDQ0VTUyc6e1xyXG4gICAgICAgICAgICBjb25zb2xlLmxvZyhhY3Rpb24uZGF0YSk7XHJcbiAgICAgICAgICAgIGNvbnN0IG5ld1Bvc3RMaXN0ID0gZHJhZnQucG9zdExpc3QuZmlsdGVyKCh2KSA9PiB2LmlkICE9IGFjdGlvbi5kYXRhKTtcclxuICAgICAgICAgICAgZHJhZnQucG9zdExpc3QgPSBuZXdQb3N0TGlzdDtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgfVxyXG4gICAgICAgIGNhc2UgJ1JFTU9WRV9QT1NUX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuXHJcbiAgICAgICAgY2FzZSAnQUREX0NPTU1FTlRfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIHtcclxuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGRyYWZ0KTtcclxuICAgICAgICAgICAgICAgIGNvbnN0IHBvc3QgPSBkcmFmdC5wb3N0TGlzdC5maW5kKCh2KSA9PiB2LmlkID09PSBhY3Rpb24uZGF0YXcpO1xyXG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2cocG9zdCk7XHJcbiAgICAgICAgICAgICAgICBwb3N0LmNvbW1lbnRMaXN0LnB1c2goe1wiY29tbWVudFdyaXRlclwiIDogYWN0aW9uLmRhdGFtZS51c2VybmFtZSwgXCJJbWFnZVwiIDogYWN0aW9uLmRhdGFtZS5wcm9maWxlaW1hZ2UsIFxyXG4gICAgICAgICAgICAgICAgXCJjb21tZW50XCIgOiBhY3Rpb24uZGF0YSwgXCJsaWtlQ291bnRcIjowLCBcInJlcGx5TGlzdFwiIDogW10sIGNvbW1lbnRJZDowfSk7XHJcbiAgICAgICAgICAgICAgICBicmVhaztcclxuICAgICAgICAgICAgfVxyXG4gICAgICAgIGNhc2UgJ0FERF9DT01NRU5UX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdBRERfQ09NTUVOVF9GQUlMVVJFJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgXHJcbiAgICAgICAgY2FzZSAnREVMRVRFX0NPTU1FTlRfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0RFTEVURV9DT01NRU5UX1NVQ0NFU1MnOntcclxuICAgICAgICAgICAgY29uc3QgcG9zdCA9IGRyYWZ0LnBvc3RMaXN0LmZpbmQoKHYpID0+IHYuaWQgPT0gYWN0aW9uLmRhdGEucG9zdElkKTtcclxuICAgICAgICAgICAgY29uc3QgaW5kZXggPSBkcmFmdC5wb3N0TGlzdC5maW5kSW5kZXgoKHYpID0+IHYuaWQgPT0gYWN0aW9uLmRhdGEucG9zdElkKTtcclxuICAgICAgICAgICAgXHJcbiAgICAgICAgICAgIHBvc3QuY29tbWVudExpc3QuZmlsdGVyKCh2KSA9PiB2LmNvbW1lbnRJZCAhPSBhY3Rpb24uZGF0YS5jb21tZW50SWQpO1xyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdFtpbmRleF0gPSBwb3N0O1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICB9XHJcbiAgICAgICAgY2FzZSAnREVMRVRFX0NPTU1FTlRfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG5cclxuICAgICAgICBjYXNlICdJTUFHRV9VUExPQURfUkVRVUVTVCc6e1xyXG4gICAgICAgICAgICBkcmFmdC5uZXdJbWFnZS5wdXNoKGFjdGlvbi5kYXRhKTtcclxuICAgICAgICAgICAgXHJcbiAgICAgICAgICAgIGRyYWZ0LmlzSW1hZ2UgPSB0cnVlO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICB9XHJcblxyXG4gICAgICAgIGNhc2UgJ0FERF9SRVBMWV9SRVFVRVNUJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnQUREX1JFUExZX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdBRERfUkVQTFlfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG5cclxuICAgICAgICBjYXNlICdERUxFVEVfUkVQTFlfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0RFTEVURV9SRVBMWV9TVUNDRVNTJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnREVMRVRFX1JFUExZX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBcclxuICAgICAgICBjYXNlICdMT0FEX0RFVEFJTF9SRVFVRVNUJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnTE9BRF9ERVRBSUxfU1VDQ0VTUyc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0xPQURfREVUQUlMX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuXHJcbiAgICAgICAgY2FzZSAnQUxBUk1fUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0FMQVJNX1JFUVVFU1RfU1VDQ0VTUyc6XHJcblxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdBTEFSTV9SRVFVRVNUX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBkZWZhdWx0OlxyXG4gICAgICAgICAgICBicmVhaztcclxuXHJcbiAgICB9XHJcbn0pO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgcmVkdWNlcjsiXSwibmFtZXMiOlsicHJvZHVjZSIsImluaXRpYWxNYWluU3RhdGUiLCJjbGVhclVwbG9hZCIsInN0b3J5TGlzdCIsInBvc3RMaXN0IiwibGltaXQiLCJwcmVQb3N0IiwibmV4dFBvc3QiLCJuZXdJbWFnZSIsImlzSW1hZ2UiLCJkZXRhaWxQYWdlIiwiYWxhcm1EYXRhIiwiZHVtbXlEYXRhIiwiaWQiLCJuYW1lIiwibGlrZUNvdW50IiwibGlrZXNDaGVjayIsImR1bW15UG9zdCIsIm1haW5QYWdlUmVxdWVzdEFjdGlvbiIsInR5cGUiLCJyZWR1Y2VyIiwic3RhdGUiLCJhY3Rpb24iLCJkcmFmdCIsImNvbnNvbGUiLCJsb2ciLCJjb25jYXQiLCJkYXRhIiwidW5zaGlmdCIsImZpbmQiLCJ2IiwiZGF0YUlkIiwiY29udGVudCIsIm5ld1Bvc3RMaXN0IiwiZmlsdGVyIiwicG9zdCIsImRhdGF3IiwiY29tbWVudExpc3QiLCJwdXNoIiwiZGF0YW1lIiwidXNlcm5hbWUiLCJwcm9maWxlaW1hZ2UiLCJjb21tZW50SWQiLCJwb3N0SWQiLCJpbmRleCIsImZpbmRJbmRleCJdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./reducers/mainpage.js\n"));

/***/ })

});