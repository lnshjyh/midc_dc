checkitemApp.service('checkitemService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addCheckitem: function(checkitem) {
                    var url = _ctx + '/checkitem/add';
                    return baseService.post(url,checkitem);
                },
                deleteCheckitem: function(json) {
                    var url = _ctx + '/checkitem/delete';
                    return baseService.post(url,json);
                },
                detail: function(checkitemId) {
                    var url = _ctx + '/checkitem/detail';
                    return baseService.post(url,checkitemId);
                },
                editCheckitem: function(checkitem) {
                    var url = _ctx + '/checkitem/edit';
                    return baseService.post(url,checkitem);
                }
            }
        }
]);
