package com.danisoft.challengeFravega.layers.access.withdrawalPoint;

import com.danisoft.challengeFravega.layers.access.Endpoints;
import com.danisoft.challengeFravega.layers.access.ResponseDto;
import com.danisoft.challengeFravega.layers.business.withdrawalPoint.WithdrawalPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WithdrawalPointController {

    private final WithdrawalPointService service;

    @Autowired
    public WithdrawalPointController(WithdrawalPointService service) {
        this.service = service;
    }

    @PostMapping(Endpoints.WITHDRAWAL_POINT_CREATE_ONE)
    public ResponseDto createByDto(@RequestBody WithdrawalPointDto dto) {

        return ResponseDto.builder()
                .message("Withdrawal Point created.")
                .data(this.service.createByDto(dto), WithdrawalPointDto.class)
                .build();
    }

    @GetMapping(Endpoints.WITHDRAWAL_POINT_READ_ONE)
    public ResponseDto getById(@PathVariable Long id) {
        return ResponseDto.builder()
                .message("Withdrawal Point fetched.")
                .data(this.service.getById(id), WithdrawalPointDto.class)
                .build();
    }

    @PutMapping(Endpoints.WITHDRAWAL_POINT_UPDATE_ONE)
    public ResponseDto updateByDto(@PathVariable Long id, @RequestBody WithdrawalPointDto dto) {

        return ResponseDto.builder()
                .message("Withdrawal Point updated.")
                .data(this.service.updateByDto(id, dto), WithdrawalPointDto.class)
                .build();
    }

    @DeleteMapping(Endpoints.WITHDRAWAL_POINT_DELETE_ONE)
    public ResponseDto deleteById(@PathVariable Long id) {

        this.service.deleteById(id);

        return ResponseDto.builder()
                .message("Withdrawal Point deleted.")
                .build();
    }

}
