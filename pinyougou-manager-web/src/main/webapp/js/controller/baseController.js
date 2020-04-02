app.controller('baseController', function ($scope) {

    // 分页控件配置 currentPage 当前页码  totalItems总记录数 itemsPerPage每页记录数 perPageOptions分页选项
    // onChange 当页码改变后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    // 刷新页面
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    // 用户勾选复选框
    $scope.selectIds = [];// 用户勾选的id集合
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id); // push 方法向集合中添加元素
        } else {
            var index = $scope.selectIds.indexOf(id);//查找值的位置
            $scope.selectIds.splice(index, 1)//参数1：移除的位置，参数2：移除的个数
        }
        // console.log($scope.selectIds);
    };

});