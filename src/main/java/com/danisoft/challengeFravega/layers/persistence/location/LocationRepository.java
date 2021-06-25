package com.danisoft.challengeFravega.layers.persistence.location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationModel, Long> {
}
