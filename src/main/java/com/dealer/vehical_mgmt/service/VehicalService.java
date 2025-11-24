package com.dealer.vehical_mgmt.service;



import com.dealer.vehical_mgmt.entity.Vehical;

import java.util.List;

public interface VehicalService
{
    public Vehical createVehicle(Vehical vehicle);
    public Vehical getVehicleById(Long id);
    public List<Vehical> getAllVehicles();
    public Vehical updateVehicle(Long id, Vehical vehicle);
    public void deleteVehicle(Long id);
    public List<Vehical> getVehicalPremiumDealer();

}
