package com.dealer.vehical_mgmt.controller;

import com.dealer.vehical_mgmt.entity.Vehical;

import com.dealer.vehical_mgmt.service.VehicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicals")
public class VehicalController
{
    @Autowired
    private VehicalService vehicalService;

    @PostMapping("/insert")
    public Vehical createVehicle(@RequestBody Vehical vehical)
    {
        return vehicalService.createVehicle(vehical);
    }

    @GetMapping("/all")
    public List<Vehical> getAllVehicles()
    {
        return vehicalService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehical getVehicleById(@PathVariable Long id)
    {
        return vehicalService.getVehicleById(id);
    }

 @PutMapping("/{id}")
 public Vehical updateVehicle(@PathVariable Long id, @RequestBody Vehical vehical)
 {
    return vehicalService.updateVehicle(id, vehical);
 }
 @DeleteMapping("/{id}")
 public void deleteVehicle(@PathVariable Long id)
 {
    vehicalService.deleteVehicle(id);
 }
 //question Task-1 done
    @GetMapping("/premium")
    public List<Vehical> getVehicalBPremiumDealer()
    {
        return vehicalService.getVehicalPremiumDealer();
    }


}
