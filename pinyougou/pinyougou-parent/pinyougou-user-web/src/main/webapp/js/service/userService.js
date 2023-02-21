/**
 * 创建service
 */
app.service("userService",function ($http) {

    /**
     *创建验证码
     * @param phone
     */
    this.createCode=function (phone) {
        return $http.get("/user/code.shtml?phone="+phone)
    }
    /**
     * 注册功能
     * @param entity
     */
    this.register=function (entity,code) {
        return $http.post("/user/add.shtml?code="+code,entity)
    }
});