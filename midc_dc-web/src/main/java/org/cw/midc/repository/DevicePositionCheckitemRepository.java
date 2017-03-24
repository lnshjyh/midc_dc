package org.cw.midc.repository;

import java.util.Date;
import java.util.List;

import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.model.PositionType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicePositionCheckitemRepository extends PagingAndSortingRepository<DevicetypePositionCheckitem, Integer> {
	
	
}
