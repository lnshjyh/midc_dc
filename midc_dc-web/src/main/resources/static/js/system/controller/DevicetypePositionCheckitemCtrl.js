var devicetypePositionCheckitemApp = angular.module('devicetypePositionCheckitemApp', ['base']);
devicetypePositionCheckitemApp.controller('devicetypePositionCheckitemCtrl', ['$rootScope', '$scope','devicetypePositionCheckitemService',function ($rootScope,$scope,devicetypePositionCheckitemService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.isAvailableMap = [{isAvailable:0, name: "不可用"}, {isAvailable: 1, name: "可用"}];
	devicetypePositionCheckitemService.basicdata().then(function(response){
		if(response){
			$scope.cList = response.c;
			$scope.dList = response.d;
			$scope.pList = response.p;
		}
		
	});
	//添加
	$scope.updateDevicetypePositionCheckitem = function(sign){
		var selectArray = $("#DevicetypePositionCheckitem_list tbody input:checked");
		if(!selectArray || (selectArray.length!=1 && sign==0)){
			alertDialog("请选择一个");
			return;
		}
		var titleName = '添加设备关联';
		var id = $(selectArray[0]).val();
		
		layer.open({
			type : 1,
			title : titleName,
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '576px', '468px' ],
			content : $('#Add_checkitem_style'),
			btn : [ '保存', '取消' ],
			yes : function(index, layero) {
				if ($("#checkitemId").val() == "") {
					alertDialog("不能为空");
					return;
				}
				else {
					var devicetypePositionCheckitem = angular.copy($scope.devicetypePositionCheckitem);
					devicetypePositionCheckitem.checkitemName = $("#checkitem").find("option:selected").text();
					devicetypePositionCheckitem.positiontypeName = $("#position").find("option:selected").text();
					devicetypePositionCheckitem.deviceTypeName = $("#device").find("option:selected").text();
					
					if(!devicetypePositionCheckitem){
						layer.msg('不能为空！', {
							time : 1000,
							icon : 1
						});
						return;
					}
					devicetypePositionCheckitemService.addDevicetypePositionCheckitem(devicetypePositionCheckitem).then(function(response){
						layer.alert(response.msg, {
							title : '提示框',
							icon : 1,
						},function(){
							layer.close(index);
							window.location.reload();
						});
					});
				}
			}
		});
	}
	
	//删除
	$scope.deleteDevicetypePositionCheckitem = function(){
		var selectArray = $("#DevicetypePositionCheckitem_list tbody input:checked");
		if(!selectArray || selectArray.length==0){
			alertDialog("请选择");
			return;
		}
		var devicetypePositionCheckitemIds = new Array();
		$.each(selectArray,function(i,e){
			var val = $(this).val();
			devicetypePositionCheckitemIds.push(val);
		});
		if(devicetypePositionCheckitemIds.lenght==0){
			return;
		}
		layer.confirm('是否删除？', {
			btn : [ '确定', '取消' ]
		}, function() {
			devicetypePositionCheckitemService.deleteDevicetypePositionCheckitem(devicetypePositionCheckitemIds).then(function(resp){
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
			$(".subDevChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subDevChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);