package com.cg.onlineflatrental.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.Landlord;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord,Integer> {

}