package com.danisoft.challengeFravega.layers.business;

import com.danisoft.challengeFravega.layers.access.BranchOfficeDto;
import com.danisoft.challengeFravega.layers.persistence.BranchOfficeModel;
import com.danisoft.challengeFravega.layers.persistence.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchOfficeService {

    private BranchOfficeRepository repository;

    @Autowired
    public BranchOfficeService(BranchOfficeRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel createByDto(BranchOfficeDto dto) {
        // Todo: Business validations
        BranchOfficeModel branchOfficeModel = BranchOfficeModel.builder()
                .address(dto.getAddress())
                .attention(dto.getAttention())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
        return this.repository.save(branchOfficeModel);
    }
}
