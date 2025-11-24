package com.dealer.vehical_mgmt.repository;

import com.dealer.vehical_mgmt.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>
{

}
