package com.jstack.spring.springsecserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jstack.spring.springsecserver.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByName(String username);

}
