package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.FindOrganizationByKodRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindOrganizationByKodServiceTest {
    @Mock
    private OrganizationRepository repository;

    @InjectMocks
    private   FindOrganizationByKodService service;

    @Test
    void findOrganizationByKod_ShouldReturnOrganization() {
        String validKod = "ORG001";
        FindOrganizationByKodRequest request = new FindOrganizationByKodRequest(validKod);
        OrganizationResponse expectedResponse = new OrganizationResponse(
                1L, validKod, "Tech1111", "+380122221133", "123 Main St, Cityville"
        );
        when(repository.findByOrganizationKod(request)).thenReturn(expectedResponse);
        OrganizationResponse actualResponse = service.findOrganizationByKodUseCase(request);
        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void findOrganizationByKod_ShouldReturnNull() {

        String invalidKod = "INVALID_KOD";
        FindOrganizationByKodRequest request = new FindOrganizationByKodRequest(invalidKod);
        when(repository.findByOrganizationKod(request)).thenReturn(null);
        OrganizationResponse actualResponse = service.findOrganizationByKodUseCase(request);
        assertNull(actualResponse);
        verify(repository, times(1)).findByOrganizationKod(request);
    }

    @Test
    void findOrganizationByKodUseCase_ShouldThrowException() {
        String kod = "ORG001";
        FindOrganizationByKodRequest request = new FindOrganizationByKodRequest(kod);
        when(repository.findByOrganizationKod(request)).thenThrow(new RuntimeException("Database error"));
        Exception exception = assertThrows(RuntimeException.class, () ->
                service.findOrganizationByKodUseCase(request)
        );
        assertEquals("Database error", exception.getMessage());
        verify(repository, times(1)).findByOrganizationKod(request);
    }


}