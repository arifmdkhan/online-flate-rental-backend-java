package com.cg.onlineflatrental.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.service.LandlordService;


@RestController
public class LandlordController {
	@Autowired
	private LandlordService ilandlordService;
	
	@PostMapping(value="/landlord")
	public ResponseEntity<String> addLandlord(@RequestBody Landlord landlord){
		Landlord value = ilandlordService.addLandlord(landlord);
		return new ResponseEntity<String>("Landlord with ID: "+value.getLandlordId()+" sucessfully created.",HttpStatus.CREATED);
	
	}
	
	@GetMapping("/landlord/{id}")
	public Landlord viewLandlordById(@PathVariable("id") Integer landlordId) throws LandlordNotFoundException{
		return ilandlordService.viewLandlord(landlordId);
		
	}
	
	@GetMapping("/landlords")
	public List<Landlord> viewAllLandlord(){
	 return ilandlordService.viewAllLandlord();
	}
	
	@DeleteMapping("/landlord/{id}")
	public ResponseEntity<String> deleteLandlord(@PathVariable Integer id) throws LandlordNotFoundException{
		 ilandlordService.deleteLandlord(id);
		 return new ResponseEntity<String>("Landlord sucessfully deleted.",HttpStatus.OK);
	}
	
	@PutMapping(value= "/landlord/{id}")
	public ResponseEntity<String> updateLandlord(@RequestBody Landlord landlord, @PathVariable int id) throws LandlordNotFoundException{
		Landlord value = ilandlordService.updateLandlord(id,landlord);
		return new ResponseEntity<String>("Landlord with ID: "+value.getLandlordId()+" sucessfully updated.",HttpStatus.ACCEPTED);
	}
	
}
	
