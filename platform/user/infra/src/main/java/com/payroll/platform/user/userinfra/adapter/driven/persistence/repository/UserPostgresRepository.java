package com.payroll.platform.user.userinfra.adapter.driven.persistence.repository;

import com.payroll.platform.user.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface UserPostgresRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByDate(Date date);

    Optional<UserEntity> findUserEntityByEmail(String email);
}
