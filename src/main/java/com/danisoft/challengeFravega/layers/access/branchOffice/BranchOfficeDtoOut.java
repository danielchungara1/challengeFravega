package com.danisoft.challengeFravega.layers.access.branchOffice;

import com.danisoft.challengeFravega.layers.access.location.LocationDtoOut;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchOfficeDtoOut {

    private Long id;
    private String attention;
    private LocationDtoOut location;

}
