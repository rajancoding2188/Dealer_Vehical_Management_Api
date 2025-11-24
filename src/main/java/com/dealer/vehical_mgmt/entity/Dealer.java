package com.dealer.vehical_mgmt.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "dealers")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealer_id;
    private String name;
    private String email;


    @Enumerated(EnumType.STRING)
    private  SubscriptionType subscriptionType;


}
