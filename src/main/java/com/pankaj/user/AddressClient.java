package com.pankaj.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pankaj.user.beans.Address;

@FeignClient(value = "api-gateway")
public interface AddressClient {
	@GetMapping("/address-service/address/byuserid/{id}")
	public Address getAddress(@PathVariable Integer id);
}
