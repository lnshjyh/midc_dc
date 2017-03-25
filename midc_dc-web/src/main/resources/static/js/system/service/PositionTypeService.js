positionTypeApp.service('positionTypeService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addPositionType: function(positionType) {
                    var url = _ctx + '/positionType/add';
                    return baseService.post(url,positionType);
                },
                deletePositionType: function(json) {
                    var url = _ctx + '/positionType/delete';
                    return baseService.post(url,json);
                },
                detail: function(positionTypeId) {
                    var url = _ctx + '/positionType/detail';
                    return baseService.post(url,positionTypeId);
                },
                editPositionType: function(positionType) {
                    var url = _ctx + '/positionType/edit';
                    return baseService.post(url,positionType);
                }
            }
        }
]);
