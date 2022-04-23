package com.capgemini.cma.service;

import com.capgemini.cma.domain.CabTask;

public interface CabTaskService {

	public CabTask addCabTask(String cabIdentifier, CabTask cabTask);
	
	CabTask findCabTaskByCabSequence(String backlog_id, String cabTaskSequence);
	
	public void deleteCTByCabTaskSequence(String backlog_id, String ct_id);
	
	public CabTask updateByCabTaskSeqence(CabTask updatedCabTask, String backlog_id, String ct_id);
}
