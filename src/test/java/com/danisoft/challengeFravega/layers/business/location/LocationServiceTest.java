package com.danisoft.challengeFravega.layers.business.location;

import com.danisoft.challengeFravega.TestContainersBase;
import com.danisoft.challengeFravega.layers.access.location.CoordinatesDtoIn;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import com.danisoft.challengeFravega.layers.persistence.location.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class LocationServiceTest extends TestContainersBase {

    @Autowired
    LocationService locationService;

    @Autowired
    LocationRepository locationRepository;

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


    @Test
    void readNearestLocation() {

        // Save 2 locations
        LocationModel location1 = LocationModel.builder()
                .address("BZB, Hipólito Yrigoyen 48, B1842 Monte Grande, Provincia de Buenos Aires")
                .latitude(BigDecimal.valueOf(-34.815682))
                .longitude(BigDecimal.valueOf(-58.467629))
                .build();
        LocationModel location2 = LocationModel.builder()
                .address("Avenida Eva Perón 3045 San Jose - Temperley, B1834 Lomas de Zamora, Provincia de Buenos Aires")
                .latitude(BigDecimal.valueOf(-34.761355))
                .longitude(BigDecimal.valueOf(-58.361099))
                .build();
        location1 = this.locationRepository.save(location1);
        location2 = this.locationRepository.save(location2);

        // Read the nearest location to reference coordinate
        // My house: Ing. Huergo 3861 Monte Grande.
        final BigDecimal LATITUDE_REFERENCE = BigDecimal.valueOf(-34.779763);
        final BigDecimal LONGITUDE_REFERENCE = BigDecimal.valueOf(-58.485872);

        final CoordinatesDtoIn COORDINATE_REFERENCE = CoordinatesDtoIn.builder()
                .latitude(LATITUDE_REFERENCE)
                .longitude(LONGITUDE_REFERENCE)
                .build();
        LocationModel nearestLocation = this.locationService.readNearestLocation(COORDINATE_REFERENCE);

        // Assert
        assertEquals(location1, nearestLocation);
        assertEquals(location1.getLatitude(), nearestLocation.getLatitude());
        assertEquals(location1.getLongitude(), nearestLocation.getLongitude());

        // Remove 2 locations
        this.locationRepository.delete(location1);
        this.locationRepository.delete(location2);

    }
}