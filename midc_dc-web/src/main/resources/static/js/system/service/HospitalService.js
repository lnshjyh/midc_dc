userApp.service('hospitalService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	addHospital: function(hospital) {
                    var url = _ctx + '/hospital/add';
                    return baseService.post(url,user);
                },
                deleteHospital: function(json) {
                    var url = _ctx + '/hospital/delete';
                    return baseService.post(url,json);
                },
                detail: function(userId) {
                    var url = _ctx + '/hospital/detail';
                    return baseService.post(url,userId);
                },
                editHospital: function(hospital) {
                    var url = _ctx + '/hospital/edit';
                    return baseService.post(url,user);
                }
            }
        }
]);
