package com.payroll.userinfra.adapter.persistence.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.Date;
import java.util.Set;

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
    @NotNull
    private String firstName;
    private String secondName;
    @NotNull
    private String surname;
    @NonNull
    private Date date;
    @ElementCollection
    @CollectionTable(name = "user_employee", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "employee_id")
    private Set<Long> employeeId;
}
