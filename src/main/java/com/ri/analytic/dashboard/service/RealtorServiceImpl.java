package com.ri.analytic.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ri.analytic.dashboard.entity.Realtor;
import com.ri.analytic.dashboard.repository.RealtorRepository;

@Service 
public class RealtorServiceImpl implements RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	@Override
	public List<Realtor> getAllRealtor() {
		return realtorRepository.findAll();
	} 
}
