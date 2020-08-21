package com.nisum.users.entityservice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private List<PhoneService> listPhones;
	
	private List<UserAccessService> listUserAccessServices;
}
