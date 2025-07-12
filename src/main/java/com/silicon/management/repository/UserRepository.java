package com.silicon.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silicon.management.model.User;

	
	@Repository
	public interface UserRepository extends JpaRepository<User , Integer >{

		User findByUsernameAndPassword(String username, String password);
	}

