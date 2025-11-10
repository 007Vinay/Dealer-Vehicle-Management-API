package com.vinay.dealervehicle.controller;

import com.vinay.dealervehicle.model.SubscriptionType;
import com.vinay.dealervehicle.model.Vehicle;
import com.vinay.dealervehicle.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Create vehicle for dealerId
    @PostMapping("/dealer/{dealerId}")
    public ResponseEntity<Vehicle> create(@PathVariable Long dealerId, @Valid @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.create(dealerId, vehicle));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.update(id, vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dealer/{dealerId}")
    public ResponseEntity<List<Vehicle>> byDealer(@PathVariable Long dealerId) {
        return ResponseEntity.ok(vehicleService.getByDealerId(dealerId));
    }

    // THE REQUIRED API: fetch all vehicles that belong to PREMIUM dealers only
    @GetMapping("/premium-dealers")
    public ResponseEntity<List<Vehicle>> vehiclesOfPremiumDealers() {
        List<Vehicle> vehicles = vehicleService.getVehiclesForSubscription(SubscriptionType.PREMIUM);
        return ResponseEntity.ok(vehicles);
    }

    // More generic: filter by subscription type
    @GetMapping("/by-dealer-subscription/{subscriptionType}")
    public ResponseEntity<List<Vehicle>> vehiclesByDealerSubscription(@PathVariable SubscriptionType subscriptionType) {
        return ResponseEntity.ok(vehicleService.getVehiclesForSubscription(subscriptionType));
    }
}

