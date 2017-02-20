package org.cw.midc.auth.repository;

import org.cw.midc.auth.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	User findByUserName(String userName);
	
}
