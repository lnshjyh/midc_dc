devicetypePositionCheckitemApp.service('DevicetypePositionCheckitemService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addDevicetypePositionCheckitem: function(checkitem) {
                    var url = _ctx + '/devicetypePositionCheckitem/add';
                    return baseService.post(url,checkitem);
                },
                deleteDevicetypePositionCheckitem: function(json) {
                    var url = _ctx + '/devicetypePositionCheckitem/delete';
                    return baseService.post(url,json);
                },
                basicdata: function(json) {
                    var url = _ctx + '/devicetypePositionCheckitem/basicdata';
                    return baseService.post(url,json);
                }
            }
        }
]);
