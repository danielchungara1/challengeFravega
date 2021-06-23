package com.danisoft.challengeFravega.layers.business.withdrawalPoint;

import com.danisoft.challengeFravega.layers.access.withdrawalPoint.WithdrawalPointDto;
import com.danisoft.challengeFravega.layers.persistence.withdrawalPoint.WithdrawalPointModel;
import com.danisoft.challengeFravega.layers.persistence.withdrawalPoint.WithdrawalPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WithdrawalPointService {

    private final WithdrawalPointRepository repository;
    private final WithdrawalPointValidator validator;

    @Autowired
    public WithdrawalPointService(
            WithdrawalPointRepository repository,
            WithdrawalPointValidator validator
    ) {
        this.repository = repository;
        this.validator = validator;
    }

    @Transactional(rollbackFor = Exception.class)
    public WithdrawalPointModel createByDto(WithdrawalPointDto dto) {

        WithdrawalPointModel model = WithdrawalPointModel.builder()
                .address(dto.getAddress())
                .capacityM3(dto.getCapacityM3())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();

        this.validator.validateModel(model);

        return this.repository.save(model);
    }

    @Transactional(rollbackFor = Exception.class)
    public WithdrawalPointModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new WithdrawalPointModel());

    }
}
