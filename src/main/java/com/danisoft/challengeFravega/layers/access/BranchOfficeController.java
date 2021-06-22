package com.danisoft.challengeFravega.layers.access;

import com.danisoft.challengeFravega.layers.business.BranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchOfficeController {

    private final BranchOfficeService service;

    @Autowired
    public BranchOfficeController(BranchOfficeService service) {
        this.service = service;
    }

    @PostMapping(Endpoints.BRANCH_OFFICE)
    public ResponseDto create(@RequestBody BranchOfficeDto branchOfficeDto) {

        return ResponseDto.builder()
                .message("Branch Office created.")
                .data(this.service.createByDto(branchOfficeDto), BranchOfficeDto.class)
                .build();
    }

}
