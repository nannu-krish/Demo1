package com.example.Demo_consumer;

import java.net.URI;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.client.WireMock;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE, properties="server.context-path=/app")
@AutoConfigureStubRunner(ids = {"com.example:Demo_Contract:+:stubs:1234"},workOffline = true)
@DirtiesContext
public class DemoConsumerApplicationTests {
/*
	@Test
	public void contextLoads() {
		String json="[\"harshita\",\"paliwal\"]";
		
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/example"))
		.willReturn(WireMock.aResponse().withBody(json).withStatus(200)));
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8082/example", String.class);
		
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody()).isEqualTo(json);
	}*/
	@Test
	public void Tests() {
		String json="[\"harshita\",\"paliwal\"]";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8082/example", String.class);
		
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody()).isEqualTo(json);
	}
	
	//@Autowired 
	//RestTemplate restTemplate;

	// (4) - stub runner for discovery client
	/*@Test
	public void should_retrieve_list_of_frauds_from_stub_via_discovery() {
		
		//ResponseEntity<String> entity = this.restTemplate.exchange(RequestEntity
			//	.get(URI.create("http://localhost:8082/example")).build(), String.class);

		//BDDAssertions.then(entity.getStatusCode().value()).isEqualTo(200);
		//BDDAssertions.then(entity.getBody()).isEqualTo("[\"harshita\",\"paliwal\"]");
	}*/
}
