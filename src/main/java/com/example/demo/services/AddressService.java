package com.example.demo.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.KafkaSender;
import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
@Path("/address")
// @RibbonClient(name="customer-service",configuration={RestClientConfig.class})
public class AddressService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private KafkaSender kafkaSender;

	// @Value("${message}")
	private String message;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Path("/{id}")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@HystrixCommand(fallbackMethod = "backupAddress", threadPoolKey = "customerThreadPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "10") })
	public Address getAddress(@PathParam("id") int id) {
		Address address = new Address();
		address.setId(1);
		System.out.println("customer 1:: " + message);
		Customer customer = restTemplate.getForObject("http://customer-service/customer/1", Customer.class);

		System.out.println("customer 2:: " + customer);

		Object object = restTemplate.getForObject("http://db-service/db/users", Object.class);
		System.out.println("object 2:: " + object);
		address.setAddress2(message);
		return address;
	}

	public Address backupAddress(int id) {
		System.out.println("inside backupAddress...");
		Address address = new Address();
		address.setId(100);
		address.setAddress1("Backup Address");
		address.setAddress2(message);
		return address;
	}

	@Path("/name")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Address getAddressDetails() {
		System.out.println("getAddressDetailsI >");
		ServiceInstance serviceInstance = loadBalancerClient.choose("CUSTOMER-SERVICE");
		System.out.println("Service URI >" + serviceInstance.getUri());
		Customer customer = restTemplate.getForObject(serviceInstance.getUri().toString() + "/customer/1",
				Customer.class);
		System.out.println("customer 3:: " + customer);
		ResponseEntity<Customer> responseEntity = restTemplate
				.exchange(serviceInstance.getUri().toString() + "/customer/1", HttpMethod.GET, null, Customer.class);
		customer = responseEntity.getBody();
		System.out.println("customer 4:: " + customer);
		Address address = new Address();
		address.setAddress1("Noida");
		return address;
	}

	@Path("/create")
	@POST
	public void createAddress(@RequestBody Address address) {
		System.out.println("Creating address...");
		System.out.println("Address : " + address.toString());

		kafkaSender.send("test-demo", "Address updated successfully!");

	}

}
