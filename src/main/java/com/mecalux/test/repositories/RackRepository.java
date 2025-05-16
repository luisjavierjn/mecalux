package com.mecalux.test.repositories;

import com.mecalux.test.domain.entities.Rack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RackRepository extends PagingAndSortingRepository<Rack, Integer>, CrudRepository<Rack, Integer> {
	List<Rack> findByWarehouseId(Integer warehouseId);
	Page<Rack> findByWarehouseId(Integer warehouseId, Pageable pageable);
}
