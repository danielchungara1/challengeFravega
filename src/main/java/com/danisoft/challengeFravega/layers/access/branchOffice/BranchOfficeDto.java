package com.danisoft.challengeFravega.layers.access.branchOffice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BranchOfficeDto {
    private String address;
    private String attention;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
