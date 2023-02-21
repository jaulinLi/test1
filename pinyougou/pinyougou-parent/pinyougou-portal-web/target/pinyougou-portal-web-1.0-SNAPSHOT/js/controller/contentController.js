/**
 * 创建控制层
 */
app.controller("contentController", function ($scope, contentService) {

    //查询首页广告
    $scope.contentList = {};
    $scope.findByCategoryId = function (categoryId) {

        contentService.findByCategoryId(categoryId).success(function (response) {

            $scope.contentList[categoryId] = response;

        })
    }

    //搜索跳转
    $scope.search=function (){
        location.href= "http://localhost:18087/search.html?keyword="+$scope.keyword;
    }
});