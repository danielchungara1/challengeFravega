package com.danisoft.challengeFravega.layers.access.branchOffice;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchOfficeDto {
    private Long id;
    private String address;
    private String attention;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
