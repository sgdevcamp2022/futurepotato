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

/***/ "./components/NavBar.js":
/*!******************************!*\
  !*** ./components/NavBar.js ***!
  \******************************/
/***/ (function(module, __webpack_exports__, __webpack_require__) {

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"./node_modules/react/jsx-dev-runtime.js\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var next_link__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! next/link */ \"./node_modules/next/link.js\");\n/* harmony import */ var next_link__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(next_link__WEBPACK_IMPORTED_MODULE_1__);\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! react */ \"./node_modules/react/index.js\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_2__);\n/* harmony import */ var react_modal__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! react-modal */ \"./node_modules/react-modal/lib/index.js\");\n/* harmony import */ var react_modal__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(react_modal__WEBPACK_IMPORTED_MODULE_3__);\n/* harmony import */ var react_redux__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! react-redux */ \"./node_modules/react-redux/es/index.js\");\n/* harmony import */ var _reducers_user__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../reducers/user */ \"./reducers/user.js\");\n/* harmony import */ var _NewPost__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./NewPost */ \"./components/NewPost.js\");\n/* harmony import */ var _NewPostText__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./NewPostText */ \"./components/NewPostText.js\");\n\nvar _s = $RefreshSig$();\n\n\n\n\n\n\n\n\nconst NavBar = ()=>{\n    _s();\n    const dispatch = (0,react_redux__WEBPACK_IMPORTED_MODULE_4__.useDispatch)();\n    const { clearUpload  } = (0,react_redux__WEBPACK_IMPORTED_MODULE_4__.useSelector)((state)=>state.mainpage);\n    const [newPostOpen, setNewPost] = (0,react__WEBPACK_IMPORTED_MODULE_2__.useState)(false);\n    const { me  } = (0,react_redux__WEBPACK_IMPORTED_MODULE_4__.useSelector)((state)=>state.user);\n    const logOut = ()=>{\n        dispatch((0,_reducers_user__WEBPACK_IMPORTED_MODULE_5__.logoutRequestAction)());\n    };\n    (0,react__WEBPACK_IMPORTED_MODULE_2__.useEffect)(()=>{\n        if (clearUpload) setNewPost(false);\n    }, [\n        clearUpload\n    ]);\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"nav\", {\n        className: \"navbar\",\n        children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n            className: \"nav-wrapper\",\n            children: [\n                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)((next_link__WEBPACK_IMPORTED_MODULE_1___default()), {\n                    href: \"/\",\n                    legacyBehavior: true,\n                    children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                        src: \"/logo.PNG\",\n                        className: \"brand-img\",\n                        alt: \"\"\n                    }, void 0, false, {\n                        fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                        lineNumber: 27,\n                        columnNumber: 21\n                    }, undefined)\n                }, void 0, false, {\n                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                    lineNumber: 26,\n                    columnNumber: 17\n                }, undefined),\n                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"input\", {\n                    type: \"text\",\n                    className: \"search-box\",\n                    placeholder: \"search\"\n                }, void 0, false, {\n                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                    lineNumber: 29,\n                    columnNumber: 17\n                }, undefined),\n                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                    className: \"nav-items\",\n                    children: [\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)((next_link__WEBPACK_IMPORTED_MODULE_1___default()), {\n                            href: \"/\",\n                            legacyBehavior: true,\n                            children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                                src: \"/home.PNG\",\n                                className: \"icon\",\n                                alt: \"\"\n                            }, void 0, false, {\n                                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                                lineNumber: 32,\n                                columnNumber: 25\n                            }, undefined)\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                            lineNumber: 31,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                            src: \"/add.PNG\",\n                            onClick: ()=>setNewPost(true),\n                            className: \"icon\",\n                            alt: \"\"\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                            lineNumber: 34,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                            src: \"/like.PNG\",\n                            className: \"icon\",\n                            alt: \"\"\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                            lineNumber: 35,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)((next_link__WEBPACK_IMPORTED_MODULE_1___default()), {\n                            href: \"/profile\",\n                            legacyBehavior: true,\n                            children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                                className: \"icon user-profile\",\n                                children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                                    className: \"profile-pic\",\n                                    style: {\n                                        width: 22,\n                                        height: 22,\n                                        display: \"inline-block\",\n                                        padding: 0,\n                                        cursor: \"pointer\"\n                                    },\n                                    children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                                        src: me.profileimage,\n                                        alt: true\n                                    }, void 0, false, {\n                                        fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                                        lineNumber: 40,\n                                        columnNumber: 33\n                                    }, undefined)\n                                }, void 0, false, {\n                                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                                    lineNumber: 38,\n                                    columnNumber: 29\n                                }, undefined)\n                            }, void 0, false, {\n                                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                                lineNumber: 37,\n                                columnNumber: 25\n                            }, undefined)\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                            lineNumber: 36,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)((react_modal__WEBPACK_IMPORTED_MODULE_3___default()), {\n                            isOpen: newPostOpen,\n                            onRequestClose: ()=>setNewPost(false),\n                            style: {\n                                content: {\n                                    left: \"20%\",\n                                    right: \"20%\",\n                                    padding: 0,\n                                    borderRadius: 13\n                                }\n                            },\n                            children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_NewPost__WEBPACK_IMPORTED_MODULE_6__[\"default\"], {}, void 0, false, {\n                                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                                lineNumber: 48,\n                                columnNumber: 25\n                            }, undefined)\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                            lineNumber: 45,\n                            columnNumber: 21\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)((next_link__WEBPACK_IMPORTED_MODULE_1___default()), {\n                            href: \"/\",\n                            legacyBehavior: true,\n                            children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"img\", {\n                                src: \"/logout.PNG\",\n                                className: \"icon\",\n                                alt: \"\",\n                                style: {\n                                    width: 25\n                                },\n                                onClick: logOut\n                            }, void 0, false, {\n                                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                                lineNumber: 52,\n                                columnNumber: 25\n                            }, undefined)\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                            lineNumber: 51,\n                            columnNumber: 21\n                        }, undefined)\n                    ]\n                }, void 0, true, {\n                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n                    lineNumber: 30,\n                    columnNumber: 17\n                }, undefined)\n            ]\n        }, void 0, true, {\n            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n            lineNumber: 25,\n            columnNumber: 13\n        }, undefined)\n    }, void 0, false, {\n        fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\NavBar.js\",\n        lineNumber: 24,\n        columnNumber: 9\n    }, undefined);\n};\n_s(NavBar, \"iECUQRDKqwqHO0UgQ7otzP6c7gg=\", false, function() {\n    return [\n        react_redux__WEBPACK_IMPORTED_MODULE_4__.useDispatch,\n        react_redux__WEBPACK_IMPORTED_MODULE_4__.useSelector,\n        react_redux__WEBPACK_IMPORTED_MODULE_4__.useSelector\n    ];\n});\n_c = NavBar;\n/* harmony default export */ __webpack_exports__[\"default\"] = (NavBar);\nvar _c;\n$RefreshReg$(_c, \"NavBar\");\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9jb21wb25lbnRzL05hdkJhci5qcy5qcyIsIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7QUFBNkI7QUFDUztBQUNKO0FBQ0Y7QUFDcUI7QUFDRTtBQUN2QjtBQUNPO0FBRXZDLE1BQU1VLFNBQVMsSUFBTTs7SUFDakIsTUFBTUMsV0FBV04sd0RBQVdBO0lBQzVCLE1BQU0sRUFBQ08sWUFBVyxFQUFDLEdBQUdOLHdEQUFXQSxDQUFDLENBQUNPLFFBQVVBLE1BQU1DLFFBQVE7SUFDM0QsTUFBTSxDQUFDQyxhQUFhQyxXQUFXLEdBQUdkLCtDQUFRQSxDQUFDLEtBQUs7SUFDaEQsTUFBSyxFQUFDZSxHQUFFLEVBQUMsR0FBR1gsd0RBQVdBLENBQUMsQ0FBQ08sUUFBVUEsTUFBTUssSUFBSTtJQUM3QyxNQUFNQyxTQUFTLElBQU07UUFDakJSLFNBQVNKLG1FQUFtQkE7SUFDaEM7SUFFQUosZ0RBQVNBLENBQUMsSUFBTTtRQUNaLElBQUdTLGFBQWFJLFdBQVcsS0FBSztJQUNwQyxHQUFHO1FBQUNKO0tBQVk7SUFFaEIscUJBQ0ksOERBQUNRO1FBQUlDLFdBQVU7a0JBQ1gsNEVBQUNDO1lBQUlELFdBQVU7OzhCQUNYLDhEQUFDckIsa0RBQUlBO29CQUFDdUIsTUFBTztvQkFBSUMsY0FBYzs4QkFDM0IsNEVBQUNDO3dCQUFJQyxLQUFJO3dCQUFZTCxXQUFVO3dCQUFZTSxLQUFJOzs7Ozs7Ozs7Ozs4QkFFbkQsOERBQUNDO29CQUFNQyxNQUFLO29CQUFPUixXQUFVO29CQUFhUyxhQUFZOzs7Ozs7OEJBQ3RELDhEQUFDUjtvQkFBSUQsV0FBVTs7c0NBQ1gsOERBQUNyQixrREFBSUE7NEJBQUN1QixNQUFPOzRCQUFJQyxjQUFjO3NDQUMzQiw0RUFBQ0M7Z0NBQUlDLEtBQUk7Z0NBQVlMLFdBQVU7Z0NBQU9NLEtBQUk7Ozs7Ozs7Ozs7O3NDQUU5Qyw4REFBQ0Y7NEJBQUlDLEtBQUk7NEJBQVdLLFNBQVMsSUFBTWYsV0FBVyxJQUFJOzRCQUFHSyxXQUFVOzRCQUFPTSxLQUFJOzs7Ozs7c0NBQzFFLDhEQUFDRjs0QkFBSUMsS0FBSTs0QkFBWUwsV0FBVTs0QkFBT00sS0FBSTs7Ozs7O3NDQUMxQyw4REFBQzNCLGtEQUFJQTs0QkFBQ3VCLE1BQU87NEJBQVdDLGNBQWM7c0NBQ2xDLDRFQUFDRjtnQ0FBSUQsV0FBVTswQ0FDWCw0RUFBQ0M7b0NBQUlELFdBQVU7b0NBQWNXLE9BQU87d0NBQUNDLE9BQU07d0NBQUlDLFFBQU87d0NBQUlDLFNBQVE7d0NBQWdCQyxTQUFTO3dDQUMxRkMsUUFBTztvQ0FBUzs4Q0FDYiw0RUFBQ1o7d0NBQUlDLEtBQUtULEdBQUdxQixZQUFZO3dDQUFFWCxHQUFHOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7c0NBSzFDLDhEQUFDdkIsb0RBQUtBOzRCQUFDbUMsUUFBUXhCOzRCQUFheUIsZ0JBQWdCLElBQUl4QixXQUFXLEtBQUs7NEJBQzVEZ0IsT0FBTztnQ0FBQ1MsU0FBUTtvQ0FBQ0MsTUFBSztvQ0FBT0MsT0FBTTtvQ0FBT1AsU0FBUTtvQ0FBR1EsY0FBYTtnQ0FBRTs0QkFBQztzQ0FFckUsNEVBQUNwQyxnREFBT0E7Ozs7Ozs7Ozs7c0NBR1osOERBQUNSLGtEQUFJQTs0QkFBQ3VCLE1BQU87NEJBQUlDLGNBQWM7c0NBQzNCLDRFQUFDQztnQ0FBSUMsS0FBSTtnQ0FBY0wsV0FBVTtnQ0FBUU0sS0FBSTtnQ0FBR0ssT0FBTztvQ0FBQ0MsT0FBTTtnQ0FBRTtnQ0FBR0YsU0FBU1o7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFNcEc7R0FoRE1UOztRQUNlTCxvREFBV0E7UUFDTkMsb0RBQVdBO1FBRXJCQSxvREFBV0E7OztLQUpyQkk7QUFrRE4sK0RBQWVBLE1BQU1BLEVBQUEiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vY29tcG9uZW50cy9OYXZCYXIuanM/ZWI5MSJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgTGluayBmcm9tICduZXh0L2xpbmsnO1xyXG5pbXBvcnQgUmVhY3QsIHt1c2VTdGF0ZX0gZnJvbSAncmVhY3QnO1xyXG5pbXBvcnQgeyB1c2VFZmZlY3QgfSBmcm9tICdyZWFjdCc7XHJcbmltcG9ydCBNb2RhbCBmcm9tICdyZWFjdC1tb2RhbCc7XHJcbmltcG9ydCB7dXNlRGlzcGF0Y2gsIHVzZVNlbGVjdG9yfSBmcm9tICdyZWFjdC1yZWR1eCc7XHJcbmltcG9ydCB7IGxvZ291dFJlcXVlc3RBY3Rpb24gfSBmcm9tICcuLi9yZWR1Y2Vycy91c2VyJztcclxuaW1wb3J0IE5ld1Bvc3QgZnJvbSAnLi9OZXdQb3N0JztcclxuaW1wb3J0IE5ld1Bvc3RUZXh0IGZyb20gJy4vTmV3UG9zdFRleHQnXHJcblxyXG5jb25zdCBOYXZCYXIgPSAoKSA9PiB7XHJcbiAgICBjb25zdCBkaXNwYXRjaCA9IHVzZURpc3BhdGNoKCk7XHJcbiAgICBjb25zdCB7Y2xlYXJVcGxvYWR9ID0gdXNlU2VsZWN0b3IoKHN0YXRlKSA9PiBzdGF0ZS5tYWlucGFnZSk7XHJcbiAgICBjb25zdCBbbmV3UG9zdE9wZW4sIHNldE5ld1Bvc3RdID0gdXNlU3RhdGUoZmFsc2UpO1xyXG4gICAgY29uc3R7bWV9ID0gdXNlU2VsZWN0b3IoKHN0YXRlKSA9PiBzdGF0ZS51c2VyKTtcclxuICAgIGNvbnN0IGxvZ091dCA9ICgpID0+IHtcclxuICAgICAgICBkaXNwYXRjaChsb2dvdXRSZXF1ZXN0QWN0aW9uKCkpO1xyXG4gICAgfVxyXG4gICAgXHJcbiAgICB1c2VFZmZlY3QoKCkgPT4ge1xyXG4gICAgICAgIGlmKGNsZWFyVXBsb2FkKSBzZXROZXdQb3N0KGZhbHNlKTtcclxuICAgIH0sIFtjbGVhclVwbG9hZF0pXHJcbiAgICBcclxuICAgIHJldHVybihcclxuICAgICAgICA8bmF2IGNsYXNzTmFtZT1cIm5hdmJhclwiPlxyXG4gICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT1cIm5hdi13cmFwcGVyXCI+XHJcbiAgICAgICAgICAgICAgICA8TGluayBocmVmID0gJy8nIGxlZ2FjeUJlaGF2aW9yPlxyXG4gICAgICAgICAgICAgICAgICAgIDxpbWcgc3JjPVwiL2xvZ28uUE5HXCIgY2xhc3NOYW1lPVwiYnJhbmQtaW1nXCIgYWx0PVwiXCIgLz5cclxuICAgICAgICAgICAgICAgIDwvTGluaz5cclxuICAgICAgICAgICAgICAgIDxpbnB1dCB0eXBlPVwidGV4dFwiIGNsYXNzTmFtZT1cInNlYXJjaC1ib3hcIiBwbGFjZWhvbGRlcj1cInNlYXJjaFwiIC8+XHJcbiAgICAgICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT1cIm5hdi1pdGVtc1wiPlxyXG4gICAgICAgICAgICAgICAgICAgIDxMaW5rIGhyZWYgPSAnLycgbGVnYWN5QmVoYXZpb3I+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIDxpbWcgc3JjPVwiL2hvbWUuUE5HXCIgY2xhc3NOYW1lPVwiaWNvblwiIGFsdD1cIlwiIC8+XHJcbiAgICAgICAgICAgICAgICAgICAgPC9MaW5rPlxyXG4gICAgICAgICAgICAgICAgICAgIDxpbWcgc3JjPVwiL2FkZC5QTkdcIiBvbkNsaWNrPXsoKSA9PiBzZXROZXdQb3N0KHRydWUpfSBjbGFzc05hbWU9XCJpY29uXCIgYWx0PVwiXCIgLz5cclxuICAgICAgICAgICAgICAgICAgICA8aW1nIHNyYz1cIi9saWtlLlBOR1wiIGNsYXNzTmFtZT1cImljb25cIiBhbHQ9XCJcIiAvPlxyXG4gICAgICAgICAgICAgICAgICAgIDxMaW5rIGhyZWYgPSAnL3Byb2ZpbGUnIGxlZ2FjeUJlaGF2aW9yPlxyXG4gICAgICAgICAgICAgICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT1cImljb24gdXNlci1wcm9maWxlXCI+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8ZGl2IGNsYXNzTmFtZT0ncHJvZmlsZS1waWMnIHN0eWxlPXt7d2lkdGg6MjIsIGhlaWdodDoyMiwgZGlzcGxheTonaW5saW5lLWJsb2NrJywgcGFkZGluZzogMFxyXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgLGN1cnNvcjoncG9pbnRlcid9fT5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICA8aW1nIHNyYz17bWUucHJvZmlsZWltYWdlfSBhbHQgLz5cclxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgICAgICAgICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICAgICAgICAgICAgICA8L0xpbms+XHJcblxyXG4gICAgICAgICAgICAgICAgICAgIDxNb2RhbCBpc09wZW49e25ld1Bvc3RPcGVufSBvblJlcXVlc3RDbG9zZT17KCk9PnNldE5ld1Bvc3QoZmFsc2UpfVxyXG4gICAgICAgICAgICAgICAgICAgICAgICBzdHlsZT17e2NvbnRlbnQ6e2xlZnQ6XCIyMCVcIiwgcmlnaHQ6XCIyMCVcIiwgcGFkZGluZzowLCBib3JkZXJSYWRpdXM6MTN9fX1cclxuICAgICAgICAgICAgICAgICAgICA+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIDxOZXdQb3N0Lz5cclxuICAgICAgICAgICAgICAgICAgICA8L01vZGFsPlxyXG5cclxuICAgICAgICAgICAgICAgICAgICA8TGluayBocmVmID0gXCIvXCIgbGVnYWN5QmVoYXZpb3I+XHJcbiAgICAgICAgICAgICAgICAgICAgICAgIDxpbWcgc3JjPVwiL2xvZ291dC5QTkdcIiBjbGFzc05hbWU9J2ljb24nICBhbHQ9XCJcIiBzdHlsZT17e3dpZHRoOjI1fX0gb25DbGljaz17bG9nT3V0fS8+XHJcbiAgICAgICAgICAgICAgICAgICAgPC9MaW5rPlxyXG4gICAgICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgIDwvbmF2PlxyXG4gICAgKTtcclxufVxyXG5cclxuZXhwb3J0IGRlZmF1bHQgTmF2QmFyIl0sIm5hbWVzIjpbIkxpbmsiLCJSZWFjdCIsInVzZVN0YXRlIiwidXNlRWZmZWN0IiwiTW9kYWwiLCJ1c2VEaXNwYXRjaCIsInVzZVNlbGVjdG9yIiwibG9nb3V0UmVxdWVzdEFjdGlvbiIsIk5ld1Bvc3QiLCJOZXdQb3N0VGV4dCIsIk5hdkJhciIsImRpc3BhdGNoIiwiY2xlYXJVcGxvYWQiLCJzdGF0ZSIsIm1haW5wYWdlIiwibmV3UG9zdE9wZW4iLCJzZXROZXdQb3N0IiwibWUiLCJ1c2VyIiwibG9nT3V0IiwibmF2IiwiY2xhc3NOYW1lIiwiZGl2IiwiaHJlZiIsImxlZ2FjeUJlaGF2aW9yIiwiaW1nIiwic3JjIiwiYWx0IiwiaW5wdXQiLCJ0eXBlIiwicGxhY2Vob2xkZXIiLCJvbkNsaWNrIiwic3R5bGUiLCJ3aWR0aCIsImhlaWdodCIsImRpc3BsYXkiLCJwYWRkaW5nIiwiY3Vyc29yIiwicHJvZmlsZWltYWdlIiwiaXNPcGVuIiwib25SZXF1ZXN0Q2xvc2UiLCJjb250ZW50IiwibGVmdCIsInJpZ2h0IiwiYm9yZGVyUmFkaXVzIl0sInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///./components/NavBar.js\n"));

/***/ })

});