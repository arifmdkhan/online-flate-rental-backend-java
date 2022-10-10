package com.cg.onlineflatrental.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.repository.IFlatRepository;


@Service
public class FlatService implements IFlatService{
		 
		@Autowired
		private IFlatRepository flatRepository;

		@Override
		public Flat addFlat(Flat flat) {
			
			Flat fl = flatRepository.save(flat);
			return fl;
		}
	
		@Override	
		public  Flat updateFlat(Flat flat,int flatId) throws FlatNotFoundException {
			
			Flat value=flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Flat with id "+flat.getFlatId()+" does not exist."));
			value.setCost(flat.getCost());
			value.setAvailability(flat.getAvailability());
			value.setFlatAddress(flat.getFlatAddress());
			return flatRepository.save(value);
			
		}
		
			
			

		@Override	
		public void deleteFlat(int id)throws FlatNotFoundException{
			
			Flat value=flatRepository.findById(id).orElseThrow(()->new FlatNotFoundException("Flat with id "+id+" does not exist."));;
			flatRepository.delete(value);
		}
		
		@Override
		public Flat viewFlat(int flatId) {
			return flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Flat With Given Id :"+flatId+" Not Available!"));
		}
		
		
		
		@Override
		public List<Flat> viewAllFlat() {
			return flatRepository.findAll();
		}
		
		@Override
		 public List<Flat> findByCostAndAvailability(float cost,String availability){
	         return flatRepository.findByCostAndAvailability(cost,availability);
	     }
		
}

