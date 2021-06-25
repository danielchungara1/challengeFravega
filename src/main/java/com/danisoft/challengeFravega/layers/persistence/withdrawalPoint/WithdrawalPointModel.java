package com.danisoft.challengeFravega.layers.persistence.withdrawalPoint;

import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "withdrawal_point")
@Setter
@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WithdrawalPointModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "capacity_m3")
    private BigDecimal capacityM3;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", unique = true)
    private LocationModel location;

    public WithdrawalPointModel(){
        this.location =  new LocationModel();
    }
}
