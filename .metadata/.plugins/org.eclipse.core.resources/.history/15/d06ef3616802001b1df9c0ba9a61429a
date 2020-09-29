package com.cognizant.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.cognizant.model.MenuItem;
@Transactional
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {

	@Query(value="select * from menuitems where id= :id",nativeQuery = true)
	public Optional<MenuItem> findById(@Param("id") Long id);
	
	@Modifying
	@Query(value = "DELETE FROM menuitems WHERE id = :id", nativeQuery = true)
	public int deleteById(@Param("id") Long id);

}
