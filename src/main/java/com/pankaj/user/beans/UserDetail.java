package com.pankaj.user.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDetail {
	private Integer id = 1;
	private String name = "Vipin";
	private String email = "vipin@gmail.com";
	private Address address;
}
