app.controller("searchController", function ($scope,$location, searchService ) {

    //定义一个数据，用于存储选择的筛选条件
    $scope.searchMap = {"keyword": "", "category": "", "brand": "", spec: {}, "price": "", "pageNum": 1, "size": 10, "sort": "", "sortFiled": ""};

    $scope.resultMap = {brandList: []};

    //加载关键字
    $scope.loadKeyword = function (){
        var keyword = $location.search()['keyword'];

        if(keyword != null){
            $scope.searchMap.keyword = keyword;
        }
        $scope.search();
    };

    //搜索品牌
    $scope.keywordsLoadBrand = function () {
        if ($scope.resultMap.brandList != null) {
            for (var i = 0; i < $scope.resultMap.brandList.length; i++) {

                var brandName = $scope.resultMap.brandList[i].text;
                var index = $scope.searchMap.keyword.indexOf(brandName);

                if (index >= 0) {
                    $scope.searchMap.brand = brandName;
                    return true;
                }
            }
        }
        return false;
    };


    //排序搜索
    $scope.sortSearch = function (sort, sortFiled) {
        $scope.searchMap.sort = sort;
        $scope.searchMap.sortFiled = sortFiled;

        $scope.search();
    };

    //搜索条件移除实现
    $scope.removeItemSearch = function (key) {
        if (key == 'category' || key == 'brand' || key == 'price') {
            $scope.searchMap[key] = '';
        } else {
            //将数据从map结构中移除
            delete $scope.searchMap.spec[key];
        }

        //搜索实现
        $scope.search();
    };

    //点击搜索条件的时候，将选中的搜索条件记录
    $scope.addItemSearch = function (key, value) {
        if (key == 'category' || key == 'brand' || key == 'price') {
            $scope.searchMap[key] = value;
        } else {
            $scope.searchMap.spec[key] = value;
        }


        //搜索实现
        $scope.search();
    };
    //搜索方法
    $scope.search = function () {
        searchService.search($scope.searchMap).success(function (response) {
            $scope.resultMap = response;

            $scope.pageHandler(response.total, $scope.searchMap.pageNum)
        });
    };

    //分页搜索
    $scope.pageSearch = function (pageNum) {
        if (!isNaN(pageNum) && pageNum > 0) {
            $scope.searchMap.pageNum = parseInt(pageNum);
        }
        if ($scope.searchMap.pageNum > $scope.page.totalPage) {
            $scope.searchMap.pageNum = $scope.page.totalPage
        }
        if (isNaN(pageNum)) {
            $scope.searchMap.pageNum = 1;
        }
        $scope.search();
    };

    //分页定义
    $scope.page = {
        size: 10,        //每页显示多少条
        total: 0,        //总共有多少条记录
        pageNum: 1,      //当前页
        offset: 1,       //偏移量
        lpage: 1,        //起始页
        rpage: 1,        //结束页
        totalPage: 1,    //总页数
        pages: [],       //页码
        nextPage: 1,     //下一页
        prePage: 1,       //上一页
        hasPre: 0,       //是否有上页
        hasNext: 0       //是否有下页
    };

    $scope.pageHandler = function (total, pageNum) {
        var size = $scope.page.size;
        $scope.page.pageNum = pageNum;
        $scope.page.total = total;
        var offset = $scope.page.offset;
        var lpage = $scope.page.lpage;
        var rpage = $scope.page.rpage;
        var totalPage = total % size == 0 ? total / size : parseInt(total / size) + 1;
        $scope.page.totalPage = totalPage;

        if (pageNum - offset > 0) {
            lpage = pageNum - offset;
            rpage = pageNum + offset;
        }
        if (pageNum - offset <= 0) {
            lpage = 1;
            rpage = pageNum + offset + (Math.abs(pageNum - offset) + 1);
        }
        if (rpage > totalPage) {
            lpage = lpage - (rpage - totalPage);
            rpage = totalPage;
        }
        if (lpage <= 0) {
            lpage = 1;
        }
        //添加分页集合
        $scope.page.pages = [];
        for (var i = lpage; i <= rpage; i++) {
            $scope.page.pages.push(i);
        }
        //数据源存入$scope.page中
        $scope.page.lpage = lpage;
        $scope.page.rpage = rpage;
        //上一页
        $scope.page.prePage = (pageNum - 1) > 0 ? pageNum - 1 : 1;
        //下一页
        $scope.page.nextPage = (pageNum + 1) <= totalPage ? pageNum + 1 : totalPage;

        $scope.page.hasPre = (pageNum - 1) > 0 ? 1 : 0;
        $scope.page.hasNext = (pageNum + 1) <= totalPage ? 1 : 0;
    }

});