package org.cw.midc.repository.ris;

import java.util.List;

import org.cw.midc.model.ris.StudyInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyInfoRepository extends PagingAndSortingRepository<StudyInfo, String> {
	
	public List<StudyInfo> findByHospitalIdAndReportStatus(String hospitalId, String reportStatus);
		
	public StudyInfo findByOrginalStudyInfoIdAndHospitalId(String orginalStudyInfoId, String hospitalId);
}
