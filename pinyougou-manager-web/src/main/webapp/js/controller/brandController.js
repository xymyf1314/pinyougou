// 品牌控制层
app.controller('brandController', function ($scope, $http, brandService) {

    // 查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
    };
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
    // 分页方法
    $scope.findPage = function (page, size) {
        brandService.findPage(page, size).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    // 新增和修改品牌
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null) {
            object = brandService.update($scope.entity);
        } else {
            object = brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();// 刷新页面
                } else {
                    $scope.reloadList();// 刷新页面
                    alert(response.message);// 弹出错误信息
                }
            }
        );
    };

    // 查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    // 删除方法
    //用户勾选复选框
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

    $scope.del = function () {
        brandService.del($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();// 刷新页面
                } else {
                    $scope.reloadList();// 刷新页面
                    alert(response.message);// 弹出错误信息
                }
            }
        );
    };

    // 条件查询
    $scope.searchEntity = {};
    $scope.search = function (page, size) {
        brandService.search(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;// 显示当前页面数据
                $scope.paginationConf.totalItems = response.total;// 更新总记录数
            }
        );
    };

});