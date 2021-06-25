package com.danisoft.challengeFravega.layers.access.branchOffice;

import com.danisoft.challengeFravega.layers.access.Endpoints;
import com.danisoft.challengeFravega.layers.access.ResponseDto;
import com.danisoft.challengeFravega.layers.business.branchOffice.BranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchOfficeController {

    private final BranchOfficeService service;

    @Autowired
    public BranchOfficeController(BranchOfficeService service) {
        this.service = service;
    }

    @PostMapping(Endpoints.BRANCH_OFFICE_CREATE_ONE)
    public ResponseDto createByDto(@RequestBody BranchOfficeDtoIn dto) {

        return ResponseDto.builder()
                .message("Branch Office created.")
                .data(this.service.createByDto(dto), BranchOfficeDtoOut.class)
                .build();
    }

    @GetMapping(Endpoints.BRANCH_OFFICE_READ_ONE)
    public ResponseDto getById(@PathVariable Long id) {
        return ResponseDto.builder()
                .message("Branch Office fetched.")
                .data(this.service.getById(id), BranchOfficeDtoOut.class)
                .build();
    }

    @PutMapping(Endpoints.BRANCH_OFFICE_UPDATE_ONE)
    public ResponseDto updateByDto(@PathVariable Long id, @RequestBody BranchOfficeDtoIn dto) {

        return ResponseDto.builder()
                .message("Branch Office updated.")
                .data(this.service.updateByDto(id, dto), BranchOfficeDtoOut.class)
                .build();
    }

    @DeleteMapping(Endpoints.BRANCH_OFFICE_DELETE_ONE)
    public ResponseDto deleteById(@PathVariable Long id) {

        this.service.deleteById(id);

        return ResponseDto.builder()
                .message("Branch Office deleted.")
                .build();
    }

}
