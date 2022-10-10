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

import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.service.FlatService;

//Description : This is Flat Controller


@RestController      
//@RequestMapping(value = "/flat",method = RequestMethod.GET)

public class FlatController {
	
	@Autowired
	FlatService flatService;


	
	@PostMapping("/flat")
	public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {

		return new ResponseEntity<>(flatService.addFlat(flat), HttpStatus.CREATED);
	}
	

	@PutMapping("/flat/{id}")
	public ResponseEntity<String> updateFlat(@RequestBody Flat flat,@PathVariable int id){
		
		Flat value = flatService.updateFlat(flat,id);
		ResponseEntity<String> flatvalue = new ResponseEntity<String>("Landlord with ID: "+value.getFlatId()+" successfully updated.",HttpStatus.ACCEPTED);
		return flatvalue;
	}


	@DeleteMapping("/flat/{flatId}")
	public ResponseEntity<String> deleteFlat(@PathVariable int flatId){
        flatService.deleteFlat(flatId);
        ResponseEntity<String> flatvalue = new ResponseEntity<String>("Flat with ID: "+flatId+" successfully deleted.",HttpStatus.OK);
        return flatvalue;
    }

	
	@GetMapping("/flat/{flatId}")
	public ResponseEntity<Flat> viewFlat(@PathVariable("flatId") int id) throws FlatNotFoundException {
		return new ResponseEntity<Flat>(flatService.viewFlat(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/flats")
	public ResponseEntity<List<Flat>> viewAllFlat() {
		List<Flat> allFlats = flatService.viewAllFlat();
		ResponseEntity<List<Flat>> entity = new ResponseEntity<List<Flat>>(allFlats, HttpStatus.OK);
		return entity;
	}
	
	 @GetMapping("flat/{cost}/{availability}")
	 public List<Flat> findByCostAndAvailability(@PathVariable("cost") float cost ,@PathVariable("availability") String availability){
	        return flatService.findByCostAndAvailability(cost,availability);
	    }
	
	
}
