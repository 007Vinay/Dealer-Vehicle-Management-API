package com.vinay.dealervehicle.repository;

import com.vinay.dealervehicle.model.Dealer;
import com.vinay.dealervehicle.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
    List<Dealer> findBySubscriptionType(SubscriptionType subscriptionType);
}
