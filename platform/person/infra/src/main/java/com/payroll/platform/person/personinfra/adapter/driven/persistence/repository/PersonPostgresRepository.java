package com.payroll.platform.person.personinfra.adapter.driven.persistence.repository;

import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPostgresRepository extends JpaRepository<PersonEntity, Long> {

  Optional<PersonEntity> findUserEntityByDate(Date date);

  Optional<PersonEntity> findUserEntityByEmail(String email);
}
