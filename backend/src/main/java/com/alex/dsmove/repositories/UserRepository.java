package com.alex.dsmove.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.dsmove.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
