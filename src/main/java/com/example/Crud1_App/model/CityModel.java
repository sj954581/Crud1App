package com.example.Crud1_App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "city")
public class CityModel {
	
//	public CityModel() {}
//	
//	public CityModel(int id,String name,String countrycode, String district,int population) {
//
//		this.id = id;
//		this.name = name;
//		this.countrycode = countrycode;
//		this.district = district;
//		this.population = population;
//	}
	
	@Id
	@GeneratedValue
	public int id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="countrycode")
	public String countrycode;
	
	@Column(name="district")
	public String district;
	
	@Column(name="population")
	public int population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ id = " + getId() + " name = " + getName() + "countrycode = " + getCountrycode() + " ]";
	}
		
}