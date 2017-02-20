package org.cw.midc.repository.storage;

import org.cw.midc.model.storage.MediaInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "midc_cache")
public interface MediaRepository extends PagingAndSortingRepository<MediaInfo, String> {
	
	@Cacheable
	MediaInfo findByName(String name);

}
