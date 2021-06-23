package com.danisoft.challengeFravega.layers.access.withdrawalPoint;

import com.danisoft.challengeFravega.layers.access.Endpoints;
import com.danisoft.challengeFravega.layers.access.ResponseDto;
import com.danisoft.challengeFravega.layers.business.withdrawalPoint.WithdrawalPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
