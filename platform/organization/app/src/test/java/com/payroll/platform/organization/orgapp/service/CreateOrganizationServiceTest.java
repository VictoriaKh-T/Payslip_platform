package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateOrganizationServiceTest {
    @Mock
    private OrganizationRepository repository;

    @InjectMocks
    private  CreateOrganizationService service;

    @Test
    void addOrganization_ShouldReturnOrganizationResponse() {
        OrganizationRequest request = new OrganizationRequest(
                1L,
                "ORG001",
                "Tech1111",
                "+380122221133",
                "123 Main St, Cityville"
        );
        OrganizationResponse response = new OrganizationResponse(
                1L,
                "ORG001",
                "Tech1111",
                "+380122221133",
                "123 Main St, Cityville"
        );

        when(repository.addOrganization(request)).thenReturn(response);

        OrganizationResponse actualResponse = service.addOrganization(request);

        assertNotNull(actualResponse);
        assertEquals(response, actualResponse);
        verify(repository, times(1)).addOrganization(request);
    }

    @Test
    void addOrganization_ShouldThrowException_WhenRepositoryFails() {
        OrganizationRequest request = new OrganizationRequest(
                1L,
                "ORG001",
                "Tech1111",
                "+380122221133",
                "123 Main St, Cityville"
        );

        when(repository.addOrganization(request)).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () ->
                service.addOrganization(request)
        );

        assertEquals("Database error", exception.getMessage());
        verify(repository, times(1)).addOrganization(request);
    }



}