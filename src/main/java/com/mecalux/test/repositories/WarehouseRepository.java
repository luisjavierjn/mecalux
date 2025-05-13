package com.mecalux.test.repositories;

import com.mecalux.test.domain.entities.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends PagingAndSortingRepository<Warehouse, Integer>, CrudRepository<Warehouse, Integer> {
}
