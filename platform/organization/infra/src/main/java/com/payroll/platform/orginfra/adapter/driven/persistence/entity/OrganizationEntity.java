package com.payroll.platform.orginfra.adapter.driven.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "organizations")
public class OrganizationEntity {
  @Id private String id;
  @NonNull private String name;
  @NonNull private String kodOrganization;
  private String address;
  private String contact;
  private String description;
}
