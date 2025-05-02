package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
