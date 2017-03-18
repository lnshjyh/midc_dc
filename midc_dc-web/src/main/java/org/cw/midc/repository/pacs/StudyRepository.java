package org.cw.midc.repository.pacs;

import org.cw.midc.model.pacs.Study;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends PagingAndSortingRepository<Study, String> {

}