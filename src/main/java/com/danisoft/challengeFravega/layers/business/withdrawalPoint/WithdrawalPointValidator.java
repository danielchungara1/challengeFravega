package com.danisoft.challengeFravega.layers.business.withdrawalPoint;

import com.danisoft.challengeFravega.layers.business.BusinessException;
import com.danisoft.challengeFravega.layers.persistence.withdrawalPoint.WithdrawalPointModel;
import com.danisoft.challengeFravega.layers.persistence.withdrawalPoint.WithdrawalPointRepository;
import com.danisoft.challengeFravega.shared.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WithdrawalPointValidator {

    private final WithdrawalPointRepository repository;

    @Autowired
    public WithdrawalPointValidator(
            WithdrawalPointRepository repository
    ) {
        this.repository = repository;
    }

    public void validateModel(WithdrawalPointModel model) {

        // Address is not null
        if (StringUtil.isEmpty(model.getAddress())) {
            BusinessException.throwException("address is required.");
        }

        // Attention is not null
        if (model.getCapacityM3() == null) {
            BusinessException.throwException("capacityM3 is required.");
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
