package com.dealer.vehical_mgmt.repository;

import com.dealer.vehical_mgmt.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DealerRepository extends JpaRepository<Dealer,Long> {

   // @Query("SELECT u FROM User u WHERE u.email = :email")
    //String  findByEmail(@Param("email") String email);
   Dealer findByEmail(String email);

   // Optional<User> findByEmail(String email);

    // Add custom query methods here if needed
}

