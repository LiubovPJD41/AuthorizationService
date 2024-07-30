package ru.Polyaeva.AuthorizationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	private static final GenericContainer<?> devAppTest = new GenericContainer<>("devapp")
			.withExposedPorts(8080);
	private static final GenericContainer<?> prodAppTest = new GenericContainer<>("prodapp")
			.withExposedPorts(8080);

	@BeforeAll
	public static void setUp() {
		devAppTest.start();
		prodAppTest.start();

	}

	@Test
	void contextLoads() {
		String expected = "[\"READ\"]";
		Integer devAppPort = devAppTest.getMappedPort(8080);
		Integer prodAppPort = prodAppTest.getMappedPort(8080);
		ResponseEntity<String> forEntityDevApp = restTemplate.getForEntity("http://localhost:" + devAppTest.getMappedPort(8080) + "/authorize?user=Ivanova&password=xxx", String.class);
		System.out.println(forEntityDevApp.getBody());
		Assertions.assertEquals(expected, forEntityDevApp.getBody());
		ResponseEntity<String> forEntityProdApp = restTemplate.getForEntity("http://localhost:" + prodAppTest.getMappedPort(8080) + "/authorize?user=Ivanova&password=xxx", String.class);
		System.out.println(forEntityProdApp.getBody());
		Assertions.assertEquals(expected, forEntityProdApp.getBody());
	}


}
