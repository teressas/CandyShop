package com.teressas.candyshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teressas.candyshop.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findUserByEmail(String email);

}
