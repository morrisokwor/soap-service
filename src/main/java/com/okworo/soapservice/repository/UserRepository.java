package com.okworo.soapservice.repository;

import com.okworo.soapservice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
