package com.capgemini.cab.management.application.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.capgemini.cab.management.application.domain.Cab;
import com.capgemini.cab.management.application.exception.CabNotFoundException;
import com.capgemini.cab.management.application.repository.CabRepository;
import com.capgemini.cab.management.application.service.CabService;

@Service
public class CabServiceImpl implements CabService {


	private CabRepository cabRepository;
	
	@SuppressWarnings("unused")
	private Cab cab;

	public CabServiceImpl(CabRepository cabRepository) {
		super();
		this.cabRepository = cabRepository;
	}

	@Override
	public Cab saveCab(Cab cab) {
		
		return cabRepository.save(cab);
	}

	@Override
	public List<Cab> getAllCabs() {
		
		return cabRepository.findAll();
	}

	@Override
	public Cab getCabById(long id) {
		
		return cabRepository.findById(id).orElseThrow(() -> new CabNotFoundException("Cab not exists with id " + id));
	}
	
	@Override
	public Cab getCabByType(String cabType) {
		
		Cab cab = cabRepository.getCabByType(cabType);
		
		if (cab == null) {
			throw new CabNotFoundException("Cab not exists with type " + cabType);
		}
		
		return cabRepository.getCabByType(cabType);
	}
	
	@Override
	public int countCabsOfType(String cabType) {
		
		return cabRepository.getCountByCabType(cabType);
	}

	@Override
	public Cab updateCab(Cab cab, long id) {
		
		Cab existingCab = cabRepository.findById(id).orElseThrow(
				() -> new CabNotFoundException("Cab not exists with id " + id));
		
		existingCab.setCarType(cab.getCarType());
		existingCab.setPerKmRate(cab.getPerKmRate());
		
		cabRepository.save(existingCab);
		
		return existingCab;
	}

	@Override
	public void deleteCab(long id) {
		
		cabRepository.findById(id).orElseThrow(() -> new CabNotFoundException("Cab not exists with id " + id));
		
		cabRepository.deleteById(id);
		
	}

}
