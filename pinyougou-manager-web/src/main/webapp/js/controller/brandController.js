// 品牌控制层
app.controller('brandController', function ($scope, $controller, brandService) {

    // 伪继承
    $controller('baseController', {$scope: $scope});

    // 查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
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