var patientApp = angular.module('patientApp', ['base']);
patientApp.controller('patientCtrl', ['$rootScope', '$scope','patientService',function ($rootScope,$scope,patientService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.sexMap = [{code:"F", name: "女"}, {code:"M", name: "男"}];
	
	patientService.devicetypes().then(function(response){
		if(response){
			$scope.dList = response;
			console.log($scope.dList);
		}
	});
	
	$scope.getByDevice = function(){
		var deviceId = $scope.queryFilter.param.deviceTypePk;
		var para={
				deviceTypeId:deviceId
		}
		patientService.bydevice(deviceId).then(function(response){
			if(response){
				$scope.dpcList1 = response.data;
				$scope.dpcList2 = response.data;
			}
		});
	}
	
	$scope.getByDevicePos = function(){
		var deviceId = $scope.queryFilter.param.deviceTypePk;
		var positionId = $scope.queryFilter.param.positionIdPk;
		var para={
				deviceTypeId:deviceId,
				positiontypeId:positionId
		}
		patientService.bydevicepos(para).then(function(response){
			if(response){
				$scope.dpcList2 = response.data;
			}
		});
	}

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