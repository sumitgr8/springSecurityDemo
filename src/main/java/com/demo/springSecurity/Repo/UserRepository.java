package com.demo.springSecurity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springSecurity.Dao.SolarUser;

@Repository
public interface UserRepository extends JpaRepository<SolarUser, Long> {
	
	SolarUser findByUsername( String username); 

}
