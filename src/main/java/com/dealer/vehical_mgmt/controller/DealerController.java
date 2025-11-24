package com.dealer.vehical_mgmt.controller;

import com.dealer.vehical_mgmt.dto.PaymentRequest;
import com.dealer.vehical_mgmt.entity.Dealer;
import com.dealer.vehical_mgmt.entity.Payment;
import com.dealer.vehical_mgmt.service.DealerService;
import com.dealer.vehical_mgmt.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealers")
public class DealerController
{
    @Autowired

    private DealerService dealerService;
   @Autowired
    private PaymentService paymentService;

    @PostMapping("/insert")
    public ResponseEntity<String> createDealer(@RequestBody Dealer dealer)
    {
        String check =dealerService.checkDuplicate(dealer);
        if(check.equals("true"))
        {
            return ResponseEntity.badRequest().body("Dealer email id  already exists");
        }
        else
        {
            return ResponseEntity.ok(dealerService.createDealer(dealer));
        }
    }
    @GetMapping("/all")
    public List<Dealer> getAllDealers()
    {
        return dealerService.getAllDealers();
    }
    @GetMapping("/{id}")
    public Dealer getDealerById(@PathVariable Long id)
    {
        return dealerService.getDealerById(id);
    }
    @PutMapping("/{id}")
    public Dealer updateDealer(@PathVariable Long id, @RequestBody Dealer dealer)
    {
        return dealerService.updateDealer(id, dealer);
    }
    @DeleteMapping("/{id}")
    public void deleteDealer(@PathVariable Long id)
    {
        dealerService.deleteDealer(id);
    }
//task-2 payment done
    @PostMapping("/generateEPayment")
    public ResponseEntity<?> generatePayment(@RequestBody PaymentRequest request)
    {
        Payment payment = paymentService.createPayment(request);
        return ResponseEntity.ok(payment);
    }

}
