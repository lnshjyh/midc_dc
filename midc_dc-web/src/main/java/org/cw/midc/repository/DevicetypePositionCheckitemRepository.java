package org.cw.midc.repository;


import org.cw.midc.model.DevicetypePositionCheckitem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicetypePositionCheckitemRepository extends PagingAndSortingRepository<DevicetypePositionCheckitem, Integer> {
	
	
}
