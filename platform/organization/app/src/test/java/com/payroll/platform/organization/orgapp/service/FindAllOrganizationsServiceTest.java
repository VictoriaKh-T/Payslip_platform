package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllOrganizationsServiceTest {
    @Mock
    private OrganizationRepository repository;

    @InjectMocks
    private  FindAllOrganizationsService service;

    @Test
    void findAll_ShouldReturnListOfOrganizations() {
        OrganizationResponse org1 = new OrganizationResponse(1L, "ORG001", "Tech1111", "+380122221133", "123 Main St, Cityville");
        OrganizationResponse org2 = new OrganizationResponse(2L, "ORG002", "BizCorp", "+380122221144", "456 Market St, Townsville");

        List<OrganizationResponse> expectedOrganizations = Arrays.asList(org1, org2);

        when(repository.findAllOrganizations()).thenReturn(expectedOrganizations);
        List<OrganizationResponse> actualOrganizations = service.findAll();
        assertNotNull(actualOrganizations);
        assertEquals(2, actualOrganizations.size());
        assertEquals(expectedOrganizations, actualOrganizations);
        verify(repository, times(1)).findAllOrganizations();
    }

    @Test
    void findAll_ShouldReturnEmptyList() {
        when(repository.findAllOrganizations()).thenReturn(Arrays.asList());
        List<OrganizationResponse> actualOrganizations = service.findAll();
        assertNotNull(actualOrganizations);
        assertTrue(actualOrganizations.isEmpty());
        verify(repository, times(1)).findAllOrganizations();
    }
}