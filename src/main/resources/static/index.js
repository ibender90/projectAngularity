angular.module('angularity', []).controller('indexController', function ($scope, $http){
    const contextPath = 'http://localhost:8181/angularity';

    $scope.showAllProducts = function () {
        $http.get(contextPath + '/products/all')
            .then(function (response){
                $scope.productsList = response.data;
            });
    };

    $scope.showProduct = function (productId) {
            $http.get(contextPath + '/products/' + productId)
                .then(function (response){
                const obj = response.data
                    alert(JSON.stringify(obj));
                });
        };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response){
                $scope.showAllProducts();
        });
    };

    $scope.changePrice = function (productId, delta) {
            $http({
                url: contextPath + '/products/change_price',
                method: 'GET',
                params: {
                    productId: productId,
                    delta: delta
                }
            }).then(function (response){
                    $scope.showAllProducts();
            });
        };

    $scope.showAllProducts();
});