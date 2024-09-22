package com.payroll.platform.organization.orgapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteOrganizationServiceTest {

  @Mock private OrganizationRepository repository;

  @InjectMocks private DeleteOrganizationService service;

  @Test
  void deleteOrganizationById_ShouldCallRepository_WhenValidIdProvided() {
    Long organizationId = 1L;
    service.deleteOrganizationById(organizationId);
    verify(repository, times(1)).deleteOrganizationById(organizationId);
  }

  @Test
  void deleteOrganizationById_ShouldThrowException_WhenRepositoryFails() {

    Long organizationId = 1L;
    doThrow(new RuntimeException("Deletion failed"))
        .when(repository)
        .deleteOrganizationById(organizationId);
    Exception exception =
        assertThrows(RuntimeException.class, () -> service.deleteOrganizationById(organizationId));
    assertEquals("Deletion failed", exception.getMessage());
    verify(repository, times(1)).deleteOrganizationById(organizationId);
  }
}
