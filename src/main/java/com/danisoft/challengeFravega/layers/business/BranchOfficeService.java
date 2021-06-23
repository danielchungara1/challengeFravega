package com.danisoft.challengeFravega.layers.business;

import com.danisoft.challengeFravega.layers.access.branchOffice.BranchOfficeDto;
import com.danisoft.challengeFravega.layers.access.branchOffice.BranchOfficeValidator;
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

        BranchOfficeModel model = BranchOfficeModel.builder()
                .address(dto.getAddress())
                .attention(dto.getAttention())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();

        this.validator.validateModel(model);

        return this.repository.save(model);
    }
}
