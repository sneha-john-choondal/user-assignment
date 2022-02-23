package com.sample.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.user.entity.UserEntity;

@Repository
public interface UserManagementRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByEmail(String email);

	UserEntity findById(int id);
}
