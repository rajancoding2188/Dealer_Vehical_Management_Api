package com.dealer.vehical_mgmt.service;

import com.dealer.vehical_mgmt.dto.PaymentRequest;
import com.dealer.vehical_mgmt.entity.Dealer;
import com.dealer.vehical_mgmt.entity.Payment;
import com.dealer.vehical_mgmt.entity.PaymentStatus;
import com.dealer.vehical_mgmt.repository.DealerRepository;
import com.dealer.vehical_mgmt.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    private DealerRepository dealerRepo;

    @Autowired
    private PaymentRepository paymentRepo;


    @Override
    public Payment createPayment(PaymentRequest request)
    {

        // 1. Validate amount
        if (request.getAmount() == null || request.getAmount() <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }

        // 2. Validate dealer
        Dealer dealer = dealerRepo.findById(request.getDealerId())
                .orElseThrow(() -> new RuntimeException("Dealer not found"));

        // 3. Create token
        String token = UUID.randomUUID().toString();

        // 4. Build payment
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setMethod(request.getMethod());
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setCreatedAt(LocalDateTime.now());
        payment.setDealer(dealer);
        payment.setToken(token);

        // 5. Save
        return paymentRepo.save(payment);
    }

}



