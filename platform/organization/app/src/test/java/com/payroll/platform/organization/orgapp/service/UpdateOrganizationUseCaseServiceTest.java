package com.payroll.platform.organization.orgapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateOrganizationUseCaseServiceTest {
  @Mock private OrganizationPersistencePort repository;

  @InjectMocks private UpdateOrganizationUseCaseService service;

  @Test
  void updateOrganization_ShouldReturnUpdatedOrganization() {
    Long organizationId = 1L;
    UpdateOrganizationRequest request =
        new UpdateOrganizationRequest(
            "OOO111", "TechUpdated", "+380122221144", "456 Market St, Townsville");
    UpdateOrganizationResponse expectedResponse =
        new UpdateOrganizationResponse(
            organizationId, "OOO111", "TechUpdated", "+380122221144", "456 Market St, Townsville");
    when(repository.updateOrganizationById(organizationId, request)).thenReturn(expectedResponse);
    UpdateOrganizationResponse actualResponse = service.updateOrganization(organizationId, request);
    assertNotNull(actualResponse);
    assertEquals(expectedResponse, actualResponse);
    verify(repository, times(1)).updateOrganizationById(organizationId, request);
  }

  @Test
  void updateOrganization_ShouldReturnNull_WhenOrganizationNotFound() {
    Long invalidOrganizationId = 999L;
    UpdateOrganizationRequest request =
        new UpdateOrganizationRequest(
            "OOO111", "TechUpdated", "+380122221144", "456 Market St, Townsville");
    when(repository.updateOrganizationById(invalidOrganizationId, request)).thenReturn(null);
    UpdateOrganizationResponse actualResponse =
        service.updateOrganization(invalidOrganizationId, request);
    assertNull(actualResponse);
    verify(repository, times(1)).updateOrganizationById(invalidOrganizationId, request);
  }
}
