package com.example.Crud1_App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "fruits")
public class fruit {

	public fruit() {}
	
	public fruit(String name,int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	@Column(name ="name")
	String name;
	
	@Column(name = "quantity")
	int quantity;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return " name =  "+ getName() +" quantity = "+ getQuantity()+"";
	}
}
