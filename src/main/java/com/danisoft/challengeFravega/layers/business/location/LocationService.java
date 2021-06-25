package com.danisoft.challengeFravega.layers.business.location;

import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import com.danisoft.challengeFravega.layers.persistence.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
    public LocationModel readNearestLocation(LocationDtoIn dto) {

        return this.repository.findById(1L).orElse(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public LocationModel createByDto(LocationDtoIn dto) {

        return this.saveOrUpdateByDto(new LocationModel(), dto);

    }

    @Transactional(rollbackFor = Exception.class)
    public LocationModel updateByDto(Long id, LocationDtoIn dto) {
        LocationModel model = this.getById(id);
        return this.saveOrUpdateByDto(model, dto);

    }

    private LocationModel saveOrUpdateByDto(LocationModel model, LocationDtoIn dto) {

        model.setAddress(dto.getAddress());
        model.setLatitude(dto.getLatitude());
        model.setLongitude(dto.getLongitude());

        this.validator.validateModel(model);

        return this.repository.save(model);

    }

    @Transactional(rollbackFor = Exception.class)
    public LocationModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new LocationModel());

    }
}
