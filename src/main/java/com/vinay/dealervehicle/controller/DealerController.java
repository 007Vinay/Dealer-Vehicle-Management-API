package com.vinay.dealervehicle.controller;

import com.vinay.dealervehicle.model.Dealer;
import com.vinay.dealervehicle.model.SubscriptionType;
import com.vinay.dealervehicle.service.DealerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {
    private final DealerService dealerService;

    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @PostMapping
    public ResponseEntity<Dealer> create(@Valid @RequestBody Dealer dealer) {
        return ResponseEntity.ok(dealerService.create(dealer));
    }

    @GetMapping
    public ResponseEntity<List<Dealer>> getAll() {
        return ResponseEntity.ok(dealerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getById(@PathVariable Long id){
        return ResponseEntity.ok(dealerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealer> update(@PathVariable Long id, @Valid @RequestBody Dealer dealer) {
        return ResponseEntity.ok(dealerService.update(id, dealer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dealerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subscription/{type}")
    public ResponseEntity<List<Dealer>> bySubscription(@PathVariable SubscriptionType type) {
        return ResponseEntity.ok(dealerService.getBySubscription(type));
    }
}
