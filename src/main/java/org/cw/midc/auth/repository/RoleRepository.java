package org.cw.midc.auth.repository;

import java.util.List;

import org.cw.midc.auth.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

	List<Role> findByIdIn(Integer[] ids);
}
