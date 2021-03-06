package org.pratap.sb;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.pratap.sb.model.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
		createGreeting();
		updateGreeting();
	}

	
	
	private void updateGreeting(){
		System.out.println("---------------------[ updateGreeting() ]------------------");
		final String uri = server + "/api/greetings/2";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json"));
		
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);
		
		Greeting greeting = new Greeting();
		BigInteger id = BigInteger.ONE;
		//id = id.add(BigInteger.ONE);
		id = id.add(BigInteger.ONE);
		greeting.setId(id);
		greeting.setText("PAWAN");
		HttpEntity<?> entity = new HttpEntity<Object>(greeting);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = null;
		response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.PUT, entity, String.class);
	}

	private void createGreeting() {
		System.out.println("---------------------[ createGreeting() ]------------------");
		final String uri = server + "/api/greetings/";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json"));

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);

		Greeting greeting = new Greeting();
		greeting.setText("SIVA");
		HttpEntity<?> entity = new HttpEntity<Object>(greeting);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = null;
		response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.POST, entity, String.class);
		System.out.println(response);
	}
	/*private void createGreeting() {
		System.out.println("---------------------[ createGreeting() ]------------------");
		final String uri = server + "/api/greetings/";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json"));

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri).queryParam("id", 4);

		Greeting greeting = new Greeting();
		greeting.setText("AURVINDO");
		HttpEntity<?> entity = new HttpEntity<Object>(greeting);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Greeting> response = null;
		response = restTemplate.exchange(uriComponentsBuilder.build().encode().toUri(), HttpMethod.POST, entity, Greeting.class);
		System.out.println(response);

	}*/

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
