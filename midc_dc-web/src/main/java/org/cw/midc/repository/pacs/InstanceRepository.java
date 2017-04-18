package org.cw.midc.repository.pacs;

import java.util.List;

import org.cw.midc.model.pacs.Instance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanceRepository extends PagingAndSortingRepository<Instance, String> {
	
	public List<Instance> findBySeriesUniqueId(String seriesUniqueId);

}
