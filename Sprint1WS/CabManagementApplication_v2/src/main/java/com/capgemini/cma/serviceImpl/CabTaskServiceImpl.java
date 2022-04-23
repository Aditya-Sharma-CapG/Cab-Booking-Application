package com.capgemini.cma.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.cma.domain.Backlog;
import com.capgemini.cma.domain.CabTask;
import com.capgemini.cma.exception.CabNotFoundException;
import com.capgemini.cma.repository.BacklogRepository;
import com.capgemini.cma.repository.CabTaskRepository;
import com.capgemini.cma.service.CabTaskService;

@Service
public class CabTaskServiceImpl implements CabTaskService {

	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private CabTaskRepository cabTaskRepository;
	
	@Override
	public CabTask addCabTask(String cabIdentifier, CabTask cabTask) {
		
		try {
			// - exception: Cab not found
			
			
			// - CabTasks to be added to a specific cab, cab != null, BacklogExist
			Backlog backlog = backlogRepository.findByCabIdentifier(cabIdentifier.toUpperCase());
			
			// - Set the Backlog to cabTask
			cabTask.setBacklog(backlog);
			
			// - We want our cab sequence to be like: IDPRO-1, IDPRO-2
			Integer backlogSequence = backlog.getCTsequence();
			
			// - Update the backlog sequence
			backlogSequence++;
			backlog.setCTsequence(backlogSequence);
			
			// - Add sequence to cab task
			cabTask.setCabTaskSequence(cabIdentifier + "-" + backlogSequence);
			cabTask.setCabIdenntifier(cabIdentifier);
			
			// - initial priority when priority is null
			if(cabTask.getPriority() == null) {
				cabTask.setPriority(3);
			}
			
			// - initial status when status is null
			if(cabTask.getStatus() == null || cabTask.getStatus() == "") {
				cabTask.setStatus("TO_DO");
			}
			
			return cabTaskRepository.save(cabTask);
			
		} catch (Exception ex) {
			throw new CabNotFoundException("Cab not Found");
		}
	}

	@Override
	public CabTask findCabTaskByCabSequence(String backlog_id, String cabTaskSequence) {
		// Make sure that we are searching under existing backlog_id
		Backlog backlog = backlogRepository.findByCabIdentifier(backlog_id);
		if (backlog == null) {
			throw new CabNotFoundException("Cab with id : " + backlog_id + " does not exist");
		}
		
		 CabTask cabTask = cabTaskRepository.findByCabTaskSequence(cabTaskSequence);
		 if (cabTask == null) {
			 throw new CabNotFoundException("Cab task with id : " + cabTaskSequence + " does not exist");
		}
		 
		 return cabTaskRepository.findByCabTaskSequence(cabTaskSequence);
	}

	@Override
	public void deleteCTByCabTaskSequence(String backlog_id, String ct_id) {
		
		CabTask cabTask = findCabTaskByCabSequence(backlog_id, ct_id);
		Backlog backlog = cabTask.getBacklog();
		List<CabTask> cabTasks = backlog.getCabTasks();
		
		cabTasks.remove(cabTask);
		backlogRepository.save(backlog);
		cabTaskRepository.delete(cabTask);
		
	}

	@Override
	public CabTask updateByCabTaskSeqence(CabTask updatedCabTask, String backlog_id, String ct_id) {
		// Find existing cab task
		CabTask cabTask = cabTaskRepository.findByCabTaskSequence(ct_id);
		
		// Replace it with updated task
		cabTask = updatedCabTask;
		
		// Save cab task
		return cabTaskRepository.save(cabTask);
	}
	
}
