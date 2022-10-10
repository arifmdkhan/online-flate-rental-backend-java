package com.cg.onlineflatrental.repository;

import java.util.List;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.Flat;


@Repository
public interface IFlatRepository extends JpaRepository<Flat,Integer>{

	List<Flat> findByCostAndAvailability(float cost, String availability);

	

}
