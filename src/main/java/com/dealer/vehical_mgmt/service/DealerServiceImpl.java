package com.dealer.vehical_mgmt.service;

import com.dealer.vehical_mgmt.entity.Dealer;
import com.dealer.vehical_mgmt.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository dealerrepos;


    @Override
    public String createDealer(Dealer dealer) {
        Dealer dealer1 = dealerrepos.save(dealer);
        return "true";


    }

    @Override
    public Dealer getDealerById(Long id) {
        return dealerrepos.findById(id).get();
    }

    @Override
    public List<Dealer> getAllDealers() {
        return dealerrepos.findAll();
    }

    @Override
    public Dealer updateDealer(Long id, Dealer newdealer) {
        Dealer updateDealer = dealerrepos.findById(id).orElse(null);
        if (updateDealer != null) {
            updateDealer.setName(newdealer.getName());
            updateDealer.setEmail(newdealer.getEmail());
            return dealerrepos.save(updateDealer);
        } else {
            throw new RuntimeException("Dealer not found");
        }


    }

    @Override
    public void deleteDealer(Long id) {
        dealerrepos.deleteById(id);
    }

    @Override
    public String checkDuplicate(Dealer dealer) {


        //dealerrepos.findByEmail(dealer.getEmail());

        String email = dealer.getEmail();
        //String str=dealerrepos.findByEmail(email);
        System.out.println(dealerrepos.findByEmail(email));
        // ;
        if (dealerrepos.findByEmail(email) != null) {
            return "true";
        } else {
            return "false";
        }

    }
}
