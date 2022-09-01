package com.example.Crud1_App.controller;

import org.json.simple.*;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.jdbc.core.JdbcTemplate;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class Crud1_AppController {
	
	@Autowired
	EntityManager em;
	
	@GetMapping("/getCompanyDetails/{name}")
	public String getCompanyDetails(@PathVariable("name") String name) throws JsonProcessingException {
		String sqlString = "SELECT \r\n" + 
				"	eims_ua_company.cid AS eims_ua_company_cid,\r\n" + 
				"	eims_ua_company.name AS eims_ua_company_name,\r\n" + 
				"	eims_ua_company.description AS eims_ua_company_description,\r\n" + 
				"	eims_ua_company.website AS eims_ua_company_website,\r\n" + 
				"	eims_ua_company.foundedyear AS eims_ua_company_foundedyear,\r\n" + 
				"	eims_ua_company.logo AS eims_ua_company_logo,\r\n" + 
				"	eims_ua_company.country AS eims_ua_company_country,\r\n" + 
				"	eims_ua_company.flag AS eims_ua_company_flag,\r\n" + 
				"	eims_ua_company.createddate AS eims_ua_company_createddate,\r\n" + 
				"	\r\n" + 
				"	eims_ua_technology.tid AS eims_ua_technology_tid,\r\n" + 
				"	eims_ua_technology.cid AS eims_ua_technology_cid,\r\n" + 
				"	eims_ua_technology.name AS eims_ua_technology_name,\r\n" + 
				"	eims_ua_technology.description AS eims_ua_technology_description,\r\n" + 
				"	eims_ua_technology.flag AS eims_ua_technology_flag,\r\n" + 
				"	eims_ua_technology.createddate AS eims_ua_technology_createddate,\r\n" + 
				"	\r\n" + 
				"	eims_ua_technology_files.id AS eims_ua_technology_files_id,\r\n" + 
				"	eims_ua_technology_files.tid AS eims_ua_technology_files_tid,\r\n" + 
				"	eims_ua_technology_files.url AS eims_ua_technology_files_url,\r\n" + 
				"	eims_ua_technology_files.type AS eims_ua_technology_files_type,\r\n" + 
				"	eims_ua_technology_files.flag AS eims_ua_technology_files_flag,\r\n" + 
				"	eims_ua_technology_files.createddate AS eims_ua_technology_files_createddate\r\n" + 
				"FROM \r\n" + 
				"	eims_ua_company\r\n" + 
				"	INNER JOIN eims_ua_technology ON \r\n" + 
				"	eims_ua_company.cid = eims_ua_technology.cid\r\n" + 
				"	INNER JOIN eims_ua_technology_files ON \r\n" + 
				"	eims_ua_technology.tid = eims_ua_technology_files.tid\r\n" + 
				"WHERE \r\n" + 
				"	eims_ua_company.name  = ?";
		Query query = em.createNativeQuery(sqlString);
		query.setParameter(1, name);
		Object rs = query.getResultList();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(rs);
	}
	
}