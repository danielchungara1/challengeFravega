package com.danisoft.challengeFravega.layers.business.location;

import com.danisoft.challengeFravega.TestContainersBase;
import com.danisoft.challengeFravega.layers.access.location.CoordinatesDtoIn;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class LocationServiceTest extends TestContainersBase {

    @Autowired
    LocationService locationService;

    @Test
    void calculateDistancePointsAtTheSameLongitude() {

        // Checked
        // https://www.meridianoutpost.com/resources/etools/calculators/calculator-latitude-longitude-distance.php?
        // https://www.geodatasource.com/distance-calculator
        final BigDecimal LATITUDE_REFERENCE = BigDecimal.valueOf(-34.779763);
        final BigDecimal LONGITUDE_REFERENCE = BigDecimal.valueOf(-58.485872);

        final CoordinatesDtoIn COORDINATE_REFERENCE = CoordinatesDtoIn.builder()
                .latitude(LATITUDE_REFERENCE)
                .longitude(LONGITUDE_REFERENCE)
                .build();

        final LocationModel COORDINATE_2 = LocationModel.builder()
                .latitude(BigDecimal.valueOf(-33.779763))
                .longitude(LONGITUDE_REFERENCE)
                .build();

        BigDecimal distance = this.locationService.calculateDistance(COORDINATE_REFERENCE, COORDINATE_2);

        assertTrue(BigDecimal.valueOf(111.19).compareTo(distance) == 0);

    }
}