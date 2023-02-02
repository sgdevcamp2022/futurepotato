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

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"initialMainState\": function() { return /* binding */ initialMainState; },\n/* harmony export */   \"mainPageRequestAction\": function() { return /* binding */ mainPageRequestAction; }\n/* harmony export */ });\n/* harmony import */ var immer__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! immer */ \"./node_modules/immer/dist/immer.esm.mjs\");\n\nconst initialMainState = {\n    clearUpload: false,\n    storyList: [],\n    postList: [],\n    limit: null,\n    prePost: null,\n    nextPost: null,\n    newImage: [],\n    isImage: false\n};\nconst dummyData = {\n    \"storyList\": [\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 1.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 2.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        },\n        {\n            \"name\": \"user1\",\n            \"profileImage\": \"/cover 3.png\"\n        }\n    ],\n    \"postList\": [\n        {\n            id: 1,\n            name: \"user1\",\n            \"content\": \"게시글1\",\n            \"createdDate\": \"2023-01-01T12:11:00\",\n            \"modifiedDate\": \"2023-01-01T13:11:00\",\n            likeCount: 12,\n            likesCheck: true,\n            \"commentCount\": 110,\n            \"commentList\": [\n                {\n                    \"commentWriter\": \"user2\",\n                    \"Image\": \"/cover 3.png\",\n                    \"comment\": \"게시글 댓글1\",\n                    \"likeCount\": 100\n                }\n            ],\n            \"imageList\": [\n                {\n                    \"image\": \"./cover 1.png\"\n                },\n                {\n                    \"image\": \"./cover 2.png\"\n                },\n                {\n                    \"image\": \"./cover 3.png\"\n                },\n                {\n                    \"image\": \"./cover 4.png\"\n                }\n            ],\n            \"isMultyImage\": false\n        }\n    ],\n    \"limit\": 10,\n    \"prePost\": 0,\n    \"nextPost\": true\n};\nconst dummyPost = {\n    id: 3,\n    name: \"user3\",\n    \"content\": \"게시글4\",\n    \"createdDate\": \"2023-01-01T12:11:00\",\n    \"modifiedDate\": \"2023-01-01T13:11:00\",\n    likeCount: 0,\n    likesCheck: false,\n    \"commentCount\": 0,\n    \"commentList\": [],\n    \"imageList\": [\n        {\n            \"image\": \"./cover 4.png\"\n        },\n        {\n            \"image\": \"./cover 3.png\"\n        },\n        {\n            \"image\": \"./cover 2.png\"\n        }\n    ],\n    \"isMultyImage\": false\n};\nconst mainPageRequestAction = ()=>({\n        type: \"MAIN_PAGE_REQUEST\"\n    });\nconst reducer = function() {\n    let state = arguments.length > 0 && arguments[0] !== void 0 ? arguments[0] : initialMainState, action = arguments.length > 1 ? arguments[1] : void 0;\n    return (0,immer__WEBPACK_IMPORTED_MODULE_0__[\"default\"])(state, (draft)=>{\n        switch(action.type){\n            case \"MAIN_PAGE_REQUEST\":\n                break;\n            case \"MAIN_PAGE_SUCCESS\":\n                console.log(\"tjdrhd\");\n                draft.storyList = draft.storyList.concat(dummyData.storyList);\n                draft.postList = draft.postList.concat(dummyData.postList);\n                draft.limit = dummyData.limit;\n                draft.prePost = dummyData.prePost;\n                draft.nextPost = dummyData.nextPost;\n                break;\n            case \"MAIN_PAGE_FAIRLUE\":\n                break;\n            case \"POST_INFO_REQUEST\":\n                break;\n            case \"POST_INFO_SUCCESS\":\n                draft.postList = action.data;\n                break;\n            case \"POST_INFO_FAILURE\":\n                break;\n            case \"ADD_POST_REQUEST\":\n                break;\n            case \"ADD_POST_SUCCESS\":\n                draft.postList.unshift(dummyPost);\n                draft.clearUpload = true;\n                draft.newImage = [];\n                break;\n            case \"ADD_POST_FAILURE\":\n                draft.clearUpload = true;\n                draft.newImage = [];\n                break;\n            case \"MOD_POST_REQUEST\":\n                break;\n            case \"MOD_POST_SUCCESS\":\n                break;\n            case \"MOD_POST_FAILURE\":\n                break;\n            case \"REMOVE_POST_REQUEST\":\n                break;\n            case \"REMOVE_POST_SUCCESS\":\n                break;\n            case \"REMOVE_POST_FAILURE\":\n                break;\n            case \"ADD_COMMENT_REQUEST\":\n                {\n                    console.log(draft);\n                    const post = draft.postList.find((v)=>v.id === action.dataw);\n                    console.log(post);\n                    post.commentList.push({\n                        \"commentWriter\": action.datame.username,\n                        \"Image\": action.datame.profileimage,\n                        \"comment\": action.data,\n                        \"likeCount\": 0\n                    });\n                    break;\n                }\n            case \"IMAGE_UPLOAD_REQUEST\":\n                {\n                    console.log(action.data.name);\n                    draft.newImage.push(action.data.get(\"image\").name);\n                    draft.isImage = true;\n                    break;\n                }\n            default:\n                break;\n        }\n    });\n};\n/* harmony default export */ __webpack_exports__[\"default\"] = (reducer);\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,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YWNrOi8vX05fRS8uL3JlZHVjZXJzL21haW5wYWdlLmpzPzQ4ZGIiXSwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHByb2R1Y2UgZnJvbSAnaW1tZXInO1xyXG5cclxuZXhwb3J0IGNvbnN0IGluaXRpYWxNYWluU3RhdGUgPSB7XHJcbiAgICBjbGVhclVwbG9hZCA6IGZhbHNlLFxyXG4gICAgc3RvcnlMaXN0OltdLFxyXG4gICAgcG9zdExpc3Q6W10sXHJcbiAgICBsaW1pdDpudWxsLFxyXG4gICAgcHJlUG9zdDpudWxsLFxyXG4gICAgbmV4dFBvc3Q6bnVsbCxcclxuICAgIG5ld0ltYWdlOltdLFxyXG4gICAgaXNJbWFnZTpmYWxzZSxcclxufVxyXG5cclxuY29uc3QgZHVtbXlEYXRhID0ge1xyXG4gICAgXCJzdG9yeUxpc3RcIiA6IFt7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAxLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDIucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifSxcclxuICAgIHtcIm5hbWVcIiA6IFwidXNlcjFcIiwgXCJwcm9maWxlSW1hZ2VcIiA6IFwiL2NvdmVyIDMucG5nXCJ9LFxyXG4gICAge1wibmFtZVwiIDogXCJ1c2VyMVwiLCBcInByb2ZpbGVJbWFnZVwiIDogXCIvY292ZXIgMy5wbmdcIn0sXHJcbiAgICB7XCJuYW1lXCIgOiBcInVzZXIxXCIsIFwicHJvZmlsZUltYWdlXCIgOiBcIi9jb3ZlciAzLnBuZ1wifV0sXHJcbiAgICBcInBvc3RMaXN0XCIgOiBbXHJcbiAgICAgICAge2lkOjEsIG5hbWUgOiBcInVzZXIxXCIsIFwiY29udGVudFwiOiBcIuqyjOyLnOq4gDFcIixcImNyZWF0ZWREYXRlXCI6IFwiMjAyMy0wMS0wMVQxMjoxMTowMFwiLFxyXG4gICAgICAgICAgICAgICAgXCJtb2RpZmllZERhdGVcIjogXCIyMDIzLTAxLTAxVDEzOjExOjAwXCIsXHJcbiAgICAgICAgICAgICAgICBsaWtlQ291bnQ6IDEyLFxyXG4gICAgICAgICAgICAgICAgbGlrZXNDaGVjazogdHJ1ZSxcclxuICAgICAgICAgICAgICAgIFwiY29tbWVudENvdW50XCI6IDExMCxcclxuICAgICAgICAgICAgICAgIFwiY29tbWVudExpc3RcIiA6IFt7XCJjb21tZW50V3JpdGVyXCI6IFwidXNlcjJcIixcclxuICAgICAgICAgICAgICAgIFwiSW1hZ2VcIjogXCIvY292ZXIgMy5wbmdcIixcclxuICAgICAgICAgICAgICAgIFwiY29tbWVudFwiOiBcIuqyjOyLnOq4gCDrjJPquIAxXCIsXHJcbiAgICAgICAgICAgICAgICBcImxpa2VDb3VudFwiOiAxMDAsfV0sXHJcbiAgICAgICAgICAgICAgICBcImltYWdlTGlzdFwiOltcclxuICAgICAgICAgICAgICAgICAgICB7XCJpbWFnZVwiOiBcIi4vY292ZXIgMS5wbmdcIn0sXHJcbiAgICAgICAgICAgICAgICAgICAge1wiaW1hZ2VcIjogXCIuL2NvdmVyIDIucG5nXCJ9LFxyXG4gICAgICAgICAgICAgICAgICAgIHtcImltYWdlXCI6IFwiLi9jb3ZlciAzLnBuZ1wifSxcclxuICAgICAgICAgICAgICAgICAgICB7XCJpbWFnZVwiOiBcIi4vY292ZXIgNC5wbmdcIn0sXHJcbiAgICAgICAgICAgICAgICBdLFxyXG4gICAgICAgICAgICAgICAgXCJpc011bHR5SW1hZ2VcIiA6IGZhbHNlLFxyXG4gICAgICAgICAgICB9XHJcbiAgICBdLFxyXG4gICAgXCJsaW1pdFwiIDogMTAsXHJcbiAgICBcInByZVBvc3RcIiA6IDAsXHJcbiAgICBcIm5leHRQb3N0XCIgOiB0cnVlLFxyXG59XHJcblxyXG5jb25zdCBkdW1teVBvc3QgPSB7XHJcbiAgICBpZDozLCBcclxuICAgIG5hbWUgOiBcInVzZXIzXCIsIFxyXG4gICAgXCJjb250ZW50XCI6IFwi6rKM7Iuc6riANFwiLFxyXG4gICAgXCJjcmVhdGVkRGF0ZVwiOiBcIjIwMjMtMDEtMDFUMTI6MTE6MDBcIixcclxuICAgIFwibW9kaWZpZWREYXRlXCI6IFwiMjAyMy0wMS0wMVQxMzoxMTowMFwiLFxyXG4gICAgbGlrZUNvdW50OiAwLFxyXG4gICAgbGlrZXNDaGVjazogZmFsc2UsXHJcbiAgICBcImNvbW1lbnRDb3VudFwiOiAwLFxyXG4gICAgXCJjb21tZW50TGlzdFwiIDogW10sXHJcbiAgICBcImltYWdlTGlzdFwiIDogW3tcImltYWdlXCI6IFwiLi9jb3ZlciA0LnBuZ1wifSxcclxuICAgIHtcImltYWdlXCI6IFwiLi9jb3ZlciAzLnBuZ1wifSx7XCJpbWFnZVwiOiBcIi4vY292ZXIgMi5wbmdcIn1dLFxyXG4gICAgXCJpc011bHR5SW1hZ2VcIiA6IGZhbHNlLFxyXG59XHJcblxyXG5leHBvcnQgY29uc3QgbWFpblBhZ2VSZXF1ZXN0QWN0aW9uID0gKCkgPT4gKHtcclxuICAgIHR5cGU6ICdNQUlOX1BBR0VfUkVRVUVTVCcsXHJcbiAgfSk7XHJcblxyXG5jb25zdCByZWR1Y2VyID0gKHN0YXRlID0gaW5pdGlhbE1haW5TdGF0ZSwgYWN0aW9uKSA9PiBwcm9kdWNlKHN0YXRlLCAoZHJhZnQpID0+IHtcclxuICAgIHN3aXRjaChhY3Rpb24udHlwZSl7XHJcbiAgICAgICAgY2FzZSAnTUFJTl9QQUdFX1JFUVVFU1QnIDogXHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ01BSU5fUEFHRV9TVUNDRVNTJyA6XHJcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwidGpkcmhkXCIpO1xyXG4gICAgICAgICAgICBkcmFmdC5zdG9yeUxpc3QgPSBkcmFmdC5zdG9yeUxpc3QuY29uY2F0KGR1bW15RGF0YS5zdG9yeUxpc3QpO1xyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdCA9IGRyYWZ0LnBvc3RMaXN0LmNvbmNhdChkdW1teURhdGEucG9zdExpc3QpO1xyXG4gICAgICAgICAgICBkcmFmdC5saW1pdCA9IGR1bW15RGF0YS5saW1pdDtcclxuICAgICAgICAgICAgZHJhZnQucHJlUG9zdCA9IGR1bW15RGF0YS5wcmVQb3N0O1xyXG4gICAgICAgICAgICBkcmFmdC5uZXh0UG9zdCA9IGR1bW15RGF0YS5uZXh0UG9zdDtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnTUFJTl9QQUdFX0ZBSVJMVUUnIDpcclxuICAgICAgICAgICAgYnJlYWs7XHJcblxyXG4gICAgICAgIGNhc2UgJ1BPU1RfSU5GT19SRVFVRVNUJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnUE9TVF9JTkZPX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdCA9IGFjdGlvbi5kYXRhO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdQT1NUX0lORk9fRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgXHJcbiAgICAgICAgY2FzZSAnQUREX1BPU1RfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ0FERF9QT1NUX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICBkcmFmdC5wb3N0TGlzdC51bnNoaWZ0KGR1bW15UG9zdCk7XHJcbiAgICAgICAgICAgIGRyYWZ0LmNsZWFyVXBsb2FkID0gdHJ1ZTtcclxuICAgICAgICAgICAgZHJhZnQubmV3SW1hZ2UgPSBbXTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnQUREX1BPU1RfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGRyYWZ0LmNsZWFyVXBsb2FkID0gdHJ1ZTtcclxuICAgICAgICAgICAgZHJhZnQubmV3SW1hZ2UgPSBbXTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICBcclxuICAgICAgICBjYXNlICdNT0RfUE9TVF9SRVFVRVNUJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnTU9EX1BPU1RfU1VDQ0VTUyc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgIGNhc2UgJ01PRF9QT1NUX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgIFxyXG4gICAgICAgIGNhc2UgJ1JFTU9WRV9QT1NUX1JFUVVFU1QnOlxyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICBjYXNlICdSRU1PVkVfUE9TVF9TVUNDRVNTJzpcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgY2FzZSAnUkVNT1ZFX1BPU1RfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgIGJyZWFrO1xyXG5cclxuICAgICAgICBjYXNlICdBRERfQ09NTUVOVF9SRVFVRVNUJzpcclxuICAgICAgICAgICAge1xyXG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coZHJhZnQpO1xyXG4gICAgICAgICAgICAgICAgY29uc3QgcG9zdCA9IGRyYWZ0LnBvc3RMaXN0LmZpbmQoKHYpID0+IHYuaWQgPT09IGFjdGlvbi5kYXRhdyk7XHJcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhwb3N0KTtcclxuICAgICAgICAgICAgICAgIHBvc3QuY29tbWVudExpc3QucHVzaCh7XCJjb21tZW50V3JpdGVyXCIgOiBhY3Rpb24uZGF0YW1lLnVzZXJuYW1lLCBcIkltYWdlXCIgOiBhY3Rpb24uZGF0YW1lLnByb2ZpbGVpbWFnZSwgXHJcbiAgICAgICAgICAgICAgICBcImNvbW1lbnRcIiA6IGFjdGlvbi5kYXRhLCBcImxpa2VDb3VudFwiOjB9KTtcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICB9XHJcbiAgICAgICAgY2FzZSAnSU1BR0VfVVBMT0FEX1JFUVVFU1QnOntcclxuICAgICAgICAgICAgY29uc29sZS5sb2coYWN0aW9uLmRhdGEubmFtZSk7XHJcbiAgICAgICAgICAgIGRyYWZ0Lm5ld0ltYWdlLnB1c2goYWN0aW9uLmRhdGEuZ2V0KFwiaW1hZ2VcIikubmFtZSk7XHJcbiAgICAgICAgICAgIGRyYWZ0LmlzSW1hZ2UgPSB0cnVlO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICB9XHJcbiAgICAgICAgZGVmYXVsdDpcclxuICAgICAgICAgICAgYnJlYWs7XHJcblxyXG4gICAgfVxyXG59KTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IHJlZHVjZXI7Il0sIm5hbWVzIjpbInByb2R1Y2UiLCJpbml0aWFsTWFpblN0YXRlIiwiY2xlYXJVcGxvYWQiLCJzdG9yeUxpc3QiLCJwb3N0TGlzdCIsImxpbWl0IiwicHJlUG9zdCIsIm5leHRQb3N0IiwibmV3SW1hZ2UiLCJpc0ltYWdlIiwiZHVtbXlEYXRhIiwiaWQiLCJuYW1lIiwibGlrZUNvdW50IiwibGlrZXNDaGVjayIsImR1bW15UG9zdCIsIm1haW5QYWdlUmVxdWVzdEFjdGlvbiIsInR5cGUiLCJyZWR1Y2VyIiwic3RhdGUiLCJhY3Rpb24iLCJkcmFmdCIsImNvbnNvbGUiLCJsb2ciLCJjb25jYXQiLCJkYXRhIiwidW5zaGlmdCIsInBvc3QiLCJmaW5kIiwidiIsImRhdGF3IiwiY29tbWVudExpc3QiLCJwdXNoIiwiZGF0YW1lIiwidXNlcm5hbWUiLCJwcm9maWxlaW1hZ2UiLCJnZXQiXSwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./reducers/mainpage.js\n"));

/***/ })

});