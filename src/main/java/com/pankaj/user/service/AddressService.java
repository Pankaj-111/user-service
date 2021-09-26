package com.pankaj.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.user.AddressClient;
import com.pankaj.user.beans.Address;
import com.pankaj.user.beans.UserDetail;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressService {

	@Autowired
	private AddressClient addressClient;

	@CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
	public UserDetail getUserById(Integer id) {
		final UserDetail user = new UserDetail();
		user.setAddress(addressClient.getAddress(id));
		return user;
	}
	
	public UserDetail fallbackGetAddressById(Integer addressId, Throwable th) {
		log.error("Error = " + th);
		UserDetail userDetail = new UserDetail();
		Address address = new Address();
		userDetail.setAddress(address);
		return userDetail;
	}
}
