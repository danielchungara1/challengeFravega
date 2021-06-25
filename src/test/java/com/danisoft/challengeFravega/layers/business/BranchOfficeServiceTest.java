package com.danisoft.challengeFravega.layers.business;

import com.danisoft.challengeFravega.TestContainersBase;
import com.danisoft.challengeFravega.layers.access.branchOffice.BranchOfficeDtoIn;
import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import com.danisoft.challengeFravega.layers.business.branchOffice.BranchOfficeService;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BranchOfficeServiceTest extends TestContainersBase {

    @Autowired
    BranchOfficeService service;


    final String ADDRESS = "Av. Corrientes 3889, Capital Federal";
    final String ATTENTION = "LU/SA: 10:00 a 18:00hs";
    final BigDecimal LATITUDE = BigDecimal.valueOf(-34.603002);
    final BigDecimal LONGITUDE = BigDecimal.valueOf(-58.419087);

    @Test
    void createBranchOfficeByDtoSuccess() {

        BranchOfficeDtoIn dto = BranchOfficeDtoIn.builder()
                .attention(ATTENTION)
                .location(LocationDtoIn.builder()
                        .address(ADDRESS)
                        .latitude(LATITUDE)
                        .longitude(LONGITUDE)
                        .build())
                .build();

        BranchOfficeModel model = service.createByDto(dto);

        assertNotNull(model);
        assertNotNull(model.getId());
        assertEquals(ATTENTION, model.getAttention());
        assertEquals(ADDRESS, model.getLocation().getAddress());
        assertEquals(LATITUDE, model.getLocation().getLatitude());
        assertEquals(LONGITUDE, model.getLocation().getLongitude());

        log.info(">>> Branch Office created with ID {}", model.getId().toString());
    }

    @Test
    void createBranchOfficeByDtoWithoutCoordinates() {

        BranchOfficeDtoIn dto = BranchOfficeDtoIn.builder()
                .attention(ATTENTION)
                .location(LocationDtoIn.builder()
                        .address(ADDRESS)
                        .build())
                .build();

        assertThrows(BusinessException.class, () -> this.service.createByDto(dto));

    }
}