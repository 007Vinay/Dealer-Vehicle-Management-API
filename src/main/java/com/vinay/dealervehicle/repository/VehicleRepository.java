package com.vinay.dealervehicle.repository;

import com.vinay.dealervehicle.model.Vehicle;
import com.vinay.dealervehicle.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByDealerId(Long dealerId);

    // JPQL to fetch vehicles whose dealer has a given subscription type
    @Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptionType = :subType")
    List<Vehicle> findByDealerSubscriptionType(@Param("subType") SubscriptionType subType);
}
