package com.danisoft.challengeFravega.layers.access.branchOffice;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class BranchOfficeValidator {

    public void validateModel(BranchOfficeModel model) {

        // Address is not null
        if (StringUtil.isEmpty(model.getAddress())) {
            BusinessException.throwException("address is required.");
        }

        // Attention is not null
        if (StringUtil.isEmpty(model.getAttention())) {
            BusinessException.throwException("attention is required.");
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