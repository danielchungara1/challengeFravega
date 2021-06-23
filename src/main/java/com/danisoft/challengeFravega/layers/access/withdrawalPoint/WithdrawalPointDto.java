package com.danisoft.challengeFravega.layers.access.withdrawalPoint;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalPointDto {
    private String address;
    private BigDecimal capacityM3;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
