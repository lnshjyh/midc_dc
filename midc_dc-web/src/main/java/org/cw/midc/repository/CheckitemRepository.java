package org.cw.midc.repository;

import java.util.Date;
import java.util.List;

import org.cw.midc.model.Checkitem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckitemRepository extends PagingAndSortingRepository<Checkitem, Integer> {
	
	
	List<Checkitem> findByCheckitemNameLike(String checkitemName, Pageable pageable);
	
	@Modifying
	@Query("update Checkitem h set h.checkitemName = :checkitemName, h.isAvailable = :isAvailable,h.operId = :operId,h.updateTime = :updateTime where h.checkitemId = :checkitemId")
	int updateByID( @Param("checkitemName")String checkitemName, @Param("isAvailable")String isAvailable,@Param("operId")String operId,@Param("updateTime")Date updateTime
			, @Param("checkitemId")Integer checkitemId);

	
}
