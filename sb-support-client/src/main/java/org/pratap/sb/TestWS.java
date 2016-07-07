package org.pratap.sb;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class TestWS implements Runnable
{
	private final String server = "http://localhost:8090";
    public static void main( String[] args )
    {
        new Thread(new TestWS()).start();
    }

	public synchronized void run() {
		testGetGreetings();
		testGetGreeting(2);
	}

	private void testGetGreeting(int id) {
		System.out.println("---------------------[ testGetGreeting(id) ]------------------");
		final String uri = server + "/api/greetings/"+id;
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);
		
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		
		ResponseEntity<String> response = null;
		
		response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
		
		System.out.println(response);
		
	}

	private void testGetGreetings() {
		System.out.println("---------------------[ testGetGreetings() ]------------------");
		final String uri = server + "/api/greetings/";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);
		
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		
		ResponseEntity<String> response = null;
		
		response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
		
		System.out.println(response);
	}
}
