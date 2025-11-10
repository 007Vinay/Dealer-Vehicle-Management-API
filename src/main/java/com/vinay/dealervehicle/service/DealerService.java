package com.vinay.dealervehicle.service;

import com.vinay.dealervehicle.model.Dealer;
import com.vinay.dealervehicle.model.SubscriptionType;
import com.vinay.dealervehicle.repository.DealerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {
    private final DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    public Dealer create(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    public Dealer update(Long id, Dealer updated) {
        Dealer dealer = dealerRepository.findById(id).orElseThrow(() -> new RuntimeException("Dealer not found"));
        dealer.setName(updated.getName());
        dealer.setEmail(updated.getEmail());
        dealer.setSubscriptionType(updated.getSubscriptionType());
        return dealerRepository.save(dealer);
    }

    public Dealer getById(Long id) {
        return dealerRepository.findById(id).orElseThrow(() -> new RuntimeException("Dealer not found"));
    }

    public List<Dealer> getAll() {
        return dealerRepository.findAll();
    }

    public void delete(Long id) {
        dealerRepository.deleteById(id);
    }

    public List<Dealer> getBySubscription(SubscriptionType type){
        return dealerRepository.findBySubscriptionType(type);
    }
}

