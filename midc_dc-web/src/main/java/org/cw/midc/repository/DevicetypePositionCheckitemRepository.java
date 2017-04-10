package org.cw.midc.repository;


import java.util.List;

import org.cw.midc.model.DeviceType;
import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.model.PositionType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicetypePositionCheckitemRepository extends PagingAndSortingRepository<DevicetypePositionCheckitem, Integer> {
	
	List<DevicetypePositionCheckitem> findByDevice(DeviceType device);
	
	List<DevicetypePositionCheckitem> findByDeviceAndPositionType(DeviceType device,PositionType positionType);
	
	
}
