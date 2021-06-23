package com.danisoft.challengeFravega.layers.business.branchOffice;

import com.danisoft.challengeFravega.layers.access.branchOffice.BranchOfficeDto;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchOfficeService {

    private final BranchOfficeRepository repository;
    private final BranchOfficeValidator validator;

    @Autowired
    public BranchOfficeService(
            BranchOfficeRepository repository,
            BranchOfficeValidator validator
    ) {
        this.repository = repository;
        this.validator = validator;
    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel createByDto(BranchOfficeDto dto) {

        return this.saveOrUpdateByDto(new BranchOfficeModel(), dto);
    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new BranchOfficeModel());

    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel updateByDto(Long id, BranchOfficeDto dto) {

        BranchOfficeModel model = this.getById(id);

        return this.saveOrUpdateByDto(model, dto);

    }

    public BranchOfficeModel saveOrUpdateByDto(BranchOfficeModel model, BranchOfficeDto dto) {

        model.setAddress(dto.getAddress());
        model.setAttention(dto.getAttention());
        model.setLatitude(dto.getLatitude());
        model.setLongitude(dto.getLongitude());

        this.validator.validateModel(model);

        return this.repository.save(model);

    }
}
