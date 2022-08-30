package com.example.Crud1_App.controller;

import org.json.simple.*;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.Crud1_App.model.fruit;
import com.example.Crud1_App.dao.CityDao;
import com.example.Crud1_App.model.CityModel;

@RestController
public class Crud1_AppController {
	
	@Autowired
	public CityDao cityDao;
	
	@Autowired
	EntityManager em;
	
	@RequestMapping(value="/test")
	public String testMethod() {
		return "Hello.. test API for crud1_App got run";
	}
	
	@PostMapping("/savecity")
	public String savecity(@RequestBody CityModel city) {
		cityDao.save(city);
		return "city saved : " + city.getId();
	}

	@GetMapping("/getcity")
	public List<CityModel> getcity() {
		return (List<CityModel>) cityDao.findAll();
	}
	
	@GetMapping("/getcitybyid/{id}")
	public Optional<CityModel> getcitybyid(@PathVariable("id") int id) {
		return cityDao.findById(id);
	}
	
	@GetMapping("/getcitybyCountryCode/{countrycode}")
	public Optional<CityModel> getcitybyCountryCode(@PathVariable("countrycode") String countrycode) {
		return cityDao.findBycountrycode(countrycode);
	}
	
	
	@PutMapping("/updatecity/{id}")
	public String updatecity(@RequestBody CityModel city) {
		cityDao.save(city);
		return "city updated : " + city.getId();
	}
	
	@DeleteMapping("/deletecity/{id}")
	public String deletecity(@PathVariable("id") int id) {
		cityDao.deleteById(id);
		return "city deleted : " + id;
	}
	
	@PostMapping("/JsonTest")
	public JSONObject JsonTest(@RequestBody JSONObject jSONObject) {
		jSONObject.put("address", "Waki");
		jSONObject.put("name", "SJ");
		return jSONObject;
	}
	
	@PostMapping("/getSortedData")
	public String getSortedData(@RequestBody List<fruit> fruits) {
		List<fruit> obj = fruits;
		
		// HashMap created to put record in KEY,VALUES format.
		TreeMap<Integer,fruit> hm = new TreeMap<Integer,fruit>();
		
		// puting all Values into HashMap 
		for(int i=0;i<obj.size();i++) {
			fruit obj1 = obj.get(i);
				hm.put(obj1.getQuantity(),obj1);
		}
		
		// Actual Descendign Sorting is Done Usign TreeMap.
//		hm.descendingMap();
		Map<Integer, fruit> map = new TreeMap<Integer,fruit>(hm).descendingMap();
		
		String sortedList = "";
		for(fruit str : map.values()) {
			sortedList = sortedList + " " + str;
		}
		
		return sortedList;
	}
	
	@GetMapping("/getAnyDataBySql/{pid}")
	public String getAnyDataBySql(@PathVariable("pid") int pid) {
		Query query = em.createNativeQuery("select * FROM city WHERE population >= ?1");
		query.setParameter(1, pid);
		List<Object> res = query.getResultList();
	
		String str1 = " ";
		for(int i=0;i<res.size();i++) {
//			Object[] obj = res.get(i);
		}
		
		HashMap<String,CityModel> map1 = new HashMap<String,CityModel>();
		CityModel cm = new CityModel();
		
		
		HashMap<String,Integer> map2 = new HashMap<String,Integer>();
		
		
		return str1.toString();
	}
	
}