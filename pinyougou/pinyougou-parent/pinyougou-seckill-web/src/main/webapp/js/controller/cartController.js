/*
* 创建controller
* */
app.controller("cartController",function ($scope, cartService) {

    //定义用户地址别名
    $scope.alias=['家里','父母家','公司'];

    //定义支付类型
    $scope.order={paymentType:'1'};

    //增加订单
    $scope.addOrder=function () {
        cartService.addOrder($scope.order).success(function (response) {

            $scope.order.receiverAreaName=$scope.address.address;
            $scope.order.receiver=$scope.address.contact;
            $scope.order.receiverMobile=$scope.address.mobile;

            if (response.success){
                //页面跳转
                if($scope.order.paymentType=='1'){//如果是微信支付，跳转到支付页面
                    location.href="pay.html";
                }else{//如果货到付款，跳转到提示页面
                    location.href="paysuccess.html";
                }
            } else {
                alert(response.message);
            }
        })
    }

    //切换支付类型
    $scope.selectPaymentType=function (paymentType) {
        $scope.order.paymentType=paymentType;
    }

    //显示地址别名
    $scope.selectAlias=function (index) {
        $scope.entity.alias=$scope.alias[index];
    }

    //添加或者修改地址方法
    $scope.save = function(){
        var result = null;
        if($scope.entity.id!=null){
            //执行修改数据
            result = cartService.update($scope.entity);
        }else{
            //增加操作
            result = cartService.addAddress($scope.entity);
        }
        //判断操作流程
        result.success(function(response){
            //判断执行状态
            if(response.success){
                //重新加载新的数据
                $scope.findAddressList();
            }else{
                //打印错误消息
                alert(response.message);
            }
        });
    }

    //根据ID查询地址信息
    $scope.getById=function(id){
        cartService.findOne(id).success(function(response){
            //将后台的数据绑定到前台
            $scope.entity=response;
        });
    }

    //删除地址
    $scope.delete=function (id) {
        cartService.delete(id).success(function (response) {
            //判断执行状态
            if(response.success){
                //重新加载新的数据
                $scope.findAddressList();
            }else{
                //打印错误消息
                alert(response.message);
            }
        });
    }

    //选择地址 记录用户收货地址
    $scope.selectAddress=function (address) {
        $scope.address=address;
    }

    //查找地址列表
    $scope.findAddressList=function () {
        cartService.findAddressList().success(function (response) {
            $scope.addressList=response;

            for (var i= 0;i<$scope.addressList.length;i++){

                if ($scope.addressList[i].isDefault=='1'){
                    $scope.address=angular.copy($scope.addressList[i]);
                }
            }
        })
    }

    //查找购物车列表
    $scope.findCartList=function () {
        cartService.findCartList().success(function (response) {
            $scope.cartList=response;

            sum($scope.cartList)
        })
    }

    //添加购物车
    $scope.add=function (itemId, num) {
        cartService.add(itemId, num).success(function (response) {
            if(response.success){
                $scope.findCartList();
            } else {
                alert(response.message)
            }
        })
    }

    //总金额和总件数计算
    sum = function (cartList) {
        $scope.totalValue={totalNum:0,totalMoney:0.0};
        for(var i=0;i<cartList.length;i++){

            var orderItemList = cartList[i].orderItemList;

            for (var j=0;j<orderItemList.length;j++){
                $scope.totalValue.totalNum+=orderItemList[j].num;

                $scope.totalValue.totalMoney+=orderItemList[j].totalFee;
            }
        }
    }
});
