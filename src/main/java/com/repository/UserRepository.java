package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;

import jakarta.persistence.Id;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User deleteById(Id id);

}
