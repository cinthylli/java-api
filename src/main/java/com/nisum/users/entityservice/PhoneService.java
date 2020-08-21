package com.nisum.users.entityservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneService {

	private Long id;
	
	private Long userIdFk;
	
	private String number;
	
	private String cityCode;

	private String countryCode;
}
