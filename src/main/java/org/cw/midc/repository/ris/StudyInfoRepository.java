package org.cw.midc.repository.ris;

import org.cw.midc.model.ris.StudyInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyInfoRepository extends PagingAndSortingRepository<StudyInfo, String> {

}
