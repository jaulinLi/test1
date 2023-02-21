/**
 * 创建service
 */
app.service("cartService",function ($http) {

    //添加订单
    this.addOrder=function (order) {
        return $http.post("/order/add.shtml",order)
    }
    //展示地址列表
    this.findAddressList=function () {
        return $http.get("/address/user/list.shtml")
    }

    //查询购物车数据
    this.findCartList=function () {
        return $http.get("/cart/list.shtml")
    }

    //加入购物车
    this.add=function (itemId, num) {
        return $http.get("/cart/add.shtml?itemid="+itemId+"&num="+num)
    }

    //以下为地址
    //增加Address
    this.addAddress=function(entity){
        return $http.post("/address/add.shtml",entity);
    }

    //保存
    this.update=function(entity){
        return $http.post("/address/update.shtml",entity);
    }

    //根据ID查询
    this.findOne=function(id){
        return $http.get("/address/"+id+".shtml");
    }

    //批量删除
    this.delete=function(id){
        return $http.get("/address/delete/"+id+".shtml");
    }

});