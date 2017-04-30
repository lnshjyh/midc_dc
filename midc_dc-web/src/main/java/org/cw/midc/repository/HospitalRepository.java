package org.cw.midc.repository;

import java.util.List;

import org.cw.midc.model.Hospital;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends PagingAndSortingRepository<Hospital, String> {
	
	List<Hospital> findByClientId(String clientId);
	
	List<Hospital> findByHospNameLike(String hospName, Pageable pageable);
	
	@Modifying
	@Query("update Hospital h set h.clientId = :clientId, h.hospName = :hospName,h.address = :address,h.longitude = :longitude,h.latitude = :latitude where h.hospId = :hospId")
	int updateByID(@Param("clientId")String clientId, @Param("hospName")String hospName, 
			@Param("address")String address,@Param("longitude")Float longitude,@Param("latitude")Float latitude,
			@Param("hospId")String hospId);

	
}
