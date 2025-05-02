package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.LocationRepository;
import com.training.model.Location;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location updateLocation(Long id, Location updatedLocation) {
        Location location = getLocationById(id);
        location.setName(updatedLocation.getName());
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}