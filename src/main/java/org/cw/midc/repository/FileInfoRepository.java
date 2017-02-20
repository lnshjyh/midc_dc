package org.cw.midc.repository;

import java.util.List;

import org.cw.midc.model.FileInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends PagingAndSortingRepository<FileInfo, String> {

	List<FileInfo> findByStatus(String status, Pageable pageable);
	
	@Modifying
	@Query("update FileInfo f set f.status = :status, f.failedReason = :failedReason where f.id = :id")
	void updateStatusByID(@Param("status")String status, @Param("id")String id, @Param("failedReason")String failedReason);
}
