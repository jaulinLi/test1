app.service('sellerLoginService',function ($http) {

    //获取用户登录名
    this.login=function () {
        return $http.get('/sellerlogin/name.shtml');
    }

})