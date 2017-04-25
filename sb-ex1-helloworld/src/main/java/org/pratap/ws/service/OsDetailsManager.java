package org.pratap.ws.service;

import java.util.Collection;

import org.pratap.ws.model.OsDetails;
import org.pratap.ws.repository.OsDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsDetailsManager implements IOsDetailsManager{

	@Autowired
	private OsDetailsRepo osDetailsRepo;

	@Override
	public Collection<OsDetails> getAllOsDetails() {
		Collection<OsDetails> allOsDetails = osDetailsRepo.findAll();
		return allOsDetails;
	}

	@Override
	public OsDetails getOsDetails(String regNo) {
		OsDetails osDetails = osDetailsRepo.findOne(regNo);
		if(null == osDetails){
			return null;
		}
		return osDetails;
	}

	@Override
	public OsDetails saveOsDetails(OsDetails osDetails) {
		OsDetails savedOsDetails = osDetailsRepo.save(osDetails);
		if(null == savedOsDetails){
			return null;
		}
		return savedOsDetails;
	}

	@Override
	public boolean deleteOsDetails(String regNo) {
		osDetailsRepo.delete(regNo);
		return true;
	}

	
	

}
