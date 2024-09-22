package com.payroll.platform.organization.orginfra.adapter.driven.persistence.repository;


import com.payroll.platform.organization.orgdomain.dto.FindOrganizationByKodRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.organization.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import com.payroll.platform.organization.orginfra.exeption.OrganizationNotFoundException;
import com.payroll.platform.organization.orginfra.mapper.OrganizationDtoToOrganizationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrganizationAdapterTest {
    @Mock
    OrganizationPostgresRepository repository;

    @InjectMocks
    OrganizationAdapter adapter;

    @Test
    public void createOrganizationSuccess() {
        OrganizationRequest request = new OrganizationRequest(1L,
                "OOO111",
                "Organization Test Name",
                "0001112233",
                "nya vagen" );
        OrganizationResponse response = new OrganizationResponse(1L,
                "OOO111",
                "Organization Test Name",
                "0001112233",
                "nya vagen" );

        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(request.id());
        organizationEntity.setKodOrganization(request.kodOrganization());
        organizationEntity.setAddress(request.address());
        organizationEntity.setName(request.name());
        organizationEntity.setTelephoneNumber(request.telephoneNumber());

        when(repository.save(any(OrganizationEntity.class))).thenReturn(organizationEntity);

        OrganizationResponse actualResponse = adapter.createOrganization(request);

        assertEquals(response.id(), actualResponse.id());
        assertEquals(response.name(), actualResponse.name());
        assertEquals(response.kodOrganization(), actualResponse.kodOrganization());

        verify(repository, times(1)).save(any(OrganizationEntity.class));

    }

    @Test
    public void findOrganizationById_Success() {
        Long organizationId = 1L;

        OrganizationResponse response = new OrganizationResponse(organizationId,
                "OOO111",
                "Organization Test Name",
                "0001112233",
                "nya vagen" );

        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(response.id());
        organizationEntity.setKodOrganization(response.kodOrganization());
        organizationEntity.setAddress(response.address());
        organizationEntity.setName(response.name());
        organizationEntity.setTelephoneNumber(response.telephoneNumber());

        when(repository.findById(organizationId)).thenReturn(Optional.of(organizationEntity));

        OrganizationResponse actualResponse = adapter.findByOrganizationId(organizationId);

        assertEquals(response.id(), actualResponse.id());
        assertEquals(response.name(), actualResponse.name());
        assertEquals(response.kodOrganization(), actualResponse.kodOrganization());

        verify(repository, times(1)).findById(organizationId);
    }

    @Test
    public void findByOrganizationId_Fail() {
        Long organizationId = 1L;

        when(repository.findById(organizationId)).thenReturn(Optional.empty());

        OrganizationNotFoundException exception =
                assertThrows( OrganizationNotFoundException.class,
                        () -> adapter.findByOrganizationId(organizationId),
                        "Expected findPersonById() to throw OrganizationNotFoundException");

        assertEquals("can`t find organization by id 1", exception.getMessage());
        verify(repository, times(1)).findById(organizationId);
    }

    @Test
    public void findOrganizationByKod_Success() {
        String kodOrganization = "TestKod111";

        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(1L);
        organizationEntity.setKodOrganization(kodOrganization);
        organizationEntity.setAddress("Test address number 1");
        organizationEntity.setName("Test name organization");
        organizationEntity.setTelephoneNumber("000-111-22-33");

        OrganizationResponse response = new OrganizationResponse(1L,
                kodOrganization,
                "Test name organization",
                "000-111-22-33",
                "Test address number 1");

        when(repository.findByKodOrganization(kodOrganization)).thenReturn(Optional.of(organizationEntity));

        OrganizationResponse actualResponse = adapter.findByOrganizationKod(new FindOrganizationByKodRequest(kodOrganization));

        assertEquals(response.id(), actualResponse.id());
        assertEquals(response.name(), actualResponse.name());
        assertEquals(response.kodOrganization(), actualResponse.kodOrganization());

        verify(repository, times(1)).findByKodOrganization(kodOrganization);

    }

}