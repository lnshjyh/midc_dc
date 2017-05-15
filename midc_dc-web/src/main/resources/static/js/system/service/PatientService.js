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
                },
                allhospital:function(){
                	var url = _ctx + '/patlist/allhospital';
                    return baseService.get(url);
                },
                report:function(studyinfoid){
                	var url = _ctx + '/patlist/report/' + studyinfoid;
                    return baseService.get(url);
                }
            	
            }
        }
]);
