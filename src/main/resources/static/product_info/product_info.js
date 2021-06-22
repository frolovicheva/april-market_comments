angular.module('app').controller('productInfoController', function ($scope, $http, $localStorage, $routeParams) {
    const contextPath = 'http://localhost:8189/market';

    $scope.loadProduct = function () {
        $http({
            url: contextPath + '/api/v1/products/' + $routeParams.productIdParam,
            method: 'GET'
        }).then(function (response) {
            $scope.prod = response.data;
        });
    };
     $scope.loadProduct();

     $scope.leaveComment = function (description) {
             $http({
                 url: contextPath + '/api/v1/product_info/',
                 method: 'POST',
                 params: {
                     prodId: $localStorage.prod.getId
                     description: description
                 }
             }).then(function (response) {
             });
     };
     $scope.showMyComments = function (product_id) {
                 $http({
                     url: contextPath + '/api/v1/product_info/' + product_id,
                     method: 'GET'
                 }).then(function (response) {
                     $scope.MyComments = response.data;
                 });
     };
     $scope.showMyComments();

     });


