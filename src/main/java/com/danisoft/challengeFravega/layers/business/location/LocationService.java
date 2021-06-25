package com.danisoft.challengeFravega.layers.business.location;

import com.danisoft.challengeFravega.layers.access.location.CoordinatesDtoIn;
import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import com.danisoft.challengeFravega.layers.persistence.location.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LocationService {

    private final LocationRepository repository;
    private final LocationValidator validator;

    @Autowired
    public LocationService(
            LocationRepository repository,
            LocationValidator validator
    ) {
        this.repository = repository;
        this.validator = validator;
    }

    @Transactional(rollbackFor = Exception.class)
    public LocationModel readNearestLocation(CoordinatesDtoIn dto) {

        Comparator<AbstractMap.SimpleEntry<LocationModel, BigDecimal>> simpleEntryComparator = Comparator.comparing(AbstractMap.SimpleEntry::getValue);

        return  this.repository.findAll()
                .parallelStream()
                .map(locationModel ->
                        new AbstractMap.SimpleEntry<>(locationModel, this.calculateDistance(dto, locationModel)))
                .peek(locationModelBigDecimalSimpleEntry -> log.info(locationModelBigDecimalSimpleEntry.toString()))
                .min(simpleEntryComparator)
                .orElseThrow(
                        () -> new BusinessException("Not exist any location nearest.")
                ).getKey();

    }

    /**
     * Calculate distance between 2 coordinates.
     * @param coordinate1 implements coordinate interface
     * @param coordinate2 implements coordinate interface
     * @return distance between 2 coordinates
     */
    private BigDecimal calculateDistance(CoordinatesDtoIn coordinate1, LocationModel coordinate2) {
        return BigDecimal.valueOf(1.5);
    }


    @Transactional(rollbackFor = Exception.class)
    public LocationModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new LocationModel());

    }
}
