package org.cw.midc.repository;

import java.util.Date;
import java.util.List;

import org.cw.midc.model.DeviceType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends PagingAndSortingRepository<DeviceType, String> {
	
	
	List<DeviceType> findByDeviceTypeNameLike(String deviceTypeName, Pageable pageable);
	
	@Modifying
	@Query("update DeviceType h set h.deviceTypeName = :deviceTypeName, h.isAvailable = :isAvailable,h.operId = :operId,h.updateTime = :updateTime where h.deviceTypeId = :deviceTypeId")
	int updateByID( @Param("deviceTypeName")String deviceTypeName, @Param("isAvailable")String isAvailable,@Param("operId")String operId,@Param("updateTime")Date updateTime
			,@Param("deviceTypeId")String deviceTypeId);

	
}
