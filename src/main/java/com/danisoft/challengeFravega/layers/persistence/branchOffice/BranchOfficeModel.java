package com.danisoft.challengeFravega.layers.persistence.branchOffice;

import com.danisoft.challengeFravega.layers.persistence.location.LocationModel;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "branch_office")
@Setter
@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BranchOfficeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "attention")
    private String attention;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", unique = true)
    private LocationModel location;

    public BranchOfficeModel(){
        this.location =  new LocationModel();
    }

}
