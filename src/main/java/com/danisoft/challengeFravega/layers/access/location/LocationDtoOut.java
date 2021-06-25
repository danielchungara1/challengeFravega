package com.danisoft.challengeFravega.layers.access.location;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDtoOut {

    private Long id;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
