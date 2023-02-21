/***
 * 创建一个服务层
 * 抽取发送请求的一部分代码
 * */
app.service("addressService",function($http){


    //增加Address
    this.add=function(entity){
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
