package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.City;
import com.training.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/add")
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @GetMapping("/getCity/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @GetMapping("/allCities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PutMapping("/modify/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "City deleted successfully.";
    }
}