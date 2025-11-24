package com.dealer.vehical_mgmt.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vehicals")
@NoArgsConstructor
@AllArgsConstructor
public class Vehical
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Double price;

    @Enumerated(EnumType.STRING)
    private VehicalStatus status;

    @ManyToOne
    @JoinColumn(name = "dealer_id")//FK
    private  Dealer dealer;


}
