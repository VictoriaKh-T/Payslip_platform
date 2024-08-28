package com.payroll.platform.user.userinfra.adapter.driven.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Valid
  @Email
  @Column(nullable = false, unique = true)
  private String email;

  @NotNull private String firstName;
  private String secondName;
  @NotNull private String surname;
  @NonNull private Date date;
}
