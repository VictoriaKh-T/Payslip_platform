package com.payroll.platform.person.personinfra.adapter.driven.persistence.repository;

import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPostgresRepository extends JpaRepository<PersonEntity, Long> {

  Optional<PersonEntity> findPersonEntityByBirthDate(LocalDate bitrhDate);

  Optional<PersonEntity> findPersonEntityByEmail(String email);
}
