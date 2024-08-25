package com.payroll.userinfra.adapter.driven.persistence.repository;

import com.payroll.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostgresRepository extends JpaRepository<UserEntity, Long> {
}
