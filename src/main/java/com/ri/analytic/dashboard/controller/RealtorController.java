package com.ri.analytic.dashboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ri.analytic.dashboard.entity.Realtor;
import com.ri.analytic.dashboard.service.RealtorService;
@RestController
public class RealtorController {

	
	private static final Logger logger = LoggerFactory.getLogger(RealtorController.class);

	@Autowired
	private RealtorService realtorService;
	
	@RequestMapping(value="/realtors", method=RequestMethod.GET)
	public ResponseEntity<List<Realtor>> getAllRealtor(){
    	logger.info("Returning all the Realtor´s");
		return new ResponseEntity<List<Realtor>>(realtorService.getAllRealtor(), HttpStatus.OK);
	}
	
}
