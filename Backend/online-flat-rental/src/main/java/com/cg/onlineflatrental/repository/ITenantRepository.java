package com.cg.onlineflatrental.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.Tenant;


@Repository
public interface ITenantRepository extends JpaRepository<Tenant, Integer>{



	

}