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

    @PostMapping(Endpoints.BRANCH_OFFICE)
    public ResponseDto createByDto(@RequestBody BranchOfficeDto dto) {

        return ResponseDto.builder()
                .message("Branch Office created.")
                .data(this.service.createByDto(dto), BranchOfficeDto.class)
                .build();
    }

    @GetMapping(Endpoints.BRANCH_OFFICE_GET_ONE)
    public ResponseDto getById(@PathVariable Long id) {
        return ResponseDto.builder()
                .message("Branch Office fetched.")
                .data(this.service.getById(id), BranchOfficeDto.class)
                .build();
    }

}
