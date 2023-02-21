app.controller('sellerLoginController',function ($scope,sellerLoginService) {

    //调用查询用户名的方法
    $scope.login=function () {
        sellerLoginService.login().success(function (response) {
            $scope.username=response;
        });
    }
});