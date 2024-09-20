package com.payroll.platform.organization.orginfra.adapter.driven.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "organizations")
@SQLDelete(sql = "UPDATE organizations SET is_delete = true WHERE id = ?")
@Entity
public class OrganizationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false, unique = true)
  private String kodOrganization;

  private String address;
  private String telephoneNumber;
  private String description;

  @Column(nullable = false)
  private boolean isDelete = false;
}
