package com.deneme.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deneme.demo.entities.User;

//T: Class  ID:Classtaki id tipi
public interface UserRepository extends JpaRepository<User, Long> {
 
}
