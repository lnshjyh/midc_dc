package org.cw.midc.repository;

import java.util.Date;
import java.util.List;

import org.cw.midc.model.PositionType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionTypeRepository extends PagingAndSortingRepository<PositionType, Integer> {
	
	
	List<PositionType> findByPositiontypeNameLike(String positiontypeName, Pageable pageable);
	
	@Modifying
	@Query("update PositionType h set h.positiontypeName = :positiontypeName, h.isAvailable = :isAvailable,h.operId = :operId,h.updateTime = :updateTime where h.positiontypeId = :positiontypeId")
	int updateByID( @Param("positiontypeName")String positiontypeName, @Param("isAvailable")String isAvailable,@Param("operId")String operId,@Param("updateTime")Date updateTime
			,@Param("positiontypeId")Integer positiontypeId);

	
}
