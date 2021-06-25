package com.danisoft.challengeFravega.layers.business.withdrawalPoint;

import com.danisoft.challengeFravega.layers.access.withdrawalPoint.WithdrawalPointDtoIn;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
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
    public WithdrawalPointModel createByDto(WithdrawalPointDtoIn dto) {

        WithdrawalPointModel model = new WithdrawalPointModel();
        model.setLocation(new LocationModel(dto.getLocation()));

        return this.saveOrUpdateByDto(model, dto);

    }

    @Transactional(rollbackFor = Exception.class)
    public WithdrawalPointModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new WithdrawalPointModel());

    }

    @Transactional(rollbackFor = Exception.class)
    public WithdrawalPointModel updateByDto(Long id, WithdrawalPointDtoIn dto) {

        WithdrawalPointModel model = this.getById(id);
        model.getLocation().setLocationByDto(dto.getLocation());

        return this.saveOrUpdateByDto(model, dto);

    }

    public WithdrawalPointModel saveOrUpdateByDto(WithdrawalPointModel model, WithdrawalPointDtoIn dto) {

        model.setCapacityM3(dto.getCapacityM3());

        this.validator.validateModel(model);

        return this.repository.save(model);

    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        this.validator.guaranteeExistModelById(id);
        this.repository.deleteById(id);
    }
}
