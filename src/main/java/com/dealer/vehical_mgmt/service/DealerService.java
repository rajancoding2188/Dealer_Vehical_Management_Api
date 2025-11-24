package com.dealer.vehical_mgmt.service;

import com.dealer.vehical_mgmt.entity.Dealer;

import java.util.List;

public interface DealerService {
    public String createDealer(Dealer dealer);

    public Dealer getDealerById(Long id);

    public List<Dealer> getAllDealers();

    public Dealer updateDealer(Long id, Dealer dealer);

    public void deleteDealer(Long id);

    public String checkDuplicate(Dealer dealer);
}
