package com.danisoft.challengeFravega.layers.access.withdrawalPoint;

import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalPointDtoIn {
    private BigDecimal capacityM3;
    private LocationDtoIn location;
}
