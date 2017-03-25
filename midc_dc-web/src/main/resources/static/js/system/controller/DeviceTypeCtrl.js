var deviceTypeApp = angular.module('deviceTypeApp', ['base']);
deviceTypeApp.controller('deviceTypeCtrl', ['$rootScope', '$scope','deviceTypeService',function ($rootScope,$scope,deviceTypeService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.isAvailableMap = [{isAvailable:0, name: "不可用"}, {isAvailable: 1, name: "可用"}];
	//添加设备类型,1为添加，0为修改
	$scope.updateDeviceType = function(sign){
		var selectArray = $("#DeviceType_list tbody input:checked");
		if(!selectArray || (selectArray.length!=1 && sign==0)){
			alertDialog("请选择一个");
			return;
		}
		var titleName = selectArray && selectArray.length>0 ? '修改设备类型':'添加设备类型';
		var deviceTypeId = $(selectArray[0]).val();
		if(deviceTypeId){
			deviceTypeService.detail(deviceTypeId).then(function(response){
				var isAvailable = response.data.isAvailable;
				$scope.deviceType = response.data;
				$scope.deviceType.isAvailable = isAvailable.toString();
			});
		}else{
			$scope.deviceType = {
					isAvailable :'0'
			};
		}
		layer.open({
			type : 1,
			title : titleName,
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '576px', '468px' ],
			content : $('#Add_deviceType_style'),
			btn : [ '保存', '取消' ],
			yes : function(index, layero) {
				if ($("#deviceTypeName").val() == "") {
					alertDialog("设备类型名不能为空");
					return;
				}
				else {
					var deviceType = angular.copy($scope.deviceType);
					if(!deviceType){
						layer.msg('设备类型不能为空！', {
							time : 1000,
							icon : 1
						});
						return;
					}
					var isAvailableStr = deviceType.isAvailable;
					deviceType.isAvailableStr = parseInt(isAvailableStr);
					if(!deviceTypeId){
						deviceTypeService.addDeviceType(deviceType).then(function(response){
							layer.alert(response.msg, {
								title : '提示框',
								icon : 1,
							},function(){
								layer.close(index);
								window.location.reload();
							});
						});
					}else{
						deviceTypeService.editDeviceType(deviceType).then(function(response){
							layer.alert('修改成功！', {
								title : '提示框',
								icon : 1,
							},function(){
								window.location.reload();
							});
							layer.close(index);
						},function(response){

						});
					}
				}
			}
		});
	}
	
	//删除设备类型
	$scope.deleteDeviceType = function(){
		var selectArray = $("#DeviceType_list tbody input:checked");
		if(!selectArray || selectArray.length==0){
			alertDialog("请选择设备类型");
			return;
		}
		var deviceTypeIds = new Array();
		$.each(selectArray,function(i,e){
			var val = $(this).val();
			deviceTypeIds.push(val);
		});
		if(deviceTypeIds.lenght==0){
			return;
		}
		layer.confirm('是否删除设备类型？', {
			btn : [ '确定', '取消' ]
		}, function() {
			deviceTypelService.deleteDeviceType(deviceTypeIds).then(function(resp){
				layer.msg(resp.msg, {
					time : 1000,
					icon : 1
				},function(){
					window.location.reload();
				});
			});
		});
	}

	$scope.selectAll = function($event){
		var target = $event.target
		if($(target).prop("checked")){
			$(".subDeviceChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subDeviceChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);