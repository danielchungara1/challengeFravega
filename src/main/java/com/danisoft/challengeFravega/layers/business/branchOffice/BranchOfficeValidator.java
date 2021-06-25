package com.danisoft.challengeFravega.layers.business.branchOffice;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.business.location.LocationValidator;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeRepository;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchOfficeValidator {

    private final BranchOfficeRepository repository;
    private final LocationValidator locationValidator;


    @Autowired
    public BranchOfficeValidator(
            BranchOfficeRepository repository,
            LocationValidator locationValidator
    ) {
        this.repository = repository;
        this.locationValidator = locationValidator;
    }

    public void validateModel(BranchOfficeModel model) {

        // Attention is not null
        if (StringUtil.isEmpty(model.getAttention())) {
            BusinessException.throwException("attention is required.");
        }

        // Location validation
        this.locationValidator.validateModel(model.getLocation());

    }

    public void guaranteeExistModelById(Long id) {
        if (!this.repository.existsById(id)) {
            BusinessException.throwException("id not exist.");
        }
    }
}
