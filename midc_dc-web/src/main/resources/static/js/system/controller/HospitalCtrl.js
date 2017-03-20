var userApp = angular.module('userApp', ['base']);
userApp.controller('hospitalCtrl', ['$rootScope', '$scope','hospitalService',function ($rootScope,$scope,hospitalService) {
	$('#multiselect').multiselect({});
	//搜索参数
	$scope.queryFilter = {};
	$scope.isAvailableMap = [{isAvailableMap:0, name: "不可用"}, {isAvailableMap: 1, name: "可用"}];
	//添加用户,1为添加，0为修改
	$scope.updateHospital = function(sign){
		var selectArray = $("#Hospital_list tbody input:checked");
		if(!selectArray || (selectArray.length!=1 && sign==0)){
			alertDialog("请选择一个");
			return;
		}
		var titleName = selectArray && selectArray.length>0 ? '修改医疗机构':'添加医疗机构';
		var hospId = $(selectArray[0]).val();
		if(hospId){
			hospitalService.detail(hospId).then(function(response){
				var isLock = response.isAvailable;
				$scope.hospital = response;
				$scope.hospital.isAvailable = isAvailable.toString();
			});
		}else{
			$scope.hospital = {
					isAvailable :'0'
			};
		}
		layer.open({
			type : 1,
			title : titleName,
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '576px', '468px' ],
			content : $('#Add_user_style'),
			btn : [ '保存', '取消' ],
			yes : function(index, layero) {
				if ($("#hospName").val() == "") {
					alertDialog("医疗机构名不能为空");
					return;
				}
				if ($("#clientId").val() == "") {
					alertDialog("客户端标识不能为空");
					return;
				}
				else {
					var hospital = angular.copy($scope.hospital);
					if(!hospital){
						layer.msg('医疗机构不能为空！', {
							time : 1000,
							icon : 1
						});
						return;
					}
					var isAvailableStr = hospital.isAvailable;
					hospital.isAvailableStr = parseInt(isAvailableStr);
					if(!hospId){
						hospitalService.addHospital(hospital).then(function(response){
							layer.alert(response.msg, {
								title : '提示框',
								icon : 1,
							},function(){
								layer.close(index);
								window.location.reload();
							});
						});
					}else{
						hospitalService.editHospital(hospital).then(function(response){
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
	
	//删除用户
	$scope.deleteHospital = function(){
		var selectArray = $("#Hospital_list tbody input:checked");
		if(!selectArray || selectArray.length==0){
			alertDialog("请选择医疗机构");
			return;
		}
		var hospitalIds = new Array();
		$.each(selectArray,function(i,e){
			var val = $(this).val();
			hospitalIds.push(val);
		});
		if(hospitalIds.lenght==0){
			return;
		}
		layer.confirm('是否删除医疗机构？', {
			btn : [ '确定', '取消' ]
		}, function() {
			hospitalService.deleteHospital(hospitalIds).then(function(resp){
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
			$(".subHospChkbox").each(function(i,e){
				$(this).attr("checked",true);
			});
		}else{
			$(".subHospChkbox").each(function(i,e){
				$(this).attr("checked",false);
			});
		}
	}
 }]);