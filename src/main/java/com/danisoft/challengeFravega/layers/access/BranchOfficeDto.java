package com.danisoft.challengeFravega.layers.access;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BranchOfficeDto {
    private String address;
    private String attention;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
