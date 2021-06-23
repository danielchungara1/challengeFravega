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

        return this.saveOrUpdateByDto(new WithdrawalPointModel(), dto);

    }

    @Transactional(rollbackFor = Exception.class)
    public WithdrawalPointModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new WithdrawalPointModel());

    }

    @Transactional(rollbackFor = Exception.class)
    public WithdrawalPointModel updateByDto(Long id, WithdrawalPointDto dto) {

        WithdrawalPointModel model = this.getById(id);

        return this.saveOrUpdateByDto(model, dto);

    }

    public WithdrawalPointModel saveOrUpdateByDto(WithdrawalPointModel model, WithdrawalPointDto dto) {

        model.setAddress(dto.getAddress());
        model.setCapacityM3(dto.getCapacityM3());
        model.setLatitude(dto.getLatitude());
        model.setLongitude(dto.getLongitude());

        this.validator.validateModel(model);

        return this.repository.save(model);

    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        this.validator.guaranteeExistModelById(id);
        this.repository.deleteById(id);
    }
}
