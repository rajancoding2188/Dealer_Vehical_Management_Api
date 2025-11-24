package com.dealer.vehical_mgmt.service;


import com.dealer.vehical_mgmt.entity.Dealer;
import com.dealer.vehical_mgmt.entity.SubscriptionType;
import com.dealer.vehical_mgmt.entity.Vehical;
import com.dealer.vehical_mgmt.repository.DealerRepository;
import com.dealer.vehical_mgmt.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicalServiceImpl implements VehicalService {
    @Autowired
    private VehicleRepository vehicleRepos;

    @Autowired
    private DealerRepository dealerRepos;


    @Override
    public Vehical createVehicle(Vehical vehicle) {
        return vehicleRepos.save(vehicle);
    }

    @Override
    public Vehical getVehicleById(Long id) {
        return vehicleRepos.findById(id).orElse(null);
    }

    @Override
    public List<Vehical> getAllVehicles() {
        return vehicleRepos.findAll();
    }

    @Override
    public Vehical updateVehicle(Long id, Vehical vehical) {
        Vehical update = vehicleRepos.findById(id).orElse(null);

        if (update != null) {
            update.setModel(vehical.getModel());
            update.setPrice(vehical.getPrice());
           update.setStatus(vehical.getStatus());
            
            return vehicleRepos.save(update);
        } else {
            throw new RuntimeException("Vehicle not found");
        }
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepos.deleteById(id);

    }

    @Override
    public List<Vehical> getVehicalPremiumDealer() {
        // Get all premium dealer
        List<Dealer> premiumDealers = dealerRepos.findAll().stream().
                filter(dealer -> dealer.getSubscriptionType() == SubscriptionType.PREMIUM).toList();
        // Get all vehicles from premium dealers
        List<Vehical> result = new ArrayList<>();
        for (Dealer dealer : premiumDealers)
        {
            System.out.println(dealer.getDealer_id());
            System.out.println(dealer.getSubscriptionType());
           result.addAll(vehicleRepos.findByDealerId(dealer.getDealer_id()));
            System.out.println(result);
        }
        return result;
    }

}
