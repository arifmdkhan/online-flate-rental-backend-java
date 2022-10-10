package com.cg.onlineflatrental.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.repository.ITenantRepository;


@Service
public class TenantService implements ITenantService {

	@Autowired
	private ITenantRepository tenantRepo;

	@Override
	public Tenant addTenant(Tenant tenant) {
		Tenant addTenant = tenantRepo.save(tenant);

		return addTenant;
	}

	@Override
	public Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException {
		Tenant t = tenantRepo.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant with Tenant Id " + tenantId + " does not exist."));
		t.setTenantName(tenant.getTenantName());
		t.setAge(tenant.getAge());
		t.setTaddress(tenant.getTaddress());

		return this.tenantRepo.save(t);

	}

	@Override
	public void deleteTenant(int tenantId) throws TenantNotFoundException {
		Tenant t = tenantRepo.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant with Tenant Id " + tenantId + " does not exist."));
		tenantRepo.delete(t);

	}

	@Override
	public Tenant viewTenant(int tenantId) throws TenantNotFoundException {

		return tenantRepo.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant with Tenant Id " + tenantId + " does not exist."));
	}

	@Override
	public List<Tenant> viewAllTenant() {
		List<Tenant> list = tenantRepo.findAll();
		return list;
	}

	@Override
	public boolean validateTenant(int tenantId) throws TenantNotFoundException {
		boolean flag=false;
		Optional<Tenant> t = tenantRepo.findById(tenantId);
		if(t== null) {
			throw new TenantNotFoundException("Wrong Input. Check Tenant Id Again");
		} else if(t.isPresent()) {
			flag=true;
		} else {
			throw new TenantNotFoundException ("Wrong Input. Check Tenant Id Again");
		}
		return flag;
	}

}
