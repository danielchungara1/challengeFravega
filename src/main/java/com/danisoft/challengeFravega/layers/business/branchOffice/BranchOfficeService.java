package com.danisoft.challengeFravega.layers.business.branchOffice;

import com.danisoft.challengeFravega.layers.access.branchOffice.BranchOfficeDtoIn;
import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import com.danisoft.challengeFravega.layers.business.location.LocationService;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeModel;
import com.danisoft.challengeFravega.layers.persistence.branchOffice.BranchOfficeRepository;
import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchOfficeService {

    private final BranchOfficeRepository repository;
    private final BranchOfficeValidator validator;
    private final LocationService locationService;

    @Autowired
    public BranchOfficeService(
            BranchOfficeRepository repository,
            BranchOfficeValidator validator,
            LocationService locationService
    ) {
        this.repository = repository;
        this.validator = validator;
        this.locationService = locationService;
    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel createByDto(BranchOfficeDtoIn dto) {

        BranchOfficeModel model = new BranchOfficeModel();
        model.setLocation(new LocationModel(dto.getLocation()));

        return this.saveOrUpdateByDto(model, dto);
    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel getById(Long id) {

        this.validator.guaranteeExistModelById(id);

        return this.repository.findById(id).orElse(new BranchOfficeModel());

    }

    @Transactional(rollbackFor = Exception.class)
    public BranchOfficeModel updateByDto(Long id, BranchOfficeDtoIn dto) {

        BranchOfficeModel model = this.getById(id);

        LocationModel locationModel = model.getLocation();
        LocationDtoIn locationDto = dto.getLocation();
        locationModel.setAddress(locationDto.getAddress());
        locationModel.setLatitude(locationDto.getLatitude());
        locationModel.setLongitude(locationDto.getLongitude());

        return this.saveOrUpdateByDto(model, dto);

    }

    public BranchOfficeModel saveOrUpdateByDto(BranchOfficeModel model, BranchOfficeDtoIn dto) {

        model.setAttention(dto.getAttention());
        
        this.validator.validateModel(model);

        return this.repository.save(model);

    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        this.validator.guaranteeExistModelById(id);
        this.repository.deleteById(id);
    }
}
