angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_rate: $scope.filter ? $scope.filter.min_rate : null,
                max_rate: $scope.filter ? $scope.filter.max_rate : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data.content;
        });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changeRate = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_rate',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.Filter = function (min, max) {
        console.log($scope.filter);
        $http({
            url: contextPath + '/products/find_between',
            method: 'get',
            params: {
                min: min,
                max: max
            }

        }).then(function (response) {
            console.log(response.data)
            $scope.ProductsList = response.data;
        });
    }

    $scope.loadProducts();

});