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

/***/ "./reducers/user.js":
/*!**************************!*\
  !*** ./reducers/user.js ***!
  \**************************/
/***/ (function(module, __webpack_exports__, __webpack_require__) {

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"initialState\": function() { return /* binding */ initialState; },\n/* harmony export */   \"loginRequestAction\": function() { return /* binding */ loginRequestAction; },\n/* harmony export */   \"logoutRequestAction\": function() { return /* binding */ logoutRequestAction; },\n/* harmony export */   \"signupRequestAction\": function() { return /* binding */ signupRequestAction; }\n/* harmony export */ });\n/* harmony import */ var _hooks_tokenInsertHeader__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../hooks/tokenInsertHeader */ \"./hooks/tokenInsertHeader.js\");\n/* harmony import */ var immer__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! immer */ \"./node_modules/immer/dist/immer.esm.mjs\");\n\n\nconst initialState = {\n    isLoggedIn: false,\n    me: {\n        profileimage: \"/cover 8.png\",\n        username: \"이유성\",\n        accountId: \"yusung\"\n    },\n    signUpData: {},\n    loginData: {\n        image: \"/cover 1.png\",\n        username: \"yusung\"\n    },\n    loadProfileSuccess: false,\n    profileData: {},\n    folloingList: [],\n    followerList: []\n};\nconst dummyfolloingList = [\n    {\n        accountId: \"user20\",\n        accountName: \"박형우\",\n        profileImage: \"./cover 9.png\"\n    },\n    {\n        accountId: \"joa\",\n        accountName: \"좋아아\",\n        profileImage: \"./cover 10.png\"\n    },\n    {\n        accountId: \"Atrox\",\n        accountName: \"그랙\",\n        profileImage: \"./cover 11.png\"\n    }\n];\nconst dummyfollowerList = [\n    {\n        accountId: \"user20\",\n        accountName: \"박형우\",\n        profileImage: \"./cover 9.png\"\n    },\n    {\n        accountId: \"joa\",\n        accountName: \"좋아아\",\n        profileImage: \"./cover 10.png\"\n    },\n    {\n        accountId: \"Atrox\",\n        accountName: \"그랙\",\n        profileImage: \"./cover 11.png\"\n    }\n];\nconst loginRequestAction = (data)=>({\n        type: \"LOG_IN_REQUEST\",\n        data\n    });\nconst signupRequestAction = (data)=>({\n        type: \"SIGN_UP_REQUEST\",\n        data\n    });\nconst logoutRequestAction = ()=>({\n        type: \"LOG_OUT\"\n    });\n//이전 상태를 액션을 통해 다음 상태로 만들어내는 함수(불면성은 지키고)\nconst reducer = function() {\n    let state = arguments.length > 0 && arguments[0] !== void 0 ? arguments[0] : initialState, action = arguments.length > 1 ? arguments[1] : void 0;\n    return (0,immer__WEBPACK_IMPORTED_MODULE_1__[\"default\"])(state, (draft)=>{\n        switch(action.type){\n            case \"LOG_IN_REQUEST\":\n                draft.isLoggedIn = false;\n                break;\n            case \"LOG_IN_SUCCESS\":\n                localStorage.setItem(\"token\", action.data.token);\n                (0,_hooks_tokenInsertHeader__WEBPACK_IMPORTED_MODULE_0__.tokenInsertHeader)(action.data.token);\n                draft.isLoggedIn = true;\n                draft.me = action.data;\n                break;\n            case \"LOG_IN_FAILURE\":\n                draft.isLoggedIn = true;\n                break;\n            case \"SIGN_UP_REQUEST\":\n                break;\n            case \"SIGN_UP_SUCCESS\":\n                break;\n            case \"SIGN_UP_FAILURE\":\n                break;\n            case \"PROFILE_LOAD_REQUEST\":\n                break;\n            case \"PROFILE_LOAD_SUCCESS\":\n                {\n                    draft.profileData = {\n                        \"name\": \"yusung\",\n                        \"profileImage\": \"/cover 8.png\",\n                        \"followerCount\": 100,\n                        \"followingCount\": 95,\n                        \"postCount\": 10,\n                        \"imageList\": [\n                            {\n                                \"image\": \"/cover 3.png\",\n                                \"postId\": 12,\n                                \"isMultyImage\": true\n                            },\n                            {\n                                \"image\": \"/cover 5.png\",\n                                \"postId\": 14,\n                                \"isMultyImage\": false\n                            }\n                        ]\n                    };\n                    draft.loadProfileSuccess = true;\n                    break;\n                }\n            case \"PROFILE_LOAD_FAILURE\":\n                break;\n            case \"GET_FOLLOING_REQUEST\":\n                break;\n            case \"GET_FOLLOING_SUCCESS\":\n                {\n                    draft.folloingList = draft.folloingList.concat(dummyfolloingList);\n                    console.log();\n                    break;\n                }\n            case \"GET_FOLLOING_FAILURE\":\n                break;\n            case \"GET_FOLLOWER_REQUEST\":\n                break;\n            case \"GET_FOLLOWER_SUCCESS\":\n                {\n                    draft.followerList = draft.followerList.concat(dummyfollowerList);\n                    console.log(\"asdf\");\n                    break;\n                }\n            case \"GET_FOLLOWER_FAILURE\":\n                break;\n            case \"LOG_OUT\":\n                localStorage.clear();\n                draft.isLoggedIn = false;\n                break;\n            default:\n                break;\n        }\n    });\n};\n/* harmony default export */ __webpack_exports__[\"default\"] = (reducer);\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,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QUFDYjtvQkFFL0NjLFFBQVFDLEdBQUcsQ0FBQztvQkFDWixLQUFNO2dCQUNWO1lBQ0osS0FBSztnQkFDRCxLQUFNO1lBR1YsS0FBSztnQkFDREwsYUFBYU0sS0FBSztnQkFDbEJQLE1BQU14QixVQUFVLEdBQUcsS0FBSztnQkFDeEIsS0FBTTtZQUNWO2dCQUNJLEtBQU07UUFFZDtJQUNSO0FBQUM7QUFFRCwrREFBZXFCLE9BQU9BLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vcmVkdWNlcnMvdXNlci5qcz8wZGY0Il0sInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IHRva2VuSW5zZXJ0SGVhZGVyIH0gZnJvbSBcIi4uL2hvb2tzL3Rva2VuSW5zZXJ0SGVhZGVyXCI7XHJcbmltcG9ydCBwcm9kdWNlIGZyb20gJ2ltbWVyJ1xyXG5cclxuZXhwb3J0IGNvbnN0IGluaXRpYWxTdGF0ZSA9IHtcclxuICAgIGlzTG9nZ2VkSW46ZmFsc2UsXHJcbiAgICBtZTp7cHJvZmlsZWltYWdlOiAnL2NvdmVyIDgucG5nJywgdXNlcm5hbWU6J+ydtOycoOyEsScsIGFjY291bnRJZDoneXVzdW5nJ30sXHJcbiAgICBzaWduVXBEYXRhOnt9LFxyXG4gICAgbG9naW5EYXRhOntpbWFnZTogJy9jb3ZlciAxLnBuZycsIHVzZXJuYW1lOid5dXN1bmcnfSxcclxuICAgIGxvYWRQcm9maWxlU3VjY2VzcyA6IGZhbHNlLFxyXG4gICAgcHJvZmlsZURhdGE6e30sXHJcbiAgICBmb2xsb2luZ0xpc3Q6W10sXHJcbiAgICBmb2xsb3dlckxpc3Q6W10sXHJcbn1cclxuXHJcbmNvbnN0IGR1bW15Zm9sbG9pbmdMaXN0ID0gW3tcclxuICAgIGFjY291bnRJZDogXCJ1c2VyMjBcIixcclxuICAgIGFjY291bnROYW1lOlwi67CV7ZiV7JqwXCIsXHJcbiAgICBwcm9maWxlSW1hZ2U6XCIuL2NvdmVyIDkucG5nXCJcclxuICAgIH0sXHJcbiAgICB7XHJcbiAgICAgICAgYWNjb3VudElkOiBcImpvYVwiLFxyXG4gICAgICAgIGFjY291bnROYW1lOlwi7KKL7JWE7JWEXCIsXHJcbiAgICAgICAgcHJvZmlsZUltYWdlOlwiLi9jb3ZlciAxMC5wbmdcIlxyXG4gICAgfSxcclxuICAgIHtcclxuICAgICAgICBhY2NvdW50SWQ6IFwiQXRyb3hcIixcclxuICAgICAgICBhY2NvdW50TmFtZTpcIuq3uOuemVwiLFxyXG4gICAgICAgIHByb2ZpbGVJbWFnZTpcIi4vY292ZXIgMTEucG5nXCJcclxuICAgIH1cclxuXTtcclxuXHJcbmNvbnN0IGR1bW15Zm9sbG93ZXJMaXN0ID0gW3tcclxuICAgIGFjY291bnRJZDogXCJ1c2VyMjBcIixcclxuICAgIGFjY291bnROYW1lOlwi67CV7ZiV7JqwXCIsXHJcbiAgICBwcm9maWxlSW1hZ2U6XCIuL2NvdmVyIDkucG5nXCJcclxuICAgIH0sXHJcbiAgICB7XHJcbiAgICAgICAgYWNjb3VudElkOiBcImpvYVwiLFxyXG4gICAgICAgIGFjY291bnROYW1lOlwi7KKL7JWE7JWEXCIsXHJcbiAgICAgICAgcHJvZmlsZUltYWdlOlwiLi9jb3ZlciAxMC5wbmdcIlxyXG4gICAgfSxcclxuICAgIHtcclxuICAgICAgICBhY2NvdW50SWQ6IFwiQXRyb3hcIixcclxuICAgICAgICBhY2NvdW50TmFtZTpcIuq3uOuemVwiLFxyXG4gICAgICAgIHByb2ZpbGVJbWFnZTpcIi4vY292ZXIgMTEucG5nXCJcclxuICAgIH1cclxuXTtcclxuXHJcbmV4cG9ydCBjb25zdCBsb2dpblJlcXVlc3RBY3Rpb24gPSAoZGF0YSkgPT4gKHtcclxuICAgIHR5cGU6ICdMT0dfSU5fUkVRVUVTVCcsXHJcbiAgICBkYXRhLFxyXG4gIH0pO1xyXG5cclxuZXhwb3J0IGNvbnN0IHNpZ251cFJlcXVlc3RBY3Rpb24gPSAoZGF0YSkgPT4gKHtcclxuICAgIHR5cGU6ICdTSUdOX1VQX1JFUVVFU1QnLFxyXG4gICAgZGF0YSxcclxufSk7XHJcblxyXG5leHBvcnQgY29uc3QgbG9nb3V0UmVxdWVzdEFjdGlvbiA9ICgpID0+ICh7XHJcbiAgICB0eXBlOidMT0dfT1VUJyxcclxufSlcclxuXHJcbi8v7J207KCEIOyDge2DnOulvCDslaHshZjsnYQg7Ya17ZW0IOuLpOydjCDsg4Htg5zroZwg66eM65Ok7Ja064K064qUIO2VqOyImCjrtojrqbTshLHsnYAg7KeA7YKk6rOgKVxyXG5jb25zdCByZWR1Y2VyID0gKHN0YXRlID0gaW5pdGlhbFN0YXRlLCBhY3Rpb24pID0+IHByb2R1Y2Uoc3RhdGUsIChkcmFmdCkgPT4ge1xyXG4gICAgICAgIHN3aXRjaChhY3Rpb24udHlwZSl7XHJcbiAgICAgICAgICAgIGNhc2UgJ0xPR19JTl9SRVFVRVNUJyA6XHJcbiAgICAgICAgICAgICAgICBkcmFmdC5pc0xvZ2dlZEluID0gZmFsc2U7XHJcbiAgICAgICAgICAgICAgICBicmVhaztcclxuICAgICAgICAgICAgY2FzZSAnTE9HX0lOX1NVQ0NFU1MnIDpcclxuICAgICAgICAgICAgICAgIGxvY2FsU3RvcmFnZS5zZXRJdGVtKCd0b2tlbicsIGFjdGlvbi5kYXRhLnRva2VuKTtcclxuICAgICAgICAgICAgICAgIHRva2VuSW5zZXJ0SGVhZGVyKGFjdGlvbi5kYXRhLnRva2VuKTtcclxuICAgICAgICAgICAgICAgIGRyYWZ0LmlzTG9nZ2VkSW4gPSB0cnVlO1xyXG4gICAgICAgICAgICAgICAgZHJhZnQubWUgPSBhY3Rpb24uZGF0YTtcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICBjYXNlICdMT0dfSU5fRkFJTFVSRScgOlxyXG4gICAgICAgICAgICAgICAgZHJhZnQuaXNMb2dnZWRJbiA9IHRydWU7XHJcbiAgICAgICAgICAgICAgICBicmVhaztcclxuICAgIFxyXG4gICAgICAgICAgICBjYXNlICdTSUdOX1VQX1JFUVVFU1QnIDpcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICBjYXNlICdTSUdOX1VQX1NVQ0NFU1MnIDpcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICBjYXNlICdTSUdOX1VQX0ZBSUxVUkUnIDpcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICBcclxuICAgICAgICAgICAgY2FzZSAnUFJPRklMRV9MT0FEX1JFUVVFU1QnOlxyXG4gICAgICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICAgIGNhc2UgJ1BST0ZJTEVfTE9BRF9TVUNDRVNTJzpcclxuICAgICAgICAgICAgICAgIHtcclxuICAgICAgICAgICAgICAgICAgICBkcmFmdC5wcm9maWxlRGF0YSA9IHtcclxuICAgICAgICAgICAgICAgICAgICAgICAgXCJuYW1lXCI6IFwieXVzdW5nXCIsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIFwicHJvZmlsZUltYWdlXCI6IFwiL2NvdmVyIDgucG5nXCIsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIFwiZm9sbG93ZXJDb3VudFwiOiAxMDAsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIFwiZm9sbG93aW5nQ291bnRcIjogOTUsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgIFwicG9zdENvdW50XCI6IDEwLFxyXG4gICAgICAgICAgICAgICAgICAgICAgICBcImltYWdlTGlzdFwiOiBbXHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICB7XCJpbWFnZVwiOiBcIi9jb3ZlciAzLnBuZ1wiLFxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgXCJwb3N0SWRcIjoxMixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIFwiaXNNdWx0eUltYWdlXCI6IHRydWV9LFxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAge1wiaW1hZ2VcIjogXCIvY292ZXIgNS5wbmdcIixcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIFwicG9zdElkXCI6MTQsXHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBcImlzTXVsdHlJbWFnZVwiIDogZmFsc2VcclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIH1cclxuICAgICAgICAgICAgICAgICAgICAgICAgXVxyXG4gICAgICAgICAgICAgICAgICAgIH0gICAgXHJcbiAgICAgICAgICAgICAgICAgICAgZHJhZnQubG9hZFByb2ZpbGVTdWNjZXNzID0gdHJ1ZTtcclxuICAgICAgICAgICAgICAgICAgICBicmVhaztcclxuICAgICAgICAgICAgICAgIH1cclxuICAgICAgICAgICAgY2FzZSAnUFJPRklMRV9MT0FEX0ZBSUxVUkUnOlxyXG4gICAgICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICAgIFxyXG4gICAgICAgICAgICBjYXNlICdHRVRfRk9MTE9JTkdfUkVRVUVTVCc6XHJcbiAgICAgICAgICAgICAgICBicmVhaztcclxuICAgICAgICAgICAgY2FzZSAnR0VUX0ZPTExPSU5HX1NVQ0NFU1MnOlxyXG4gICAgICAgICAgICAgICAge1xyXG4gICAgICAgICAgICAgICAgICAgIGRyYWZ0LmZvbGxvaW5nTGlzdCA9IGRyYWZ0LmZvbGxvaW5nTGlzdC5jb25jYXQoZHVtbXlmb2xsb2luZ0xpc3QpO1xyXG4gICAgICAgICAgICAgICAgICAgIFxyXG4gICAgICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKCk7XHJcbiAgICAgICAgICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICAgICAgICB9XHJcbiAgICAgICAgICAgIGNhc2UgJ0dFVF9GT0xMT0lOR19GQUlMVVJFJzpcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICAgICAgXHJcbiAgICAgICAgICAgIGNhc2UgJ0dFVF9GT0xMT1dFUl9SRVFVRVNUJzpcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICBjYXNlICdHRVRfRk9MTE9XRVJfU1VDQ0VTUyc6XHJcbiAgICAgICAgICAgICAgICB7XHJcbiAgICAgICAgICAgICAgICAgICAgZHJhZnQuZm9sbG93ZXJMaXN0ID0gZHJhZnQuZm9sbG93ZXJMaXN0LmNvbmNhdChkdW1teWZvbGxvd2VyTGlzdCk7XHJcbiAgICAgICAgICAgICAgICAgICAgXHJcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coXCJhc2RmXCIpO1xyXG4gICAgICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICAgICAgfVxyXG4gICAgICAgICAgICBjYXNlICdHRVRfRk9MTE9XRVJfRkFJTFVSRSc6XHJcbiAgICAgICAgICAgICAgICBicmVhaztcclxuXHJcblxyXG4gICAgICAgICAgICBjYXNlICdMT0dfT1VUJyA6XHJcbiAgICAgICAgICAgICAgICBsb2NhbFN0b3JhZ2UuY2xlYXIoKTtcclxuICAgICAgICAgICAgICAgIGRyYWZ0LmlzTG9nZ2VkSW4gPSBmYWxzZTtcclxuICAgICAgICAgICAgICAgIGJyZWFrO1xyXG4gICAgICAgICAgICBkZWZhdWx0OlxyXG4gICAgICAgICAgICAgICAgYnJlYWs7XHJcbiAgICBcclxuICAgICAgICB9XHJcbn0pO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgcmVkdWNlcjsiXSwibmFtZXMiOlsidG9rZW5JbnNlcnRIZWFkZXIiLCJwcm9kdWNlIiwiaW5pdGlhbFN0YXRlIiwiaXNMb2dnZWRJbiIsIm1lIiwicHJvZmlsZWltYWdlIiwidXNlcm5hbWUiLCJhY2NvdW50SWQiLCJzaWduVXBEYXRhIiwibG9naW5EYXRhIiwiaW1hZ2UiLCJsb2FkUHJvZmlsZVN1Y2Nlc3MiLCJwcm9maWxlRGF0YSIsImZvbGxvaW5nTGlzdCIsImZvbGxvd2VyTGlzdCIsImR1bW15Zm9sbG9pbmdMaXN0IiwiYWNjb3VudE5hbWUiLCJwcm9maWxlSW1hZ2UiLCJkdW1teWZvbGxvd2VyTGlzdCIsImxvZ2luUmVxdWVzdEFjdGlvbiIsImRhdGEiLCJ0eXBlIiwic2lnbnVwUmVxdWVzdEFjdGlvbiIsImxvZ291dFJlcXVlc3RBY3Rpb24iLCJyZWR1Y2VyIiwic3RhdGUiLCJhY3Rpb24iLCJkcmFmdCIsImxvY2FsU3RvcmFnZSIsInNldEl0ZW0iLCJ0b2tlbiIsImNvbmNhdCIsImNvbnNvbGUiLCJsb2ciLCJjbGVhciJdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./reducers/user.js\n"));

/***/ })

});