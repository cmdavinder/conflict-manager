package com.hcl.cm.repository.specification;


import com.hcl.cm.entities.CiReservation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.Map;

public class CiReservationSpecifications {

    public static Specification<CiReservation> byId(String name, Long id) {
        return (root, query, cb) -> cb.equal(root.get(name), id);
    }
}
