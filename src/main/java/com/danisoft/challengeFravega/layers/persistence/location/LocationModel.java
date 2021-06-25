package com.danisoft.challengeFravega.layers.persistence.location;

import com.danisoft.challengeFravega.layers.access.location.LocationDtoIn;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "location")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    public LocationModel(LocationDtoIn dto) {
        this.setLocationByDto(dto);
    }

    public void setLocationByDto(LocationDtoIn dto) {
        this.address = dto.getAddress();
        this.latitude = dto.getLatitude();
        this.longitude = dto.getLongitude();
    }
}
