package com.capgemini.cma.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cma.domain.Backlog;
import com.capgemini.cma.domain.Cab;
import com.capgemini.cma.exception.CabIdException;
import com.capgemini.cma.repository.BacklogRepository;
import com.capgemini.cma.repository.CabRepository;
import com.capgemini.cma.service.CabService;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Override
	public Cab saveOrUpdate(Cab cab) {
	
		try {
			cab.setCabIdentifier(cab.getCabIdentifier().toUpperCase());
			
			// BL
			
			// 1. When cab is created, backlog should be created
			if (cab.getId() == null) {
				Backlog backlog = new Backlog();
				cab.setBacklog(backlog);
				backlog.setCab(cab);
				backlog.setCabIdentifier(cab.getCabIdentifier().toUpperCase());
			}
			
			// 2. when cab is updated, backlog should not be null
			if (cab.getId() != null) {
				cab.setBacklog(backlogRepository.findByCabIdentifier(cab.getCabIdentifier().toUpperCase()));
			}
			
			return cabRepository.save(cab);
			
		} catch (Exception e) {
			throw new CabIdException("Cab Id : " + cab.getCabIdentifier().toUpperCase() + " already exists");
		}

	}

//	@Override
//	public Cab saveCab(Cab cab) {
//		
//		return cabRepository.save(cab);
//	}

//	@Override
//	public List<Cab> getAllCabs() {
//		
//		return cabRepository.findAll();
//	}
	
	@Override
	public Cab findCabByCabIdentifier(String cabId) {
		Cab project = cabRepository.findByCabIdentifier(cabId.toUpperCase());
		
		if(project == null) {
			throw new CabIdException("Cab Identifier : " + cabId.toUpperCase() + " does not exist");
		}
		
		return project;
	}

//	@Override
//	public Cab getCabById(long id) {
//		
//		return cabRepository.findById(id).orElseThrow(() -> new CabNotFoundException("Cab not exists with id " + id));
//	}
	
//	@Override
//	public Cab getCabByType(String cabType) {
//		
//		Cab cab = cabRepository.getCabByType(cabType);
//		
//		if (cab == null) {
//			throw new CabNotFoundException("Cab not exists with type " + cabType);
//		}
//		
//		return cabRepository.getCabByType(cabType);
//	}
	
//	@Override
//	public int countCabsOfType(String cabType) {
//		
//		return cabRepository.getCountByCabType(cabType);
//	}

//	@Override
//	public Cab updateCab(Cab cab, long id) {
//		
//		Cab existingCab = cabRepository.findById(id).orElseThrow(
//				() -> new CabNotFoundException("Cab not exists with id " + id));
//		
//		existingCab.setCarType(cab.getCarType());
//		existingCab.setPerKmRate(cab.getPerKmRate());
//		
//		cabRepository.save(existingCab);
//		
//		return existingCab;
//	}

//	@Override
//	public void deleteCab(long id) {
//		
//		cabRepository.findById(id).orElseThrow(() -> new CabNotFoundException("Cab not exists with id " + id));
//		
//		cabRepository.deleteById(id);
//		
//	}
	
	@Override
	public Iterable<Cab> findAllCab() {
		return cabRepository.findAll();
	}

	@Override
	public void deleteCabByCabIdentifier(String cabId) {
		Cab cab = cabRepository.findByCabIdentifier(cabId.toUpperCase());
		if(cab == null) {
			throw new CabIdException("Cab Identifier : " + cabId.toUpperCase() + " does not exist");
		}
		
		cabRepository.delete(cab);
		
	}

}
