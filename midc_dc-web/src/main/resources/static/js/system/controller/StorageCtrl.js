var storageApp = angular.module('storageApp', ['base']);
storageApp.controller('storageCtrl', ['$rootScope', '$scope','storageService',function ($rootScope,$scope,storageService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	//添加,1为添加，0为修改
	$scope.updateStorage = function(sign){
		var selectArray = $("#Checkitem_list tbody input:checked");
		var titleName = '添加存储';
		var storageId = $(selectArray[0]).val();
		layer.open({
			type : 1,
			title : titleName,
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '576px', '468px' ],
			content : $('#Add_checkitem_style'),
			btn : [ '保存', '取消' ],
			yes : function(index, layero) {
				if ($("#name").val() == "") {
					alertDialog("检查项名不能为空");
					return;
				}
				else {
					var storageInfo = angular.copy($scope.storageInfo);
					if(!storageInfo){
						layer.msg('不能为空！', {
							time : 1000,
							icon : 1
						});
						return;
					}
					storageService.addStorage(storageInfo).then(function(response){
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
	
	//删除检查项
	$scope.deleteStorage= function(){
		var selectArray = $("#Checkitem_list tbody input:checked");
		if(!selectArray || selectArray.length==0){
			alertDialog("请选择");
			return;
		}
		var ids = new Array();
		$.each(selectArray,function(i,e){
			var val = $(this).val();
			ids.push(val);
		});
		if(ids.lenght==0){
			return;
		}
		layer.confirm('是否删除存储？', {
			btn : [ '确定', '取消' ]
		}, function() {
			storageService.deleteStorage(ids).then(function(resp){
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
			$(".subStorageChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subStorageChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);