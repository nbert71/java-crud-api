package com.example.javacrudapi.repository;

import com.example.javacrudapi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {}
