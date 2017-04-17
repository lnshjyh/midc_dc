var checkitemApp = angular.module('patientApp', ['base']);
checkitemApp.controller('patientCtrl', ['$rootScope', '$scope','patientService',function ($rootScope,$scope,patientService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.isAvailableMap = [{isAvailable:0, name: "不可用"}, {isAvailable: 1, name: "可用"}];
	

	$scope.selectAll = function($event){
		var target = $event.target
		if($(target).prop("checked")){
			$(".subPatientChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subPatientChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);