package org.pratap.ws.service;

import java.util.Collection;

import org.pratap.ws.model.OsDetails;

public interface IOsDetailsManager {
	public Collection<OsDetails> getAllOsDetails();
	public OsDetails getOsDetails(String regNo);
	public OsDetails saveOsDetails(OsDetails osDetails);
	public boolean deleteOsDetails(String regNo);
}
