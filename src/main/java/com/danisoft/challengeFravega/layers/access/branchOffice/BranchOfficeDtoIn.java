package com.danisoft.challengeFravega.layers.access.branchOffice;

import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchOfficeDtoIn {

    private String attention;
    private LocationDtoIn location = new LocationDtoIn();

}
