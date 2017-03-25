var positionTypeApp = angular.module('positionTypeApp', ['base']);
positionTypeApp.controller('positionTypeCtrl', ['$rootScope', '$scope','positionTypeService',function ($rootScope,$scope,positionTypeService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.isAvailableMap = [{isAvailable:0, name: "不可用"}, {isAvailable: 1, name: "可用"}];
	//添加部位类型,1为添加，0为修改
	$scope.updatePositionType = function(sign){
		var selectArray = $("#PositionType_list tbody input:checked");
		if(!selectArray || (selectArray.length!=1 && sign==0)){
			alertDialog("请选择一个");
			return;
		}
		var titleName = selectArray && selectArray.length>0 ? '修改部位类型':'添加部位类型';
		var positiontypeId = $(selectArray[0]).val();
		if(positiontypeId){
			positionTypeService.detail(positiontypeId).then(function(response){
				var isAvailable = response.data.isAvailable;
				$scope.positionType = response.data;
				$scope.positionType.isAvailable = isAvailable.toString();
			});
		}else{
			$scope.positionType = {
					isAvailable :'0'
			};
		}
		layer.open({
			type : 1,
			title : titleName,
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '576px', '468px' ],
			content : $('#Add_positionType_style'),
			btn : [ '保存', '取消' ],
			yes : function(index, layero) {
				if ($("#positiontypeName").val() == "") {
					alertDialog("部位类型名不能为空");
					return;
				}
				else {
					var positionType = angular.copy($scope.positionType);
					if(!positionType){
						layer.msg('部位类型不能为空！', {
							time : 1000,
							icon : 1
						});
						return;
					}
					var isAvailableStr = positionType.isAvailable;
					positionType.isAvailableStr = parseInt(isAvailableStr);
					if(!positiontypeId){
						positionTypeService.addPositionType(positionType).then(function(response){
							layer.alert(response.msg, {
								title : '提示框',
								icon : 1,
							},function(){
								layer.close(index);
								window.location.reload();
							});
						});
					}else{
						positionTypeService.editPositionType(positionType).then(function(response){
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
	
	//删除部位类型
	$scope.deletePositionType = function(){
		var selectArray = $("#PositionType_list tbody input:checked");
		if(!selectArray || selectArray.length==0){
			alertDialog("请选择部位类型");
			return;
		}
		var positiontypeIds = new Array();
		$.each(selectArray,function(i,e){
			var val = $(this).val();
			positiontypeIds.push(val);
		});
		if(positiontypeIds.lenght==0){
			return;
		}
		layer.confirm('是否删除部位类型？', {
			btn : [ '确定', '取消' ]
		}, function() {
			positionTypeService.deletePositionType(positiontypeIds).then(function(resp){
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
			$(".subPosChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subPosChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);