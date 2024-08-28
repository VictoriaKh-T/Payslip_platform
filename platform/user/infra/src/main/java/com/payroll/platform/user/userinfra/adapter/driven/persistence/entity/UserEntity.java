package com.payroll.platform.user.userinfra.adapter.driven.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

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

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_name")
  )
  private Set<Role> roles = Set.of(Role.USER);

  @Column(nullable = false)
  private boolean isDelete = false;
}
