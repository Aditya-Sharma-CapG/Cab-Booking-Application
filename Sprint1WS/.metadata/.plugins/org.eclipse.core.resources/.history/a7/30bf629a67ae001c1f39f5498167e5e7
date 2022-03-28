package com.capgemini.cab.management.application.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Cab;
import com.capgemini.cab.management.application.repository.CabRepository;
import com.capgemini.cab.management.application.service.CabService;

@Service
public class CabServiceImpl implements CabService {


	private CabRepository cabRepository;

	public CabServiceImpl(CabRepository cabRepository) {
		super();
		this.cabRepository = cabRepository;
	}


	@Override
	public List<Cab> getAllCabs() {
		
		return cabRepository.findAll();
	}

}
