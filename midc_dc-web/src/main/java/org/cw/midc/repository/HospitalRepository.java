package org.cw.midc.repository;

import java.util.List;

import org.cw.midc.model.FileInfo;
import org.cw.midc.model.Hospital;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends PagingAndSortingRepository<Hospital, String> {

	
}
