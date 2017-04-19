package com.pulsar.repository;

import org.springframework.data.repository.CrudRepository;

import com.pulsar.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {

	int countByemailAddress(String emailAddress);
}
