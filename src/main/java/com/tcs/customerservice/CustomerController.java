package com.tcs.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return repository.save(customer);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

}