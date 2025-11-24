package com.dealer.vehical_mgmt.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "payments")
public class Payment
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long paymentId;
        private Double amount;

        @Enumerated(EnumType.STRING)
        private PaymentStatus status;

        private String token;

        private String method;

        private LocalDateTime createdAt;

        @ManyToOne
        @JoinColumn(name = "dealer_id")
        private Dealer dealer;

}

