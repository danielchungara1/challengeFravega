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

    @PostMapping(Endpoints.WITHDRAWAL_POINT)
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

}
