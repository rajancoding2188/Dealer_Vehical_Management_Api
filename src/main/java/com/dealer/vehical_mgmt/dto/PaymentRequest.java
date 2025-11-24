package com.dealer.vehical_mgmt.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long dealerId;
    private Double amount;
    private String method;//upi or card or patym

}
