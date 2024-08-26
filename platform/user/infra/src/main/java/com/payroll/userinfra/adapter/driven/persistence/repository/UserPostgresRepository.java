package com.payroll.userinfra.adapter.driven.persistence.repository;

import com.payroll.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.Optional;

public interface UserPostgresRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByDate(Date date);

    Optional<UserEntity> findUserEntityByEmail(String email);
}
