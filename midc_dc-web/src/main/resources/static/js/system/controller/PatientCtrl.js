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
		var deviceId = $scope.queryFilter.param.deviceTypeId;
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
		var deviceId = $scope.queryFilter.param.deviceTypeId;
		var positionId = $scope.queryFilter.param.positiontypeId;
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
	
	$scope.viewReport = function(){
		var selectArray = $("#Patient_list tbody input:checked");
		if(!selectArray || (selectArray.length!=1)){
			alertDialog("请选择一个");
			return;
		}
		var studyinfoId = $(selectArray[0]).val();
		layer.open({
			type : 1,
			title : '查看影像学报告',
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '900px', '500px' ],
			content : $('#report'),
			btn : [  '关闭' ]
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