package org.pratap.ws.web.api;

import java.util.Collection;

import javax.print.attribute.standard.Media;

import org.apache.catalina.connector.Request;
import org.pratap.ws.model.OsDetails;
import org.pratap.ws.service.IOsDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OsDetailsController {
	
	@Autowired
	private IOsDetailsManager osDetailsManager;

	@RequestMapping(value="Osd/api/all-os-details", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<OsDetails>> getAllOsDetails() {
		Collection<OsDetails> allOsDetails = osDetailsManager.getAllOsDetails();
		return new ResponseEntity<Collection<OsDetails>>(allOsDetails, HttpStatus.OK);
	}

	@RequestMapping(value="Osd/api/all-os-details/{regNo}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OsDetails> getOsDetails(@PathVariable("regNo") String regNo) {
		OsDetails osDetails = osDetailsManager.getOsDetails(regNo);
		if(null == osDetails){
			return new ResponseEntity<OsDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OsDetails>(osDetails, HttpStatus.OK);
	}

	
	@RequestMapping(value="Osd/api/save-os-details", method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OsDetails> saveOsDetails(@RequestBody OsDetails osDetails) {
		OsDetails savedOsDetails = osDetailsManager.saveOsDetails(osDetails);
		if(null == savedOsDetails){
			return new ResponseEntity<OsDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<OsDetails>(savedOsDetails, HttpStatus.OK);
	}

	@RequestMapping(value="/Osd/api/delete-os-details/{regNo}", method= RequestMethod.DELETE)
	public ResponseEntity<OsDetails> deleteOsDetails(@PathVariable("regNo") String regNo) {
		boolean isOsDetailsDeleted = osDetailsManager.deleteOsDetails(regNo); 
		if(!isOsDetailsDeleted){
			return new ResponseEntity<OsDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<OsDetails>(HttpStatus.NO_CONTENT);
	}
	
}
