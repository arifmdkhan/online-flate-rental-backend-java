package com.cg.onlineflatrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.FlatBooking;

@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking, Integer>{
	

}


