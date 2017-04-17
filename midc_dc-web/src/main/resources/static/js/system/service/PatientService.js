patientApp.service('patientService', ['$http', '$q', 'baseService',
        function($http, $q, baseService) {
            return {
            	bydevice: function(json) {
                    var url = _ctx + '/patlist/bydevice';
                    return baseService.post(url,json);
                },
                bydevicepos: function(json) {
                    var url = _ctx + '/patlist/bydevicepos';
                    return baseService.post(url,json);
                },
                devicetypes: function(json) {
                    var url = _ctx + '/patlist/devicetypes';
                    return baseService.get(url);
                }
            	
            }
        }
]);
