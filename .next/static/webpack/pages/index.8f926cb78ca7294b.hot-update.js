"use strict";
/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
self["webpackHotUpdate_N_E"]("pages/index",{

/***/ "./components/NewPostText.js":
/*!***********************************!*\
  !*** ./components/NewPostText.js ***!
  \***********************************/
/***/ (function(module, __webpack_exports__, __webpack_require__) {

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"./node_modules/react/jsx-dev-runtime.js\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react */ \"./node_modules/react/index.js\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);\n/* harmony import */ var react_slick__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! react-slick */ \"./node_modules/react-slick/lib/index.js\");\n/* harmony import */ var slick_carousel_slick_slick_css__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! slick-carousel/slick/slick.css */ \"./node_modules/slick-carousel/slick/slick.css\");\n/* harmony import */ var slick_carousel_slick_slick_css__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(slick_carousel_slick_slick_css__WEBPACK_IMPORTED_MODULE_3__);\n/* harmony import */ var slick_carousel_slick_slick_theme_css__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! slick-carousel/slick/slick-theme.css */ \"./node_modules/slick-carousel/slick/slick-theme.css\");\n/* harmony import */ var slick_carousel_slick_slick_theme_css__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(slick_carousel_slick_slick_theme_css__WEBPACK_IMPORTED_MODULE_4__);\n/* harmony import */ var _UserInfo__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./UserInfo */ \"./components/UserInfo.js\");\n/* harmony import */ var react_redux__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! react-redux */ \"./node_modules/react-redux/es/index.js\");\n\nvar _s = $RefreshSig$();\n\n\n\n\n\n\n\nconst NewPostText = (props)=>{\n    _s();\n    const dispatch = (0,react_redux__WEBPACK_IMPORTED_MODULE_6__.useDispatch)();\n    const { me  } = (0,react_redux__WEBPACK_IMPORTED_MODULE_6__.useSelector)((state)=>state.user);\n    const { newImage  } = (0,react_redux__WEBPACK_IMPORTED_MODULE_6__.useSelector)((state)=>state.mainpage);\n    console.log(newImage);\n    const imageSource = window.URL.createObjectURL(newImage[0]);\n    const [postText, setPostText] = (0,react__WEBPACK_IMPORTED_MODULE_1__.useState)(\"\");\n    const onChangePostText = (0,react__WEBPACK_IMPORTED_MODULE_1__.useCallback)((e)=>{\n        setPostText(e.target.value);\n    }, []);\n    const [currentSlide, setCurrentSlide] = (0,react__WEBPACK_IMPORTED_MODULE_1__.useState)(0);\n    const settings = {\n        dote: true,\n        infinite: true,\n        speed: 500,\n        slidesToShow: 1,\n        slidesToScroll: 1\n    };\n    const onSubmit = ()=>{\n        props.isEdit ? dispatch({\n            type: \"MOD_POST_REQUEST\",\n            data: postText,\n            dataId: me.accountId\n        }) : dispatch({\n            type: \"ADD_POST_REQUEST\",\n            dataId: me.accountId,\n            data: postText,\n            dataImage: newImage\n        });\n    };\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n        className: \"flex-center\",\n        children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n            className: \"modal_window\",\n            children: [\n                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                    className: \"modal_title\",\n                    style: {\n                        borderBottom: \"1px solid lightgray\",\n                        paddingBottom: 15,\n                        paddingTop: 15\n                    },\n                    children: [\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            className: \"modal_title_side\"\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                            lineNumber: 40,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            style: {\n                                fontWeight: \"bold\"\n                            },\n                            children: [\n                                \" \",\n                                props.isEdit ? \"게시물 수정하기\" : \"세 게시물 만들기\"\n                            ]\n                        }, void 0, true, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                            lineNumber: 41,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            className: \"modal_title_side\"\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                            lineNumber: 42,\n                            columnNumber: 21\n                        }, undefined)\n                    ]\n                }, void 0, true, {\n                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                    lineNumber: 38,\n                    columnNumber: 17\n                }, undefined),\n                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                    className: \"wrapper-detail\",\n                    style: {\n                        girdTemplateColumns: \"50% 50%\"\n                    },\n                    children: [\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            className: \"left-col-detail\",\n                            children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                                src: \"./cover 1.png\",\n                                className: \"post-image\",\n                                alt: \"\",\n                                style: {\n                                    objectFit: \"contain\",\n                                    height: 200,\n                                    width: 400\n                                }\n                            }, void 0, false, {\n                                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                                lineNumber: 46,\n                                columnNumber: 17\n                            }, undefined)\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                            lineNumber: 45,\n                            columnNumber: 13\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            className: \"right-col-detail\",\n                            style: {\n                                padding: 0,\n                                display: \"flex\",\n                                flexDirection: \"column\"\n                            },\n                            children: [\n                                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                                    children: [\n                                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_UserInfo__WEBPACK_IMPORTED_MODULE_5__[\"default\"], {\n                                            postImage: me.profileimage,\n                                            postId: me.accountId,\n                                            postName: me.username,\n                                            isMain: false\n                                        }, void 0, false, {\n                                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                                            lineNumber: 50,\n                                            columnNumber: 21\n                                        }, undefined),\n                                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"textarea\", {\n                                            placeholder: props.isEdit ? \"\" : \"내용 작성...\",\n                                            style: {\n                                                height: 100,\n                                                width: 350\n                                            },\n                                            value: postText,\n                                            onChange: onChangePostText\n                                        }, void 0, false, {\n                                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                                            lineNumber: 51,\n                                            columnNumber: 21\n                                        }, undefined)\n                                    ]\n                                }, void 0, true, {\n                                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                                    lineNumber: 49,\n                                    columnNumber: 17\n                                }, undefined),\n                                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"button\", {\n                                    className: \"btn profile-edit-btn\",\n                                    onClick: onSubmit,\n                                    children: props.isEdit ? \"수정하기\" : \"공유하기\"\n                                }, void 0, false, {\n                                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                                    lineNumber: 54,\n                                    columnNumber: 17\n                                }, undefined)\n                            ]\n                        }, void 0, true, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                            lineNumber: 48,\n                            columnNumber: 13\n                        }, undefined)\n                    ]\n                }, void 0, true, {\n                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n                    lineNumber: 44,\n                    columnNumber: 17\n                }, undefined)\n            ]\n        }, void 0, true, {\n            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n            lineNumber: 37,\n            columnNumber: 13\n        }, undefined)\n    }, void 0, false, {\n        fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NewPostText.js\",\n        lineNumber: 36,\n        columnNumber: 9\n    }, undefined);\n};\n_s(NewPostText, \"iIIzu1oq6IeQ7HQEM6OIYCgdvU8=\", false, function() {\n    return [\n        react_redux__WEBPACK_IMPORTED_MODULE_6__.useDispatch,\n        react_redux__WEBPACK_IMPORTED_MODULE_6__.useSelector,\n        react_redux__WEBPACK_IMPORTED_MODULE_6__.useSelector\n    ];\n});\n_c = NewPostText;\n/* harmony default export */ __webpack_exports__[\"default\"] = (NewPostText);\nvar _c;\n$RefreshReg$(_c, \"NewPostText\");\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,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LFNBQVMsTUFBTTs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFPM0c7R0FwRE03Qjs7UUFDZUQsb0RBQVdBO1FBQ2ZELG9EQUFXQTtRQUNMQSxvREFBV0E7OztLQUg1QkU7QUFzRE4sK0RBQWVBLFdBQVdBLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vY29tcG9uZW50cy9OZXdQb3N0VGV4dC5qcz80ZTBlIl0sInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBSZWFjdCwge3VzZUNhbGxiYWNrLCB1c2VTdGF0ZX0gZnJvbSAncmVhY3QnO1xyXG5pbXBvcnQgU2xpZGVyIGZyb20gJ3JlYWN0LXNsaWNrJztcclxuaW1wb3J0ICdzbGljay1jYXJvdXNlbC9zbGljay9zbGljay5jc3MnO1xyXG5pbXBvcnQgJ3NsaWNrLWNhcm91c2VsL3NsaWNrL3NsaWNrLXRoZW1lLmNzcyc7XHJcbmltcG9ydCBVc2VySW5mbyBmcm9tICcuL1VzZXJJbmZvJztcclxuaW1wb3J0IHsgdXNlU2VsZWN0b3IgfSBmcm9tICdyZWFjdC1yZWR1eCc7XHJcbmltcG9ydCB7dXNlRGlzcGF0Y2h9IGZyb20gJ3JlYWN0LXJlZHV4JztcclxuXHJcbmNvbnN0IE5ld1Bvc3RUZXh0ID0gKHByb3BzKSA9PiB7XHJcbiAgICBjb25zdCBkaXNwYXRjaCA9IHVzZURpc3BhdGNoKCk7XHJcbiAgICBjb25zdCB7bWV9ID0gdXNlU2VsZWN0b3IoKHN0YXRlKSA9PiBzdGF0ZS51c2VyKTtcclxuICAgIGNvbnN0IHtuZXdJbWFnZX0gPSB1c2VTZWxlY3Rvcigoc3RhdGUpID0+IHN0YXRlLm1haW5wYWdlKTtcclxuICAgIGNvbnNvbGUubG9nKG5ld0ltYWdlKTtcclxuICAgIGNvbnN0IGltYWdlU291cmNlID0gd2luZG93LlVSTC5jcmVhdGVPYmplY3RVUkwobmV3SW1hZ2VbMF0pO1xyXG4gICAgY29uc3QgW3Bvc3RUZXh0LCBzZXRQb3N0VGV4dF0gPSB1c2VTdGF0ZSgnJyk7XHJcbiAgICBjb25zdCBvbkNoYW5nZVBvc3RUZXh0ID0gdXNlQ2FsbGJhY2soKGUpID0+IHtcclxuICAgICAgICBzZXRQb3N0VGV4dChlLnRhcmdldC52YWx1ZSk7XHJcbiAgICB9LCBbXSk7XHJcblxyXG4gICAgY29uc3QgW2N1cnJlbnRTbGlkZSwgc2V0Q3VycmVudFNsaWRlXSA9IHVzZVN0YXRlKDApO1xyXG4gICAgY29uc3Qgc2V0dGluZ3MgPSB7XHJcbiAgICAgICAgZG90ZTp0cnVlLFxyXG4gICAgICAgIGluZmluaXRlOnRydWUsXHJcbiAgICAgICAgc3BlZWQ6NTAwLFxyXG4gICAgICAgIHNsaWRlc1RvU2hvdzogMSxcclxuICAgICAgICBzbGlkZXNUb1Njcm9sbDogMSxcclxuICAgIH1cclxuXHJcblxyXG5cclxuICAgIGNvbnN0IG9uU3VibWl0ID0gKCkgPT57XHJcbiAgICAgICAgcHJvcHMuaXNFZGl0ID8gZGlzcGF0Y2goe3R5cGU6J01PRF9QT1NUX1JFUVVFU1QnLCBkYXRhOnBvc3RUZXh0LCBkYXRhSWQ6bWUuYWNjb3VudElkfSlcclxuICAgICAgICA6IGRpc3BhdGNoKHt0eXBlOidBRERfUE9TVF9SRVFVRVNUJywgZGF0YUlkOm1lLmFjY291bnRJZCwgZGF0YTpwb3N0VGV4dCwgZGF0YUltYWdlOm5ld0ltYWdlfSk7XHJcbiAgICB9XHJcbiAgICByZXR1cm4oXHJcbiAgICAgICAgPGRpdiBjbGFzc05hbWU9XCJmbGV4LWNlbnRlclwiPlxyXG4gICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT1cIm1vZGFsX3dpbmRvd1wiID5cclxuICAgICAgICAgICAgICAgIDxkaXYgY2xhc3NOYW1lPVwibW9kYWxfdGl0bGVcIiAgc3R5bGU9e3tib3JkZXJCb3R0b206XCIxcHggc29saWQgbGlnaHRncmF5XCIsIHBhZGRpbmdCb3R0b206MTUsXHJcbiAgICAgICAgICAgICAgICBwYWRkaW5nVG9wOjE1fX0+XHJcbiAgICAgICAgICAgICAgICAgICAgPGRpdiBjbGFzc05hbWUgPSAnbW9kYWxfdGl0bGVfc2lkZSc+PC9kaXY+XHJcbiAgICAgICAgICAgICAgICAgICAgPGRpdiBzdHlsZT17e2ZvbnRXZWlnaHQ6J2JvbGQnfX0+IHtwcm9wcy5pc0VkaXQgPyBcIuqyjOyLnOusvCDsiJjsoJXtlZjquLBcIiA6IFwi7IS4IOqyjOyLnOusvCDrp4zrk6TquLBcIn08L2Rpdj5cclxuICAgICAgICAgICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZSA9J21vZGFsX3RpdGxlX3NpZGUnPjwvZGl2PlxyXG4gICAgICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT0nd3JhcHBlci1kZXRhaWwnIHN0eWxlPXt7Z2lyZFRlbXBsYXRlQ29sdW1uczpcIjUwJSA1MCVcIn19PlxyXG4gICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT1cImxlZnQtY29sLWRldGFpbFwiPlxyXG4gICAgICAgICAgICAgICAgPGltZyBzcmM9XCIuL2NvdmVyIDEucG5nXCIgY2xhc3NOYW1lPVwicG9zdC1pbWFnZVwiIGFsdD1cIlwiIHN0eWxlPXt7b2JqZWN0Rml0OlwiY29udGFpblwiLCBoZWlnaHQ6MjAwLCB3aWR0aDo0MDB9fS8+ICAgICBcclxuICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgIDxkaXYgY2xhc3NOYW1lPVwicmlnaHQtY29sLWRldGFpbFwiIHN0eWxlPXt7cGFkZGluZzowLCBkaXNwbGF5OidmbGV4JywgZmxleERpcmVjdGlvbjonY29sdW1uJ319PlxyXG4gICAgICAgICAgICAgICAgPGRpdj5cclxuICAgICAgICAgICAgICAgICAgICA8VXNlckluZm8gcG9zdEltYWdlID0ge21lLnByb2ZpbGVpbWFnZX0gcG9zdElkID0ge21lLmFjY291bnRJZH0gcG9zdE5hbWUgPSB7bWUudXNlcm5hbWV9IGlzTWFpbiA9IHtmYWxzZX0vPlxyXG4gICAgICAgICAgICAgICAgICAgIDx0ZXh0YXJlYSBwbGFjZWhvbGRlcj17cHJvcHMuaXNFZGl0ID8gJycgOiAn64K07JqpIOyekeyEsS4uLid9IHN0eWxlPXt7aGVpZ2h0OjEwMCwgd2lkdGg6MzUwfX1cclxuICAgICAgICAgICAgICAgICAgICB2YWx1ZT17cG9zdFRleHR9IG9uQ2hhbmdlPXtvbkNoYW5nZVBvc3RUZXh0fS8+XHJcbiAgICAgICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICAgICAgICAgIDxidXR0b24gY2xhc3NOYW1lPVwiYnRuIHByb2ZpbGUtZWRpdC1idG5cIiBvbkNsaWNrPXtvblN1Ym1pdH0+e3Byb3BzLmlzRWRpdCA/IFwi7IiY7KCV7ZWY6riwXCIgOiBcIuqzteycoO2VmOq4sFwifTwvYnV0dG9uPlxyXG4gICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICAgICAgPC9kaXY+XHJcblxyXG4gICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICA8L2Rpdj5cclxuICAgIClcclxufVxyXG5cclxuZXhwb3J0IGRlZmF1bHQgTmV3UG9zdFRleHQ7Il0sIm5hbWVzIjpbIlJlYWN0IiwidXNlQ2FsbGJhY2siLCJ1c2VTdGF0ZSIsIlNsaWRlciIsIlVzZXJJbmZvIiwidXNlU2VsZWN0b3IiLCJ1c2VEaXNwYXRjaCIsIk5ld1Bvc3RUZXh0IiwicHJvcHMiLCJkaXNwYXRjaCIsIm1lIiwic3RhdGUiLCJ1c2VyIiwibmV3SW1hZ2UiLCJtYWlucGFnZSIsImNvbnNvbGUiLCJsb2ciLCJpbWFnZVNvdXJjZSIsIndpbmRvdyIsIlVSTCIsImNyZWF0ZU9iamVjdFVSTCIsInBvc3RUZXh0Iiwic2V0UG9zdFRleHQiLCJvbkNoYW5nZVBvc3RUZXh0IiwiZSIsInRhcmdldCIsInZhbHVlIiwiY3VycmVudFNsaWRlIiwic2V0Q3VycmVudFNsaWRlIiwic2V0dGluZ3MiLCJkb3RlIiwiaW5maW5pdGUiLCJzcGVlZCIsInNsaWRlc1RvU2hvdyIsInNsaWRlc1RvU2Nyb2xsIiwib25TdWJtaXQiLCJpc0VkaXQiLCJ0eXBlIiwiZGF0YSIsImRhdGFJZCIsImFjY291bnRJZCIsImRhdGFJbWFnZSIsImRpdiIsImNsYXNzTmFtZSIsInN0eWxlIiwiYm9yZGVyQm90dG9tIiwicGFkZGluZ0JvdHRvbSIsInBhZGRpbmdUb3AiLCJmb250V2VpZ2h0IiwiZ2lyZFRlbXBsYXRlQ29sdW1ucyIsImltZyIsInNyYyIsImFsdCIsIm9iamVjdEZpdCIsImhlaWdodCIsIndpZHRoIiwicGFkZGluZyIsImRpc3BsYXkiLCJmbGV4RGlyZWN0aW9uIiwicG9zdEltYWdlIiwicHJvZmlsZWltYWdlIiwicG9zdElkIiwicG9zdE5hbWUiLCJ1c2VybmFtZSIsImlzTWFpbiIsInRleHRhcmVhIiwicGxhY2Vob2xkZXIiLCJvbkNoYW5nZSIsImJ1dHRvbiIsIm9uQ2xpY2siXSwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./components/NewPostText.js\n"));

/***/ })

});