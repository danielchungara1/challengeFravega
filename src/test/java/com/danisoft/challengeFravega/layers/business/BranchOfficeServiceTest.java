package com.danisoft.challengeFravega.layers.business;

import com.danisoft.challengeFravega.TestContainersBase;
import com.danisoft.challengeFravega.layers.access.branchOffice.BranchOfficeDto;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BranchOfficeServiceTest extends TestContainersBase {

    @Autowired
    BranchOfficeService service;

    @Test
    void createBranchOfficeByDtoSuccess() {

        final String ADDRESS = "Av. Corrientes 3889, Capital Federal";
        final String ATTENTION = "LU/SA: 10:00 a 18:00hs";
        final BigDecimal LATITUDE = BigDecimal.valueOf(-34.603002);
        final BigDecimal LONGITUDE = BigDecimal.valueOf(-58.419087);


        BranchOfficeDto dto = BranchOfficeDto.builder()
                .address(ADDRESS)
                .attention(ATTENTION)
                .latitude(LATITUDE)
                .longitude(LONGITUDE)
                .build();

        BranchOfficeModel model = service.createByDto(dto);

        assertNotNull(model);
        assertNotNull(model.getId());
        assertEquals(ADDRESS, model.getAddress());
        assertEquals(ATTENTION, model.getAttention());
        assertEquals(LATITUDE, model.getLatitude());
        assertEquals(LONGITUDE, model.getLongitude());

        log.info(">>> Branch Office created with ID {}", model.getId().toString());
    }
}