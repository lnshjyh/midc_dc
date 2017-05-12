storageApp.service('storageService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addStorage: function(storageInfo) {
                    var url = _ctx + '/storage/add';
                    return baseService.post(url,storageInfo);
                },
                deleteStorage: function(json) {
                    var url = _ctx + '/storage/delete';
                    return baseService.post(url,json);
                },
                editStorage: function(storageInfo) {
                    var url = _ctx + '/storage/edit';
                    return baseService.post(url,checkitem);
                }
            }
        }
]);
