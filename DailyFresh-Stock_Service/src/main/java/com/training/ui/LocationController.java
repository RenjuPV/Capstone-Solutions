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

import com.training.model.Location;
import com.training.service.LocationService;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/add")
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @GetMapping("/get/{id}")
    public Location getLocation(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping("/getAll")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PutMapping("/modify/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location) {
        return locationService.updateLocation(id, location);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "Location deleted successfully.";
    }
}
