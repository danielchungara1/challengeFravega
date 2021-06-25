package com.danisoft.challengeFravega.layers.business.withdrawalPoint;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.business.location.LocationValidator;
import com.danisoft.challengeFravega.layers.persistence.withdrawalPoint.WithdrawalPointModel;
import com.danisoft.challengeFravega.layers.persistence.withdrawalPoint.WithdrawalPointRepository;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawalPointValidator {

    private final WithdrawalPointRepository repository;
    private final LocationValidator locationValidator;

    @Autowired
    public WithdrawalPointValidator(
            WithdrawalPointRepository repository,
            LocationValidator locationValidator
    ) {
        this.repository = repository;
        this.locationValidator = locationValidator;
    }

    public void validateModel(WithdrawalPointModel model) {

        // Attention is not null
        if (model.getCapacityM3() == null) {
            BusinessException.throwException("capacityM3 is required.");
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
