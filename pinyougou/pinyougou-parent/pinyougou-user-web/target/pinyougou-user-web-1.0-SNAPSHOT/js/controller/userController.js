/**
 * 创建controller
 */
app.controller("userController",function ($scope,userService) {

    //验证码
    $scope.createCode=function () {
        userService.createCode($scope.entity.phone).success(function (response) {

            alert(response.message);
        })
    }

    //注册
    $scope.register=function () {
        userService.register($scope.entity,$scope.code).success(function (response) {

            alert(response.message);
        })
    }
});