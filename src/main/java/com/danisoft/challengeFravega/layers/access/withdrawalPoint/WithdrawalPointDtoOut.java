package com.danisoft.challengeFravega.layers.access.withdrawalPoint;

import com.danisoft.challengeFravega.layers.access.location.LocationDtoOut;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalPointDtoOut {
    private Long id;
    private BigDecimal capacityM3;
    private LocationDtoOut location;
}
