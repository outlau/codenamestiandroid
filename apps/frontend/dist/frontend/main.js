(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "../../node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "../../node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _components_home_home_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/home/home.component */ "./src/app/components/home/home.component.ts");




var routes = [
    { path: '', component: _components_home_home_component__WEBPACK_IMPORTED_MODULE_3__["HomeComponent"] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\r\n"

/***/ }),

/***/ "./src/app/app.component.scss":
/*!************************************!*\
  !*** ./src/app/app.component.scss ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuc2NzcyJ9 */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "../../node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'frontend';
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.scss */ "./src/app/app.component.scss")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "../../node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "../../node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "../../node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _components_home_home_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/home/home.component */ "./src/app/components/home/home.component.ts");







var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"],
                _components_home_home_component__WEBPACK_IMPORTED_MODULE_6__["HomeComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/components/home/home.component.html":
/*!*****************************************************!*\
  !*** ./src/app/components/home/home.component.html ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"!_started && loaded\" [ngClass]=\"{'loaded':loaded}\" class=\"container text-center\">\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12\">\r\n      <h1>14-02-2019 12:00</h1>\r\n    </div>\r\n  </div>\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12\">\r\n      <p class=\"lead sti\" [ngClass]=\"{'big_text':bigSti}\" style=\"font-style: italic\">\r\n        Sti\r\n      </p>\r\n      <p class=\"lead\">\r\n        My heart beats for you\r\n      </p>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div id=\"fireworksContainer\">\r\n\r\n</div>\r\n\r\n<div *ngIf=\"!_countdownEnded && loaded\" [ngClass]=\"{'loaded':loaded}\" class=\"container text-center actual-container\" id=\"error\">\r\n  <svg class=\"heart\"\r\n    version=\"1.1\"\r\n    id=\"Capa_1\"\r\n    xmlns=\"http://www.w3.org/2000/svg\"\r\n    xmlns:xlink=\"http://www.w3.org/1999/xlink\"\r\n    x=\"0px\"\r\n    y=\"0px\"\r\n    viewBox=\"0 0 50 50\"\r\n    style=\"enable-background:new 0 0 50 50;\"\r\n    xml:space=\"preserve\"\r\n  >\r\n    <path\r\n      style=\"fill:#D75A4A;\"\r\n      d=\"M24.85,10.126c2.018-4.783,6.628-8.125,11.99-8.125c7.223,0,12.425,6.179,13.079,13.543\r\n\tc0,0,0.353,1.828-0.424,5.119c-1.058,4.482-3.545,8.464-6.898,11.503L24.85,48L7.402,32.165c-3.353-3.038-5.84-7.021-6.898-11.503\r\n\tc-0.777-3.291-0.424-5.119-0.424-5.119C0.734,8.179,5.936,2,13.159,2C18.522,2,22.832,5.343,24.85,10.126z\"\r\n    />\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n  </svg>\r\n\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12\">\r\n      <div class=\"main-icon text-success\"><span class=\"uxicon uxicon-clock-refresh\"></span></div>\r\n      <h1>What will the future bring? </h1>\r\n      <p class=\"lead\">You will see in</p>\r\n      <p class=\"lead\">\r\n        <strong *ngIf=\"_days\"> {{ _days }}d </strong>\r\n        <strong *ngIf=\"_hours\"> {{ _hours }}h </strong>\r\n        <strong *ngIf=\"_minutes\"> {{ _minutes }}m </strong>\r\n        <strong *ngIf=\"_seconds\"> {{ _seconds }}s </strong>\r\n      </p>\r\n    </div>\r\n  </div>\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12\">\r\n      <p class=\"lead\" style=\"font-style: italic\">\r\n        {{quote}}\r\n      </p>\r\n      <p class=\"lead\" style=\"font-size: 11px\">\r\n        {{subText}}\r\n      </p>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n\r\n<div *ngIf=\"_countdownEnded && loaded\" [ngClass]=\"{'loaded':loaded}\" class=\"container text-center actual-container\" id=\"error\">\r\n  <svg class=\"heart\"\r\n    version=\"1.1\"\r\n    id=\"Capa_1\"\r\n    xmlns=\"http://www.w3.org/2000/svg\"\r\n    xmlns:xlink=\"http://www.w3.org/1999/xlink\"\r\n    x=\"0px\"\r\n    y=\"0px\"\r\n    viewBox=\"0 0 50 50\"\r\n    style=\"enable-background:new 0 0 50 50;\"\r\n    xml:space=\"preserve\"\r\n  >\r\n    <path\r\n      style=\"fill:#D75A4A;\"\r\n      d=\"M24.85,10.126c2.018-4.783,6.628-8.125,11.99-8.125c7.223,0,12.425,6.179,13.079,13.543\r\n\tc0,0,0.353,1.828-0.424,5.119c-1.058,4.482-3.545,8.464-6.898,11.503L24.85,48L7.402,32.165c-3.353-3.038-5.84-7.021-6.898-11.503\r\n\tc-0.777-3.291-0.424-5.119-0.424-5.119C0.734,8.179,5.936,2,13.159,2C18.522,2,22.832,5.343,24.85,10.126z\"\r\n    />\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n    <g></g>\r\n  </svg>\r\n\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12\">\r\n      <div class=\"main-icon text-success\"><span class=\"uxicon uxicon-clock-refresh\"></span></div>\r\n      <h1>The future is here</h1>\r\n      <p class=\"lead\"><i>Boyfriend</i> has officially launched</p>\r\n    </div>\r\n  </div>\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12\">\r\n      <p class=\"lead\" style=\"font-style: italic\">\r\n        Download here\r\n      </p>\r\n\r\n      <a href=\"/api/boyfriend\" class=\"lead\" style=\"font-style: italic\">\r\n\r\n        Click\r\n      </a>\r\n    </div>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/components/home/home.component.scss":
/*!*****************************************************!*\
  !*** ./src/app/components/home/home.component.scss ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "body, h1, p {\n  font-family: \"Helvetica Neue\", \"Segoe UI\", Segoe, Helvetica, Arial, \"Lucida Grande\", sans-serif;\n  font-weight: normal;\n  margin: 0;\n  padding: 0;\n  text-align: center; }\n\n.container {\n  margin-left: auto;\n  margin-right: auto;\n  margin-top: 77px;\n  max-width: 1170px;\n  padding-right: 15px;\n  padding-left: 15px;\n  opacity: 0;\n  -webkit-animation: fadein 2s;\n  /* Safari, Chrome and Opera > 12.1 */\n  /* Firefox < 16 */\n  /* Internet Explorer */\n  /* Opera < 12.1 */\n  animation: fadein 2s; }\n\n@keyframes fadein {\n  from {\n    opacity: 0; }\n  to {\n    opacity: 1; } }\n\n/* Firefox < 16 */\n\n/* Safari, Chrome and Opera > 12.1 */\n\n@-webkit-keyframes fadein {\n  from {\n    opacity: 0; }\n  to {\n    opacity: 1; } }\n\n/* Internet Explorer */\n\n/* Opera < 12.1 */\n\n.loaded {\n  opacity: 1 !important; }\n\n.row:before, .row:after {\n  display: table;\n  content: \" \"; }\n\nh1 {\n  font-size: 48px;\n  font-weight: 300;\n  margin: 0 0 20px 0; }\n\n.lead {\n  font-size: 21px;\n  font-weight: 200;\n  margin: 20px; }\n\np {\n  margin: 0 0 10px; }\n\na {\n  color: #3282e6;\n  text-decoration: none; }\n\nhtml, body {\n  height: 100%; }\n\n* {\n  -moz-box-sizing: border-box; }\n\nbody {\n  background-color: #ededed;\n  color: #424242;\n  margin: 0;\n  font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\n  font-size: 14px;\n  line-height: 1.428571429; }\n\nh1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {\n  font-family: \"HelveticaNeue-Light\",\"Helvetica Neue Light\",\"Helvetica Neue\",Helvetica,Arial,\"Lucida Grande\",sans-serif;\n  font-weight: normal;\n  line-height: 1.1;\n  color: #333; }\n\nh1 small, h2 small, h3 small, h4 small, h5 small, h6 small, .h1 small, .h2 small, .h3 small, .h4 small, .h5 small, .h6 small {\n  font-weight: normal;\n  line-height: 1; }\n\nh1, .h1 {\n  font-size: 45px;\n  line-height: 48px; }\n\nh2, .h2 {\n  font-size: 36px;\n  line-height: 42px; }\n\nh3, .h3 {\n  font-size: 28px;\n  line-height: 36px; }\n\nh4, .h4 {\n  font-size: 24px;\n  line-height: 25px; }\n\nh5, .h5 {\n  font-size: 20px;\n  line-height: 24px; }\n\nh6, .h6 {\n  font-size: 18px;\n  line-height: 24px; }\n\na {\n  color: #3282e6; }\n\na:hover, a:focus {\n  color: #165db5;\n  text-decoration: underline; }\n\n.text-center {\n  text-align: center; }\n\n.wrap {\n  min-height: 100%;\n  display: table;\n  height: 100%; }\n\n.top-bar {\n  height: 20px;\n  background: #71a100;\n  background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzcxYTEwMCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiM2ZmExMDAiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);\n  background: linear-gradient(to bottom, #71a100 0%, #6fa100 100%);\n  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#71a100', endColorstr='#6fa100',GradientType=0 ); }\n\n.welcome-container {\n  width: 500px;\n  margin: 0 auto;\n  overflow: auto;\n  padding-bottom: 60px; }\n\n.coming-soon-wrap {\n  margin-top: 90px; }\n\n.frowny-face {\n  text-align: center;\n  font-size: 130px;\n  color: #919191;\n  line-height: 1.1;\n  margin-top: 90px;\n  margin-bottom: 70px; }\n\n.welcome-container h1 {\n  margin-bottom: 1em; }\n\n.btn-primary {\n  background-color: #7FB141;\n  border-color: #648C33;\n  color: #FFFFFF; }\n\ninput, button, select, textarea {\n  font-family: inherit;\n  font-size: inherit;\n  line-height: inherit; }\n\nbutton, html input[type=\"button\"], input[type=\"reset\"], input[type=\"submit\"] {\n  cursor: pointer; }\n\nbutton, select {\n  text-transform: none; }\n\nbutton, input {\n  line-height: normal; }\n\nbutton, input, select, textarea {\n  font-family: inherit;\n  font-size: 100%;\n  margin: 0; }\n\n.btn {\n  -moz-border-bottom-colors: none;\n  -moz-border-left-colors: none;\n  -moz-border-right-colors: none;\n  -moz-border-top-colors: none;\n  border-color: transparent;\n  -o-border-image: none;\n     border-image: none;\n  border-radius: 0 0 0 0;\n  border-style: solid;\n  border-width: 0 0 3px;\n  cursor: pointer;\n  display: inline-block;\n  font-size: 14px;\n  font-weight: 300;\n  line-height: 1.42857;\n  margin-bottom: 0;\n  padding: 8px 20px;\n  text-align: center;\n  vertical-align: middle;\n  white-space: nowrap;\n  text-decoration: none; }\n\n.btn-primary {\n  background-color: #7FB141;\n  border-color: #648C33;\n  color: #FFFFFF; }\n\n.btn-primary:hover,\n.btn-primary:focus,\n.btn-primary:active,\n.btn-primary.active {\n  background-color: #729E3A;\n  border-color: #496626;\n  color: #fff; }\n\n.btn:hover,\n.btn:focus {\n  text-decoration: none; }\n\n.login-container {\n  text-align: right;\n  margin: 20px; }\n\n.footer {\n  position: relative;\n  margin-top: -60px;\n  /* negative value of footer height */\n  height: 60px;\n  clear: both;\n  text-align: center;\n  font-size: 14px; }\n\n.heart {\n  width: 50px;\n  height: 50px;\n  transition: .5s all; }\n\n.heart:hover {\n  width: 80px;\n  height: 80px; }\n\n.big_text {\n  font-size: 50px;\n  opacity: 1; }\n\n.sti {\n  transition: 3s all;\n  opacity: .5; }\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9ob21lL0Q6XFxDb2RlIFByb2plY3RzXFxjb2RlbmFtZXN0aVxcYXBwc1xcZnJvbnRlbmQvc3JjXFxhcHBcXGNvbXBvbmVudHNcXGhvbWVcXGhvbWUuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBR0E7RUFDRSwrRkFBK0Y7RUFDL0YsbUJBQW1CO0VBQ25CLFNBQVM7RUFDVCxVQUFVO0VBQ1Ysa0JBQWtCLEVBQUE7O0FBR3BCO0VBQ0UsaUJBQWtCO0VBQ2xCLGtCQUFtQjtFQUNuQixnQkFBZ0I7RUFDaEIsaUJBQWlCO0VBQ2pCLG1CQUFtQjtFQUNuQixrQkFBa0I7RUFDbEIsVUFBVTtFQUNWLDRCQUE0QjtFQUFFLG9DQUFBO0VBQ0gsaUJBQUE7RUFDRCxzQkFBQTtFQUNELGlCQUFBO0VBQ3pCLG9CQUFvQixFQUFBOztBQUd0QjtFQUNFO0lBQU8sVUFBVSxFQUFBO0VBQ2pCO0lBQU8sVUFBVSxFQUFBLEVBQUE7O0FBR25CLGlCQUFBOztBQU1BLG9DQUFBOztBQUNBO0VBQ0U7SUFBTyxVQUFVLEVBQUE7RUFDakI7SUFBTyxVQUFVLEVBQUEsRUFBQTs7QUFHbkIsc0JBQUE7O0FBTUEsaUJBQUE7O0FBU0E7RUFDRSxxQkFBcUIsRUFBQTs7QUFHdkI7RUFDRSxjQUFjO0VBQ2QsWUFBWSxFQUFBOztBQUdkO0VBQ0UsZUFBZTtFQUNmLGdCQUFnQjtFQUNoQixrQkFBa0IsRUFBQTs7QUFHcEI7RUFDRSxlQUFlO0VBQ2YsZ0JBQWdCO0VBQ2hCLFlBQVksRUFBQTs7QUFHZDtFQUNFLGdCQUFnQixFQUFBOztBQUdsQjtFQUNFLGNBQWM7RUFDZCxxQkFBcUIsRUFBQTs7QUFHdkI7RUFDRSxZQUFZLEVBQUE7O0FBR2Q7RUFDRSwyQkFBMkIsRUFBQTs7QUFHN0I7RUFDRSx5QkFBeUI7RUFDekIsY0FBYztFQUNkLFNBQVM7RUFDVCx3REFBdUQ7RUFDdkQsZUFBYztFQUNkLHdCQUF1QixFQUFBOztBQUd6QjtFQUEwQyxxSEFBb0g7RUFBQyxtQkFBa0I7RUFBQyxnQkFBZTtFQUFDLFdBQVUsRUFBQTs7QUFBQztFQUFrSCxtQkFBa0I7RUFBQyxjQUFhLEVBQUE7O0FBQy9WO0VBQU8sZUFBYztFQUFDLGlCQUFnQixFQUFBOztBQUN0QztFQUFPLGVBQWM7RUFBQyxpQkFBZ0IsRUFBQTs7QUFDdEM7RUFBTyxlQUFjO0VBQUMsaUJBQWdCLEVBQUE7O0FBQ3RDO0VBQU8sZUFBYztFQUFDLGlCQUFnQixFQUFBOztBQUN0QztFQUFPLGVBQWM7RUFBQyxpQkFBZ0IsRUFBQTs7QUFDdEM7RUFBTyxlQUFjO0VBQUMsaUJBQWdCLEVBQUE7O0FBRXRDO0VBQUUsY0FBYSxFQUFBOztBQUNmO0VBQWdCLGNBQWE7RUFBQywwQkFBeUIsRUFBQTs7QUFFdkQ7RUFBYSxrQkFBaUIsRUFBQTs7QUFFOUI7RUFDRSxnQkFBZ0I7RUFDaEIsY0FBYztFQUNkLFlBQVksRUFBQTs7QUFHZDtFQUNFLFlBQVk7RUFDWixtQkFBbUI7RUFDbkIsbXFCQUFtcUI7RUFNbnFCLGdFQUFnRTtFQUNoRSxtSEFBbUgsRUFBQTs7QUFHckg7RUFDRSxZQUFZO0VBQ1osY0FBYztFQUNkLGNBQWM7RUFDZCxvQkFBb0IsRUFBQTs7QUFHdEI7RUFDRSxnQkFBZ0IsRUFBQTs7QUFHbEI7RUFDRSxrQkFBa0I7RUFDbEIsZ0JBQWdCO0VBQ2hCLGNBQWM7RUFDZCxnQkFBZ0I7RUFDaEIsZ0JBQWdCO0VBQ2hCLG1CQUFtQixFQUFBOztBQUdyQjtFQUNFLGtCQUFrQixFQUFBOztBQUdwQjtFQUNFLHlCQUF5QjtFQUN6QixxQkFBcUI7RUFDckIsY0FBYyxFQUFBOztBQUdoQjtFQUNFLG9CQUFvQjtFQUNwQixrQkFBa0I7RUFDbEIsb0JBQW9CLEVBQUE7O0FBRXRCO0VBQ0UsZUFBZSxFQUFBOztBQUVqQjtFQUNFLG9CQUFvQixFQUFBOztBQUV0QjtFQUNFLG1CQUFtQixFQUFBOztBQUVyQjtFQUNFLG9CQUFvQjtFQUNwQixlQUFlO0VBQ2YsU0FBUyxFQUFBOztBQUdYO0VBQ0UsK0JBQStCO0VBQy9CLDZCQUE2QjtFQUM3Qiw4QkFBOEI7RUFDOUIsNEJBQTRCO0VBQzVCLHlCQUF5QjtFQUN6QixxQkFBa0I7S0FBbEIsa0JBQWtCO0VBQ2xCLHNCQUFzQjtFQUN0QixtQkFBbUI7RUFDbkIscUJBQXFCO0VBQ3JCLGVBQWU7RUFDZixxQkFBcUI7RUFDckIsZUFBZTtFQUNmLGdCQUFnQjtFQUNoQixvQkFBb0I7RUFDcEIsZ0JBQWdCO0VBQ2hCLGlCQUFpQjtFQUNqQixrQkFBa0I7RUFDbEIsc0JBQXNCO0VBQ3RCLG1CQUFtQjtFQUNuQixxQkFBcUIsRUFBQTs7QUFHdkI7RUFDRSx5QkFBeUI7RUFDekIscUJBQXFCO0VBQ3JCLGNBQWMsRUFBQTs7QUFJaEI7Ozs7RUFJRSx5QkFBeUI7RUFDekIscUJBQXFCO0VBQ3JCLFdBQVcsRUFBQTs7QUFHYjs7RUFFRSxxQkFBcUIsRUFBQTs7QUFHdkI7RUFDRSxpQkFBaUI7RUFDakIsWUFBWSxFQUFBOztBQUdkO0VBQ0Usa0JBQWtCO0VBQ2xCLGlCQUFpQjtFQUFFLG9DQUFBO0VBQ25CLFlBQVk7RUFDWixXQUFVO0VBQ1Ysa0JBQWtCO0VBQ2xCLGVBQWUsRUFBQTs7QUFHakI7RUFDRSxXQUFVO0VBQ1YsWUFBVztFQUNYLG1CQUFtQixFQUFBOztBQUVyQjtFQUNFLFdBQVU7RUFDVixZQUFXLEVBQUE7O0FBT2I7RUFDRSxlQUFjO0VBQ2QsVUFBVSxFQUFBOztBQUVaO0VBQ0Usa0JBQWtCO0VBQ2xCLFdBQVcsRUFBQSIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvaG9tZS9ob21lLmNvbXBvbmVudC5zY3NzIiwic291cmNlc0NvbnRlbnQiOlsiYm9keSB7XHJcbn1cclxuXHJcbmJvZHksIGgxLCBwIHtcclxuICBmb250LWZhbWlseTogXCJIZWx2ZXRpY2EgTmV1ZVwiLCBcIlNlZ29lIFVJXCIsIFNlZ29lLCBIZWx2ZXRpY2EsIEFyaWFsLCBcIkx1Y2lkYSBHcmFuZGVcIiwgc2Fucy1zZXJpZjtcclxuICBmb250LXdlaWdodDogbm9ybWFsO1xyXG4gIG1hcmdpbjogMDtcclxuICBwYWRkaW5nOiAwO1xyXG4gIHRleHQtYWxpZ246IGNlbnRlcjtcclxufVxyXG5cclxuLmNvbnRhaW5lciB7XHJcbiAgbWFyZ2luLWxlZnQ6ICBhdXRvO1xyXG4gIG1hcmdpbi1yaWdodDogIGF1dG87XHJcbiAgbWFyZ2luLXRvcDogNzdweDtcclxuICBtYXgtd2lkdGg6IDExNzBweDtcclxuICBwYWRkaW5nLXJpZ2h0OiAxNXB4O1xyXG4gIHBhZGRpbmctbGVmdDogMTVweDtcclxuICBvcGFjaXR5OiAwO1xyXG4gIC13ZWJraXQtYW5pbWF0aW9uOiBmYWRlaW4gMnM7IC8qIFNhZmFyaSwgQ2hyb21lIGFuZCBPcGVyYSA+IDEyLjEgKi9cclxuICAtbW96LWFuaW1hdGlvbjogZmFkZWluIDJzOyAvKiBGaXJlZm94IDwgMTYgKi9cclxuICAtbXMtYW5pbWF0aW9uOiBmYWRlaW4gMnM7IC8qIEludGVybmV0IEV4cGxvcmVyICovXHJcbiAgLW8tYW5pbWF0aW9uOiBmYWRlaW4gMnM7IC8qIE9wZXJhIDwgMTIuMSAqL1xyXG4gIGFuaW1hdGlvbjogZmFkZWluIDJzO1xyXG59XHJcblxyXG5Aa2V5ZnJhbWVzIGZhZGVpbiB7XHJcbiAgZnJvbSB7IG9wYWNpdHk6IDA7IH1cclxuICB0byAgIHsgb3BhY2l0eTogMTsgfVxyXG59XHJcblxyXG4vKiBGaXJlZm94IDwgMTYgKi9cclxuQC1tb3ota2V5ZnJhbWVzIGZhZGVpbiB7XHJcbiAgZnJvbSB7IG9wYWNpdHk6IDA7IH1cclxuICB0byAgIHsgb3BhY2l0eTogMTsgfVxyXG59XHJcblxyXG4vKiBTYWZhcmksIENocm9tZSBhbmQgT3BlcmEgPiAxMi4xICovXHJcbkAtd2Via2l0LWtleWZyYW1lcyBmYWRlaW4ge1xyXG4gIGZyb20geyBvcGFjaXR5OiAwOyB9XHJcbiAgdG8gICB7IG9wYWNpdHk6IDE7IH1cclxufVxyXG5cclxuLyogSW50ZXJuZXQgRXhwbG9yZXIgKi9cclxuQC1tcy1rZXlmcmFtZXMgZmFkZWluIHtcclxuICBmcm9tIHsgb3BhY2l0eTogMDsgfVxyXG4gIHRvICAgeyBvcGFjaXR5OiAxOyB9XHJcbn1cclxuXHJcbi8qIE9wZXJhIDwgMTIuMSAqL1xyXG5ALW8ta2V5ZnJhbWVzIGZhZGVpbiB7XHJcbiAgZnJvbSB7IG9wYWNpdHk6IDA7IH1cclxuICB0byAgIHsgb3BhY2l0eTogMTsgfVxyXG59XHJcblxyXG4uYWN0dWFsLWNvbnRhaW5lcntcclxufVxyXG5cclxuLmxvYWRlZCB7XHJcbiAgb3BhY2l0eTogMSAhaW1wb3J0YW50O1xyXG59XHJcblxyXG4ucm93OmJlZm9yZSwgLnJvdzphZnRlciB7XHJcbiAgZGlzcGxheTogdGFibGU7XHJcbiAgY29udGVudDogXCIgXCI7XHJcbn1cclxuXHJcbmgxIHtcclxuICBmb250LXNpemU6IDQ4cHg7XHJcbiAgZm9udC13ZWlnaHQ6IDMwMDtcclxuICBtYXJnaW46IDAgMCAyMHB4IDA7XHJcbn1cclxuXHJcbi5sZWFkIHtcclxuICBmb250LXNpemU6IDIxcHg7XHJcbiAgZm9udC13ZWlnaHQ6IDIwMDtcclxuICBtYXJnaW46IDIwcHg7XHJcbn1cclxuXHJcbnAge1xyXG4gIG1hcmdpbjogMCAwIDEwcHg7XHJcbn1cclxuXHJcbmEge1xyXG4gIGNvbG9yOiAjMzI4MmU2O1xyXG4gIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcclxufVxyXG5cclxuaHRtbCxib2R5IHtcclxuICBoZWlnaHQ6IDEwMCU7XHJcbn1cclxuXHJcbioge1xyXG4gIC1tb3otYm94LXNpemluZzogYm9yZGVyLWJveDtcclxufVxyXG5cclxuYm9keSB7XHJcbiAgYmFja2dyb3VuZC1jb2xvcjogI2VkZWRlZDtcclxuICBjb2xvcjogIzQyNDI0MjtcclxuICBtYXJnaW46IDA7XHJcbiAgZm9udC1mYW1pbHk6XCJIZWx2ZXRpY2EgTmV1ZVwiLEhlbHZldGljYSxBcmlhbCxzYW5zLXNlcmlmO1xyXG4gIGZvbnQtc2l6ZToxNHB4O1xyXG4gIGxpbmUtaGVpZ2h0OjEuNDI4NTcxNDI5O1xyXG59XHJcblxyXG5oMSxoMixoMyxoNCxoNSxoNiwuaDEsLmgyLC5oMywuaDQsLmg1LC5oNntmb250LWZhbWlseTpcIkhlbHZldGljYU5ldWUtTGlnaHRcIixcIkhlbHZldGljYSBOZXVlIExpZ2h0XCIsXCJIZWx2ZXRpY2EgTmV1ZVwiLEhlbHZldGljYSxBcmlhbCxcIkx1Y2lkYSBHcmFuZGVcIixzYW5zLXNlcmlmO2ZvbnQtd2VpZ2h0Om5vcm1hbDtsaW5lLWhlaWdodDoxLjE7Y29sb3I6IzMzM31oMSBzbWFsbCxoMiBzbWFsbCxoMyBzbWFsbCxoNCBzbWFsbCxoNSBzbWFsbCxoNiBzbWFsbCwuaDEgc21hbGwsLmgyIHNtYWxsLC5oMyBzbWFsbCwuaDQgc21hbGwsLmg1IHNtYWxsLC5oNiBzbWFsbHtmb250LXdlaWdodDpub3JtYWw7bGluZS1oZWlnaHQ6MX1cclxuaDEsLmgxe2ZvbnQtc2l6ZTo0NXB4O2xpbmUtaGVpZ2h0OjQ4cHh9XHJcbmgyLC5oMntmb250LXNpemU6MzZweDtsaW5lLWhlaWdodDo0MnB4fVxyXG5oMywuaDN7Zm9udC1zaXplOjI4cHg7bGluZS1oZWlnaHQ6MzZweH1cclxuaDQsLmg0e2ZvbnQtc2l6ZToyNHB4O2xpbmUtaGVpZ2h0OjI1cHh9XHJcbmg1LC5oNXtmb250LXNpemU6MjBweDtsaW5lLWhlaWdodDoyNHB4fVxyXG5oNiwuaDZ7Zm9udC1zaXplOjE4cHg7bGluZS1oZWlnaHQ6MjRweH1cclxuXHJcbmF7Y29sb3I6IzMyODJlNjt9XHJcbmE6aG92ZXIsYTpmb2N1c3tjb2xvcjojMTY1ZGI1O3RleHQtZGVjb3JhdGlvbjp1bmRlcmxpbmV9XHJcblxyXG4udGV4dC1jZW50ZXJ7dGV4dC1hbGlnbjpjZW50ZXJ9XHJcblxyXG4ud3JhcCB7XHJcbiAgbWluLWhlaWdodDogMTAwJTtcclxuICBkaXNwbGF5OiB0YWJsZTtcclxuICBoZWlnaHQ6IDEwMCU7XHJcbn1cclxuXHJcbi50b3AtYmFyIHtcclxuICBoZWlnaHQ6IDIwcHg7XHJcbiAgYmFja2dyb3VuZDogIzcxYTEwMDtcclxuICBiYWNrZ3JvdW5kOiB1cmwoZGF0YTppbWFnZS9zdmcreG1sO2Jhc2U2NCxQRDk0Yld3Z2RtVnljMmx2YmowaU1TNHdJaUEvUGdvOGMzWm5JSGh0Ykc1elBTSm9kSFJ3T2k4dmQzZDNMbmN6TG05eVp5OHlNREF3TDNOMlp5SWdkMmxrZEdnOUlqRXdNQ1VpSUdobGFXZG9kRDBpTVRBd0pTSWdkbWxsZDBKdmVEMGlNQ0F3SURFZ01TSWdjSEpsYzJWeWRtVkJjM0JsWTNSU1lYUnBiejBpYm05dVpTSStDaUFnUEd4cGJtVmhja2R5WVdScFpXNTBJR2xrUFNKbmNtRmtMWFZqWjJjdFoyVnVaWEpoZEdWa0lpQm5jbUZrYVdWdWRGVnVhWFJ6UFNKMWMyVnlVM0JoWTJWUGJsVnpaU0lnZURFOUlqQWxJaUI1TVQwaU1DVWlJSGd5UFNJd0pTSWdlVEk5SWpFd01DVWlQZ29nSUNBZ1BITjBiM0FnYjJabWMyVjBQU0l3SlNJZ2MzUnZjQzFqYjJ4dmNqMGlJemN4WVRFd01DSWdjM1J2Y0MxdmNHRmphWFI1UFNJeElpOCtDaUFnSUNBOGMzUnZjQ0J2Wm1aelpYUTlJakV3TUNVaUlITjBiM0F0WTI5c2IzSTlJaU0yWm1FeE1EQWlJSE4wYjNBdGIzQmhZMmwwZVQwaU1TSXZQZ29nSUR3dmJHbHVaV0Z5UjNKaFpHbGxiblErQ2lBZ1BISmxZM1FnZUQwaU1DSWdlVDBpTUNJZ2QybGtkR2c5SWpFaUlHaGxhV2RvZEQwaU1TSWdabWxzYkQwaWRYSnNLQ05uY21Ga0xYVmpaMmN0WjJWdVpYSmhkR1ZrS1NJZ0x6NEtQQzl6ZG1jKyk7XHJcbiAgYmFja2dyb3VuZDogLW1vei1saW5lYXItZ3JhZGllbnQodG9wLCAgIzcxYTEwMCAwJSwgIzZmYTEwMCAxMDAlKTtcclxuICBiYWNrZ3JvdW5kOiAtd2Via2l0LWdyYWRpZW50KGxpbmVhciwgbGVmdCB0b3AsIGxlZnQgYm90dG9tLCBjb2xvci1zdG9wKDAlLCM3MWExMDApLCBjb2xvci1zdG9wKDEwMCUsIzZmYTEwMCkpO1xyXG4gIGJhY2tncm91bmQ6IC13ZWJraXQtbGluZWFyLWdyYWRpZW50KHRvcCwgICM3MWExMDAgMCUsIzZmYTEwMCAxMDAlKTtcclxuICBiYWNrZ3JvdW5kOiAtby1saW5lYXItZ3JhZGllbnQodG9wLCAgIzcxYTEwMCAwJSwjNmZhMTAwIDEwMCUpO1xyXG4gIGJhY2tncm91bmQ6IC1tcy1saW5lYXItZ3JhZGllbnQodG9wLCAgIzcxYTEwMCAwJSwjNmZhMTAwIDEwMCUpO1xyXG4gIGJhY2tncm91bmQ6IGxpbmVhci1ncmFkaWVudCh0byBib3R0b20sICAjNzFhMTAwIDAlLCM2ZmExMDAgMTAwJSk7XHJcbiAgZmlsdGVyOiBwcm9naWQ6RFhJbWFnZVRyYW5zZm9ybS5NaWNyb3NvZnQuZ3JhZGllbnQoIHN0YXJ0Q29sb3JzdHI9JyM3MWExMDAnLCBlbmRDb2xvcnN0cj0nIzZmYTEwMCcsR3JhZGllbnRUeXBlPTAgKTtcclxufVxyXG5cclxuLndlbGNvbWUtY29udGFpbmVyIHtcclxuICB3aWR0aDogNTAwcHg7XHJcbiAgbWFyZ2luOiAwIGF1dG87XHJcbiAgb3ZlcmZsb3c6IGF1dG87XHJcbiAgcGFkZGluZy1ib3R0b206IDYwcHg7XHJcbn1cclxuXHJcbi5jb21pbmctc29vbi13cmFwIHtcclxuICBtYXJnaW4tdG9wOiA5MHB4O1xyXG59XHJcblxyXG4uZnJvd255LWZhY2Uge1xyXG4gIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICBmb250LXNpemU6IDEzMHB4O1xyXG4gIGNvbG9yOiAjOTE5MTkxO1xyXG4gIGxpbmUtaGVpZ2h0OiAxLjE7XHJcbiAgbWFyZ2luLXRvcDogOTBweDtcclxuICBtYXJnaW4tYm90dG9tOiA3MHB4O1xyXG59XHJcblxyXG4ud2VsY29tZS1jb250YWluZXIgaDEge1xyXG4gIG1hcmdpbi1ib3R0b206IDFlbTtcclxufVxyXG5cclxuLmJ0bi1wcmltYXJ5IHtcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiAjN0ZCMTQxO1xyXG4gIGJvcmRlci1jb2xvcjogIzY0OEMzMztcclxuICBjb2xvcjogI0ZGRkZGRjtcclxufVxyXG5cclxuaW5wdXQsIGJ1dHRvbiwgc2VsZWN0LCB0ZXh0YXJlYSB7XHJcbiAgZm9udC1mYW1pbHk6IGluaGVyaXQ7XHJcbiAgZm9udC1zaXplOiBpbmhlcml0O1xyXG4gIGxpbmUtaGVpZ2h0OiBpbmhlcml0O1xyXG59XHJcbmJ1dHRvbiwgaHRtbCBpbnB1dFt0eXBlPVwiYnV0dG9uXCJdLCBpbnB1dFt0eXBlPVwicmVzZXRcIl0sIGlucHV0W3R5cGU9XCJzdWJtaXRcIl0ge1xyXG4gIGN1cnNvcjogcG9pbnRlcjtcclxufVxyXG5idXR0b24sIHNlbGVjdCB7XHJcbiAgdGV4dC10cmFuc2Zvcm06IG5vbmU7XHJcbn1cclxuYnV0dG9uLCBpbnB1dCB7XHJcbiAgbGluZS1oZWlnaHQ6IG5vcm1hbDtcclxufVxyXG5idXR0b24sIGlucHV0LCBzZWxlY3QsIHRleHRhcmVhIHtcclxuICBmb250LWZhbWlseTogaW5oZXJpdDtcclxuICBmb250LXNpemU6IDEwMCU7XHJcbiAgbWFyZ2luOiAwO1xyXG59XHJcblxyXG4uYnRuIHtcclxuICAtbW96LWJvcmRlci1ib3R0b20tY29sb3JzOiBub25lO1xyXG4gIC1tb3otYm9yZGVyLWxlZnQtY29sb3JzOiBub25lO1xyXG4gIC1tb3otYm9yZGVyLXJpZ2h0LWNvbG9yczogbm9uZTtcclxuICAtbW96LWJvcmRlci10b3AtY29sb3JzOiBub25lO1xyXG4gIGJvcmRlci1jb2xvcjogdHJhbnNwYXJlbnQ7XHJcbiAgYm9yZGVyLWltYWdlOiBub25lO1xyXG4gIGJvcmRlci1yYWRpdXM6IDAgMCAwIDA7XHJcbiAgYm9yZGVyLXN0eWxlOiBzb2xpZDtcclxuICBib3JkZXItd2lkdGg6IDAgMCAzcHg7XHJcbiAgY3Vyc29yOiBwb2ludGVyO1xyXG4gIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICBmb250LXNpemU6IDE0cHg7XHJcbiAgZm9udC13ZWlnaHQ6IDMwMDtcclxuICBsaW5lLWhlaWdodDogMS40Mjg1NztcclxuICBtYXJnaW4tYm90dG9tOiAwO1xyXG4gIHBhZGRpbmc6IDhweCAyMHB4O1xyXG4gIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICB2ZXJ0aWNhbC1hbGlnbjogbWlkZGxlO1xyXG4gIHdoaXRlLXNwYWNlOiBub3dyYXA7XHJcbiAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xyXG59XHJcblxyXG4uYnRuLXByaW1hcnkge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM3RkIxNDE7XHJcbiAgYm9yZGVyLWNvbG9yOiAjNjQ4QzMzO1xyXG4gIGNvbG9yOiAjRkZGRkZGO1xyXG59XHJcblxyXG5cclxuLmJ0bi1wcmltYXJ5OmhvdmVyLFxyXG4uYnRuLXByaW1hcnk6Zm9jdXMsXHJcbi5idG4tcHJpbWFyeTphY3RpdmUsXHJcbi5idG4tcHJpbWFyeS5hY3RpdmUge1xyXG4gIGJhY2tncm91bmQtY29sb3I6ICM3MjlFM0E7XHJcbiAgYm9yZGVyLWNvbG9yOiAjNDk2NjI2O1xyXG4gIGNvbG9yOiAjZmZmO1xyXG59XHJcblxyXG4uYnRuOmhvdmVyLFxyXG4uYnRuOmZvY3VzIHtcclxuICB0ZXh0LWRlY29yYXRpb246IG5vbmU7XHJcbn1cclxuXHJcbi5sb2dpbi1jb250YWluZXIge1xyXG4gIHRleHQtYWxpZ246IHJpZ2h0O1xyXG4gIG1hcmdpbjogMjBweDtcclxufVxyXG5cclxuLmZvb3RlciB7XHJcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gIG1hcmdpbi10b3A6IC02MHB4OyAvKiBuZWdhdGl2ZSB2YWx1ZSBvZiBmb290ZXIgaGVpZ2h0ICovXHJcbiAgaGVpZ2h0OiA2MHB4O1xyXG4gIGNsZWFyOmJvdGg7XHJcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gIGZvbnQtc2l6ZTogMTRweDtcclxufVxyXG5cclxuLmhlYXJ0e1xyXG4gIHdpZHRoOjUwcHg7XHJcbiAgaGVpZ2h0OjUwcHg7XHJcbiAgdHJhbnNpdGlvbjogLjVzIGFsbDtcclxufVxyXG4uaGVhcnQ6aG92ZXJ7XHJcbiAgd2lkdGg6ODBweDtcclxuICBoZWlnaHQ6ODBweDtcclxufVxyXG5cclxuXHJcblxyXG5cclxuXHJcbi5iaWdfdGV4dHtcclxuICBmb250LXNpemU6NTBweDtcclxuICBvcGFjaXR5OiAxO1xyXG59XHJcbi5zdGl7XHJcbiAgdHJhbnNpdGlvbjogM3MgYWxsO1xyXG4gIG9wYWNpdHk6IC41O1xyXG59XHJcbiJdfQ== */"

/***/ }),

/***/ "./src/app/components/home/home.component.ts":
/*!***************************************************!*\
  !*** ./src/app/components/home/home.component.ts ***!
  \***************************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "../../node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "../../node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "../../node_modules/rxjs/_esm5/operators/index.js");




var HomeComponent = /** @class */ (function () {
    function HomeComponent() {
        this.loaded = false;
        this._countdownEnded = false;
        this.quotes = [
            "Heaven is close when Blitzi is near",
            "The love of Blitzi heals",
            "When all else fails, Blitzi is there",
            "Where there is a Blitzi, there is love",
            "No boyfriend is complete without his Blitzi",
            "Blitzi is life, Blitzi is love, Blitzi is happiness",
            "Where there is a Blitzi, there is a way",
            "No love is more powerful than the love of a Blitzi",
            "A Blitzi a day keeps the doctors away",
        ];
    }
    HomeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this._countdownEnds = "2019-02-23:16:00";
        // this._countdownEnds = "2019-02-23:14:44";
        this._countdownStarts = "2019-02-14:12:00";
        this._diff = Date.parse(this._countdownEnds) - Date.parse(new Date().toString());
        this._startDiff = Date.parse(this._countdownStarts) - Date.parse(new Date().toString());
        this._started = true;
        this._days = this.getDays(this._diff);
        this._hours = this.getHours(this._diff);
        this._minutes = this.getMinutes(this._diff);
        this._seconds = this.getSeconds(this._diff);
        this.quote = this.quotes[this._days];
        Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["interval"])(1000).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["map"])(function (x) {
            _this._diff = Date.parse(_this._countdownEnds) - Date.parse(new Date().toString());
            _this._startDiff = Date.parse(_this._countdownStarts) - Date.parse(new Date().toString());
        })).subscribe(function () {
            console.log(_this._diff);
            _this.loaded = true;
            if (_this._startDiff > 0) {
                _this._started = false;
                return;
            }
            if (_this._diff < 0) {
                _this._countdownEnded = true;
                return;
            }
            if (_this._days == 0) {
                _this.subText = "Come back tomorrow for a sorpresa";
            }
            else {
                _this.subText = "Come back tomorrow for a new Blitzi quote of the day";
            }
            _this._started = true;
            _this._days = _this.getDays(_this._diff);
            _this._hours = _this.getHours(_this._diff);
            _this._minutes = _this.getMinutes(_this._diff);
            _this._seconds = _this.getSeconds(_this._diff);
            _this.quote = _this.quotes[_this._days];
        });
        Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["interval"])(2000).subscribe(function () { return _this.bigSti = !_this.bigSti; });
    };
    HomeComponent.prototype.getDays = function (t) {
        return Math.floor(t / (1000 * 60 * 60 * 24));
    };
    HomeComponent.prototype.getHours = function (t) {
        return Math.floor((t / (1000 * 60 * 60)) % 24);
    };
    HomeComponent.prototype.getMinutes = function (t) {
        return Math.floor((t / 1000 / 60) % 60);
    };
    HomeComponent.prototype.getSeconds = function (t) {
        return Math.floor((t / 1000) % 60);
    };
    HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: "app-home",
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/components/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.scss */ "./src/app/components/home/home.component.scss")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "../../node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "../../node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\Code Projects\codenamesti\apps\frontend\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map