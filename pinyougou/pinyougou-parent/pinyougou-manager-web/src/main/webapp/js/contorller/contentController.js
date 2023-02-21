/*****
 * 定义一个控制层 controller
 * 发送HTTP请求从后台获取数据
 ****/
app.controller("contentController",function($scope,$http,$controller,contentService,uploadService,contentCategoryService){

    //继承父控制器
    $controller("baseController",{$scope:$scope});

    $scope.status=['无效','有效'];

    $scope.categoryNameList={};

    //图片上传
    $scope.uploadFile=function () {
        uploadService.uploadFile().success(function (response) {
            if (response.success){
                $scope.entity.pic=response.message;
            }else{
                alert(response.message)
            }
        }).error(function () {
            alert("上传发生错误")
        })
    }

    //查询所有广告分类列表
    $scope.findAllList=function () {
        contentCategoryService.findAllList().success(function (response) {
            $scope.categoryList=response;
            for(var i= 0;i<response.length;i++){
                var key = response[i].id;
                var value = response[i].name;

                $scope.categoryNameList[key]=value;
            }
        })
    }

    //获取所有的Content信息
    $scope.getPage=function(page,size){
        //发送请求获取数据
        contentService.findAll(page,size,$scope.searchEntity).success(function(response){
            //集合数据
            $scope.list = response.list;
            //分页数据
            $scope.paginationConf.totalItems=response.total;
        });
    }

    //添加或者修改方法
    $scope.save = function(){
        var result = null;
        if($scope.entity.id!=null){
            //执行修改数据
            result = contentService.update($scope.entity);
        }else{
            //增加操作
            result = contentService.add($scope.entity);
        }
        //判断操作流程
        result.success(function(response){
            //判断执行状态
            if(response.success){
                //重新加载新的数据
                $scope.reloadList();
            }else{
                //打印错误消息
                alert(response.message);
            }
        });
    }

    //根据ID查询信息
    $scope.getById=function(id){
        contentService.findOne(id).success(function(response){
            //将后台的数据绑定到前台
            $scope.entity=response;
        });
    }

    //批量删除
    $scope.delete=function(){
        contentService.delete($scope.selectids).success(function(response){
            //判断删除状态
            if(response.success){
                $scope.reloadList();
            }else{
                alert(response.message);
            }
        });
    }
});
