/**
 * 创建服务层
 * @type
 */
app.service("contentService", function ($http) {

    this.findByCategoryId = function (categoryId) {
        return $http.post("/content/findByCategoryId.shtml?categoryId=" + categoryId)
    }
})