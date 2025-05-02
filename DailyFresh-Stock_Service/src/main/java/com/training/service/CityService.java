package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.CityRepository;
import com.training.model.City;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City updateCity(Long id, City updatedCity) {
        City city = getCityById(id);
        city.setName(updatedCity.getName());
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}