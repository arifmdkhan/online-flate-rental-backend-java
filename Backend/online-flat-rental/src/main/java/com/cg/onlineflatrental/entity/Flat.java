package com.cg.onlineflatrental.entity;

import javax.persistence.CascadeType;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Flat")
public class Flat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flatId; 
	private float cost;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "houseNo")
	private FlatAddress flatAddress;
	private String availability;

	@ManyToOne
	@JoinColumn(name = "landlord_id")
	private Landlord landlord;
	
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flat(int flatId, float cost, FlatAddress flatAddress, String availability) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;
	}
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatid) {
		flatId = flatid;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAdress) {
		this.flatAddress = flatAdress;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Flat [FlatId=" + flatId + ", cost=" + cost + ", flatAdress=" + flatAddress + ", availability="
				+ availability + "]";
	}
	
	
}
