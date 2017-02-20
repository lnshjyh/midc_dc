package org.cw.midc.repository.pacs;

import org.cw.midc.model.pacs.Instance;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanceRepository extends PagingAndSortingRepository<Instance, String> {

}
