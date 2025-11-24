package com.dealer.vehical_mgmt.service;

import com.dealer.vehical_mgmt.dto.PaymentRequest;
import com.dealer.vehical_mgmt.entity.Payment;

public interface PaymentService {

Payment createPayment(PaymentRequest request);
}
