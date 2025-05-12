package com.mecalux.test.repositories;

import com.mecalux.test.domain.entities.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<Rack, Integer> {
}
