var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
        .when("/acceuil", {
            templateUrl : "template/Accueil.html"
        })
        .when("/connexion", {
            templateUrl : "template/Connexion.html"
        })
        .otherwise({
            redirectTo: "/acceuil"
        });
}).controller('ValidationCtrl', function (){

});