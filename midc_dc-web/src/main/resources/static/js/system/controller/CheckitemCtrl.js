var checkitemApp = angular.module('checkitemApp', ['base']);
checkitemApp.controller('checkitemCtrl', ['$rootScope', '$scope','checkitemService',function ($rootScope,$scope,checkitemService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.isAvailableMap = [{isAvailable:0, name: "不可用"}, {isAvailable: 1, name: "可用"}];
	//添加检查项,1为添加，0为修改
	$scope.updateCheckitem = function(sign){
		var selectArray = $("#Checkitem_list tbody input:checked");
		if(!selectArray || (selectArray.length!=1 && sign==0)){
			alertDialog("请选择一个");
			return;
		}
		var titleName = sign==0 ? '修改检查项':'添加检查项';
		var checkitemId = $(selectArray[0]).val();
		if(sign==0){
			checkitemService.detail(checkitemId).then(function(response){
				var isAvailable = response.data.isAvailable;
				$scope.checkitem = response.data;
				$scope.checkitem.isAvailable = isAvailable.toString();
			});
		}else{
			$scope.checkitem = {
					isAvailable :'1'
			};
		}
		layer.open({
			type : 1,
			title : titleName,
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '576px', '468px' ],
			content : $('#Add_checkitem_style'),
			btn : [ '保存', '取消' ],
			yes : function(index, layero) {
				if ($("#checkitemName").val() == "") {
					alertDialog("检查项名不能为空");
					return;
				}
				else {
					var checkitem = angular.copy($scope.checkitem);
					if(!checkitem){
						layer.msg('检查项不能为空！', {
							time : 1000,
							icon : 1
						});
						return;
					}
					var isAvailableStr = checkitem.isAvailable;
					checkitem.isAvailableStr = parseInt(isAvailableStr);
					if(!checkitemId){
						checkitemService.addCheckitem(checkitem).then(function(response){
							layer.alert(response.msg, {
								title : '提示框',
								icon : 1,
							},function(){
								layer.close(index);
								window.location.reload();
							});
						});
					}else{
						checkitemService.editCheckitem(checkitem).then(function(response){
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
	
	//删除检查项
	$scope.deleteCheckitem = function(){
		var selectArray = $("#Checkitem_list tbody input:checked");
		if(!selectArray || selectArray.length==0){
			alertDialog("请选择检查项");
			return;
		}
		var checkitemIds = new Array();
		$.each(selectArray,function(i,e){
			var val = $(this).val();
			checkitemIds.push(val);
		});
		if(checkitemIds.lenght==0){
			return;
		}
		layer.confirm('是否删除检查项？', {
			btn : [ '确定', '取消' ]
		}, function() {
			checkitemService.deleteCheckitem(checkitemIds).then(function(resp){
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
			$(".subCheckitemChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subCheckitemChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);