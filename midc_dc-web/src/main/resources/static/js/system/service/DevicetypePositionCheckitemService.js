devicetypePositionCheckitemApp.service('devicetypePositionCheckitemService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addDevicetypePositionCheckitem: function(checkitem) {
                    var url = _ctx + '/devicetypePC/add';
                    return baseService.post(url,checkitem);
                },
                deleteDevicetypePositionCheckitem: function(json) {
                    var url = _ctx + '/devicetypePC/delete';
                    return baseService.post(url,json);
                },
                basicdata: function(json) {
                    var url = _ctx + '/devicetypePC/basicdata';
                    return baseService.get(url);
                }
            }
        }
]);
