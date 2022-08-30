package com.example.Crud1_App.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Crud1_App.model.CityModel;

public interface CityDao extends CrudRepository<CityModel, Integer>{
	
	Optional<CityModel> findBycountrycode(String countrycode);
}