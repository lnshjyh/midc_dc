package org.cw.midc.repository.pacs;

import org.cw.midc.model.pacs.Series;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends PagingAndSortingRepository<Series, String> {
	
}
