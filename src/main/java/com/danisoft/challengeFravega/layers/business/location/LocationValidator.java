package com.danisoft.challengeFravega.layers.business.location;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import com.danisoft.challengeFravega.layers.persistence.location.LocationRepository;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationValidator {

    private final LocationRepository repository;

    @Autowired
    public LocationValidator(
            LocationRepository repository
    ) {
        this.repository = repository;
    }

    public void validateModel(LocationModel model) {

        // Address is not null
        if (StringUtil.isEmpty(model.getAddress())) {
            BusinessException.throwException("address is required.");
        }

        // Latitude is not null
        if (model.getLatitude() == null) {
            BusinessException.throwException("latitude is required.");
        }

        // Longitude is not null
        if (model.getLongitude() == null) {
            BusinessException.throwException("longitude is required.");
        }

    }

    public void guaranteeExistModelById(Long id) {
        if (!this.repository.existsById(id)) {
            BusinessException.throwException("id not exist.");
        }
    }
}
