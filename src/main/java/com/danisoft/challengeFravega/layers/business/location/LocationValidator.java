package com.danisoft.challengeFravega.layers.business.location;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class LocationValidator {

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

}
