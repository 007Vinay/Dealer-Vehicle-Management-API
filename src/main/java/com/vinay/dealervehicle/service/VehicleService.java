package com.vinay.dealervehicle.service;

import com.vinay.dealervehicle.model.Dealer;
import com.vinay.dealervehicle.model.SubscriptionType;
import com.vinay.dealervehicle.model.Vehicle;
import com.vinay.dealervehicle.repository.DealerRepository;
import com.vinay.dealervehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final DealerRepository dealerRepository;

    public VehicleService(VehicleRepository vehicleRepository, DealerRepository dealerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.dealerRepository = dealerRepository;
    }

    public Vehicle create(Long dealerId, Vehicle vehicle) {
        Dealer dealer = dealerRepository.findById(dealerId).orElseThrow(() -> new RuntimeException("Dealer not found"));
        vehicle.setDealer(dealer);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle updated) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setModel(updated.getModel());
        vehicle.setPrice(updated.getPrice());
        vehicle.setStatus(updated.getStatus());
        // if dealer change requested, update dealer reference
        if (updated.getDealer() != null && updated.getDealer().getId() != null) {
            Dealer newDealer = dealerRepository.findById(updated.getDealer().getId())
                    .orElseThrow(() -> new RuntimeException("Dealer not found"));
            vehicle.setDealer(newDealer);
        }
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getByDealerId(Long dealerId) {
        return vehicleRepository.findByDealerId(dealerId);
    }

    public List<Vehicle> getVehiclesForSubscription(SubscriptionType subscriptionType) {
        return vehicleRepository.findByDealerSubscriptionType(subscriptionType);
    }
}
