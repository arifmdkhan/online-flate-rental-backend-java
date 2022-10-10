package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.TenantNotFoundException; 


public interface ITenantService {

	public Tenant addTenant(Tenant tenant); 
	public Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException;
	public void deleteTenant(int tenantId) throws TenantNotFoundException; 
	public Tenant viewTenant(int id) throws TenantNotFoundException; 
	public List<Tenant>viewAllTenant();	
	public boolean validateTenant(int tenantId) throws TenantNotFoundException;
}