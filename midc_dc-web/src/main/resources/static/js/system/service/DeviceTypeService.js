deviceTypeApp.service('deviceTypeService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addDeviceType: function(deviceType) {
                    var url = _ctx + '/deviceType/add';
                    return baseService.post(url,deviceType);
                },
                deleteDeviceType: function(json) {
                    var url = _ctx + '/deviceType/delete';
                    return baseService.post(url,json);
                },
                detail: function(deviceTypeId) {
                    var url = _ctx + '/deviceType/detail';
                    return baseService.post(url,deviceTypeId);
                },
                editDeviceType: function(deviceType) {
                    var url = _ctx + '/deviceType/edit';
                    return baseService.post(url,deviceType);
                }
            }
        }
]);
