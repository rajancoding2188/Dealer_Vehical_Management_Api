package com.dealer.vehical_mgmt.repository;

import com.dealer.vehical_mgmt.entity.Vehical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  java.util.List;
@Repository
public interface VehicleRepository extends JpaRepository<Vehical, Long> {
   // List<Vehical> findByDealerId(Long dealerId);

    @Query("select v from Vehical v where v.dealer.dealer_id = :dealerId")
    List<Vehical> findByDealerId(@Param("dealerId") Long dealerId);

}

