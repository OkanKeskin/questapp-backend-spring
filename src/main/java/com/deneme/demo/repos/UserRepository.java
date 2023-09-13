package com.deneme.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deneme.demo.entities.User;

//T: Class  ID:Classtaki id tipi
public interface UserRepository extends JpaRepository<User, Long> {

	//QUERY Deneme - Stored Procedure
	@Query(value = "Call GetAllUser()", 
			  nativeQuery = true)
	List<User> findDenemeUser();

	User findByUserName(String username);
 
}
