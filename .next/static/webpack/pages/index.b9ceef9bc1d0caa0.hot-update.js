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

/***/ "./components/Mainpage.js":
/*!********************************!*\
  !*** ./components/Mainpage.js ***!
  \********************************/
/***/ (function(module, __webpack_exports__, __webpack_require__) {

eval(__webpack_require__.ts("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"./node_modules/react/jsx-dev-runtime.js\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var _AppLayout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./AppLayout */ \"./components/AppLayout.js\");\n/* harmony import */ var _Story_StoryForm__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./Story/StoryForm */ \"./components/Story/StoryForm.js\");\n/* harmony import */ var _Mainpost_MainPosts__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./Mainpost/MainPosts */ \"./components/Mainpost/MainPosts.js\");\n/* harmony import */ var _MainSide_Recommend__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./MainSide/Recommend */ \"./components/MainSide/Recommend.js\");\n/* harmony import */ var react_redux__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react-redux */ \"./node_modules/react-redux/es/index.js\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! react */ \"./node_modules/react/index.js\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_6___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_6__);\n\nvar _s = $RefreshSig$();\n\n\n\n\n\n\nconst Mainpage = ()=>{\n    _s();\n    const dispatch = (0,react_redux__WEBPACK_IMPORTED_MODULE_5__.useDispatch)();\n    const { postList  } = (0,react_redux__WEBPACK_IMPORTED_MODULE_5__.useSelector)((state)=>state.mainpage);\n    console.losg(postList);\n    (0,react__WEBPACK_IMPORTED_MODULE_6__.useEffect)(()=>{\n        dispatch({\n            type: \"MAIN_PAGE_REQUEST\"\n        });\n    }, postList);\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.Fragment, {\n        children: [\n            /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_AppLayout__WEBPACK_IMPORTED_MODULE_1__[\"default\"], {}, void 0, false, {\n                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                lineNumber: 16,\n                columnNumber: 9\n            }, undefined),\n            /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"section\", {\n                className: \"main\",\n                children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                    className: \"wrapper\",\n                    children: [\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            className: \"left-col\",\n                            children: [\n                                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_Story_StoryForm__WEBPACK_IMPORTED_MODULE_2__[\"default\"], {}, void 0, false, {\n                                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                                    lineNumber: 20,\n                                    columnNumber: 21\n                                }, undefined),\n                                /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_Mainpost_MainPosts__WEBPACK_IMPORTED_MODULE_3__[\"default\"], {}, void 0, false, {\n                                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                                    lineNumber: 21,\n                                    columnNumber: 21\n                                }, undefined)\n                            ]\n                        }, void 0, true, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                            lineNumber: 19,\n                            columnNumber: 17\n                        }, undefined),\n                        /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n                            className: \"right-col\",\n                            children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(_MainSide_Recommend__WEBPACK_IMPORTED_MODULE_4__[\"default\"], {}, void 0, false, {\n                                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                                lineNumber: 24,\n                                columnNumber: 21\n                            }, undefined)\n                        }, void 0, false, {\n                            fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                            lineNumber: 23,\n                            columnNumber: 17\n                        }, undefined)\n                    ]\n                }, void 0, true, {\n                    fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                    lineNumber: 18,\n                    columnNumber: 13\n                }, undefined)\n            }, void 0, false, {\n                fileName: \"C:\\\\Users\\\\dbtjd\\\\smilegate_front\\\\front\\\\components\\\\Mainpage.js\",\n                lineNumber: 17,\n                columnNumber: 9\n            }, undefined)\n        ]\n    }, void 0, true);\n};\n_s(Mainpage, \"B2Ks/uZL63Sl3obPh+Hsl8ae9x8=\", false, function() {\n    return [\n        react_redux__WEBPACK_IMPORTED_MODULE_5__.useDispatch,\n        react_redux__WEBPACK_IMPORTED_MODULE_5__.useSelector\n    ];\n});\n_c = Mainpage;\n/* harmony default export */ __webpack_exports__[\"default\"] = (Mainpage);\nvar _c;\n$RefreshReg$(_c, \"Mainpage\");\n\n\n;\n    // Wrapped in an IIFE to avoid polluting the global scope\n    ;\n    (function () {\n        var _a, _b;\n        // Legacy CSS implementations will `eval` browser code in a Node.js context\n        // to extract CSS. For backwards compatibility, we need to check we're in a\n        // browser context before continuing.\n        if (typeof self !== 'undefined' &&\n            // AMP / No-JS mode does not inject these helpers:\n            '$RefreshHelpers$' in self) {\n            // @ts-ignore __webpack_module__ is global\n            var currentExports = module.exports;\n            // @ts-ignore __webpack_module__ is global\n            var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;\n            // This cannot happen in MainTemplate because the exports mismatch between\n            // templating and execution.\n            self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.id);\n            // A module can be accepted automatically based on its exports, e.g. when\n            // it is a Refresh Boundary.\n            if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {\n                // Save the previous exports on update so we can compare the boundary\n                // signatures.\n                module.hot.dispose(function (data) {\n                    data.prevExports = currentExports;\n                });\n                // Unconditionally accept an update to this module, we'll check if it's\n                // still a Refresh Boundary later.\n                // @ts-ignore importMeta is replaced in the loader\n                module.hot.accept();\n                // This field is set when the previous version of this module was a\n                // Refresh Boundary, letting us know we need to check for invalidation or\n                // enqueue an update.\n                if (prevExports !== null) {\n                    // A boundary can become ineligible if its exports are incompatible\n                    // with the previous exports.\n                    //\n                    // For example, if you add/remove/change exports, we'll want to\n                    // re-execute the importing modules, and force those components to\n                    // re-render. Similarly, if you convert a class component to a\n                    // function, we want to invalidate the boundary.\n                    if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {\n                        module.hot.invalidate();\n                    }\n                    else {\n                        self.$RefreshHelpers$.scheduleUpdate();\n                    }\n                }\n            }\n            else {\n                // Since we just executed the code for the module, it's possible that the\n                // new exports made it ineligible for being a boundary.\n                // We only care about the case when we were _previously_ a boundary,\n                // because we already accepted this update (accidental side effect).\n                var isNoLongerABoundary = prevExports !== null;\n                if (isNoLongerABoundary) {\n                    module.hot.invalidate();\n                }\n            }\n        }\n    })();\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9jb21wb25lbnRzL01haW5wYWdlLmpzLmpzIiwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7OztBQUFvQztBQUNNO0FBQ0c7QUFDQTtBQUNVO0FBQ1I7QUFDL0MsTUFBTVEsV0FBVyxJQUFNOztJQUNuQixNQUFNQyxXQUFXTCx3REFBV0E7SUFDNUIsTUFBTSxFQUFDTSxTQUFRLEVBQUMsR0FBR0wsd0RBQVdBLENBQUMsQ0FBQ00sUUFBVUEsTUFBTUMsUUFBUTtJQUN4REMsUUFBUUMsSUFBSSxDQUFDSjtJQUNiSCxnREFBU0EsQ0FBQyxJQUFNO1FBQ1pFLFNBQVM7WUFBQ00sTUFBTTtRQUFtQjtJQUN2QyxHQUFFTDtJQUNGLHFCQUNJOzswQkFDQSw4REFBQ1Ysa0RBQVNBOzs7OzswQkFDViw4REFBQ2dCO2dCQUFRQyxXQUFVOzBCQUNmLDRFQUFDQztvQkFBSUQsV0FBVTs7c0NBQ1gsOERBQUNDOzRCQUFJRCxXQUFVOzs4Q0FDWCw4REFBQ2hCLHdEQUFTQTs7Ozs7OENBQ1YsOERBQUNDLDJEQUFTQTs7Ozs7Ozs7Ozs7c0NBRWQsOERBQUNnQjs0QkFBSUQsV0FBVTtzQ0FDWCw0RUFBQ2QsMkRBQVNBOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7OztBQU05QjtHQXZCTUs7O1FBQ2VKLG9EQUFXQTtRQUNUQyxvREFBV0E7OztLQUY1Qkc7QUF5Qk4sK0RBQWVBLFFBQVFBLEVBQUMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vY29tcG9uZW50cy9NYWlucGFnZS5qcz80Y2RjIl0sInNvdXJjZXNDb250ZW50IjpbImltcG9ydCBBcHBMYXlvdXQgZnJvbSBcIi4vQXBwTGF5b3V0XCI7XHJcbmltcG9ydCBTdG9yeUZvcm0gZnJvbSBcIi4vU3RvcnkvU3RvcnlGb3JtXCI7XHJcbmltcG9ydCBNYWluUG9zdHMgZnJvbSBcIi4vTWFpbnBvc3QvTWFpblBvc3RzXCI7XHJcbmltcG9ydCBSZWNvbW1lbmQgZnJvbSBcIi4vTWFpblNpZGUvUmVjb21tZW5kXCI7XHJcbmltcG9ydCB7IHVzZURpc3BhdGNoLCB1c2VTZWxlY3RvciB9IGZyb20gXCJyZWFjdC1yZWR1eFwiO1xyXG5pbXBvcnQgeyB1c2VDYWxsYmFjaywgdXNlRWZmZWN0IH0gZnJvbSBcInJlYWN0XCI7XHJcbmNvbnN0IE1haW5wYWdlID0gKCkgPT4ge1xyXG4gICAgY29uc3QgZGlzcGF0Y2ggPSB1c2VEaXNwYXRjaCgpO1xyXG4gICAgY29uc3Qge3Bvc3RMaXN0fSA9IHVzZVNlbGVjdG9yKChzdGF0ZSkgPT4gc3RhdGUubWFpbnBhZ2UpO1xyXG4gICAgY29uc29sZS5sb3NnKHBvc3RMaXN0KTtcclxuICAgIHVzZUVmZmVjdCgoKSA9PiB7XHJcbiAgICAgICAgZGlzcGF0Y2goe3R5cGU6ICdNQUlOX1BBR0VfUkVRVUVTVCd9KTtcclxuICAgIH0scG9zdExpc3QpXHJcbiAgICByZXR1cm4oXHJcbiAgICAgICAgPD5cclxuICAgICAgICA8QXBwTGF5b3V0Lz5cclxuICAgICAgICA8c2VjdGlvbiBjbGFzc05hbWU9XCJtYWluXCI+XHJcbiAgICAgICAgICAgIDxkaXYgY2xhc3NOYW1lPVwid3JhcHBlclwiPlxyXG4gICAgICAgICAgICAgICAgPGRpdiBjbGFzc05hbWU9XCJsZWZ0LWNvbFwiPlxyXG4gICAgICAgICAgICAgICAgICAgIDxTdG9yeUZvcm0gLz5cclxuICAgICAgICAgICAgICAgICAgICA8TWFpblBvc3RzIC8+XHJcbiAgICAgICAgICAgICAgICA8L2Rpdj5cclxuICAgICAgICAgICAgICAgIDxkaXYgY2xhc3NOYW1lPVwicmlnaHQtY29sXCI+XHJcbiAgICAgICAgICAgICAgICAgICAgPFJlY29tbWVuZCAvPlxyXG4gICAgICAgICAgICAgICAgPC9kaXY+XHJcbiAgICAgICAgICAgIDwvZGl2PlxyXG4gICAgICAgIDwvc2VjdGlvbj5cclxuICAgICAgICA8Lz5cclxuICAgICk7XHJcbn1cclxuXHJcbmV4cG9ydCBkZWZhdWx0IE1haW5wYWdlOyJdLCJuYW1lcyI6WyJBcHBMYXlvdXQiLCJTdG9yeUZvcm0iLCJNYWluUG9zdHMiLCJSZWNvbW1lbmQiLCJ1c2VEaXNwYXRjaCIsInVzZVNlbGVjdG9yIiwidXNlQ2FsbGJhY2siLCJ1c2VFZmZlY3QiLCJNYWlucGFnZSIsImRpc3BhdGNoIiwicG9zdExpc3QiLCJzdGF0ZSIsIm1haW5wYWdlIiwiY29uc29sZSIsImxvc2ciLCJ0eXBlIiwic2VjdGlvbiIsImNsYXNzTmFtZSIsImRpdiJdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./components/Mainpage.js\n"));

/***/ })

});