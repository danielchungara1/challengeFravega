package com.danisoft.challengeFravega.layers.business.branchOffice;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeRepository;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchOfficeValidator {

    private final BranchOfficeRepository repository;

    @Autowired
    public BranchOfficeValidator(
            BranchOfficeRepository repository
    ) {
        this.repository = repository;
    }

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

    public void guaranteeExistModelById(Long id) {
        if (!this.repository.existsById(id)) {
            BusinessException.throwException("id not exist.");
        }
    }
}
