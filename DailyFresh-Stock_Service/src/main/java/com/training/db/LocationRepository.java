package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}