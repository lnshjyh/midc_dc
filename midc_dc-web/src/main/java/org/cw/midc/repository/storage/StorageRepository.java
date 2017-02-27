package org.cw.midc.repository.storage;

import org.cw.midc.model.storage.StorageInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//@CacheConfig
public interface StorageRepository extends PagingAndSortingRepository<StorageInfo, String> {

//	@Cacheable
	StorageInfo findByStatus(String status);
}
