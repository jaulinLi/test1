//创建angularjs模块
var app = angular.module('pinyougou',[]);

app.config(['$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode(true);
}]);